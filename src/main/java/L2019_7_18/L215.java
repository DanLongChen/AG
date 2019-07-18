package L2019_7_18;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by DanLongChen on 2019/7/18
 * 找出数组中第k个最大的值
 **/
public class L215 {
    public int findKthLargest(int[] nums, int k) {
        /**
         * 解法一：使用排序，然后找第k个下标就好了
         */
        /**
         * 解法二：使用小根堆，当size>k的时候就进行pop，保证堆里面只剩下k个，那么堆根就是第k个最大的
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2?1:o1==o2?0:-1;
            }
        });
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}
