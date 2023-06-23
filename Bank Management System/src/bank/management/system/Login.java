package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login() {
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No. :");
        cardno.setFont(new Font("Ralway",Font.BOLD,20));
        cardno.setBounds(120,150,250,40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Ralway",Font.BOLD,20));
        pin.setBounds(120,220,250,40);
        add(pin);

        pinTextField = new JPasswordField ();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setOpaque(true);
        login.setForeground(Color.white);
        login.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        login.setVisible(true);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setOpaque(true);
        clear.setForeground(Color.white);
        clear.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        clear.setVisible(true);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setOpaque(true);
        signup.setForeground(Color.white);
        signup.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        signup.setVisible(true);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);


        setSize(850, 480);
        setVisible(true);
        setLocation(350, 200);
        setTitle("ATM Machine");

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");

        } else if (e.getSource() == login) {

            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pinnumber = '"+pinNumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
               // System.out.println(rs.next());
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Congratulations! You have Successfully Log In. \nPress OK to Continue.");
                    setVisible(false);
                    new Transactions(pinNumber,cardNumber).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number OR PIN Number.");
                }
            }
            catch (Exception ae)
            {
                System.out.println(ae);
            }



        }else if (e.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);

        }
    }

    public static void main(String args[]) {
        new Login();
    }


}
