package L2019_7_15;

import java.util.*;

/**
 * Created by DanLongChen on 2019/7/15
 * topK
 **/
public class L347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //可以借助于优先队列
        Map<Integer,Integer> map = new HashMap<>();//首先统计每个元素出现的频率
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2)>0?-1:map.get(o1)-map.get(o2)==0?0:1;
            }
        });
        for(int i:map.keySet()){
            queue.add(i);
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<k;i++){
            result.add(queue.poll());
        }
        return result;
    }
}
