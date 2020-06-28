public class Solution {
    public static int solution(int start, int length) {
        if(length==1)
        	return start;
        int ele = start;
        int curlength = length;
        int xorsum =0;
        while(curlength>0){
        	//System.out.println(ele+" "+(ele+curlength-1));
        	// xorsum ^= (calcxor(ele)^calcxor(ele+curlength-1));
        	int xorx =0;
        	for(int i=ele; i<=(ele+curlength-1); i++)
        		xorx ^= i;
        	xorsum ^= xorx;
        	ele += length;
        	curlength -= 1;
        }
        return xorsum;
        
    }

    public static int calcxor(int x){
    	if(x==0) return 0;
    	
    	int c = (x)%4;
    	switch(c){
    		case 0: return x;
    		case 1: return 1;
    		case 2: return x+1;
    		case 3: return 0;
    	}
    	return 0;
    }

    public static void main(String[] args){
    	System.out.println(solution(0,3));
    	System.out.println(solution(17,4));
    }
}