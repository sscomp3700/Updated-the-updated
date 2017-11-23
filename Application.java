import java.sql.*;

public class Application {

    private static Application instance;   // Singleton pattern

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }
    // Main components of this application

    private Connection connection;
   public Connection getConnection() {
        return connection;
    }

    private DataAdapter dataAdapter;

    // Create the Product View and Controller here!

    private ProductView productView = new ProductView();

    private OrderView orderView = new OrderView();

    private CheckoutScreen checkoutScreen = new CheckoutScreen();

    private MainScreenMan mainScreenMan = new MainScreenMan();

    private MainScreenCashier mainScreenCashier = new MainScreenCashier();

    private LoginScreen loginScreen = new LoginScreen();

    private AddUserView addUserView = new AddUserView();

    private AccountInfoView accountInfoView = new AccountInfoView();

    private PasswordChangeScreen passwordChangeScreen = new PasswordChangeScreen();

    private RecordsView recordsView = new RecordsView();

    public MainScreenMan getMainScreenMan() {
        return mainScreenMan;
    }

    public MainScreenCashier getMainScreenCashier() {
        return mainScreenCashier;
    }

    public ProductView getProductView() {
        return productView;
    }

    public OrderView getOrderView() { return orderView; }

    public CheckoutScreen getCheckoutScreen() {
        return checkoutScreen;
    }

    public LoginScreen getLoginScreen() { return loginScreen; }

    public AddUserView getAddUserView() { return addUserView; }

    public AccountInfoView getAccountInfoView() { return accountInfoView; }

    public PasswordChangeScreen getPasswordChangeScreen() { return passwordChangeScreen; }

    public RecordsView getRecordsView() { return recordsView; }

    private ProductController productController;

    public ProductController getProductController() {
        return productController;
    }

    private OrderController orderController;

    public OrderController getOrderController() { return orderController; }

    private CheckoutController checkoutController;

    public CheckoutController getCheckoutController() {
        return checkoutController;
    }

    private EmployeeController employeeController;

    public EmployeeController getEmployeeController() { return employeeController; }

    private AccountInfoController accountInfoController;

    public AccountInfoController getAccountInfoController() { return accountInfoController; }

    private LoginScreenController loginScreenController;

    public LoginScreenController getLoginScreenController() { return loginScreenController; }

    private PasswordChangeScreenController passwordChangeScreenController;

    public PasswordChangeScreenController getPasswordChangeScreenController() { return passwordChangeScreenController; }

    private RecordsController recordsController;

    public RecordsController getRecordsController() { return recordsController; }

    public DataAdapter getDataAdapter() {
        return dataAdapter;
    }

    private void initializeDatabase(Statement stmt) throws SQLException {
        // create the tables and insert sample data here!

        stmt.execute("create table Product (ProductID int PRIMARY KEY, ProductName char(30), Price double, Quantity double)");
        //    stmt.execute("create table Order (ProductID int PRIMARY KEY, ProductName char(30), Price double, Quantity double)");


    }

    private Application() {
        // create SQLite database connection here!
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:storedb.db");
            Statement stmt = connection.createStatement();
            if (!stmt.executeQuery("select * from product").next()) // product table do not exist
                initializeDatabase(stmt);


        }
        catch (ClassNotFoundException ex) {
            System.out.println("SQLite is not installed. System exits with error!");
            System.exit(1);
        }

        catch (SQLException ex) {
            System.out.println("SQLite database is not ready. System exits with error!" + ex.getMessage());

            System.exit(2);
        }

        // Create data adapter here!
        dataAdapter = new DataAdapter(connection);

        productController = new ProductController(productView, dataAdapter);

        checkoutController = new CheckoutController(checkoutScreen, dataAdapter);

        orderController = new OrderController(orderView);

        accountInfoController = new AccountInfoController(accountInfoView, dataAdapter);

        employeeController = new EmployeeController(addUserView, dataAdapter);

        loginScreenController = new LoginScreenController(loginScreen, dataAdapter);

        passwordChangeScreenController = new PasswordChangeScreenController(passwordChangeScreen, dataAdapter);

        recordsController = new RecordsController(recordsView, dataAdapter);
    }


    public static void main(String[] args) {
        Application.getInstance().getLoginScreen().setVisible(true);
    }
}
