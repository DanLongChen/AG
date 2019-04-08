package L2019_4_7;

/**二进制加法（输入的两个String都不为空，并且只是包含0和1）
 * Created by Paser on 2019/4/7.
 */
public class L67 {
    public String addBinary(String a, String b) {
        int indexA=a.length()-1;
        int indexB=b.length()-1;
        StringBuilder result=new StringBuilder();
        int tempA=0;
        int tempB=0;
        int jinwei=0;
        while (indexA>=0 && indexB>=0){
            tempA=a.charAt(indexA)-'0';
            tempB=b.charAt(indexB)-'0';
            result.insert(0,(tempA+tempB+jinwei)%2);
            jinwei=(tempA+tempB+jinwei)/2;
            indexA--;
            indexB--;
            System.out.println(jinwei);
        }
        while (indexA>=0){
            tempA=a.charAt(indexA)-'0';
            result.insert(0,(tempA+jinwei)%2);
            jinwei=(tempA+jinwei)/2;
            indexA--;
        }
        while (indexB>=0){
            tempB=b.charAt(indexB)-'0';
            result.insert(0,(tempB+jinwei)%2);
            jinwei=(tempB+jinwei)/2;
            indexB--;
        }
        if (jinwei==1){
            result.insert(0,jinwei);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new L67().addBinary("11","1"));

    }
}
