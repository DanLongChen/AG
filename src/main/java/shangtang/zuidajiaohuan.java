package shangtang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/19
 **/
public class zuidajiaohuan {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(handler(n));
    }
    public static int handler(int num) {
        if(num<10){
            return num;
        }
        String str=num+"";
        char[] arr=str.toCharArray();
        Arrays.sort(arr);
        int index=-1;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(arr[str.length()-i-1]!=c){
                index=i;
                break;
            }
        }
        if(index==-1){
            return Integer.parseInt(str);
        }else{
            int secondMax=-1;
            for(int i=str.length()-1;i>=index;i--){
                char c=str.charAt(i);
                if(c==arr[str.length()-index-1]){
                    secondMax=i;
                    break;
                }
            }
            arr=str.toCharArray();
            char temp=arr[index];
            arr[index]=arr[secondMax];
            arr[secondMax]=temp;
            return Integer.parseInt(new String(arr));

        }
    }
}
