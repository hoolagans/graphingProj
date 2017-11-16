

import java.util.ArrayList;

/**
 * TestGraph.java -- class to execute tests and display generic points, segments, and graphs
 *    for data in a unit-square
 *
 * 
 */


import java.awt.*;
import javax.swing.*;

/**
 * @author A. Thall
 * 11/7/17:  added JFrame setLocationRelativeTo(null) to automatically center window
 */
public class TestGraph extends JFrame
{
    Renderer drawing;
    
    /**
     * instance constructor creates JFrame for rendering
     * -- called in main()
     */
    public TestGraph() {
        
        Container content = this.getContentPane();  // get content pane
        content.setLayout(new BorderLayout());      // set its layout
        drawing = new Renderer(this);  // Create a drawing window in the pain
        content.add(drawing, BorderLayout.CENTER);  // center expands
        
        this.setTitle("Swell Graph Renderer");
        this.pack();             // finalize window layout
    }
    
    int choice = 1;
    //GraphADT mat = null;
    grapher mat= null;
    final int NUMCHOICES = 1;
    
    public void createAndShowPoints() {

    	drawing.clearPoints();
    	drawing.clearEdges();

    	if (choice == 0) {
    		// 0:  create complete WtAdjMatrixGraph
    		//mat = new SimpleGraph(20);
    		//drawing.addGraph(mat);
    		//System.out.println(choice);
    		mat = new AdjGraph();
    		mat = mat.create();
    		for (int i = 0;i<10;i++){
    			mat.addVert();
    			mat.addEdge((int)(10*Math.random()), (int)(10*Math.random()));
    		}
    		drawing.addGraph(mat);
    		choice = (choice + 1) % (NUMCHOICES+1);
    		//System.out.println(choice);
    		this.setTitle("Graph Renderer: the graph!");
    	}
    	else if (choice == 1) {

    		//mat = new AdjMatrix(20);
    		mat = new AdjMatrix();
    		mat = mat.create();
    		//for (int i = 0; i < mat.numVerts() - 1; i++)
    			//for (int j = i+1; j < mat.numVerts(); j += 1)
    		for (int i = 0; i < 10 - 1; i++)
    			for (int j = i+1; j <10; j += 1)
    				mat.addEdge(i, j);
    		drawing.addGraph(mat);
    		choice = (choice + 1) % (NUMCHOICES+1);
    		this.setTitle("Swell Graph Renderer: AdjMatrixGraph!");
    		
    	}

    }

    /**
     * driver method for min-point-distance finder
     * @param args -- optional number of points > 0
     */
    public static void main(String []args) {
        
        JFrame window = new TestGraph();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
        ((TestGraph) window).createAndShowPoints();
    }
}