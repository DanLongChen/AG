package N2019_6_19;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/6/19
 * 制造回文
 **/
public class zhizaohuiwen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        int[] chars = new int[26];
        for (int i = 0; i < string.length(); i++) {
            chars[string.charAt(i) - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if ((chars[i] & 1) == 1)
                result++;
        }
        System.out.println(result == 0 ? 1 : result);
    }
}
