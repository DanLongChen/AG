package shunfeng;

import javax.print.DocFlavor;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by DanLongChen on 2019/8/29
 **/
public class test {
    public static void main(String[] args) {

    }
    public static void handler(){
        Scanner sca = new Scanner(System.in);
        while(sca.hasNext()){
            int n = sca.nextInt();
            int m = sca.nextInt();
            int k = sca.nextInt();
            boolean[][] map = new boolean[n][m];
            for(int i = 0; i < k; i++) {
                int x = sca.nextInt()-1;
                int y = sca.nextInt()-1;
                map[x][y] = true;
            }
            double[][] cw = new double[n][m];
            cw[0][0] = 1;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){

                    if(map[i][j]) cw[i][j] = 0;
                    else if(i == 0 && j == 0) {}
                    else cw[i][j] = (j-1<0?0:(i+1<n?cw[i][j-1]*0.5:cw[i][j-1]))+(i-1<0?0:(j+1<m?cw[i-1][j]*0.5:cw[i-1][j]));
                }
            }
            double res = cw[n-1][m-1];
            System.out.println(String.format("%.2f", res));
        }
    }

    public  void maxDepth(String seq) {
        /**
         * 如果是左括号那么stack值++，若不是那么进行消解操作stack--
         */
        int stack=0;
        int maxDepth = 0;
        char[] chars=seq.toCharArray();
        for (char e : chars) {
            if (e == '(') {
                ++stack;
                maxDepth = Math.max(stack, maxDepth);
            } else {
                --stack;
            }
        }
        System.out.println(maxDepth);

    }

    //KMP算法实现
    private static void KMP(String source, String pattern) {
        int[] N=getN(pattern);
        int res=0;
        int sourceLength=source.length();
        int patternLength=pattern.length();
        for(int i=0;i<=(sourceLength-patternLength);){
            res++;
            String str=source.substring(i, i+patternLength);//要比较的字符串
            p(str);
            int count=getNext(pattern, str,N);
            p("移动"+count+"步");
            if(count==0){
                p("KMP：匹配成功");
                break;
            }
            i=i+count;
        }
        p("KMP：一共匹配"+res+"次数");
    }
    /**
     * 得到下一次要移动的次数
     *
     * @param pattern
     * @param str
     * @param N
     * @return 0,字符串匹配；
     */
    private static int getNext(String pattern,String str,int[] N) {
        int n = pattern.length();
        char v1[] = str.toCharArray();
        char v2[] = pattern.toCharArray();
        int x = 0;
        while (n-- != 0) {
            if (v1[x] != v2[x]){
                if(x==0){
                    return 1;//如果第一个不相同，移动1步
                }
                return x-N[x-1];//x:第一次出现不同的索引的位置，即j
            }
            x++;
        }
        return 0;
    }
    private static int[] getN(String pattern) {
        char[] pat=pattern.toCharArray();
        int j=pattern.length()-1;
        int[] N=new int[j+1];
        for(int i=j;i>=2;i--){
            N[i-1]=getK(i,pat);
        }
        for(int a:N)
            p(a);
        return N;
    }
    private static int getK(int j, char[] pat) {
        int x=j-2;
        int y=1;
        while (x>=0 && compare(pat, 0, x, y, j-1)) {
            x--;
            y++;
        }
        return x+1;
    }
    private static boolean compare(char[] pat,int b1,int e1,int b2,int e2){
        int n = e1-b1+1;
        while (n-- != 0) {
            if (pat[b1] != pat[b2]){
                return true;
            }
            b1++;
            b2++;
        }
        return false;
    }
    public static void p(Object obj) {
        System.out.println(obj);
    }
}
