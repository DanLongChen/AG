package L2019_7_21;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Paser on 2019/7/21.
 */
public class L621 {
    public int leastInterval(char[] tasks, int n) {
        //首先寻找任务数最多的任务，然后计算该任务所需的时间，然后再加上任务数==最大任务数的任         //务组数
        if(tasks==null || tasks.length==0){
            return 0;
        }
        if(tasks.length==1){
            return 1;
        }
        Map<Character,Integer> map=new HashMap<>();
        char maxC='0';
        int maxNum=0;
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
            if(map.get(tasks[i])>maxNum){
                maxC=tasks[i];
                maxNum=map.get(tasks[i]);
            }
        }
        int item=0;
        for(Integer i:map.values()){
            if(i==maxNum){
                item++;
            }
        }
        int result=(maxNum-1)*(n+1)+item;
        return result>tasks.length?result:tasks.length;//看看是不是比最初tasks的长度要长
    }
}
