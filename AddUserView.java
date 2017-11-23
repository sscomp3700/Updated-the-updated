import javax.swing.*;

public class AddUserView extends JFrame{
    private JTextField txtUserID  = new JTextField(10);
    private JTextField txtUserName  = new JTextField(30);
    private JTextField txtUserType  = new JTextField(10);
    private JTextField txtUserPassword  = new JTextField(10);

    private JButton btnLoadUser = new JButton("Load User");
    private JButton btnSaveUser = new JButton("Save User");

    public AddUserView() {
        this.setTitle("Add/Edit Users");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(500, 200);

        JPanel panelButton = new JPanel();
        panelButton.add(btnLoadUser);
        panelButton.add(btnSaveUser);
        this.getContentPane().add(panelButton);

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

    }

    public JButton getBtnLoadUser() {
        return btnLoadUser;
    }

    public JButton getBtnSaveUser() {
        return btnSaveUser;
    }

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