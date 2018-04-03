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

public class TreasurerUI extends JFrame{
	private int			frameWidth 	= 400;
	private int			frameHeight = 600;
	
	private String		userName;
	
	private JMenuBar 	accountsMenuBar;
	private JMenu		fileMenu;
	private JMenuItem	open, saveAs, save, exit;
	private JMenu		helpMenu;
	private JMenuItem	about, content, documentation, support, checkForUpdates;
	
	private JTabbedPane	tabbedPane;
	private JSplitPane	managementTab;
	private JPanel		managementOptionsPanel;
	private JScrollPane	incomeStatementScrollPane;
	private JTextArea	incomeStatementTextArea;
	private JPanel 		panel, 		panel_1, 	panel_2, 	panel_3, 	panel_4, 
						panel_5,	panel_6, 	panel_7, 	panel_8, 	panel_9,
						panel_10;
	private JLabel 		lblIncomeStatement, lblIncomeStatement_1, lblSales, 
						lblIncome, lblCost, lblTax, lblPercentage, lblOptions;
	private JTextField 	textField_sales, textField_income, textField_costs, 
						textField_tax;
	private JButton 	btnPrint;
	private JSplitPane	communicationsTab;
	private JPanel		communicationsOptionPanel;
	private JList 		customerList;
	private JScrollPane customersScrollPane;
	
	public TreasurerUI(String frameTitle, String userName) {
		setTitle(frameTitle);
		this.userName = userName;
		setVisible(true);
		this.fillFrame();
		setSize(frameWidth, frameHeight);
		setMinimumSize(new Dimension(frameWidth, frameHeight));
		//frame.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void fillFrame() {
		setJMenuBar(accountsMenuBar());
		getContentPane().add(introPanel(),	BorderLayout.NORTH);
		getContentPane().add(tabbedPane(),	BorderLayout.CENTER);
	}
	
	public JTabbedPane tabbedPane() {
		tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Communication", null, communicationsTab(),	null);
		
		tabbedPane.addTab("Management",	null, managementTab(),	null);
		
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		// this line allows u to change the tab index to focus on what ever tab u want
		tabbedPane.setSelectedIndex(1);
		
		return tabbedPane;
	}

	private void set1By3MinimumSizeRatioForPanel(JPanel panel) {
		int width = frameWidth / 3;
		int height = frameHeight;
		panel.setMinimumSize(new Dimension(width, height));
	}
	
	public JSplitPane communicationsTab() {
		communicationsTab = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		communicationsTab.setDividerLocation(frameWidth / 3);
		
		customerList = 			new JList<JLabel>();
		customersScrollPane = 	new JScrollPane(customerList);
		
		customerList.add(new JLabel("Hello"));
		
		int width = 2 * frameWidth / 3;
		int height = frameHeight;
		customersScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		customersScrollPane.setMinimumSize(new Dimension(width, height));
		
		communicationsTab.add(communicationsOptionPanel());
		communicationsTab.add(customersScrollPane);
		
		panel_10 = new JPanel();
		customersScrollPane.setColumnHeaderView(panel_10);
		
		return communicationsTab;
	}
	
	public JPanel communicationsOptionPanel() {
		communicationsOptionPanel = new JPanel();
		
		set1By3MinimumSizeRatioForPanel(communicationsOptionPanel);
		
		return communicationsOptionPanel;
	}
	
	public JSplitPane managementTab() {
		managementTab = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		managementTab.setDividerLocation(frameWidth / 3);
		
		incomeStatementTextArea =		new JTextArea();
		incomeStatementScrollPane =		new JScrollPane(incomeStatementTextArea);
		
		int width = 2 * frameWidth / 3;
		int height = frameHeight;
		incomeStatementScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		incomeStatementScrollPane.setMinimumSize(new Dimension(width, height));
		
		managementTab.add(managementOptionsPanel());
		managementTab.add(incomeStatementScrollPane);
		
		lblIncomeStatement_1 = new JLabel(" Income Statement:");
		incomeStatementScrollPane.setColumnHeaderView(lblIncomeStatement_1);
		
		return managementTab;
	}
	
	public JPanel managementOptionsPanel() { // refactor this when you get the chance
		int gridSize = 15;
		managementOptionsPanel = new JPanel(new GridLayout(gridSize,1));
		set1By3MinimumSizeRatioForPanel(managementOptionsPanel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		managementOptionsPanel.add(panel);
		
		lblIncomeStatement = new JLabel("Income Statement");
		panel.add(lblIncomeStatement);
		
		panel_1 = new JPanel();
		managementOptionsPanel.add(panel_1);
		
		lblIncome = new JLabel("income $");
		panel_1.add(lblIncome);
		
		textField_income = new JTextField();
		panel_1.add(textField_income);
		textField_income.setColumns(5);
		
		panel_2 = new JPanel();
		managementOptionsPanel.add(panel_2);
		
		lblSales = new JLabel("sales $");
		panel_2.add(lblSales);
		
		textField_sales = new JTextField();
		panel_2.add(textField_sales);
		textField_sales.setColumns(6);
		
		panel_3 = new JPanel();
		managementOptionsPanel.add(panel_3);
		
		lblCost = new JLabel("costs $");
		panel_3.add(lblCost);
		
		textField_costs = new JTextField();
		panel_3.add(textField_costs);
		textField_costs.setColumns(6);
		
		panel_4 = new JPanel();
		managementOptionsPanel.add(panel_4);
		
		lblTax = new JLabel("tax ");
		panel_4.add(lblTax);
		
		textField_tax = new JTextField();
		panel_4.add(textField_tax);
		textField_tax.setColumns(6);
		
		lblPercentage = new JLabel("%");
		panel_4.add(lblPercentage);
		
		panel_5 = new JPanel();
		managementOptionsPanel.add(panel_5);
		
		panel_6 = new JPanel();
		managementOptionsPanel.add(panel_6);
		
		panel_7 = new JPanel();
		managementOptionsPanel.add(panel_7);
		
		panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		managementOptionsPanel.add(panel_8);
		
		lblOptions = new JLabel("Options");
		panel_8.add(lblOptions);
		
		panel_9 = new JPanel();
		managementOptionsPanel.add(panel_9);
		
		btnPrint = new JButton("print");
		panel_9.add(btnPrint);
		
		return managementOptionsPanel;
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
