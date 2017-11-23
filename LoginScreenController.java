import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreenController implements ActionListener {
    private LoginScreen loginScreen;
    private DataAdapter dataAdapter; // to save and load product information

    public LoginScreenController(LoginScreen loginScreen, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.loginScreen = loginScreen;

        loginScreen.getBtnLogin().addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginScreen.getBtnLogin())
            login();
    }


    private void login() {
        int userID;
        String userPassword;
        try {
            userID = Integer.parseInt(loginScreen.getTxtUserID().getText());
            userPassword = loginScreen.getTxtUserPassword().getText();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid user ID! Please provide a valid user ID!");
            return;
        }

        Employee employee = dataAdapter.loadUser(userID);

        if (employee == null) {
            JOptionPane.showMessageDialog(null, "This user ID does not exist in the database!");
            return;
        }
        if(userPassword.equals(employee.getUserPassword())) {
            if(employee.getUserType().equals("Manager")) {
                Application.getInstance().getMainScreenMan().setVisible(true);
            }
            else if(employee.getUserType().equals("Cashier")) {
                Application.getInstance().getMainScreenCashier().setVisible(true);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid password!");
            return;
        }




    }


}
