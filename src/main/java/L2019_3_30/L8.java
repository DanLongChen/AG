package L2019_3_30;

/**字符串转整数
 * Created by Paser on 2019/3/30.
 */
public class L8 {
    public static void main(String[] args) {
        System.out.println(new L8().myAtoi("-91283472332"));
    }
    public int myAtoi(String str) {
        String temp=str.trim();//首先去掉空格
        if (temp.length()==0){
            return 0;
        }
        StringBuilder builder=new StringBuilder();
        char firstOne=temp.charAt(0);
        for(int i=0;i<temp.length();i++){
            if (i==0){
                if(firstOne=='-' || firstOne=='+' || firstOne>='0'&&firstOne<='9'){
                    builder.append(firstOne);
                    continue;
                }else{
                    return 0;
                }

            }
            if (temp.charAt(i)>='0' && temp.charAt(i)<='9'){
                builder.append(temp.charAt(i));
            }else{
                break;
            }
        }
        if(stringToInt(builder.toString())){
            return Integer.parseInt(builder.toString());
        }else{
            if(builder.length()==1){
                return 0;
            }else{
                if(firstOne=='-'){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
        }

    }

    /**
     * 转化string到int，转化失败的情况可能是溢出，或者只有加减
     * @param string
     * @return
     */
    public boolean stringToInt(String string){
        try{
            Integer.parseInt(string);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
