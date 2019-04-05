package L2019_4_5;

import java.util.HashSet;
import java.util.Set;

/**验证是否为数独板，二维数组中要么是.要么是数字
 * Created by Paser on 2019/4/5.
 */
public class L36 {
    public boolean isValidSudoku(char[][] board) {
        /**
         * 先验证每一行是否为数独
         */
        for (int i=0;i<board.length;i++){
            Set<Character> set=new HashSet<>();
            for (int j=0;j<board[i].length;j++){
                if(board[i][j]>='0' && board[i][j]<=9){//是数字则放入set中检验
                    if(set.contains(board[i][j])){
                        return false;//已经包含了这个数字的情况下
                    }else{
                        set.add(board[i][j]);
                    }
                }
            }
            if (set.size()==0){//说明这一行没有数字，那么也返回false
                return false;
            }
        }
        /**
         * 验证每一列是否是数独
         */
        for(int j=0;j<board[0].length;j++){
            Set<Character> set=new HashSet<>();
            for(int i=0;i<board.length;i++){
                if(board[i][j]>='0' && board[i][j]<=9){//是数字则放入set中检验
                    if(set.contains(board[i][j])){
                        return false;//已经包含了这个数字的情况下
                    }else{
                        set.add(board[i][j]);
                    }
                }
            }
            if (set.size()==0){//说明这一行没有数字，那么也返回false
                return false;
            }
        }
        /**
         * 再验证每个3X3是否为数独
         */
        for (int i=0;i<3;i++){//表示行的系数值
            for(int j=0;j<3;j++){//表示列的系数值
                Set<Character> set=new HashSet<>();
                for(int x=0;x<3;x++){
                    for(int y=0;y<3;y++){
                        if (board[3*i+x][3*j+y]>=0 && board[3*i+x][3*j+y]<=9){
                            if(set.contains(board[3*i+x][3*j+y])){
                                return false;
                            }
                            set.add(board[3*i+x][3*j+y]);
                        }
                    }
                }
                if(set.size()==0){
                    return false;
                }
            }
        }
        return true;
    }
}
