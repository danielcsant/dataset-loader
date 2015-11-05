import com.mongodb.BasicDBObject;

/**
 * Created by dcarroza on 4/11/15.
 */
public class Flight extends BasicDBObject {

    private String year;
    private String month;
    private String day;
    private String departureTime;
    private String crsDepatureTime;
    private String arrivalTime;
    private String cRSArrivalTime;
    private String uniqueCarrier;
    private String flightNum;
    private String actualElapsedTime;
    private String cRSElapsedTime;
    private String arrDelay;
    private String depDelay;
    private String origin;
    private String dest;
    private String distance;
    private String cancellationCode;

//    ,,,DayOfWeek,,,,,,,TailNum,ActualElapsedTime,CRSElapsedTime,AirTime,ArrDelay,DepDelay,Origin,Dest,Distance,TaxiIn,TaxiOut,Cancelled,CancellationCode,Diverted,CarrierDelay,WeatherDelay,NASDelay,SecurityDelay,LateAircraftDelay

    public String getCancellationCode() {
        return getString("CancellationCode");
    }

    public void setCancellationCode(String cancellationCode) {
        this.cancellationCode = cancellationCode;
        put("CancellationCode", cancellationCode);
    }

    public String getYear() {
        return getString("Year");
    }

    public void setYear(String year) {
        this.year = year;
        put("Year", year);
    }

    public String getMonth() {
        return getString("Month");
    }

    public void setMonth(String month) {
        this.month = month;
        put("Month", month);
    }

    public String getDay() {
        return getString("DayofMonth");
    }

    public void setDay(String day) {
        this.day = day;
        put("DayofMonth", day);
    }

    public String getDepartureTime() {
        return getString("DepTime");
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
        put("DepTime", departureTime);
    }

    public String getCrsDepatureTime() {
        return getString("CRSDepTime");
    }

    public void setCrsDepatureTime(String crsDepatureTime) {
        this.crsDepatureTime = crsDepatureTime;
        put("CRSDepTime", crsDepatureTime);
    }

    public String getArrivalTime() {
        return getString("ArrTime");
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
        put("ArrTime", arrivalTime);
    }

    public String getcRSArrivalTime() {
        return getString("CRSArrTime");
    }

    public void setcRSArrivalTime(String cRSArrivalTime) {
        this.cRSArrivalTime = cRSArrivalTime;
        put("CRSArrTime", cRSArrivalTime);
    }

    public String getUniqueCarrier() {
        return getString("UniqueCarrier");
    }

    public void setUniqueCarrier(String uniqueCarrier) {
        this.uniqueCarrier = uniqueCarrier;
        put("UniqueCarrier", uniqueCarrier);
    }

    public String getFlightNum() {
        return getString("FlightNum");
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
        put("FlightNum", flightNum);
    }

    public String getActualElapsedTime() {
        return getString("ActualElapsedTime");
    }

    public void setActualElapsedTime(String actualElapsedTime) {
        this.actualElapsedTime = actualElapsedTime;
        put("ActualElapsedTime", actualElapsedTime);
    }

    public String getcRSElapsedTime() {
        return getString("CRSElapsedTime");
    }

    public void setcRSElapsedTime(String cRSElapsedTime) {
        this.cRSElapsedTime = cRSElapsedTime;
        put("CRSElapsedTime", cRSElapsedTime);
    }

    public String getArrDelay() {
        return getString("ArrDelay");
    }

    public void setArrDelay(String arrDelay) {
        this.arrDelay = arrDelay;
        put("ArrDelay", arrDelay);
    }

    public String getDepDelay() {
        return getString("DepDelay");
    }

    public void setDepDelay(String depDelay) {
        this.depDelay = depDelay;
        put("DepDelay", depDelay);
    }

    public String getOrigin() {
        return getString("Origin");
    }

    public void setOrigin(String origin) {
        this.origin = origin;
        put("Origin", origin);
    }

    public String getDest() {
        return getString("Dest");
    }

    public void setDest(String dest) {
        this.dest = dest;
        put("Dest", dest);
    }

    public String getDistance() {
        return getString("Distance");
    }

    public void setDistance(String distance) {
        this.distance = distance;
        put("Distance", distance);
    }
}
