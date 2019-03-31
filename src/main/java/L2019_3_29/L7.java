package L2019_3_29;

/**int值反转
 * Created by DanLongChen on 2019/3/29
 **/
public class L7 {
    public int reverse(int x) {
        /**
         * 定义两个数，一个*10，一个/10
         */
        int result=0;
        while (x!=0){
            int xTemp=x%10;
            x/=10;
            /**
             * 这是两种会溢出的情况
             */
            if (result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 &&xTemp>Integer.MAX_VALUE%10 )){
                return 0;
            }
            if(result<Integer.MIN_VALUE/10 || (result==Integer.MIN_VALUE/10 && xTemp<Integer.MIN_VALUE%10)){
                return 0;
            }
            result=result*10+xTemp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new L7().reverse(123));
    }
}
