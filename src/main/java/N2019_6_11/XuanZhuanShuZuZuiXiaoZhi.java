package N2019_6_11;

/**
 * Created by DanLongChen on 2019/6/11
 * 求旋转数组的最小值
 **/
public class XuanZhuanShuZuZuiXiaoZhi {
    public int minNumberInRotateArray(int [] array) {
        int left=0,right=array.length-1;
        while (array[left]>array[right]){
            if(right-left==1){
                return array[right];
            }
            int mid=(left+right)/2;
            if(array[left]<=array[mid]){
                left=mid;
            }
            if(array[mid]<=array[right]){
                right=mid;
            }
        }
        return array[0];
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,1,1,1,1};
        System.out.println(new XuanZhuanShuZuZuiXiaoZhi().minNumberInRotateArray(array));
    }
}
