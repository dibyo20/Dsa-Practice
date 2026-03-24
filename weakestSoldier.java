import java.util.PriorityQueue;

public class weakestSoldier {
    static class Row implements Comparable<Row> {
        int indx;
        int soldiers;

        Row(int indx, int soldiers) {
            this.indx = indx;
            this.soldiers = soldiers;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) {
                return this.indx - r2.indx; // Sorting by index if soldiers are equal
            } else {
                return this.soldiers - r2.soldiers; // Sorting by number of soldiers
            }
        }
    }

    public static void main(String args[]) {
        int army[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 } };

        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();
        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[i].length; j++) {
                count += army[i][j] == 1 ? 1 : 0; // Counting soldiers in each row
            }
            pq.add(new Row(i, count));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("Row " + pq.remove().indx + " has the weakest soldiers.");
        }
    }
}
