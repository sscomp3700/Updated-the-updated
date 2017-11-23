import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class DataAdapter {
    private Connection connection;

    public DataAdapter(Connection connection) {
        this.connection = connection;
    }

    public Product loadProduct(int id) {
        try {
            String query = "SELECT * FROM Product WHERE ProductID = " + id;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(3));
                product.setQuantity(resultSet.getDouble(4));
                resultSet.close();
                statement.close();

                return product;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE ProductID = ?");
            statement.setInt(1, product.getProductID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE Product SET Name = ?, Price = ?, Quantity = ? WHERE ProductID = ?");
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setDouble(3, product.getQuantity());
                statement.setInt(4, product.getProductID());
            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Product VALUES (?, ?, ?, ?)");
                statement.setString(2, product.getName());
                statement.setDouble(3, product.getPrice());
                statement.setDouble(4, product.getQuantity());
                statement.setInt(1, product.getProductID());
            }
            statement.execute();
            resultSet.close();
            statement.close();
            return true;        // save successfully

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
        }
    }

    public Order loadOrder(int id) {
        try {
            Order order = null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Order WHERE OrderID = " + id);

            if (resultSet.next()) {
                order = new Order();
                order.setOrderID(resultSet.getInt("OrderID"));
                order.setCustomerName(resultSet.getString("Customer"));
                order.setTotalCost(resultSet.getDouble("TotalCost"));
                order.setDate(resultSet.getDate("OrderDate"));
                resultSet.close();
                statement.close();
            }

            // loading the order lines for this order
            resultSet = statement.executeQuery("SELECT * FROM OrderLine WHERE OrderID = " + id);

            while (resultSet.next()) {
                OrderLine line = new OrderLine();
                line.setOrderID(resultSet.getInt(1));
                line.setProductID(resultSet.getInt(2));
                line.setQuantity(resultSet.getDouble(3));
                line.setCost(resultSet.getDouble(4));
                order.addLine(line);
            }

            return order;

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return null;
        }
    }

    public Order loadAllOrders() {

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Order");

            if (resultSet.next()) {
                Order order = new Order();
                order.setOrderID(resultSet.getInt("OrderID"));
                order.setCustomerName(resultSet.getString("Customer"));
                order.setTotalCost(resultSet.getDouble("TotalCost"));
                order.setDate(resultSet.getDate("OrderDate"));
                resultSet.close();
                statement.close();
            }
            DefaultTableModel jModel = new DefaultTableModel(new String[]{"OrderID", "Customer", "TotalCost", "OrderDate"}, 0);
            while (resultSet.next()) {
                String st1 = resultSet.getString("OrderID");
                String st2 = resultSet.getString("Customer");
                String st3 = resultSet.getString("TotalCost");
                String st4 = resultSet.getString("OrderDate");
                jModel.addRow(new Object[]{st1, st2, st3, st4});
            }
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean saveOrder(Order order) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Order VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, order.getOrderID());
            statement.setDate(2, order.getDate());
            statement.setString(3, order.getCustomerName());
            statement.setDouble(4, order.getTotalCost());
            statement.setDouble(5, order.getTotalTax());

            statement.execute();    // commit to the database;
            statement.close();

            statement = connection.prepareStatement("INSERT INTO OrderLine VALUES (?, ?, ?, ?)");
            for (OrderLine line: order.getLines()) { // store for each order line!
                statement.setInt(1, line.getOrderID());
                statement.setInt(2, line.getProductID());
                statement.setDouble(3, line.getQuantity());
                statement.setDouble(4, line.getCost());

                statement.execute();    // commit to the database;
            }
            statement.close();
            return true; // save successfully!
        }
        catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;
        }
    }
    public Employee loadUser(int id) {
        try {
            String query = "SELECT * FROM Employee WHERE UserID = " + id;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Employee employee = new Employee();
                employee.setUserID(resultSet.getInt(1));
                employee.setUserName(resultSet.getString(2));
                employee.setUserType(resultSet.getString(3));
                employee.setUserPassword(resultSet.getString(4));
                resultSet.close();
                statement.close();
                return employee;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveUser(Employee employee) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Employee WHERE UserID = ?");
            statement.setInt(1, employee.getUserID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE Employee SET UserName = ?, UserType = ?, UserPassword = ? WHERE UserID = ?");
                statement.setString(1, employee.getUserName());
                statement.setString(2, employee.getUserType());
                statement.setString(3, employee.getUserPassword());
                statement.setInt(4, employee.getUserID());
            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Employee VALUES (?, ?, ?, ?)");
                statement.setString(2, employee.getUserName());
                statement.setString(3, employee.getUserType());
                statement.setString(4, employee.getUserPassword());
                statement.setInt(1, employee.getUserID());
            }
            statement.execute();
            resultSet.close();
            statement.close();
            return true;        // save successfully

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
        }
    }
    public boolean updateUser(Employee employee) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Employee WHERE UserID = ?");
            statement.setInt(1, employee.getUserID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE Employee SET UserPassword = ? WHERE UserID = ?");
                statement.setString(3, employee.getUserPassword());
            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Employee VALUES (?, ?, ?, ?)");
                statement.setString(2, employee.getUserName());
                statement.setString(3, employee.getUserType());
                statement.setString(4, employee.getUserPassword());
                statement.setInt(1, employee.getUserID());
            }
            statement.execute();
            resultSet.close();
            statement.close();
            return true;        // save successfully

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
        }
    }

}
