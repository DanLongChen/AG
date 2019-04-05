package L2019_4_5;

import java.util.Arrays;

/**找下一个序列
 * Created by Paser on 2019/4/5.
 */
public class L31 {
    public void nextPermutation(int[] nums) {
        if(nums.length==0 || nums.length==1){
            return;
        }
        int tail=nums.length-1;
        int point=0;//代表需要替换的index
        /**
         * 先找到一个从后往前不按照生序来的index
         */
        while (tail>0){
            if(nums[tail]<=nums[tail-1]){
                tail--;
                continue;
            }else{
                point=tail-1;
                break;

            }
        }
        System.out.println(point);
        /**
         * 从后往前找，找到那个>point数的那个index，互换，再把point之后的所有数反一下
         1　　2　　7　　4　　3　　1

         1　　2　　7　　4　　3　　1

         1　　3　　7　　4　　2　　1

         1　　3　　1　　2　　4　　7

         */
        int left=point+1;
        if(point==0 && nums[point]>nums[point+1]){
            left=point;
        }
        int right=nums.length-1;
        System.out.println(left+"   "+right);
        tail=nums.length-1;
        int point1=0;
        while (tail>=0){
            if(nums[tail]<=nums[point]){
                tail--;
            }else{
                point1=tail;
                break;
            }
        }
        System.out.println("point1="+point1);
        int temp=nums[point];
        nums[point]=nums[point1];
        nums[point1]=temp;
        System.out.println(Arrays.toString(nums));
        while(left<right){
            temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            System.out.println(Arrays.toString(nums));
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums={5,1,1};
        new L31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
