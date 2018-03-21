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
	private JSplitPane	accountsTab;
	private JScrollPane	accountsScrollPane;
	private JTextArea	accountsTextArea;
	private JButton		printButton;
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
	
	public JSplitPane accountsTab() {
		accountsTab = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		accountsTab.setDividerLocation(100);
		
		accountsTextArea =			new JTextArea();
		accountsScrollPane = 		new JScrollPane(accountsTextArea);
		
		accountsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		accountsScrollPane.setMinimumSize(new Dimension(300, 600));
		
		accountsTab.add(optionsPanel());
		accountsTab.add(accountsScrollPane);
		
		return accountsTab;
	}
	
	public JPanel optionsPanel() {
		JPanel optionsPanel = new JPanel(new GridLayout(16,1));
		optionsPanel.setMinimumSize(new Dimension(100, 600));
		
		JPanel centeredText = new JPanel(new GridBagLayout());
		JLabel optionsLabel = new JLabel("Options");
		printButton = new JButton("print");
		
		centeredText.add(optionsLabel);
		
		optionsPanel.add(centeredText);
		optionsPanel.add(printButton);
		
		return optionsPanel;
	}
	
	public JPanel introPanel() {
		JPanel introPanel = new JPanel(new GridBagLayout());
		
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
