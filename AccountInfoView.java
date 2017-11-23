import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountInfoView extends JFrame {
    private JTextField txtUserID = new JTextField(10);
    private JTextField txtUserName = new JTextField(30);
    private JTextField txtUserType = new JTextField(10);
    private JTextField txtUserPassword = new JTextField(10);

    private JButton btnLoadInfo = new JButton("Load Info");
    private JButton btnChangePassword = new JButton("Change Password");

    public AccountInfoView() {
        this.setTitle("Account Info");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(500, 200);

        JPanel panelUserID = new JPanel();
        panelUserID.add(new JLabel("User ID: "));
        panelUserID.add(txtUserID);
        txtUserID.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelUserID);

        JPanel panelUserName = new JPanel();
        panelUserName.add(new JLabel("User Name: "));
        panelUserName.add(txtUserName);
        this.getContentPane().add(panelUserName);

        JPanel panelUserInfo = new JPanel();
        panelUserInfo.add(new JLabel("User Type: "));
        panelUserInfo.add(txtUserType);
        txtUserType.setHorizontalAlignment(JTextField.RIGHT);

        panelUserInfo.add(new JLabel("Password: "));
        panelUserInfo.add(txtUserPassword);
        txtUserPassword.setHorizontalAlignment(JTextField.RIGHT);

        this.getContentPane().add(panelUserInfo);

        JPanel panelButton = new JPanel();
        panelButton.add(btnChangePassword);
        panelButton.add(btnLoadInfo);
        this.getContentPane().add(panelButton);

        btnChangePassword.addActionListener(new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getPasswordChangeScreen().setVisible(true);            }
        });

    }

    public JButton getBtnChangePassword() {
        return btnChangePassword;
    }

    public JButton getBtnLoadInfo() { return btnLoadInfo; }

    public JTextField getTxtUserID() {
        return txtUserID;
    }

    public JTextField getTxtUserName() {
        return txtUserName;
    }

    public JTextField getTxtUserType() {
        return txtUserType;
    }

    public JTextField getTxtUserPassword() {
        return txtUserPassword;
    }
}