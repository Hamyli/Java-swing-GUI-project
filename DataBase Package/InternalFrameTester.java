import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class InternalFrameTester
{
  public static void main(String[]args)
  {
    JFrame frame = new JFrame("Frame");
    frame.setLayout(new GridLayout(1,1));
    JPanel pane = new JPanel();
    frame.add(pane);
    JPanel pane2 = new JPanel();
    MyInternalFrame littleFrame = new MyInternalFrame();
    try {
      littleFrame.setSelected(true);
    } catch (java.beans.PropertyVetoException e) {}

    littleFrame.setVisible(true);
    pane2.add(littleFrame);
    frame.add(pane2);
    
    frame.pack();
    frame.setSize(500, 500);
    frame.setVisible(true);
    
  }
}

