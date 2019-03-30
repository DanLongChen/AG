package L2019_3_30;

import java.util.ArrayList;
import java.util.List;

/**Z字形变化
 * Created by Paser on 2019/3/30.
 */
public class L6 {
    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        if(s.length()<=numRows){
            return s;
        }
        String result="";
        List<List<Character>> list=new ArrayList<List<Character>>();
        for (int i=0;i<numRows;i++){
            list.add(new ArrayList<Character>());
        }
        int flag=-1;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(count>=numRows-1 || count<=0){
                flag=-flag;
            }
            list.get(count).add(s.charAt(i));
            count+=flag;
        }
        for(int i=0;i<list.size();i++){
            for (int j=0;j<list.get(i).size();j++){
                result+=list.get(i).get(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new L6().convert("AB",1));
    }
}
