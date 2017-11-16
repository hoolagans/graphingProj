/**
 * SpatiallyMapped.java -- interface for being drawable by our Renderer class
 *
 *
 * 
 * 11/7/17:  Refactored:  removed "abstract" from all methods, from older refactoring from abstract class
 *   to interface.
 *           New BRANCH:  added iterators for more straightforward entry into Renderer
 */


/**
 * +
 *
 */
public interface SpatiallyMapped {

	Point loc(int u);
	int numVerts();
	int numEdges();
	
	Iterable<Point> vertexIterable();
	Iterable<Segment> segmentIterable();
}
