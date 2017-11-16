/**
 *make two child classes AdjMatrix AdjGraph
 *and AdjListGraph
 *make both of the children of this and fill in each method 
 */

/**
 * @author pizza
 *
 */

public abstract class grapher {
	
	abstract grapher create(int numVerts);
	abstract grapher create();
	
	abstract void addVert();
	
	abstract boolean addEdge(int v1, int v2);
	abstract boolean addEdge(int v1, int v2, double wt);
	
	abstract boolean neighbors(int v1, int v2);
	
	abstract double edgeWt(int v1, int v2);
	
	abstract boolean markVertex(int v1);
	abstract boolean markedVertex(int v1);
	abstract boolean clearVertexMarker(int v1);
	
	abstract boolean clearEdgeMarker(int v1, int v2);
	abstract boolean markEdge(int v1, int v2);
	abstract boolean markedEdge(int v1, int v2);
	abstract boolean[][] getPoints();
	
	
}
