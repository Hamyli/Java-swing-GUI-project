import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class DisplayAllStudentFrame extends JFrame implements ActionListener
{
  JTextField firstName;
  JTextField lastName;
  JTextField studentNumber;
  JTextField grade;
  
  public DisplayAllStudentFrame()
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
    infoPane.setLayout(new GridLayout(1, 4));
    infoPane.add(new JLabel("First Name"));
   
    firstName.addActionListener(this);
    infoPane.add(new JLabel("Last Name"));

    lastName.addActionListener(this);
    infoPane.add(new JLabel("Grade"));

    grade.addActionListener(this);
    infoPane.add(new JLabel("Student Number"));

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
    
  }
}