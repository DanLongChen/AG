package L2019_3_26;

/**求旋转数组的最小值
 * Created by DanLongChen on 2019/3/27
 * 有一个已经排好序的数组，现在以某个未知元素为支点旋转，如：0,1,2,4,5,6,7 旋转之后为 4,5,6,7,0,1，2。求旋转之后的数组的最小值(相当于两个子数组，前面的子数组大于后面的，最小值在两个数组的分界处)
 **/
public class XuanZhuanShuzuZuiXiaoZhi {
    public int solution(int[] arr){
        int low=0;
        int high=arr.length-1;
        int mid=0;
        while(low<high){
            mid=(low+high)/2;
            if(arr[low]<arr[mid]){
                low=mid;
            }else{
                high=mid;
            }
        }
        return arr[mid+1];
    }

    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,3};
        XuanZhuanShuzuZuiXiaoZhi xuanZhuanShuzuZuiXiaoZhi=new  XuanZhuanShuzuZuiXiaoZhi();
        System.out.println(xuanZhuanShuzuZuiXiaoZhi.solution(arr));
    }
}
