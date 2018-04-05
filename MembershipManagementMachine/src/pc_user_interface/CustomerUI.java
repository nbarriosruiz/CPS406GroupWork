package pc_user_interface;
/**
 *Last Name: Barrios-Ruiz
 *First Name: Nicolas 
 *Student ID: 500773454
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;

public class CustomerUI extends JFrame{

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 400;

    private JPanel pPayment;
    private JPanel pCredit;
    private JPanel pDebit;

    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblPhoneNumber;
    private JLabel lblAddress;
    private JLabel lblCreditNumber;
    private JLabel lblSecurityCode;
    private JLabel lblDebitNumber;
    private JLabel lblVerificationCode;

    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfPhoneNumber;
    private JTextField tfAddress;
    private JTextField tfCreditNumber;
    private JTextField tfSecurityCode;
    private JTextField tfDebitNumber;
    private JTextField tfVerificationCode;

    private JTextArea taNotification;

    private ActionListener paymentListener;
    private ActionListener confirmListener;
    private ActionListener backListener;

    private JButton btnCredit;
    private JButton btnDebit;
    private JButton btnConfirm1;
    private JButton btnConfirm2;
    private JButton btnCreditBack;
    private JButton btnDebitBack;

    private JPanel menuPanel;
        
    private String lastNameGotten;
    private String firstNameGotten;
    private String addressGotten;
    private String phoneNumberGotten;
    private String ccNumberGotten;
    private String securityCodeGotten;
    private String dcNumberGotten;
    private String verificationCodeGotten;
    private String userName;

    class PaymentListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            // Action done if credit button is clicked
            if(event.getSource() == btnCredit)
            {
                validate();
                repaint();
                pCredit();
                validate();
                repaint();  
            }
            // Action done if debit button is clicked
            if(event.getSource() == btnDebit)
            {
                validate();
                repaint();
                pDebit();
                validate();
                repaint();
            }
        }
    }
    class ConfirmListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
            if(event.getSource() == btnConfirm1)
            {
                // Action done if confirm button is clicked after clicking credit
                getInfoPayC();
            }
            if(event.getSource() == btnConfirm2)
            {
                // Action done if confirm button is clicked after clicking debit
                getInfoPayD();
            }
        }
    }
    class BackListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == btnCreditBack)
            {
                //Action done if debit button is clicked after clicking credit
                validate();
                repaint();
                pDebit();
                validate();
                repaint();
            }
            if(event.getSource() == btnDebitBack)
            {
                //Action done if credit button is clicked after clicking debit
                validate();
                repaint();
                pCredit();
                validate();
                repaint(); 
            }
        }
    }

    public CustomerUI(String userName){
        String frameTitle = userName + ", Welcome to LA Fitness ";
        setTitle(frameTitle);
        this.userName = userName;
        setVisible(true);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setMinimumSize(new Dimension(410, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menuPanel = new JPanel(new BorderLayout());
        menuPanel.setPreferredSize(new Dimension(410, 400));
        add(menuPanel);

        createPayMenu();

    }

    public void createPayMenu(){
        //creates the credit and debit buttons
        pPayment = new JPanel(new GridLayout(1,2));
            paymentListener = new PaymentListener();
            btnCredit = new JButton("Credit");
                btnCredit.addActionListener(paymentListener);
                pPayment.add(btnCredit);
            btnDebit = new JButton("Debit");
                btnDebit.addActionListener(paymentListener);
                pPayment.add(btnDebit);
            add(pPayment);
    }

    public void pCredit(){
        //creates the credit menu once credit is clicked
        pPayment.removeAll();
        menuPanel.removeAll();
            JPanel pCreditConfrim = new JPanel(new BorderLayout());
                pCredit = new JPanel(new GridLayout(6,2));
                    JPanel p1 = new JPanel();
                    JPanel p2 = new JPanel();
                    JPanel p3 = new JPanel();
                    JPanel p4 = new JPanel();
                    JPanel p5 = new JPanel();
                    JPanel p6 = new JPanel();

                    JPanel p7 = new JPanel();
                    JPanel p8 = new JPanel();
                    JPanel p9 = new JPanel();
                    JPanel p10 = new JPanel();
                    JPanel p11 = new JPanel();
                    JPanel p12 = new JPanel();

                    lblFirstName = new JLabel("First Name:");
                        p7.add(lblFirstName);
                    lblLastName = new JLabel("Last Name:");
                        p8.add(lblLastName);
                    lblPhoneNumber = new JLabel("Phone Number:");
                        p9.add(lblPhoneNumber);
                    lblAddress = new JLabel("Address:");
                        p10.add(lblAddress);
                    lblCreditNumber = new JLabel("Credit Card Number:");
                        p11.add(lblCreditNumber);
                    lblSecurityCode = new JLabel("Security Code:");
                        p12.add(lblSecurityCode);

                    tfFirstName = new JTextField(10);
                        p1.add(tfFirstName);
                    tfLastName = new JTextField(10);
                        p2.add(tfLastName);
                    tfPhoneNumber = new JTextField(10);
                        p3.add(tfPhoneNumber);
                    tfAddress = new JTextField(10);
                        p4.add(tfAddress);
                    tfCreditNumber = new JTextField(10);
                        p5.add(tfCreditNumber);
                    tfSecurityCode = new JTextField(10);
                        p6.add(tfSecurityCode);

                    pCredit.add(p7);
                    pCredit.add(p1);
                    pCredit.add(p8);
                    pCredit.add(p2);
                    pCredit.add(p9);
                    pCredit.add(p3);
                    pCredit.add(p10);
                    pCredit.add(p4);
                    pCredit.add(p11);
                    pCredit.add(p5);
                    pCredit.add(p12);
                    pCredit.add(p6);

                JPanel pButton = new JPanel(new GridLayout(1,2));
                    btnConfirm1 = new JButton("Confirm");
                    pButton.add(btnConfirm1);
                    confirmListener = new ConfirmListener();
                    btnConfirm1.addActionListener(confirmListener);

                    btnCreditBack = new JButton("Debit");
                    pButton.add(btnCreditBack);
                    backListener = new BackListener();
                    btnCreditBack.addActionListener(backListener);

            pCreditConfrim.setBorder(BorderFactory.createTitledBorder("Information:"));
            pCreditConfrim.add(pCredit, BorderLayout.NORTH);
            pCreditConfrim.add(pButton, BorderLayout.SOUTH);

            taNotification = new JTextArea();
                taNotification.setEditable(false);
                taNotification.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Notifications:"), taNotification.getBorder()));


        menuPanel.add(pCreditConfrim, BorderLayout.NORTH);
        menuPanel.add(taNotification, BorderLayout.CENTER);

    }
    public void pDebit(){       
        //creates the debit menu once debit is clicked
        pPayment.removeAll();
        menuPanel.removeAll();
            JPanel pDebitConfrim = new JPanel(new BorderLayout());
                pDebit = new JPanel(new GridLayout(6,2));
                    JPanel p1 = new JPanel();
                    JPanel p2 = new JPanel();
                    JPanel p3 = new JPanel();
                    JPanel p4 = new JPanel();
                    JPanel p5 = new JPanel();
                    JPanel p6 = new JPanel();

                    JPanel p7 = new JPanel();
                    JPanel p8 = new JPanel();
                    JPanel p9 = new JPanel();
                    JPanel p10 = new JPanel();
                    JPanel p11 = new JPanel();
                    JPanel p12 = new JPanel();

                    lblFirstName = new JLabel("First Name:");
                        p7.add(lblFirstName);
                    lblLastName = new JLabel("Last Name:");
                        p8.add(lblLastName);
                    lblPhoneNumber = new JLabel("Phone Number:");
                        p9.add(lblPhoneNumber);
                    lblAddress = new JLabel("Address:");
                        p10.add(lblAddress);
                    lblDebitNumber = new JLabel("Debit Card Number:");
                        p11.add(lblDebitNumber);
                    lblVerificationCode = new JLabel("Verification Code:");
                        p12.add(lblVerificationCode);

                    tfFirstName = new JTextField(10);
                        p1.add(tfFirstName);
                    tfLastName = new JTextField(10);
                        p2.add(tfLastName);
                    tfPhoneNumber = new JTextField(10);
                        p3.add(tfPhoneNumber);
                    tfAddress = new JTextField(10);
                        p4.add(tfAddress);
                    tfDebitNumber = new JTextField(10);
                        p5.add(tfDebitNumber);
                    tfVerificationCode = new JTextField(10);
                        p6.add(tfVerificationCode);

                    pDebit.add(p7);
                    pDebit.add(p1);
                    pDebit.add(p8);
                    pDebit.add(p2);
                    pDebit.add(p9);
                    pDebit.add(p3);
                    pDebit.add(p10);
                    pDebit.add(p4);
                    pDebit.add(p11);
                    pDebit.add(p5);
                    pDebit.add(p12);
                    pDebit.add(p6);

                JPanel pButton = new JPanel(new GridLayout(1,2));
                    btnConfirm2 = new JButton("Confirm");
                    pButton.add(btnConfirm2);
                    confirmListener = new ConfirmListener();
                    btnConfirm2.addActionListener(confirmListener);

                    btnDebitBack = new JButton("Credit");
                    pButton.add(btnDebitBack);
                    backListener = new BackListener();
                    btnDebitBack.addActionListener(backListener);
           
            pDebitConfrim.setBorder(BorderFactory.createTitledBorder("Information:"));        
            pDebitConfrim.add(pDebit, BorderLayout.NORTH);
            pDebitConfrim.add(pButton, BorderLayout.SOUTH);

            taNotification = new JTextArea();
                taNotification.setEditable(false);
                taNotification.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Notifications:"), taNotification.getBorder()));


        menuPanel.add(pDebitConfrim, BorderLayout.NORTH);
        menuPanel.add(taNotification, BorderLayout.CENTER);

    }

    public void getInfoPayD(){
        // gets info from the debit menu
        firstNameGotten = tfFirstName.getText();
        lastNameGotten = tfLastName.getText();
        phoneNumberGotten = tfPhoneNumber.getText();
        addressGotten = tfAddress.getText();
        dcNumberGotten = tfDebitNumber.getText();
        verificationCodeGotten = tfVerificationCode.getText();

        if(lastNameGotten.isEmpty() || firstNameGotten.isEmpty() || dcNumberGotten.isEmpty() || phoneNumberGotten.isEmpty() || addressGotten.isEmpty() || verificationCodeGotten.isEmpty()){
            taNotification.setText("    Error missing information");
        }
        else{
            taNotification.setText("    Payment Successful");
        }
    }

    public void getInfoPayC(){
        // gets info from the credit menu
        firstNameGotten = tfFirstName.getText();
        lastNameGotten = tfLastName.getText();
        phoneNumberGotten = tfPhoneNumber.getText();
        addressGotten = tfAddress.getText();
        ccNumberGotten = tfCreditNumber.getText();
        securityCodeGotten = tfSecurityCode.getText();

        if(lastNameGotten.isEmpty() || firstNameGotten.isEmpty() || ccNumberGotten.isEmpty() || phoneNumberGotten.isEmpty() || addressGotten.isEmpty() || securityCodeGotten.isEmpty()){
            taNotification.setText("    Error missing information");
        }
        else{
            taNotification.setText("    Payment Successful");
        }
    }
}
