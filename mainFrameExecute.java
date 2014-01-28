import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class mainFrameExecute
{
  public static ArrayList<Student> studentList = new ArrayList<Student>();
  
  public static void getData() throws IOException
  {
    File studentFile = new File("studentData.txt");
    if(!studentFile.exists())
    {
      studentFile.createNewFile();
    }
    Scanner in = new Scanner(studentFile);
    int maxIndex = -1;
    String text[] = new String[1000];
    while(in.hasNext())
    {
      maxIndex++;
      text[maxIndex] = in.nextLine();
    }
    in.close();
    
    for(int j = 0; j<= maxIndex; j++)
    {
      Scanner sc = new Scanner(text[j]);
      String firstName = sc.next();
      System.out.println(firstName);
      String lastName = sc.next();
      String studentNumber = sc.next();
      String grade = sc.next();
      Student newStudent = new Student(firstName, lastName, studentNumber, grade);
      if(sc.hasNext())
      {
        while(sc.hasNext())
        {
          newStudent.signUpContest(sc.next(), sc.next());
        }
      }
      mainFrameExecute.studentList.add(newStudent);
    }
  }
  
  public static void saveData() throws IOException
  {
    System.out.println(mainFrameExecute.studentList.get(0).getfirstName());
    File oldFile = new File("studentData.txt");
    File upDateFile = new File("temp.txt");
    PrintWriter output = new PrintWriter(upDateFile);
    for(int j = 0; j<studentList.size(); j++)
    {
      Student tempObject = studentList.get(j);
      output.print(tempObject.getfirstName() + " ");
      output.print(tempObject.getlastName() + " ");
      output.print(tempObject.getStudentNumber() + " ");
      output.print(tempObject.getGrade() + " ");
      for(int x = 0; x<tempObject.contests.size(); x++)
      {
        output.print(tempObject.contests.get(x) + " ");
        output.print(tempObject.contestCost.get(x) + " ");
      }
      output.println("");
    }
    output.close();
    oldFile.delete();
    upDateFile.renameTo(new File("studentData.txt"));
  }
  public static void main(String[]args) throws IOException
  {
    getData();
    mainFrame frame = new mainFrame();
    frame.addWindowListener
      (new WindowAdapter()
       {
         public void windowCLosing(WindowEvent e)
         {
           System.exit(0);
         }
       }
      );
  }
}

class mainFrame extends JFrame implements ActionListener
{
  public mainFrame()
  {
    super("Main Menu");
    JPanel headerPane = (JPanel) getContentPane();
    headerPane.setLayout(new FlowLayout());
    JLabel label = new JLabel("Main Menu Interface");
    label.setFont(new Font("Times new Roman", Font.PLAIN, 18));
    headerPane.add(label);
    
    JPanel bodyPane = new JPanel();
    bodyPane.setLayout(new GridLayout(3, 3));
    JButton button1 = new JButton("Add Student");
    button1.addActionListener(this);
    bodyPane.add(button1);
    JButton button3 = new JButton("Delete Student");
    button3.addActionListener(this);
    bodyPane.add(button3);
    JButton button4 = new JButton("Add Contest");
    button4.addActionListener(this);
    bodyPane.add(button4);
    JButton button5 = new JButton("Delete Contest");
    button5.addActionListener(this);
    bodyPane.add(button5);
    JButton button6 = new JButton("Change Student Info");
    button6.addActionListener(this);
    bodyPane.add(button6);
    JButton button7 = new JButton("change Contest Info");
    button7.addActionListener(this);
    bodyPane.add(button7);
    JButton button8 = new JButton("Display All Students");
    button8.addActionListener(this);
    bodyPane.add(button8);
    JButton button9 = new JButton("Display balance");
    button9.addActionListener(this);
    bodyPane.add(button9);
    JButton button10 = new JButton("Display Registered Contest");
    button10.addActionListener(this);
    bodyPane.add(button10);
    headerPane.add(bodyPane);
    
    JPanel endPane = new JPanel();
    endPane.setLayout(new FlowLayout());
    JButton button11 = new JButton("Reset All Data");
    button11.addActionListener(this);
    endPane.add(button11);
    JButton button12 = new JButton("Save All Data");
    button12.addActionListener(this);
    endPane.add(button12);
    headerPane.add(endPane);
    
    this.pack();
    this.setSize(600, 200);
    this.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    if(e.getActionCommand().equals("Add Student"))
    {
      AddStudentFrame frameAS = new AddStudentFrame();
      frameAS.addWindowListener
      (new WindowAdapter()
       {
         public void windowCLosing(WindowEvent e)
         {
           System.exit(0);
         }
       }
      );
    }
    else if(e.getActionCommand().equals("Delete Student"))
    {
      DeleteStudentFrame frameDS = new DeleteStudentFrame();
      frameDS.addWindowListener
      (new WindowAdapter()
       {
         public void windowCLosing(WindowEvent e)
         {
           System.exit(0);
         }
       }
      );
    }
    else if(e.getActionCommand().equals("Display All Students"))
    {
      JFrame frame = new JFrame("Frame");
      frame.setLayout(new GridLayout(1,1));
      StudentInformation pane2 = new StudentInformation();
      frame.add(pane2);
      StudentInfoDisplay studentInfoDisplay = new StudentInfoDisplay();
      frame.getContentPane().add(studentInfoDisplay.getMainDisplay());
      
      frame.pack();
      frame.setSize(750, 300);
      frame.setVisible(true);
      
    }
    else if(e.getActionCommand().equals("Save All Data"))
    {
      try{
        mainFrameExecute.saveData();
        System.out.println("Data should be saved");
      }catch (IOException g){
        System.out.println("file did not get created");
      }
    }
  }
}