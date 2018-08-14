package punnettme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.DropMode;
import javax.swing.JComboBox;

public class PunnettMeGUI implements Runnable, MouseListener, ItemListener
{

	//*********** GUI Globals ***********
	private JFrame window;
	/*
	 *Variable Breakdown:
	 *geneOne = Gene One
	 *POne = Parent One
	 *Combo = drop down menu(JComboBox<String>)
	 *Rad = Radio Button(JRadioButton) for each allele type
	 *HomoD = Homozygous Dominant (Gene trait) 
	 *Hetero = Heterozygous(Gene trait) 
	 *HomoR = Homozygous Recessive (Gene trait) 
	 */
	
	//Parent One
	private JComboBox<String> geneOnePOneCombo;
	private JComboBox<String> geneTwoPOneCombo;
	private JComboBox<String> geneThreePOneCombo;
	private JComboBox<String> geneFourPOneCombo;
	private JComboBox<String> geneFivePOneCombo;

	//Parent Two
	private JComboBox<String> geneOnePTwoCombo;
	private JComboBox<String> geneTwoPTwoCombo;
	private JComboBox<String> geneThreePTwoCombo;
	private JComboBox<String> geneFourPTwoCombo;
	private JComboBox<String> geneFivePTwoCombo;
	
	//Parent One 
	private JLabel geneTwoPOneLabel;
	private JLabel geneThreePOneLabel;
	private JLabel geneFourPOneLabel;
	private JLabel geneFivePOneLabel;
	
	//Parent Two 
	private JLabel geneOnePTwoLabel;
	private JLabel geneTwoPTwoLabel;
	private JLabel geneThreePTwoLabel;
	private JLabel geneFourPTwoLabel;
	private JLabel geneFivePTwoLabel;
	
	//Parent One
	private ButtonGroup geneOnePOneBG;
	private ButtonGroup geneTwoPOneBG;
	private ButtonGroup geneThreePOneBG;
	private ButtonGroup geneFourPOneBG;
	private ButtonGroup geneFivePOneBG;

	//Parent Two
	private ButtonGroup geneOnePTwoBG;
	private ButtonGroup geneTwoPTwoBG;
	private ButtonGroup geneThreePTwoBG;
	private ButtonGroup geneFourPTwoBG;
	private ButtonGroup geneFivePTwoBG;
	
	//Parent One
	private JRadioButton geneOnePOneRadHomoD;
	private JRadioButton geneOnePOneRadHetero;
	private JRadioButton geneOnePOneRadHomoR;
	private JRadioButton geneTwoPOneRadHomoD;
	private JRadioButton geneTwoPOneRadHetero;
	private JRadioButton geneTwoPOneRadHomoR;
	private JRadioButton geneThreePOneRadHomoD;
	private JRadioButton geneThreePOneRadHetero;
	private JRadioButton geneThreePOneRadHomoR;
	private JRadioButton geneFourPOneRadHomoD;
	private JRadioButton geneFourPOneRadHetero;
	private JRadioButton geneFourPOneRadHomoR;
	private JRadioButton geneFivePOneRadHomoD;
	private JRadioButton geneFivePOneRadHetero;
	private JRadioButton geneFivePOneRadHomoR;

	//Parent Two
	private JRadioButton geneOnePTwoRadHomoD;
	private JRadioButton geneOnePTwoRadHetero;
	private JRadioButton geneOnePTwoRadHomoR;
	private JRadioButton geneTwoPTwoRadHomoD;
	private JRadioButton geneTwoPTwoRadHetero;
	private JRadioButton geneTwoPTwoRadHomoR;
	private JRadioButton geneThreePTwoRadHomoD;
	private JRadioButton geneThreePTwoRadHetero;
	private JRadioButton geneThreePTwoRadHomoR;
	private JRadioButton geneFourPTwoRadHomoD;
	private JRadioButton geneFourPTwoRadHetero;
	private JRadioButton geneFourPTwoRadHomoR;
	private JRadioButton geneFivePTwoRadHomoD;
	private JRadioButton geneFivePTwoRadHetero;
	private JRadioButton geneFivePTwoRadHomoR;
	
	private JButton resetButton;
	private JButton calcButton;
	
	private Color textColor = Color.WHITE;
	private Color backgroundColor = Color.DARK_GRAY;
	private Color textFieldColor = Color.GRAY;
	private String[] geneOptions = {"Select Symbol","A","B","C","D","E",
									"F","G","H","I","J","K",
									"L","M","N","O","P","Q",
									"R","S","T","U","V","W",
									"X","Y","Z",};
	private String defaultComboItem = "Select Symbol";
	
	//*********** PunnettMe Globals ***********
	private PunnettMe pm;
	private Parent parentOne;
	private Parent parentTwo;
	
	//*********** Debug Switches *********** 
	private boolean inDebugMode = false;
	
	public static void main (String[] args)
	{
		SwingUtilities.invokeLater(new PunnettMeGUI());
	}

	//UNCOMMENT FOR DESIGN
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PunnettMeGUI window = new PunnettMeGUI();
//					window.window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	//UNCOMMENT FOR DESIGN
//	public PunnettMeGUI()
//	{
//		initialize();
//	}
	
	
	//COMMENT OUT FOR DESIGN
	public void run() 
	{
		start();
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
	//COMMENT OUT FOR DESIGN
//	private void initialize() {
	private void start() 
	{
		
		//*********** PunnettMe Code init ***********
		pm = new PunnettMe();
		//*********** GUI START ***********
		
		//Window 
		window = new JFrame();
		window.setBackground(Color.DARK_GRAY);
		window.setTitle("PunnettMe");
		window.setBounds(100, 100, 800, 600);
//		window.setMaximumSize(new Dimension(900, 600));
		window.setMinimumSize(new Dimension(825, 600));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		window.getContentPane().setLayout(gridBagLayout);
		
		//Main Content Panel (includes everything)
		JPanel content = new JPanel();
		content.setBackground(backgroundColor);
		content.setForeground(textColor);
		GridBagConstraints gbc_content = new GridBagConstraints();
		gbc_content.fill = GridBagConstraints.BOTH;
		gbc_content.gridwidth = 0;
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
		gbc_parentOne.insets = new Insets(0, 5, 0, 0);
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
		gbc_parentOneLabel.anchor = GridBagConstraints.NORTH;
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
		
		//Gene One Parent One Combo
		geneOnePOneCombo = new JComboBox<String>();
		geneOnePOneCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneOnePOneCombo.addItem(geneOptions[init]);
		}
		geneOnePOneCombo.setBackground(textFieldColor);
		geneOnePOneCombo.setForeground(textColor);
		geneOnePOneCombo.addItemListener(this);
		GridBagConstraints gbc_geneOnePOneCombo = new GridBagConstraints();
		gbc_geneOnePOneCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePOneCombo.weightx = 0.25;
		gbc_geneOnePOneCombo.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneCombo.gridx = 0;
		gbc_geneOnePOneCombo.gridy = 3;
		parentOne.add(geneOnePOneCombo, gbc_geneOnePOneCombo);
		
		//Gene One Parent One Radio HomoD
		geneOnePOneRadHomoD = new JRadioButton("AA");
		geneOnePOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePOneRadHomoD.setBackground(backgroundColor);
		geneOnePOneRadHomoD.setForeground(textColor);
		geneOnePOneRadHomoD.setEnabled(inDebugMode);
//		geneOnePOneRadHomoD.addItemListener(this);
		GridBagConstraints gbc_geneOnePOneRadHomoD = new GridBagConstraints();
		gbc_geneOnePOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePOneRadHomoD.weightx = 0.25;
		gbc_geneOnePOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneRadHomoD.gridx = 1;
		gbc_geneOnePOneRadHomoD.gridy = 3;
		parentOne.add(geneOnePOneRadHomoD, gbc_geneOnePOneRadHomoD);
		
		//Gene One Parent One Radio Hetero
		geneOnePOneRadHetero = new JRadioButton("Aa");
		geneOnePOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePOneRadHetero.setBackground(backgroundColor);
		geneOnePOneRadHetero.setForeground(textColor);
		geneOnePOneRadHetero.setEnabled(inDebugMode);
//		geneOnePOneRadHetero.addItemListener(this);
		GridBagConstraints gbc_geneOnePOneRadHetero = new GridBagConstraints();
		gbc_geneOnePOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePOneRadHetero.weightx = 0.25;
		gbc_geneOnePOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneRadHetero.gridx = 2;
		gbc_geneOnePOneRadHetero.gridy = 3;
		parentOne.add(geneOnePOneRadHetero, gbc_geneOnePOneRadHetero);
		
		//Gene One Parent One Radio HomoR
		geneOnePOneRadHomoR = new JRadioButton("aa");
		geneOnePOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePOneRadHomoR.setBackground(backgroundColor);
		geneOnePOneRadHomoR.setForeground(textColor);
		geneOnePOneRadHomoR.setEnabled(inDebugMode);
//		geneOnePOneRadHomoR.addItemListener(this);
		GridBagConstraints gbc_geneOnePOneRadHomoR = new GridBagConstraints();
		gbc_geneOnePOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneOnePOneRadHomoR.weightx = 0.25;
		gbc_geneOnePOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneRadHomoR.gridx = 3;
		gbc_geneOnePOneRadHomoR.gridy = 3;
		parentOne.add(geneOnePOneRadHomoR, gbc_geneOnePOneRadHomoR);
		
		//Gene Two Parent One Label
		geneTwoPOneLabel = new JLabel("Gene 2");
		geneTwoPOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPOneLabel.setBackground(backgroundColor);
		geneTwoPOneLabel.setForeground(textColor);
		geneTwoPOneLabel.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPOneLabel = new GridBagConstraints();
		gbc_geneTwoPOneLabel.gridwidth = 4;
		gbc_geneTwoPOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneTwoPOneLabel.weightx = 1.0;
		gbc_geneTwoPOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneLabel.gridx = 0;
		gbc_geneTwoPOneLabel.gridy = 5;
		parentOne.add(geneTwoPOneLabel, gbc_geneTwoPOneLabel);
		
		//Gene Two Parent One Combo
		geneTwoPOneCombo = new JComboBox<String>();
		geneTwoPOneCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneTwoPOneCombo.addItem(geneOptions[init]);
		}
		geneTwoPOneCombo.setBackground(textFieldColor);
		geneTwoPOneCombo.setForeground(textColor);
		geneTwoPOneCombo.addItemListener(this);
		geneTwoPOneCombo.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPOneCombo = new GridBagConstraints();
		gbc_geneTwoPOneCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPOneCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneTwoPOneCombo.gridx = 0;
		gbc_geneTwoPOneCombo.gridy = 6;
		parentOne.add(geneTwoPOneCombo, gbc_geneTwoPOneCombo);
		
		//Gene Two Parent One Radio HomoD
		geneTwoPOneRadHomoD = new JRadioButton("AA");
		geneTwoPOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPOneRadHomoD.setBackground(backgroundColor);
		geneTwoPOneRadHomoD.setForeground(textColor);
		geneTwoPOneRadHomoD.addItemListener(this);
		geneTwoPOneRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPOneRadHomoD = new GridBagConstraints();
		gbc_geneTwoPOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPOneRadHomoD.weightx = 0.25;
		gbc_geneTwoPOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneRadHomoD.gridx = 1;
		gbc_geneTwoPOneRadHomoD.gridy = 6;
		parentOne.add(geneTwoPOneRadHomoD, gbc_geneTwoPOneRadHomoD);
		
		//Gene Two Parent One Radio Hetero
		geneTwoPOneRadHetero = new JRadioButton("Aa");
		geneTwoPOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPOneRadHetero.setBackground(backgroundColor);
		geneTwoPOneRadHetero.setForeground(textColor);
		geneTwoPOneRadHetero.addItemListener(this);
		geneTwoPOneRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPOneRadHetero = new GridBagConstraints();
		gbc_geneTwoPOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPOneRadHetero.weightx = 0.25;
		gbc_geneTwoPOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneRadHetero.gridx = 2;
		gbc_geneTwoPOneRadHetero.gridy = 6;
		parentOne.add(geneTwoPOneRadHetero, gbc_geneTwoPOneRadHetero);
		
		//Gene Two Parent One Radio HomoR
		geneTwoPOneRadHomoR = new JRadioButton("aa");
		geneTwoPOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPOneRadHomoR.setBackground(backgroundColor);
		geneTwoPOneRadHomoR.setForeground(textColor);
		geneTwoPOneRadHomoR.addItemListener(this);
		geneTwoPOneRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPOneRadHomoR = new GridBagConstraints();
		gbc_geneTwoPOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneTwoPOneRadHomoR.weightx = 0.25;
		gbc_geneTwoPOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneRadHomoR.gridx = 3;
		gbc_geneTwoPOneRadHomoR.gridy = 6;
		parentOne.add(geneTwoPOneRadHomoR, gbc_geneTwoPOneRadHomoR);
		
		//Gene Three Parent One Label
		geneThreePOneLabel = new JLabel("Gene 3");
		geneThreePOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePOneLabel.setBackground(backgroundColor);
		geneThreePOneLabel.setForeground(textColor);
		geneThreePOneLabel.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePOneLabel = new GridBagConstraints();
		gbc_geneThreePOneLabel.gridwidth = 4;
		gbc_geneThreePOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneThreePOneLabel.weightx = 1.0;
		gbc_geneThreePOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneLabel.gridx = 0;
		gbc_geneThreePOneLabel.gridy = 8;
		parentOne.add(geneThreePOneLabel, gbc_geneThreePOneLabel);
		
		//Gene Three Parent One Combo
		geneThreePOneCombo = new JComboBox<String>();
		geneThreePOneCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneThreePOneCombo.addItem(geneOptions[init]);
		}
		geneThreePOneCombo.setBackground(textFieldColor);
		geneThreePOneCombo.setForeground(textColor);
		geneThreePOneCombo.addItemListener(this);
		geneThreePOneCombo.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePOneCombo = new GridBagConstraints();
		gbc_geneThreePOneCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePOneCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneThreePOneCombo.gridx = 0;
		gbc_geneThreePOneCombo.gridy = 9;
		parentOne.add(geneThreePOneCombo, gbc_geneThreePOneCombo);
		
		//Gene Three Parent One Radio HomoD
		geneThreePOneRadHomoD = new JRadioButton("AA");
		geneThreePOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePOneRadHomoD.setBackground(backgroundColor);
		geneThreePOneRadHomoD.setForeground(textColor);
		geneThreePOneRadHomoD.addItemListener(this);
		geneThreePOneRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePOneRadHomoD = new GridBagConstraints();
		gbc_geneThreePOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePOneRadHomoD.weightx = 0.25;
		gbc_geneThreePOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneRadHomoD.gridx = 1;
		gbc_geneThreePOneRadHomoD.gridy = 9;
		parentOne.add(geneThreePOneRadHomoD, gbc_geneThreePOneRadHomoD);
		
		//Gene Three Parent One Radio Hetero
		geneThreePOneRadHetero = new JRadioButton("Aa");
		geneThreePOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePOneRadHetero.setBackground(backgroundColor);
		geneThreePOneRadHetero.setForeground(textColor);
		geneThreePOneRadHetero.addItemListener(this);
		geneThreePOneRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePOneRadHetero = new GridBagConstraints();
		gbc_geneThreePOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePOneRadHetero.weightx = 0.25;
		gbc_geneThreePOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneRadHetero.gridx = 2;
		gbc_geneThreePOneRadHetero.gridy = 9;
		parentOne.add(geneThreePOneRadHetero, gbc_geneThreePOneRadHetero);
		
		//Gene Three Parent One Radio HomoR
		geneThreePOneRadHomoR = new JRadioButton("aa");
		geneThreePOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePOneRadHomoR.setBackground(backgroundColor);
		geneThreePOneRadHomoR.setForeground(textColor);
		geneThreePOneRadHomoR.addItemListener(this);
		geneThreePOneRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePOneRadHomoR = new GridBagConstraints();
		gbc_geneThreePOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneThreePOneRadHomoR.weightx = 0.25;
		gbc_geneThreePOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneRadHomoR.gridx = 3;
		gbc_geneThreePOneRadHomoR.gridy = 9;
		parentOne.add(geneThreePOneRadHomoR, gbc_geneThreePOneRadHomoR);
		
		//Gene Four Parent One Label
		geneFourPOneLabel = new JLabel("Gene 4");
		geneFourPOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPOneLabel.setBackground(backgroundColor);
		geneFourPOneLabel.setForeground(textColor);
		geneFourPOneLabel.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPOneLabel = new GridBagConstraints();
		gbc_geneFourPOneLabel.gridwidth = 4;
		gbc_geneFourPOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneFourPOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneLabel.gridx = 0;
		gbc_geneFourPOneLabel.gridy = 11;
		parentOne.add(geneFourPOneLabel, gbc_geneFourPOneLabel);
		
		//Gene Four Parent One Combo
		geneFourPOneCombo = new JComboBox<String>();
		geneFourPOneCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneFourPOneCombo.addItem(geneOptions[init]);
		}
		geneFourPOneCombo.setBackground(textFieldColor);
		geneFourPOneCombo.setForeground(textColor);
		geneFourPOneCombo.addItemListener(this);
		geneFourPOneCombo.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPOneCombo = new GridBagConstraints();
		gbc_geneFourPOneCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPOneCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneFourPOneCombo.gridx = 0;
		gbc_geneFourPOneCombo.gridy = 12;
		parentOne.add(geneFourPOneCombo, gbc_geneFourPOneCombo);
		
		//Gene Four Parent One Radio HomoD
		geneFourPOneRadHomoD = new JRadioButton("AA");
		geneFourPOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPOneRadHomoD.setBackground(backgroundColor);
		geneFourPOneRadHomoD.setForeground(textColor);
		geneFourPOneRadHomoD.addItemListener(this);
		geneFourPOneRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPOneRadHomoD = new GridBagConstraints();
		gbc_geneFourPOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPOneRadHomoD.weightx = 0.25;
		gbc_geneFourPOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneRadHomoD.gridx = 1;
		gbc_geneFourPOneRadHomoD.gridy = 12;
		parentOne.add(geneFourPOneRadHomoD, gbc_geneFourPOneRadHomoD);
		
		//Gene Four Parent One Radio Hetero
		geneFourPOneRadHetero = new JRadioButton("Aa");
		geneFourPOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPOneRadHetero.setBackground(backgroundColor);
		geneFourPOneRadHetero.setForeground(textColor);
		geneFourPOneRadHetero.addItemListener(this);
		geneFourPOneRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPOneRadHetero = new GridBagConstraints();
		gbc_geneFourPOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPOneRadHetero.weightx = 0.25;
		gbc_geneFourPOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneRadHetero.gridx = 2;
		gbc_geneFourPOneRadHetero.gridy = 12;
		parentOne.add(geneFourPOneRadHetero, gbc_geneFourPOneRadHetero);
		
		//Gene Four Parent One Radio HomoR
		geneFourPOneRadHomoR = new JRadioButton("aa");
		geneFourPOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPOneRadHomoR.setBackground(backgroundColor);
		geneFourPOneRadHomoR.setForeground(textColor);
		geneFourPOneRadHomoR.addItemListener(this);
		geneFourPOneRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPOneRadHomoR = new GridBagConstraints();
		gbc_geneFourPOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneFourPOneRadHomoR.weightx = 0.25;
		gbc_geneFourPOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneRadHomoR.gridx = 3;
		gbc_geneFourPOneRadHomoR.gridy = 12;
		parentOne.add(geneFourPOneRadHomoR, gbc_geneFourPOneRadHomoR);
		
		//Gene Five Parent One Label
		geneFivePOneLabel = new JLabel("Gene 5");
		geneFivePOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePOneLabel.setBackground(backgroundColor);
		geneFivePOneLabel.setForeground(textColor);
		geneFivePOneLabel.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePOneLabel = new GridBagConstraints();
		gbc_geneFivePOneLabel.gridwidth = 4;
		gbc_geneFivePOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneFivePOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneLabel.gridx = 0;
		gbc_geneFivePOneLabel.gridy = 14;
		parentOne.add(geneFivePOneLabel, gbc_geneFivePOneLabel);
		
		//Gene Five Parent One Combo
		geneFivePOneCombo = new JComboBox<String>();
		geneFivePOneCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneFivePOneCombo.addItem(geneOptions[init]);
		}
		geneFivePOneCombo.setBackground(textFieldColor);
		geneFivePOneCombo.setForeground(textColor);
		geneFivePOneCombo.addItemListener(this);
		geneFivePOneCombo.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePOneCombo = new GridBagConstraints();
		gbc_geneFivePOneCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePOneCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneFivePOneCombo.gridx = 0;
		gbc_geneFivePOneCombo.gridy = 15;
		parentOne.add(geneFivePOneCombo, gbc_geneFivePOneCombo);
		
		//Gene Five Parent One Radio HomoD
		geneFivePOneRadHomoD = new JRadioButton("AA");
		geneFivePOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePOneRadHomoD.setBackground(backgroundColor);
		geneFivePOneRadHomoD.setForeground(textColor);
		geneFivePOneRadHomoD.addItemListener(this);
		geneFivePOneRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePOneRadHomoD = new GridBagConstraints();
		gbc_geneFivePOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePOneRadHomoD.weightx = 0.25;
		gbc_geneFivePOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneRadHomoD.gridx = 1;
		gbc_geneFivePOneRadHomoD.gridy = 15;
		parentOne.add(geneFivePOneRadHomoD, gbc_geneFivePOneRadHomoD);
		
		//Gene Five Parent One Radio Hetero
		geneFivePOneRadHetero = new JRadioButton("Aa");
		geneFivePOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePOneRadHetero.setBackground(backgroundColor);
		geneFivePOneRadHetero.setForeground(textColor);
		geneFivePOneRadHetero.addItemListener(this);
		geneFivePOneRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePOneRadHetero = new GridBagConstraints();
		gbc_geneFivePOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePOneRadHetero.weightx = 0.25;
		gbc_geneFivePOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneRadHetero.gridx = 2;
		gbc_geneFivePOneRadHetero.gridy = 15;
		parentOne.add(geneFivePOneRadHetero, gbc_geneFivePOneRadHetero);
		
		//Gene Five Parent One Radio HomoR
		geneFivePOneRadHomoR = new JRadioButton("aa");
		geneFivePOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePOneRadHomoR.setBackground(backgroundColor);
		geneFivePOneRadHomoR.setForeground(textColor);
		geneFivePOneRadHomoR.addItemListener(this);
		geneFivePOneRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePOneRadHomoR = new GridBagConstraints();
		gbc_geneFivePOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneFivePOneRadHomoR.weightx = 0.25;
		gbc_geneFivePOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneRadHomoR.gridx = 3;
		gbc_geneFivePOneRadHomoR.gridy = 15;
		parentOne.add(geneFivePOneRadHomoR, gbc_geneFivePOneRadHomoR);
		
		//Parent One Calculation Button
		calcButton = new JButton("Calculate");
		calcButton.setBackground(backgroundColor);
		calcButton.setForeground(textColor);
		calcButton.setEnabled(inDebugMode);
//		calcButton.addMouseListener(this);
		GridBagConstraints gbc_calcButton = new GridBagConstraints();
		gbc_calcButton.gridwidth = 4;
		gbc_calcButton.weightx = 1.0;
		gbc_calcButton.fill = GridBagConstraints.BOTH;
		gbc_calcButton.gridx = 0;
		gbc_calcButton.gridy = 20;
		parentOne.add(calcButton, gbc_calcButton);
		
		//Adding all Parent One radio buttons to their corresponding ButtonGroups
		//Gene One 
		geneOnePOneBG = new ButtonGroup();
		geneOnePOneBG.add(geneOnePOneRadHomoD);
		geneOnePOneBG.add(geneOnePOneRadHetero);
		geneOnePOneBG.add(geneOnePOneRadHomoR);

		//Gene Two 
		geneTwoPOneBG = new ButtonGroup();
		geneTwoPOneBG.add(geneTwoPOneRadHomoD);
		geneTwoPOneBG.add(geneTwoPOneRadHetero);
		geneTwoPOneBG.add(geneTwoPOneRadHomoR);
		
		//Gene Three 
		geneThreePOneBG = new ButtonGroup();
		geneThreePOneBG.add(geneThreePOneRadHomoD);
		geneThreePOneBG.add(geneThreePOneRadHetero);
		geneThreePOneBG.add(geneThreePOneRadHomoR);
		
		//Gene Four
		geneFourPOneBG = new ButtonGroup();
		geneFourPOneBG.add(geneFourPOneRadHomoD);
		geneFourPOneBG.add(geneFourPOneRadHetero);
		geneFourPOneBG.add(geneFourPOneRadHomoR);
		
		//Gene Five
		geneFivePOneBG = new ButtonGroup();
		geneFivePOneBG.add(geneFivePOneRadHomoD);
		geneFivePOneBG.add(geneFivePOneRadHetero);
		geneFivePOneBG.add(geneFivePOneRadHomoR);
		
		
		
		//Parent Two Column
		JPanel parentTwo = new JPanel();
		parentTwo.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_parentTwo = new GridBagConstraints();
		gbc_parentTwo.insets = new Insets(0, 5, 0, 0);
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
		gbc_parentTwoLabel.anchor = GridBagConstraints.NORTH;
		gbc_parentTwoLabel.gridwidth = 4;
		gbc_parentTwoLabel.weightx = 1.0;
		gbc_parentTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_parentTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_parentTwoLabel.gridx = 0;
		gbc_parentTwoLabel.gridy = 0;
		parentTwo.add(parentTwoLabel, gbc_parentTwoLabel);
		
		//Gene One Parent Two Label
		geneOnePTwoLabel = new JLabel("Gene 1");
		geneOnePTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePTwoLabel.setBackground(backgroundColor);
		geneOnePTwoLabel.setForeground(textColor);
		geneOnePTwoLabel.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneOnePTwoLabel = new GridBagConstraints();
		gbc_geneOnePTwoLabel.gridwidth = 4;
		gbc_geneOnePTwoLabel.weightx = 1.0;
		gbc_geneOnePTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneOnePTwoLabel.gridx = 0;
		gbc_geneOnePTwoLabel.gridy = 2;
		parentTwo.add(geneOnePTwoLabel, gbc_geneOnePTwoLabel);
		
		//Gene One Parent Two Combo
		geneOnePTwoCombo = new JComboBox<String>();
		geneOnePTwoCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneOnePTwoCombo.addItem(geneOptions[init]);
		}
		geneOnePTwoCombo.setBackground(textFieldColor);
		geneOnePTwoCombo.setForeground(textColor);
		geneOnePTwoCombo.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneOnePTwoCombo = new GridBagConstraints();
		gbc_geneOnePTwoCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePTwoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneOnePTwoCombo.gridx = 0;
		gbc_geneOnePTwoCombo.gridy = 3;
		parentTwo.add(geneOnePTwoCombo, gbc_geneOnePTwoCombo);
		
		//Gene One Parent Two Radio HomoD
		geneOnePTwoRadHomoD = new JRadioButton("AA");
		geneOnePTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePTwoRadHomoD.setBackground(backgroundColor);
		geneOnePTwoRadHomoD.setForeground(textColor);
		geneOnePTwoRadHomoD.addItemListener(this);
		geneOnePTwoRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneOnePTwoRadHomoD = new GridBagConstraints();
		gbc_geneOnePTwoRadHomoD.weightx = 0.25;
		gbc_geneOnePTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePTwoRadHomoD.gridx = 1;
		gbc_geneOnePTwoRadHomoD.gridy = 3;
		parentTwo.add(geneOnePTwoRadHomoD, gbc_geneOnePTwoRadHomoD);
		
		//Gene One Parent Two Radio Hetero
		geneOnePTwoRadHetero = new JRadioButton("Aa");
		geneOnePTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePTwoRadHetero.setBackground(backgroundColor);
		geneOnePTwoRadHetero.setForeground(textColor);
		geneOnePTwoRadHetero.addItemListener(this);
		geneOnePTwoRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneOnePTwoRadHetero = new GridBagConstraints();
		gbc_geneOnePTwoRadHetero.weightx = 0.25;
		gbc_geneOnePTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePTwoRadHetero.gridx = 2;
		gbc_geneOnePTwoRadHetero.gridy = 3;
		parentTwo.add(geneOnePTwoRadHetero, gbc_geneOnePTwoRadHetero);
		
		//Gene One Parent Two Radio HomoR
		geneOnePTwoRadHomoR = new JRadioButton("aa");
		geneOnePTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePTwoRadHomoR.setBackground(backgroundColor);
		geneOnePTwoRadHomoR.setForeground(textColor);
		geneOnePTwoRadHomoR.addItemListener(this);
		geneOnePTwoRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneOnePTwoRadHomoR = new GridBagConstraints();
		gbc_geneOnePTwoRadHomoR.weightx = 0.25;
		gbc_geneOnePTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneOnePTwoRadHomoR.gridx = 3;
		gbc_geneOnePTwoRadHomoR.gridy = 3;
		parentTwo.add(geneOnePTwoRadHomoR, gbc_geneOnePTwoRadHomoR);
		
		//Gene Two Parent Two Label
		geneTwoPTwoLabel = new JLabel("Gene 2");
		geneTwoPTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPTwoLabel.setBackground(backgroundColor);
		geneTwoPTwoLabel.setForeground(textColor);
		geneTwoPTwoLabel.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPTwoLabel = new GridBagConstraints();
		gbc_geneTwoPTwoLabel.gridwidth = 4;
		gbc_geneTwoPTwoLabel.weightx = 1.0;
		gbc_geneTwoPTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneTwoPTwoLabel.gridx = 0;
		gbc_geneTwoPTwoLabel.gridy = 5;
		parentTwo.add(geneTwoPTwoLabel, gbc_geneTwoPTwoLabel);
		
		//Gene Two Parent Two Combo
		geneTwoPTwoCombo = new JComboBox<String>();
		geneTwoPTwoCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneTwoPTwoCombo.addItem(geneOptions[init]);
		}
		geneTwoPTwoCombo.setBackground(textFieldColor);
		geneTwoPTwoCombo.setForeground(textColor);
		geneTwoPTwoCombo.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPTwoCombo = new GridBagConstraints();
		gbc_geneTwoPTwoCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPTwoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneTwoPTwoCombo.gridx = 0;
		gbc_geneTwoPTwoCombo.gridy = 6;
		parentTwo.add(geneTwoPTwoCombo, gbc_geneTwoPTwoCombo);
		
		//Gene Two Parent Two Radio HomoD
		geneTwoPTwoRadHomoD = new JRadioButton("AA");
		geneTwoPTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPTwoRadHomoD.setBackground(backgroundColor);
		geneTwoPTwoRadHomoD.setForeground(textColor);
		geneTwoPTwoRadHomoD.addItemListener(this);
		geneTwoPTwoRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPTwoRadHomoD = new GridBagConstraints();
		gbc_geneTwoPTwoRadHomoD.weightx = 0.25;
		gbc_geneTwoPTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPTwoRadHomoD.gridx = 1;
		gbc_geneTwoPTwoRadHomoD.gridy = 6;
		parentTwo.add(geneTwoPTwoRadHomoD, gbc_geneTwoPTwoRadHomoD);
		
		//Gene Two Parent Two Radio Hetero
		geneTwoPTwoRadHetero = new JRadioButton("Aa");
		geneTwoPTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPTwoRadHetero.setBackground(backgroundColor);
		geneTwoPTwoRadHetero.setForeground(textColor);
		geneTwoPTwoRadHetero.addItemListener(this);
		geneTwoPTwoRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPTwoRadHetero = new GridBagConstraints();
		gbc_geneTwoPTwoRadHetero.weightx = 0.25;
		gbc_geneTwoPTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPTwoRadHetero.gridx = 2;
		gbc_geneTwoPTwoRadHetero.gridy = 6;
		parentTwo.add(geneTwoPTwoRadHetero, gbc_geneTwoPTwoRadHetero);
		
		//Gene Two Parent Two Radio HomoR
		geneTwoPTwoRadHomoR = new JRadioButton("aa");
		geneTwoPTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPTwoRadHomoR.setBackground(backgroundColor);
		geneTwoPTwoRadHomoR.setForeground(textColor);
		geneTwoPTwoRadHomoR.addItemListener(this);
		geneTwoPTwoRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPTwoRadHomoR = new GridBagConstraints();
		gbc_geneTwoPTwoRadHomoR.weightx = 0.25;
		gbc_geneTwoPTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneTwoPTwoRadHomoR.gridx = 3;
		gbc_geneTwoPTwoRadHomoR.gridy = 6;
		parentTwo.add(geneTwoPTwoRadHomoR, gbc_geneTwoPTwoRadHomoR);
		
		//Gene Three Parent Two Label
		geneThreePTwoLabel = new JLabel("Gene 3");
		geneThreePTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePTwoLabel.setBackground(backgroundColor);
		geneThreePTwoLabel.setForeground(textColor);
		geneThreePTwoLabel.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePTwoLabel = new GridBagConstraints();
		gbc_geneThreePTwoLabel.gridwidth = 4;
		gbc_geneThreePTwoLabel.weightx = 1.0;
		gbc_geneThreePTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneThreePTwoLabel.gridx = 0;
		gbc_geneThreePTwoLabel.gridy = 8;
		parentTwo.add(geneThreePTwoLabel, gbc_geneThreePTwoLabel);
		
		//Gene Three Parent Two Combo
		geneThreePTwoCombo = new JComboBox<String>();
		geneThreePTwoCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneThreePTwoCombo.addItem(geneOptions[init]);
		}
		geneThreePTwoCombo.setBackground(textFieldColor);
		geneThreePTwoCombo.setForeground(textColor);
		geneThreePTwoCombo.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePTwoCombo = new GridBagConstraints();
		gbc_geneThreePTwoCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePTwoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneThreePTwoCombo.gridx = 0;
		gbc_geneThreePTwoCombo.gridy = 9;
		parentTwo.add(geneThreePTwoCombo, gbc_geneThreePTwoCombo);
		
		//Gene Three Parent Two Radio HomoD
		geneThreePTwoRadHomoD = new JRadioButton("AA");
		geneThreePTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePTwoRadHomoD.setBackground(backgroundColor);
		geneThreePTwoRadHomoD.setForeground(textColor);
		geneThreePTwoRadHomoD.addItemListener(this);
		geneThreePTwoRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePTwoRadHomoD = new GridBagConstraints();
		gbc_geneThreePTwoRadHomoD.weightx = 0.25;
		gbc_geneThreePTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePTwoRadHomoD.gridx = 1;
		gbc_geneThreePTwoRadHomoD.gridy = 9;
		parentTwo.add(geneThreePTwoRadHomoD, gbc_geneThreePTwoRadHomoD);
		
		//Gene Three Parent Two Radio Hetero
		geneThreePTwoRadHetero = new JRadioButton("Aa");
		geneThreePTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePTwoRadHetero.setBackground(backgroundColor);
		geneThreePTwoRadHetero.setForeground(textColor);
		geneThreePTwoRadHetero.addItemListener(this);
		geneThreePTwoRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePTwoRadHetero = new GridBagConstraints();
		gbc_geneThreePTwoRadHetero.weightx = 0.25;
		gbc_geneThreePTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePTwoRadHetero.gridx = 2;
		gbc_geneThreePTwoRadHetero.gridy = 9;
		parentTwo.add(geneThreePTwoRadHetero, gbc_geneThreePTwoRadHetero);
		
		//Gene Three Parent Two Radio HomoR
		geneThreePTwoRadHomoR = new JRadioButton("aa");
		geneThreePTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePTwoRadHomoR.setBackground(backgroundColor);
		geneThreePTwoRadHomoR.setForeground(textColor);
		geneThreePTwoRadHomoR.addItemListener(this);
		geneThreePTwoRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePTwoRadHomoR = new GridBagConstraints();
		gbc_geneThreePTwoRadHomoR.weightx = 0.25;
		gbc_geneThreePTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneThreePTwoRadHomoR.gridx = 3;
		gbc_geneThreePTwoRadHomoR.gridy = 9;
		parentTwo.add(geneThreePTwoRadHomoR, gbc_geneThreePTwoRadHomoR);
		
		//Gene Four Parent Two Label
		geneFourPTwoLabel = new JLabel("Gene 4");
		geneFourPTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPTwoLabel.setBackground(backgroundColor);
		geneFourPTwoLabel.setForeground(textColor);
		geneFourPTwoLabel.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPTwoLabel = new GridBagConstraints();
		gbc_geneFourPTwoLabel.gridwidth = 4;
		gbc_geneFourPTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneFourPTwoLabel.gridx = 0;
		gbc_geneFourPTwoLabel.gridy = 11;
		parentTwo.add(geneFourPTwoLabel, gbc_geneFourPTwoLabel);
		
		//Gene Four Parent Two Combo
		geneFourPTwoCombo = new JComboBox<String>();
		geneFourPTwoCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneFourPTwoCombo.addItem(geneOptions[init]);
		}
		geneFourPTwoCombo.setBackground(textFieldColor);
		geneFourPTwoCombo.setForeground(textColor);
		geneFourPTwoCombo.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPTwoCombo = new GridBagConstraints();
		gbc_geneFourPTwoCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPTwoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneFourPTwoCombo.gridx = 0;
		gbc_geneFourPTwoCombo.gridy = 12;
		parentTwo.add(geneFourPTwoCombo, gbc_geneFourPTwoCombo);
		
		//Gene Four Parent Two Radio HomoD
		geneFourPTwoRadHomoD = new JRadioButton("AA");
		geneFourPTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPTwoRadHomoD.setBackground(backgroundColor);
		geneFourPTwoRadHomoD.setForeground(textColor);
		geneFourPTwoRadHomoD.addItemListener(this);
		geneFourPTwoRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPTwoRadHomoD = new GridBagConstraints();
		gbc_geneFourPTwoRadHomoD.weightx = 0.25;
		gbc_geneFourPTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPTwoRadHomoD.gridx = 1;
		gbc_geneFourPTwoRadHomoD.gridy = 12;
		parentTwo.add(geneFourPTwoRadHomoD, gbc_geneFourPTwoRadHomoD);
		
		//Gene Four Parent Two Radio Hetero
		geneFourPTwoRadHetero = new JRadioButton("Aa");
		geneFourPTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPTwoRadHetero.setBackground(backgroundColor);
		geneFourPTwoRadHetero.setForeground(textColor);
		geneFourPTwoRadHetero.addItemListener(this);
		geneFourPTwoRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPTwoRadHetero = new GridBagConstraints();
		gbc_geneFourPTwoRadHetero.weightx = 0.25;
		gbc_geneFourPTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPTwoRadHetero.gridx = 2;
		gbc_geneFourPTwoRadHetero.gridy = 12;
		parentTwo.add(geneFourPTwoRadHetero, gbc_geneFourPTwoRadHetero);
		
		//Gene Four Parent Two Radio HomoR
		geneFourPTwoRadHomoR = new JRadioButton("aa");
		geneFourPTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPTwoRadHomoR.setBackground(backgroundColor);
		geneFourPTwoRadHomoR.setForeground(textColor);
		geneFourPTwoRadHomoR.addItemListener(this);
		geneFourPTwoRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPTwoRadHomoR = new GridBagConstraints();
		gbc_geneFourPTwoRadHomoR.weightx = 0.25;
		gbc_geneFourPTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneFourPTwoRadHomoR.gridx = 3;
		gbc_geneFourPTwoRadHomoR.gridy = 12;
		parentTwo.add(geneFourPTwoRadHomoR, gbc_geneFourPTwoRadHomoR);
		
		//Gene Five Parent Two Label
		geneFivePTwoLabel = new JLabel("Gene 5");
		geneFivePTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePTwoLabel.setBackground(backgroundColor);
		geneFivePTwoLabel.setForeground(textColor);
		geneFivePTwoLabel.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePTwoLabel = new GridBagConstraints();
		gbc_geneFivePTwoLabel.gridwidth = 4;
		gbc_geneFivePTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneFivePTwoLabel.gridx = 0;
		gbc_geneFivePTwoLabel.gridy = 14;
		parentTwo.add(geneFivePTwoLabel, gbc_geneFivePTwoLabel);
		
		//Gene Five Parent Two Combo
		geneFivePTwoCombo = new JComboBox<String>();
		geneFivePTwoCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneFivePTwoCombo.addItem(geneOptions[init]);
		}
		geneFivePTwoCombo.setBackground(textFieldColor);
		geneFivePTwoCombo.setForeground(textColor);
		geneFivePTwoCombo.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePTwoCombo = new GridBagConstraints();
		gbc_geneFivePTwoCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePTwoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneFivePTwoCombo.gridx = 0;
		gbc_geneFivePTwoCombo.gridy = 15;
		parentTwo.add(geneFivePTwoCombo, gbc_geneFivePTwoCombo);
		
		//Gene Five Parent Two Radio HomoD 
		geneFivePTwoRadHomoD = new JRadioButton("AA");
		geneFivePTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePTwoRadHomoD.setBackground(backgroundColor);
		geneFivePTwoRadHomoD.setForeground(textColor);
		geneFivePTwoRadHomoD.addItemListener(this);
		geneFivePTwoRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePTwoRadHomoD = new GridBagConstraints();
		gbc_geneFivePTwoRadHomoD.weightx = 0.25;
		gbc_geneFivePTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePTwoRadHomoD.gridx = 1;
		gbc_geneFivePTwoRadHomoD.gridy = 15;
		parentTwo.add(geneFivePTwoRadHomoD, gbc_geneFivePTwoRadHomoD);
		
		//Gene Five Parent Two Radio Hetero
		geneFivePTwoRadHetero = new JRadioButton("Aa");
		geneFivePTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePTwoRadHetero.setBackground(backgroundColor);
		geneFivePTwoRadHetero.setForeground(textColor);
		geneFivePTwoRadHetero.addItemListener(this);
		geneFivePTwoRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePTwoRadHetero = new GridBagConstraints();
		gbc_geneFivePTwoRadHetero.weightx = 0.25;
		gbc_geneFivePTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePTwoRadHetero.gridx = 2;
		gbc_geneFivePTwoRadHetero.gridy = 15;
		parentTwo.add(geneFivePTwoRadHetero, gbc_geneFivePTwoRadHetero);
		
		//Gene Five Parent Two Radio HomoR
		geneFivePTwoRadHomoR = new JRadioButton("aa");
		geneFivePTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePTwoRadHomoR.setBackground(backgroundColor);
		geneFivePTwoRadHomoR.setForeground(textColor);
		geneFivePTwoRadHomoR.addItemListener(this);
		geneFivePTwoRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePTwoRadHomoR = new GridBagConstraints();
		gbc_geneFivePTwoRadHomoR.weightx = 0.25;
		gbc_geneFivePTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneFivePTwoRadHomoR.gridx = 3;
		gbc_geneFivePTwoRadHomoR.gridy = 15;
		parentTwo.add(geneFivePTwoRadHomoR, gbc_geneFivePTwoRadHomoR);
		
		//Reset Button 
		resetButton = new JButton("Reset");
		resetButton.setBackground(backgroundColor);
		resetButton.setForeground(textColor);
		resetButton.addMouseListener(this);
		GridBagConstraints gbc_resetButton = new GridBagConstraints();
		gbc_resetButton.gridwidth = 4;
		gbc_resetButton.weightx = 1.0;
		gbc_resetButton.fill = GridBagConstraints.BOTH;
		gbc_resetButton.gridx = 0;
		gbc_resetButton.gridy = 20;
		parentTwo.add(resetButton, gbc_resetButton);
		
		//Adding all Parent Two radio buttons to their corresponding ButtonGroups
		//Gene One 
		geneOnePTwoBG = new ButtonGroup();
		geneOnePTwoBG.add(geneOnePTwoRadHomoD);
		geneOnePTwoBG.add(geneOnePTwoRadHetero);
		geneOnePTwoBG.add(geneOnePTwoRadHomoR);

		//Gene Two
		geneTwoPTwoBG = new ButtonGroup();
		geneTwoPTwoBG.add(geneTwoPTwoRadHomoD);
		geneTwoPTwoBG.add(geneTwoPTwoRadHetero);
		geneTwoPTwoBG.add(geneTwoPTwoRadHomoR);
		
		//Gene Three
		geneThreePTwoBG = new ButtonGroup();
		geneThreePTwoBG.add(geneThreePTwoRadHomoD);
		geneThreePTwoBG.add(geneThreePTwoRadHetero);
		geneThreePTwoBG.add(geneThreePTwoRadHomoR);
		
		//Gene Four
		geneFourPTwoBG = new ButtonGroup();
		geneFourPTwoBG.add(geneFourPTwoRadHomoD);
		geneFourPTwoBG.add(geneFourPTwoRadHetero);
		geneFourPTwoBG.add(geneFourPTwoRadHomoR);
		
		//Gene Five
		geneFivePTwoBG = new ButtonGroup();
		geneFivePTwoBG.add(geneFivePTwoRadHomoD);
		geneFivePTwoBG.add(geneFivePTwoRadHetero);
		geneFivePTwoBG.add(geneFivePTwoRadHomoR);
		
		
		
		//Results Column
		JPanel resultsPanel = new JPanel();
		//temp, fix color later.
		resultsPanel.setBackground(backgroundColor);
		resultsPanel.setForeground(textColor);
		GridBagConstraints gbc_resultsPanel = new GridBagConstraints();
		gbc_resultsPanel.insets = new Insets(0, 5, 0, 0);
		gbc_resultsPanel.gridwidth = 2;
		gbc_resultsPanel.weighty = 1.0;
		gbc_resultsPanel.weightx = 0.6;
		gbc_resultsPanel.fill = GridBagConstraints.BOTH;
		gbc_resultsPanel.gridx = 2;
		gbc_resultsPanel.gridy = 0;
		content.add(resultsPanel, gbc_resultsPanel);
		GridBagLayout gbl_resultsPanel = new GridBagLayout();
		gbl_resultsPanel.columnWidths = new int[]{265, 0, 0, 0, 0, 0};
		gbl_resultsPanel.rowHeights = new int[]{14, 525, 22, 0};
		gbl_resultsPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0};
		gbl_resultsPanel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		resultsPanel.setLayout(gbl_resultsPanel);
		
		//Results Label
		JLabel resultsLabel = new JLabel("Results");
		resultsLabel.setBackground(backgroundColor);
		resultsLabel.setForeground(textColor);
		resultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblResults = new GridBagConstraints();
		gbc_lblResults.gridwidth = 3;
		gbc_lblResults.insets = new Insets(0, 0, 5, 5);
		gbc_lblResults.anchor = GridBagConstraints.NORTH;
		gbc_lblResults.weighty = 0.01;
		gbc_lblResults.fill = GridBagConstraints.BOTH;
		gbc_lblResults.gridx = 0;
		gbc_lblResults.gridy = 0;
		resultsPanel.add(resultsLabel, gbc_lblResults);
		
		//Results JTextArea
		JTextArea resultsJTA = new JTextArea();
		resultsJTA.setBackground(textFieldColor);
		resultsJTA.setForeground(textColor);
		resultsJTA.setEditable(false);
		GridBagConstraints gbc_resultsJTA = new GridBagConstraints();
		gbc_resultsJTA.weightx = 1.0;
		gbc_resultsJTA.fill = GridBagConstraints.BOTH;
		gbc_resultsJTA.weighty = 1.0;
		gbc_resultsJTA.gridx = 0;
		gbc_resultsJTA.gridy = 1;
		resultsPanel.add(resultsJTA, gbc_resultsJTA);
		
		//COMMENT OUT FOR DESIGN
		window.pack();
		window.setVisible(true);
		
	}

	//For Mouse clicks on the Radials &
	//Calculate and Reset Buttons.
	public void mouseClicked(MouseEvent e) 
	{
		if (e.getSource().equals(calcButton))
		{
			System.out.print("CALCULATE BUTTON using: |");
			System.out.print(geneOnePOneCombo.getSelectedItem().toString() + "| |");
			System.out.print(geneTwoPOneCombo.getSelectedItem().toString() + "| |");
			System.out.print(geneThreePOneCombo.getSelectedItem().toString() + "| |");
			System.out.print(geneFourPOneCombo.getSelectedItem().toString() + "| |");
			System.out.print(geneFivePOneCombo.getSelectedItem().toString() + "|\n");
			
		/*Error Check the combo boxes/radials
		 *1: Make sure each gene has a radial selected.
		 * NOTE: Make each Item Selection remove itself from the
		 * combo box list? Is that doable? 
		 */
		
		}
		else if (e.getSource().equals(resetButton))
		{
			System.out.println("RESET BUTTON");
//			clearAllCombosAndRadios();
		}
	}

	public void mouseEntered(MouseEvent arg0){}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0){}

	public void mouseReleased(MouseEvent arg0){}

	//For ComboBoxes' selection changes and Radio Button Selections.
	public void itemStateChanged(ItemEvent e) 
	{
		if (e.getStateChange() == ItemEvent.SELECTED)
		{
			
			if (e.getSource() instanceof JComboBox)
			{
				System.out.println("Action is a JComboBox");
				if (e.getSource().equals(geneOnePOneCombo))
				{
					System.out.println("G1P1: Selected Item: " + e.getItem().toString());
					if (!(e.getItem().equals(defaultComboItem)))
					{
						if (geneOnePOneCombo.getSelectedIndex() != 0 && !geneTwoPOneCombo.isEnabled())
						{
							geneOnePTwoLabel.setEnabled(true);
							toggleButtonGroup(geneOnePOneBG);
							toggleButtonGroup(geneOnePTwoBG);
							toggleNextComboBox(geneTwoPOneCombo);
							
						}
						calcButton.addMouseListener(this);
						calcButton.setEnabled(true);
					}
					else 
					{
						geneOnePTwoLabel.setEnabled(true);
						toggleButtonGroup(geneOnePOneBG);
						toggleButtonGroup(geneOnePTwoBG);
						toggleNextComboBox(geneTwoPOneCombo);

						calcButton.removeMouseListener(this);
						calcButton.setEnabled(false);
					}
				}
				else if (e.getSource().equals(geneTwoPOneCombo))
				{
					System.out.println("G2P1: Selected Item: " + e.getItem().toString());
				}
				if (e.getSource().equals(geneThreePOneCombo))
				{
					System.out.println("G3P1: Selected Item: " + e.getItem().toString());
				}
				if (e.getSource().equals(geneFourPOneCombo))
				{
					System.out.println("G4P1: Selected Item: " + e.getItem().toString());
				}
				if (e.getSource().equals(geneFivePOneCombo))
				{
					System.out.println("G5P1: Selected Item: " + e.getItem().toString());
				}
			}
			else if (e.getSource() instanceof JRadioButton)
			{
				System.out.println("Action is a JRadioButton");
				JRadioButton jrb = (JRadioButton)e.getSource();
				System.out.println("Selected Source = " + jrb.getText());
				
			}
		}
		
	}

	private void toggleButtonGroup(ButtonGroup buttonGroup)
	{
		Enumeration<AbstractButton> buttons = buttonGroup.getElements();
		while (buttons.hasMoreElements())
		{
			JRadioButton jrb = (JRadioButton)buttons.nextElement();
			if (jrb.isEnabled() && jrb.getItemListeners().length > 0)
			{
				buttonGroup.clearSelection();
				jrb.setEnabled(false);
				jrb.removeItemListener(this);
				System.out.println("Button Row Deactivated.");
			}
			else
			{
				jrb.setEnabled(true);
				jrb.addItemListener(this);
				System.out.println("Button Row Activated.");
				
			}
		}
	}
	
	private void toggleNextComboBox(JComboBox<String> comboBox)
	{
		if (comboBox.isEnabled() && comboBox.getItemListeners().length > 0)
		{
			comboBox.setSelectedIndex(0);
			comboBox.setEnabled(false);
			comboBox.removeItemListener(this);
			System.out.println("Combo Box Deactivated.");
		}
		else
		{
			comboBox.setEnabled(true);
			comboBox.addItemListener(this);
			System.out.println("Combo Box Activated.");
		}
	}
	
}
