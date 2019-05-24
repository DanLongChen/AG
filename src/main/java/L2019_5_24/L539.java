package L2019_5_24;

/**
 * Created by DanLongChen on 2019/5/24
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给出“小时：分钟”格式的24小时时钟点列表，找到列表中任意两个时间点之间的最小分钟差异(列表中可能有多个时间)。
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 */

public class L539 {
    public static void main(String[] args) {
        List<String> timePoints=new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        System.out.println(new L539().findMinDifference1(timePoints));
    }
    public int findMinDifference(List<String> timePoints) {
        int result=0;
        int min=Integer.MAX_VALUE;
        /**
         * 两个循环会超时
         */
        for (int i=0;i<timePoints.size();i++){
            for (int j=i+1;j<timePoints.size();j++){
                int h1=Integer.valueOf(timePoints.get(i).split(":")[0]);
                int m1=Integer.valueOf(timePoints.get(i).split(":")[1]);
                int h2=Integer.valueOf(timePoints.get(j).split(":")[0]);
                int m2=Integer.valueOf(timePoints.get(j).split(":")[1]);
                /**
                 * 初步思路是两个互相减，然后取一个最小值
                 */
                int del1=handler(h1,m1,h2,m2);//第一个减第二个
                int del2=handler(h2,m2,h1,m1);//第二个减第一个
                if (del1<del2){
                    result=del1;
                }else{
                    result=del2;
                }
                if (result<min){
                    min=result;
                }
            }
        }

        return min;
    }
    public int findMinDifference1(List<String> timePoints) {
        /**
         * 首先进行排序，然后后一个时间-前一个时间
         */
        int result=Integer.MAX_VALUE;
        Collections.sort(timePoints);
        for (int i=0;i<timePoints.size();i++){
            int h1=Integer.valueOf(timePoints.get(i).split(":")[0]);
            int m1=Integer.valueOf(timePoints.get(i).split(":")[1]);
            int h2=Integer.valueOf(timePoints.get((i+1)%timePoints.size()).split(":")[0]);
            int m2=Integer.valueOf(timePoints.get((i+1)%timePoints.size()).split(":")[1]);

            int del=(h2-h1)*60+m2-m1;
            if(i==timePoints.size()-1){
                del+=24*60;
            }
            if (result>del){
                result=del;
            }
        }
        return result;
    }
    public int handler(int h1,int m1,int h2,int m2){//执行两个时间相减（第一个减第二个）
        int del=0;
        if (h1>h2){
            if (m1>=m2){
                del=(h1-h2)*60+(m1-m2);
            }else{
                del=(h1-h2-1)*60+(m1+60-m2);
            }
        }else{
            if (h1<h2 || (h1==h2 && m1<m2)){
                h1+=24;
                if (m1>=m2){
                    del=(h1-h2)*60+(m1-m2);
                }else{
                    del=(h1-h2-1)*60+(m1+60-m2);
                }
            }else{
                del=m1-m2;
            }
        }
        return del;
    }
}
