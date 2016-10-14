package hash;

import java.util.Random;

import static java.lang.Math.sqrt;

/**
 * Created by wesley on 2016/10/12.
 */
public class OpenAddressingHash {

    public int hash_div1(int k, int m)//选m的值常常是不接近2的幂的质数。
    {
        return k % m;
    }

    public int hash_mul(int k) {
        double A = (sqrt(5) - 1) / 2.0;
        int m = 100;//对于m没有特别要求。m一般选择为2的某个幂。
        return (int) (A * k - (int) (A * k)) * m;
    }

    //全域散列 P为质数
    int hash_Universal(int k, int p) {
        Random rand = new Random();
        int a = 0, b = 0, flag = 0;
        int m = 6;//m不一定非是质数。
        if (flag == 0) {
            a = rand.nextInt() % (p - 1) + 1;
            b = rand.nextInt() % p;
            flag = 1;
        }
        return ((a * k + b) % p) % m;
    }

    //线性探查
    public int LineProbe(int k, int m, int i) {
        return (hash_div1(k, m) + i) % m; //选m的值常常是不接近2的幂的质数。
    }

    //二次探查
    public int QuadraticProbing(int k, int m, int i) {
        int c1 = 1, c2 = 3;
        return (hash_div1(k, m) + c1 * i + c2 * i * i) % m; //其中常数c1,c2,m的值的选择是受限制的
    }

    //双重探查
    public int DoublefunProbing(int k, int m, int i) {
        return (hash_div1(k, m) + i * (1 + hash_div1(k, m - 1))) % m;
    }

    public int hash_insert1(int T[], int m, int k) {
        int i = 0;
        do {
            int j = LineProbe(k, m, i);//这里可以替换成二次，双重探查。插入，查找，删除函数同时被替换
            if (T[j] == -1 || T[j] == -2) {
                T[j] = k;
                return j;
            } else i++;
        } while (i != m);
        System.out.println("hash table overflow");
        return -1;
    }

    public int hash_insert2(int T[], int m, int k) {
        int i = 0;
        do {
            int j = QuadraticProbing(k, m, i);//这里可以替换成二次，双重探查。插入，查找，删除函数同时被替换
            if (T[j] == -1 || T[j] == -2) {
                T[j] = k;
                return j;
            } else i++;
        } while (i != m);
        System.out.println("hash table overflow");
        return -1;
    }

    public int hash_insert3(int T[], int m, int k) {
        int i = 0;
        do {
            int j = DoublefunProbing(k, m, i);//这里可以替换成二次，双重探查。插入，查找，删除函数同时被替换
            if (T[j] == -1 || T[j] == -2) {
                T[j] = k;
                return j;
            } else i++;
        } while (i != m);
        System.out.println("hash table overflow");
        return -1;
    }

    public int hash_search(int T[],int m,int k)
    {
        int i=0,j=0;
        do
        {
            j=LineProbe(k,m,i);//这里可以替换成二次，双重探查。插入，查找，删除函数同时被替换
            if (T[j]==k)
            {
                return j;
            }
            else i++;
        } while (T[j]!=-1||i!=m);
        return -1;
    }
    void hash_delete(int T[],int m,int k)
    {
        int j=hash_search(T,m,k);//首先先找到该关键字k
        if (j!=-1)
        {
            T[j]=-2;//如果找到了，那么设置其为空。
            System.out.println("successful deleted");
        }
        System.out.println("items not in hashtable");
    }
    public static void main(String[] args){
        OpenAddressingHash oah =new OpenAddressingHash();
        int[] a={10,22,31,4,15,28,17,88,59};
        int[] T=new int[11];
        System.out.println("Linear hash");
        for (int i=0;i<11;i++)
        {
            T[i]=-1;
        }
        for( int i=0;i<9;i++)
        {
            oah.hash_insert1(T,11,a[i]);
        }
        for(int i=0;i<11;i++)
        {
            System.out.print(T[i]+" ");
        }
        System.out.println();
        System.out.println("quadratic probing");
        for (int i=0;i<11;i++)
        {
            T[i]=-1;
        }
        for( int i=0;i<9;i++)
        {
            oah.hash_insert2(T,11,a[i]);
        }
        for(int i=0;i<11;i++)
        {
            System.out.print(T[i]+" ");
        }
        System.out.println();
        System.out.println("double hashing");
        for (int i=0;i<11;i++)
        {
            T[i]=-1;
        }
        for( int i=0;i<9;i++)
        {
            oah.hash_insert3(T,11,a[i]);
        }
        for(int i=0;i<11;i++)
        {
            System.out.print(T[i]+" ");
        }
        System.out.println();
        System.out.println(oah.hash_search(T,11,31));
        oah.hash_delete(T,11,31);
        System.out.println(oah.hash_search(T,11,31));

    }
}
