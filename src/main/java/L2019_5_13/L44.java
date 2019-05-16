package L2019_5_13;

/**实现正则表达式的？和*匹配
 * Created by DanLongChen on 2019/5/13
 **/
public class L44 {
    public boolean isMatch(String s, String p) {
        int i=0,j=0,iPoint=-1,jPoint=-1;//分别用于指示s，p的下标，当遇到*时候的匹配位置
        while (i<s.length()){
            if (j<p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){//如果说刚好匹配或者是？（？可以充当任意一个字符）
                ++i;
                ++j;
            }
            else if(j<p.length() && p.charAt(j)=='*'){//当前模式串的位置
                iPoint=i;
                jPoint=j++;
            }
            else if (iPoint>=0){//说明遇到了*
                i=++iPoint;//查看是用*匹配来得快还是用其他符号匹配来得快
                j=jPoint+1;//指向匹配串中*的下一个位置
            }else{
                return false;
            }
        }
        while (j<p.length() && p.charAt(j)=='*'){
            j++;
        }
        return j==p.length();
    }

    public static void main(String[] args) {
        System.out.println(new L44().isMatch("aa","*"));
        System.out.println("acdcb".matches("a*c?b"));
    }
}
