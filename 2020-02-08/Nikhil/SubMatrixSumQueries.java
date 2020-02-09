package interviewbit;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 08/02/20, Sat
 **/
public class SubMatrixSumQueries {

    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {

        final int modulo = 1000000007;

        for (int index = 1; index < A.length; index++)
            for (int walker = 0; walker < A[index].length; walker++)
                A[index][walker] = (A[index][walker]+A[index-1][walker])%modulo;

        for(int index = 0; index<A.length; index++)
            for(int walker = 1; walker< A[index].length; walker++) {
                A[index][walker] = ( A[index][walker]+A[index][walker-1])%modulo;
            }

        int[] sum = new int[B.length];
        for(int index = 0; index<B.length; index++){
            int x1 = B[index] - 1;
            int y1 = C[index] - 1;
            int x2 = D[index] - 1;
            int y2 = E[index] - 1;

            if(x1 == 0 && y1 == 0)
                sum[index] = A[x2][y2];
            else if(x1 ==0)
                sum[index] = A[x2][y2] - A[x2][y1-1];
            else if(y1 == 0)
                sum[index] = A[x2][y2] - A[x1-1][y2];
            else
                sum[index] = (A[x2][y2] + A[x1 - 1][y1 - 1] - A[x1 - 1][y2] - A[x2][y1 - 1])%modulo;


            while(sum[index]<0)
                sum[index] += modulo;
            sum[index] = sum[index]%modulo;
        }
        return sum;
    }
}
