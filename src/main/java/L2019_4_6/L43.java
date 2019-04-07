package L2019_4_6;

/**两个String相乘，length<110,不能使用BigInteger这些，第一个不包含0（除非是0本身）
 * Created by Paser on 2019/4/6.
 */
public class L43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        /**
         * 这里可以使用模拟乘法的过程
         */
        int[] result=new int[num1.length()+num2.length()];
        for (int i=num1.length()-1;i>=0;i--){
            int a=num1.charAt(i)-'0';
            int jinwei=0;//表示进位
            for (int j=num2.length()-1;j>=0;j--){
                int b=num2.charAt(j)-'0';
                int temp=a*b+jinwei+result[i+j+1];//算出某个位置的值
                jinwei=temp/10;//计算进位
                result[i+j+1]=temp%10;//算出最新填入i+j+1位置的值
            }
            /**
             * 代表乘法计算中的一行结束，统计jinwei的值（也就是最高位是否有进位）
             */
            if(jinwei>0){
                result[i]=jinwei;//计算到最后j==0
            }
        }
        int k=0;
        while (result[k]==0){
            k++;//找出数值开始的起始位置
        }
        StringBuilder builder=new StringBuilder();
        for (int i=k;i<result.length;i++){
            builder.append(result[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new L43().multiply("123","456"));
    }
}
