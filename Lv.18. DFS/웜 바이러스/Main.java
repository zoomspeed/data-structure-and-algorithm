import java.util.*;

public class Main{
  static int N;
  static int M;
  static final int MAX = 150;
  //static final int MMAX = 100050;
  static int x;
  static int y;
  static boolean visited[] = new boolean[MAX];
  static int count = -1;
  //static int mark[] = new int[MAX]; 
  static ArrayList<Integer>[] list = new ArrayList[MAX];
  //static boolean answer = true;
  //static boolean matrix[][] = new boolean[NMAX][MMAX];
    public static void main(String[] args){

       // Please Enter Your Code Here

       Scanner sc = new Scanner(System.in);
       
       
       N = sc.nextInt();
       M = sc.nextInt();
       

       
       for(int i=0; i<MAX; i++){
    	   
    	   list[i] = new ArrayList<Integer>();
    	   



       }      

       
       for(int i=0; i<M; i++){
         
         x = sc.nextInt();
         y = sc.nextInt();
         
         list[x].add(y);

         list[y].add(x);
       }
       
       //System.out.println(list.get(0).get(0));
       
       
       dfs(1);
       
       System.out.println(count);
       
/*       
       for(int i=0; i<list.size(); i++){
         
    	  
         for(int j=0; j<list.get(i).size(); j++){
           
        	System.out.print(list.get(i).get(j));
         }
         System.out.println();
       }
       
       
       */
       
/*       
       for(int i=0;i<N;i++) { 
           Iterator<Integer> iter = list.get(i).iterator();
           System.out.print(i);
           if(iter.hasNext()) System.out.print("-");
           while(iter.hasNext()) System.out.print(iter.next() + " ");
           System.out.println("");
       }*/


    }
	public static void dfs(int node) {
		
		int current = 0;
		
		
		visited[node] = true;
		
		count++;

		
		for(int i=0; i<list[node].size(); i++) {
			
			current = list[node].get(i);
			//System.out.println(current);
			if(!visited[current]){
				dfs(current);
			}

		}
	}
	    
    
}

