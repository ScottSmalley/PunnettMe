package punnettme;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PunnettGUI extends JPanel implements Runnable
{
	private static final long serialVersionUID = 42L;
	private JFrame window;
	
	public static void main (String [] args)
	{
		SwingUtilities.invokeLater(new PunnettGUI());
	}

	public void run() 
	{
		System.out.println("liek, i'm gud at major hxrers");
		
		Dimension panelSize = new Dimension(800, 600);
		
		window = new JFrame("PunnettMe");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setPreferredSize(panelSize);
		window.setMinimumSize(panelSize);
		
		window.setContentPane(this);
		
		/*
		 * grid layout for jframe, 
		 * 1 cell for p1, 1 cell for p2, 2 cells for output
		 * 
		 * gridbaglayout for the inner portions?
		 */
		
	}
	
}
