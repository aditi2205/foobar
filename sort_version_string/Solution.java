import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Pattern;
public class Solution{
	public static String[] solution(String[] l){
		
		for(int i=0; i<l.length-1; i++){
			for(int j=0; j<l.length-i-1; j++){
				
				String[] a = l[j].split(Pattern.quote("."));
				String[] b = l[j+1].split(Pattern.quote("."));
				
				if(alessthanb(a[0],b[0]))
					swap(l,j,j+1);
				else if(aequalsb(a[0],b[0])){
					if(a.length>1 && b.length>1){
						if(alessthanb(a[1],b[1]))
							swap(l,j,j+1);
						else if(aequalsb(a[1],b[1])){
							if(a.length>2 && b.length>2){
								if(alessthanb(a[2],b[2]))
									swap(l,j,j+1);
								else{
									if(a.length<b.length)
										swap(l,j,j+1);
								}
							}
							else{
								if(a.length<b.length)
										swap(l,j,j+1);
							}
						}

					}
					else{
						if(a.length<b.length)
								swap(l,j,j+1);
					}
				}

			}
		}

		int p = 0;
		int q = l.length-1;
		while(p<=q){
			swap(l,p,q);
			p++;
			q--;
		}

		return l;
	}

	private static void swap(String[] l, int i, int j){
		String temp = l[i];
		l[i] = l[j];
		l[j] = temp; 
	}

	private static boolean alessthanb(String a, String b){
		return (Integer.parseInt(a)<Integer.parseInt(b));
	}
	private static boolean aequalsb(String a, String b){
		return (Integer.parseInt(a)==Integer.parseInt(b));
	}

	public static void main(String[] args){
		String[] l = {"1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"};

		l = solution(l);
		for(int i=0; i<l.length; i++)
			System.out.println(l[i]+" ");
	}
}



	