import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;

public class TableFrame extends JFrame
{
  public TableFrame()
  {
    super("DataBase Table");
    
    TablePanel pane = new TablePanel();
    pane.setOpaque(true);
    this.setContentPane(pane);
    
    this.pack();
    this.setVisible(true);
  }
}