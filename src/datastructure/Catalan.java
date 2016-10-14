package datastructure;

/**
 * Created by wesley on 2016/10/12.
 */
import java.util.*;

import java.math.BigInteger;

public class Catalan {  //求卡特兰数

    public static void main(String[] args){
        for (int i = 1; i <= 50; i++) {
        System.out.println(i + "'s Catalan Number is " + CatalanNumber(i));
        }

        int numberOfCatalan = 101; //要求多少个卡特兰数

        BigInteger[] digis = new BigInteger[numberOfCatalan];

        digis = generateCatalan(numberOfCatalan);


        Scanner scanner = new Scanner(System.in);


        int number;

        while(true) {
            number = scanner.nextInt();
            if(number == -1)
                break;
            String answer = digis[number].toString();
            System.out.println(answer);
        }
    }

    //使用递归的方式解决卡特兰数
    public static double CatalanNumber(int n) {
        if (n == 1) {
        return 1;
        }
        else {
        return CatalanNumber(n - 1) * 2 * (2 * n - 1) / (n + 1);
        }
        }

    static BigInteger[] generateCatalan(int numberOfCatalan) {
        //产生卡特兰数
        BigInteger digis[] = new BigInteger[numberOfCatalan + 1];

        BigInteger x = new BigInteger("1"); //第一个卡特兰数为1


        digis[1] = x;

        int y = 0;

        int z = 0;


        for(int counter = 2; counter <= numberOfCatalan; ++ counter) {

            y = 4 * counter - 2;

            z = counter + 1;

            digis[counter] = digis[counter-1].multiply(new BigInteger("" + y));
            digis[counter] = digis[counter].divide(new BigInteger("" + z));
        }
        return digis;
    }
}

