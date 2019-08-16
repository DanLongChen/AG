package L2019_8_2;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/2
 * 俄罗斯方块
 **/
public class wy2019_7_1 {
    public static void main(String[] args) {
        /**
         * //这道题的思路很简单，N列，就定义一个1*N的数组，每一列落下方块时，对应数组位置+1，最后取数组的最小值就可以了
         */
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int[] nums=new int[m];
        int[] col=new int[n];
        for(int i=0;i<m;i++){
            int temp=input.nextInt();
            nums[i]=temp;
            col[temp-1]+=1;
        }
        int result=0;
        int mi=1;
        out:
        while(mi<=m){
            for(int i=0;i<n;i++){
                col[i]--;
                if(col[i]<0){
                    break out;
                }
                mi+=1;
            }
            result++;
        }
        System.out.println(result);

    }
}
