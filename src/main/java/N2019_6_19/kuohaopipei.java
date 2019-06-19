package N2019_6_19;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/6/19
 * 基本上暴力解法只能过80%，所以需要优化。
 * 判断字符串匹配思想：给一个整数c=0，遍历字符串s，碰到左括号+1，碰到有括号-1，如果遍历过程中c不出现小于0的情况且最终c=0，那么字符串s中的括号就是匹配的。
 * 1.输入时检查每个字符串，可以分成2种：自身匹配①，自身不匹配。其中自身不匹配有三种情况：全向右开（内部可能穿插着一些自身闭合的子串 如：'(()('这种）②，全向左开③，两面开④。
 * 2.①只能和①匹配，所以可以单独用m记录①的个数，则组合匹配的个数是m*m.
 * 3.④跟谁都不匹配， 所以忽略。
 * 4.②和③，哈希表positive记录②中向右开的括号的个数为key的字符串个数有多少个，哈希表negtive记录③中向左开的括号的个数为key的字符串个数有多少个。如若判断当前s为情况②，则找③中绝对值相等的字符串的个数，累加即可。
 * 5.把2和4中的值相加，就是最终的总个数。
 **/
public class kuohaopipei {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] strs=new String[n];
        //int[] cs=new int[n];
        HashMap<Integer,Integer> positive=new HashMap<>();
        HashMap<Integer,Integer> negtive=new HashMap<>();
        int m=0,count=0;
        for(int i=0;i<n;i++)
        {
            String s=sc.next();
            int c=0,min=Integer.MAX_VALUE;
            boolean flag=false;
            for(int j=0;j<s.length();j++)
            {
                if(s.charAt(j)=='(')
                    c++;
                else if(s.charAt(j)==')')
                    c--;
                else;
                if(c<0)
                {
                    flag=true;
                    if(c<min)
                        min=c;
                }
            }
            if(!flag && c==0)
                m++;
            if(!flag && c>0)
            {
                if(positive.get(c)!=null)
                    positive.put(c, positive.get(c)+1);
                else
                    positive.put(c,1);
                if(negtive.get(-c)!=null)
                    count+=negtive.get(-c);
            }
            if(c<0 && c==min)
            {
                if(negtive.get(c)!=null)
                    negtive.put(c, negtive.get(c)+1);
                else
                    negtive.put(c,1);
                if(positive.get(-c)!=null)
                    count+=positive.get(-c);
            }
        }
        count+=m*m;
        /*for(Integer key:positive.keySet())
        {
            if(negtive.get(-key)!=null)
                count+=positive.get(key)*negtive.get(-key);
        }*/
        System.out.println(count);
    }
}
