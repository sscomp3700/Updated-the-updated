import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class EmployeeController implements ActionListener {
        private AddUserView addUserView;
        private DataAdapter dataAdapter; // to save and load product information

        public EmployeeController(AddUserView addUserView, DataAdapter dataAdapter) {
            this.dataAdapter = dataAdapter;
            this.addUserView = addUserView;

            addUserView.getBtnLoadUser().addActionListener(this);
            addUserView.getBtnSaveUser().addActionListener(this);
        }


        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addUserView.getBtnLoadUser())
                loadUser();
            else
            if (e.getSource() == addUserView.getBtnSaveUser())
                saveUser();
        }

        private void saveUser() {
            int userID;
            try {
                userID = Integer.parseInt(addUserView.getTxtUserID().getText());
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid user ID! Please provide a valid user ID!");
                return;
            }

            String userName = addUserView.getTxtUserName().getText().trim();
            if (userName.length() == 0) {
                JOptionPane.showMessageDialog(null, "Invalid user name! Please provide a non-empty user name!");
                return;
            }
            String userType = addUserView.getTxtUserType().getText().trim();
            String userPassword = addUserView.getTxtUserPassword().getText().trim();
            if (userPassword.length() == 0) {
                JOptionPane.showMessageDialog(null, "Invalid user password! Please provide a non-empty user password!");
                return;
            }



            // Done all validations! Make an object for this product!

            Employee employee = new Employee();
            employee.setUserID(userID);
            employee.setUserName(userName);
            employee.setUserType(userType);
            employee.setUserPassword(userPassword);

            // Store the product to the database

            dataAdapter.saveUser(employee);
        }

        private void loadUser() {
            int userID = 0;
            try {
                userID = Integer.parseInt(addUserView.getTxtUserID().getText());
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

            addUserView.getTxtUserName().setText(employee.getUserName());
            addUserView.getTxtUserType().setText(String.valueOf(employee.getUserType()));
            addUserView.getTxtUserPassword().setText(String.valueOf(employee.getUserPassword()));
        }

    }

