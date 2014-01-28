import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class DisplayRegisteredContest extends JPanel implements ActionListener
{
  private static JTextArea students;
  //private static String[] names;
  
  public DisplayRegisteredContest()
  {
    super();
    students = new JTextArea();
    this.add(students);
  }
  
  public static void update(String contest)
  { 
    students.setText("");
    for(int x = 0; x<mainFrameExecute.studentList.size(); x++)
    {
      for(int y = 0; y<mainFrameExecute.studentList.get(x).contests.size(); y++)
      {
        if(mainFrameExecute.studentList.get(x).contests.get(y).equalsIgnoreCase(contest))
        {
          students.append(mainFrameExecute.studentList.get(x).getfirstName() + " " + mainFrameExecute.studentList.get(x).getlastName() + "\n");
          System.out.println("b");
          break;
        }
      }
    }
  }
  
  public void actionPerformed(ActionEvent e)
  {
  }
}