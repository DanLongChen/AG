package L2019_4_8;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个n表示需要变换的序列，k表示返回第几个序列
 * Input: n = 3, k = 3
 * Output: "213"
 * 解释：https://www.cnblogs.com/grandyang/p/4358678.html
 * Created by DanLongChen on 2019/4/8
 **/
public class L60 {
    public String getPermutation(int n, int k) {
        String result = "";
        List<Integer> list = new ArrayList<>();
        int zuhe = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            zuhe *= i;//计算组合数
        }
        k--;//作为下标
        for (int i = n; i >= 1; i--) {
            zuhe=zuhe/i;//计算当前的组合数
            int index=k/zuhe;//计算第几位在list中的下标
            k=k%zuhe;
            result+=list.get(index);
            list.remove(index);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new L60().getPermutation(4, 17));
    }
}
