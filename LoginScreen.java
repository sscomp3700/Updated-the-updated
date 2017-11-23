import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {

    private JTextField txtUserID  = new JTextField(10);
    private JTextField txtUserPassword = new JTextField(10);

    private JButton btnLogin = new JButton("Login");

    public LoginScreen() {
        this.setTitle("Welcome to the Store Management System! Please login!");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(500, 200);

        JPanel panelUserID = new JPanel();
        panelUserID.add(new JLabel("Username: "));
        panelUserID.add(txtUserID);
        txtUserID.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelUserID);

        JPanel panelPassword = new JPanel();
        panelPassword.add(new JLabel("Password: "));
        panelPassword.add(txtUserPassword);
        txtUserPassword.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelPassword);

        JPanel panelButton = new JPanel();
        panelButton.add(btnLogin);
        this.getContentPane().add(panelButton);

    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JTextField getTxtUserID() {
        return txtUserID;
    }
    public JTextField getTxtUserPassword() { return txtUserPassword; }

}
