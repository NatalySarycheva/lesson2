package lesson_2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        int[] abc = task1(array);
        System.out.println(Arrays.toString(abc));
        task2();
        int[] array3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int[] abc3 = task3(array3);
        System.out.println(Arrays.toString(abc3));
        int[] array4min = { 25, 5, 3, 2, 11, 65, 12, 7, 4, 8, 9 };
        System.out.println(task4min(array4min));
        int[] array4max = { 1, 5, 3, 2, 11, 65, 12, 7, 4, 8, 9 };
        System.out.println(task4max(array4max));
        int[][] square = task5(5);
        printArr(square);
    }

    public static int[] task1 (int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i]==0){
                a[i]=1;
            }else {
                a[i]=0;
            }
        }
        return a;
    }

    public static void task2 () {
        int[] arr  = new int[8] ;
        for ( int c = 0; c < 8; c++) {
            if ( c == 0 ) {
                arr[c] = 1;
            } else {
                arr[c] = arr[c - 1] + 3;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] task3 (int[] d) {
        for ( int x = 0; x < d.length; x++ ) {
            if ( d[x] < 6) {
                d[x] = d[x]*2;
            }
        }
        return d;
    }

    public static int task4min (int[] f) {
        int min = f[0];
        for ( int y = 1; y < f.length; y++ ) {
            if ( f[y] < min ) {
                min = f[y];
            }
        }
        return min;
    }

    public static int task4max (int[] k) {
        int max = k[0];
        for ( int z = 1; z < k.length; z++) {
            if ( k[z] > max ) {
                max = k[z];
            }
        }
        return max;
    }
    public static int[][] task5 (int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    result[i][j] = 1;
                    result[i][n-j-1] = 1;
                }
            }
        }
        return result;
    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}

