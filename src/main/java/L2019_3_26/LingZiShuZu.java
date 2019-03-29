package L2019_3_26;

/**求零子数组，也就是给定一个数组，求其中最接近0的子序列
 * Created by DanLongChen on 2019/3/27
 **/
public class LingZiShuZu {
    public int solution(int[] arr){
        int result=arr[0];
        int sum=arr[0];//以arr[i]为结尾的最小子数组
        for(int i=1;i<arr.length;i++){
            sum=Math.min(Math.abs(sum+arr[i]),Math.abs(arr[i]));
            if(result>=sum){
                result=sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={1,-2,3,10,-4,7,2,-5};
        LingZiShuZu lingZiShuZu=new LingZiShuZu();
        System.out.println(lingZiShuZu.solution(arr));
    }
}
