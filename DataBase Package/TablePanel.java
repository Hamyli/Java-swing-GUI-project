import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

public class TablePanel extends JPanel
{
  private Boolean DEBUG;
  public TablePanel() 
  {
    super(new GridLayout(1,0));

    JTable table = new JTable(new MyTableModel());
    table.setPreferredScrollableViewportSize(new Dimension(700, 250));
    table.setFillsViewportHeight(true);

    //Create the scroll pane and add the table to it.
    JScrollPane scrollPane = new JScrollPane(table);

    //Add the scroll pane to this panel.
    add(scrollPane);
  }


class MyTableModel extends AbstractTableModel 
{
   private String[] columnNames = {"First Name","Last Name","Student Number","Grade","Euclid"};
   private Object[][] data = 
   {
     {"Kathy", "Smith",
      "Snowboarding", new Integer(5), false},
     {"John", "Doe",
      "Rowing", new Integer(3), new Boolean(true)},
     {"Sue", "Black",
      "Knitting", new Integer(2), new Boolean(false)},
     {"Jane", "White",
      "Speed reading", new Integer(20), new Boolean(true)},
     {"Joe", "Brown",
      "Pool", new Integer(10), new Boolean(false)}
    };

   public int getColumnCount() 
   {
     return columnNames.length;
   }

   public int getRowCount() 
   {
     return data.length;
   }

   public String getColumnName(int col) 
   {
     return columnNames[col];
   }

   public Object getValueAt(int row, int col) 
   {
     return data[row][col];
   }

   public Class getColumnClass(int c) 
   {
     return getValueAt(0, c).getClass();
   }

   public boolean isCellEditable(int row, int col) 
   {
     if (col < 2) 
     {
       return false;
     } 
     else 
     {
       return true;
     }
   }

   public void setValueAt(Object value, int row, int col) 
   {
     if(DEBUG) 
     {
       System.out.println("Setting value at " + row + "," + col+ " to " + value+ " (an instance of "+ value.getClass() + ")");
     }
     data[row][col] = value;
     fireTableCellUpdated(row, col);

     if (DEBUG) 
     {
       System.out.println("New value of data:");
       printDebugData();
     }
   }

   private void printDebugData() 
   {
     int numRows = getRowCount();
     int numCols = getColumnCount();

     for (int i=0; i < numRows; i++) 
     {
       System.out.print("    row " + i + ":");
       for (int j=0; j < numCols; j++) 
       {
         System.out.print("  " + data[i][j]);
       }
       System.out.println();
     }
     System.out.println("--------------------------");
   }
}
    public static void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame("TableDemo");
        frame.addWindowListener
        (new WindowAdapter()
         {
           public void windowCLosing(WindowEvent e)
           {
             System.exit(0);
           }
         }
        );

        //Create and set up the content pane.
        TableDemo newContentPane = new TableDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}