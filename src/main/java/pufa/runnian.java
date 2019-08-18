package pufa;

/**
 * Created by DanLongChen on 2019/8/17
 **/
public class runnian {
    public static void main(String[] args) {
        for (int i=1990;i<=2004;i++){
            if(i%4==0&&i%100!=0 || i%400==0){
                System.out.println(i);
            }
        }
    }
}
