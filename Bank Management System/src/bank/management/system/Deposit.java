package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JButton exit, back, deposit;
    JTextField amountTextField;
    String pinNumber,cardNumber;


    Deposit(String pinNumber, String cardNumber){
        this.pinNumber=pinNumber;
        this.cardNumber=cardNumber;

        setLayout(null);


        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the Amount for deposit.");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        text.setBounds(200,300,400,20);
        image.add(text);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway",Font.BOLD,22));
        amountTextField.setBounds(175,350,320,25);
        image.add(amountTextField);

        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

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
        setTitle("Deposit");
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
        else if (e.getSource() == deposit)
        {

            String creditAmount = amountTextField.getText();
            Date date = new Date();
            String balanceAmount ="";
             if(creditAmount.equals(""))
              {
                JOptionPane.showMessageDialog(null,"Please enter the Amount.");
               }
               else
                {


                    /*  Conn c = new Conn();
                    try{
                        ResultSet rs =c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                        int balance =0;
                        while(rs.next())
                        {
                            if(rs.getString("balanceAmount").equals())

                        }

                    }*/



                    try
                       {
                         Conn c = new Conn();
                         String query1 = "insert into bank values('" + pinNumber + "', '" + cardNumber +"','"+ date + "','Credit', '" + creditAmount + "', '','" + balanceAmount + "')";
                         c.s.executeUpdate(query1);
                         JOptionPane.showMessageDialog(null, "Congratulation.! You have successfully deposited the amount Rs. " + creditAmount + "/-, \n in Card Number: " + cardNumber);
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
        new Deposit("","");

    }


}
