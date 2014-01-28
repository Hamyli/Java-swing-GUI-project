import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JLabel;
public class StudentInfoDisplay extends JPanel implements ActionListener
{
  private JPanel mainDisplay;
  public static JLabel nameInput;
  public static JLabel numberInput;
  public static JLabel contestInput;
  public static JLabel gradeInput;
  public static JLabel costInput;
  private JTextField userInput;
  private JTextField payField;
  private static int studentIndex;
  //private static String fullName;
  
  public static void update(String name)
  {
    for(int x = 0; x<mainFrameExecute.studentList.size(); x++)
    {
      String fullName = mainFrameExecute.studentList.get(x).getfirstName() + " " + mainFrameExecute.studentList.get(x).getlastName();
      System.out.println(fullName);
      if(name.equals(fullName))
      {
        studentIndex = x;
        nameInput.setText(fullName);
        numberInput.setText(mainFrameExecute.studentList.get(studentIndex).getStudentNumber());
        gradeInput.setText(mainFrameExecute.studentList.get(studentIndex).getGrade());
        String temp = "";
        for(int i = 0; i<mainFrameExecute.studentList.get(studentIndex).contests.size(); i++)
        {
          temp = temp + mainFrameExecute.studentList.get(studentIndex).contests.get(i) + " ";
        }
        contestInput.setText(temp);
        costInput.setText(mainFrameExecute.studentList.get(studentIndex).getTotalCost() + "");
        break;
      }
    }
  }
      
  public StudentInfoDisplay()
  {
    mainDisplay=new JPanel(new GridLayout(8,2,2,5));
    mainDisplay.setBorder(BorderFactory.createLineBorder(Color.black));

    
    
    //Dimension minimumSize=new Dimension(600,400);
    //mainDisplay.setMinimumSize(minimumSize);
    //mainDisplay.setPreferredSize(new Dimension(400, 200));
    
    
    JLabel general =new JLabel("Student Information Outline");
    JLabel studentName=new JLabel("Student Name:");
    JLabel studentNumber=new JLabel("Student Number:");
    JLabel numberOfContest=new JLabel("Contest Enrolled in:");
    JLabel grade=new JLabel("Grade:");
    JLabel layoutPurpose=new JLabel("");
    JLabel cost=new JLabel("Debit/Credit");
    costInput=new JLabel("");
    JLabel instruction = new JLabel("Please Enter the Name of the Contest you wish to enroll the student in: ");
    
    nameInput=new JLabel();
    numberInput=new JLabel();
    contestInput=new JLabel();
    gradeInput=new JLabel();
    
    JButton add = new JButton("Add");
    add.addActionListener(this);
    userInput=new JTextField();
    JButton pay = new JButton("Pay");
    pay.addActionListener(this);
    payField = new JTextField();
    
    general.setFont(new Font("arial",Font.BOLD,20));
    studentName.setFont(new Font("arial",Font.PLAIN,14));
    studentNumber.setFont(new Font("arial",Font.PLAIN,14));
    numberOfContest.setFont(new Font("arial",Font.PLAIN,14));
    grade.setFont(new Font("arial",Font.PLAIN,14));
    cost.setFont(new Font("arial",Font.PLAIN,14));
    instruction.setFont(new Font("arial", Font.PLAIN, 14));
    
    studentName.setForeground(Color.DARK_GRAY);
    studentNumber.setForeground(Color.DARK_GRAY);
    numberOfContest.setForeground(Color.DARK_GRAY);
    grade.setForeground(Color.DARK_GRAY);
    cost.setForeground(Color.DARK_GRAY);
    instruction.setForeground(Color.DARK_GRAY);
    
    mainDisplay.add("North",general);
    mainDisplay.add("North",layoutPurpose);
    mainDisplay.add("North", studentName);
    mainDisplay.add("North", nameInput);
    mainDisplay.add("NORTH", studentNumber);
    mainDisplay.add("NORTH", numberInput);
    mainDisplay.add("NORTH", numberOfContest);
    mainDisplay.add("NORTH", contestInput);
    mainDisplay.add("NORTH", grade);
    mainDisplay.add("NORTH", gradeInput);
    mainDisplay.add("NORTH",cost);
    mainDisplay.add("NORTH",costInput);
    //mainDisplay.add("NORTH",instruction);
    mainDisplay.add("NORTH",add);
    mainDisplay.add("NORTH",userInput);
    mainDisplay.add("NORTH",pay);
    mainDisplay.add("NORTH",payField);
    mainDisplay.setOpaque(true);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    if(e.getActionCommand().equals("Add"))
    {
      String addedContest = userInput.getText().trim();
      Boolean exists = false;
      for(int x= 0; x<mainFrameExecute.contestList.size(); x++)
      {
        if(mainFrameExecute.contestList.get(x).getContestName().equalsIgnoreCase(addedContest))
        {
          mainFrameExecute.studentList.get(studentIndex).signUpContest(addedContest);
          mainFrameExecute.studentList.get(studentIndex).addTotalCost(Integer.parseInt(mainFrameExecute.contestList.get(x).getContestCost()));
          exists = true;
        }
      }
      if(exists)
        update(StudentInformation.cmbType);
      else
        JOptionPane.showMessageDialog(this, "Contest not registered. Please register this contest!");
    }
    else if(e.getActionCommand().equals("Pay"))
    {
      if(payField.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this, "Please enter an integer amount.");
      }
      else
      {
        int paidAmount = Integer.parseInt(payField.getText().trim());
        mainFrameExecute.studentList.get(studentIndex).subtractTotalCost(paidAmount);
        update(StudentInformation.cmbType);
      }
    }
  }
  
  public JPanel getMainDisplay()
  {
    return mainDisplay;
  }
  /*public static void DisplayGUI()
  {
    JFrame frame=new JFrame("Student Information");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    StudentInfoDisplay studentInfoDisplay=new StudentInfoDisplay();
    frame.getContentPane().add(studentInfoDisplay.getMainDisplay());
    frame.pack();
    frame.setVisible(true);
    
  }*/
  /*public static void main (String args[])
  {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        DisplayGUI();
      }
    });
  }*/
  
  public void change(ListSelectionEvent e)
  {
  }
}