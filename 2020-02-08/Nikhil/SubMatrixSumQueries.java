package interviewbit;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 08/02/20, Sat
 **/
public class SubMatrixSumQueries {

    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {

        final long modulo = 1000000007L;

        long first = 0L;
        long second = 0L;

        for (int index = 1; index < A.length; index++)
            for (int walker = 0; walker < A[index].length; walker++) {
                first = A[index][walker];
                second = A[index-1][walker];
                A[index][walker] = (int)((first+second)%modulo);
            }

        for(int index = 0; index<A.length; index++)
            for(int walker = 1; walker< A[index].length; walker++) {
                first = A[index][walker];
                second = A[index][walker-1];
                A[index][walker] = (int)((first+second)%modulo);
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
            else {
                first = A[x2][y2];
                second = A[x1 - 1][y1 - 1];
                sum[index] = (int)((first+second - A[x1 - 1][y2] - A[x2][y1 - 1])%modulo);
            }
        }
        return sum;
    }
}
