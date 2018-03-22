package pc_user_interface;

/**
 *Last Name: Barrios-Ruiz
 *First Name: Nicolas 
 *Student ID: 500773454
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CustomerUI extends JFrame{

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    
    private JFrame frame;
    private JPanel customerPanel;

    private JButton confirm;
    private JButton confirm2;

    private ActionListener payCreditListener;
    private ActionListener payDebitListener;
    private ActionListener confirmListener1;
    private ActionListener confirmListener2;

    private JMenuBar menuBar;
    private JMenu payMenu;
    private JMenuItem payMenuItemC;
    private JMenuItem payMenuItemD;

    private JPanel menuPanel;
    private JPanel descPanel;
    private JPanel payPanelC;
    private JPanel payPanelD;

    private JLabel welcomeLabel;
    private JLabel ccNumber;
    private JLabel dcNumber;
    private JLabel firstName1;
    private JLabel lastName1;
    private JLabel firstName2;
    private JLabel lastName2;
    private JLabel month;
    private JLabel day;
    private JLabel time;
    private JLabel month2;
    private JLabel day2;
    private JLabel time2;
    
    private JTextField ccTextField;
    private JTextField fnTextField;
    private JTextField lnTextField;
    private JTextField dcTextField;
    private JTextField fnTextField2;
    private JTextField lnTextField2;
    private JTextField monthField;
    private JTextField dayField;
    private JTextField timeField;
    private JTextField monthField2;
    private JTextField dayField2;
    private JTextField timeField2;

    private JTextArea confirmation1;
    private JTextArea confirmation2;

    private String confirmDate1;
    private String confirmDate2;
    private String lastNameGotten;
    private String firstNameGotten;
    private String ccNumberGotten;
    private String dayGotten;
    private String monthGotten;
    private String timeGotten;

    class PayCreditListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
        validate();
        repaint();
        createPayPanelC();
        validate();
        repaint();
        }
    }

    class PayDebitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
        validate();
        repaint();
        createPayPanelD();
        validate();
        repaint();
        }
    }

    class ConfirmListener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            getInfoPayC();
        }
    }

    class ConfirmListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            getInfoPayD();
        }
    }

    public CustomerUI(String frameTitle){
        descPanel = new JPanel(new BorderLayout());
        menuPanel = new JPanel(new BorderLayout());
        menuPanel.setPreferredSize(new Dimension(410, 400));
        add(menuPanel);
        welcomeLabel = new JLabel("Welcome");

        setTitle(frameTitle);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setMinimumSize(new Dimension(410, 400));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createMenuBar();

    }

    public void createMenuBar(){
        menuBar = new JMenuBar();
        createPayMenu();
        menuPanel.add(menuBar, BorderLayout.NORTH);
    }

    public void createPayMenu(){
        payMenu = new JMenu("Pay");

        payMenuItemC = new JMenuItem("Credit");
        payCreditListener = new PayCreditListener();
        payMenuItemC.addActionListener(payCreditListener);

        payMenuItemD = new JMenuItem("Debit");
        payDebitListener = new PayDebitListener();
        payMenuItemD.addActionListener(payDebitListener);

        payMenu.add(payMenuItemC);
        payMenu.add(payMenuItemD);

        menuBar.add(payMenu);

    }

    public void createPayPanelC(){
        descPanel.removeAll();
        payPanelC = new JPanel(new GridLayout(3,1));
        JPanel north = new JPanel(new GridLayout(3,3));
        JPanel center = new JPanel(new GridLayout(4,3));
        confirmation1 = new JTextArea();

        confirm = new JButton("Confirm");
        confirmListener1 = new ConfirmListener1();
        confirm.addActionListener(confirmListener1);

        monthField = new JTextField();
        month = new JLabel("Month:");
        dayField = new JTextField();
        day = new JLabel("Day:");
        timeField = new JTextField();
        time = new JLabel("Time:");

        center.add(month);
        center.add(monthField);
        center.add(day);
        center.add(dayField);
        center.add(time);
        center.add(timeField);
        center.add(confirm);

        ccNumber = new JLabel("Credit Card Number:");
        ccTextField = new JTextField(1);

        firstName1 = new JLabel("First Name:");
        lastName1 = new JLabel("Last Name:");

        fnTextField = new JTextField(1);
        lnTextField = new JTextField(1);

        north.add(ccNumber);
        north.add(ccTextField);
        north.add(firstName1);
        north.add(fnTextField);
        north.add(lastName1);
        north.add(lnTextField);
        payPanelC.add(north);
        payPanelC.add(center);
        payPanelC.add(confirmation1);

        descPanel.add(payPanelC);
        menuPanel.add(descPanel);

    }

     public void createPayPanelD(){
        descPanel.removeAll();
        payPanelD = new JPanel(new GridLayout(3,1));
        JPanel north2 = new JPanel(new GridLayout(3,3));
        JPanel center2 = new JPanel(new GridLayout(4,3));
        confirmation2 = new JTextArea();

        confirm2 = new JButton("Confirm");
        confirmListener2 = new ConfirmListener2();
        confirm2.addActionListener(confirmListener2);

        monthField2 = new JTextField();
        month2 = new JLabel("Month:");
        dayField2 = new JTextField();
        day2 = new JLabel("Day:");
        timeField2 = new JTextField();
        time2 = new JLabel("Time:");

        center2.add(month2);
        center2.add(monthField2);
        center2.add(day2);
        center2.add(dayField2);
        center2.add(time2);
        center2.add(timeField2);
        center2.add(confirm2);

        dcNumber = new JLabel("Debit Card Number:");
        dcTextField = new JTextField(1);

        firstName2 = new JLabel("First Name:");
        lastName2 = new JLabel("Last Name:");

        fnTextField2 = new JTextField(1);
        lnTextField2 = new JTextField(1);

        north2.add(dcNumber);
        north2.add(dcTextField);
        north2.add(firstName2);
        north2.add(fnTextField2);
        north2.add(lastName2);
        north2.add(lnTextField2);
        payPanelD.add(north2);
        payPanelD.add(center2);
        payPanelD.add(confirmation2);

        descPanel.add(payPanelD);
        menuPanel.add(descPanel);
     }
     public void getInfoPayC(){
        lastNameGotten = lnTextField.getText();
        firstNameGotten = fnTextField.getText();
        ccNumberGotten = ccTextField.getText();
        dayGotten = dayField.getText();
        monthGotten = monthField.getText();
        timeGotten = timeField.getText();

        if(lastNameGotten.isEmpty() || firstNameGotten.isEmpty() || ccNumberGotten.isEmpty() || dayGotten.isEmpty() || monthGotten.isEmpty() || timeGotten.isEmpty()){
            confirmation1.setText("Error missing information");
        }
        else{
        confirmDate1 = firstNameGotten + " " + lastNameGotten + " scheduled at " + monthGotten + " " + dayGotten + " at " + timeGotten + " using CC# " + ccNumberGotten;
        confirmation1.setText(confirmDate1);
        }
     } 

     public void getInfoPayD(){
        lastNameGotten = lnTextField2.getText();
        firstNameGotten = fnTextField2.getText();
        ccNumberGotten = dcTextField.getText();
        dayGotten = dayField2.getText();
        monthGotten = monthField2.getText();
        timeGotten = timeField2.getText();

        if(lastNameGotten.isEmpty() || firstNameGotten.isEmpty() || ccNumberGotten.isEmpty() || dayGotten.isEmpty() || monthGotten.isEmpty() || timeGotten.isEmpty()){
            confirmation2.setText("Error missing information");
        }
        else{
        confirmDate2 = firstNameGotten + " " + lastNameGotten + " scheduled at " + monthGotten + " " + dayGotten + " at " + timeGotten + " using DC# " + ccNumberGotten;
        confirmation2.setText(confirmDate2);
        }
     } 
}
