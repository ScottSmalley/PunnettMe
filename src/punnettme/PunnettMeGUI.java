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

public class PunnettMeGUI {

	private JFrame frmPunnettme;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PunnettMeGUI window = new PunnettMeGUI();
					window.frmPunnettme.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PunnettMeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPunnettme = new JFrame();
		frmPunnettme.setTitle("PunnettMe");
		frmPunnettme.setBounds(100, 100, 800, 586);
		frmPunnettme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		frmPunnettme.getContentPane().setLayout(gridBagLayout);
		
		JPanel content = new JPanel();
		content.setForeground(Color.BLACK);
		GridBagConstraints gbc_content = new GridBagConstraints();
		gbc_content.gridwidth = 0;
		gbc_content.fill = GridBagConstraints.BOTH;
		gbc_content.gridheight = 0;
		gbc_content.weighty = 1.0;
		gbc_content.weightx = 1.0;
		gbc_content.gridx = 0;
		gbc_content.gridy = 0;
		frmPunnettme.getContentPane().add(content, gbc_content);
		GridBagLayout gbl_content = new GridBagLayout();
		gbl_content.columnWidths = new int[]{372, 10, 10, 10, 0};
		gbl_content.rowHeights = new int[]{10, 0};
		gbl_content.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_content.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		content.setLayout(gbl_content);
		
		JPanel parentOne = new JPanel();
		parentOne.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_parentOne = new GridBagConstraints();
		gbc_parentOne.fill = GridBagConstraints.BOTH;
		gbc_parentOne.weighty = 1.0;
		gbc_parentOne.weightx = 0.2;
		gbc_parentOne.gridx = 0;
		gbc_parentOne.gridy = 0;
		content.add(parentOne, gbc_parentOne);
		GridBagLayout gbl_parentOne = new GridBagLayout();
		gbl_parentOne.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_parentOne.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_parentOne.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_parentOne.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		parentOne.setLayout(gbl_parentOne);
		
		JLabel parentOneLabel = new JLabel("Parent One");
		GridBagConstraints gbc_parentOneLabel = new GridBagConstraints();
		gbc_parentOneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_parentOneLabel.weightx = 1.0;
		gbc_parentOneLabel.fill = GridBagConstraints.BOTH;
		gbc_parentOneLabel.gridx = 1;
		gbc_parentOneLabel.gridy = 0;
		parentOne.add(parentOneLabel, gbc_parentOneLabel);
		
		JLabel geneOnePOneLabel = new JLabel("Gene 1");
		GridBagConstraints gbc_geneOnePOneLabel = new GridBagConstraints();
		gbc_geneOnePOneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePOneLabel.weightx = 1.0;
		gbc_geneOnePOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneOnePOneLabel.gridx = 1;
		gbc_geneOnePOneLabel.gridy = 2;
		parentOne.add(geneOnePOneLabel, gbc_geneOnePOneLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.weightx = 0.25;
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 3;
		parentOne.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnAa = new JRadioButton("AA");
		GridBagConstraints gbc_rdbtnAa = new GridBagConstraints();
		gbc_rdbtnAa.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAa.weightx = 0.25;
		gbc_rdbtnAa.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa.gridx = 1;
		gbc_rdbtnAa.gridy = 3;
		parentOne.add(rdbtnAa, gbc_rdbtnAa);
		
		JRadioButton rdbtnAa_1 = new JRadioButton("Aa");
		GridBagConstraints gbc_rdbtnAa_1 = new GridBagConstraints();
		gbc_rdbtnAa_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAa_1.weightx = 0.25;
		gbc_rdbtnAa_1.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_1.gridx = 2;
		gbc_rdbtnAa_1.gridy = 3;
		parentOne.add(rdbtnAa_1, gbc_rdbtnAa_1);
		
		JRadioButton rdbtnAa_2 = new JRadioButton("aa");
		GridBagConstraints gbc_rdbtnAa_2 = new GridBagConstraints();
		gbc_rdbtnAa_2.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnAa_2.weightx = 0.25;
		gbc_rdbtnAa_2.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_2.gridx = 3;
		gbc_rdbtnAa_2.gridy = 3;
		parentOne.add(rdbtnAa_2, gbc_rdbtnAa_2);
		
		JButton calcButton = new JButton("Calculate");
		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel geneTwoPOneLabel = new JLabel("Gene 2");
		GridBagConstraints gbc_geneTwoPOneLabel = new GridBagConstraints();
		gbc_geneTwoPOneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPOneLabel.weightx = 1.0;
		gbc_geneTwoPOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPOneLabel.gridx = 1;
		gbc_geneTwoPOneLabel.gridy = 5;
		parentOne.add(geneTwoPOneLabel, gbc_geneTwoPOneLabel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.weightx = 0.25;
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 6;
		parentOne.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdbtnAa_3 = new JRadioButton("AA");
		GridBagConstraints gbc_rdbtnAa_3 = new GridBagConstraints();
		gbc_rdbtnAa_3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAa_3.weightx = 0.25;
		gbc_rdbtnAa_3.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_3.gridx = 1;
		gbc_rdbtnAa_3.gridy = 6;
		parentOne.add(rdbtnAa_3, gbc_rdbtnAa_3);
		
		JRadioButton rdbtnAa_4 = new JRadioButton("Aa");
		GridBagConstraints gbc_rdbtnAa_4 = new GridBagConstraints();
		gbc_rdbtnAa_4.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAa_4.weightx = 0.25;
		gbc_rdbtnAa_4.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_4.gridx = 2;
		gbc_rdbtnAa_4.gridy = 6;
		parentOne.add(rdbtnAa_4, gbc_rdbtnAa_4);
		
		JRadioButton rdbtnAa_5 = new JRadioButton("aa");
		GridBagConstraints gbc_rdbtnAa_5 = new GridBagConstraints();
		gbc_rdbtnAa_5.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnAa_5.weightx = 0.25;
		gbc_rdbtnAa_5.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_5.gridx = 3;
		gbc_rdbtnAa_5.gridy = 6;
		parentOne.add(rdbtnAa_5, gbc_rdbtnAa_5);
		
		JLabel geneThreePOneLabel = new JLabel("Gene 3");
		GridBagConstraints gbc_geneThreePOneLabel = new GridBagConstraints();
		gbc_geneThreePOneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePOneLabel.weightx = 1.0;
		gbc_geneThreePOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneThreePOneLabel.gridx = 1;
		gbc_geneThreePOneLabel.gridy = 8;
		parentOne.add(geneThreePOneLabel, gbc_geneThreePOneLabel);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.weightx = 0.25;
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 9;
		parentOne.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JRadioButton rdbtnAa_6 = new JRadioButton("AA");
		GridBagConstraints gbc_rdbtnAa_6 = new GridBagConstraints();
		gbc_rdbtnAa_6.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAa_6.weightx = 0.25;
		gbc_rdbtnAa_6.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_6.gridx = 1;
		gbc_rdbtnAa_6.gridy = 9;
		parentOne.add(rdbtnAa_6, gbc_rdbtnAa_6);
		
		JRadioButton rdbtnAa_9 = new JRadioButton("Aa");
		GridBagConstraints gbc_rdbtnAa_9 = new GridBagConstraints();
		gbc_rdbtnAa_9.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAa_9.weightx = 0.25;
		gbc_rdbtnAa_9.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_9.gridx = 2;
		gbc_rdbtnAa_9.gridy = 9;
		parentOne.add(rdbtnAa_9, gbc_rdbtnAa_9);
		
		JRadioButton rdbtnAa_12 = new JRadioButton("aa");
		GridBagConstraints gbc_rdbtnAa_12 = new GridBagConstraints();
		gbc_rdbtnAa_12.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnAa_12.weightx = 0.25;
		gbc_rdbtnAa_12.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_12.gridx = 3;
		gbc_rdbtnAa_12.gridy = 9;
		parentOne.add(rdbtnAa_12, gbc_rdbtnAa_12);
		
		JLabel geneFourPOneLabel = new JLabel("Gene 4");
		GridBagConstraints gbc_geneFourPOneLabel = new GridBagConstraints();
		gbc_geneFourPOneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFourPOneLabel.gridx = 1;
		gbc_geneFourPOneLabel.gridy = 11;
		parentOne.add(geneFourPOneLabel, gbc_geneFourPOneLabel);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.weightx = 0.25;
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 12;
		parentOne.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JRadioButton rdbtnAa_7 = new JRadioButton("AA");
		GridBagConstraints gbc_rdbtnAa_7 = new GridBagConstraints();
		gbc_rdbtnAa_7.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAa_7.weightx = 0.25;
		gbc_rdbtnAa_7.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_7.gridx = 1;
		gbc_rdbtnAa_7.gridy = 12;
		parentOne.add(rdbtnAa_7, gbc_rdbtnAa_7);
		
		JRadioButton rdbtnAa_10 = new JRadioButton("Aa");
		GridBagConstraints gbc_rdbtnAa_10 = new GridBagConstraints();
		gbc_rdbtnAa_10.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAa_10.weightx = 0.25;
		gbc_rdbtnAa_10.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_10.gridx = 2;
		gbc_rdbtnAa_10.gridy = 12;
		parentOne.add(rdbtnAa_10, gbc_rdbtnAa_10);
		
		JRadioButton rdbtnAa_13 = new JRadioButton("aa");
		GridBagConstraints gbc_rdbtnAa_13 = new GridBagConstraints();
		gbc_rdbtnAa_13.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnAa_13.weightx = 0.25;
		gbc_rdbtnAa_13.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_13.gridx = 3;
		gbc_rdbtnAa_13.gridy = 12;
		parentOne.add(rdbtnAa_13, gbc_rdbtnAa_13);
		
		JLabel geneFivePOneLabel = new JLabel("Gene 5");
		GridBagConstraints gbc_geneFivePOneLabel = new GridBagConstraints();
		gbc_geneFivePOneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePOneLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFivePOneLabel.gridx = 1;
		gbc_geneFivePOneLabel.gridy = 14;
		parentOne.add(geneFivePOneLabel, gbc_geneFivePOneLabel);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.weightx = 0.25;
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 0;
		gbc_textField_4.gridy = 15;
		parentOne.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JRadioButton rdbtnAa_8 = new JRadioButton("AA");
		GridBagConstraints gbc_rdbtnAa_8 = new GridBagConstraints();
		gbc_rdbtnAa_8.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAa_8.weightx = 0.25;
		gbc_rdbtnAa_8.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_8.gridx = 1;
		gbc_rdbtnAa_8.gridy = 15;
		parentOne.add(rdbtnAa_8, gbc_rdbtnAa_8);
		
		JRadioButton rdbtnAa_11 = new JRadioButton("Aa");
		GridBagConstraints gbc_rdbtnAa_11 = new GridBagConstraints();
		gbc_rdbtnAa_11.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAa_11.weightx = 0.25;
		gbc_rdbtnAa_11.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_11.gridx = 2;
		gbc_rdbtnAa_11.gridy = 15;
		parentOne.add(rdbtnAa_11, gbc_rdbtnAa_11);
		
		JRadioButton rdbtnAa_14 = new JRadioButton("aa");
		GridBagConstraints gbc_rdbtnAa_14 = new GridBagConstraints();
		gbc_rdbtnAa_14.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnAa_14.weightx = 0.25;
		gbc_rdbtnAa_14.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAa_14.gridx = 3;
		gbc_rdbtnAa_14.gridy = 15;
		parentOne.add(rdbtnAa_14, gbc_rdbtnAa_14);
		GridBagConstraints gbc_calcButton = new GridBagConstraints();
		gbc_calcButton.insets = new Insets(0, 0, 0, 5);
		gbc_calcButton.weightx = 1.0;
		gbc_calcButton.fill = GridBagConstraints.BOTH;
		gbc_calcButton.gridx = 1;
		gbc_calcButton.gridy = 20;
		parentOne.add(calcButton, gbc_calcButton);
		
		JPanel parentTwo = new JPanel();
		parentTwo.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_parentTwo = new GridBagConstraints();
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
		
		JLabel parentTwoLabel = new JLabel("Parent Two");
		GridBagConstraints gbc_parentTwoLabel = new GridBagConstraints();
		gbc_parentTwoLabel.weightx = 1.0;
		gbc_parentTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_parentTwoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_parentTwoLabel.gridx = 1;
		gbc_parentTwoLabel.gridy = 0;
		parentTwo.add(parentTwoLabel, gbc_parentTwoLabel);
		
		JLabel geneOnePTwoLabel = new JLabel("Gene 1");
		GridBagConstraints gbc_geneOnePTwoLabel = new GridBagConstraints();
		gbc_geneOnePTwoLabel.weightx = 1.0;
		gbc_geneOnePTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneOnePTwoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_geneOnePTwoLabel.gridx = 1;
		gbc_geneOnePTwoLabel.gridy = 2;
		parentTwo.add(geneOnePTwoLabel, gbc_geneOnePTwoLabel);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.weightx = 0.25;
		gbc_textField_5.fill = GridBagConstraints.BOTH;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.gridx = 0;
		gbc_textField_5.gridy = 3;
		parentTwo.add(textField_5, gbc_textField_5);
		
		JRadioButton radioButton = new JRadioButton("AA");
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.weightx = 0.25;
		gbc_radioButton.fill = GridBagConstraints.BOTH;
		gbc_radioButton.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton.gridx = 1;
		gbc_radioButton.gridy = 3;
		parentTwo.add(radioButton, gbc_radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Aa");
		GridBagConstraints gbc_radioButton_1 = new GridBagConstraints();
		gbc_radioButton_1.weightx = 0.25;
		gbc_radioButton_1.fill = GridBagConstraints.BOTH;
		gbc_radioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_1.gridx = 2;
		gbc_radioButton_1.gridy = 3;
		parentTwo.add(radioButton_1, gbc_radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("aa");
		GridBagConstraints gbc_radioButton_2 = new GridBagConstraints();
		gbc_radioButton_2.weightx = 0.25;
		gbc_radioButton_2.fill = GridBagConstraints.BOTH;
		gbc_radioButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_radioButton_2.gridx = 3;
		gbc_radioButton_2.gridy = 3;
		parentTwo.add(radioButton_2, gbc_radioButton_2);
		
		JLabel geneTwoPTwoLabel = new JLabel("Gene 2");
		GridBagConstraints gbc_geneTwoPTwoLabel = new GridBagConstraints();
		gbc_geneTwoPTwoLabel.weightx = 1.0;
		gbc_geneTwoPTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneTwoPTwoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_geneTwoPTwoLabel.gridx = 1;
		gbc_geneTwoPTwoLabel.gridy = 5;
		parentTwo.add(geneTwoPTwoLabel, gbc_geneTwoPTwoLabel);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.weightx = 0.25;
		gbc_textField_6.fill = GridBagConstraints.BOTH;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.gridx = 0;
		gbc_textField_6.gridy = 6;
		parentTwo.add(textField_6, gbc_textField_6);
		
		JRadioButton radioButton_3 = new JRadioButton("AA");
		GridBagConstraints gbc_radioButton_3 = new GridBagConstraints();
		gbc_radioButton_3.weightx = 0.25;
		gbc_radioButton_3.fill = GridBagConstraints.BOTH;
		gbc_radioButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_3.gridx = 1;
		gbc_radioButton_3.gridy = 6;
		parentTwo.add(radioButton_3, gbc_radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("Aa");
		GridBagConstraints gbc_radioButton_4 = new GridBagConstraints();
		gbc_radioButton_4.weightx = 0.25;
		gbc_radioButton_4.fill = GridBagConstraints.BOTH;
		gbc_radioButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_4.gridx = 2;
		gbc_radioButton_4.gridy = 6;
		parentTwo.add(radioButton_4, gbc_radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("aa");
		GridBagConstraints gbc_radioButton_5 = new GridBagConstraints();
		gbc_radioButton_5.weightx = 0.25;
		gbc_radioButton_5.fill = GridBagConstraints.BOTH;
		gbc_radioButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_radioButton_5.gridx = 3;
		gbc_radioButton_5.gridy = 6;
		parentTwo.add(radioButton_5, gbc_radioButton_5);
		
		JLabel geneThreePTwoLabel = new JLabel("Gene 3");
		GridBagConstraints gbc_geneThreePTwoLabel = new GridBagConstraints();
		gbc_geneThreePTwoLabel.weightx = 1.0;
		gbc_geneThreePTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneThreePTwoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_geneThreePTwoLabel.gridx = 1;
		gbc_geneThreePTwoLabel.gridy = 8;
		parentTwo.add(geneThreePTwoLabel, gbc_geneThreePTwoLabel);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.weightx = 0.25;
		gbc_textField_7.fill = GridBagConstraints.BOTH;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.gridx = 0;
		gbc_textField_7.gridy = 9;
		parentTwo.add(textField_7, gbc_textField_7);
		
		JRadioButton radioButton_6 = new JRadioButton("AA");
		GridBagConstraints gbc_radioButton_6 = new GridBagConstraints();
		gbc_radioButton_6.weightx = 0.25;
		gbc_radioButton_6.fill = GridBagConstraints.BOTH;
		gbc_radioButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_6.gridx = 1;
		gbc_radioButton_6.gridy = 9;
		parentTwo.add(radioButton_6, gbc_radioButton_6);
		
		JRadioButton radioButton_7 = new JRadioButton("Aa");
		GridBagConstraints gbc_radioButton_7 = new GridBagConstraints();
		gbc_radioButton_7.weightx = 0.25;
		gbc_radioButton_7.fill = GridBagConstraints.BOTH;
		gbc_radioButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_7.gridx = 2;
		gbc_radioButton_7.gridy = 9;
		parentTwo.add(radioButton_7, gbc_radioButton_7);
		
		JRadioButton radioButton_8 = new JRadioButton("aa");
		GridBagConstraints gbc_radioButton_8 = new GridBagConstraints();
		gbc_radioButton_8.weightx = 0.25;
		gbc_radioButton_8.fill = GridBagConstraints.BOTH;
		gbc_radioButton_8.insets = new Insets(0, 0, 5, 0);
		gbc_radioButton_8.gridx = 3;
		gbc_radioButton_8.gridy = 9;
		parentTwo.add(radioButton_8, gbc_radioButton_8);
		
		JLabel geneFourPTwoLabel = new JLabel("Gene 4");
		GridBagConstraints gbc_geneFourPTwoLabel = new GridBagConstraints();
		gbc_geneFourPTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFourPTwoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_geneFourPTwoLabel.gridx = 1;
		gbc_geneFourPTwoLabel.gridy = 11;
		parentTwo.add(geneFourPTwoLabel, gbc_geneFourPTwoLabel);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.weightx = 0.25;
		gbc_textField_8.fill = GridBagConstraints.BOTH;
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.gridx = 0;
		gbc_textField_8.gridy = 12;
		parentTwo.add(textField_8, gbc_textField_8);
		
		JRadioButton radioButton_9 = new JRadioButton("AA");
		GridBagConstraints gbc_radioButton_9 = new GridBagConstraints();
		gbc_radioButton_9.weightx = 0.25;
		gbc_radioButton_9.fill = GridBagConstraints.BOTH;
		gbc_radioButton_9.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_9.gridx = 1;
		gbc_radioButton_9.gridy = 12;
		parentTwo.add(radioButton_9, gbc_radioButton_9);
		
		JRadioButton radioButton_10 = new JRadioButton("Aa");
		GridBagConstraints gbc_radioButton_10 = new GridBagConstraints();
		gbc_radioButton_10.weightx = 0.25;
		gbc_radioButton_10.fill = GridBagConstraints.BOTH;
		gbc_radioButton_10.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_10.gridx = 2;
		gbc_radioButton_10.gridy = 12;
		parentTwo.add(radioButton_10, gbc_radioButton_10);
		
		JRadioButton radioButton_11 = new JRadioButton("aa");
		GridBagConstraints gbc_radioButton_11 = new GridBagConstraints();
		gbc_radioButton_11.weightx = 0.25;
		gbc_radioButton_11.fill = GridBagConstraints.BOTH;
		gbc_radioButton_11.insets = new Insets(0, 0, 5, 0);
		gbc_radioButton_11.gridx = 3;
		gbc_radioButton_11.gridy = 12;
		parentTwo.add(radioButton_11, gbc_radioButton_11);
		
		JLabel geneFivePTwoLabel = new JLabel("Gene 5");
		GridBagConstraints gbc_geneFivePTwoLabel = new GridBagConstraints();
		gbc_geneFivePTwoLabel.fill = GridBagConstraints.BOTH;
		gbc_geneFivePTwoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_geneFivePTwoLabel.gridx = 1;
		gbc_geneFivePTwoLabel.gridy = 14;
		parentTwo.add(geneFivePTwoLabel, gbc_geneFivePTwoLabel);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.weightx = 0.25;
		gbc_textField_9.fill = GridBagConstraints.BOTH;
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.gridx = 0;
		gbc_textField_9.gridy = 15;
		parentTwo.add(textField_9, gbc_textField_9);
		
		JRadioButton radioButton_12 = new JRadioButton("AA");
		GridBagConstraints gbc_radioButton_12 = new GridBagConstraints();
		gbc_radioButton_12.weightx = 0.25;
		gbc_radioButton_12.fill = GridBagConstraints.BOTH;
		gbc_radioButton_12.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_12.gridx = 1;
		gbc_radioButton_12.gridy = 15;
		parentTwo.add(radioButton_12, gbc_radioButton_12);
		
		JRadioButton radioButton_13 = new JRadioButton("Aa");
		GridBagConstraints gbc_radioButton_13 = new GridBagConstraints();
		gbc_radioButton_13.weightx = 0.25;
		gbc_radioButton_13.fill = GridBagConstraints.BOTH;
		gbc_radioButton_13.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_13.gridx = 2;
		gbc_radioButton_13.gridy = 15;
		parentTwo.add(radioButton_13, gbc_radioButton_13);
		
		JRadioButton radioButton_14 = new JRadioButton("aa");
		GridBagConstraints gbc_radioButton_14 = new GridBagConstraints();
		gbc_radioButton_14.weightx = 0.25;
		gbc_radioButton_14.fill = GridBagConstraints.BOTH;
		gbc_radioButton_14.insets = new Insets(0, 0, 5, 0);
		gbc_radioButton_14.gridx = 3;
		gbc_radioButton_14.gridy = 15;
		parentTwo.add(radioButton_14, gbc_radioButton_14);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_resetButton = new GridBagConstraints();
		gbc_resetButton.weightx = 1.0;
		gbc_resetButton.fill = GridBagConstraints.BOTH;
		gbc_resetButton.insets = new Insets(0, 0, 0, 5);
		gbc_resetButton.gridx = 1;
		gbc_resetButton.gridy = 20;
		parentTwo.add(resetButton, gbc_resetButton);
		
		JPanel resultsPanel = new JPanel();
		resultsPanel.setBackground(Color.BLUE);
		GridBagConstraints gbc_resultsPanel = new GridBagConstraints();
		gbc_resultsPanel.gridwidth = 2;
		gbc_resultsPanel.fill = GridBagConstraints.BOTH;
		gbc_resultsPanel.weighty = 1.0;
		gbc_resultsPanel.weightx = 0.6;
		gbc_resultsPanel.gridx = 2;
		gbc_resultsPanel.gridy = 0;
		content.add(resultsPanel, gbc_resultsPanel);
		resultsPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JTextArea txtrResultsjta = new JTextArea();
		resultsPanel.add(txtrResultsjta, "4, 2, fill, fill");
	}

}
