public class OrderLine {
    private int productID;
    private int orderID;
    private int quantity;
    private double cost;

    public void setOrderID (int orderID) {
        this.orderID = orderID;
    }

    public void setProductID (int productID) {
        this.productID = productID;
    }

    public void setCost (double cost) {
        this.cost = cost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }


}
