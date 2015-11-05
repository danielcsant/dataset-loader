import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.*;

/**
 * Created by dcarroza on 3/11/15.
 */
public class MongoDbIngestor {

    public static void main(String[] args) {
        // or, to connect to a replica set, with auto-discovery of the primary, supply a seed list of members
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(Arrays.asList(new ServerAddress("52.91.49.85", 27017),
                    new ServerAddress("52.91.90.161", 27017),
                    new ServerAddress("52.23.199.0", 27017)));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DB db = mongoClient.getDB("datasets");

        DBCollection table = db.getCollection("flights");

        CSVreader csVreader = new CSVreader("/home/fcillero/Documentos/datasets/2008.csv");

        Flight flight = csVreader.nextLine();
        List<DBObject> documents = new ArrayList();
        while (flight != null) {
            documents.add(flight);
            if (documents.size() == 10000){
                table.insert(documents);
                documents = new ArrayList();
            }
            flight = csVreader.nextLine();
        }

        table.insert(documents);

        csVreader.close();

    }


}
