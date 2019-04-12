package L2019_4_12;

import java.util.FormatFlagsConversionMismatchException;

/**
 * Created by DanLongChen on 2019/4/12
 **/
public class BiaoQian {
    public static void main(String[] args) {
        outer:
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                if(i==1){
                    break outer;
                }
                System.out.println("i="+i+"   j="+j);
            }
        }
        System.out.println("跳出成功！");
    }
}
