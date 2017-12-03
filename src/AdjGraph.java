import java.util.ArrayList;
//adjacency list graph needs to be implemented, stores a list with all points that it is connected to
//ArrayList<ArrayList<Integer>> AdjList = new ArrayList();
public class AdjGraph extends grapher{
	
	//ArrayList<grapher> a;
	//boolean adjMatrix[][];
	boolean vertexMark[];
	boolean edgeMark[][];
	double weight[][];
	ArrayList<ArrayList<Integer>> AdjList = new ArrayList();
	final int DEFAULT_SIZE = 10;
	public grapher create(int numVerts){
		//a = new ArrayList<grapher>(numVerts);
		//AdjList = new ArrayList(numVerts);
		for (int i = 0;i<numVerts;i++){
			AdjList.add(new ArrayList<Integer>());	
		}
		
		vertexMark = new boolean[numVerts];
		edgeMark = new boolean[numVerts][numVerts];
		weight = new double[numVerts][numVerts];
		//grapher b  = new AdjMatrix();
		return this;
	}
	public grapher create(){
		//AdjList = new ArrayList(DEFAULT_SIZE);
		vertexMark = new boolean[DEFAULT_SIZE];
		edgeMark = new boolean[DEFAULT_SIZE][DEFAULT_SIZE];
		weight = new double[DEFAULT_SIZE][DEFAULT_SIZE];
		for(int i = 0;i<DEFAULT_SIZE;i++){
			AdjList.add(new ArrayList<Integer>());
		}
		System.out.println(AdjList.size());
		return this;
	}
	public void addVert(){
		int newSize = AdjList.size()+1;
		//ArrayList<ArrayList<Integer>> tmpAdjL = new ArrayList();
		boolean[] tmpVertexMark = new boolean[newSize];
		boolean[][] tmpEdgeMark = new boolean[newSize][newSize];
		double[][] tmpWeight = new double[newSize][newSize];
		AdjList.add(new ArrayList<Integer>());
		
		for(int i = 0;i<AdjList.size()-1;i++){
			tmpVertexMark[i]=vertexMark[i];
			for(int j = 0; j<AdjList.size()-1;j++){
				//tmpAdjL.add(AdjList.get(i));
				tmpEdgeMark[i][j]=edgeMark[i][j];
				tmpWeight[i][j]=weight[i][j];
			}
		}
		vertexMark = tmpVertexMark;
		//sAdjList = tmpAdjL;
		edgeMark = tmpEdgeMark;
		weight = tmpWeight;
	}
	public boolean addEdge(int v1, int v2){
		
		if(AdjList.size()>v1&&AdjList.size()>v2){
			AdjList.get(v1).add(v2);
			return true;}
			return false;
	}
	public boolean addEdge(int v1, int v2, double wt){
		if(AdjList.size()>v1&&AdjList.size()>v2){
			AdjList.get(v1).add(v2);
			weight[v1][v2]=wt;
			return true;
			}
			return false;
	}
	public boolean neighbors(int v1, int v2){
		for(int i =0;i<AdjList.get(v1).size();i++){
			if(AdjList.get(v1).get(i)==v2){
				return true;
			}
		}
		return false;
	}
	public double edgeWt(int v1, int v2){
		
		return weight[v1][v2];
	}
	public boolean markVertex(int v1){
		if(AdjList.size()>v1){
			vertexMark[v1]=true;
			return true;}
			return false;
	}
	public boolean markedVertex(int v1){
		
		return vertexMark[v1];
	}
	public boolean clearVertexMarker(int v1){
		if(AdjList.size()>v1){
			vertexMark[v1]=false;
			return true;}
			return false;
	}
	public boolean markEdge(int v1, int v2){
		if(AdjList.size()>v1&&AdjList.size()>v2){
			edgeMark[v1][v2]=true;
			return true;}
			
			return false;
	}
	public boolean markedEdge(int v1, int v2){
		return edgeMark[v1][v2];
	}
	public boolean clearEdgeMarker(int v1, int v2){
		if(AdjList.size()>v1&&AdjList.size()>v2){
			edgeMark[v1][v2]=false;
			return true;}
			return false;
	}
	public boolean[][] getPoints(){
		boolean adjMatrix[][]=new boolean[AdjList.size()][AdjList.size()];
		for (int i =0;i<AdjList.size();i++){
			for(int j = 0;j<AdjList.size();j++){
				adjMatrix[i][j]=false;
			}
			for(int j = 0; j<AdjList.get(i).size();j++){
				adjMatrix[i][AdjList.get(i).get(j)]=true;
			}
		}
		return adjMatrix;
		
	}
	

}
