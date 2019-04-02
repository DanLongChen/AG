package L2019_4_2;

/**返回两个字符串第一个匹配的位置
 * Created by DanLongChen on 2019/4/2
 **/
public class L28 {
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0 && needle.length()==0){
            return 0;
        }
        for (int i=0;;i++){//haystack的起始点
            for(int j=0;;j++){//对应于haystack和needle的长度（needle的起始点每次都从0开始）
                if(j==needle.length()){//说明比较串已经比完，完全匹配
                    return i;
                }
                if(i+j==haystack.length()){//说明主串已经比完了
                    return -1;
                }
                if (haystack.charAt(i+j)!=needle.charAt(j)){//不匹配的情况
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new L28().strStr("aaa","aaa"));
    }
}
