package kuaishou;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.message.source.PayloadSourceMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/25
 **/
public class kuaileshu {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        for(int i=0;i<num;i++){
            int n=input.nextInt();
            handler(n);
        }


    }
    public static void handler(int n){
        List<Integer> list = new ArrayList<>();
        while (true) {
            int result = 0;
            while (n > 0) {
                int tem = n % 10;
                result += tem * tem;
                n /= 10;
            }
            if (result == 1) {
                System.out.println(true);
                break;
            } else if (list.contains(result)) {
                System.out.println(false);
                break;
            } else {
                list.add(result);
                n = result;
            }
        }
    }
}
