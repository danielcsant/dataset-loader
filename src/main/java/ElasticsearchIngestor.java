import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

import java.util.*;

/**
 * Created by dcarroza on 5/11/15.
 */
public class ElasticsearchIngestor {

    private static final Logger LOG = LoggerFactory.getLogger(ElasticsearchIngestor.class);
    public static final int transportTcpPort = 9300;

    private static ElasticsearchTemplate elasticsearchTemplate;
    private static Client client;

    public static void main(String[] args) {
        CSVreader csVreader = new CSVreader("/home/fcillero/Documentos/datasets/2008.csv");

        Flight flight = csVreader.nextLine();
        List<IndexQuery> documents = new ArrayList();
        while (flight != null) {
            IndexQuery indexQuery = new IndexQueryBuilder().withIndexName("flights")
                    .withType("myType").withObject(flight).build();
            documents.add(indexQuery);
            if (documents.size() == 10000){
                getElasticsearchTemplate().bulkIndex(documents);
                documents = new ArrayList();
            }
            flight = csVreader.nextLine();
        }

        getElasticsearchTemplate().bulkIndex(documents);

        csVreader.close();

        client.close();

    }

    public static synchronized ElasticsearchTemplate getElasticsearchTemplate() {
        if (elasticsearchTemplate == null) {

            LOG.info("Starting Elasticsearch node");
            StringBuffer hosts = new StringBuffer();

            List<String> nodes = new ArrayList();
            nodes.add("ip-172-31-11-146.ec2.internal");
            nodes.add("ip-172-31-11-155.ec2.internal");
            nodes.add("ip-172-31-8-78.ec2.internal");

            Iterator esNodeIterator = nodes.iterator();

            while (esNodeIterator.hasNext()) {
                hosts.append(esNodeIterator.next()).append("[").append(transportTcpPort).append("]");
                if (esNodeIterator.hasNext()) {
                    hosts.append(",");
                }
            }

            LOG.debug("Connecting in unicast with: " + hosts.toString());

            ImmutableSettings.Builder settings = ImmutableSettings.settingsBuilder();
            settings.put("cluster.name", "Stratio ElasticSearch")
                    .put("http.enabled", "false")
                    .put("transport.tcp.port", transportTcpPort)
                    .put("discovery.zen.ping.multicast.enabled", "true")
                    .put("discovery.zen.ping.unicast.hosts", hosts.toString());

            client = new TransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(nodes.get(0), transportTcpPort))
                    .addTransportAddress(new InetSocketTransportAddress(nodes.get(1), transportTcpPort))
                    .addTransportAddress(new InetSocketTransportAddress(nodes.get(2), transportTcpPort));

            elasticsearchTemplate = new ElasticsearchTemplate(client);
            LOG.info("Elasticsearch node started");
        }
        return elasticsearchTemplate;
    }

}
