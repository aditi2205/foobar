import java.util.Queue;
import java.util.LinkedList;
public class Solution {

    static class Pair{
        int x;
        int y;
        int dis;
        Pair(int i, int j, int w){
            this.x = i;
            this.y = j;
            this.dis = w;
        }
    }
    
    public static int solution(int src, int target){
       
        int x = src/8;
        int y = src%8;
        int tx = target/8;
        int ty = target%8;
        
        int [][] vis = new int[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++)
                vis[i][j] = 0;
        }
       
        int val = getsteps(x,y,tx,ty,vis);
        return val;
    }
    
    static int[] row = {2,2,-2,-2,1,1,-1,-1};
    static int[] col = {1,-1,-1,1,2,-2,2,-2};

    public static boolean isValid(int x, int y){
        if(x<0 || x>7 || y<0 || y>7)
            return false;
        return true;
    }

    public static int getsteps(int x, int y, int tx, int ty, int[][] vis) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y,0));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            //System.out.println(curr.x+" "+curr.y+" "+curr.dis);

            if(curr.x==tx && curr.y==ty){
                return curr.dis;
            }
            
           for(int i=0; i<row.length; i++){
                int a = curr.x+row[i];
                int b = curr.y+col[i];
                if(isValid(a,b) && (vis[a][b]==0)){
                    vis[a][b]=1;
                    q.add(new Pair(a,b,curr.dis+1));
                }
                
           }
       }

       return -1;
       
        
    }

    public static void main(String[] args){

        System.out.println(solution(19,36));

    }
}