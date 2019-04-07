package L2019_4_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 合并所有间隔的重合
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Created by Paser on 2019/4/7.
 */
public class L56 {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return start+"   "+end;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        List<Interval> result=new ArrayList<>();
        for (int i=0;i<intervals.size();i++){
            /**
             * 先把能合并的合并掉，不能合并之后再放入结果
             */
            if (i<intervals.size()-1){
                if (intervals.get(i).start<=intervals.get(i+1).start && intervals.get(i).end>=intervals.get(i+1).start){
                    Interval temp=new Interval(Math.min(intervals.get(i).start,intervals.get(i+1).start),Math.max(intervals.get(i).end,intervals.get(i+1).end));
//                    result.add(temp);
                    intervals.set(i,temp);
                    intervals.remove(i+1);
                    i--;
                }else{
                    result.add(intervals.get(i));
                }
            }else {
                result.add(intervals.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> list=new ArrayList<>();
        Interval temp1=new Interval(1,4);
        list.add(temp1);
        Interval temp2=new Interval(1,4);
        list.add(temp2);
//        Interval temp3=new Interval(3,5);
//        list.add(temp3);
//        Interval temp4=new Interval(15,18);
//        list.add(temp4);
        System.out.println(new L56().merge(list));
    }
}
