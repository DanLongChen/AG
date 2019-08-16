package L2019_8_2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/2
 **/
public class wy2019_7_6 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();//塔的数量
        int k=input.nextInt();//最多操作次数
        int[] nums=new int[n];
        class ta{
            int index;
            int height;
            public ta(int index,int height){
                this.index=index;//从1开始
                this.height=height;
            }
        }
        PriorityQueue<ta> max=new PriorityQueue<>(new Comparator<ta>() {
            @Override
            public int compare(ta o1, ta o2) {
                return o1.height>o2.height?-1:o1.height==o2.height?0:1;
            }
        });
        PriorityQueue<ta> min=new PriorityQueue<>(new Comparator<ta>() {
            @Override
            public int compare(ta o1, ta o2) {
                return o1.height>o2.height?1:o1.height==o2.height?0:-1;
            }
        });
        for(int i=1;i<=n;i++){
            ta temp=new ta(i,input.nextInt());
            max.add(temp);
            min.add(temp);
        }
        int cnum=0;
        int[][] result=new int[k][2];
        for(int i=0;i<k;i++){
            ta tamin=min.poll();
            ta tamax=max.poll();
            if(tamax.height-tamin.height==1){
                break;
            }
            cnum++;
            result[i][0]=tamax.index;
            result[i][1]=tamin.index;
            tamax.height-=1;
            tamin.height+=1;
            max.add(tamax);
            min.add(tamin);
        }
        System.out.println(max.peek().height-min.peek().height+" "+cnum);
        for(int i=0;i<cnum;i++){
            System.out.println(result[i][0]+" "+result[i][1]);
        }

    }
}
