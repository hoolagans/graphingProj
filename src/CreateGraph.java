/**
 * 
 */

/**
 * @author pizza
 *
 */
public class CreateGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		grapher a = new AdjMatrix();
		a = a.create();
		a.addEdge(1, 2);
		a.addVert();
		System.out.print(a.neighbors(1, 10));
	}

}
