package L2019_3_26;

/**求最大连续子数组
 * Created by DanLongChen on 2019/3/27
 **/
public class MaxSubArray {
    /**
     * 尝试暴力法、分治
     * @param arr
     * @return
     */
    public int solution(int[] arr){
        int max=0;
        for(int i=0;i<arr.length;i++){//定义搜索的起点
            for(int j=i;j<arr.length;j++){//定义搜索的终点
                int temp=0;
                for(int k=i;k<=j;k++){//把这个区间的数全部加起来与max作比较
                    temp+=arr[k];
                }
                if(temp>max){
                    max=temp;
                }
            }
        }
        return max;
    }

    /**
     * DP算法
     * @param arr
     * @return
     */
    public int DP(int[] arr){
        int result=arr[0];//标记当前这个为最大值
        int sum=arr[0];
        for(int i=1;i<arr.length;i++){
            sum=Math.max(sum+arr[i],arr[i]);
            if(sum>result){
                result=sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray=new MaxSubArray();
        int[] arr={1,-2,3,10,-4,7,2,-5};
        System.out.println(maxSubArray.DP(arr));
    }
}
