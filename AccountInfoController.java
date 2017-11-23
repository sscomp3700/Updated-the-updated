import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountInfoController implements ActionListener {
    private AccountInfoView accountInfoView;
    private DataAdapter dataAdapter; // to save and load product information

    public AccountInfoController(AccountInfoView accountInfoView, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.accountInfoView = accountInfoView;

        accountInfoView.getBtnLoadInfo().addActionListener(this);
        accountInfoView.getBtnChangePassword().addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accountInfoView.getBtnLoadInfo())
            loadUser();
    }

    private void loadUser() {
        int userID = 0;
        try {
            userID = Integer.parseInt(accountInfoView.getTxtUserID().getText());
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

        accountInfoView.getTxtUserName().setText(employee.getUserName());
        accountInfoView.getTxtUserType().setText(String.valueOf(employee.getUserType()));
        accountInfoView.getTxtUserPassword().setText(String.valueOf(employee.getUserPassword()));
    }


}