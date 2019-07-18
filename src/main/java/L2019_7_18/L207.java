package L2019_7_18;

/**
 * Created by DanLongChen on 2019/7/18
 * 课程表
 **/
public class L207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
         * 使用拓扑排序，先找出入度为0的节点，删去该节点，再找，然后再删除
         */
        if(numCourses==0){
            return false;
        }
        boolean[] visited=new boolean[numCourses];
        int[] inDegree=new int[numCourses];//表示每个节点的入度
        for (int i=0;i<prerequisites.length;i++){
            inDegree[prerequisites[i][0]]++;//代表入度(因为二维数组中前面的值依赖于后面的值，相当于后面的值指向前面的值)
        }
        while (true){
            //开始寻找入度为0的节点
            int i=0;
            for(i=0;i<numCourses;i++){
                if(inDegree[i]==0 && !visited[i]){
                    break;
                }
            }
            if(i==numCourses){//没有找到入度为0的
                break;
            }
            for(int j=0;j<prerequisites.length;j++){
                if(prerequisites[j][1]==i){
                    inDegree[prerequisites[j][0]]--;
                }
            }
            visited[i]=true;
        }
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]>0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums={{1,0},{0,1}};
        System.out.println(new L207().canFinish(2,nums));
    }
}
