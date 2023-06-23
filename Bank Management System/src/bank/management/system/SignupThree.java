package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;

    String formno;

    public SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);
        JLabel l1 =new JLabel("Page 3: Account Details");
        l1.setFont( new Font("Raleway", Font.BOLD,22));
        l1.setBounds(270,40,400,40);
        add(l1);

        JLabel type =new JLabel("Account Type:");
        type.setFont( new Font("Raleway", Font.BOLD,22));
        type.setBackground(Color.white);
        type.setBounds(100,120,200,40);
        add(type);

        r1= new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,170,250,20);
        add(r1);

        r2= new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(100,220,250,20);
        add(r2);

        r3= new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(340,220,250,20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(340,170,300,20);
        add(r4);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);


        JLabel cardNo =new JLabel("Card Number:");
        cardNo.setFont( new Font("Raleway", Font.BOLD,22));
        cardNo.setBounds(100,270,400,40);
        add(cardNo);

        JLabel dummyCardNo =new JLabel("XXXX_XXXX_XXXX_4142");
        dummyCardNo.setFont( new Font("Raleway", Font.BOLD,22));
        dummyCardNo.setBounds(290,270,400,40);
        add(dummyCardNo);

        JLabel cardDetails =new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont( new Font("Raleway", Font.BOLD,12));
        cardDetails.setBounds(100,305,300,20);
        add(cardDetails);


        JLabel pinNo =new JLabel("PIN No.:");
        pinNo.setFont( new Font("Raleway", Font.BOLD,22));
        pinNo.setBounds(100,370,400,40);
        add(pinNo);

        JLabel dummyPin =new JLabel("XXXX");
        dummyPin.setFont( new Font("Raleway", Font.BOLD,22));
        dummyPin.setBounds(290,370,400,40);
        add(dummyPin);

        JLabel pinDetails =new JLabel("Your 4 Digit PIN Number");
        pinDetails.setFont( new Font("Raleway", Font.BOLD,12));
        pinDetails.setBounds(100,405,300,20);
        add(pinDetails);

        JLabel  services =new JLabel("Services Required:");
        services.setFont( new Font("Raleway", Font.BOLD,22));
        services.setBounds(100,450,300,20);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont( new Font("Raleway", Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("ATM CARD");
        c2.setBackground(Color.white);
        c2.setFont( new Font("Raleway", Font.BOLD,16));
        c2.setBounds(100,500,200,30);
        add(c2);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont( new Font("Raleway", Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont( new Font("Raleway", Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS Alert");
        c4.setBackground(Color.white);
        c4.setFont( new Font("Raleway", Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont( new Font("Raleway", Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont( new Font("Raleway", Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7 = new JCheckBox("I Hereby declare that the above mention details are correct to the best of my knowledge.");
        c7.setBackground(Color.white);
        c7.setFont( new Font("Raleway", Font.BOLD,16));
        c7.setBounds(100,680,600,30);
        add(c7);

        cancel = new JButton("Cancel");
        cancel.setBounds(300,740,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setOpaque(true);
        cancel.setForeground(Color.white);
        cancel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        cancel.setVisible(true);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBounds(420,740,100,30);
        submit.setBackground(Color.BLACK);
        submit.setOpaque(true);
        submit.setForeground(Color.white);
        submit.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        submit.setVisible(true);
        submit.addActionListener(this);
        add(submit);


        getContentPane().setBackground(Color.WHITE);



        setSize(850, 850);
        setVisible(true);
        setLocation(450, 200);
        setUndecorated(true);
        setTitle("SIGN UP PAGE");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit)
        {
            String accountType = null;
            if(r1.isSelected()){
                accountType="Savings Account";
            } else if(r2.isSelected()){
                accountType="Fixed Deposit Account";
            } else if(r3.isSelected()){
                accountType="Current Account";
            } else if(r4.isSelected()){
                accountType="Recurring Deposit Account";
            }
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000l ) + 5404093600000000l);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000l ) + 1000l);
            String facility = "";
            if(c1.isSelected())
            {
                facility = facility + " ATM Card";
            }
            if(c2.isSelected())
            {
                facility += " Internet Banking";
            }
            if(c3.isSelected())
            {
                facility = facility + " Mobile Banking";
            }
            if(c4.isSelected())
            {
                facility = facility + " EMAIL & SMS Alerts";
            }
            if(c5.isSelected())
            {
                facility = facility + " Cheque Book";
            }
            if(c6.isSelected())
            {
                facility = facility + " E-Statement";
            }
            String declaration ="";
            if(c7.isSelected())
            {
                declaration = "Acknowledge";
            }

            try{
                if (accountType.equals("") || cardNumber.equals("") || pinNumber.equals("") || facility.equals("") || declaration.equals("")  )
                {
                    JOptionPane.showMessageDialog(null,"Please fill all the Required fields.");
                }
                else
                {
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"', '"+declaration+"')";
                    String query2 = "insert into logIn values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    setVisible(false);

                    JOptionPane.showMessageDialog(null,"Congratulation.! You have successfully created an account with following credentials. \nCard Number: "+ cardNumber +"\n Pin Number: " + pinNumber);
                    JOptionPane.showMessageDialog(null,"Please enter your First Deposit. \nPress OK to Continue.");
                    new Deposit(pinNumber,cardNumber).setVisible(true);
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == cancel)
        {
            setVisible(false);
            new Login().setVisible(true);

        }


    }
      public static void main(String []args)
        {
        new SignupThree("");
        }

}
