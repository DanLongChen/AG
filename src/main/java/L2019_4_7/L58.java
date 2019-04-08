package L2019_4_7;

/**最后一个单词的长度
 * Created by Paser on 2019/4/7.
 */
public class L58 {
    public int lengthOfLastWord(String s) {
        if (s.length()==0){
            return 0;
        }
        String[] temp=s.split(" ");
        if(temp.length==0){
            return 0;
        }
        return temp[temp.length-1].length();
    }

    public static void main(String[] args) {
        System.out.println(new L58().lengthOfLastWord("     "));
    }
}
