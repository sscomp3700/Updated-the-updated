import java.util.*;
import java.util.jar.JarEntry;

public class Order {
    private int number;
    private String customerName;
    private double totalCost;
    private Date date;

    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void addLine(OrderLine line) {
        lines.add(line);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}

