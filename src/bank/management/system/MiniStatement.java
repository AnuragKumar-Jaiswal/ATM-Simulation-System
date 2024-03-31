package bank.management.system;

import java.awt.Color;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame {

    String pinnumber;

    MiniStatement(String pinnumber) {
        setLayout(null);
        this.pinnumber = pinnumber;

        setTitle("Mini Statement");

        JLabel bank = new JLabel("National Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel mini = new JLabel();
        add(mini);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 500, 300, 20);
        add(balance);

        int bal = 0;

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(("select cardnumber from login where pinnumber = '" + pinnumber + "'"));

            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX"
                        + rs.getString("cardnumber").substring(12));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(("select * from bank where pin = '" + pinnumber + "'"));

            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("amount") + "<br><br> <html>");

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        mini.setBounds(20, 100, 400, 200);
        balance.setText("Your current account balance is Rs " + bal);

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
