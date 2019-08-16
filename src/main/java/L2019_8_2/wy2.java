package L2019_8_2;

import java.util.*;

/**
 * Created by DanLongChen on 2019/8/3
 **/
public class wy2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int t=input.nextInt();
        while (input.hasNext()){
            int n=input.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=input.nextInt();
            }
            boolean flag=false;
            System.out.println(Arrays.toString(arr));
            List<List<Integer>> qpl=permuteUnique(arr);
            System.out.println(qpl);
            for(int i=0;i<qpl.size();i++){
                List<Integer> list = qpl.get(i);
                flag=check(list);
                System.out.println(flag);
                if(flag){
                    break;
                }
            }
            System.out.println(flag?"YES":"NO");

        }
    }
    private static boolean check(List<Integer> list){
        for(int i=1;i<list.size()-1;i++){//先比较中间的
            if(list.get(i-1)+list.get(i+1)<list.get(i)){
                System.out.println("lala");
                return false;
            }
        }
        //比较头尾
        boolean head=list.get(0)<list.get(1)+list.get(list.size()-1);
        boolean tail=list.get(list.size()-1)<list.get(0)+list.get(list.size()-2);
        if(head==true && tail==true){
            return true;
        }else{
            return false;
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        handler(result, new ArrayList<Integer>(), arr);
        return result;

    }

    public static void handler(List<List<Integer>> result, List<Integer> temp, List<Integer> arr) {
        if (arr.isEmpty()) {
            result.add(temp);
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> list = new ArrayList<>(temp);
            list.add(arr.get(i));
            if (i +1 < arr.size() && arr.get(i) == arr.get(i + 1)) {

                continue;
            }
            List<Integer> newArr = new ArrayList<>(arr);
            newArr.remove(i);
            handler(result, list, newArr);

        }
    }
}
