package pc_user_interface;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class MainUI {
	private static JFrame 		frame;
	
	private static JMenuBar 	menuBar;
	private static JMenu		fileMenu;
	private static JMenuItem	open, saveAs, save, exit;
	private static JMenu		helpMenu;
	private static JMenuItem	about, content, documentation, support, checkForUpdates;
	
	public static void main(String[] args) {
		frame = new JFrame("Membership Management Machine");
		frame.setVisible(true);
		fillFrame();
		frame.setSize(400,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void fillFrame() {
		frame.setJMenuBar(menuBar());
	}
	
	public static JMenuBar menuBar() {
		menuBar = new JMenuBar();
		
		menuBar.add(fileMenu());
		menuBar.add(helpMenu());
		
		return menuBar;
	}
	
	public static JMenu fileMenu() {
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
	
	public static JMenu helpMenu() {
		JMenu helpMenu = new JMenu("Help");
		//about, content, documentation, support, checkForUpdates;
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
