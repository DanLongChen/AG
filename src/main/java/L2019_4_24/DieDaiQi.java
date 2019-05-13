package L2019_4_24;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanLongChen on 2019/4/24
 **/
public class DieDaiQi {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(i);
        }
        for (int i=0;i<10;i++){
            list.remove(i);
        }
    }
}
