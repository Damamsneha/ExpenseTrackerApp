package anshu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Graph_Shortest_Path {
static final int num_vertices=6;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int minDistance(int path_array[],Boolean SptSet[] ){
int min=Integer.MAX_VALUE;
int min_index=-1;
for(int v=0;v<num_vertices;v++) {
	if(SptSet[v]==false&&path_array[v]<=min) {
	min=path_array[v];
	min_index=v;
	}
}
return min_index;
}
void printMinPath(int path_array[]) {
	System.out.println("vertex    distance" );
	for(int i=0;i<num_vertices;i++)
		System.out.println(i+"\t\t\t"+path_array[i]);
}
void algo_dijsktra(int graph[][],int src_node) {
	 int path_array[] = new int [num_vertices];
	 Boolean SptSet[]=new Boolean[num_vertices];
	 for(int v=0;v<num_vertices;v++) {
		 path_array[v]=Integer.MAX_VALUE;
		 SptSet[v]=false;
	 }
	 path_array[src_node]=0;
	 for(int count=0;count<num_vertices-1;count++) {
	int u = minDistance(path_array,SptSet);
	 SptSet[u]=true;
	 for(int v=0;v<num_vertices;v++)
		 if(!SptSet[v]&&graph[u][v]!=0&&path_array[u]!=Integer.MAX_VALUE&&path_array[u]+graph[u][v]<path_array[v])
			 path_array[v]=path_array[u]+graph[u][v];
}
	 printMinPath(path_array);	 
}

}
