import java.io.*;
import java.util.*;

public class Contest
{
  private String contestName;
  private String contestCost;
  private String contestGrade;
  
  public Contest(String x, String y, String z)
  {
    contestName = x;
    contestCost = y;
    contestGrade = z;
  }
  
  public String getContestName()
  {
    return contestName;
  }
  
  public String getContestCost()
  {
    return contestCost;
  }
  
  public String getContestGrade()
  {
    return contestGrade;
  }
}