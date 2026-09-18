import java.util.*;

public class smallestRangeCoveringElementsFromKLists {
    public static class Node {
        int val;
        int listIndex;
        int elementIndex;

        public Node(int val, int listIndex, int elementIndex) {
            this.val = val;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.add(new Node(val, i, 0));
            currentMax = Math.max(currentMax, val);
        }

        int bestLeft = minHeap.peek().val;
        int bestRight = currentMax;

        while (true) {
            Node minNode = minHeap.poll();
            int currentMin = minNode.val;

            if (currentMax - currentMin < bestRight - bestLeft) {
                bestLeft = currentMin;
                bestRight = currentMax;
            } else if (currentMax - currentMin == bestRight - bestLeft && currentMin < bestLeft) {
                bestLeft = currentMin;
                bestRight = currentMax;
            }

            int nextIndex = minNode.elementIndex + 1;
            if (nextIndex >= nums.get(minNode.listIndex).size()) {
                break;
            }

            int nextValue = nums.get(minNode.listIndex).get(nextIndex);
            minHeap.offer(new Node(nextValue, minNode.listIndex, nextIndex));
            currentMax = Math.max(currentMax, nextValue);
        }
        return new int[] { bestLeft, bestRight };
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));
        System.out.println(Arrays.toString(smallestRange(nums)));
    }
}
