package N2019_6_5;

/**
 * Created by DanLongChen on 2019/6/5
 * 二维数组查找，给定一个二维数组，查找里面是否有指定的数
 **/
public class N_ErWeiShuZuChaZhao {
    public boolean Find(int target, int [][] array) {
        //从矩阵的右上角开始，如果当前的值比target大，那么这一列没有搜索的必要，如果比target小，那么这一行没有搜索的必要
        int rows=array.length;
        int cols=array[0].length;
        int row=0;
        int col=cols-1;
        while (row<rows && col>=0){
            if (array[row][col]==target){
                return true;
            }else{
                if(array[row][col]>target){
                    col--;//这一列没有找的必要
                }else{
                    row++;//这一行没有找的必要
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target=7;
        System.out.println(new N_ErWeiShuZuChaZhao().Find(target,nums));
    }
}
