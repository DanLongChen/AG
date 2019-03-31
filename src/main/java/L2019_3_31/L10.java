package L2019_3_31;

/**
 * Created by DanLongChen on 2019/3/31
 **/
public class L10 {
    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }

    public static void main(String[] args) {
        System.out.println(new L10().isMatch("aa",".*"));
    }
}
