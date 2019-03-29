package SuanFa;

import java.util.*;

/**
 * Created by DanLongChen on 2019/3/14
 **/
public class Test {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        List<Integer> a=new ArrayList<Integer>();
        List<Integer> b=new ArrayList<Integer>();
        for(int i=0;i<num;i++){
            a.add(input.nextInt());
        }
        for(int i=0;i<num;i++){
            b.add(input.nextInt());
        }
        int sumA=0;
        int sumB=0;
        Collections.sort(a);
        Collections.sort(b);
        a.remove(a.size()-1);
        b.remove(b.size()-1);
        int i=0;
        while(i<a.size() && i<b.size()){
            sumA+=a.get(i);
            sumB+=b.get(i);
            i++;
        }
        System.out.println(sumA-sumB);
    }
}
