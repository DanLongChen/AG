package L2019_3_30;

/**判断整数是否是回文
 * Created by Paser on 2019/3/30.
 */
public class L9 {
    public boolean isPalindrome(int x) {
        //给定两个指针向两端扩散
        String temp=String.valueOf(x);
        int size=temp.length();
        int left=0;
        int right=0;
        if(size%2==0){//判定长度是个偶数
            left=size/2-1;
            right=left+1;
        }else{
            left=size/2;
            right=left;
        }
        while (left>=0 && right<size){
            if(temp.charAt(left)==temp.charAt(right)){
                left--;
                right++;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L9().isPalindrome(141));
    }
}
