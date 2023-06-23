package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pinNumber, cardNumber;
    JButton exit, back, withdrawal;



    public BalanceEnquiry( String cardNumber, String pinNumber) throws HeadlessException {

        this.pinNumber=pinNumber;
        this.cardNumber=cardNumber;


        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        exit = new JButton("Exit");
        exit.setBounds(165,520,130,30);
        exit.addActionListener(this);
        image.add(exit);

        Conn c = new Conn();
        int balanceAmount = 0;
        try {

            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Credit")) {
                    balanceAmount += Integer.parseInt(rs.getString("creditAmount"));
                } else if (rs.getString("type").equals("Debit")) {
                    balanceAmount -= Integer.parseInt(rs.getString("debitAmount"));
                }

            }
        } catch (Exception e){
            System.out.println(e);
        }



        JLabel text = new JLabel("Your current Account Balance is");
        text.setBounds(200,350,400,30);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        JLabel balance = new JLabel("Rs. "+ balanceAmount);
        balance.setBounds(270,420,400,30);
        balance.setForeground(Color.white);
        balance.setFont(new Font("System",Font.BOLD,22));
        image.add(balance);



        setSize(900,900);
        setLocation(450,100);
        setUndecorated(true);
        setTitle("Balance Enquiry");
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==exit)
        {
            System.exit(0);
        }  else if (e.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinNumber,cardNumber).setVisible(true);
        }

    }

    public static void main(String []args)
    {
        new BalanceEnquiry("","").setVisible(true);
    }
}
