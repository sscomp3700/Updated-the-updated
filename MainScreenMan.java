import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenMan extends JFrame {

    private JButton btnManage   = new JButton("Manage Product");
    private JButton btnAccountInfo   = new JButton("Account Info");
    private JButton btnUserManage   = new JButton("Manage Users");
    private JButton btnRecords   = new JButton("Business Records");


    public MainScreenMan() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);

        btnManage.setPreferredSize(new Dimension(320, 100));
        btnManage.setFont(new Font("Consolas", Font.BOLD, 24));
        btnManage.setForeground(Color.WHITE);
        btnManage.setBackground(Color.BLUE);
        btnAccountInfo.setPreferredSize(new Dimension(320, 100));
        btnAccountInfo.setFont(new Font("Consolas", Font.BOLD, 24));
        btnAccountInfo.setForeground(Color.WHITE);
        btnAccountInfo.setBackground(Color.BLUE);
        btnUserManage.setPreferredSize(new Dimension(320, 100));
        btnUserManage.setFont(new Font("Consolas", Font.BOLD, 24));
        btnUserManage.setForeground(Color.WHITE);
        btnUserManage.setBackground(Color.BLUE);
        btnRecords.setPreferredSize(new Dimension(320, 100));
        btnRecords.setFont(new Font("Consolas", Font.BOLD, 24));
        btnRecords.setForeground(Color.WHITE);
        btnRecords.setBackground(Color.BLUE);


        JLabel title = new JLabel("Store Management System: Manager");
        title.setFont(new Font("Consolas", Font.BOLD, 55));
        title.setForeground(Color.BLUE);
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel panelButton = new JPanel();
        panelButton.add(btnManage);
        panelButton.add(btnAccountInfo);
        panelButton.add(btnUserManage);
        panelButton.add(btnRecords);

        this.getContentPane().add(panelButton);

        btnManage.addActionListener(new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getProductView().setVisible(true);
            }
        });

        btnAccountInfo.addActionListener(new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getAccountInfoView().setVisible(true);
            }
        });
        btnUserManage.addActionListener(new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getAddUserView().setVisible(true);
            }
        });

        btnRecords.addActionListener(new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getRecordsView().setVisible(true);
            }
        });
    }


}

