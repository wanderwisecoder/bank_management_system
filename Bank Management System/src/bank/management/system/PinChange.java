package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JButton back, change, exit;
    JPasswordField pin, repin;
    String pinNumber,cardNumber;


    PinChange (String pinNumber, String cardNumber){
        this.pinNumber=pinNumber;
        this.cardNumber=cardNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pinText = new JLabel("Enter New PIN");
        pinText.setForeground(Color.white);
        pinText.setFont(new Font("System",Font.BOLD,14));
        pinText.setBounds(165,320,180,25);
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,14));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        JLabel repinText = new JLabel("Re-Enter New PIN");
        repinText.setForeground(Color.white);
        repinText.setFont(new Font("System",Font.BOLD,14));
        repinText.setBounds(165,360,200,25);
        image.add(repinText);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,14));
        repin.setBounds(330,360,180,25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        exit = new JButton("Exit");
        exit.setBounds(165,520,130,30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(450,100);
        setUndecorated(true);
        setTitle("Change Your PIN");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == change)
        {

            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter PIN.");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN.");
                    return;
                }
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                Conn c = new Conn();
                String query1= "UPDATE bank SET pin = '"+rpin+"' WHERE pin = '"+pinNumber+"'";
                String query2= "update signupthree set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";
                String query3= "update logIn set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Your PIN has been Successfully Updated.");

                setVisible(false);
                new Transactions(rpin,cardNumber).setVisible(true);


            } catch (Exception e1) {
                System.out.println(e1);
            }
        } else if (e.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinNumber,cardNumber).setVisible(true);
        } else  if(e.getSource()==exit)
        {
            System.exit(0);
        }


    }

    public static void main(String []args)
    {
        new PinChange("","").setVisible(true);
    }


}
