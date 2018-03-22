package pc_user_interface;

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TreasurerUI {
	private JFrame 		frame;
	private int			frameWidth 	= 400;
	private int			frameHeight = 600;
	
	private String		userName;
	
	private JMenuBar 	accountsMenuBar;
	private JMenu		fileMenu;
	private JMenuItem	open, saveAs, save, exit;
	private JMenu		helpMenu;
	private JMenuItem	about, content, documentation, support, checkForUpdates;
	
	private JTabbedPane	tabbedPane;
	private JSplitPane	accountsTab;
	private JScrollPane	accountsScrollPane;
	private JTextArea	accountsTextArea;
	private JPanel 		panel, 		panel_1, 	panel_2, 	panel_3, 	panel_4, 
						panel_5,	panel_6, 	panel_7, 	panel_8, 	panel_9,
						panel_10, 	panel_11, 	panel_12, 	panel_13, 	panel_14,
						panel_15;
	private JLabel 		lblIncomeStatement;
	private JLabel 		lblSales;
	private JTextField 	textField_sales;
	private JLabel 		lblIncome;
	private JTextField 	textField_income;
	private JLabel 		lblCost;
	private JTextField 	textField_costs;
	private JLabel 		lblTax;
	private JTextField 	textField_tax;
	private JLabel 		lblPercentage;
	private JLabel 		lblOptions;
	private JButton 	btnPrint;
	private JSplitPane	managementTab;
	
	public TreasurerUI(String userName) {
		this.userName = userName;
		frame = new JFrame("Membership Management Machine");
		frame.setVisible(true);
		this.fillFrame();
		frame.setSize(frameWidth, frameHeight);
		frame.setMinimumSize(new Dimension(frameWidth, frameHeight));
		//frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void fillFrame() {
		frame.setJMenuBar(accountsMenuBar());
		frame.getContentPane().add(introPanel(),	BorderLayout.NORTH);
		frame.getContentPane().add(tabbedPane(),	BorderLayout.CENTER);
	}
	
	public JTabbedPane tabbedPane() {
		tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Management", null, managementTab(),	null);
		
		tabbedPane.addTab("Accounts",	null, accountsTab(),	null);
		
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		// this line allows u to change the tab index to focus on what ever tab u want
		tabbedPane.setSelectedIndex(1);
		
		return tabbedPane;
	}
	
	public JPanel managementTab() {
		managementTab = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		managementTab.setDividerLocation(frameWidth / 3);
		
		return managementTab;
	}
	
	public JSplitPane accountsTab() {
		accountsTab = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		accountsTab.setDividerLocation(frameWidth / 3);
		
		accountsTextArea =		new JTextArea();
		accountsScrollPane =	new JScrollPane(accountsTextArea);
		
		int width = 2 * frameWidth / 3;
		int height = frameHeight;
		accountsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		accountsScrollPane.setMinimumSize(new Dimension(width, height));
		
		accountsTab.add(optionsPanel());
		accountsTab.add(accountsScrollPane);
		
		return accountsTab;
	}
	
	public JPanel optionsPanel() {
		int gridSize = 16;
		JPanel optionsPanel = new JPanel(new GridLayout(gridSize,1));
		int width = frameWidth / 3;
		int height = frameHeight;
		optionsPanel.setMinimumSize(new Dimension(width, height));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		optionsPanel.add(panel);
		
		lblIncomeStatement = new JLabel("Income Statement");
		panel.add(lblIncomeStatement);
		
		panel_1 = new JPanel();
		optionsPanel.add(panel_1);
		
		lblIncome = new JLabel("income $");
		panel_1.add(lblIncome);
		
		textField_income = new JTextField();
		panel_1.add(textField_income);
		textField_income.setColumns(5);
		
		panel_2 = new JPanel();
		optionsPanel.add(panel_2);
		
		lblSales = new JLabel("sales $");
		panel_2.add(lblSales);
		
		textField_sales = new JTextField();
		panel_2.add(textField_sales);
		textField_sales.setColumns(6);
		
		panel_3 = new JPanel();
		optionsPanel.add(panel_3);
		
		lblCost = new JLabel("costs $");
		panel_3.add(lblCost);
		
		textField_costs = new JTextField();
		panel_3.add(textField_costs);
		textField_costs.setColumns(6);
		
		panel_4 = new JPanel();
		optionsPanel.add(panel_4);
		
		lblTax = new JLabel("tax ");
		panel_4.add(lblTax);
		
		textField_tax = new JTextField();
		panel_4.add(textField_tax);
		textField_tax.setColumns(6);
		
		lblPercentage = new JLabel("%");
		panel_4.add(lblPercentage);
		
		panel_5 = new JPanel();
		optionsPanel.add(panel_5);
		
		panel_6 = new JPanel();
		optionsPanel.add(panel_6);
		
		panel_7 = new JPanel();
		optionsPanel.add(panel_7);
		
		panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		optionsPanel.add(panel_8);
		
		lblOptions = new JLabel("Options");
		panel_8.add(lblOptions);
		
		panel_9 = new JPanel();
		optionsPanel.add(panel_9);
		
		btnPrint = new JButton("print");
		panel_9.add(btnPrint);
		
		panel_10 = new JPanel();
		optionsPanel.add(panel_10);
		
		panel_11 = new JPanel();
		optionsPanel.add(panel_11);
		
		panel_12 = new JPanel();
		optionsPanel.add(panel_12);
		
		panel_13 = new JPanel();
		optionsPanel.add(panel_13);
		
		panel_14 = new JPanel();
		optionsPanel.add(panel_14);
		
		panel_15 = new JPanel();
		optionsPanel.add(panel_15);
		
		
		
		return optionsPanel;
	}
	
	public JPanel introPanel() {
		JPanel introPanel = new JPanel(new GridBagLayout());
		introPanel.setBackground(SystemColor.textHighlightText);
		
		introPanel.add(new JLabel(userName + " signed in as Treasurer"));
		
		return introPanel;
	}
	
	public JMenuBar accountsMenuBar() {
		accountsMenuBar = new JMenuBar();
		
		accountsMenuBar.add(fileMenu());
		accountsMenuBar.add(helpMenu());
		
		return accountsMenuBar;
	}
	
	public JMenu fileMenu() {
		fileMenu = new JMenu("File");
		
		open = 		new JMenuItem("open");
		saveAs =	new JMenuItem("save as");
		save = 		new JMenuItem("save");
		exit = 		new JMenuItem("exit");
		
		fileMenu.add(open);
		fileMenu.add(saveAs);
		fileMenu.add(save);
		fileMenu.add(exit);
		
		return fileMenu;
	}
	
	public JMenu helpMenu() {
		helpMenu = new JMenu("Help");
		
		about = 			new JMenuItem("about");
		content = 			new JMenuItem("content");
		documentation = 	new JMenuItem("open documentation");
		support = 			new JMenuItem("support");
		checkForUpdates =	new JMenuItem("check for updates");
		
		helpMenu.add(about);
		helpMenu.add(content);
		helpMenu.add(documentation);
		helpMenu.add(support);
		helpMenu.add(checkForUpdates);
		
		return helpMenu;
	}
}
