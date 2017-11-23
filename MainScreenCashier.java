import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenCashier extends JFrame {

    private JButton btnCheckout = new JButton("Checkout");
    private JButton btnAccountInfo   = new JButton("AccountInfo");

    public MainScreenCashier() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);

        btnAccountInfo.setPreferredSize(new Dimension(320, 100));
        btnAccountInfo.setFont(new Font("Consolas", Font.BOLD, 24));
        btnAccountInfo.setForeground(Color.WHITE);
        btnAccountInfo.setBackground(Color.BLUE);
        btnCheckout.setPreferredSize(new Dimension(320, 100));
        btnCheckout.setFont(new Font("Consolas", Font.BOLD, 24));
        btnCheckout.setForeground(Color.WHITE);
        btnCheckout.setBackground(Color.BLUE);


        JLabel title = new JLabel("Store Management System: Cashier");
        title.setFont(new Font("Consolas", Font.BOLD, 55));
        title.setForeground(Color.BLUE);
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel panelButton = new JPanel();
        panelButton.add(btnCheckout);
        panelButton.add(btnAccountInfo);

        this.getContentPane().add(panelButton);

        btnCheckout.addActionListener(new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getCheckoutScreen().setVisible(true);            }
        });


        btnAccountInfo.addActionListener(new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getAccountInfoView().setVisible(true);
            }
        });
    }


}
