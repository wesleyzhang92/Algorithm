package IntroductiontoAlgorithm.orderstatistics;

/**
 * Created by wesley on 2016/10/7.
 */

import IntroductiontoAlgorithm.util.Utils;

import java.util.Arrays;
import java.util.Scanner;


public class KthQuantile {

    public void kth_quantile_tradition(int[] nums,int[] result,int k){
        RandomSelect rs =new RandomSelect();
        if(nums.length % k != 0)
            return;
        int n = nums.length/k;
        for(int i=0;i<k-1;i++){
            int r=rs.random_select(nums, 0, nums.length-1, (i+1)*n);
            result[i]=r;
        }
    }


    public void kth_quantile(int[] nums,int[] result,int p,int r,int k,int t){
        if(k==0)
            return;
        if(r>p){
            int rank = k == 1 ? k * t : k / 2 * t;
            RandomSelect rs = new RandomSelect();
            int x =rs.random_select(nums, p, r,rank);
            result[(rank + p) / t - 1]=x;
            if (k == 1) {
                return;
            }
            int q = Utils.indexOf(nums, p, r, x);
            kth_quantile(nums,result,p,q,k/2,t);
            kth_quantile(nums,result,q+ 1, r, k - (int)(k / 2),t);
        }
        else
            return;
    }

    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        int k = cin.nextInt();
        int[] nums={6,3,4,2,5,1,8,7};
        int[] result =new int[k];
        int[] result1 = new int[k];
        if (nums.length % k != 0) {
            throw new IllegalArgumentException("The data set can be seprated into k subsets.");
        }
        KthQuantile kq = new KthQuantile();
        kq.kth_quantile_tradition(nums, result, k);
        kq.kth_quantile(nums,result1,0,nums.length-1,k,nums.length/k);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));

    }
}

