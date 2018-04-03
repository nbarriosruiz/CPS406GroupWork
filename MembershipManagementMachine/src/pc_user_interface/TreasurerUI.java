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
	private int			frameWidth 	= 800;
	private int			frameHeight = 600;
	
	private String		userName;
	
	private JMenuBar 	accountsMenuBar;
	private JMenu		fileMenu;
	private JMenuItem	newIncomeStatement, open, saveAs, save, exit;
	private JMenu		helpMenu;
	private JMenuItem	about, documentation;
	
	private JTabbedPane	tabbedPane;
	private JSplitPane	incomeAndExpensesTab;
	private JPanel		incomeAndExpensesOptionsPanel;
	private JScrollPane	incomeStatementScrollPane;
	private JTextArea	incomeStatementTextArea;
	private JPanel 		incomeStatementInputPanel, panel_1, panel_2, panel_3, 
						incomeStatementOptionsPanel;
	private JLabel 		lblIncomeStatement, lblRevenue, lblExpenses, lblTax, lblPercentage, lblOptions;
	private JTextField 	textField_income, textField_costs, textField_tax;
	private JButton 	btnOutputResult, btnSave;
	private JSplitPane	accountsTab;
	private JPanel		accountsOptionPanel;
	private JPanel		customerSortingPanel;
	private JList 		customerList;
	private JScrollPane customersScrollPane;
	private JPanel panel;
	
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
		
		tabbedPane.addTab("Accounts", null, accountsTab(),	null);
		
		tabbedPane.addTab("Income and Expenses",	null, incomeAndExpensesTab(),	null);
		
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		// this line allows u to change the tab index to focus on what ever tab u want
		tabbedPane.setSelectedIndex(1);
		
		return tabbedPane;
	}

	private void set1By3MinimumSizeRatioForPanel(JComponent component) {
		int width = frameWidth / 3;
		int height = frameHeight;
		component.setMinimumSize(new Dimension(width, height));
	}
	
	public JSplitPane accountsTab() {
		accountsTab = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		accountsTab.setDividerLocation(frameWidth / 3);
		
		customerList = 			new JList<JLabel>();
		customersScrollPane = 	new JScrollPane(customerList);
		customerSortingPanel = 	new JPanel();
		
		customerList.add(new JLabel("Hello"));
		
		int width = 2 * frameWidth / 3;
		int height = frameHeight;
		customersScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		customersScrollPane.setMinimumSize(new Dimension(width, height));
		customersScrollPane.setColumnHeaderView(customerSortingPanel);
		set1By3MinimumSizeRatioForPanel(customerScrollPane);
		
		accountsTab.add(customersScrollPane);
		accountsTab.add(accountsOptionPanel());
		
		return accountsTab;
	}
	
	public JPanel accountsOptionPanel() {
		accountsOptionPanel = new JPanel();
		
		//set1By3MinimumSizeRatioForPanel(accountsOptionPanel);
		
		
		
		return accountsOptionPanel;
	}
	
	public JSplitPane incomeAndExpensesTab() {
		incomeAndExpensesTab = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		incomeAndExpensesTab.setDividerLocation(frameWidth / 3);
		
		incomeStatementTextArea =		new JTextArea();
		incomeStatementScrollPane =		new JScrollPane(incomeStatementTextArea);
		lblIncomeStatement = 			new JLabel(" Income Statement:");
		
		int width = 2 * frameWidth / 3;
		int height = frameHeight;
		incomeStatementScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		incomeStatementScrollPane.setMinimumSize(new Dimension(width, height));
		incomeStatementScrollPane.setColumnHeaderView(lblIncomeStatement);
		
		incomeAndExpensesTab.add(incomeAndExpensesOptionsPanel());
		incomeAndExpensesTab.add(incomeStatementScrollPane);
		
		return incomeAndExpensesTab;
	}
	
	public JPanel incomeAndExpensesOptionsPanel() {
		incomeAndExpensesOptionsPanel = new JPanel(new GridLayout(2,1));
		set1By3MinimumSizeRatioForPanel(incomeAndExpensesOptionsPanel);
		
		incomeAndExpensesOptionsPanel.add(incomeStatementInputPanel());
		incomeAndExpensesOptionsPanel.add(incomeStatementOptionsPanel());
		
		btnSave = new JButton("save");
		incomeStatementOptionsPanel.add(btnSave);
		
		return incomeAndExpensesOptionsPanel;
	}
	
	public JPanel incomeStatementOptionsPanel() {
		incomeStatementOptionsPanel = new JPanel();
		incomeStatementOptionsPanel.setBorder(new TitledBorder(null, "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnOutputResult = 			new JButton("output result");
		incomeStatementOptionsPanel.add(btnOutputResult);
		
		return incomeStatementOptionsPanel;
	}
	
	public JPanel incomeStatementInputPanel() {
		incomeStatementInputPanel = new JPanel((new GridLayout(4, 1)));
		incomeStatementInputPanel.setBorder(new TitledBorder(null, "Input", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel_1 = 			new JPanel();
		lblRevenue = 		new JLabel("revenue $");
		textField_income = 	new JTextField();
		textField_income.setColumns(14);
		panel_1.add(lblRevenue);
		panel_1.add(textField_income);
		
		panel_2 = 			new JPanel();
		lblExpenses = 			new JLabel("expenses $");
		textField_costs = 	new JTextField();
		textField_costs.setColumns(13);
		panel_2.add(lblExpenses);
		panel_2.add(textField_costs);
		
		panel_3 = 			new JPanel();
		lblTax = 			new JLabel("tax ");
		textField_tax = 	new JTextField();
		lblPercentage = 	new JLabel("%");
		textField_tax.setColumns(16);
		panel_3.add(lblTax);
		panel_3.add(textField_tax);
		panel_3.add(lblPercentage);
		
		incomeStatementInputPanel.add(panel_1);
		incomeStatementInputPanel.add(panel_2);
		incomeStatementInputPanel.add(panel_3);
		
		return incomeStatementInputPanel;
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
		
		newIncomeStatement = 	new JMenuItem("new income statement");
		open = 					new JMenuItem("open");
		saveAs =				new JMenuItem("save as");
		save = 					new JMenuItem("save");
		exit = 					new JMenuItem("exit");
		
		fileMenu.add(newIncomeStatement);
		fileMenu.add(open);
		fileMenu.add(saveAs);
		fileMenu.add(save);
		fileMenu.add(exit);
		
		return fileMenu;
	}
	
	public JMenu helpMenu() {
		helpMenu = new JMenu("Help");
		
		about = 			new JMenuItem("about");
		documentation = 	new JMenuItem("open documentation");
		
		helpMenu.add(about);
		helpMenu.add(documentation);
		
		return helpMenu;
	}
}
