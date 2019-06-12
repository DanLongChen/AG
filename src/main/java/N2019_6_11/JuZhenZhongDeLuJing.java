package N2019_6_11;

/**
 * Created by DanLongChen on 2019/6/11
 * 矩阵中的路径
 **/
public class JuZhenZhongDeLuJing {
    public static void main(String[] args) {
        char[] matrx={'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str={'b','c','c','e','d'};
        System.out.println(new JuZhenZhongDeLuJing().hasPath(matrx,3,4,str));
    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] flag=new boolean[rows*cols];
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(handler(matrix,rows,cols,i,j,str,0,flag)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean handler(char[] matrix,int rows,int cols,int i,int j,char[] str,int index,boolean[] flag){
        int flagIndex=i*cols+j;
        if (i<0 || i>rows-1 || j<0 || j>cols-1 || flag[flagIndex] || str[index]!=matrix[flagIndex]){
            return false;
        }
        if(index==str.length-1){
            return true;
        }
        flag[flagIndex]=true;
        if(handler(matrix,rows,cols,i,j-1,str,index+1,flag)
        || handler(matrix,rows,cols,i,j+1,str,index+1,flag)
        || handler(matrix,rows,cols,i+1,j,str,index+1,flag)
        || handler(matrix,rows,cols,i-1,j,str,index+1,flag)){
            return true;
        }
        flag[flagIndex]=false;
        return false;

    }
}
