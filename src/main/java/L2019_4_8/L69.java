package L2019_4_8;

/**模拟平方根，其中x为非负，要求返回的是整形
 * Created by DanLongChen on 2019/4/8
 **/
public class L69 {
    public int mySqrt(int x) {
        int left=0,right=x;
        while (left<right){
            int mid=(left+right)/2;
            System.out.println(mid);
            if (mid*mid==x){
                return mid;
            }else{
                if(mid*mid>x){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new L69().mySqrt(8));
    }
}
