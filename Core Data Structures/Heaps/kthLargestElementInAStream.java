import java.util.*;

public class kthLargestElementInAStream {
    public static class kthLargest {
        public PriorityQueue<Integer> pq = new PriorityQueue<>();
        public int kth;

        public kthLargest(int k, int[] nums) {
            kth = k;
            for (int i = 0; i < nums.length; i++) {
                if (pq.size() == k) {
                    if (pq.peek() < nums[i]) {
                        pq.poll();
                        pq.add(nums[i]);
                        continue;
                    } else {
                        continue;
                    }
                }
                pq.add(nums[i]);
            }
        }

        public int add(int val) {
            if (pq.size() == kth && pq.peek() < val) {
                pq.poll();
                pq.add(val);
            } else if (pq.size() < kth) {
                pq.add(val);
            }
            return pq.peek();
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        kthLargest kth = new kthLargest(3, nums);
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
    }

}
