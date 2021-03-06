/**
 * Punnett Me is an app to use for Punnett Squares for Genetic Trait Calculations.
 * You can calculate up to 5 different traits at once.
 * You can quickly change from Homozygous parents and Heterozygous parents 
 * for comparisons.
 * 
 * Uses Design by Contract programming style.
 * 
 * Scott Smalley, BS Software Engineering student at Utah Valley University
 * Fall 2020 expected graduation
 * scottsmalley90@gmail.com
 * 
 * @author Scott Smalley
 */
package punnettme;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JTextArea;
import java.awt.Dimension;
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
	 *BG = ButtonGroup (Radio Buttons only)
	 *HomoD = Homozygous Dominant (Gene trait) 
	 *Hetero = Heterozygous(Gene trait) 
	 *HomoR = Homozygous Recessive (Gene trait) 
	 */
	
	//Parent One - JComboBox to select the letter
	//to represent the gene.
	private JComboBox<String> geneOnePOneCombo;
	private JComboBox<String> geneTwoPOneCombo;
	private JComboBox<String> geneThreePOneCombo;
	private JComboBox<String> geneFourPOneCombo;
	private JComboBox<String> geneFivePOneCombo;
		
		//Parent One Gene Labels
	private JLabel geneTwoPOneLabel;
	private JLabel geneThreePOneLabel;
	private JLabel geneFourPOneLabel;
	private JLabel geneFivePOneLabel;

		//Parent One ButtonGroups for JRadioButtons
		//representing Allele types (AA, Aa, aa)
	private ButtonGroup geneOnePOneBG;
	private ButtonGroup geneTwoPOneBG;
	private ButtonGroup geneThreePOneBG;
	private ButtonGroup geneFourPOneBG;
	private ButtonGroup geneFivePOneBG;
	
		//Parent One each JRadioButton that
		//will be added to the corresponding
		//ButtonGroup above.
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

	//Parent Two - JComboBox to select the letter
	//to represent the gene.
	private JComboBox<String> geneOnePTwoCombo;
	private JComboBox<String> geneTwoPTwoCombo;
	private JComboBox<String> geneThreePTwoCombo;
	private JComboBox<String> geneFourPTwoCombo;
	private JComboBox<String> geneFivePTwoCombo;
	
		//Parent Two Gene Labels
	private JLabel geneOnePTwoLabel;
	private JLabel geneTwoPTwoLabel;
	private JLabel geneThreePTwoLabel;
	private JLabel geneFourPTwoLabel;
	private JLabel geneFivePTwoLabel;
	
		//Parent One ButtonGroups for JRadioButtons
		//representing Allele types (AA, Aa, aa)
	private ButtonGroup geneOnePTwoBG;
	private ButtonGroup geneTwoPTwoBG;
	private ButtonGroup geneThreePTwoBG;
	private ButtonGroup geneFourPTwoBG;
	private ButtonGroup geneFivePTwoBG;
	
		//Parent One each JRadioButton that
		//will be added to the corresponding
		//ButtonGroup above.
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
	
	//List of JComboBoxes for each Parent.
	//List of ParentOne and ParentTwo Labels.
	//List of ButtonGroups for ParentOne and ParentTwo.
	private List<JComboBox<String>> comboBoxPOneList;
	private List<JComboBox<String>> comboBoxPTwoList;
	private List<JLabel> geneLabelList;
	private List<ButtonGroup> buttonGroupList;
	
	//Parent One and Two Buttons for initiating Calculations
	//and resetting the JComboBoxes, JRadioButtons, JLabels,
	//and the results JTextArea.
	private JButton resetButton;
	private JButton calcButton;
	
	//Results
	private JPanel resultsPanel;
	private JTextArea resultsJTA;
	
//	//Default GUI Colors
//	private Color textColor = Color.decode("#E3E7FF");
//	private Color backgroundColor = Color.decode("#404047");
//	private Color textFieldColor = Color.decode("#837676");

	//Default GUI Colors
	private Color textColor = Color.decode("#DCDDD8");
	private Color backgroundColor = Color.decode("#354B5E");
	private Color textFieldColor = Color.decode("#475F77");
	private Color disabledColor = Color.decode("#D74B4B");
	
//	//Default GUI Colors
//	private Color textColor = Color.WHITE;
//	private Color backgroundColor = Color.DARK_GRAY;
//	private Color textFieldColor = Color.GRAY;
	
	
	
	//JComboBoxes options.
	private String[] geneOptions = {"Select Symbol","A","B","C","D","E",
									"F","G","H","I","J","K",
									"L","M","N","O","P","Q",
									"R","S","T","U","V","W",
									"X","Y","Z"};
	private String defaultComboItem = "Select Symbol";
	
	//*PunnettMe Globals
	private PunnettMeCalculations pm;
	
	//Debug Switch 
	private boolean inDebugMode = false;
	
	public static void main (String[] args)
	{
		SwingUtilities.invokeLater(new PunnettMeGUI());
	}

	//Outward facing run method for calling private start method.
	public void run() 
	{
		start();
	}

	/**
	 *  Builds the GUI. Initializes the PunnettMe Object and
	 *  ArrayLists.
	 * 
	 * GUI variable layout breakdown:
	 * Ex: geneOnePOneLabel
	 * 
	 * geneOne = First Gene identifier
	 * POne = Parent One identifier
	 * Label == Description of the Object
	 */
	
	private void start() 
	{
		
		//*********** PunnettMe Code init ***********
		pm = new PunnettMeCalculations();
		comboBoxPOneList = new ArrayList<>();
		comboBoxPTwoList = new ArrayList<>();
		geneLabelList = new ArrayList<>();
		buttonGroupList = new ArrayList<>();
		
		//*********** GUI START ***********
		//Window 
		window = new JFrame();
		window.setBackground(Color.DARK_GRAY);
		window.setTitle("PunnettMe");
		window.setBounds(100, 100, 800, 600);
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
		JPanel parentOnePanel = new JPanel();
		parentOnePanel.setBackground(backgroundColor);
		parentOnePanel.setForeground(backgroundColor);
		GridBagConstraints gbc_parentOne = new GridBagConstraints();
		gbc_parentOne.insets = new Insets(0, 5, 0, 0);
		gbc_parentOne.weighty = 1.0;
		gbc_parentOne.weightx = 0.2;
		gbc_parentOne.fill = GridBagConstraints.BOTH;
		gbc_parentOne.gridx = 0;
		gbc_parentOne.gridy = 0;
		content.add(parentOnePanel, gbc_parentOne);
		GridBagLayout gbl_parentOne = new GridBagLayout();
		gbl_parentOne.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_parentOne.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_parentOne.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_parentOne.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		parentOnePanel.setLayout(gbl_parentOne);
	
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
		parentOnePanel.add(parentOneLabel, gbc_parentOneLabel);
		
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
		parentOnePanel.add(geneOnePOneLabel, gbc_geneOnePOneLabel);
		
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
		comboBoxPOneList.add(geneOnePOneCombo);
		GridBagConstraints gbc_geneOnePOneCombo = new GridBagConstraints();
		gbc_geneOnePOneCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePOneCombo.weightx = 0.25;
		gbc_geneOnePOneCombo.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneCombo.gridx = 0;
		gbc_geneOnePOneCombo.gridy = 3;
		parentOnePanel.add(geneOnePOneCombo, gbc_geneOnePOneCombo);
		
		//Gene One Parent One Radio HomoD
		geneOnePOneRadHomoD = new JRadioButton("AA");
		geneOnePOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePOneRadHomoD.setBackground(backgroundColor);
		geneOnePOneRadHomoD.setForeground(textColor);
		geneOnePOneRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneOnePOneRadHomoD = new GridBagConstraints();
		gbc_geneOnePOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePOneRadHomoD.weightx = 0.25;
		gbc_geneOnePOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneRadHomoD.gridx = 1;
		gbc_geneOnePOneRadHomoD.gridy = 3;
		parentOnePanel.add(geneOnePOneRadHomoD, gbc_geneOnePOneRadHomoD);
		
		//Gene One Parent One Radio Hetero
		geneOnePOneRadHetero = new JRadioButton("Aa");
		geneOnePOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePOneRadHetero.setBackground(backgroundColor);
		geneOnePOneRadHetero.setForeground(textColor);
		geneOnePOneRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneOnePOneRadHetero = new GridBagConstraints();
		gbc_geneOnePOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePOneRadHetero.weightx = 0.25;
		gbc_geneOnePOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneRadHetero.gridx = 2;
		gbc_geneOnePOneRadHetero.gridy = 3;
		parentOnePanel.add(geneOnePOneRadHetero, gbc_geneOnePOneRadHetero);
		
		//Gene One Parent One Radio HomoR
		geneOnePOneRadHomoR = new JRadioButton("aa");
		geneOnePOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePOneRadHomoR.setBackground(backgroundColor);
		geneOnePOneRadHomoR.setForeground(textColor);
		geneOnePOneRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneOnePOneRadHomoR = new GridBagConstraints();
		gbc_geneOnePOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneOnePOneRadHomoR.weightx = 0.25;
		gbc_geneOnePOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneRadHomoR.gridx = 3;
		gbc_geneOnePOneRadHomoR.gridy = 3;
		parentOnePanel.add(geneOnePOneRadHomoR, gbc_geneOnePOneRadHomoR);
		
		//Gene Two Parent One Label
		geneTwoPOneLabel = new JLabel("Gene 2");
		geneTwoPOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPOneLabel.setBackground(backgroundColor);
		geneTwoPOneLabel.setForeground(textColor);
		geneTwoPOneLabel.setEnabled(inDebugMode);
		geneLabelList.add(geneTwoPOneLabel);
		GridBagConstraints gbc_geneTwoPOneLabel = new GridBagConstraints();
		gbc_geneTwoPOneLabel.gridwidth = 4;
		gbc_geneTwoPOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneTwoPOneLabel.weightx = 1.0;
		gbc_geneTwoPOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneLabel.gridx = 0;
		gbc_geneTwoPOneLabel.gridy = 5;
		parentOnePanel.add(geneTwoPOneLabel, gbc_geneTwoPOneLabel);
		
		//Gene Two Parent One Combo
		geneTwoPOneCombo = new JComboBox<String>();
		geneTwoPOneCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneTwoPOneCombo.addItem(geneOptions[init]);
		}
		geneTwoPOneCombo.setBackground(textFieldColor);
		geneTwoPOneCombo.setForeground(textColor);
		geneTwoPOneCombo.setEnabled(inDebugMode);
		comboBoxPOneList.add(geneTwoPOneCombo);
		GridBagConstraints gbc_geneTwoPOneCombo = new GridBagConstraints();
		gbc_geneTwoPOneCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPOneCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneTwoPOneCombo.gridx = 0;
		gbc_geneTwoPOneCombo.gridy = 6;
		parentOnePanel.add(geneTwoPOneCombo, gbc_geneTwoPOneCombo);
		
		//Gene Two Parent One Radio HomoD
		geneTwoPOneRadHomoD = new JRadioButton("AA");
		geneTwoPOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPOneRadHomoD.setBackground(backgroundColor);
		geneTwoPOneRadHomoD.setForeground(textColor);
		geneTwoPOneRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPOneRadHomoD = new GridBagConstraints();
		gbc_geneTwoPOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPOneRadHomoD.weightx = 0.25;
		gbc_geneTwoPOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneRadHomoD.gridx = 1;
		gbc_geneTwoPOneRadHomoD.gridy = 6;
		parentOnePanel.add(geneTwoPOneRadHomoD, gbc_geneTwoPOneRadHomoD);
		
		//Gene Two Parent One Radio Hetero
		geneTwoPOneRadHetero = new JRadioButton("Aa");
		geneTwoPOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPOneRadHetero.setBackground(backgroundColor);
		geneTwoPOneRadHetero.setForeground(textColor);
		geneTwoPOneRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPOneRadHetero = new GridBagConstraints();
		gbc_geneTwoPOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPOneRadHetero.weightx = 0.25;
		gbc_geneTwoPOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneRadHetero.gridx = 2;
		gbc_geneTwoPOneRadHetero.gridy = 6;
		parentOnePanel.add(geneTwoPOneRadHetero, gbc_geneTwoPOneRadHetero);
		
		//Gene Two Parent One Radio HomoR
		geneTwoPOneRadHomoR = new JRadioButton("aa");
		geneTwoPOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPOneRadHomoR.setBackground(backgroundColor);
		geneTwoPOneRadHomoR.setForeground(textColor);
		geneTwoPOneRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPOneRadHomoR = new GridBagConstraints();
		gbc_geneTwoPOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneTwoPOneRadHomoR.weightx = 0.25;
		gbc_geneTwoPOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneRadHomoR.gridx = 3;
		gbc_geneTwoPOneRadHomoR.gridy = 6;
		parentOnePanel.add(geneTwoPOneRadHomoR, gbc_geneTwoPOneRadHomoR);
		
		//Gene Three Parent One Label
		geneThreePOneLabel = new JLabel("Gene 3");
		geneThreePOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePOneLabel.setBackground(backgroundColor);
		geneThreePOneLabel.setForeground(textColor);
		geneThreePOneLabel.setEnabled(inDebugMode);
		geneLabelList.add(geneThreePOneLabel);
		GridBagConstraints gbc_geneThreePOneLabel = new GridBagConstraints();
		gbc_geneThreePOneLabel.gridwidth = 4;
		gbc_geneThreePOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneThreePOneLabel.weightx = 1.0;
		gbc_geneThreePOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneLabel.gridx = 0;
		gbc_geneThreePOneLabel.gridy = 8;
		parentOnePanel.add(geneThreePOneLabel, gbc_geneThreePOneLabel);
		
		//Gene Three Parent One Combo
		geneThreePOneCombo = new JComboBox<String>();
		geneThreePOneCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneThreePOneCombo.addItem(geneOptions[init]);
		}
		geneThreePOneCombo.setBackground(textFieldColor);
		geneThreePOneCombo.setForeground(textColor);
		geneThreePOneCombo.setEnabled(inDebugMode);
		comboBoxPOneList.add(geneThreePOneCombo);
		GridBagConstraints gbc_geneThreePOneCombo = new GridBagConstraints();
		gbc_geneThreePOneCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePOneCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneThreePOneCombo.gridx = 0;
		gbc_geneThreePOneCombo.gridy = 9;
		parentOnePanel.add(geneThreePOneCombo, gbc_geneThreePOneCombo);
		
		//Gene Three Parent One Radio HomoD
		geneThreePOneRadHomoD = new JRadioButton("AA");
		geneThreePOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePOneRadHomoD.setBackground(backgroundColor);
		geneThreePOneRadHomoD.setForeground(textColor);
		geneThreePOneRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePOneRadHomoD = new GridBagConstraints();
		gbc_geneThreePOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePOneRadHomoD.weightx = 0.25;
		gbc_geneThreePOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneRadHomoD.gridx = 1;
		gbc_geneThreePOneRadHomoD.gridy = 9;
		parentOnePanel.add(geneThreePOneRadHomoD, gbc_geneThreePOneRadHomoD);
		
		//Gene Three Parent One Radio Hetero
		geneThreePOneRadHetero = new JRadioButton("Aa");
		geneThreePOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePOneRadHetero.setBackground(backgroundColor);
		geneThreePOneRadHetero.setForeground(textColor);
		geneThreePOneRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePOneRadHetero = new GridBagConstraints();
		gbc_geneThreePOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePOneRadHetero.weightx = 0.25;
		gbc_geneThreePOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneRadHetero.gridx = 2;
		gbc_geneThreePOneRadHetero.gridy = 9;
		parentOnePanel.add(geneThreePOneRadHetero, gbc_geneThreePOneRadHetero);
		
		//Gene Three Parent One Radio HomoR
		geneThreePOneRadHomoR = new JRadioButton("aa");
		geneThreePOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePOneRadHomoR.setBackground(backgroundColor);
		geneThreePOneRadHomoR.setForeground(textColor);
		geneThreePOneRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePOneRadHomoR = new GridBagConstraints();
		gbc_geneThreePOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneThreePOneRadHomoR.weightx = 0.25;
		gbc_geneThreePOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneRadHomoR.gridx = 3;
		gbc_geneThreePOneRadHomoR.gridy = 9;
		parentOnePanel.add(geneThreePOneRadHomoR, gbc_geneThreePOneRadHomoR);
		
		//Gene Four Parent One Label
		geneFourPOneLabel = new JLabel("Gene 4");
		geneFourPOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPOneLabel.setBackground(backgroundColor);
		geneFourPOneLabel.setForeground(textColor);
		geneFourPOneLabel.setEnabled(inDebugMode);
		geneLabelList.add(geneFourPOneLabel);
		GridBagConstraints gbc_geneFourPOneLabel = new GridBagConstraints();
		gbc_geneFourPOneLabel.gridwidth = 4;
		gbc_geneFourPOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneFourPOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneLabel.gridx = 0;
		gbc_geneFourPOneLabel.gridy = 11;
		parentOnePanel.add(geneFourPOneLabel, gbc_geneFourPOneLabel);
		
		//Gene Four Parent One Combo
		geneFourPOneCombo = new JComboBox<String>();
		geneFourPOneCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneFourPOneCombo.addItem(geneOptions[init]);
		}
		geneFourPOneCombo.setBackground(textFieldColor);
		geneFourPOneCombo.setForeground(textColor);
		geneFourPOneCombo.setEnabled(inDebugMode);
		comboBoxPOneList.add(geneFourPOneCombo);
		GridBagConstraints gbc_geneFourPOneCombo = new GridBagConstraints();
		gbc_geneFourPOneCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPOneCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneFourPOneCombo.gridx = 0;
		gbc_geneFourPOneCombo.gridy = 12;
		parentOnePanel.add(geneFourPOneCombo, gbc_geneFourPOneCombo);
		
		//Gene Four Parent One Radio HomoD
		geneFourPOneRadHomoD = new JRadioButton("AA");
		geneFourPOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPOneRadHomoD.setBackground(backgroundColor);
		geneFourPOneRadHomoD.setForeground(textColor);
		geneFourPOneRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPOneRadHomoD = new GridBagConstraints();
		gbc_geneFourPOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPOneRadHomoD.weightx = 0.25;
		gbc_geneFourPOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneRadHomoD.gridx = 1;
		gbc_geneFourPOneRadHomoD.gridy = 12;
		parentOnePanel.add(geneFourPOneRadHomoD, gbc_geneFourPOneRadHomoD);
		
		//Gene Four Parent One Radio Hetero
		geneFourPOneRadHetero = new JRadioButton("Aa");
		geneFourPOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPOneRadHetero.setBackground(backgroundColor);
		geneFourPOneRadHetero.setForeground(textColor);
		geneFourPOneRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPOneRadHetero = new GridBagConstraints();
		gbc_geneFourPOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPOneRadHetero.weightx = 0.25;
		gbc_geneFourPOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneRadHetero.gridx = 2;
		gbc_geneFourPOneRadHetero.gridy = 12;
		parentOnePanel.add(geneFourPOneRadHetero, gbc_geneFourPOneRadHetero);
		
		//Gene Four Parent One Radio HomoR
		geneFourPOneRadHomoR = new JRadioButton("aa");
		geneFourPOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPOneRadHomoR.setBackground(backgroundColor);
		geneFourPOneRadHomoR.setForeground(textColor);
		geneFourPOneRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPOneRadHomoR = new GridBagConstraints();
		gbc_geneFourPOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneFourPOneRadHomoR.weightx = 0.25;
		gbc_geneFourPOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneRadHomoR.gridx = 3;
		gbc_geneFourPOneRadHomoR.gridy = 12;
		parentOnePanel.add(geneFourPOneRadHomoR, gbc_geneFourPOneRadHomoR);
		
		//Gene Five Parent One Label
		geneFivePOneLabel = new JLabel("Gene 5");
		geneFivePOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePOneLabel.setBackground(backgroundColor);
		geneFivePOneLabel.setForeground(textColor);
		geneFivePOneLabel.setEnabled(inDebugMode);
		geneLabelList.add(geneFivePOneLabel);
		GridBagConstraints gbc_geneFivePOneLabel = new GridBagConstraints();
		gbc_geneFivePOneLabel.gridwidth = 4;
		gbc_geneFivePOneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneFivePOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneLabel.gridx = 0;
		gbc_geneFivePOneLabel.gridy = 14;
		parentOnePanel.add(geneFivePOneLabel, gbc_geneFivePOneLabel);
		
		//Gene Five Parent One Combo
		geneFivePOneCombo = new JComboBox<String>();
		geneFivePOneCombo.setMaximumRowCount(26);
		for (int init = 0; init < geneOptions.length; init++)
		{
			geneFivePOneCombo.addItem(geneOptions[init]);
		}
		geneFivePOneCombo.setBackground(textFieldColor);
		geneFivePOneCombo.setForeground(textColor);
		geneFivePOneCombo.setEnabled(inDebugMode);
		comboBoxPOneList.add(geneFivePOneCombo);
		GridBagConstraints gbc_geneFivePOneCombo = new GridBagConstraints();
		gbc_geneFivePOneCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePOneCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneFivePOneCombo.gridx = 0;
		gbc_geneFivePOneCombo.gridy = 15;
		parentOnePanel.add(geneFivePOneCombo, gbc_geneFivePOneCombo);
		
		//Gene Five Parent One Radio HomoD
		geneFivePOneRadHomoD = new JRadioButton("AA");
		geneFivePOneRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePOneRadHomoD.setBackground(backgroundColor);
		geneFivePOneRadHomoD.setForeground(textColor);
		geneFivePOneRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePOneRadHomoD = new GridBagConstraints();
		gbc_geneFivePOneRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePOneRadHomoD.weightx = 0.25;
		gbc_geneFivePOneRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneRadHomoD.gridx = 1;
		gbc_geneFivePOneRadHomoD.gridy = 15;
		parentOnePanel.add(geneFivePOneRadHomoD, gbc_geneFivePOneRadHomoD);
		
		//Gene Five Parent One Radio Hetero
		geneFivePOneRadHetero = new JRadioButton("Aa");
		geneFivePOneRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePOneRadHetero.setBackground(backgroundColor);
		geneFivePOneRadHetero.setForeground(textColor);
		geneFivePOneRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePOneRadHetero = new GridBagConstraints();
		gbc_geneFivePOneRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePOneRadHetero.weightx = 0.25;
		gbc_geneFivePOneRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneRadHetero.gridx = 2;
		gbc_geneFivePOneRadHetero.gridy = 15;
		parentOnePanel.add(geneFivePOneRadHetero, gbc_geneFivePOneRadHetero);
		
		//Gene Five Parent One Radio HomoR
		geneFivePOneRadHomoR = new JRadioButton("aa");
		geneFivePOneRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePOneRadHomoR.setBackground(backgroundColor);
		geneFivePOneRadHomoR.setForeground(textColor);
		geneFivePOneRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePOneRadHomoR = new GridBagConstraints();
		gbc_geneFivePOneRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneFivePOneRadHomoR.weightx = 0.25;
		gbc_geneFivePOneRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneRadHomoR.gridx = 3;
		gbc_geneFivePOneRadHomoR.gridy = 15;
		parentOnePanel.add(geneFivePOneRadHomoR, gbc_geneFivePOneRadHomoR);
		
		//Parent One Calculation Button
		calcButton = new JButton("Calculate");
		calcButton.setBackground(backgroundColor);
		calcButton.setForeground(textColor);
		calcButton.setEnabled(inDebugMode);
		calcButton.setEnabled(true);
		calcButton.addMouseListener(this);
		GridBagConstraints gbc_calcButton = new GridBagConstraints();
		gbc_calcButton.gridwidth = 4;
		gbc_calcButton.weightx = 1.0;
		gbc_calcButton.fill = GridBagConstraints.BOTH;
		gbc_calcButton.gridx = 0;
		gbc_calcButton.gridy = 20;
		parentOnePanel.add(calcButton, gbc_calcButton);
		
		//Adding all Parent One radio buttons to their corresponding ButtonGroups
		//Gene One Parent One
		geneOnePOneBG = new ButtonGroup();
		geneOnePOneBG.add(geneOnePOneRadHomoD);
		geneOnePOneBG.add(geneOnePOneRadHetero);
		geneOnePOneBG.add(geneOnePOneRadHomoR);
		buttonGroupList.add(geneOnePOneBG);
		
		//Gene Two Parent One
		geneTwoPOneBG = new ButtonGroup();
		geneTwoPOneBG.add(geneTwoPOneRadHomoD);
		geneTwoPOneBG.add(geneTwoPOneRadHetero);
		geneTwoPOneBG.add(geneTwoPOneRadHomoR);
		buttonGroupList.add(geneTwoPOneBG);
		
		//Gene Three Parent One
		geneThreePOneBG = new ButtonGroup();
		geneThreePOneBG.add(geneThreePOneRadHomoD);
		geneThreePOneBG.add(geneThreePOneRadHetero);
		geneThreePOneBG.add(geneThreePOneRadHomoR);
		buttonGroupList.add(geneThreePOneBG);
		
		//Gene Four Parent One
		geneFourPOneBG = new ButtonGroup();
		geneFourPOneBG.add(geneFourPOneRadHomoD);
		geneFourPOneBG.add(geneFourPOneRadHetero);
		geneFourPOneBG.add(geneFourPOneRadHomoR);
		buttonGroupList.add(geneFourPOneBG);
		
		//Gene Five Parent One
		geneFivePOneBG = new ButtonGroup();
		geneFivePOneBG.add(geneFivePOneRadHomoD);
		geneFivePOneBG.add(geneFivePOneRadHetero);
		geneFivePOneBG.add(geneFivePOneRadHomoR);
		buttonGroupList.add(geneFivePOneBG);
		
		//Parent Two Column
		JPanel parentTwoPanel = new JPanel();
		parentTwoPanel.setBackground(backgroundColor);
		GridBagConstraints gbc_parentTwo = new GridBagConstraints();
		gbc_parentTwo.insets = new Insets(0, 5, 0, 0);
		gbc_parentTwo.weighty = 1.0;
		gbc_parentTwo.weightx = 0.2;
		gbc_parentTwo.fill = GridBagConstraints.BOTH;
		gbc_parentTwo.gridx = 1;
		gbc_parentTwo.gridy = 0;
		content.add(parentTwoPanel, gbc_parentTwo);
		GridBagLayout gbl_parentTwo = new GridBagLayout();
		gbl_parentTwo.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_parentTwo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_parentTwo.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_parentTwo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		parentTwoPanel.setLayout(gbl_parentTwo);
		
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
		parentTwoPanel.add(parentTwoLabel, gbc_parentTwoLabel);
		
		//Gene One Parent Two Label
		geneOnePTwoLabel = new JLabel("Gene 1");
		geneOnePTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePTwoLabel.setBackground(backgroundColor);
		geneOnePTwoLabel.setForeground(textColor);
		geneOnePTwoLabel.setEnabled(inDebugMode);
		geneLabelList.add(geneOnePTwoLabel);
		GridBagConstraints gbc_geneOnePTwoLabel = new GridBagConstraints();
		gbc_geneOnePTwoLabel.gridwidth = 4;
		gbc_geneOnePTwoLabel.weightx = 1.0;
		gbc_geneOnePTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneOnePTwoLabel.gridx = 0;
		gbc_geneOnePTwoLabel.gridy = 2;
		parentTwoPanel.add(geneOnePTwoLabel, gbc_geneOnePTwoLabel);
		
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
		comboBoxPTwoList.add(geneOnePTwoCombo);
		GridBagConstraints gbc_geneOnePTwoCombo = new GridBagConstraints();
		gbc_geneOnePTwoCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePTwoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneOnePTwoCombo.gridx = 0;
		gbc_geneOnePTwoCombo.gridy = 3;
		parentTwoPanel.add(geneOnePTwoCombo, gbc_geneOnePTwoCombo);
		
		//Gene One Parent Two Radio HomoD
		geneOnePTwoRadHomoD = new JRadioButton("AA");
		geneOnePTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePTwoRadHomoD.setBackground(backgroundColor);
		geneOnePTwoRadHomoD.setForeground(textColor);
		geneOnePTwoRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneOnePTwoRadHomoD = new GridBagConstraints();
		gbc_geneOnePTwoRadHomoD.weightx = 0.25;
		gbc_geneOnePTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePTwoRadHomoD.gridx = 1;
		gbc_geneOnePTwoRadHomoD.gridy = 3;
		parentTwoPanel.add(geneOnePTwoRadHomoD, gbc_geneOnePTwoRadHomoD);
		
		//Gene One Parent Two Radio Hetero
		geneOnePTwoRadHetero = new JRadioButton("Aa");
		geneOnePTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePTwoRadHetero.setBackground(backgroundColor);
		geneOnePTwoRadHetero.setForeground(textColor);
		geneOnePTwoRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneOnePTwoRadHetero = new GridBagConstraints();
		gbc_geneOnePTwoRadHetero.weightx = 0.25;
		gbc_geneOnePTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePTwoRadHetero.gridx = 2;
		gbc_geneOnePTwoRadHetero.gridy = 3;
		parentTwoPanel.add(geneOnePTwoRadHetero, gbc_geneOnePTwoRadHetero);
		
		//Gene One Parent Two Radio HomoR
		geneOnePTwoRadHomoR = new JRadioButton("aa");
		geneOnePTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneOnePTwoRadHomoR.setBackground(backgroundColor);
		geneOnePTwoRadHomoR.setForeground(textColor);
		geneOnePTwoRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneOnePTwoRadHomoR = new GridBagConstraints();
		gbc_geneOnePTwoRadHomoR.weightx = 0.25;
		gbc_geneOnePTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneOnePTwoRadHomoR.gridx = 3;
		gbc_geneOnePTwoRadHomoR.gridy = 3;
		parentTwoPanel.add(geneOnePTwoRadHomoR, gbc_geneOnePTwoRadHomoR);
		
		//Gene Two Parent Two Label
		geneTwoPTwoLabel = new JLabel("Gene 2");
		geneTwoPTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPTwoLabel.setBackground(backgroundColor);
		geneTwoPTwoLabel.setForeground(textColor);
		geneTwoPTwoLabel.setEnabled(inDebugMode);
		geneLabelList.add(geneTwoPTwoLabel);
		GridBagConstraints gbc_geneTwoPTwoLabel = new GridBagConstraints();
		gbc_geneTwoPTwoLabel.gridwidth = 4;
		gbc_geneTwoPTwoLabel.weightx = 1.0;
		gbc_geneTwoPTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneTwoPTwoLabel.gridx = 0;
		gbc_geneTwoPTwoLabel.gridy = 5;
		parentTwoPanel.add(geneTwoPTwoLabel, gbc_geneTwoPTwoLabel);
		
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
		comboBoxPTwoList.add(geneTwoPTwoCombo);
		GridBagConstraints gbc_geneTwoPTwoCombo = new GridBagConstraints();
		gbc_geneTwoPTwoCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPTwoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneTwoPTwoCombo.gridx = 0;
		gbc_geneTwoPTwoCombo.gridy = 6;
		parentTwoPanel.add(geneTwoPTwoCombo, gbc_geneTwoPTwoCombo);
		
		//Gene Two Parent Two Radio HomoD
		geneTwoPTwoRadHomoD = new JRadioButton("AA");
		geneTwoPTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPTwoRadHomoD.setBackground(backgroundColor);
		geneTwoPTwoRadHomoD.setForeground(textColor);
		geneTwoPTwoRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPTwoRadHomoD = new GridBagConstraints();
		gbc_geneTwoPTwoRadHomoD.weightx = 0.25;
		gbc_geneTwoPTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPTwoRadHomoD.gridx = 1;
		gbc_geneTwoPTwoRadHomoD.gridy = 6;
		parentTwoPanel.add(geneTwoPTwoRadHomoD, gbc_geneTwoPTwoRadHomoD);
		
		//Gene Two Parent Two Radio Hetero
		geneTwoPTwoRadHetero = new JRadioButton("Aa");
		geneTwoPTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPTwoRadHetero.setBackground(backgroundColor);
		geneTwoPTwoRadHetero.setForeground(textColor);
		geneTwoPTwoRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPTwoRadHetero = new GridBagConstraints();
		gbc_geneTwoPTwoRadHetero.weightx = 0.25;
		gbc_geneTwoPTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPTwoRadHetero.gridx = 2;
		gbc_geneTwoPTwoRadHetero.gridy = 6;
		parentTwoPanel.add(geneTwoPTwoRadHetero, gbc_geneTwoPTwoRadHetero);
		
		//Gene Two Parent Two Radio HomoR
		geneTwoPTwoRadHomoR = new JRadioButton("aa");
		geneTwoPTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneTwoPTwoRadHomoR.setBackground(backgroundColor);
		geneTwoPTwoRadHomoR.setForeground(textColor);
		geneTwoPTwoRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneTwoPTwoRadHomoR = new GridBagConstraints();
		gbc_geneTwoPTwoRadHomoR.weightx = 0.25;
		gbc_geneTwoPTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneTwoPTwoRadHomoR.gridx = 3;
		gbc_geneTwoPTwoRadHomoR.gridy = 6;
		parentTwoPanel.add(geneTwoPTwoRadHomoR, gbc_geneTwoPTwoRadHomoR);
		
		//Gene Three Parent Two Label
		geneThreePTwoLabel = new JLabel("Gene 3");
		geneThreePTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePTwoLabel.setBackground(backgroundColor);
		geneThreePTwoLabel.setForeground(textColor);
		geneThreePTwoLabel.setEnabled(inDebugMode);
		geneLabelList.add(geneThreePTwoLabel);
		GridBagConstraints gbc_geneThreePTwoLabel = new GridBagConstraints();
		gbc_geneThreePTwoLabel.gridwidth = 4;
		gbc_geneThreePTwoLabel.weightx = 1.0;
		gbc_geneThreePTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneThreePTwoLabel.gridx = 0;
		gbc_geneThreePTwoLabel.gridy = 8;
		parentTwoPanel.add(geneThreePTwoLabel, gbc_geneThreePTwoLabel);
		
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
		comboBoxPTwoList.add(geneThreePTwoCombo);
		GridBagConstraints gbc_geneThreePTwoCombo = new GridBagConstraints();
		gbc_geneThreePTwoCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePTwoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneThreePTwoCombo.gridx = 0;
		gbc_geneThreePTwoCombo.gridy = 9;
		parentTwoPanel.add(geneThreePTwoCombo, gbc_geneThreePTwoCombo);
		
		//Gene Three Parent Two Radio HomoD
		geneThreePTwoRadHomoD = new JRadioButton("AA");
		geneThreePTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePTwoRadHomoD.setBackground(backgroundColor);
		geneThreePTwoRadHomoD.setForeground(textColor);
		geneThreePTwoRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePTwoRadHomoD = new GridBagConstraints();
		gbc_geneThreePTwoRadHomoD.weightx = 0.25;
		gbc_geneThreePTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePTwoRadHomoD.gridx = 1;
		gbc_geneThreePTwoRadHomoD.gridy = 9;
		parentTwoPanel.add(geneThreePTwoRadHomoD, gbc_geneThreePTwoRadHomoD);
		
		//Gene Three Parent Two Radio Hetero
		geneThreePTwoRadHetero = new JRadioButton("Aa");
		geneThreePTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePTwoRadHetero.setBackground(backgroundColor);
		geneThreePTwoRadHetero.setForeground(textColor);
		geneThreePTwoRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePTwoRadHetero = new GridBagConstraints();
		gbc_geneThreePTwoRadHetero.weightx = 0.25;
		gbc_geneThreePTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePTwoRadHetero.gridx = 2;
		gbc_geneThreePTwoRadHetero.gridy = 9;
		parentTwoPanel.add(geneThreePTwoRadHetero, gbc_geneThreePTwoRadHetero);
		
		//Gene Three Parent Two Radio HomoR
		geneThreePTwoRadHomoR = new JRadioButton("aa");
		geneThreePTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneThreePTwoRadHomoR.setBackground(backgroundColor);
		geneThreePTwoRadHomoR.setForeground(textColor);
		geneThreePTwoRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneThreePTwoRadHomoR = new GridBagConstraints();
		gbc_geneThreePTwoRadHomoR.weightx = 0.25;
		gbc_geneThreePTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneThreePTwoRadHomoR.gridx = 3;
		gbc_geneThreePTwoRadHomoR.gridy = 9;
		parentTwoPanel.add(geneThreePTwoRadHomoR, gbc_geneThreePTwoRadHomoR);
		
		//Gene Four Parent Two Label
		geneFourPTwoLabel = new JLabel("Gene 4");
		geneFourPTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPTwoLabel.setBackground(backgroundColor);
		geneFourPTwoLabel.setForeground(textColor);
		geneFourPTwoLabel.setEnabled(inDebugMode);
		geneLabelList.add(geneFourPTwoLabel);
		GridBagConstraints gbc_geneFourPTwoLabel = new GridBagConstraints();
		gbc_geneFourPTwoLabel.gridwidth = 4;
		gbc_geneFourPTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneFourPTwoLabel.gridx = 0;
		gbc_geneFourPTwoLabel.gridy = 11;
		parentTwoPanel.add(geneFourPTwoLabel, gbc_geneFourPTwoLabel);
		
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
		comboBoxPTwoList.add(geneFourPTwoCombo);
		GridBagConstraints gbc_geneFourPTwoCombo = new GridBagConstraints();
		gbc_geneFourPTwoCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPTwoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneFourPTwoCombo.gridx = 0;
		gbc_geneFourPTwoCombo.gridy = 12;
		parentTwoPanel.add(geneFourPTwoCombo, gbc_geneFourPTwoCombo);
		
		//Gene Four Parent Two Radio HomoD
		geneFourPTwoRadHomoD = new JRadioButton("AA");
		geneFourPTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPTwoRadHomoD.setBackground(backgroundColor);
		geneFourPTwoRadHomoD.setForeground(textColor);
		geneFourPTwoRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPTwoRadHomoD = new GridBagConstraints();
		gbc_geneFourPTwoRadHomoD.weightx = 0.25;
		gbc_geneFourPTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPTwoRadHomoD.gridx = 1;
		gbc_geneFourPTwoRadHomoD.gridy = 12;
		parentTwoPanel.add(geneFourPTwoRadHomoD, gbc_geneFourPTwoRadHomoD);
		
		//Gene Four Parent Two Radio Hetero
		geneFourPTwoRadHetero = new JRadioButton("Aa");
		geneFourPTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPTwoRadHetero.setBackground(backgroundColor);
		geneFourPTwoRadHetero.setForeground(textColor);
		geneFourPTwoRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPTwoRadHetero = new GridBagConstraints();
		gbc_geneFourPTwoRadHetero.weightx = 0.25;
		gbc_geneFourPTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPTwoRadHetero.gridx = 2;
		gbc_geneFourPTwoRadHetero.gridy = 12;
		parentTwoPanel.add(geneFourPTwoRadHetero, gbc_geneFourPTwoRadHetero);
		
		//Gene Four Parent Two Radio HomoR
		geneFourPTwoRadHomoR = new JRadioButton("aa");
		geneFourPTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneFourPTwoRadHomoR.setBackground(backgroundColor);
		geneFourPTwoRadHomoR.setForeground(textColor);
		geneFourPTwoRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFourPTwoRadHomoR = new GridBagConstraints();
		gbc_geneFourPTwoRadHomoR.weightx = 0.25;
		gbc_geneFourPTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneFourPTwoRadHomoR.gridx = 3;
		gbc_geneFourPTwoRadHomoR.gridy = 12;
		parentTwoPanel.add(geneFourPTwoRadHomoR, gbc_geneFourPTwoRadHomoR);
		
		//Gene Five Parent Two Label
		geneFivePTwoLabel = new JLabel("Gene 5");
		geneFivePTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePTwoLabel.setBackground(backgroundColor);
		geneFivePTwoLabel.setForeground(textColor);
		geneFivePTwoLabel.setEnabled(inDebugMode);
		geneLabelList.add(geneFivePTwoLabel);
		GridBagConstraints gbc_geneFivePTwoLabel = new GridBagConstraints();
		gbc_geneFivePTwoLabel.gridwidth = 4;
		gbc_geneFivePTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_geneFivePTwoLabel.gridx = 0;
		gbc_geneFivePTwoLabel.gridy = 14;
		parentTwoPanel.add(geneFivePTwoLabel, gbc_geneFivePTwoLabel);
		
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
		comboBoxPTwoList.add(geneFivePTwoCombo);
		GridBagConstraints gbc_geneFivePTwoCombo = new GridBagConstraints();
		gbc_geneFivePTwoCombo.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePTwoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_geneFivePTwoCombo.gridx = 0;
		gbc_geneFivePTwoCombo.gridy = 15;
		parentTwoPanel.add(geneFivePTwoCombo, gbc_geneFivePTwoCombo);
		
		//Gene Five Parent Two Radio HomoD 
		geneFivePTwoRadHomoD = new JRadioButton("AA");
		geneFivePTwoRadHomoD.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePTwoRadHomoD.setBackground(backgroundColor);
		geneFivePTwoRadHomoD.setForeground(textColor);
		geneFivePTwoRadHomoD.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePTwoRadHomoD = new GridBagConstraints();
		gbc_geneFivePTwoRadHomoD.weightx = 0.25;
		gbc_geneFivePTwoRadHomoD.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoRadHomoD.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePTwoRadHomoD.gridx = 1;
		gbc_geneFivePTwoRadHomoD.gridy = 15;
		parentTwoPanel.add(geneFivePTwoRadHomoD, gbc_geneFivePTwoRadHomoD);
		
		//Gene Five Parent Two Radio Hetero
		geneFivePTwoRadHetero = new JRadioButton("Aa");
		geneFivePTwoRadHetero.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePTwoRadHetero.setBackground(backgroundColor);
		geneFivePTwoRadHetero.setForeground(textColor);
		geneFivePTwoRadHetero.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePTwoRadHetero = new GridBagConstraints();
		gbc_geneFivePTwoRadHetero.weightx = 0.25;
		gbc_geneFivePTwoRadHetero.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoRadHetero.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePTwoRadHetero.gridx = 2;
		gbc_geneFivePTwoRadHetero.gridy = 15;
		parentTwoPanel.add(geneFivePTwoRadHetero, gbc_geneFivePTwoRadHetero);
		
		//Gene Five Parent Two Radio HomoR
		geneFivePTwoRadHomoR = new JRadioButton("aa");
		geneFivePTwoRadHomoR.setHorizontalAlignment(SwingConstants.CENTER);
		geneFivePTwoRadHomoR.setBackground(backgroundColor);
		geneFivePTwoRadHomoR.setForeground(textColor);
		geneFivePTwoRadHomoR.setEnabled(inDebugMode);
		GridBagConstraints gbc_geneFivePTwoRadHomoR = new GridBagConstraints();
		gbc_geneFivePTwoRadHomoR.weightx = 0.25;
		gbc_geneFivePTwoRadHomoR.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoRadHomoR.insets = new Insets(0, 0, 5, 0);
		gbc_geneFivePTwoRadHomoR.gridx = 3;
		gbc_geneFivePTwoRadHomoR.gridy = 15;
		parentTwoPanel.add(geneFivePTwoRadHomoR, gbc_geneFivePTwoRadHomoR);
		
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
		parentTwoPanel.add(resetButton, gbc_resetButton);
		
		//Adding all Parent Two radio buttons to their corresponding ButtonGroups
		//Gene One Parent Two
		geneOnePTwoBG = new ButtonGroup();
		geneOnePTwoBG.add(geneOnePTwoRadHomoD);
		geneOnePTwoBG.add(geneOnePTwoRadHetero);
		geneOnePTwoBG.add(geneOnePTwoRadHomoR);
		buttonGroupList.add(geneOnePTwoBG);

		//Gene Two Parent Two
		geneTwoPTwoBG = new ButtonGroup();
		geneTwoPTwoBG.add(geneTwoPTwoRadHomoD);
		geneTwoPTwoBG.add(geneTwoPTwoRadHetero);
		geneTwoPTwoBG.add(geneTwoPTwoRadHomoR);
		buttonGroupList.add(geneTwoPTwoBG);
		
		//Gene Three Parent Two
		geneThreePTwoBG = new ButtonGroup();
		geneThreePTwoBG.add(geneThreePTwoRadHomoD);
		geneThreePTwoBG.add(geneThreePTwoRadHetero);
		geneThreePTwoBG.add(geneThreePTwoRadHomoR);
		buttonGroupList.add(geneThreePTwoBG);
		
		//Gene Four Parent Two
		geneFourPTwoBG = new ButtonGroup();
		geneFourPTwoBG.add(geneFourPTwoRadHomoD);
		geneFourPTwoBG.add(geneFourPTwoRadHetero);
		geneFourPTwoBG.add(geneFourPTwoRadHomoR);
		buttonGroupList.add(geneFourPTwoBG);
		
		//Gene Five Parent Two
		geneFivePTwoBG = new ButtonGroup();
		geneFivePTwoBG.add(geneFivePTwoRadHomoD);
		geneFivePTwoBG.add(geneFivePTwoRadHetero);
		geneFivePTwoBG.add(geneFivePTwoRadHomoR);
		buttonGroupList.add(geneFivePTwoBG);
		
		//Results Column
		resultsPanel = new JPanel();
		resultsPanel.setBackground(backgroundColor);
		resultsPanel.setForeground(textColor);
		GridBagConstraints gbc_resultsPanel = new GridBagConstraints();
		gbc_resultsPanel.insets = new Insets(0, 5, 0, 5);
		gbc_resultsPanel.gridwidth = 1;
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
		resultsJTA = new JTextArea();
		resultsJTA.setBackground(textFieldColor);
		resultsJTA.setForeground(textColor);
		resultsJTA.setEditable(false);
		resultsJTA.setColumns(1);
		resultsJTA.setLineWrap(false);
		resultsJTA.setFont(new Font(javax.swing.UIManager.getDefaults().getFont("Label.font").getFontName(), Font.PLAIN, 14));
		GridBagConstraints gbc_resultsJTA = new GridBagConstraints();
		gbc_resultsJTA.fill = GridBagConstraints.BOTH;
		gbc_resultsJTA.gridwidth = 3;
		gbc_resultsJTA.weightx = 1.0;
		gbc_resultsJTA.weighty = 1.0;
		gbc_resultsJTA.gridx = 0;
		gbc_resultsJTA.gridy = 1;
		JScrollPane jsp = new JScrollPane(resultsJTA, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		resultsPanel.add(jsp, gbc_resultsJTA);
		
		//Error Message Colors
		UIManager.put("OptionPane.background", new ColorUIResource(215,75,75));
		UIManager.put("OptionPane.messageForeground", textColor);
		UIManager.put("Panel.background", new ColorUIResource(215,75,75));
		UIManager.put("JComboBox.disabledBackground", new ColorUIResource(215, 75, 75));

		window.pack();
		window.setVisible(true);
	}

	/**
	 * For Calculate and Reset Buttons.
	 * If event came from the Calculate button, it will run errorCheckGenes() 
	 * to verify all selected genes are assigned a symbol and selected alleles 
	 * from both parents.
	 * 
	 * Reset button will clear all symbol JComboBoxes and ButtonGroups to default.
	 * 
	 * @param e MouseEvent
	 */
	public void mouseClicked(MouseEvent e) 
	{
		//Calculation Button
		if (e.getSource().equals(calcButton))
		{
			//If error checking comes back true, calculate.
			if (errorCheckGenes())
			{
				startCalculation();
			}
		}
		//Reset Button
		else if (e.getSource().equals(resetButton))
		{
			//Resets all JComboBoxes and ButtonGroups to unselected.
			resetAll();
		}
	}

	public void mouseEntered(MouseEvent arg0){}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0){}
	public void mouseReleased(MouseEvent arg0){}

	//For ComboBoxes' selection changes and Radio Button Selections.
	/**
	 * Activates when a user changes the selected item in a JComboBox.
	 * Depending on the Gene Row it's on, it will enable the JComboBox
	 * of the Gene Row below it. Additionally, it will activate the
	 * current row's ButtonGroups to select a corresponding allele type.
	 * 
	 * @param e ItemEvent
	 */
	public void itemStateChanged(ItemEvent e) 
	{
		/*
		 * ItemStateChanged fires twice, one for the deselect of
		 * the default item, and the selection of the new item.
		 * Currently we have no relevant use for the deselect.
		 * So we only care about the even that was a selection.
		 */
		if (e.getStateChange() == ItemEvent.SELECTED)
		{
			/*
			 * JRadioButton's activate itemStateChanged() as well.
			 * We have a separate method to deal with those and 
			 * the ButtonGroups they're assigned to, so we ignore them.
			 */
			if (e.getSource() instanceof JComboBox)
			{
				//Gene One 
				if (e.getSource().equals(geneOnePOneCombo))
				{
					//If the current item is the default item, don't activate anything as 
					//they need to make their selection in the JComboBox before anything else.
					if (!(e.getItem().equals(defaultComboItem)))
					{
						//If the next JComboBox is disabled(which is should be), call the 
						//JComboBox and ButtonGroups to be enabled.
						if (!geneTwoPOneCombo.isEnabled())
						{
							geneOnePTwoLabel.setEnabled(true);
							geneTwoPOneLabel.setEnabled(true);
							toggleButtonGroup(geneOnePOneBG);
							toggleButtonGroup(geneOnePTwoBG);
							toggleNextComboBox(geneTwoPOneCombo);
						}
						//Update the ButtonGroup's to reflect the symbol that was selected.						
						updateParentTwoComboBox(geneOnePTwoCombo, geneOnePOneCombo.getSelectedIndex());
						updateButtonGroup((String)geneOnePOneCombo.getSelectedItem(), geneOnePOneBG);
						updateButtonGroup((String)geneOnePOneCombo.getSelectedItem(), geneOnePTwoBG);
					}
					//If the JComboBox below the itemEvent is enabled, disable it.
					//Used to toggle on and off the ButtonGroups as well.
					else 
					{
						geneOnePTwoLabel.setEnabled(false);
						geneTwoPOneLabel.setEnabled(false);
						toggleButtonGroup(geneOnePOneBG);
						toggleButtonGroup(geneOnePTwoBG);
						toggleNextComboBox(geneTwoPOneCombo);
						updateParentTwoComboBox(geneOnePTwoCombo, geneOnePOneCombo.getSelectedIndex());
						updateButtonGroup((String)geneOnePOneCombo.getSelectedItem(), geneOnePOneBG);
						updateButtonGroup((String)geneOnePOneCombo.getSelectedItem(), geneOnePTwoBG);
					}
				}
				
				//Gene Two - Same Comments as above, just for GeneTwo instead of GeneOne
				else if (e.getSource().equals(geneTwoPOneCombo))
				{
					if (!(e.getItem().equals(defaultComboItem)))
					{
						if (!geneThreePOneCombo.isEnabled())
						{
							geneTwoPTwoLabel.setEnabled(true);
							geneThreePOneLabel.setEnabled(true);
							toggleButtonGroup(geneTwoPOneBG);
							toggleButtonGroup(geneTwoPTwoBG);
							toggleNextComboBox(geneThreePOneCombo);
						}
						
						updateParentTwoComboBox(geneTwoPTwoCombo, geneTwoPOneCombo.getSelectedIndex());
						updateButtonGroup((String)geneTwoPOneCombo.getSelectedItem(), geneTwoPOneBG);
						updateButtonGroup((String)geneTwoPOneCombo.getSelectedItem(), geneTwoPTwoBG);
					}
					else 
					{
						geneTwoPTwoLabel.setEnabled(false);
						geneThreePOneLabel.setEnabled(false);
						toggleButtonGroup(geneTwoPOneBG);
						toggleButtonGroup(geneTwoPTwoBG);
						toggleNextComboBox(geneThreePOneCombo);
						updateParentTwoComboBox(geneTwoPTwoCombo, geneTwoPOneCombo.getSelectedIndex());
						updateButtonGroup((String)geneTwoPOneCombo.getSelectedItem(), geneTwoPOneBG);
						updateButtonGroup((String)geneTwoPOneCombo.getSelectedItem(), geneTwoPTwoBG);
					}
				}
				
				//Gene Three - Same Comments as above, just for GeneThree instead of GeneTwo
				else if (e.getSource().equals(geneThreePOneCombo))
				{
					if (!(e.getItem().equals(defaultComboItem)))
					{
						if (!geneFourPOneCombo.isEnabled())
						{
							geneThreePTwoLabel.setEnabled(true);
							geneFourPOneLabel.setEnabled(true);
							toggleButtonGroup(geneThreePOneBG);
							toggleButtonGroup(geneThreePTwoBG);
							toggleNextComboBox(geneFourPOneCombo);
						}
						
						updateParentTwoComboBox(geneThreePTwoCombo, geneThreePOneCombo.getSelectedIndex());
						updateButtonGroup((String)geneThreePOneCombo.getSelectedItem(), geneThreePOneBG);
						updateButtonGroup((String)geneThreePOneCombo.getSelectedItem(), geneThreePTwoBG);
					}
					else 
					{
						geneThreePTwoLabel.setEnabled(false);
						geneFourPOneLabel.setEnabled(false);
						toggleButtonGroup(geneThreePOneBG);
						toggleButtonGroup(geneThreePTwoBG);
						toggleNextComboBox(geneFourPOneCombo);
						updateParentTwoComboBox(geneThreePTwoCombo, geneThreePOneCombo.getSelectedIndex());
						updateButtonGroup((String)geneThreePOneCombo.getSelectedItem(), geneThreePOneBG);
						updateButtonGroup((String)geneThreePOneCombo.getSelectedItem(), geneThreePTwoBG);
					}
				}
				
				//Gene Four - Same Comments as above, just for GeneFour instead of GeneThree
				else if (e.getSource().equals(geneFourPOneCombo))
				{
					if (!(e.getItem().equals(defaultComboItem)))
					{
						if (!geneFivePOneCombo.isEnabled())
						{
							geneFourPTwoLabel.setEnabled(true);
							geneFivePOneLabel.setEnabled(true);
							toggleButtonGroup(geneFourPOneBG);
							toggleButtonGroup(geneFourPTwoBG);
							toggleNextComboBox(geneFivePOneCombo);
						}
						
						updateParentTwoComboBox(geneFourPTwoCombo, geneFourPOneCombo.getSelectedIndex());
						updateButtonGroup((String)geneFourPOneCombo.getSelectedItem(), geneFourPOneBG);
						updateButtonGroup((String)geneFourPOneCombo.getSelectedItem(), geneFourPTwoBG);
					}
					else 
					{
						geneFourPTwoLabel.setEnabled(false);
						geneFivePOneLabel.setEnabled(false);
						toggleButtonGroup(geneFourPOneBG);
						toggleButtonGroup(geneFourPTwoBG);
						toggleNextComboBox(geneFivePOneCombo);
						updateParentTwoComboBox(geneFourPTwoCombo, geneFourPOneCombo.getSelectedIndex());
						updateButtonGroup((String)geneFourPOneCombo.getSelectedItem(), geneFourPOneBG);
						updateButtonGroup((String)geneFourPOneCombo.getSelectedItem(), geneFourPTwoBG);
					}
				}
				
				//Gene Five - Same Comments as above, just for GeneFive instead of GeneFour
				//Except this method has no method below it, so it only concerns itself with
				//its own ButtonGroup and JComboBoxes.
				else if (e.getSource().equals(geneFivePOneCombo))
				{
					if (!(e.getItem().equals(defaultComboItem)))
					{
						if (geneFivePTwoLabel.isEnabled() == false)
						{
							geneFivePTwoLabel.setEnabled(true);
							toggleButtonGroup(geneFivePOneBG);
							toggleButtonGroup(geneFivePTwoBG);
						}
						
						updateParentTwoComboBox(geneFivePTwoCombo, geneFivePOneCombo.getSelectedIndex());
						updateButtonGroup((String)geneFivePOneCombo.getSelectedItem(), geneFivePOneBG);
						updateButtonGroup((String)geneFivePOneCombo.getSelectedItem(), geneFivePTwoBG);
					}
					else 
					{
						geneFivePTwoLabel.setEnabled(false);
						toggleButtonGroup(geneFivePOneBG);
						toggleButtonGroup(geneFivePTwoBG);
						updateParentTwoComboBox(geneFivePTwoCombo, geneFivePOneCombo.getSelectedIndex());
						updateButtonGroup((String)geneFivePOneCombo.getSelectedItem(), geneFivePOneBG);
						updateButtonGroup((String)geneFivePOneCombo.getSelectedItem(), geneFivePTwoBG);
					}
				}
			}
		}
	}

	/**
	 * Acts as a toggle switch for ButtonGroups.
	 * Takes in a JRadioButton ButtonGroup, 
	 * cycles through the list and if they 
	 * are enabled with ItemListeners, disable them.
	 * Otherwise enable them. 
	 * 
	 * @param buttonGroup ButtonGroup
	 */
	private void toggleButtonGroup(ButtonGroup buttonGroup)
	{
		//Build Enumeration of the ButtonGroup parameter for use in method.
		Enumeration<AbstractButton> currentBG = buttonGroup.getElements();
		
		//Cycle through the Enumeration, check each item if they're enabled
		//and don't have any ItemListeners. If so, enable them. If they
		//are enabled and have ItemListeners, disable them.
		while (currentBG.hasMoreElements())
		{
			JRadioButton currentButton = (JRadioButton)currentBG.nextElement();
			if (currentButton.isEnabled() && currentButton.getItemListeners().length > 0)
			{
				//Makes JRadioButtons to show unselected.
				buttonGroup.clearSelection();
				currentButton.setEnabled(false);
				currentButton.removeItemListener(this);
			}
			else
			{
				currentButton.setEnabled(true);
				currentButton.addItemListener(this);
			}
		}
	}
	
	/**
	 * Acts like a switch to toggle the JComboBox
	 * enabled or disabled. If enabled with ItemListeners 
	 * remove them, disable the JComboBox, and set the 
	 * selected item in the list to the first item(default item)
	 * 
	 * @param comboBox JComboBox
	 */
	private void toggleNextComboBox(JComboBox<String> comboBox)
	{
		if (comboBox.isEnabled() && comboBox.getItemListeners().length > 0)
		{
			comboBox.setSelectedIndex(0);
			comboBox.setEnabled(false);
			comboBox.removeItemListener(this);
		}
		else
		{
			comboBox.setEnabled(true);
			comboBox.addItemListener(this);
		}
	}
	
	/**
	 * To update ParentTwo's disabled JComboBox.
	 * Takes in a JComboBox, and an int value related to an index position
	 * in the JComboBox. It enables the JComboBox, sets the selected index
	 * to the corresponding index number passed, and disables the JComboBox
	 * again. 
	 *  
	 * @param comboBox JComboBox
	 * @param indexPos integer
	 */
	private void updateParentTwoComboBox(JComboBox<String> comboBox, int indexPos)
	{
		comboBox.setEnabled(true);
		comboBox.setSelectedIndex(indexPos);
		comboBox.setEnabled(false);
	}
	
	/**
	 * Updates each JRadioButton's Label text in the ButtonGroup given.
	 * The newText parameter must be capitalized.
	 * If this method was called in lieu of deactivating its 
	 * ButtonGroup, it will turn the label texts into A equivalents.
	 * 
	 * @param labelText String
	 * @param buttonGroup ButtonGroup
	 */
	private void updateButtonGroup(String labelText, ButtonGroup buttonGroup)
	{
		//If default selected item, use this default text.
		//Else use what's in newText as the new text for each radio button.
		if (labelText.equals(defaultComboItem))
		{
			labelText = "A";
		}
			String newTextLowerCase = labelText.toLowerCase();
			
			//Building Enumeration to use on the current ButtonGroup
			Enumeration<AbstractButton> currentBG = buttonGroup.getElements();
			int buttonCtr = 0;
			
			//Counter used to make sure the first Button displays
			//two Uppercase letters, second one Uppercase and one Lowercase, 
			//and finally the third will be both Lowercase letters.
			while (currentBG.hasMoreElements() && buttonCtr < 3)
			{
				JRadioButton currentButton = (JRadioButton)currentBG.nextElement();
				if (buttonCtr == 0)
				{
					currentButton.setText(labelText + labelText);
				}
				else if (buttonCtr == 1)
				{
					currentButton.setText(labelText + newTextLowerCase);
				}
				else if (buttonCtr == 2)
				{
					currentButton.setText(newTextLowerCase + newTextLowerCase);
				}
				
				buttonCtr++;
			}
	}
	
	/**
	 * Resets the first JComboBox to default, which
	 * cascades through all five potentially active
	 * JComboBoxes to reset them. Also resets the 
	 * JTextArea where results are shown.
	 */
	private void resetAll()
	{
		//Uses ItemListener's Deselect ActionListener to toggle
		//the JComboBoxes and ButtonGroups
		geneOnePOneCombo.setSelectedIndex(0);
		resultsJTA.setText("");
	}

	/**
	 * Checks to see which Gene Rows are enabled.
	 * If enabled, verify they have a selected symbol, 
	 * and in each parent's ButtonGroup has a selected
	 * JRadioButton(allele). Otherwise it will add to
	 * the error message, and set the boolean to flag
	 * to false. If the boolean was flagged, it'll 
	 * call a error pop-up message to display
	 * which lines have errors.
	 * 
	 * @return noErrors boolean
	 */
	private boolean errorCheckGenes()
	{
		boolean hasNoErrors = true;
		int numberOfInactiveGenes = 0;
		
		//Starter error message.
		String errorMsg = "ERROR: Please select an allele type for the following:\n";
		
		//Cycles through the five potentially active JComboBoxes to verify
		//if they're active and if they have ButtonGroups selected.
		//Used for loop so if we add new JComboBoxes in the future, we can
		//simply add them to the list, and create an if statement.
		for (int geneCheck = 0; geneCheck < comboBoxPOneList.size(); geneCheck++)
		{
			JComboBox<String> currentComboBox = comboBoxPOneList.get(geneCheck);
			if (currentComboBox.isEnabled() && currentComboBox.getSelectedIndex() != 0)
			{
				//Gene One
				if (geneCheck == 0)
				{
					if (!hasButtonSelected(geneOnePOneBG))
					{
						errorMsg += "Parent One Gene One\n";
						hasNoErrors = false;
					}
					if (!hasButtonSelected(geneOnePTwoBG))
					{
						
						errorMsg += "Parent Two Gene One\n";
						hasNoErrors = false;
					}
				}
				//Gene Two
				else if (geneCheck == 1)
				{
					if (!hasButtonSelected(geneTwoPOneBG))
					{
						errorMsg += "Parent One Gene Two\n";
						hasNoErrors = false;
					}
					if (!hasButtonSelected(geneTwoPTwoBG))
					{
						
						errorMsg += "Parent Two Gene Two\n";
						hasNoErrors = false;
					}
				}
				//Gene Three
				else if (geneCheck == 2)
				{
					if (!hasButtonSelected(geneThreePOneBG))
					{
						errorMsg += "Parent One Gene Three\n";
						hasNoErrors = false;
					}
					if (!hasButtonSelected(geneThreePTwoBG))
					{
						
						errorMsg += "Parent Two Gene Three\n";
						hasNoErrors = false;
					}
				}
				//Gene Four
				else if (geneCheck == 3)
				{
					if (!hasButtonSelected(geneFourPOneBG))
					{
						errorMsg += "Parent One Gene Four\n";
						hasNoErrors = false;
					}
					if (!hasButtonSelected(geneFourPTwoBG))
					{
						
						errorMsg += "Parent Two Gene Four\n";
						hasNoErrors = false;
					}
				}
				//Gene Five
				else if (geneCheck == 4)
				{
					if (!hasButtonSelected(geneFivePOneBG))
					{
						errorMsg += "Parent One Gene Five\n";
						hasNoErrors = false;
					}
					if (!hasButtonSelected(geneFivePTwoBG))
					{
						
						errorMsg += "Parent Two Gene Five\n";
						hasNoErrors = false;
					}
				}
			}
			else
			{
				numberOfInactiveGenes++;
			}
		}
		
		//No genes have been selected.
		//At least one gene must be used to Calculate.
		if (numberOfInactiveGenes > 4)
		{
			hasNoErrors = false;
			JOptionPane.showMessageDialog(window, "Please select a gene symbol to calculate.");
		}
		//Show error message if the error boolean was flagged.
		else if (!hasNoErrors)
		{
			
			JOptionPane.showMessageDialog(window, errorMsg);
		}
		
		return hasNoErrors;
	}
	
	/**
	 * This method checks to see if one of the 
	 * ButtonGroup's JRadioButtons are selected.
	 * If it finds one, it returns true, otherwise
	 * it returns false.
	 * 
	 * @param buttonGroup ButtonGroup
	 * @return isButtonSelected boolean
	 */
	private boolean hasButtonSelected(ButtonGroup buttonGroup)
	{
		//To cycle through the ButtonGroup parameter.
		Enumeration<AbstractButton> currentBG = buttonGroup.getElements();
		boolean hasOneSelected = false;
		while (currentBG.hasMoreElements())
		{
			JRadioButton currentButton = (JRadioButton)currentBG.nextElement();
			if (currentButton.isSelected())
			{
				hasOneSelected = true;
			}
		}
				
		return hasOneSelected;
	}
	
	/**
	 * Builds the Genes by checking all five relevant
	 * JComboBoxes. Then gets the boolean value from each
	 * of the corresponding buttons in Parent One and Parent
	 * Two's ButtonGroups. Two parent objects are built with the Genes,
	 * and sent to build the punnett square. Finally, after 
	 * built it displays the results.
	 */
	private void startCalculation()
	{
		Gene[] rawGenePOne = new Gene[5];
		Gene[] rawGenePTwo = new Gene[5];
		
		//Gene One
		if (geneOnePOneCombo.getSelectedIndex() != 0)
		{
			//Parent One
			rawGenePOne[0] = new Gene(geneOnePOneCombo.getSelectedItem().toString(), 
					geneOnePOneRadHetero.isSelected(), 
					geneOnePOneRadHomoD.isSelected(),
					geneOnePOneRadHomoR.isSelected());
			
			//Parent Two
			rawGenePTwo[0] = new Gene(geneOnePOneCombo.getSelectedItem().toString(), 
					geneOnePTwoRadHetero.isSelected(), 
					geneOnePTwoRadHomoD.isSelected(),
					geneOnePTwoRadHomoR.isSelected());
		}
		
		//Gene Two
		if (geneTwoPOneCombo.getSelectedIndex() != 0)
		{
			//Parent One
			rawGenePOne[1] = new Gene(geneTwoPOneCombo.getSelectedItem().toString(), 
					geneTwoPOneRadHetero.isSelected(), 
					geneTwoPOneRadHomoD.isSelected(),
					geneTwoPOneRadHomoR.isSelected());
			
			//Parent Two
			rawGenePTwo[1] = new Gene(geneTwoPOneCombo.getSelectedItem().toString(), 
					geneTwoPTwoRadHetero.isSelected(), 
					geneTwoPTwoRadHomoD.isSelected(),
					geneTwoPTwoRadHomoR.isSelected());
		}
		
		//Gene Three
		if (geneThreePOneCombo.getSelectedIndex() != 0)
		{
			//Parent One
			rawGenePOne[2] = new Gene(geneThreePOneCombo.getSelectedItem().toString(), 
					geneThreePOneRadHetero.isSelected(), 
					geneThreePOneRadHomoD.isSelected(),
					geneThreePOneRadHomoR.isSelected());
			
			//Parent Two
			rawGenePTwo[2] = new Gene(geneThreePOneCombo.getSelectedItem().toString(), 
					geneThreePTwoRadHetero.isSelected(), 
					geneThreePTwoRadHomoD.isSelected(),
					geneThreePTwoRadHomoR.isSelected());
		}
		
		//Gene Four
		if (geneFourPOneCombo.getSelectedIndex() != 0)
		{
			//Parent One
			rawGenePOne[3] = new Gene(geneFourPOneCombo.getSelectedItem().toString(), 
					geneFourPOneRadHetero.isSelected(), 
					geneFourPOneRadHomoD.isSelected(),
					geneFourPOneRadHomoR.isSelected());
			
			//Parent Two
			rawGenePTwo[3] = new Gene(geneFourPOneCombo.getSelectedItem().toString(), 
					geneFourPTwoRadHetero.isSelected(), 
					geneFourPTwoRadHomoD.isSelected(),
					geneFourPTwoRadHomoR.isSelected());
		}
		
		//Gene Five
		if (geneFivePOneCombo.getSelectedIndex() != 0)
		{
			//Parent One
			rawGenePOne[4] = new Gene(geneFivePOneCombo.getSelectedItem().toString(), 
					geneFivePOneRadHetero.isSelected(), 
					geneFivePOneRadHomoD.isSelected(),
					geneFivePOneRadHomoR.isSelected());
			//Parent Two
			rawGenePTwo[4] = new Gene(geneFivePOneCombo.getSelectedItem().toString(), 
					geneFivePTwoRadHetero.isSelected(), 
					geneFivePTwoRadHomoD.isSelected(),
					geneFivePTwoRadHomoR.isSelected());
		}

		//Build parents, and set their Genes.
		Parent parentOne = new Parent();
		parentOne.setRawGenes(rawGenePOne);
		
		Parent parentTwo = new Parent();
		parentTwo.setRawGenes(rawGenePTwo);

		//Send to PunnettMe for Calculating.
		pm.build(parentOne, parentTwo);
		
		//Output the results to the results JTextArea.
		outputResults(pm.getResults());
	}
	
	/**
	 * Takes the ArrayList of offspring results, 
	 * and outputs them line by line to the results JTextArea
	 * 
	 * @param results List
	 */
	private void outputResults(List<String> results)
	{
		//To reset the JTextArea to start from empty.
		resultsJTA.setText("");
		
		//Cycles through offspring to output to JTextArea.
		for (int output = results.size()-1; output >= 0 ; output--)
		{
			resultsJTA.append(results.get(output) + "\n");
		}
		//Outputs the size of the ArrayList as the total offspring accounted for.
		resultsJTA.append(results.size() + " total offspring");
		//Sets the viewing area of the JTextArea to be the very beginning.
		//As you append to the JTextArea, it will set the position to the
		//end of the list. This way it starts at the top.
		resultsJTA.setCaretPosition(0);
	}
}
