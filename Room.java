/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package room;
  import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Room extends JFrame {

    private JLabel lblRoomNo;
    private JLabel lblRoomType;
    private JLabel lblRoomCharges;
    private JTextField txtRoomNo;
    private JComboBox<String> cmbRoomType;
    private JTextField txtRoomCharges;
    private JButton btnNew;
    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnGetData;
    private JTable roomTable;
    private DefaultTableModel tableModel;

    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/room details?zeroDateTimeBehavior=convertToNull [root on Default schema]";
    private String username = "your_username";
    private String password = "your_password";

    public Room() {
        initComponents();
        connectToDatabase();
    }

    private void initComponents() {
        setTitle("Room Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Room Info"));
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setBackground(Color.lightGray);

        lblRoomNo = new JLabel("Room No.");
        lblRoomType = new JLabel("Room Type");
        lblRoomCharges = new JLabel("Room Charges");

        txtRoomNo = new JTextField(10);
        cmbRoomType = new JComboBox<>(new String[]{"General", "Deluxe"});
        txtRoomCharges = new JTextField(10);

        btnNew = new JButton("New");
        btnNew.setBackground(Color.YELLOW);
        btnNew.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNew.setForeground(Color.BLACK);
        btnNew.setOpaque(true);
        btnNew.setBorderPainted(true);

        btnSave = new JButton("Save");
        btnSave.setBackground(Color.YELLOW);
        btnSave.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSave.setForeground(Color.BLACK);
        btnSave.setOpaque(true);
        btnSave.setBorderPainted(true);

        btnUpdate = new JButton("Update");
        btnUpdate.setBackground(Color.YELLOW);
        btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnUpdate.setForeground(Color.BLACK);
        btnUpdate.setOpaque(true);
        btnUpdate.setBorderPainted(true);

        btnDelete = new JButton("Delete");
        btnDelete.setBackground(Color.YELLOW);
        btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnDelete.setForeground(Color.BLACK);
        btnDelete.setOpaque(true);
        btnDelete.setBorderPainted(true);

        btnGetData = new JButton("Get Data");
        btnGetData.setBackground(Color.YELLOW);
        btnGetData.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnGetData.setForeground(Color.BLACK);
        btnGetData.setOpaque(true);
        btnGetData.setBorderPainted(true);

        // Add action listeners for the buttons
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnGetData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnGetDataActionPerformed(evt);
            }
        });

        // Initialize the table model
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Room No.", "Room Type", "Room Charges", "Room Status"}
        );

        // Create the roomTable using the table model
        roomTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(roomTable);

        // Set up the GroupLayout for the panel
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblRoomNo)
                .addComponent(lblRoomType)
                .addComponent(lblRoomCharges)
                .addComponent(btnNew)
                .addComponent(scrollPane)
        );
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(txtRoomNo)
                .addComponent(cmbRoomType)
                .addComponent(txtRoomCharges)
                .addComponent(btnSave)
                .addComponent(btnUpdate)
                .addComponent(btnDelete)
                .addComponent(btnGetData)
        );
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblRoomNo)
                .addComponent(txtRoomNo)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblRoomType)
                .addComponent(cmbRoomType)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblRoomCharges)
                .addComponent(txtRoomCharges)
        );
        vGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnNew)
                .addComponent(btnSave)
        );
        vGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnUpdate)
                .addComponent(btnDelete)
        );
        vGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnGetData)
        );
        vGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(vGroup);

        GroupLayout groupLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(groupLayout);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btnNewActionPerformed(ActionEvent evt) {
        txtRoomNo.setText("");
        txtRoomCharges.setText("");
        cmbRoomType.setSelectedIndex(-1);
        txtRoomNo.requestFocus();
    }

    private void btnSaveActionPerformed(ActionEvent evt) {
        try {
            String query = "INSERT INTO room_info (room_no, room_type, room_charges) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, txtRoomNo.getText());
            statement.setString(2, (String) cmbRoomType.getSelectedItem());
            statement.setString(3, txtRoomCharges.getText());
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Room information saved successfully.");

            btnNewActionPerformed(evt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving room information.");
        }
    }

    private void btnUpdateActionPerformed(ActionEvent evt) {
        // Handle the update button action
    }

    private void btnDeleteActionPerformed(ActionEvent evt) {
        // Handle the delete button action
    }

    private void btnGetDataActionPerformed(ActionEvent evt) {
        try {
            String query = "SELECT * FROM room_info";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Clear the table model
            tableModel.setRowCount(0);

            while (resultSet.next()) {
                String roomNo = resultSet.getString("room_no");
                String roomType = resultSet.getString("room_type");
                String roomCharges = resultSet.getString("room_charges");
                String roomStatus = resultSet.getString("room_status");

                tableModel.addRow(new Object[]{roomNo, roomType, roomCharges, roomStatus});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving room information.");
        }
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to database.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Room().setVisible(true);
            }
        });
    }
}

    

