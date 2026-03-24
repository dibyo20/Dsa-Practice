import java.util.*;

public class itineraryFromTickets {
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> reverseMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            reverseMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (!reverseMap.containsKey(key)) {
                return key; // starting point
            }
        }

        return null; // No starting point found
    }

    public static void main(String args[]) {  // Tc: O(n)
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Banglore");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print(" -> " + tickets.get(key));
            start = tickets.get(key);
        }
        System.out.println();
    }
}
