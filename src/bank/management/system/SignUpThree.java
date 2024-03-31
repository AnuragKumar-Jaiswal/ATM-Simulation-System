package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.*;

public class SignUpThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;

    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formNo;

    SignUpThree(String formNo) {
        this.formNo = formNo;

        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 16));
        type.setBounds(100, 180, 250, 20);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 210, 250, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(100, 240, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(350, 210, 250, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 240, 250, 20);
        add(r4);
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 16));
        card.setBounds(100, 280, 200, 20);
        add(card);

        JLabel carddetail = new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 10));
        carddetail.setBounds(100, 300, 200, 20);
        add(carddetail);

        JLabel cardnumber = new JLabel("XXXX-XXXX-XXXX-1440");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 16));
        cardnumber.setBounds(330, 280, 250, 20);
        add(cardnumber);

        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(100, 330, 200, 20);
        add(pin);

        JLabel pindetail = new JLabel("Your 4 Digit Pin");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 10));
        pindetail.setBounds(100, 350, 200, 20);
        add(pindetail);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 16));
        pinnumber.setBounds(330, 330, 250, 20);
        add(pinnumber);

        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 16));
        services.setBounds(100, 380, 200, 20);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 410, 200, 20);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(330, 410, 200, 20);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 440, 200, 20);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(330, 440, 200, 20);
        add(c4);

        c5 = new JCheckBox("Check Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 470, 200, 20);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(330, 440, 200, 20);
        add(c6);

        c7 = new JCheckBox(
                "I hereby declare that all the above details entered are correct to the best of my knowledge!");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setBounds(100, 500, 900, 20);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBounds(250, 550, 150, 25);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 16));
        cancel.setBounds(420, 550, 150, 25);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(1000, 750);
        setLocation(50, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fix Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000l) + 5040936000000000l);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000l) + 1000l);

            String facility = "";

            if (c1.isSelected()) {
                facility = facility + " ATM Card";
            }
            if (c2.isSelected()) {
                facility = facility + " Internet Banking";
            }
            if (c3.isSelected()) {
                facility = facility + " Mobile Banking";
            }
            if (c4.isSelected()) {
                facility = facility + " Email & SMS Alerts";
            }
            if (c5.isSelected()) {
                facility = facility + " Cheque Book";
            }
            if (c6.isSelected()) {
                facility = facility + " E-Statement ";
            }

            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }
                if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Plese select the consent box");
                } else {
                    Conn c = new Conn();
                    String query = "insert into signupthree (formNo,accountType,cardnumber,pinnumber,facility) values (?,?,?,?,?)";
                    String query2 = "insert into login (formNo,cardnumber,pinnumber) values (?,?,?)";
                    PreparedStatement ps = c.c.prepareStatement(query);
                    ps.setString(1, formNo);
                    ps.setString(2, accountType);
                    ps.setString(3, cardnumber);
                    ps.setString(4, pinnumber);
                    ps.setString(5, facility);
                    ps = c.c.prepareStatement(query2);
                    ps.setString(1, formNo);
                    ps.setString(2, cardnumber);
                    ps.setString(3, pinnumber);
                    ps.execute();

                    // ps1.execute();
                    ps.close();
                    // ps1.close();
                    c.c.close();

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\nPin: " + pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }

            } catch (Exception ae) {
                System.out.println(ae);
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }

}
