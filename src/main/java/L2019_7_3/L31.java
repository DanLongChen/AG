package L2019_7_3;

/**
 * Created by DanLongChen on 2019/7/3
 * 下一个排序
 **/
public class L31 {
    public void nextPermutation(int[] nums) {
        //首先从后往前找，找到a[i-1]<a[i],然后再从后往前找，找到第一个>a[i-1]的值，将两者交换，再将i-1之后的数字进行逆序
        /**
         * 我们需要从右边找到第一对两个连续的数字 a[i]a[i] 和 a[i-1]a[i−1]，它们满足 a[i]>a[i-1]a[i]>a[i−1]。现在，没有对 a[i-1]a[i−1] 右侧的重新排列可以创建更大的排列，因为该子数组由数字按降序组成。因此，我们需要重新排列 a[i-1]a[i−1] 右边的数字，包括它自己。
         *
         * 现在，什么样子的重新排列将产生下一个更大的数字呢？我们想要创建比当前更大的排列。因此，我们需要将数字 a[i-1]a[i−1] 替换为位于其右侧区域的数字中比它更大的数字，例如 a[j]a[j]。
         *
         *
         *
         * 我们交换数字 a[i-1]a[i−1] 和 a[j]a[j]。我们现在在索引 i-1i−1 处有正确的数字。 但目前的排列仍然不是我们正在寻找的排列。我们需要通过仅使用 a[i-1]a[i−1]右边的数字来形成最小的排列。 因此，我们需要放置那些按升序排列的数字，以获得最小的排列。
         *
         * 但是，请记住，在从右侧扫描数字时，我们只是继续递减索引直到我们找到 a[i]a[i] 和 a[i-1]a[i−1] 这对数。其中，a[i] > a[i-1]a[i]>a[i−1]。因此，a[i-1]a[i−1] 右边的所有数字都已按降序排序。此外，交换 a[i-1]a[i−1] 和 a[j]a[j] 并未改变该顺序。因此，我们只需要反转 a[i-1]a[i−1] 之后的数字，以获得下一个最小的字典排列。
         *
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/two-sum/solution/xia-yi-ge-pai-lie-by-leetcode/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        if(nums==null || nums.length==0 || nums.length==1){
            return;
        }
        if(nums.length==2){
            swap(nums,0,nums.length-1);
            return;
        }
        int index=nums.length-2;
        while(index>=0 && nums[index]>=nums[index+1]){
            index--;
        }
        if(index>=0){//如果说当前已经到-1了，则不执行这个步骤
            int target=nums[index];
            int index1=0;
            for(int i=nums.length-1;i>index;i--){
                if(nums[i]>target){
                    index1=i;
                    break;
                }
            }
            swap(nums,index,index1);
        }
        int left=index+1,right=nums.length-1;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }



    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
