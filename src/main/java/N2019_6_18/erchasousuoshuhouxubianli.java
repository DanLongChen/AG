package N2019_6_18;

/**
 * Created by DanLongChen on 2019/6/18
 * 判断一个序列是不是一个树的后序遍历
 **/
public class erchasousuoshuhouxubianli {
    public static void main(String[] args) {
        int[] num={1,2,3,4,5};
        System.out.println(new erchasousuoshuhouxubianli().VerifySquenceOfBST(num));
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        /**
         * 最后一个数作为根节点，其左子树都比起小，右子树都比其大，那么找到这个边界，然后在进行判断（递归）
         */
        if (sequence==null || sequence!=null && sequence.length==0){
            return false;
        }
        return handler(sequence,0,sequence.length-1);
    }
    public boolean handler(int[] sequence,int start,int end){
        if (start>=end){
            return true;
        }
        int max=sequence[end];
        int i = 0;
        for (;i<end;i++){
            if(sequence[i]>max){
                break;
            }
        }
        int j=i;
        for (;j<end;j++){
            if(sequence[j]<max){
                return false;
            }
        }
        boolean a=true;
        if (i>start)
            handler(sequence,start,i-1);
        boolean b=true;
        if (i<end-1)
        handler(sequence,i,end-1);
        return  a&&b ;

    }
}
