package dataStructures.Graph;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        boolean vis[]=new boolean[n];
        Queue<Integer> q= new LinkedList<Integer>();
        vis[0]=true;
        for(Integer x:rooms.get(0)){
            q.add(x);
            vis[x]=true;
        }
        while(!q.isEmpty()){
            int front = q.poll();
            for(Integer x:rooms.get(front)){
                if(vis[x]==false){
                    q.add(x);
                    vis[x]=true;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i]==false)
                return false;
        }
        return true;
    }
}
