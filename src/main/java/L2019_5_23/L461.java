package L2019_5_23;

/**
 * Created by DanLongChen on 2019/5/23
 **/

/**
 * 计算两个整数之间的汉明距离
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 */
public class L461 {
    public static void main(String[] args) {
        System.out.println(new L461().hammingDistance(1,4));
    }
    public int hammingDistance(int x, int y) {
        String sX=Integer.toBinaryString(x);
        String sY=Integer.toBinaryString(y);
        while (sX.length()!=sY.length()){
            if (sX.length()<sY.length()){
                sX="0"+sX;
            }else{
                sY="0"+sY;
            }
        }
        int index=0;
        int result=0;
        while (index<sX.length()){
            if(sX.charAt(index)==sY.charAt(index)){
                index++;
                continue;
            }
            index++;
            result++;
        }
        System.out.println(sX+"  "+sY);
        return result;
    }
}
