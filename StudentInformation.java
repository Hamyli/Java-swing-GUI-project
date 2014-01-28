import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class StudentInformation extends JPanel implements ActionListener
{
    public StudentInformation()
    {
        super(new BorderLayout());
        String [] studentName = new String[mainFrameExecute.studentList.size()];
        for(int j = 0; j<mainFrameExecute.studentList.size(); j++)
        {
          studentName[j] = mainFrameExecute.studentList.get(j).getfirstName() + " " + mainFrameExecute.studentList.get(j).getlastName();
        }
        
        add(new JLabel("Here are the List of Students"), BorderLayout.NORTH);
        //Create the combo box, select the item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        JComboBox studentList = new JComboBox(studentName);
        studentList.setSelectedIndex(0);
        studentList.addActionListener(this);
        studentList.setPreferredSize(new Dimension(100, 20));

        //Lay out the demo.
        add(studentList, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    /** Listens to the combo box. */
    public void actionPerformed(ActionEvent e) 
    {
      JComboBox jcmbType = (JComboBox) e.getSource();
      String cmbType = (String) jcmbType.getSelectedItem();
      System.out.println(cmbType);
      StudentInfoDisplay.update(cmbType);
    }
}