package BT;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import structure5.*;


/*
 * A Viewer for Binary Trees.
 */
public class BinaryTreeView<E> extends JPanel {

    /* The tree currently being display */
    protected BinaryTreeNode<E> tree;

    /* The max. height of any tree drawn so far.  This
       is used to avoid the tree jumping around when nodes
       are removed from the tree. */
    protected int maxHeight;

    /* The font for the tree nodes. */
    protected Font font = new Font("Roman", 0, 14);
    
    /* 
     * Create a new window with the given width and height 
     * that is showing the given tree.
     */
    public BinaryTreeView(BinaryTreeNode<E> tree, int width, int height) {

        //Initialize drawing colors, border, opacity.
        setBackground(Color.white);
        setForeground(Color.black);

        // Create window and make it so hitting the close icon
        // will terminate the program
        JFrame f = new JFrame("BinaryTree View");
        f.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        
        f.getContentPane().add(this, BorderLayout.CENTER);
        f.setSize(new Dimension(width, height));
        f.setVisible(true);
        
        // install initial tree.
        setTree(tree);
    }

    /*
     * Set the display to show the given tree.
     */ 
    public void setTree(BinaryTreeNode<E> t) {
        tree = t;
        maxHeight = tree.height;
    }

    /*
     * Invoke this method whenever you would like the window
     * to be refreshed, such as after updating the tree in some
     * way.
     */
    public void refresh() {
        paintImmediately(0,0, getWidth(), getHeight());
    }


    /*
     * Draw the contents of the tree into the given Graphics
     * context.
     * It will place all info between minX and maxX in the x-direction,
     * starting at location y in the y-direction.  Levels of the tree
     * will be separated by yStep pixels.
     */
    protected void drawTree(Graphics g, int minX, int maxX, 
                            int y, int yStep, Node tree) {

        String s = String.valueOf(tree.data);
        
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        int width = fm.stringWidth(s);
        int height = fm.getHeight();

        int xSep = Math.min((maxX - minX)/8, 10);

        g.drawString(s, (minX + maxX)/2 - width/2, y + yStep/2);

        if (tree.left != null) {
            // if left tree not empty, draw line to it and recursively
            // draw that tree
            g.drawLine((minX + maxX)/2 - xSep, y + yStep/2 + 5,
                       (minX + (minX + maxX)/2) / 2, 
                       y + yStep + yStep/2 - height);
            drawTree(g, minX, (minX + maxX)/2, y + yStep, yStep, tree.left);
        }
        if (tree.right != null) {
            // same thing for right subtree.
            g.drawLine((minX + maxX)/2 + xSep, y + yStep/2 + 5,
                       (maxX + (minX + maxX)/2) / 2, 
                       y + yStep + yStep/2 - height);
            drawTree(g, (minX + maxX)/2, maxX, y + yStep, yStep, tree.right);
        }
    }


    /*
     * paint method unherited from the Swing library.  Just
     * calls drawTree whenever the window needs to be repainted.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);      //clears the background
        int width = getWidth();
        int height = getHeight();
        maxHeight = Math.max(tree.height, maxHeight);
        int treeHeight = maxHeight;

        drawTree(g, 0, width, 0, height / (treeHeight + 1), tree.root);

    } 

    /* 
     * Test code.
     */
    public static void main(String s[]) {
       /* BinaryTree<String> tree = new BinaryTree<String>("Hiya", 
                                         new BinaryTree<String>("moo"), 
                                         new BinaryTree<String>("cow"));
        BinaryTree<String> tree2 = new BinaryTree<String>("MOOOOOO", tree, tree);*/
       /* BinaryTreeView<String> btv = new BinaryTreeView<String>(tree2, 400, 400);
        btv.refresh();*/
    }
}
