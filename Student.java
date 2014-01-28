import java.io.*;
import java.util.*;

public class Student
{
  private String firstName;
  private String lastName;
  private String studentNumber;
  private String grade;
  public ArrayList <String> contests = new ArrayList<String>();
  public ArrayList <String> contestCost = new ArrayList<String>();
  
  public Student(String x, String y, String z, String c) throws IOException
  {

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
  
  public void signUpContest(String name, String price)
  {
    contests.add(name);
    contestCost.add(price);
  }
  
  public ArrayList<String> getContest()
  {
    return contests;
  }
}