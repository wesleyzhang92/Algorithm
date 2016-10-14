package orderstatistics;

/**
 * Created by wesley on 2016/10/7.
 */
import java.util.Random;

public class RandomSelect {

    //从A[p,r]中找到第i小的元素，递归形式
    public int random_select(int[] nums,int p,int r,int i){
        if(p==r)
            return nums[p];
        int q = randomized_partition(nums,p,r);
        int k = q - p + 1;
        if(i==k)
            return nums[q];
        else if(i<k)
            return random_select(nums,p,q-1,i);
        else return random_select(nums,q+1,r,i-k);
    }

    //从A[p,r]中找到第i小的元素，循环形式
    public int random_select_loop(int[] nums,int p,int r,int i){
        while(i>0 && i<=r-p+1){
            int q = randomized_partition(nums,p,r);
            int k = q - p + 1;
            if(i==k)
                return nums[q];
            else if(i<k){
                r = q-1;
            }
            else{
                p = q+1;
                i = i-k;
            }
        }
        return Integer.MAX_VALUE;
    }
    public void exchange(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public int partition(int[] nums,int p,int r){
        int x = nums[r];
        int i = p-1;
        for(int j=p;j<r;j++){
            if(nums[j]<=x){
                i++;
                exchange(nums,i,j);
            }
        }
        exchange(nums,i+1,r);
        return i+1;
    }

    public int partition2(int[] nums,int p,int r,int x){
        for(int j=p;j<r;j++){
            if(nums[j]==x){
                exchange(nums,r,j);
                break;
            }
        }
        return partition(nums,p,r);
    }

    public int randomized_partition(int[] nums,int p,int r){
        Random rand = new Random(100);
        int i = rand.nextInt(r-p)+p;
        exchange(nums,r,i);
        return partition(nums,p,r);
    }

    public static void main(String[] args){
        int[] num={6,3,4,2,5,1,1,1,1,4,5,6};
        RandomSelect rs = new RandomSelect();
        int result = rs.random_select_loop(num, 0, num.length-1, 6);
        System.out.println(result);
    }
}

