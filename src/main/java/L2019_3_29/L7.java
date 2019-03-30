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
            result=(result+xTemp)*10;
        }
        return result/10;
    }

    public static void main(String[] args) {
        System.out.println(new L7().reverse(123));
    }
}
