package kuaishou;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/25
 **/
public class hebingneirongliu {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String a=input.nextLine();
        String b=input.nextLine();
        String[] arrA=a.split(" ");
        String[] arrB=b.split(" ");
        int index=1;
        int indexB=0;
        boolean flag=false;
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<arrA.length;i++){
            index++;
            builder.append(arrA[i]+" ");
            if(index==5 && flag==false){
                builder.append(arrB[indexB++]+" ");
                if(indexB>=arrB.length){
                    flag=true;
                }
                index=1;
            }
        }
        if(flag==false){
            for(int i=indexB;i<arrB.length;i++){
                builder.append(arrB[i]+" ");
            }
        }
        System.out.println(builder.toString().substring(0,builder.length()-1));
    }
}
