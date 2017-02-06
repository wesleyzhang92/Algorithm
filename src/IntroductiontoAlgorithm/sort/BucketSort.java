package IntroductiontoAlgorithm.sort;

/**
 * Created by wesley on 2016/10/6.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BucketSort {
    public static void main(String[] args) {
        BucketSort bs = new BucketSort();
        double[] nums = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23};
        bs.bucket_sort(nums);
    }

    public void bucket_sort(double[] nums) {
        int n = nums.length;
        ArrayList<ArrayList<Double>> bucket = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < 10; i++) {
            bucket.add(new ArrayList<Double>());
        }
        for (int j = 0; j < n; j++) {
            int k = (int) Math.floor(nums[j] * 10);
            bucket.get(k).add(nums[j]);
        }
        for (ArrayList<Double> list : bucket)
            Collections.sort(list);
        for (ArrayList<Double> list : bucket) {
            if (list.isEmpty())
                continue;
            Iterator<Double> it = list.iterator();
            while (it.hasNext()) {
                double db = it.next();
                System.out.print(db + " ");
            }

        }

    }
}

