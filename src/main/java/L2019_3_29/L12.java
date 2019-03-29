package L2019_3_29;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

/**整数转罗马数字
 * Created by DanLongChen on 2019/3/29
 **/
public class L12 {
    public String intToRoman(int num) {
        String result="";
        /**
         * 需要判断几种特殊情况
         */
        while (num!=0){
            if (num>=1000){
                int qian=num/1000;
                for (int i=0;i<qian;i++){
                    result+="M";
                }
                num=num%1000;
            }
            if(num>=900){
                result+="CM";
                num-=900;
            }
            if(num>=500){
                result+="D";
                num-=500;
            }
            if(num>=400){
                result+="CD";
                num-=400;
            }
            if(num>=100){
                int bai=num/100;
                for(int i=0;i<bai;i++){
                    result+="C";
                }
                num%=100;
            }
            if(num>=90){
                result+="XC";
                num-=90;
            }
            if(num>=50){
                result+="L";
                num-=50;
            }
            if(num>=40){
                result+="XL";
                num-=40;
            }
            if(num>=10){
                int shi=num/10;
                for(int i=0;i<shi;i++){
                    result+="X";
                }
                num%=10;
            }
            if(num>=9){
                result+="IX";
                num-=9;
            }
            if(num>=5){
                result+="V";
                num-=5;
            }
            if(num>=4){
                result+="IV";
                num-=4;
            }
            if(num>=1){
                int yi=num/1;
                for(int i=0;i<yi;i++){
                    result+="I";
                }
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L12 l12=new L12();
        System.out.println(l12.intToRoman(1994));
    }
}
