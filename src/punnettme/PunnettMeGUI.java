package punnettme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.DropMode;

public class PunnettMeGUI {

	private JFrame window;
	private JTextField geneOnePOneTF;
	private JTextField geneTwoPOneTF;
	private JTextField geneThreePOneTF;
	private JTextField geneFourPOneTF;
	private JTextField geneFivePOneTF;
	private JTextField geneOnePTwoTF;
	private JTextField geneTwoPTwoTF;
	private JTextField geneThreePTwoTF;
	private JTextField geneFourPTwoTF;
	private JTextField geneFivePTwoTF;

	private Color textColor = Color.WHITE;
	private Color backgroundColor = Color.DARK_GRAY;
	private Color textFieldColor = Color.GRAY;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PunnettMeGUI window = new PunnettMeGUI();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PunnettMeGUI() {
		initialize();
	}

	/* Builds the GUI.
	 * 
	 * GUI variable layout breakdown:
	 * Ex: geneOnePOneLabel
	 * 
	 * geneOne = First Gene identifier
	 * POne = Parent One identifier
	 * Label == Description of the Object
	 */
	private void initialize() {
		
		//Window 
		window = new JFrame();
		window.setBackground(Color.DARK_GRAY);
		window.setTitle("PunnettMe");
		window.setBounds(100, 100, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		window.getContentPane().setLayout(gridBagLayout);
		
		//Main Content Panel (includes everything)
		JPanel content = new JPanel();
//		content.setForeground(Color.BLACK);
		GridBagConstraints gbc_content = new GridBagConstraints();
		gbc_content.gridwidth = 0;
		gbc_content.fill = GridBagConstraints.BOTH;
		gbc_content.gridheight = 0;
		gbc_content.weighty = 1.0;
		gbc_content.weightx = 1.0;
		gbc_content.gridx = 0;
		gbc_content.gridy = 0;
		window.getContentPane().add(content, gbc_content);
		GridBagLayout gbl_content = new GridBagLayout();
		gbl_content.columnWidths = new int[]{196, 196, 196, 0};
		gbl_content.rowHeights = new int[]{547, 0};
		gbl_content.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_content.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		content.setLayout(gbl_content);
		
	//Parent One Column
		JPanel parentOne = new JPanel();
		parentOne.setBackground(backgroundColor);
		parentOne.setForeground(backgroundColor);
		GridBagConstraints gbc_parentOne = new GridBagConstraints();
		gbc_parentOne.weighty = 1.0;
		gbc_parentOne.weightx = 0.2;
		gbc_parentOne.fill = GridBagConstraints.BOTH;
		gbc_parentOne.gridx = 0;
		gbc_parentOne.gridy = 0;
		content.add(parentOne, gbc_parentOne);
		GridBagLayout gbl_parentOne = new GridBagLayout();
		gbl_parentOne.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_parentOne.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_parentOne.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_parentOne.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		parentOne.setLayout(gbl_parentOne);
	
		//Parent One Label
		JLabel parentOneLabel = new JLabel("Parent One");
		parentOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		parentOneLabel.setBackground(backgroundColor);
		parentOneLabel.setForeground(textColor);
		GridBagConstraints gbc_parentOneLabel = new GridBagConstraints();
		gbc_parentOneLabel.gridwidth = 4;
		gbc_parentOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_parentOneLabel.weightx = 1.0;
		gbc_parentOneLabel.fill = GridBagConstraints.BOTH;
		gbc_parentOneLabel.gridx = 0;
		gbc_parentOneLabel.gridy = 0;
		parentOne.add(parentOneLabel, gbc_parentOneLabel);
		//Gene One Parent One Label
		JLabel geneOnePOneLabel = new JLabel("Gene 1");
		geneOnePOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePOneLabel.setBackground(backgroundColor);
		geneOnePOneLabel.setForeground(textColor);
		GridBagConstraints gbc_geneOnePOneLabel = new GridBagConstraints();
		gbc_geneOnePOneLabel.gridwidth = 4;
		gbc_geneOnePOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneOnePOneLabel.weightx = 1.0;
		gbc_geneOnePOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneLabel.gridx = 0;
		gbc_geneOnePOneLabel.gridy = 2;
		parentOne.add(geneOnePOneLabel, gbc_geneOnePOneLabel);
		
		//Gene One Parent One TextField
		geneOnePOneTF = new JTextField();
		geneOnePOneTF.setBackground(textFieldColor);
		geneOnePOneTF.setForeground(textColor);
		geneOnePOneTF.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_geneOnePOneTF = new GridBagConstraints();
		gbc_geneOnePOneTF.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePOneTF.weightx = 0.25;
		gbc_geneOnePOneTF.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneTF.gridx = 0;
		gbc_geneOnePOneTF.gridy = 3;
		parentOne.add(geneOnePOneTF, gbc_geneOnePOneTF);
		geneOnePOneTF.setColumns(10);
		
		//Gene One Parent One Radial HomoD
		JRadioButton geneOnePOneRadHomoD = new JRadioButton("AA");
		geneOnePOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePOneRadHomoD.setBackground(backgroundColor);
		geneOnePOneRadHomoD.setForeground(textColor);
		GridBagConstraints gbc_geneOnePOneRadHomoD = new GridBagConstraints();
		gbc_geneOnePOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePOneRadHomoD.weightx = 0.25;
		gbc_geneOnePOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneRadHomoD.gridx = 1;
		gbc_geneOnePOneRadHomoD.gridy = 3;
		parentOne.add(geneOnePOneRadHomoD, gbc_geneOnePOneRadHomoD);
		
		//Gene One Parent One Radial Hetero
		JRadioButton geneOnePOneRadHetero = new JRadioButton("Aa");
		geneOnePOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePOneRadHetero.setBackground(backgroundColor);
		geneOnePOneRadHetero.setForeground(textColor);
		GridBagConstraints gbc_geneOnePOneRadHetero = new GridBagConstraints();
		gbc_geneOnePOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePOneRadHetero.weightx = 0.25;
		gbc_geneOnePOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneRadHetero.gridx = 2;
		gbc_geneOnePOneRadHetero.gridy = 3;
		parentOne.add(geneOnePOneRadHetero, gbc_geneOnePOneRadHetero);
		
		//Gene One Parent One Radial HomoR
		JRadioButton geneOnePOneRadHomoR = new JRadioButton("aa");
		geneOnePOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePOneRadHomoR.setBackground(backgroundColor);
		geneOnePOneRadHomoR.setForeground(textColor);
		GridBagConstraints gbc_geneOnePOneRadHomoR = new GridBagConstraints();
		gbc_geneOnePOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneOnePOneRadHomoR.weightx = 0.25;
		gbc_geneOnePOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneRadHomoR.gridx = 3;
		gbc_geneOnePOneRadHomoR.gridy = 3;
		parentOne.add(geneOnePOneRadHomoR, gbc_geneOnePOneRadHomoR);
		
		JLabel instructPOneLabel = new JLabel("1 Letter A-Z a-z");
		instructPOneLabel.setBackground(backgroundColor);
		instructPOneLabel.setForeground(textColor);
		GridBagConstraints gbc_instructPOneLabel = new GridBagConstraints();
		gbc_instructPOneLabel.gridx = 0;
		gbc_instructPOneLabel.gridy = 4;
		parentOne.add(instructPOneLabel, gbc_instructPOneLabel);
		
		//Gene Two Parent One Label
		JLabel geneTwoPOneLabel = new JLabel("Gene 2");
		geneTwoPOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPOneLabel.setBackground(backgroundColor);
		geneTwoPOneLabel.setForeground(textColor);
		GridBagConstraints gbc_geneTwoPOneLabel = new GridBagConstraints();
		gbc_geneTwoPOneLabel.gridwidth = 4;
		gbc_geneTwoPOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneTwoPOneLabel.weightx = 1.0;
		gbc_geneTwoPOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneLabel.gridx = 0;
		gbc_geneTwoPOneLabel.gridy = 5;
		parentOne.add(geneTwoPOneLabel, gbc_geneTwoPOneLabel);
		
		//Gene Two Parent One TextField
		geneTwoPOneTF = new JTextField();
		geneTwoPOneTF.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPOneTF.setBackground(textFieldColor);
		geneTwoPOneTF.setForeground(textColor);
		GridBagConstraints gbc_geneTwoPOneTF = new GridBagConstraints();
		gbc_geneTwoPOneTF.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPOneTF.weightx = 0.25;
		gbc_geneTwoPOneTF.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneTF.gridx = 0;
		gbc_geneTwoPOneTF.gridy = 6;
		parentOne.add(geneTwoPOneTF, gbc_geneTwoPOneTF);
		geneTwoPOneTF.setColumns(10);
		
		//Gene Two Parent One Radial HomoD
		JRadioButton geneTwoPOneRadHomoD = new JRadioButton("AA");
		geneTwoPOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPOneRadHomoD.setBackground(backgroundColor);
		geneTwoPOneRadHomoD.setForeground(textColor);
		GridBagConstraints gbc_geneTwoPOneRadHomoD = new GridBagConstraints();
		gbc_geneTwoPOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPOneRadHomoD.weightx = 0.25;
		gbc_geneTwoPOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneRadHomoD.gridx = 1;
		gbc_geneTwoPOneRadHomoD.gridy = 6;
		parentOne.add(geneTwoPOneRadHomoD, gbc_geneTwoPOneRadHomoD);
		
		//Gene Two Parent One Radial Hetero
		JRadioButton geneTwoPOneRadHetero = new JRadioButton("Aa");
		geneTwoPOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPOneRadHetero.setBackground(backgroundColor);
		geneTwoPOneRadHetero.setForeground(textColor);
		GridBagConstraints gbc_geneTwoPOneRadHetero = new GridBagConstraints();
		gbc_geneTwoPOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPOneRadHetero.weightx = 0.25;
		gbc_geneTwoPOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneRadHetero.gridx = 2;
		gbc_geneTwoPOneRadHetero.gridy = 6;
		parentOne.add(geneTwoPOneRadHetero, gbc_geneTwoPOneRadHetero);
		
		//Gene Two Parent One Radial HomoR
		JRadioButton geneTwoPOneRadHomoR = new JRadioButton("aa");
		geneTwoPOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPOneRadHomoR.setBackground(backgroundColor);
		geneTwoPOneRadHomoR.setForeground(textColor);
		GridBagConstraints gbc_geneTwoPOneRadHomoR = new GridBagConstraints();
		gbc_geneTwoPOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneTwoPOneRadHomoR.weightx = 0.25;
		gbc_geneTwoPOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneRadHomoR.gridx = 3;
		gbc_geneTwoPOneRadHomoR.gridy = 6;
		parentOne.add(geneTwoPOneRadHomoR, gbc_geneTwoPOneRadHomoR);
		
		//Gene Three Parent One Label
		JLabel geneThreePOneLabel = new JLabel("Gene 3");
		geneThreePOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePOneLabel.setBackground(backgroundColor);
		geneThreePOneLabel.setForeground(textColor);
		GridBagConstraints gbc_geneThreePOneLabel = new GridBagConstraints();
		gbc_geneThreePOneLabel.gridwidth = 4;
		gbc_geneThreePOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneThreePOneLabel.weightx = 1.0;
		gbc_geneThreePOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneLabel.gridx = 0;
		gbc_geneThreePOneLabel.gridy = 8;
		parentOne.add(geneThreePOneLabel, gbc_geneThreePOneLabel);
		
		//Gene Three Parent One TextField
		geneThreePOneTF = new JTextField();
		geneThreePOneTF.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePOneTF.setBackground(textFieldColor);
		geneThreePOneTF.setForeground(textColor);
		geneThreePOneTF.setColumns(10);
		GridBagConstraints gbc_geneThreePOneTF = new GridBagConstraints();
		gbc_geneThreePOneTF.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePOneTF.weightx = 0.25;
		gbc_geneThreePOneTF.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneTF.gridx = 0;
		gbc_geneThreePOneTF.gridy = 9;
		parentOne.add(geneThreePOneTF, gbc_geneThreePOneTF);
		
		//Gene Three Parent One Radial HomoD
		JRadioButton geneThreePOneRadHomoD = new JRadioButton("AA");
		geneThreePOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePOneRadHomoD.setBackground(backgroundColor);
		geneThreePOneRadHomoD.setForeground(textColor);
		GridBagConstraints gbc_geneThreePOneRadHomoD = new GridBagConstraints();
		gbc_geneThreePOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePOneRadHomoD.weightx = 0.25;
		gbc_geneThreePOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneRadHomoD.gridx = 1;
		gbc_geneThreePOneRadHomoD.gridy = 9;
		parentOne.add(geneThreePOneRadHomoD, gbc_geneThreePOneRadHomoD);
		
		//Gene Three Parent One Radial Hetero
		JRadioButton geneThreePOneRadHetero = new JRadioButton("Aa");
		geneThreePOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePOneRadHetero.setBackground(backgroundColor);
		geneThreePOneRadHetero.setForeground(textColor);
		GridBagConstraints gbc_geneThreePOneRadHetero = new GridBagConstraints();
		gbc_geneThreePOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePOneRadHetero.weightx = 0.25;
		gbc_geneThreePOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneRadHetero.gridx = 2;
		gbc_geneThreePOneRadHetero.gridy = 9;
		parentOne.add(geneThreePOneRadHetero, gbc_geneThreePOneRadHetero);
		
		//Gene Three Parent One Radial HomoR
		JRadioButton geneThreePOneRadHomoR = new JRadioButton("aa");
		geneThreePOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePOneRadHomoR.setBackground(backgroundColor);
		geneThreePOneRadHomoR.setForeground(textColor);
		GridBagConstraints gbc_geneThreePOneRadHomoR = new GridBagConstraints();
		gbc_geneThreePOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneThreePOneRadHomoR.weightx = 0.25;
		gbc_geneThreePOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneRadHomoR.gridx = 3;
		gbc_geneThreePOneRadHomoR.gridy = 9;
		parentOne.add(geneThreePOneRadHomoR, gbc_geneThreePOneRadHomoR);
		
		//Gene Four Parent One Label
		JLabel geneFourPOneLabel = new JLabel("Gene 4");
		geneFourPOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPOneLabel.setBackground(backgroundColor);
		geneFourPOneLabel.setForeground(textColor);
		GridBagConstraints gbc_geneFourPOneLabel = new GridBagConstraints();
		gbc_geneFourPOneLabel.gridwidth = 4;
		gbc_geneFourPOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneFourPOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneLabel.gridx = 0;
		gbc_geneFourPOneLabel.gridy = 11;
		parentOne.add(geneFourPOneLabel, gbc_geneFourPOneLabel);
		
		//Gene Four Parent One TextField
		geneFourPOneTF = new JTextField();
		geneFourPOneTF.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPOneTF.setBackground(textFieldColor);
		geneFourPOneTF.setForeground(textColor);
		geneFourPOneTF.setColumns(10);
		GridBagConstraints gbc_geneFourPOneTF = new GridBagConstraints();
		gbc_geneFourPOneTF.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPOneTF.weightx = 0.25;
		gbc_geneFourPOneTF.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneTF.gridx = 0;
		gbc_geneFourPOneTF.gridy = 12;
		parentOne.add(geneFourPOneTF, gbc_geneFourPOneTF);
		
		//Gene Four Parent One Radial HomoD
		JRadioButton geneFourPOneRadHomoD = new JRadioButton("AA");
		geneFourPOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPOneRadHomoD.setBackground(backgroundColor);
		geneFourPOneRadHomoD.setForeground(textColor);
		GridBagConstraints gbc_geneFourPOneRadHomoD = new GridBagConstraints();
		gbc_geneFourPOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPOneRadHomoD.weightx = 0.25;
		gbc_geneFourPOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneRadHomoD.gridx = 1;
		gbc_geneFourPOneRadHomoD.gridy = 12;
		parentOne.add(geneFourPOneRadHomoD, gbc_geneFourPOneRadHomoD);
		
		//Gene Four Parent One Radial Hetero
		JRadioButton geneFourPOneRadHetero = new JRadioButton("Aa");
		geneFourPOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPOneRadHetero.setBackground(backgroundColor);
		geneFourPOneRadHetero.setForeground(textColor);
		GridBagConstraints gbc_geneFourPOneRadHetero = new GridBagConstraints();
		gbc_geneFourPOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPOneRadHetero.weightx = 0.25;
		gbc_geneFourPOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneRadHetero.gridx = 2;
		gbc_geneFourPOneRadHetero.gridy = 12;
		parentOne.add(geneFourPOneRadHetero, gbc_geneFourPOneRadHetero);
		
		//Gene Four Parent One Radial HomoR
		JRadioButton geneFourPOneRadHomoR = new JRadioButton("aa");
		geneFourPOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPOneRadHomoR.setBackground(backgroundColor);
		geneFourPOneRadHomoR.setForeground(textColor);
		GridBagConstraints gbc_geneFourPOneRadHomoR = new GridBagConstraints();
		gbc_geneFourPOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneFourPOneRadHomoR.weightx = 0.25;
		gbc_geneFourPOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneRadHomoR.gridx = 3;
		gbc_geneFourPOneRadHomoR.gridy = 12;
		parentOne.add(geneFourPOneRadHomoR, gbc_geneFourPOneRadHomoR);
		
		//Gene Five Parent One Label
		JLabel geneFivePOneLabel = new JLabel("Gene 5");
		geneFivePOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePOneLabel.setBackground(backgroundColor);
		geneFivePOneLabel.setForeground(textColor);
		GridBagConstraints gbc_geneFivePOneLabel = new GridBagConstraints();
		gbc_geneFivePOneLabel.gridwidth = 4;
		gbc_geneFivePOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneFivePOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneLabel.gridx = 0;
		gbc_geneFivePOneLabel.gridy = 14;
		parentOne.add(geneFivePOneLabel, gbc_geneFivePOneLabel);
		
		//Gene Five Parent One TextField
		geneFivePOneTF = new JTextField();
		geneFivePOneTF.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePOneTF.setBackground(textFieldColor);
		geneFivePOneTF.setForeground(textColor);
		geneFivePOneTF.setColumns(10);
		GridBagConstraints gbc_geneFivePOneTF = new GridBagConstraints();
		gbc_geneFivePOneTF.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePOneTF.weightx = 0.25;
		gbc_geneFivePOneTF.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneTF.gridx = 0;
		gbc_geneFivePOneTF.gridy = 15;
		parentOne.add(geneFivePOneTF, gbc_geneFivePOneTF);
		
		//Gene Five Parent One Radial HomoD
		JRadioButton geneFivePOneRadHomoD = new JRadioButton("AA");
		geneFivePOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePOneRadHomoD.setBackground(backgroundColor);
		geneFivePOneRadHomoD.setForeground(textColor);
		GridBagConstraints gbc_geneFivePOneRadHomoD = new GridBagConstraints();
		gbc_geneFivePOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePOneRadHomoD.weightx = 0.25;
		gbc_geneFivePOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneRadHomoD.gridx = 1;
		gbc_geneFivePOneRadHomoD.gridy = 15;
		parentOne.add(geneFivePOneRadHomoD, gbc_geneFivePOneRadHomoD);
		
		//Gene Five Parent One Radial Hetero
		JRadioButton geneFivePOneRadHetero = new JRadioButton("Aa");
		geneFivePOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePOneRadHetero.setBackground(backgroundColor);
		geneFivePOneRadHetero.setForeground(textColor);
		GridBagConstraints gbc_geneFivePOneRadHetero = new GridBagConstraints();
		gbc_geneFivePOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePOneRadHetero.weightx = 0.25;
		gbc_geneFivePOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneRadHetero.gridx = 2;
		gbc_geneFivePOneRadHetero.gridy = 15;
		parentOne.add(geneFivePOneRadHetero, gbc_geneFivePOneRadHetero);
		
		//Gene Five Parent One Radial HomoR
		JRadioButton geneFivePOneRadHomoR = new JRadioButton("aa");
		geneFivePOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePOneRadHomoR.setBackground(backgroundColor);
		geneFivePOneRadHomoR.setForeground(textColor);
		GridBagConstraints gbc_geneFivePOneRadHomoR = new GridBagConstraints();
		gbc_geneFivePOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneFivePOneRadHomoR.weightx = 0.25;
		gbc_geneFivePOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneRadHomoR.gridx = 3;
		gbc_geneFivePOneRadHomoR.gridy = 15;
		parentOne.add(geneFivePOneRadHomoR, gbc_geneFivePOneRadHomoR);
		
		//Parent One Calculation Button
		JButton calcButton = new JButton("Calculate");
		calcButton.setBackground(backgroundColor);
		calcButton.setForeground(textColor);
		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_calcButton = new GridBagConstraints();
		gbc_calcButton.gridwidth = 4;
		gbc_calcButton.weightx = 1.0;
		gbc_calcButton.fill = GridBagConstraints.BOTH;
		gbc_calcButton.gridx = 0;
		gbc_calcButton.gridy = 20;
		parentOne.add(calcButton, gbc_calcButton);
		
		//Parent Two Column
		JPanel parentTwo = new JPanel();
		parentTwo.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_parentTwo = new GridBagConstraints();
		gbc_parentTwo.weighty = 1.0;
		gbc_parentTwo.weightx = 0.2;
		gbc_parentTwo.fill = GridBagConstraints.BOTH;
		gbc_parentTwo.gridx = 1;
		gbc_parentTwo.gridy = 0;
		content.add(parentTwo, gbc_parentTwo);
		GridBagLayout gbl_parentTwo = new GridBagLayout();
		gbl_parentTwo.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_parentTwo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_parentTwo.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_parentTwo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		parentTwo.setLayout(gbl_parentTwo);
		
		//Parent Two Label
		JLabel parentTwoLabel = new JLabel("Parent Two");
		parentTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		parentTwoLabel.setBackground(backgroundColor);
		parentTwoLabel.setForeground(textColor);
		GridBagConstraints gbc_parentTwoLabel = new GridBagConstraints();
		gbc_parentTwoLabel.gridwidth = 4;
		gbc_parentTwoLabel.weightx = 1.0;
		gbc_parentTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_parentTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_parentTwoLabel.gridx = 0;
		gbc_parentTwoLabel.gridy = 0;
		parentTwo.add(parentTwoLabel, gbc_parentTwoLabel);
		
		//Gene One Parent Two Label
		JLabel geneOnePTwoLabel = new JLabel("Gene 1");
		geneOnePTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePTwoLabel.setBackground(backgroundColor);
		geneOnePTwoLabel.setForeground(textColor);
		GridBagConstraints gbc_geneOnePTwoLabel = new GridBagConstraints();
		gbc_geneOnePTwoLabel.gridwidth = 4;
		gbc_geneOnePTwoLabel.weightx = 1.0;
		gbc_geneOnePTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneOnePTwoLabel.gridx = 0;
		gbc_geneOnePTwoLabel.gridy = 2;
		parentTwo.add(geneOnePTwoLabel, gbc_geneOnePTwoLabel);
		
		//Gene One Parent Two TextField
		geneOnePTwoTF = new JTextField();
		geneOnePTwoTF.setBackground(textFieldColor);
		geneOnePTwoTF.setForeground(textColor);
		geneOnePTwoTF.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePTwoTF.setColumns(10);
		GridBagConstraints gbc_geneOnePTwoTF = new GridBagConstraints();
		gbc_geneOnePTwoTF.weightx = 0.25;
		gbc_geneOnePTwoTF.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoTF.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePTwoTF.gridx = 0;
		gbc_geneOnePTwoTF.gridy = 3;
		parentTwo.add(geneOnePTwoTF, gbc_geneOnePTwoTF);
		
		//Gene One Parent Two Radial HomoD
		JRadioButton geneOnePTwoRadHomoD = new JRadioButton("AA");
		geneOnePTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePTwoRadHomoD.setBackground(backgroundColor);
		geneOnePTwoRadHomoD.setForeground(textColor);
		GridBagConstraints gbc_geneOnePTwoRadHomoD = new GridBagConstraints();
		gbc_geneOnePTwoRadHomoD.weightx = 0.25;
		gbc_geneOnePTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePTwoRadHomoD.gridx = 1;
		gbc_geneOnePTwoRadHomoD.gridy = 3;
		parentTwo.add(geneOnePTwoRadHomoD, gbc_geneOnePTwoRadHomoD);
		
		//Gene One Parent Two Radial Hetero
		JRadioButton geneOnePTwoRadHetero = new JRadioButton("Aa");
		geneOnePTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePTwoRadHetero.setBackground(backgroundColor);
		geneOnePTwoRadHetero.setForeground(textColor);
		GridBagConstraints gbc_geneOnePTwoRadHetero = new GridBagConstraints();
		gbc_geneOnePTwoRadHetero.weightx = 0.25;
		gbc_geneOnePTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePTwoRadHetero.gridx = 2;
		gbc_geneOnePTwoRadHetero.gridy = 3;
		parentTwo.add(geneOnePTwoRadHetero, gbc_geneOnePTwoRadHetero);
		
		//Gene One Parent Two Radial HomoR
		JRadioButton geneOnePTwoRadHomoR = new JRadioButton("aa");
		geneOnePTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePTwoRadHomoR.setBackground(backgroundColor);
		geneOnePTwoRadHomoR.setForeground(textColor);
		GridBagConstraints gbc_geneOnePTwoRadHomoR = new GridBagConstraints();
		gbc_geneOnePTwoRadHomoR.weightx = 0.25;
		gbc_geneOnePTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneOnePTwoRadHomoR.gridx = 3;
		gbc_geneOnePTwoRadHomoR.gridy = 3;
		parentTwo.add(geneOnePTwoRadHomoR, gbc_geneOnePTwoRadHomoR);
		
		JLabel instructPTwoLabel = new JLabel("1 Letter A-Z a-z");
		instructPTwoLabel.setBackground(backgroundColor);
		instructPTwoLabel.setForeground(textColor);
		GridBagConstraints gbc_instructPTwoLabel = new GridBagConstraints();
		gbc_instructPTwoLabel.gridx = 0;
		gbc_instructPTwoLabel.gridy = 4;
		parentTwo.add(instructPTwoLabel, gbc_instructPTwoLabel);
		
		//Gene Two Parent Two Label
		JLabel geneTwoPTwoLabel = new JLabel("Gene 2");
		geneTwoPTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPTwoLabel.setBackground(backgroundColor);
		geneTwoPTwoLabel.setForeground(textColor);
		GridBagConstraints gbc_geneTwoPTwoLabel = new GridBagConstraints();
		gbc_geneTwoPTwoLabel.gridwidth = 4;
		gbc_geneTwoPTwoLabel.weightx = 1.0;
		gbc_geneTwoPTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneTwoPTwoLabel.gridx = 0;
		gbc_geneTwoPTwoLabel.gridy = 5;
		parentTwo.add(geneTwoPTwoLabel, gbc_geneTwoPTwoLabel);
		
		//Gene Two Parent Two TextField
		geneTwoPTwoTF = new JTextField();
		geneTwoPTwoTF.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPTwoTF.setBackground(textFieldColor);
		geneTwoPTwoTF.setForeground(textColor);
		geneTwoPTwoTF.setColumns(10);
		GridBagConstraints gbc_geneTwoPTwoTF = new GridBagConstraints();
		gbc_geneTwoPTwoTF.weightx = 0.25;
		gbc_geneTwoPTwoTF.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoTF.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPTwoTF.gridx = 0;
		gbc_geneTwoPTwoTF.gridy = 6;
		parentTwo.add(geneTwoPTwoTF, gbc_geneTwoPTwoTF);
		
		//Gene Two Parent Two Radial HomoD
		JRadioButton geneTwoPTwoRadHomoD = new JRadioButton("AA");
		geneTwoPTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPTwoRadHomoD.setBackground(backgroundColor);
		geneTwoPTwoRadHomoD.setForeground(textColor);
		GridBagConstraints gbc_geneTwoPTwoRadHomoD = new GridBagConstraints();
		gbc_geneTwoPTwoRadHomoD.weightx = 0.25;
		gbc_geneTwoPTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPTwoRadHomoD.gridx = 1;
		gbc_geneTwoPTwoRadHomoD.gridy = 6;
		parentTwo.add(geneTwoPTwoRadHomoD, gbc_geneTwoPTwoRadHomoD);
		
		//Gene Two Parent Two Radial Hetero
		JRadioButton geneTwoPTwoRadHetero = new JRadioButton("Aa");
		geneTwoPTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPTwoRadHetero.setBackground(backgroundColor);
		geneTwoPTwoRadHetero.setForeground(textColor);
		GridBagConstraints gbc_geneTwoPTwoRadHetero = new GridBagConstraints();
		gbc_geneTwoPTwoRadHetero.weightx = 0.25;
		gbc_geneTwoPTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPTwoRadHetero.gridx = 2;
		gbc_geneTwoPTwoRadHetero.gridy = 6;
		parentTwo.add(geneTwoPTwoRadHetero, gbc_geneTwoPTwoRadHetero);
		
		//Gene Two Parent Two Radial HomoR
		JRadioButton geneTwoPTwoRadHomoR = new JRadioButton("aa");
		geneTwoPTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPTwoRadHomoR.setBackground(backgroundColor);
		geneTwoPTwoRadHomoR.setForeground(textColor);
		GridBagConstraints gbc_geneTwoPTwoRadHomoR = new GridBagConstraints();
		gbc_geneTwoPTwoRadHomoR.weightx = 0.25;
		gbc_geneTwoPTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneTwoPTwoRadHomoR.gridx = 3;
		gbc_geneTwoPTwoRadHomoR.gridy = 6;
		parentTwo.add(geneTwoPTwoRadHomoR, gbc_geneTwoPTwoRadHomoR);
		
		//Gene Three Parent Two Label
		JLabel geneThreePTwoLabel = new JLabel("Gene 3");
		geneThreePTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePTwoLabel.setBackground(backgroundColor);
		geneThreePTwoLabel.setForeground(textColor);
		GridBagConstraints gbc_geneThreePTwoLabel = new GridBagConstraints();
		gbc_geneThreePTwoLabel.gridwidth = 4;
		gbc_geneThreePTwoLabel.weightx = 1.0;
		gbc_geneThreePTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneThreePTwoLabel.gridx = 0;
		gbc_geneThreePTwoLabel.gridy = 8;
		parentTwo.add(geneThreePTwoLabel, gbc_geneThreePTwoLabel);
		
		//Gene Three Parent Two TextField
		geneThreePTwoTF = new JTextField();
		geneThreePTwoTF.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePTwoTF.setBackground(textFieldColor);
		geneThreePTwoTF.setForeground(textColor);
		geneThreePTwoTF.setColumns(10);
		GridBagConstraints gbc_geneThreePTwoTF = new GridBagConstraints();
		gbc_geneThreePTwoTF.weightx = 0.25;
		gbc_geneThreePTwoTF.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoTF.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePTwoTF.gridx = 0;
		gbc_geneThreePTwoTF.gridy = 9;
		parentTwo.add(geneThreePTwoTF, gbc_geneThreePTwoTF);
		
		//Gene Three Parent Two Radial HomoD
		JRadioButton geneThreePTwoRadHomoD = new JRadioButton("AA");
		geneThreePTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePTwoRadHomoD.setBackground(backgroundColor);
		geneThreePTwoRadHomoD.setForeground(textColor);
		GridBagConstraints gbc_geneThreePTwoRadHomoD = new GridBagConstraints();
		gbc_geneThreePTwoRadHomoD.weightx = 0.25;
		gbc_geneThreePTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePTwoRadHomoD.gridx = 1;
		gbc_geneThreePTwoRadHomoD.gridy = 9;
		parentTwo.add(geneThreePTwoRadHomoD, gbc_geneThreePTwoRadHomoD);
		
		//Gene Three Parent Two Radial Hetero
		JRadioButton geneThreePTwoRadHetero = new JRadioButton("Aa");
		geneThreePTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePTwoRadHetero.setBackground(backgroundColor);
		geneThreePTwoRadHetero.setForeground(textColor);
		GridBagConstraints gbc_geneThreePTwoRadHetero = new GridBagConstraints();
		gbc_geneThreePTwoRadHetero.weightx = 0.25;
		gbc_geneThreePTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePTwoRadHetero.gridx = 2;
		gbc_geneThreePTwoRadHetero.gridy = 9;
		parentTwo.add(geneThreePTwoRadHetero, gbc_geneThreePTwoRadHetero);
		
		//Gene Three Parent Two Radial HomoR
		JRadioButton geneThreePTwoRadHomoR = new JRadioButton("aa");
		geneThreePTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePTwoRadHomoR.setBackground(backgroundColor);
		geneThreePTwoRadHomoR.setForeground(textColor);
		GridBagConstraints gbc_geneThreePTwoRadHomoR = new GridBagConstraints();
		gbc_geneThreePTwoRadHomoR.weightx = 0.25;
		gbc_geneThreePTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneThreePTwoRadHomoR.gridx = 3;
		gbc_geneThreePTwoRadHomoR.gridy = 9;
		parentTwo.add(geneThreePTwoRadHomoR, gbc_geneThreePTwoRadHomoR);
		
		//Gene Four Parent Two Label
		JLabel geneFourPTwoLabel = new JLabel("Gene 4");
		geneFourPTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPTwoLabel.setBackground(backgroundColor);
		geneFourPTwoLabel.setForeground(textColor);
		GridBagConstraints gbc_geneFourPTwoLabel = new GridBagConstraints();
		gbc_geneFourPTwoLabel.gridwidth = 4;
		gbc_geneFourPTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneFourPTwoLabel.gridx = 0;
		gbc_geneFourPTwoLabel.gridy = 11;
		parentTwo.add(geneFourPTwoLabel, gbc_geneFourPTwoLabel);
		
		//Gene Four Parent Two TextField
		geneFourPTwoTF = new JTextField();
		geneFourPTwoTF.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPTwoTF.setBackground(textFieldColor);
		geneFourPTwoTF.setForeground(textColor);
		geneFourPTwoTF.setColumns(10);
		GridBagConstraints gbc_geneFourPTwoTF = new GridBagConstraints();
		gbc_geneFourPTwoTF.weightx = 0.25;
		gbc_geneFourPTwoTF.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoTF.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPTwoTF.gridx = 0;
		gbc_geneFourPTwoTF.gridy = 12;
		parentTwo.add(geneFourPTwoTF, gbc_geneFourPTwoTF);
		
		//Gene Four Parent Two Radial HomoD
		JRadioButton geneFourPTwoRadHomoD = new JRadioButton("AA");
		geneFourPTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPTwoRadHomoD.setBackground(backgroundColor);
		geneFourPTwoRadHomoD.setForeground(textColor);
		GridBagConstraints gbc_geneFourPTwoRadHomoD = new GridBagConstraints();
		gbc_geneFourPTwoRadHomoD.weightx = 0.25;
		gbc_geneFourPTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPTwoRadHomoD.gridx = 1;
		gbc_geneFourPTwoRadHomoD.gridy = 12;
		parentTwo.add(geneFourPTwoRadHomoD, gbc_geneFourPTwoRadHomoD);
		
		//Gene Four Parent Two Radial Hetero
		JRadioButton geneFourPTwoRadHetero = new JRadioButton("Aa");
		geneFourPTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPTwoRadHetero.setBackground(backgroundColor);
		geneFourPTwoRadHetero.setForeground(textColor);
		GridBagConstraints gbc_geneFourPTwoRadHetero = new GridBagConstraints();
		gbc_geneFourPTwoRadHetero.weightx = 0.25;
		gbc_geneFourPTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPTwoRadHetero.gridx = 2;
		gbc_geneFourPTwoRadHetero.gridy = 12;
		parentTwo.add(geneFourPTwoRadHetero, gbc_geneFourPTwoRadHetero);
		
		//Gene Four Parent Two Radial HomoR
		JRadioButton geneFourPTwoRadHomoR = new JRadioButton("aa");
		geneFourPTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPTwoRadHomoR.setBackground(backgroundColor);
		geneFourPTwoRadHomoR.setForeground(textColor);
		GridBagConstraints gbc_geneFourPTwoRadHomoR = new GridBagConstraints();
		gbc_geneFourPTwoRadHomoR.weightx = 0.25;
		gbc_geneFourPTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneFourPTwoRadHomoR.gridx = 3;
		gbc_geneFourPTwoRadHomoR.gridy = 12;
		parentTwo.add(geneFourPTwoRadHomoR, gbc_geneFourPTwoRadHomoR);
		
		//Gene Five Parent Two Label
		JLabel geneFivePTwoLabel = new JLabel("Gene 5");
		geneFivePTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePTwoLabel.setBackground(backgroundColor);
		geneFivePTwoLabel.setForeground(textColor);
		GridBagConstraints gbc_geneFivePTwoLabel = new GridBagConstraints();
		gbc_geneFivePTwoLabel.gridwidth = 4;
		gbc_geneFivePTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneFivePTwoLabel.gridx = 0;
		gbc_geneFivePTwoLabel.gridy = 14;
		parentTwo.add(geneFivePTwoLabel, gbc_geneFivePTwoLabel);
		
		//Gene Five Parent Two TextField
		geneFivePTwoTF = new JTextField();
		geneFivePTwoTF.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePTwoTF.setBackground(textFieldColor);
		geneFivePTwoTF.setForeground(textColor);
		geneFivePTwoTF.setColumns(10);
		GridBagConstraints gbc_geneFivePTwoTF = new GridBagConstraints();
		gbc_geneFivePTwoTF.weightx = 0.25;
		gbc_geneFivePTwoTF.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoTF.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePTwoTF.gridx = 0;
		gbc_geneFivePTwoTF.gridy = 15;
		parentTwo.add(geneFivePTwoTF, gbc_geneFivePTwoTF);
		
		//Gene Five Parent Two Radial HomoD 
		JRadioButton geneFivePTwoRadHomoD = new JRadioButton("AA");
		geneFivePTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePTwoRadHomoD.setBackground(backgroundColor);
		geneFivePTwoRadHomoD.setForeground(textColor);
		GridBagConstraints gbc_geneFivePTwoRadHomoD = new GridBagConstraints();
		gbc_geneFivePTwoRadHomoD.weightx = 0.25;
		gbc_geneFivePTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePTwoRadHomoD.gridx = 1;
		gbc_geneFivePTwoRadHomoD.gridy = 15;
		parentTwo.add(geneFivePTwoRadHomoD, gbc_geneFivePTwoRadHomoD);
		
		//Gene Five Parent Two Radial Hetero
		JRadioButton geneFivePTwoRadHetero = new JRadioButton("Aa");
		geneFivePTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePTwoRadHetero.setBackground(backgroundColor);
		geneFivePTwoRadHetero.setForeground(textColor);
		GridBagConstraints gbc_geneFivePTwoRadHetero = new GridBagConstraints();
		gbc_geneFivePTwoRadHetero.weightx = 0.25;
		gbc_geneFivePTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePTwoRadHetero.gridx = 2;
		gbc_geneFivePTwoRadHetero.gridy = 15;
		parentTwo.add(geneFivePTwoRadHetero, gbc_geneFivePTwoRadHetero);
		
		//Gene Five Parent Two Radial HomoR
		JRadioButton geneFivePTwoRadHomoR = new JRadioButton("aa");
		geneFivePTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePTwoRadHomoR.setBackground(backgroundColor);
		geneFivePTwoRadHomoR.setForeground(textColor);
		GridBagConstraints gbc_geneFivePTwoRadHomoR = new GridBagConstraints();
		gbc_geneFivePTwoRadHomoR.weightx = 0.25;
		gbc_geneFivePTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneFivePTwoRadHomoR.gridx = 3;
		gbc_geneFivePTwoRadHomoR.gridy = 15;
		parentTwo.add(geneFivePTwoRadHomoR, gbc_geneFivePTwoRadHomoR);
		
		//Reset Button 
		JButton resetButton = new JButton("Reset");
		resetButton.setBackground(backgroundColor);
		resetButton.setForeground(textColor);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_resetButton = new GridBagConstraints();
		gbc_resetButton.gridwidth = 4;
		gbc_resetButton.weightx = 1.0;
		gbc_resetButton.fill = GridBagConstraints.BOTH;
		gbc_resetButton.gridx = 0;
		gbc_resetButton.gridy = 20;
		parentTwo.add(resetButton, gbc_resetButton);
		
		
		//Results Column
		JPanel resultsPanel = new JPanel();
		//temp, fix color later.
		resultsPanel.setBackground(Color.BLUE);
		GridBagConstraints gbc_resultsPanel = new GridBagConstraints();
		gbc_resultsPanel.gridwidth = 2;
		gbc_resultsPanel.weighty = 1.0;
		gbc_resultsPanel.weightx = 0.6;
		gbc_resultsPanel.fill = GridBagConstraints.BOTH;
		gbc_resultsPanel.gridx = 2;
		gbc_resultsPanel.gridy = 0;
		content.add(resultsPanel, gbc_resultsPanel);
		GridBagLayout gbl_resultsPanel = new GridBagLayout();
		gbl_resultsPanel.columnWidths = new int[]{265, 0};
		gbl_resultsPanel.rowHeights = new int[]{14, 525, 22, 0};
		gbl_resultsPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_resultsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		resultsPanel.setLayout(gbl_resultsPanel);
		
		//Results Label
		JLabel resultsLabel = new JLabel("Results");
		resultsLabel.setBackground(backgroundColor);
		resultsLabel.setForeground(textColor);
		resultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblResults = new GridBagConstraints();
		gbc_lblResults.fill = GridBagConstraints.BOTH;
		gbc_lblResults.gridwidth = 2;
		gbc_lblResults.gridx = 0;
		gbc_lblResults.gridy = 0;
		resultsPanel.add(resultsLabel, gbc_lblResults);
		
		//Results JTextArea
		JTextArea resultsJTA = new JTextArea();
		resultsJTA.setDropMode(DropMode.ON);
		resultsJTA.setBackground(textFieldColor);
		resultsJTA.setForeground(textColor);
		resultsJTA.setEditable(false);
		GridBagConstraints gbc_resultsJTA = new GridBagConstraints();
		gbc_resultsJTA.gridheight = 2;
		gbc_resultsJTA.gridwidth = 2;
		gbc_resultsJTA.fill = GridBagConstraints.BOTH;
		gbc_resultsJTA.gridx = 0;
		gbc_resultsJTA.gridy = 1;
		resultsPanel.add(resultsJTA, gbc_resultsJTA);
		
	}

}
