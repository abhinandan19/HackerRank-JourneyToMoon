package journeytomoon;

import java.util.*;
/**
 *
 * @author Abhinandan
 */
public class Solution {
    private static HashMap<Integer,ArrayList<Integer>> edgeMap = new HashMap<Integer,ArrayList<Integer>>();
    private static int[] cantPair = new int[1];
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int I = in.nextInt();
        
        for(int i=0;i<I;i++){
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            
                if(edgeMap.containsKey(n1)){
                    edgeMap.get(n1).add(n2);
                }
                else{
                    ArrayList<Integer> edge = new ArrayList<Integer>();
                    edge.add(n2);
                    edgeMap.put(n1, edge);
                }
                
                if(edgeMap.containsKey(n2)){
                    edgeMap.get(n2).add(n1);
                }
                else{
                    ArrayList<Integer> edge = new ArrayList<Integer>();
                    edge.add(n1);
                    edgeMap.put(n2, edge);
                }
        }
        
        visited = new boolean[N];
        long notPos = 0;
        
        for(int i=0;i<N;i++){           
            if(!visited[i]){    
                dfs(i);
                if(cantPair[0] != 0){
                    int x = cantPair[0]+1;
                    notPos += (long) (x-1) * x/2;
                }
                cantPair[0] = 0;
            }
        }
        
        long allPos = (long)(N-1) * N/2;
        long canPair = allPos - notPos;
        
        System.out.println(canPair);
        
    }
    
    public static void dfs(int node){
            visited[node] = true;
            if(edgeMap.containsKey(node)){
                for(int neighbour : edgeMap.get(node)){
                    if(!visited[neighbour]){
                        cantPair[0]++;
                        dfs(neighbour);
                    }
                }
            }
    }
}
