package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, adharTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, income, category, education, occupation;
    String formno;
    SignupTwo(String formno){

        this.formno=formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails .setFont(new Font("Raleway",Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religionLabel = new JLabel("Religion:");
        religionLabel.setFont(new Font("Raleway",Font.BOLD,20));
        religionLabel.setBounds(100,150,100,30);
        add(religionLabel);

        String valReligion[]= {"Hindu", "Muslim","Sikh","Christian","Others"};
         religion = new JComboBox(valReligion);
        //religion.setFont(new Font("Raleway",Font.BOLD,14));
        religion.setBounds(300,150,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel categoryLabel = new JLabel("Category: ");
        categoryLabel.setFont(new Font("Raleway",Font.BOLD,20));
        categoryLabel.setBounds(100,200,200,30);
        add(categoryLabel);

        String valCategory[]= {"Open", "OBC","ST","SC","NT","Other"};
        category = new JComboBox(valCategory);
        //category.setFont(new Font("Raleway",Font.BOLD,14));
        category.setBounds(300,200,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel incomeLabel = new JLabel("Income: ");
        incomeLabel.setFont(new Font("Raleway",Font.BOLD,20));
        incomeLabel.setBounds(100,250,200,30);
        add(incomeLabel);

        String incomeCategory[]= {"Null", " < 1,50,000","< 2,50,000","< 5,00,000","Up-to 10,00,000"};
        income = new JComboBox(incomeCategory);
        //category.setFont(new Font("Raleway",Font.BOLD,14));
        income.setBounds(300,250,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel qualificationLabel = new JLabel("Qualification: ");
        qualificationLabel.setFont(new Font("Raleway",Font.BOLD,20));
        qualificationLabel.setBounds(100,300,200,30);
        add(qualificationLabel);

        String educationValue[]= {"Non-Graduation", "Graduation","Post Graduation","Doctorate","Other"};
        education = new JComboBox(educationValue);
        //category.setFont(new Font("Raleway",Font.BOLD,14));
        education.setBounds(300,300,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occupationLabel = new JLabel("Occupation: ");
        occupationLabel.setFont(new Font("Raleway",Font.BOLD,20));
        occupationLabel.setBounds(100,350,200,30);
        add(occupationLabel);


        String occupationalValue[]= {"Salaried", "Self-Employed","Business","Student","Other"};
        occupation = new JComboBox(occupationalValue);
        //category.setFont(new Font("Raleway",Font.BOLD,14));
        occupation.setBounds(300,350,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel panLabel = new JLabel("PAN No.: ");
        panLabel.setFont(new Font("Raleway",Font.BOLD,20));
        panLabel.setBounds(100,400,200,30);
        add(panLabel);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,400,400,30);
        add(panTextField);

        JLabel adharLabel = new JLabel("Adhar No.: ");
        adharLabel.setFont(new Font("Raleway",Font.BOLD,20));
        adharLabel.setBounds(100,450,200,30);
        add(adharLabel);

        adharTextField = new JTextField();
        adharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adharTextField.setBounds(300,450,400,30);
        add(adharTextField);

        JLabel seniorCitizenLabel = new JLabel("Senior Citizen: ");
        seniorCitizenLabel.setFont(new Font("Raleway",Font.BOLD,20));
        seniorCitizenLabel.setBounds(100,500,200,30);
        add(seniorCitizenLabel);

        syes =new JRadioButton("YES");
        syes.setBounds(300, 500, 120,30);
        add(syes);

        sno =new JRadioButton("NO");
        sno.setBounds(450,500,120,30);
        add(sno);

        ButtonGroup seniorCitizen = new ButtonGroup();
        seniorCitizen.add(syes);
        seniorCitizen.add(sno);

        JLabel existingAccountLabel = new JLabel("Existing Account: ");
        existingAccountLabel.setFont(new Font("Raleway",Font.BOLD,20));
        existingAccountLabel.setBounds(100,550,200,30);
        add(existingAccountLabel);

        eyes =new JRadioButton("YES");
        eyes.setBounds(300, 550, 120,30);
        add(eyes);

        eno =new JRadioButton("NO");
        eno.setBounds(450,550,120,30);
        add(eno);

        ButtonGroup existingAccount = new ButtonGroup();
        existingAccount.add(eyes);
        existingAccount.add(eno);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.setOpaque(true);
        next.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        next.setVisible(true);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        setTitle("SIGN UP PAGE");

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String sreligion  = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected())
        {
            seniorcitizen="YES";
        }
        else if(sno.isSelected())
        {
            seniorcitizen="NO";
        }

        String existingaccount = null;
        if(eyes.isSelected())
        {
            existingaccount="YES";
        }
        else if(eno.isSelected())
        {
            existingaccount="NO";
        }

        String sadhar = adharTextField.getText();
        String span = panTextField.getText();


        try{
            if (sreligion.equals("") || scategory.equals("") || sincome.equals("") || seducation.equals("") || soccupation.equals("") || seniorcitizen.equals("") || existingaccount.equals("") || span.equals("") || sadhar.equals("")  )
            {
                JOptionPane.showMessageDialog(null,"Please fill all the Required fields.");
            }else {
                Conn c = new Conn();
                String query = "insert into signuptwo value('"+formno+"', '"+sreligion+"','"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+sadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }

        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public static void main(String []args){
        new SignupTwo("");
    }



}
