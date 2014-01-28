import java.io.*;
import java.util.*;

public class Student
{
  private String firstName;
  private String lastName;
  private String studentNumber;
  private String grade;
  private int totalCost;
  public ArrayList <String> contests = new ArrayList<String>();
  //public ArrayList <String> contestCost = new ArrayList<String>();
  public ArrayList <String> contestGrade = new ArrayList<String>();
  
  public Student(String x, String y, String z, String c, int a) throws IOException
  {
    totalCost = a;
    //System.out.println(totalCost);
    firstName = x;
    lastName = y;
    studentNumber = z;
    grade = c;
  }
  
  public String getfirstName()
  {
    return firstName;
  }
  
  public String getlastName()
  {
    return lastName;
  }
  
  public String getStudentNumber()
  {
    return studentNumber;
  }
  
  public String getGrade()
  {
    return grade;
  }
  
  public void signUpContest(String name)
  {
    contests.add(name);
  }
  
  public void addTotalCost(int x)
  {
    totalCost+=x;
  }
  
  public void subtractTotalCost(int x)
  {
    totalCost-=x;
  }
  
  public int getTotalCost()
  {
    return totalCost;
  }
}