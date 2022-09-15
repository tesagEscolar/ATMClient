package App.src.Components;

import App.src.Utils.ComponentUI;

import java.awt.*;
import javax.swing.*;

public class Separator extends JSeparator implements ComponentUI{
  private Color foreground;
  private int orientation;
  private int[] position,  dimensions;
  
  public Separator(Color foreground, int orientation, int[] position, int[] dimensions){
    this.foreground = foreground;
    this.orientation = orientation;
    this.position = position;
    this.dimensions = dimensions;
    setDefaultConfiguration();
  }
    
    
  @Override
  public void setDefaultConfiguration(){
    this.setForeground(foreground);
    this.setOrientation(orientation);
    this.setBounds(position[0], position[1],dimensions[0], dimensions[1]);
  }

}