package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, fastCash, pinChange, signOut, cashWithdrawal,miniStatement, balanceEnquiry, exit;

    String pinNumber,cardNumber;


    public Transactions(String pinNumber, String cardNumber) throws HeadlessException {

        this.pinNumber=pinNumber;
        this.cardNumber=cardNumber;

        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction.");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(160,415,110,30);
        deposit.addActionListener(this);
        image.add(deposit);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(160,450,110,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        pinChange = new JButton("PIN Change");
        pinChange.setBounds(160,485,110,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        signOut = new JButton("Sign Out");
        signOut.setBounds(160,520,110,30);
        signOut.addActionListener(this);
        image.add(signOut);

        cashWithdrawal = new JButton("Cash Withdrawal");
        cashWithdrawal.setBounds(383,415,130,30);
        cashWithdrawal.addActionListener(this);
        image.add(cashWithdrawal);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(383,450,130,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(383,485,130,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(383,520,130,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,830);
        setLocation(450,100);
        setUndecorated(true);
        setTitle("Transactions");
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==exit)
        {
            System.exit(0);
        }else if (e.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNumber, cardNumber).setVisible(true);
        }else if (e.getSource() == cashWithdrawal) {
            setVisible(false);
            new Withdrawal(pinNumber, cardNumber).setVisible(true);
        }else if (e.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinNumber, cardNumber).setVisible(true);
        }else if (e.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinNumber, cardNumber).setVisible(true);
        }else if (e.getSource() == balanceEnquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinNumber,cardNumber).setVisible(true);
        }else if (e.getSource() == signOut)
        {
            setVisible(false);
            new Login().setVisible(true);
        }else if (e.getSource() == miniStatement)
        {
            new MiniStatement(pinNumber,cardNumber).setVisible(true);
        }

    }

    public static void main(String []args)
    {
        new Transactions("","");

    }


}
