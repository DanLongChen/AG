package L2019_4_7;

import java.security.interfaces.RSAKey;
import java.util.Arrays;

/**给一个数组的最后一个数加上1，考虑进位问题(不存在前导0，除0以外)
 * Created by Paser on 2019/4/7.
 */
public class L66 {
    public int[] plusOne(int[] digits) {
        if (digits[0]==0){
            return new int[]{1};
        }
        int[] result=new int[digits.length+1];//考虑最高位可能会进1
        /**
         * 首先计算最后一位的数值
         */
        int temp=digits[digits.length-1]+1;
        int jinwei =temp/10;
        result[result.length-1]=temp%10;

        for (int i=digits.length-2;i>=0;i--){
            System.out.println(i);
            temp=digits[i]+jinwei;
            jinwei=temp/10;
            result[i+1]=temp%10;
        }
        if (jinwei==1){
            result[0]=1;
            return result;
        }else{
            int[] newResult=new int[result.length-1];
            for (int i=1;i< result.length;i++){
                newResult[i-1]=result[i];
            }
            return newResult;
        }
    }

    public static void main(String[] args) {
        int[] digits={1,2,3};
        System.out.println(Arrays.toString(new L66().plusOne(digits)));
    }
}
