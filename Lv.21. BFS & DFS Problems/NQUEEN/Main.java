import java.util.*;

public class Main {

	static int N = 0;
	static int MAX = 15;
	static int cols[] = new int[MAX];
	static int dx[] = {-1,1,-1,1,0,0,-1,1};
	static int dy[] = {-1,-1,1,1,-1,1,0,0};
	static int answer = 0;
	static int ans[] = new int[2];
	static int visited[] = new int[MAX];
	static boolean even = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();

		dfs(0);
		System.out.println(answer);
	}
	
	public static void dfs(int y){
		
		if(y==N){
			answer++;
		}		
		for(int i=0; i<N; i++){
			int x = i;
			
			if(check(y,i)){
				visited[y] = i;
				dfs(y+1);
			}
		}
		visited[y] = -1;		
	}

	public static boolean check(int y, int x){
		
		if(y==0){
			return true;
		}
		for(int i=0; i<y; i++){
			
			if(visited[i]==x){
				
				return false;
				
			}
			if(x == visited[i]-(y-i) || x==visited[i]+(y-i)){
				
				return false;
			}
		}
		
		return true;		
	}

	public static void vreset(){
		
		for(int i=0; i<N; i++){
			
			visited[i] = -1;
		}		
	}
}