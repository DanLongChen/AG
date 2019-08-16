package L2019_8_2;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/3
 * 重拍数列
 **/
public class cpsl {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        while (input.hasNext()){
            int l=input.nextInt();
            int four=0;
            int two=0;
            for (int i=0;i<l;i++){
                int temp=input.nextInt();
                if(temp%4==0){
                    four++;
                }else if(temp%2==0){
                    two++;
                }
            }
            four=2*four+1;
            two=Math.max(two-1,0);
            if(four+two>=l){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
            n--;
            if(n==0){
                break;
            }
        }
        input.close();
    }
}
