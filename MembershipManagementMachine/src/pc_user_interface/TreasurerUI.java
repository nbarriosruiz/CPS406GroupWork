package pc_user_interface;

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TreasurerUI {
	private JFrame 		frame;
	
	private String		userName;
	
	private JMenuBar 	accountsMenuBar;
	private JMenu		fileMenu;
	private JMenuItem	open, saveAs, save, exit;
	private JMenu		helpMenu;
	private JMenuItem	about, content, documentation, support, checkForUpdates;
	
	private JTabbedPane	tabbedPane;
	private JPanel		accountsTab;
	private JTextArea	accountsTextArea;
	private JPanel		managementTab;
	
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
		frame.setJMenuBar(accountsMenuBar());
		frame.add(introPanel(),	BorderLayout.NORTH);
		frame.add(tabbedPane(),	BorderLayout.CENTER);
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
		managementTab = new JPanel(new BorderLayout());
		
		
		
		return managementTab;
	}
	
	public JPanel accountsTab() {
		accountsTab = new JPanel(new GridLayout(1,2));
		
		JPanel accountsTextPanel = 	new JPanel(new BorderLayout());
		accountsTextArea = 			new JTextArea();
		JPanel toolsPanel = 		new JPanel(new GridLayout());
		
		accountsTextPanel.setBorder(BorderFactory.createEtchedBorder());
		accountsTextPanel.add(accountsTextArea, BorderLayout.CENTER);
		
		accountsTab.add(toolsPanel);
		accountsTab.add(accountsTextPanel);
		
		return accountsTab;
	}
	
	public JPanel introPanel() {
		JPanel introPanel = new JPanel(new BorderLayout());
		
		introPanel.setLayout(new GridBagLayout());
		
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
