package N2019_5_15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/5/15
 **/
public class NiuNiuyuNiuNiu {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int[] n1=new int[3];
        int[] n2=new int[3];
        List<Integer> AlGet=new ArrayList<>();
        for (int i=0;i<3;i++){
            int a=input.nextInt();
            n1[i]=a;
            AlGet.add(a);
        }
        for (int i=0;i<3;i++){
            int b=input.nextInt();
            n2[i]=b;
            AlGet.add(b);
        }
        int sum1=n1[0]+n1[1]+n1[2];
        int sum2=n2[0]+n2[1]+n2[2];
        int dil=sum2-sum1;
        int Aindex=0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0;i<4;i++){
            List<Integer> list1=new ArrayList<Integer>();
            for (int j=1;j<=13;j++){
                if (Aindex<AlGet.size() && AlGet.get(Aindex)==j){
                    Aindex++;
                    continue;
                }
                list1.add(j);
            }
            list.add(list1);
        }
        int cout=0;//用于判断A>B的次数
        int x=0,y=0;
        List<Integer> allValue=new ArrayList<>();
        for (int i=0;i<4;i++){
            for (int j=0;j<list.get(i).size();j++){
                allValue.add(list.get(i).get(j));
            }
        }
        System.out.println(allValue.size());
        for (int i=0;i<allValue.size();i++){
            for (int j=0;j<allValue.size();j++){
                x=allValue.get(i);
                y=allValue.get(j);
                if(x-y>dil){
//                    System.out.println(x+"   "+y);
                    cout++;
                }
            }
        }

        System.out.printf("%.4f",(double)cout/(46*45));

    }
}
