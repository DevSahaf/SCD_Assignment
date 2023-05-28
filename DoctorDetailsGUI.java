/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doctordetailsgui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Admin
 */
public class DoctorDetailsGUI extends JFrame implements ActionListener{

    private JTextField idField, fullNameField, fatherNameField, emailField, contactField, addressField, qualificationField;
    private JComboBox<String> bloodGroupComboBox, genderComboBox;
    private JButton btnSave, btnUpdate, btnDelete, btnNew, btnGetData;

    private String[] bloodGroups = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
    private String[] genders = {"Male", "Female", "Other"};

    public DoctorDetailsGUI() {
        setTitle("Doctor Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Create main panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Doctor Information"));
        panel.setBackground(Color.lightGray);


        // Create GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add ID label and text field
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel IDLabel=new JLabel();
        panel.add(new JLabel("ID:"));
        gbc.gridx = 1;
        gbc.gridy = 0;
        idField = new JTextField(15);
        panel.add(idField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel NAMELabel=new JLabel();
        panel.add(new JLabel("Full Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        fullNameField = new JTextField(15);
        panel.add(fullNameField, gbc);

        // Add Father's Name label and text field
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Father's Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        fatherNameField = new JTextField(15);
        panel.add(fatherNameField, gbc);

        // Add Email label and text field
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        emailField = new JTextField(15);
        panel.add(emailField, gbc);

        // Add Contact label and text field
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Contact:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        contactField = new JTextField(15);
        panel.add(contactField, gbc);

        // Add Address label and text field
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Address:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        addressField = new JTextField(15);
        panel.add(addressField, gbc);

        // Add Qualification label and text field
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Qualification:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        qualificationField = new JTextField(15);
        panel.add(qualificationField, gbc);

        // Add Blood Group label and combo box
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Blood Group:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        bloodGroupComboBox = new JComboBox<>(bloodGroups);
        panel.add(bloodGroupComboBox, gbc);

        // Add Gender label and combo box
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Gender:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        genderComboBox = new JComboBox<>(genders);
        panel.add(genderComboBox, gbc);

        // Add buttons
        gbc.gridx = 0;
        gbc.gridy = 9;
        btnSave = new JButton("Save");
        btnSave.addActionListener(this);
        panel.add(btnSave, gbc);
        btnSave.setBackground(Color.YELLOW);
        btnSave.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSave.setForeground(Color.BLACK);
        btnSave.setOpaque(true);
        btnSave.setBorderPainted(true);



        gbc.gridx = 1;
        gbc.gridy = 9;
        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(this);
        panel.add(btnUpdate, gbc);
        btnUpdate.setBackground(Color.YELLOW);
        btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnUpdate.setForeground(Color.BLACK);
        btnUpdate.setOpaque(true);
        btnUpdate.setBorderPainted(true);


        gbc.gridx = 2;
        gbc.gridy = 9;
        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(this);
        panel.add(btnDelete, gbc);
        btnDelete.setBackground(Color.YELLOW);
        btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnDelete.setForeground(Color.BLACK);
        btnDelete.setOpaque(true);
        btnDelete.setBorderPainted(true);

        gbc.gridx = 3;
        gbc.gridy = 9;
        btnNew = new JButton("New");
        btnNew.addActionListener(this);
        panel.add(btnNew, gbc);
        btnNew.setBackground(Color.YELLOW);
        btnNew.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNew.setForeground(Color.BLACK);
        btnNew.setOpaque(true);
        btnNew.setBorderPainted(true);

        gbc.gridx = 4;
        gbc.gridy = 9;
        btnGetData = new JButton("Get Data");
        btnGetData.addActionListener(this);
        panel.add(btnGetData, gbc);
        btnGetData.setBackground(Color.YELLOW);
        btnGetData.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnGetData.setForeground(Color.BLACK);
        btnGetData.setOpaque(true);
        btnGetData.setBorderPainted(true);

        // Add panel to frame
        getContentPane().add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            // Save button action
            // Get values from text fields and combo boxes
            String id = idField.getText();
            String fullName = fullNameField.getText();
            String fatherName = fatherNameField.getText();
            String email = emailField.getText();
            String contact = contactField.getText();
            String address = addressField.getText();
            String qualification = qualificationField.getText();
            String bloodGroup = (String) bloodGroupComboBox.getSelectedItem();
            String gender = (String) genderComboBox.getSelectedItem();

            // Perform save operation with the values
            // ...

        } else if (e.getSource() == btnUpdate) {
            // Update button action
            // Get values from text fields and combo boxes
            String id = idField.getText();
            String fullName = fullNameField.getText();
            String fatherName = fatherNameField.getText();
            String email = emailField.getText();
            String contact = contactField.getText();
            String address = addressField.getText();
            String qualification = qualificationField.getText();
            String bloodGroup = (String) bloodGroupComboBox.getSelectedItem();
            String gender = (String) genderComboBox.getSelectedItem();

            // Perform update operation with the values
            // ...

        } else if (e.getSource() == btnDelete) {
            // Delete button action
            // Get value from ID text field
            String id = idField.getText();

            // Perform delete operation with the ID value
            // ...

        } else if (e.getSource() == btnNew) {
            // New button action
            // Clear all text fields and reset combo boxes
            idField.setText("");
            fullNameField.setText("");
            fatherNameField.setText("");
            emailField.setText("");
            contactField.setText("");
            addressField.setText("");
            qualificationField.setText("");
            bloodGroupComboBox.setSelectedIndex(0);
            genderComboBox.setSelectedIndex(0);

        } else if (e.getSource() == btnGetData) {
            // Get Data button action
            // Get value from ID text field
            String id = idField.getText();

        }
    }

    public static void main(String[] args) {
        new DoctorDetailsGUI();
    }
}
    

