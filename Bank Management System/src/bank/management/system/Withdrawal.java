package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JButton exit, back, withdrawal;
    JTextField amountTextField;
    String pinNumber,cardNumber;


    Withdrawal (String pinNumber, String cardNumber){
        this.pinNumber=pinNumber;
        this.cardNumber=cardNumber;

        setLayout(null);


        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the Amount to Withdraw.");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        text.setBounds(200,300,400,20);
        image.add(text);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway",Font.BOLD,22));
        amountTextField.setBounds(175,350,320,25);
        image.add(amountTextField);

        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(355,485,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        exit = new JButton("Exit");
        exit.setBounds(165,520,130,30);
        exit.addActionListener(this);
        image.add(exit);




        setSize(900,830);
        setLocation(450,100);
        setUndecorated(true);
        setTitle("Withdrawal");
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== exit )
        {
            System.exit(0);
        }
        else if (e.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinNumber,cardNumber).setVisible(true);
        }
        else if (e.getSource() == withdrawal)
        {
            System.out.println(amountTextField);
            String amount = amountTextField.getText();
            Date date = new Date();
            if(amount.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter the Amount.");
            }
            else
            {
                Conn c = new Conn();
                try
                {
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                    int balanceAmount = 0;

                    while(rs.next())
                    {
                        if(rs.getString("type").equals("Credit"))
                        {
                            balanceAmount += Integer.parseInt(rs.getString("creditAmount"));
                        }
                        else if (rs.getString("type").equals("Debit"))
                        {
                            balanceAmount -= Integer.parseInt(rs.getString("debitAmount"));
                        }

                    }
                    if( e.getSource() != exit && balanceAmount < Integer.parseInt( amount ))
                    {
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    balanceAmount -= Integer.parseInt(amount);
                    String balance_amount = ""+balanceAmount;
                    String query1 = "insert into bank values('" + pinNumber + "', '" + cardNumber +"','"+ date + "','Debit', '','"+amount+"','" + balance_amount + "')";
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Congratulation.! You have successfully withdrawal the amount Rs. " + amount + "/-, \n from Card Number: " + cardNumber);
                    JOptionPane.showMessageDialog(null, "Your Account Balance is Rs. " + balanceAmount );

                    setVisible(false);
                    new Transactions(pinNumber,cardNumber).setVisible(true);
                }
                catch (Exception ae)
                {
                    System.out.println(ae);
                }
            }

        }


    }

    public static void main (String []args)
    {
        new Withdrawal("","");

    }


}
