import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dcarroza on 4/11/15.
 */
public class CSVreader {

    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";

    public CSVreader(String csvPath) {
        try {
            br = new BufferedReader(new FileReader(csvPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Flight nextLine() {

        Flight flight = null;

        try {
            if ((line = br.readLine()) != null) {

                // use comma as separator
                String [] row = line.split(cvsSplitBy);

                flight = new Flight();
                flight.setYear(row[0]);
                flight.setMonth(row[1]);
                flight.setDay(row[2]);
                flight.setDepartureTime(row[3]);
                flight.setCrsDepatureTime(row[4]);
                flight.setUniqueCarrier(row[5]);
                flight.setFlightNum(row[6]);
                flight.setActualElapsedTime(row[7]);
                flight.setcRSElapsedTime(row[8]);
                flight.setArrDelay(row[9]);
                flight.setDepDelay(row[10]);
                flight.setOrigin(row[11]);
                flight.setDest(row[12]);
                flight.setDistance(row[13]);
                flight.setCancellationCode(row[14]);

//                System.out.println("Flight [code= " + flight[4]  + " , name=" + flight[5] + "]");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return flight;
    }

    public void close() {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
