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

    }
}
