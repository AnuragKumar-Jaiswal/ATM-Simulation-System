package bank.management.system;

import java.awt.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.event.*;
import java.sql.PreparedStatement;

public class SignUpTwo extends JFrame implements ActionListener {
    JTextField aadharTextField, panTextField;
    JButton next;
    JRadioButton sYes, sNo, eYes, eNo;
    JDateChooser dateChooser;
    @SuppressWarnings("rawtypes")
    JComboBox religion, category, occupation, education, income;

    String formNo;

    SignUpTwo(String formNo) {
        this.formNo = formNo;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionDetails = new JLabel("Page 2: Additional Details");
        additionDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionDetails.setBounds(290, 50, 400, 30);
        add(additionDetails);

        JLabel religionJLabel = new JLabel("Religion:");
        religionJLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionJLabel.setBounds(100, 100, 200, 30);
        add(religionJLabel);

        String valReligion[] = { "Hindu", "Muslim", "Sikh", "Christian", "Others" };
        religion = new JComboBox<>(valReligion);
        religion.setFont(new Font("Raleway", Font.BOLD, 14));
        religion.setBounds(300, 100, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel categoryJLabel = new JLabel("Category:");
        categoryJLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryJLabel.setBounds(100, 150, 200, 30);
        add(categoryJLabel);

        String valCategory[] = { "General", "SC", "ST", "OBC", "Others" };
        category = new JComboBox<>(valCategory);
        category.setFont(new Font("Raleway", Font.BOLD, 14));
        category.setBounds(300, 150, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel incomeJLabel = new JLabel("Income:");
        incomeJLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeJLabel.setBounds(100, 200, 200, 30);
        add(incomeJLabel);

        String valIncomer[] = { "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000" };
        income = new JComboBox<>(valIncomer);
        income.setFont(new Font("Raleway", Font.BOLD, 14));
        income.setBounds(300, 200, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel educationJLabel = new JLabel("Educational");
        educationJLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationJLabel.setBounds(100, 250, 200, 30);
        add(educationJLabel);

        JLabel qualificationJLabel = new JLabel("Qualification:");
        qualificationJLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        qualificationJLabel.setBounds(100, 275, 200, 30);
        add(qualificationJLabel);

        String valEducation[] = { "Non-Graduation", "Graduation", "Post-Graduation", "Doctrate", "Others" };
        education = new JComboBox<>(valEducation);
        education.setFont(new Font("Raleway", Font.BOLD, 14));
        education.setBounds(300, 275, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occupationJLabel = new JLabel("Occupation:");
        occupationJLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationJLabel.setBounds(100, 350, 200, 30);
        add(occupationJLabel);

        String valOccupation[] = { "Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others" };
        occupation = new JComboBox<>(valOccupation);
        occupation.setFont(new Font("Raleway", Font.BOLD, 14));
        occupation.setBounds(300, 350, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel panJLabel = new JLabel("PAN Number:");
        panJLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panJLabel.setBounds(100, 400, 200, 30);
        add(panJLabel);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 400, 400, 30);
        add(panTextField);

        JLabel aadharJLabel = new JLabel("Aadhar Number:");
        aadharJLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharJLabel.setBounds(100, 450, 200, 30);
        add(aadharJLabel);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 450, 400, 30);
        add(aadharTextField);

        JLabel seniorJLabel = new JLabel("Senior Citizen:");
        seniorJLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorJLabel.setBounds(100, 500, 200, 30);
        add(seniorJLabel);

        sYes = new JRadioButton("Yes");
        sYes.setBounds(300, 500, 100, 30);
        sYes.setBackground(Color.WHITE);
        add(sYes);

        sNo = new JRadioButton("No ");
        sNo.setBounds(420, 500, 100, 30);
        sNo.setBackground(Color.WHITE);
        add(sNo);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(sYes);
        seniorGroup.add(sNo);

        JLabel existingJLabel = new JLabel("Existion Account:");
        existingJLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        existingJLabel.setBounds(100, 550, 200, 30);
        add(existingJLabel);

        eYes = new JRadioButton("Yes");
        eYes.setBounds(300, 550, 100, 30);
        eYes.setBackground(Color.WHITE);
        add(eYes);

        eNo = new JRadioButton("No ");
        eNo.setBounds(420, 550, 100, 30);
        eNo.setBackground(Color.WHITE);
        add(eNo);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eYes);
        existingGroup.add(eNo);

        // pinTextField = new JTextField();
        // pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        // pinTextField.setBounds(300, 550, 400, 20);
        // add(pinTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 600, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 750);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // String formNo = "" + random;
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorCitizen = null;

        if (sYes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (sNo.isSelected()) {
            seniorCitizen = "No";
        }

        String existingAccount = null;

        if (eYes.isSelected()) {
            existingAccount = "Yes";
        } else if (eNo.isSelected()) {
            existingAccount = "No";
        }

        String sAadhar = (String) aadharTextField.getText();
        String sPan = (String) panTextField.getText();

        try {

            // if (sreligion.equals("")) {
            // JOptionPane.showMessageDialog(null, "Name is required");
            // } else {
            Conn c = new Conn();
            // String query = "insert into signup values{'" + formNo + "','" + name + "','"
            // + fName + "','" + dob
            // + "','" + gender + "','" + email + "','" + marital + "','" + address + "','"
            // + city + "','"
            // + pin + "','" + state + "')";
            // c.s.executeUpdate(query);

            String query = "insert into signuptwo (formNo,sreligion,scategory,sincome,seducation,soccupation,sAadhar,seniorCitizen,existingAccount,sPan) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.c.prepareStatement(query);
            ps.setString(1, formNo);
            ps.setString(2, sreligion);
            ps.setString(3, scategory);
            ps.setString(4, sincome);
            ps.setString(5, seducation);
            ps.setString(6, soccupation);
            ps.setString(7, sAadhar);
            ps.setString(8, seniorCitizen);
            ps.setString(9, existingAccount);
            ps.setString(10, sPan);

            ps.execute();
            ps.close();
            c.c.close();

            setVisible(false);
            new SignUpThree(formNo).setVisible(true);

            // }

        } catch (Exception ae) {
            System.out.println(ae);
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }

}
