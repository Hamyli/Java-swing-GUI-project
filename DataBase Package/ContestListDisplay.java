import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class ContestListDisplay extends JPanel implements ActionListener
{
  private String[] contestNames;
  private JComboBox contestList;
  public static String cmbType;
  
    public ContestListDisplay()
    {
        super(new BorderLayout());
        contestNames = new String[mainFrameExecute.contestList.size()];
        for(int j = 0; j<mainFrameExecute.contestList.size(); j++)
        {
          contestNames[j] = mainFrameExecute.contestList.get(j).getContestName();
        }
        
        add(new JLabel("Here are the List of Contests"), BorderLayout.NORTH);
        //Create the combo box, select the item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        contestList = new JComboBox(contestNames);
        contestList.setSelectedIndex(0);
        contestList.addActionListener(this);
        contestList.setPreferredSize(new Dimension(100, 20));
        
        //JPanel endPane = new JPanel();
        //JButton search = new JButton("Search");
        //search..addActionListener(this);

        //endPane.add(search);
        //searchField = new JTextField(16);
        //endPane.add(searchField);
        //add(endPane, BorderLayout.SOUTH);

        //Lay out the demo.
        add(contestList, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    /** Listens to the combo box. */
    public void actionPerformed(ActionEvent e) 
    {
      JComboBox jcmbType = (JComboBox) e.getSource();
      cmbType = (String) jcmbType.getSelectedItem();
      DisplayRegisteredContest.update(cmbType);
    }
}