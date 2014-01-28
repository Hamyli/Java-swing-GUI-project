import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class DeleteStudentFrame extends JFrame implements ActionListener
{
  JTextField studentNumber;

  
  public DeleteStudentFrame()
  {
    super("Delete Student");
    
    studentNumber = new JTextField(10);
    
    JPanel mainPane = (JPanel) getContentPane();
    mainPane.setLayout(new BorderLayout());
    JLabel label = new JLabel("Delete Student Interface");
    label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    mainPane.add(label, BorderLayout.NORTH);
    
    JPanel infoPane = new JPanel();
    infoPane.setLayout(new GridLayout(4, 2));

    infoPane.add(new JLabel("Student Number: "));
    infoPane.add(studentNumber);
    studentNumber.addActionListener(this);
    mainPane.add(infoPane, BorderLayout.CENTER);
    
    JPanel subPane = new JPanel();
    subPane.setLayout(new FlowLayout());
    JButton submit = new JButton("Submit Info");
    submit.addActionListener(this);
    subPane.add(submit);
    mainPane.add(subPane, BorderLayout.SOUTH);
    
    this.pack();
    this.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    if(e.getActionCommand().equals("Submit Info"))
    {
      String nameToBeDel = studentNumber.getText().trim();
      for(int x = 0; x<mainFrameExecute.studentList.size(); x++)
      {
        String studentNumber = mainFrameExecute.studentList.get(x).getStudentNumber();
        if(studentNumber.equals(nameToBeDel))
        {
          mainFrameExecute.studentList.remove(x);
        }
      }
    }
  }
}