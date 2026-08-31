import java.util.*;

public class dotaTwoSenate {
    public static String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new ArrayDeque<>();
        Queue<Integer> dire = new ArrayDeque<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            char ch = senate.charAt(i);
            if (ch == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();

            if (r < d) {
                radiant.add(r + n);
            } else {
                dire.add(d + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        String senate = "RD";
        System.out.println(predictPartyVictory(senate));
    }
}
