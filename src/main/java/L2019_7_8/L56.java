package L2019_7_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by DanLongChen on 2019/7/8
 * 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L56 {
    private class interval{
        public int start;
        public int end;
        public interval(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public int[][] merge(int[][] intervals) {
        /**
         * 首先进行排序，排序好之后再比较前后的两个区间，如果可以合并则进行合并，如果不能进行合并则加入结果集合
         */
        if(intervals==null || intervals.length==0){
            return new int[0][0];
        }
        List<interval> nums=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            interval temp=new interval(intervals[i][0],intervals[i][1]);
            nums.add(temp);
        }
        Collections.sort(nums,new Comparator<interval>(){
            @Override
            public int compare(interval o1,interval o2){
                return o1.start-o2.start;
            }
        });
        List<interval> result=new ArrayList<>();
        for(int i=0;i<nums.size();i++){
            if(i<nums.size()-1){
                if(nums.get(i).start<=nums.get(i+1).start && nums.get(i).end>=nums.get(i+1).start){
                    /**
                     * 如果可以合并则一直进行合并，不能合并的时候将结果加入结果集合
                     */
                    interval temp=new interval(Math.min(nums.get(i).start,nums.get(i+1).start),Math.max(nums.get(i).end,nums.get(i+1).end));
                    nums.set(i,temp);
                    nums.remove(i+1);
                    i--;
                }else{
                    result.add(nums.get(i));
                }
            }else{
                result.add(nums.get(i));
            }
        }
        int[][] finalResult=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            finalResult[i]=new int[]{result.get(i).start,result.get(i).end};
        }
        return finalResult;
    }
}
