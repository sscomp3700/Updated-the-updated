import javax.xml.transform.Result;
import java.sql.*;

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
                product.setID(resultSet.getInt(1));
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

    public void saveProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE ProductID = ?");
            statement.setInt(1, product.getID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE Product SET Name = ?, Price = ?, Quantity = ? WHERE ProductID = ?");
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setDouble(3, product.getQuantity());
                statement.setInt(4, product.getID());
            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Product VALUES (?, ?, ?, ?)");
                statement.setString(2, product.getName());
                statement.setDouble(3, product.getPrice());
                statement.setDouble(4, product.getQuantity());
                statement.setInt(1, product.getID());
            }
            statement.execute();

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
    }

    public Order loadOrder(int num) {
        try {
            String query = "SELECT * FROM Order WHERE OrderID = " + num;
            Order order = null;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                order = new Order();
                order.setNumber(resultSet.getInt(1));
                order.setCustomerName(resultSet.getString(2));
                order.setTotalCost(resultSet.getDouble(3));
                order.setDate(resultSet.getDate(4));
                resultSet.close();
                statement.close();

                query = "SELECT * FROM OrderLine WHERE OrderID = " + num;
                resultSet = statement.executeQuery(query);
            }
            while (resultSet.next()) {
                OrderLine line = new OrderLine();
                line.setOrderID(resultSet.getInt(1));
                line.setProductID(resultSet.getInt(2));
                line.setCost(resultSet.getDouble(3));
                order.addLine(line);
            }

            return order;

        }

        catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }

        return null;
    }
}
