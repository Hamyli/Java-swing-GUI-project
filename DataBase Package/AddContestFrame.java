import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class AddContestFrame extends JFrame implements ActionListener
{
  JTextField contestName;
  JTextField price;
  JTextField contestGrade;

  
  public AddContestFrame()
  {
    super("Add Contest");
    
    contestName = new JTextField(10);
    price = new JTextField(10);
    contestGrade = new JTextField(10);
    
    
    JPanel mainPane = (JPanel) getContentPane();
    mainPane.setLayout(new BorderLayout());
    JLabel label = new JLabel("Add Contest Interface");
    label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    mainPane.add(label, BorderLayout.NORTH);
    
    JPanel infoPane = new JPanel();
    infoPane.setLayout(new GridLayout(4, 2));
    infoPane.add(new JLabel("Contest Name: "));
    infoPane.add(contestName);
    contestName.addActionListener(this);
    infoPane.add(new JLabel("Price: "));
    infoPane.add(price);
    price.addActionListener(this);
    infoPane.add(new JLabel("Contest Grade: "));
    infoPane.add(contestGrade);
    contestGrade.addActionListener(this);
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
    try{
      Contest newOne = new Contest(contestName.getText().trim(), price.getText().trim(), contestGrade.getText().trim());
      mainFrameExecute.contestList.add(newOne);
    }catch(Exception f){}
  }
}
