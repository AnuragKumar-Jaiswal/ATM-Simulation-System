package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField newPin, rePin;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg  "));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel pinText = new JLabel("New Pin");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 320, 180, 25);
        image.add(pinText);

        newPin = new JPasswordField();
        newPin.setFont(new Font("Raleway", Font.BOLD, 25));
        newPin.setBounds(330, 320, 100, 25);
        image.add(newPin);

        JLabel rePinText = new JLabel("Re-Enter New Pin");
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.BOLD, 16));
        rePinText.setBounds(165, 360, 180, 25);
        image.add(rePinText);

        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 25));
        rePin.setBounds(330, 360, 100, 25);
        image.add(rePin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(350, 0);
        setVisible(true);

    }

    public static void main(String[] args) {
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            try {
                String nPin = newPin.getText();
                String rPin = rePin.getText();

                if (!nPin.equals(rPin)) {
                    JOptionPane.showMessageDialog(null, "Entered Pin does not match");
                    return;
                }
                if (nPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter new Pin");
                    return;
                }
                if (rPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-enter new Pin");
                    return;
                }

                Conn c = new Conn();
                String query1 = "update bank set pin = '" + rPin + "' where pin = '" + pinnumber + "'";
                String query2 = "update login set pinnumber = '" + rPin + "' where pinnumber = '" + pinnumber + "'";
                String query3 = "update signupthree set pinnumber = '" + rPin + "' where pinnumber = '" + pinnumber + "'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin changed successfully");
                setVisible(false);
                new Transactions(rPin).setVisible(true);

            } catch (Exception ae) {
                System.out.println(ae);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

    }
}
