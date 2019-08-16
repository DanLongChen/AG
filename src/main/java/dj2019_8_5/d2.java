package dj2019_8_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/6
 **/
public class d2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while (input.hasNext()){
            int a=input.nextInt();
            int b=input.nextInt();
            Map<String,String> map = new HashMap<>();
            for(int i=0;i<a;i++){
                map.put(input.next(),input.next());
            }
            for(int i=0;i<b;i++){
                String s=input.next();
                System.out.println(map.get(s));
            }
        }
    }
}
