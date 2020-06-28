
public class Solution {

    public static int solution(int n) {
        // Your code here
        if(n<3)
        	return 0;
        if(n==3)
        	return 1;

        int[][] cache = new int[201][201];
        for(int i=0; i<cache.length; i++)
        	for(int j=0; j<cache[0].length; j++)
        		cache[i][j] =-1;

        return helper(1,n, cache)-1;
    }

    public static int helper(int curHeight, int n, int[][] cache){

    	if(n==0)
    		return 1;

    	if((n-curHeight)<0)
    		return 0;

    	if(cache[curHeight][n]!=-1)
    		return cache[curHeight][n];

    	cache[curHeight][n]=  helper(curHeight+1, (n-curHeight), cache) + helper(curHeight+1, n, cache);

    	return cache[curHeight][n];

    }

    public static void main(String[] args){
    	System.out.println(solution(5));
    	System.out.println(solution(200));
    }
}