/*
*author: harshithThota
*date: 09-02-2020
*/
vector<int> Solution::solve(vector<vector<int> > &A, vector<int> &B, vector<int> &C, vector<int> &D, vector<int> &E) {

    vector<int> result;
    long long int prefixMatrix[A.size()][A[0].size()];
    int index1,index2;
    
    for(index1=0;index1<A.size();index1++) {
        for(index2=0;index2<A[index1].size();index2++) {
            if (index1==0) {
                if (index2==0) {
                    prefixMatrix[index1][index2] =A[index1][index2];
                } else {
                    prefixMatrix[index1][index2] = prefixMatrix[index1][index2-1] + A[index1][index2];
                }
            } else {
                if(index2==0) {
                    prefixMatrix[index1][index2] = prefixMatrix[index1-1][index2] + A[index1][index2];
                } else {
                    prefixMatrix[index1][index2] = prefixMatrix[index1-1][index2]+prefixMatrix[index1][index2-1]- prefixMatrix[index1-1][index2-1] + A[index1][index2];
                }
            }
        }
    }
    
    int index;
    long long res;
    
    for(index=0;index<B.size();index++) {
        res = 0;
        res += prefixMatrix[D[index] -1][E[index]-1];
        
        if(B[index] > 1) {
             res -= prefixMatrix[B[index]-2][E[index] -1];
        }
        
        if (C[index] > 1) {
            res -= prefixMatrix[D[index] -1][C[index] -2];
        }
        
        if (B[index] > 1 && C[index] > 1) {
              res += prefixMatrix[B[index] -2][C[index] -2];
        }
        
        while(res<0)
            res+=1000000007;
        res=res%1000000007;

        result.push_back(res);
    }
    
    return result;
}
