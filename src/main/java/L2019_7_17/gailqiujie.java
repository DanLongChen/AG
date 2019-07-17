package L2019_7_17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/7/17
 **/
public class gailqiujie {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt()+1;
        int[] path=new int[n*2+1];
        int result=0;
        for(int i=0;i<6000;i++){
            int p=n;
            int left=0;//表示往左走的步数
            int right=0;//表示往右走的步数
            Arrays.fill(path,0);
            for(int j=0;j<n;j++){//表示随机往左往右行走
                if(Math.random()>0.5){
                    p++;
                    if(path[p]==0){
                        left++;
                    }
                }else{
                    p--;
                    if(path[p]==0){
                        right++;
                    }
                }
                path[p]=1;
            }
//            for(int i1 = 0;i1<=2*n;i1++){
//                if(path[i1]==1){
//                    result++;
//                }
//            }
            result+=(left+right);
        }
        System.out.println(result);
        System.out.printf("%.1f",(double)((double)result/6000));
    }
}
