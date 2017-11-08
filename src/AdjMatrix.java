/**
 * 
 */

/**
 * @author pizza
 *
 */
import java.util.ArrayList;
public class AdjMatrix extends grapher{
	//ArrayList<grapher> a;
	boolean adjMatrix[][];
	boolean vertexMark[];
	boolean edgeMark[][];
	double weight[][];
	int DEFAULT_SIZE = 10;
	
	public grapher create(int numVerts){
		//a = new ArrayList<grapher>(numVerts);
		adjMatrix = new boolean[numVerts][numVerts];
		vertexMark = new boolean[numVerts];
		edgeMark = new boolean[numVerts][numVerts];
		weight = new double[numVerts][numVerts];
		
		//grapher b  = new AdjMatrix();
		return this;
	}
	public grapher create(){
		//a = new ArrayList<grapher>();
		adjMatrix = new boolean[DEFAULT_SIZE][DEFAULT_SIZE];
		vertexMark = new boolean[DEFAULT_SIZE];
		edgeMark = new boolean[DEFAULT_SIZE][DEFAULT_SIZE];
		weight = new double[DEFAULT_SIZE][DEFAULT_SIZE];
		
		return this;
	}
	public void addVert(){
		int newSize = adjMatrix.length+1;
		boolean[][] tmpAdjM = new boolean[newSize][newSize];
		boolean[] tmpVertexMark = new boolean[newSize];
		boolean[][] tmpEdgeMark = new boolean[newSize][newSize];
		double[][] tmpWeight = new double[newSize][newSize];
		
		
		for(int i = 0;i<tmpAdjM.length-1;i++){
			tmpVertexMark[i]=vertexMark[i];
			for(int j = 0; j<tmpAdjM.length-1;j++){
				tmpAdjM[i][j]=adjMatrix[i][j];
				tmpEdgeMark[i][j]=edgeMark[i][j];
				tmpWeight[i][j]=weight[i][j];
			}
		}
		vertexMark = tmpVertexMark;
		adjMatrix = tmpAdjM;
		edgeMark = tmpEdgeMark;
		weight = tmpWeight;
	}
	public boolean addEdge(int v1, int v2){
		if(adjMatrix.length>v1&&adjMatrix.length>v2){
		adjMatrix[v1][v2]=true;
		return true;}
		return false;
		
	}
	public boolean addEdge(int v1, int v2, double wt){
		if(adjMatrix.length>v1&&adjMatrix.length>v2){
		adjMatrix[v1][v2]=true;
		weight[v1][v2]=wt;
		return true;
		}
		return false;
	}
	public boolean neighbors(int v1, int v2){
		return adjMatrix[v1][v2];
	}
	public double edgeWt(int v1, int v2){
		
		return weight[v1][v2];
	}
	public boolean markVertex(int v1){
		if(adjMatrix.length>v1){
		vertexMark[v1]=true;
		return true;}
		return false;
	}
	public boolean markedVertex(int v1){
		
		return vertexMark[v1];
	}
	public boolean clearVertexMarker(int v1){
		if(adjMatrix.length>v1){
		vertexMark[v1]=false;
		return true;}
		return false;
	}
	public boolean markEdge(int v1, int v2){
		if(adjMatrix.length>v1&&adjMatrix.length>v2){
		edgeMark[v1][v2]=true;
		return true;}
		
		return false;
	}
	public boolean markedEdge(int v1, int v2){
		return edgeMark[v1][v2];
	}
	public boolean clearEdgeMarker(int v1, int v2){
		if(adjMatrix.length>v1&&adjMatrix.length>v2){
		edgeMark[v1][v2]=false;
		return true;}
		return false;
	}
}
