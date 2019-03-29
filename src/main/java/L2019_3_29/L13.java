package L2019_3_29;

/**罗马数字变成数字
 * Created by DanLongChen on 2019/3/29
 **/
public class L13 {
    public int romanToInt(String s) {
        char[] chars=s.toCharArray();
        int result=0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='M'){
                result+=1000;
            }
            if(chars[i]=='D'){
                result+=500;
            }
            if(chars[i]=='C'){
                if(i+1<chars.length){
                    /**
                     * 成对出现的特殊情况
                     */
                    if(chars[i+1]=='D'){
                        result+=400;
                        i++;
                        continue;
                    }
                    if(chars[i+1]=='M'){
                        result+=900;
                        i++;
                        continue;
                    }
                    result+=100;
                }else{
                    result+=100;
                }
            }
            if (chars[i] == 'L') {
                result+=50;
            }
            if(chars[i]=='X'){
                if(i+1<chars.length){
                    if(chars[i+1]=='L'){
                        result+=40;
                        i++;
                        continue;
                    }
                    if(chars[i+1]=='C'){
                        result+=90;
                        i++;
                        continue;
                    }
                    result+=10;
                }else{
                    result+=10;
                }
            }
            if(chars[i]=='V'){
                result+=5;
            }
            if(chars[i]=='I'){
                if(i+1<chars.length){
                    if(chars[i+1]=='V'){
                        result+=4;
                        i++;
                        continue;
                    }
                    if(chars[i+1]=='X'){
                        result+=9;
                        i++;
                        continue;
                    }
                    result+=1;
                }else{
                    result+=1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new L13().romanToInt("MCMXCIV"));
    }
}
