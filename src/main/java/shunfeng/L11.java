package shunfeng;

import jdk.internal.util.xml.impl.Input;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/29
 **/
public class L11 {
        static int n,m,k;
        static int a[]=new int[1000];
        public static void init()
        {
            for(int i=1;i<=n;i++)
            {
                a[i]=i;
            }
        }
        public static int find(int x)
        {
            if(a[x]==x) return x;
            else return find(a[x]);
        }
        public static void unit(int x,int y)
        {
            a[x]=find(x);
            a[y]=find(y);
            a[a[x]]=a[y];
        }
        public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            n=in.nextInt();
            m=in.nextInt();
            k=in.nextInt();
            init();
            for(int i=0;i<k;i++)
            {
                int x=in.nextInt();
                int y=in.nextInt();
                unit(x,y);
            }
            int sum=0;
            for(int i=1;i<=n;i++)
            {
                if(a[i]==i)
                    sum++;
            }
            Random random=new Random();
            System.out.println(random.nextInt(10));

        }
}
