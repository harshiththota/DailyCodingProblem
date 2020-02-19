package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 19/02/20, Wed
 **/

/*
Link to Problem Statement: https://github.com/vaskoz/dailycodingproblem-go/issues/553
 */


public class FindElementInSortedArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int noOfTests = sc.nextInt();

        for(int test = 0; test < noOfTests; test++){

            int length = sc.nextInt();

            int[] numbers = new int[length];
            for(int index = 0; index < length; index++){
                numbers[index] = sc.nextInt();
            }

            int element = sc.nextInt();

            Arrays.sort(numbers);

            System.out.println(findMissingElement(numbers, element,0, length-1));
        }
    }

    public static int findMissingElement(int[] numbers, int element, int left, int right){

        if(left > right)
            return -1;

        int mid = getMid(left, right);

        if(numbers[mid] == element)
            return mid+1;

        else if(element < numbers[mid])
            return findMissingElement(numbers, element, left, mid-1);

        return findMissingElement(numbers, element, mid+1, right);

    }

    public static int getMid(int left, int right){

        int sum = left+right;
        int count = 0;
        while(sum -2 >= 0){
            count++;
            sum-=2;
        }
        return count;

    }
}

