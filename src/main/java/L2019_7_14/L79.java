package L2019_7_14;

/**
 * Created by Paser on 2019/7/14.
 * 单词搜索
 */
public class L79 {
    public static void main(String[] args) {
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new L79().exist(board,"ABCCED"));
    }
    public boolean exist(char[][] board, String word) {
        /**
         * DFS+回溯，使用一个数组来记录是否已经搜索过了
         */
        if(board==null || board.length==0 || word==null || word.length()==0){
            return false;
        }
        int[][] flag=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0) && handler(board,flag,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean handler(char[][] board,int[][] flag,String word,int i,int j,int index){
        /**
         * 因为外面已经有个循环了，所以里面就不需要循环了
         */
        if(index==word.length()){//找到的情况
            return true;
        }
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || word.charAt(index)!=board[i][j] || flag[i][j]==1){
            return false;//停止查找的情况
        }
        flag[i][j]=1;
        if(handler(board,flag,word,i+1,j,index+1) || handler(board,flag,word,i-1,j,index+1)
                || handler(board,flag,word,i,j+1,index+1) || handler(board,flag,word,i,j-1,index+1)){
            return true;
        }//上下左右任何一个找到了都是可以的
        flag[i][j]=0;//进行回溯
        return false;

    }
}
