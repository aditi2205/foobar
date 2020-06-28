
import java.util.Scanner;
public class Solution{
    public static String solution(int i) {
        
        String sb = "";
        int n = 20500;
        boolean [] prime = new boolean[n+1];
        for(int k=0; k<n; k++)
        	prime[k] = true;
        
        for(int p=2; p<=n; p++){
        	if(prime[p]){
	        	for(int j=p*p; j<=n; j+=p ){
	        		prime[j] = false; 
        		}
       	 	}
        }

        for(int k=2; k<=n; k++){
        	if(prime[k]==true){
        		if(sb.length()<=10005)
        			sb+=String.valueOf(k);
        		else
        			break;
        	}
        }

        return sb.substring(i,i+5);
    }

    public static void main(String[] args){
    	Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
    	System.out.println(solution(n));
    }
}