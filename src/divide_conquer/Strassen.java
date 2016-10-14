package divide_conquer;

/**
 * Created by wesley on 2016/10/3.
 */

//Strassen矩阵乘法

import java.util.*;

public class Strassen{

    public Strassen(){
        A = new int[NUMBER][NUMBER];
        B = new int[NUMBER][NUMBER];
        C = new int[NUMBER][NUMBER];
    }

    /**
     * 输入矩阵函数
     * */
    public void input(int a[][]){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
    }

    /**
     * 输出矩阵
     * */
    public void output(int[][] result){
        for(int b[] : result) {
            for(int temp : b) {
                System.out.print(temp + "   ");
            }
            System.out.println();
        }
    }

    /**
     * 矩阵乘法，此处只是定义了2*2矩阵的乘法
     * */
    public void Mul(int[][] first, int[][] second, int[][] result){
        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < 2; ++j) {
                result[i][j] = 0;
                for(int k = 0; k < 2; ++k) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }

    }

    /**
     * 矩阵的加法运算
     * */
    public void Add(int[][] first, int[][] second, int[][] result){
        for(int i = 0; i < first.length; i++) {
            for(int j = 0; j < first[i].length; j++) {
                result[i][j] = first[i][j] + second[i][j];
            }
        }
    }

    /**
     * 矩阵的减法运算
     * */
    public void sub(int[][] first, int[][] second, int[][] result){
        for(int i = 0; i < first.length; i++) {
            for(int j = 0; j < first[i].length; j++) {
                result[i][j] = first[i][j] - second[i][j];
            }
        }
    }

    /**
     * strassen矩阵算法
     * */
    public void strassen(int[][] A, int[][] B, int[][] C){
        //定义一些中间变量
        int [][] M1=new int [NUMBER][NUMBER];
        int [][] M2=new int [NUMBER][NUMBER];
        int [][] M3=new int [NUMBER][NUMBER];
        int [][] M4=new int [NUMBER][NUMBER];
        int [][] M5=new int [NUMBER][NUMBER];
        int [][] M6=new int [NUMBER][NUMBER];
        int [][] M7=new int [NUMBER][NUMBER];

        int [][] C11=new int [NUMBER][NUMBER];
        int [][] C12=new int [NUMBER][NUMBER];
        int [][] C21=new int [NUMBER][NUMBER];
        int [][] C22=new int [NUMBER][NUMBER];

        int [][] A11=new int [NUMBER][NUMBER];
        int [][] A12=new int [NUMBER][NUMBER];
        int [][] A21=new int [NUMBER][NUMBER];
        int [][] A22=new int [NUMBER][NUMBER];

        int [][] B11=new int [NUMBER][NUMBER];
        int [][] B12=new int [NUMBER][NUMBER];
        int [][] B21=new int [NUMBER][NUMBER];
        int [][] B22=new int [NUMBER][NUMBER];

        int [][] temp=new int [NUMBER][NUMBER];
        int [][] temp1=new int [NUMBER][NUMBER];



        if(A.length==2){
            Mul(A, B, C);
        }else{
            //首先将矩阵A，B 分为4块
            for(int i = 0; i < A.length/2; i++) {
                for(int j = 0; j < A.length/2; j++) {
                    A11[i][j]=A[i][j];
                    A12[i][j]=A[i][j+A.length/2];
                    A21[i][j]=A[i+A.length/2][j];
                    A22[i][j]=A[i+A.length/2][j+A.length/2];
                    B11[i][j]=B[i][j];
                    B12[i][j]=B[i][j+A.length/2];
                    B21[i][j]=B[i+A.length/2][j];
                    B22[i][j]=B[i+A.length/2][j+A.length/2];
                }
            }
            //计算M1
            sub(B12, B22, temp);
            Mul(A11, temp, M1);
            //计算M2
            Add(A11, A12, temp);
            Mul(temp, B22, M2);
            //计算M3
            Add(A21, A22, temp);
            Mul(temp, B11, M3);
            //M4
            sub(B21, B11, temp);
            Mul(A22, temp, M4);
            //M5
            Add(A11, A22, temp1);
            Add(B11, B22, temp);
            Mul(temp1, temp, M5);
            //M6
            sub(A12, A22, temp1);
            Add(B21, B22, temp);
            Mul(temp1, temp, M6);
            //M7
            sub(A11, A21, temp1);
            Add(B11, B12, temp);
            Mul(temp1, temp, M7);

            //计算C11
            Add(M5, M4, temp1);
            sub(temp1, M2, temp);
            Add(temp, M6, C11);
            //计算C12
            Add(M1, M2, C12);
            //C21
            Add(M3, M4, C21);
            //C22
            Add(M5, M1, temp1);
            sub(temp1, M3, temp);
            sub(temp, M7, C22);

            //结果送回C中
            for(int i = 0; i < C.length/2; i++) {
                for(int j = 0; j < C.length/2; j++) {
                    C[i][j]=C11[i][j];
                    C[i][j+C.length/2]=C12[i][j];
                    C[i+C.length/2][j]=C21[i][j];
                    C[i+C.length/2][j+C.length/2]=C22[i][j];
                }
            }


        }

    }

    public static void main(String[] args){
        Strassen demo=new Strassen();
        System.out.println("输入矩阵A");
        demo.input(A);
        System.out.println("输入矩阵B");
        demo.input(B);
        demo.strassen(A, B, C);
        demo.output(C);
    }

    private static int A[][];
    private static int B[][];
    private static int C[][];
    private final static int NUMBER = 4;
}
