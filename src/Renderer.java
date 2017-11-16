
/**
 * Renderer.java -- a general purpose rendering class for rendering
 *   Points, Segments, and Graph vertices
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

/**
 * creates a drawing window to pass Point []  and PointPairs
 */
public class Renderer extends JPanel implements MouseListener
{
    // a Renderer knows its parent frame, so can communicate with code in TestGraph
    TestGraph testGraphFrame;
    
    public static final int HEIGHT = 512;
    public static final int WIDTH = 512;
    
    public static final int OFFSET = 10;
    public static final int XWIN = WIDTH - 2*OFFSET;
    public static final int YWIN = HEIGHT - 2*OFFSET;
    
    public static final int NODESIZE = 8;
    
    ArrayList<Point> points = new ArrayList<Point>();
    ArrayList<Color> pointColors = new ArrayList<Color>();
    
    ArrayList<Segment> segments = new ArrayList<Segment>();
    ArrayList<Color> segmentColors = new ArrayList<Color>();
    
    public Renderer(TestGraph frame) {  // constructor
        
        testGraphFrame = frame;
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.addMouseListener(this);       // listen to mouse events
    }
    
    public void addPoint(Point p) {
        
        points.add(p);
        pointColors.add(Color.WHITE);
        this.repaint();
    }
    
    public void addPoints(Point []p) {
        for (Point pt : p) {
            points.add(pt);
            pointColors.add(Color.WHITE);
        }
        this.repaint();
    }
    
    public void addPoints(Collection<Point> p) {
        for (Point pt : p) {
            points.add(pt);
            pointColors.add(Color.WHITE);
        }
        this.repaint();
    }
    
    public void addSegment(Point a, Point b) {
        segments.add(new Segment(a, b));
        segmentColors.add(Color.GREEN);
        this.repaint();
    }
    
    public void addSegment(Segment e) {
        
        segments.add(e);
        segmentColors.add(Color.GREEN);
        this.repaint();
    }
    
    public void addSegments(Segment []e) {
        
        for (Segment edge : e) {
            segments.add(edge);
            segmentColors.add(Color.GREEN);
        }
        this.repaint();
    }
    
    public void addSegments(Collection<Segment> e) {
        for (Segment edge : e) {
            segments.add(edge);
            segmentColors.add(Color.GREEN);
        }
        this.repaint();
    }
    
    public void addGraph(SpatiallyMapped graph) {
    	
    	for (Point p : graph.vertexIterable())
			addPoint(p);
    	
    	for (Segment s : graph.segmentIterable())
    		addSegment(s.A, s.B);
    }
    public void addGraph(grapher graph){
   //array of points maybe to keep track of all points so that segments can be made.
    boolean matrix[][]=graph.getPoints();
    int size = matrix.length;
    System.out.println(size);
    Point[] pnts = new Point[matrix.length];
    	for(int z = 0; z<matrix.length;z++){
    		pnts[z]=new Point();
    	}
    	for(int i = 0; i<matrix.length;i++){
    		addPoint(pnts[i]);
    		for(int j = 0; j<matrix.length;j++){
    			//if(matrix[i][j]==false){
    				//addPoint(new Point((double)i/size,(double)j/size));
    			//}
    			if(matrix[i][j]==true){
    				//Point a = new Point((double)i/size,(double)j/size);
    				//addPoint(a);
    				//Point b = new Point((double)j/size,(double)j/size);
    				addSegment(new Segment(pnts[i],pnts[j]));
    				//System.out.println(j + " " + i );
    			}
    		}
    	}
    }
    public void clearPoints() {
        
        points.clear();
        pointColors.clear();
        this.repaint();
    }
    
    public void clearEdges() {
        segments.clear();
        segmentColors.clear();
        this.repaint();
    }
    int numTimes = 0;
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    // Paint background, borders
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        g.setColor(Color.GRAY);
        g.drawRect(OFFSET, OFFSET, XWIN, YWIN);
        
        for (int edgenum = 0; edgenum < segments.size(); edgenum++) {
            Segment e = segments.get(edgenum);
            g.setColor(segmentColors.get(edgenum));
            g.drawLine((int) Math.floor(e.A.x*XWIN) + OFFSET,
                       (int) Math.floor(e.A.y*YWIN) + OFFSET,
                       (int) Math.floor(e.B.x*XWIN) + OFFSET,
                       (int) Math.floor(e.B.y*YWIN) + OFFSET);
        }
        
        for (int ptnum = 0; ptnum < points.size(); ptnum++) {
            Point p = points.get(ptnum);
            g.setColor(pointColors.get(ptnum));
            g.fillOval(((int) Math.floor(p.x*XWIN)) + OFFSET - NODESIZE/2,
                       ((int) Math.floor(p.y*YWIN)) + OFFSET - NODESIZE/2,
                       NODESIZE, NODESIZE);
        }
    }
    
    /**
     * bunch of stuff for setting callbacks---mousePressed() only one active,
     *   tells containing TestGraph to create a new pointset, rerun and redisplay
     *   a test, etc.
     */
    // Need to define implementation methods or class will be abstract
    public void mouseClicked(MouseEvent e) {} // ignore
    public void mouseEntered(MouseEvent e) {}  // ignore
    public void mouseExited(MouseEvent e) {}  // ignore
    public void mouseReleased(MouseEvent e) {} // ignore
    
    public void mousePressed(MouseEvent e) {
        testGraphFrame.createAndShowPoints();
        repaint();
    } 
    
}
