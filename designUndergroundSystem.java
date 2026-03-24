import java.util.HashMap;

public class designUndergroundSystem { 

    static class CheckIn { // Class to store check-in information
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    static class Trip { // Class to store total travel time and count of trips for a route
        int totalTime;
        int count;

        Trip(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    HashMap<Integer, CheckIn> checkInMap;
    HashMap<String, Trip> routeMap;

    public designUndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckIn checkInData = checkInMap.get(id);

        String startStation = checkInData.station;
        int startTime = checkInData.time;

        int travelTime = t - startTime;

        String route = startStation + "#" + stationName;

        Trip trip = routeMap.getOrDefault(route, new Trip(0, 0)); // Get existing trip data or create a new one if it doesn't exist

        trip.totalTime += travelTime;
        trip.count++;

        routeMap.put(route, trip); // Update the route data

        checkInMap.remove(id); // Remove the check-in data for the user after they have checked out
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "#" + endStation;

        Trip trip = routeMap.get(route);

        return (double) trip.totalTime / trip.count; // Calculate and return the average time for the route
    }

    public static void main(String[] args) {

        designUndergroundSystem undergroundSystem = new designUndergroundSystem();

        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);

        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);

        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));

        undergroundSystem.checkIn(10, "Leyton", 24);

        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));

        undergroundSystem.checkOut(10, "Waterloo", 38);

        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
    }
}