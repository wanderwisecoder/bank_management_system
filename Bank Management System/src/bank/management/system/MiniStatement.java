package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    JButton exit;



    public MiniStatement(String pinNumber, String cardNumber) throws HeadlessException {

        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setBounds(20,400,300,20);
        add(balanceLabel);

        Conn c = new Conn();
        int balance =0;
        try{

            ResultSet rs = c.s.executeQuery("select * from login where pinNumber = '" +pinNumber+"'");
            while (rs.next())
            {
                card.setText("Card Number: " + rs.getString("cardNumber").substring(0,4)+ " - XXXX - XXXX - " + rs.getString("cardNumber").substring(12));
            }

        }
        catch (Exception e1)
        {
            System.out.println(e1);
        }
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while (rs.next())
            {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("creditAmount") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("debitAmount") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("balanceAmount")+"<br><br><html>");

                if (rs.getString("type").equals("Credit")) {
                    balance += Integer.parseInt(rs.getString("creditAmount"));
                } else if (rs.getString("type").equals("Debit")) {
                    balance -= Integer.parseInt(rs.getString("debitAmount"));
                }
            }
            balanceLabel.setText("Your current Account Balance is Rs. " +balance );
            ;

        } catch (Exception e2)
        {
            System.out.println(e2);
        }

        exit = new JButton("Exit");
        exit.setBounds(20, 500, 100, 25);
        exit.addActionListener(this);
        add(exit);




        setSize(400,600);
        setLocation(100,100);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

    }

    public static void main(String []args)
    {
        new MiniStatement("","");
    }
}
