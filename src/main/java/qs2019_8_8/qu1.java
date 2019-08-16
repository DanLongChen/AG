package qs2019_8_8;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/8
 **/
public class qu1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        BigDecimal a=new BigDecimal(input.next());
        BigDecimal b=new BigDecimal(input.next());
        System.out.println(a.add(b));
    }
}
