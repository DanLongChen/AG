package laohu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/18
 **/
public class l1 {
    public static int handler (String s) {
        String[] arr = s.split("[^0-9]");//直接提取数字（按照非数字进行切分，那么剩下的都是数字）
        System.out.println(Arrays.toString(arr));
        HashMap<String, Integer> map = new HashMap<>();//使用map记录下每个数字出现的次数
        int max = 1;
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(!"".equals(arr[i])) {
                if(map.containsKey(arr[i])) {
                    int times = map.get(arr[i]) + 1;
                    max = Math.max(max, times);
                    map.put(arr[i], times);
                    index = i;
                }else {
                    map.put(arr[i], 1);
                }
            }
        }
        return max * Integer.valueOf(arr[index]);//出现最多的数*出现的次数就可以
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        String s = "9fil3dj11P0jAsf11j";
//        s = "9393";
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            int result = handler(s);
            System.out.println(result);
        }
        sc.close();
    }
}
