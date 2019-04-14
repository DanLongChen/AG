package L2019_4_14;

import java.util.ArrayList;
import java.util.List;

/**格雷码，是由一系列二进制组织成的二进制串（两个连续的值仅仅在一位上不同），给定一个数n表示二进制串的长度，求出所有可能的格雷码
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Created by DanLongChen on 2019/4/14
 **/
public class L89 {
    public List<Integer> grayCode(int n) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(0);
        for(int i=0;i<n;i++){
            int s = l.size();
            for(int j = s-1;j>=0;j--){
                l.add(l.get(j)+(int)Math.pow(2,i));
            }
        }
        return l;
    }
}
