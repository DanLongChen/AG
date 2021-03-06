package L2019_3_31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**电话号码组合
 * Created by DanLongChen on 2019/3/31
 **/
public class L17 {
    public List<String> letterCombinations(String digits) {
        List<List<Character>> list = new ArrayList<>();
        if (digits.length()==0){
            return new ArrayList<String>();
        }
        List<Character> temp=null;
        /**
         * 首先创建好对应表
         */
        for(int i=0;i<9;i++){
            if(i==0){
                temp=new ArrayList<>();
                list.add(temp);
            }
            if(i==1){
                temp=new ArrayList<>(Arrays.asList('a','b','c'));
                list.add(temp);
            }
            if(i==2){
                temp=new ArrayList<>(Arrays.asList('d','e','f'));
                list.add(temp);
            }
            if(i==3){
                temp=new ArrayList<>(Arrays.asList('g','h','i'));
                list.add(temp);
            }
            if(i==4){
                temp=new ArrayList<>(Arrays.asList('j','k','l'));
                list.add(temp);
            }
            if(i==5){
                temp=new ArrayList<>(Arrays.asList('m','n','o'));
                list.add(temp);
            }
            if(i==6){
                temp=new ArrayList<>(Arrays.asList('p','q','r','s'));
                list.add(temp);
            }
            if(i==7){
                temp=new ArrayList<>(Arrays.asList('t','u','v'));
                list.add(temp);
            }
            if(i==8){
                temp=new ArrayList<>(Arrays.asList('w','x','y','z'));
                list.add(temp);
            }
        }
        /**
         * 两个两个来进行组合
         */
        char[] numbers=digits.toCharArray();
        List<String> result=new ArrayList<>();
        result.add("");
        for(char i:numbers){//用于获取是哪一个号码
            List<String> resultTemp=new ArrayList<>();
            for(char j:list.get(i-'0'-1)){//获取对应电话号码的字母
                for(String k:result){
                    k+=j;
                    resultTemp.add(k);
                }
            }
            result=resultTemp;
        }
        return result;


    }

    public static void main(String[] args) {
        System.out.println(new L17().letterCombinations(""));
    }
}
