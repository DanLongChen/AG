package jichu;

/**
 * Created by DanLongChen on 2019/8/14
 * 求最大公约数
 **/
public class zuidagongyueshu {
    public static void main(String[] args) {
        int x=100,y=10;
        int z=y;
        while(x%y!=0){
            z=x%y;
            x=y;
            y=z;
        }
        System.out.println(z);
    }
}
