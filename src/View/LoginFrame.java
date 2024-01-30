    package View;

    import javax.swing.*;

    import Controller.ControllerLogin;

    import java.awt.*;  
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;


    public class LoginFrame extends JFrame {
        private ControllerLogin controllerLogin;
        private JTextField fieldUsername;
        private JPasswordField fieldPassword;

        public LoginFrame() {
            this.controllerLogin =new ControllerLogin();

            setTitle("Form Login");
            setSize(600, 450);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            Component();
        }



        private void Component() {
            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            panel.setBackground(new Color(44, 62, 80));
        
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(10, 10, 10, 10);
        
            JLabel labelJudul = new JLabel("Form Login");
            labelJudul.setForeground(Color.WHITE);
            labelJudul.setFont(new Font("Arial", Font.BOLD, 24));
            panel.add(labelJudul, gbc);
        
            gbc.gridy++;
            JLabel labelUsername = new JLabel("Username:");
            labelUsername.setForeground(Color.WHITE); 
            panel.add(labelUsername, gbc);

            gbc.gridy++;
            fieldUsername = new JTextField(20);
            panel.add(fieldUsername, gbc);

            gbc.gridy++;
            JLabel labelPassword = new JLabel("Password:");
            labelPassword.setForeground(Color.WHITE); 
            panel.add(labelPassword, gbc);

            gbc.gridy++;
            fieldPassword = new JPasswordField(20);
            panel.add(fieldPassword, gbc);

            gbc.gridy++;
            JButton tombolLogin = new JButton("Login");
            tombolLogin.setBackground(new Color(34, 167, 240));
            tombolLogin.setForeground(Color.WHITE);
            tombolLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action();
                }
            });
            panel.add(tombolLogin, gbc);
        
            add(panel);
        }



        
        private void action() {
            String username = fieldUsername.getText();
            String password = new String(fieldPassword.getPassword());

            if (controllerLogin.cekLogin(username, password)) {
                JOptionPane.showMessageDialog(this, "Login berhasil!", "Login Berhasil", JOptionPane.INFORMATION_MESSAGE);

                SwingUtilities.invokeLater(() -> {
                    Menu layarUtama = new Menu(this);
                    layarUtama.setVisible(true);
                    dispose();
                });
            } else {
                JOptionPane.showMessageDialog(this, "Username atau password salah!", "Login Gagal", JOptionPane.ERROR_MESSAGE);
            }
        }



        
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    LoginFrame layarLogin = new LoginFrame();
                    layarLogin.setVisible(true);
                }
            });
        }
    }