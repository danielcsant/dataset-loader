import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dcarroza on 4/11/15.
 */
public class CSVreaderTest {

    @Test
    public void testRead(){
        CSVreader csVreader = new CSVreader("/home/fcillero/Documentos/datasets/2008.csv");

        Flight flight = csVreader.nextLine();

        Assert.assertNotNull(flight.getActualElapsedTime());
    }

}