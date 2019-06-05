package N2019_6_5;

/**
 * Created by DanLongChen on 2019/6/5
 * 替换字符串中的空格
 **/
public class N_TiHuanKongGe {
    public String replaceSpace(StringBuffer str) {
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                builder.append("%20");
            }else{
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new N_TiHuanKongGe().replaceSpace(new StringBuffer("1 2 3 4")));
    }
}
