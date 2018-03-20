package pc_user_interface;

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TreasurerUI {
	private JFrame 		frame;
	
	private String		userName;
	
	private JMenuBar 	menuBar;
	private JMenu		fileMenu;
	private JMenuItem	open, saveAs, save, exit;
	private JMenu		helpMenu;
	private JMenuItem	about, content, documentation, support, checkForUpdates;
	
	private JPanel		introPanel;
	private JLabel		nameLabel;
	
	private JPanel		tabsPanel;
	private JTabbedPane	tabbedPane;
	private JPanel		accountsTab, customersTab, managementTab;
	
	public TreasurerUI(String userName) {
		this.userName = userName;
		frame = new JFrame("Membership Management Machine");
		frame.setVisible(true);
		this.fillFrame();
		frame.setSize(400,600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void fillFrame() {
		frame.setJMenuBar(menuBar());
		frame.add(introPanel(), BorderLayout.NORTH);
		frame.add(tabsPanel(), BorderLayout.CENTER);
	}
	
	public JPanel tabsPanel() {
		tabsPanel = new JPanel(new BorderLayout());
		
		tabsPanel.add(tabbedPane(), BorderLayout.CENTER);
		
		return tabsPanel;
	}
	
	public JTabbedPane tabbedPane() {
		tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Management", null, managementTab(), null);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		tabbedPane.addTab("Customers", null, customersTab(), null);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		tabbedPane.addTab("Accounts", null, accountsTab(), null);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		
		return tabbedPane;
	}
	
	public JPanel managementTab() {
		managementTab = new JPanel(new BorderLayout());
		
		
		
		return managementTab;
	}
	
	public JPanel customersTab() {
		customersTab = new JPanel();
		
		return customersTab;
	}
	
	public JPanel accountsTab() {
		accountsTab = new JPanel(new BorderLayout());
		
		return accountsTab;
	}
	
	public JPanel introPanel() {
		introPanel = new JPanel(new BorderLayout());
		
		introPanel.setLayout(new GridBagLayout());
		
		nameLabel = new JLabel(userName + " signed in as Treasurer");
		
		introPanel.add(nameLabel);
		
		return introPanel;
	}
	
	public JMenuBar menuBar() {
		menuBar = new JMenuBar();
		
		menuBar.add(fileMenu());
		menuBar.add(helpMenu());
		
		return menuBar;
	}
	
	public JMenu fileMenu() {
		fileMenu = new JMenu("File");
		
		open = 		new JMenuItem("open");
		saveAs = 	new JMenuItem("save as");
		save = 		new JMenuItem("save");
		exit = 		new JMenuItem("exit");
		
		fileMenu.add(open);
		fileMenu.add(saveAs);
		fileMenu.add(save);
		fileMenu.add(exit);
		
		return fileMenu;
	}
	
	public JMenu helpMenu() {
		JMenu helpMenu = new JMenu("Help");
		
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
