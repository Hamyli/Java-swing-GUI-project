import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class AddStudentFrame extends JFrame implements ActionListener
{
  JTextField firstName;
  JTextField lastName;
  JTextField studentNumber;
  JTextField grade;
  
  public AddStudentFrame()
  {
    super("Add Student");
    
    firstName = new JTextField(10);
    lastName = new JTextField(10);
    studentNumber = new JTextField(10);
    grade = new JTextField(10);
    
    JPanel mainPane = (JPanel) getContentPane();
    mainPane.setLayout(new BorderLayout());
    JLabel label = new JLabel("Add Student Interface");
    label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    mainPane.add(label, BorderLayout.NORTH);
    
    JPanel infoPane = new JPanel();
    infoPane.setLayout(new GridLayout(4, 2));
    infoPane.add(new JLabel("First Name: "));
    infoPane.add(firstName);
    firstName.addActionListener(this);
    infoPane.add(new JLabel("Last Name: "));
    infoPane.add(lastName);
    lastName.addActionListener(this);
    infoPane.add(new JLabel("Grade: "));
    infoPane.add(grade);
    grade.addActionListener(this);
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
      try{
        Student newOne = new Student(firstName.getText().trim(), lastName.getText().trim(), grade.getText().trim(), studentNumber.getText().trim());
        mainFrameExecute.studentList.add(newOne);
        System.out.println("added new student");
        System.out.println("added student is " + mainFrameExecute.studentList.get(0).getfirstName());
      }catch(Exception f){}
      firstName.setText("");
      lastName.setText("");
      grade.setText("");
      studentNumber.setText("");
    }
  }
}