package wy2019_8_3;

import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by DanLongChen on 2019/8/4
 **/
public class test {
    PriorityQueue<Activity> queue = new PriorityQueue<>(new Comparator<Activity>() {
        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.getBeginTime().before(o2.getBeginTime()) ? -1 : o1.getBeginTime() == o2.getBeginTime() ? 0 : -1;
        }
    });

    public static void main(String[] args) {


    }

    public void add(String name, String rule, Date startTime, Date endTime) {//添加一个活动，需要输入活动的名称，规则，开始时间，结束时间
        Activity newActivity = new Activity(name, rule, startTime, endTime);
        queue.add(newActivity);
    }

    public void delete(String name) {//删除一个活动，需要输入对应的活动名称
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            Activity temp = (Activity) iterator.next();
            if (temp.getName() == name) {
                iterator.remove();
                break;
            }
        }
    }

    public int ActicitySchedule() {
        Iterator iterator = queue.iterator();
        int[] s = new int[queue.size()];
        int[] f = new int[queue.size()];
        boolean[] a = new boolean[queue.size()];
        int index = 0;
        while (iterator.hasNext()) {
            Activity temp = (Activity) iterator.next();
            s[index] = (int) temp.getBeginTime().getTime();
            f[index] = (int) temp.getEndTime().getTime();
            index++;
        }
        int n = s.length - 1;
        a[1] = true;
        int j = 1;
        int count = 1;

        for (int i = 2; i <= n; i++) {
            if (s[i] >= f[j]) {
                a[i] = true;
                j = i;
                count++;
            } else {
                a[i] = false;
            }

        }
        return count;

    }

}

class Activity {
    private String Name;
    private String Rule;
    private Date beginTime;
    private Date endTime;

    public Activity(String name, String rule, Date beginTime, Date endTime) {
        Name = name;
        Rule = rule;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRule() {
        return Rule;
    }

    public void setRule(String rule) {
        Rule = rule;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}