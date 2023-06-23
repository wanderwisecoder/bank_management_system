package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {

    JButton rs100, rs500, rs1000, rs2000, rs5000,rs10000, back, exit;

    String pinNumber,cardNumber;


    public FastCash(String pinNumber, String cardNumber) throws HeadlessException {

        this.pinNumber=pinNumber;
        this.cardNumber=cardNumber;

        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select withdrawal amount.");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        rs100 = new JButton("Rs. 100");
        rs100.setBounds(160,415,110,30);
        rs100.addActionListener(this);
        image.add(rs100);

        rs500 = new JButton("Rs. 500");
        rs500.setBounds(160,450,110,30);
        rs500.addActionListener(this);
        image.add(rs500);

       rs1000 = new JButton("Rs. 1000");
       rs1000.setBounds(160,485,110,30);
        rs1000.addActionListener(this);
        image.add(rs1000);

        exit = new JButton("Exit");
        exit.setBounds(160,520,110,30);
        exit.addActionListener(this);
        image.add(exit);

        rs5000 = new JButton("Rs. 5000");
        rs5000.setBounds(383,415,130,30);
        rs5000.addActionListener(this);
        image.add(rs5000);

        rs10000 = new JButton("Rs. 10000");
        rs10000.setBounds(383,450,130,30);
        rs10000.addActionListener(this);
        image.add(rs10000);

        rs2000 = new JButton("Rs. 2000");
        rs2000.setBounds(383,485,130,30);
        rs2000.addActionListener(this);
        image.add(rs2000);

        back = new JButton("Back");
        back.setBounds(383,520,130,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,830);
        setLocation(450,100);
        setUndecorated(true);
        setTitle("Fast Cash");
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==exit)
        {
            System.exit(0);
        }
        else if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber, cardNumber).setVisible(true);
        }
        else{
            String debitAmount  = ((JButton)e.getSource()).getText().substring(4);
            Conn c = new Conn();
            try{

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
            if( e.getSource() != exit && balanceAmount < Integer.parseInt( debitAmount ))
            {
                JOptionPane.showMessageDialog(null,"Insufficient Balance");
                return;
            }
                balanceAmount -= Integer.parseInt(debitAmount);
                String balance_amount = ""+balanceAmount;

            Date date = new Date();
            String query1 = "insert into bank values('" + pinNumber + "', '" + cardNumber +"','"+ date + "','Debit', '','"+debitAmount+"','" + balance_amount + "')";
            c.s.executeUpdate(query1);
            JOptionPane.showMessageDialog(null,"Rs. "+debitAmount+" Debited Successfully.");
                setVisible(false);
                new Transactions(pinNumber,cardNumber).setVisible(true);
       }


       catch (Exception e1)
       {
           System.out.println(e1);
       }
        }
        /*else if (e.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNumber, cardNumber).setVisible(true);
        }else if (e.getSource() == cashWithdrawal) {
            setVisible(false);
            new Withdrawal(pinNumber, cardNumber).setVisible(true);
        }*/

    }

    public static void main(String []args)
    {
        new FastCash("","");

    }


}
