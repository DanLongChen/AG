package youzan;

import java.util.*;

/**
 * Created by DanLongChen on 2019/8/20
 **/
public class L1 {
    class Node{
        int val;
        Node next;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String s=input.next();
        String[] arr=s.split("\\|");
        String[] arr1=arr[0].split(",");
        String[] arr2=arr[1].split(",");
        System.out.println(arr1.length);
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(Integer.parseInt(arr1[i]));
        }
        for(int i=0;i<arr2.length;i++){
            set.add(Integer.parseInt(arr2[i]));
        }
        Iterator iterator=set.iterator();
        int[] result=new int[set.size()];
        int index=0;
        System.out.print("[");
        while(iterator.hasNext()){
            result[index++]=(Integer) iterator.next();
        }
        for(int i=0;i<result.length;i++){
            if(i==result.length-1){
                System.out.print(result[i]);

            }else{
                System.out.print(result[i]+",");
            }
        }
        System.out.print("]");
    }
}
