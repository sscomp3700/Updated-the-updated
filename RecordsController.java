import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class RecordsController implements ActionListener {
    private RecordsView recordsView;
    private DataAdapter dataAdapter; // to save and load product
    private Order order = null;
    private JTable jTable;

    public RecordsController(RecordsView recordsView, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == recordsView.getToMain())
            Application.getInstance().getMainScreenMan().setVisible(true);

        else
        if (e.getSource() == recordsView.getLoadOrders())
            dataAdapter.loadAllOrders();
    }

    }

