import javax.swing.*;
import java.awt.event.ActionListener;

public class PasswordChangeScreen extends JFrame{
    private JTextField txtUserPassword  = new JTextField(10);

    private JButton btnUpdatePassword = new JButton("Update Password");

    public PasswordChangeScreen() {
        this.setTitle("Change Password");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(500, 200);


        JPanel panelUserPassword = new JPanel();
        panelUserPassword.add(new JLabel("New User Password: "));
        panelUserPassword.add(txtUserPassword);
        txtUserPassword.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelUserPassword);

        JPanel panelButton = new JPanel();
        panelButton.add(btnUpdatePassword);
        this.getContentPane().add(panelButton);
    }

    public JButton getBtnUpdatePassword() { return btnUpdatePassword;    }
    public JTextField getTxtUserPassword() {
        return txtUserPassword;
    }
}