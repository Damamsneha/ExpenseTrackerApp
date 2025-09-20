package anshu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int graph[][]=new int[][] {{2,4,0,7,5,4},{3,4,5,6,7,1},{4,3,1,6,9,6},
{5,6,7,0,1,3},{4,9,1,0,4,0},{1,5,8,0,3,1}};
Graph_Shortest_Path g = new Graph_Shortest_Path();
g.algo_dijsktra(graph,0);
	}

}
