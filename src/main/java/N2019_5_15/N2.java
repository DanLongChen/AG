package N2019_5_15;

import com.sun.deploy.panel.ITreeNode;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/5/15
 **/
public class N2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int startNum=input.nextInt();
        int[][] startXY=new int[startNum][2];
        for (int i=0;i<startNum;i++){
            for (int j=0;j<2;j++){
                startXY[i][j]=input.nextInt();
            }
        }
        int queNum=input.nextInt();
        int[][] questionis=new int[queNum][4];
        for(int i=0;i<queNum;i++){
            for(int j=0;j<4;j++){
                questionis[i][j]=input.nextInt();
            }
        }
        for (int qi=0;qi<queNum;qi++){
            int Lx=questionis[qi][0];
            int Ly=questionis[qi][1];
            int Rx=questionis[qi][2];
            int Ry=questionis[qi][3];
            int sum=0;
            for (int si=0;si<startNum;si++){
                if(startXY[si][0]>=Lx && startXY[si][1]>=Ly && startXY[si][0]<=Rx && startXY[si][1]<=Ry){
//            System.out.println(Lx+" "+Ly+" "+Rx+" "+Ry);
//                    System.out.println(startXY[si][0]+" "+startXY[si][1]);
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
