package logingui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LOGINGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LOGINGUI() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        passwordField = new JPasswordField(20);
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        JButton loginButton = new JButton("Login");
        Color Color;
        Color = null;
        loginButton.setBackground(Color.YELLOW);
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        loginButton.setForeground(Color.BLACK);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(true);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                }

            }
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(usernameLabel, constraints);

        constraints.gridx = 1;
        panel.add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        panel.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, constraints);

        add(panel);
        pack();
        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
             new LOGINGUI();
            }
        });
    }
}


