package IntroductiontoAlgorithm.greedy;

import java.util.*;

/**
 * Created by wesley on 2016/11/14.
 */
class Activity implements Comparable<Activity> {
    private String startTime;//活动开始时间
    private String endTime;//活动结束时间
    public Activity(String startTime,String endTime){
        this.startTime=startTime;
        this.endTime=endTime;
    }
    /**
     * 按照活动结束时间非递减排序
     */
    @Override
    public int compareTo(Activity obj) {
        String targetEndTime=obj.getEndTime();
        int endHour=Integer.parseInt(endTime.split(":")[0]);
        int endMin=Integer.parseInt(endTime.split(":")[1]);
        int targetEndHour=Integer.parseInt(targetEndTime.split(":")[0]);
        int targetEndMin=Integer.parseInt(targetEndTime.split(":")[1]);
        int i=endMin>targetEndMin?1:(endMin<targetEndMin?-1:0);
        return endHour>targetEndHour?1:(endHour<targetEndHour?-1:(i));
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    @Override
    public String toString() {
        return startTime + "~" + endTime;
    }
}
public class ActivityPlan {
    List<Activity> res=new ArrayList<Activity>();
    public List<Activity> layout(Iterator<Activity> activities){
        if(!activities.hasNext()){
            return res;
        }
        Activity activity=activities.next();
        int size=res.size();
        if(size==0){
            res.add(activity);
        }else{
            Activity preActivity=res.get(size-1);
            String preEndTime=preActivity.getEndTime();
            String thisStartTime=activity.getStartTime();
            if(legal(preEndTime,thisStartTime)){
                res.add(activity);
            }
        }
        return layout(activities);
    }
    /**
     * 当前活动的开始时间是否在上一个活动的结束时间之后
     */
    private boolean legal(String preEndTime, String thisStartTime) {
        int preHour=Integer.parseInt(preEndTime.split(":")[0]);
        int preMin=Integer.parseInt(preEndTime.split(":")[1]);
        int thisHour=Integer.parseInt(thisStartTime.split(":")[0]);
        int thisMin=Integer.parseInt(thisStartTime.split(":")[1]);
        int i=preMin>thisMin?-1:(preMin<thisMin?1:0);
        int j=preHour>thisHour?-1:(preHour<thisHour?1:(i));
        return j>=0;
    }


    //TreeSet 的使用，创建即有序，不用再进行排序操作
    public static void main(String[] args) {
        Set<Activity> activitys=new TreeSet<Activity>();
        activitys.add(new Activity("9:30","10:30"));
        activitys.add(new Activity("7:30","8:50"));
        activitys.add(new Activity("10:40","11:30"));
        activitys.add(new Activity("8:00","10:30"));
        activitys.add(new Activity("8:30","11:40"));
        activitys.add(new Activity("10:30","12:30"));
        ActivityPlan plan=new ActivityPlan();
        List<Activity> res=plan.layout(activitys.iterator());
        for(Activity activity:res){
            System.out.print("\t"+activity);
        }
    }
}

/**
 2      * //算法导论中活动选择问题动态规划求解
 3      * @param s 活动的开始时间
 4      * @param f 活动的结束时间
 5      * @param n 活动数目
 6      * @return 最大兼容的活动个数
 7      */
/*
            public static int maxCompatiableActivity(int[] s, int[] f, int n){
                int[][] c = new int[n + 2][n + 2];

                for(int j = 0; j <= n+1; j++)
                    for(int i = n+1; i >= j; i--)
                         c[i][j] = 0;//if i>=j S(i,j)是空集合

                int maxTemp = 0;
                for(int j = 1; j <= n+1; j++)
                {
                    for(int i = 0; i < j; i++)//i < j
                    {
                        for(int k = i+1; k < j; k++)// i< k <j
                        {
                            if(s[k] >= f[i] && f[k] <= s[j])//S(i,j)不空
                            {
                                if(c[i][k] + c[k][j] + 1 > maxTemp)
                                    maxTemp = c[i][k] + c[k][j] + 1;
                            }
                        }//inner for
                        c[i][j] = maxTemp;
                        maxTemp = 0;
                    }//media for
                }//outer for
                return c[0][n+1];
            }
            */
