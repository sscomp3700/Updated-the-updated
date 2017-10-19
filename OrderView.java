import javax.swing.*;

public class OrderView extends JFrame {

    private JTextField txtProductID  = new JTextField(10);
    private JTextField txtProductName  = new JTextField(30);
    private JTextField txtProductPrice  = new JTextField(10);
    private JTextField txtProductQuantity  = new JTextField(10);

    private JButton btnLoad = new JButton("Load Product");
    private JButton btnSave = new JButton("Save Product");

    public OrderView() {
        this.setTitle("Product View");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(500, 200);

        JPanel panelButton = new JPanel();
        panelButton.add(btnLoad);
        panelButton.add(btnSave);
        this.getContentPane().add(panelButton);

    }

    public JButton getBtnLoad() {
        return btnLoad;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JTextField getTxtProductID() {
        return txtProductID;
    }

    public JTextField getTxtProductName() {
        return txtProductName;
    }

    public JTextField getTxtProductPrice() {
        return txtProductPrice;
    }

    public JTextField getTxtProductQuantity() {
        return txtProductQuantity;
    }
}


