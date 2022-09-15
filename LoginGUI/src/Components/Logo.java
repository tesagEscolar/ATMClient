package LoginGUI.src.Components;

import LoginGUI.src.Utils.ComponentUI;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class Logo extends JLabel implements ComponentUI{
  private boolean focusable = false;
  private String url;
  private int[] position,  dimensions;
  
  public Logo(boolean focusable, String url, int[] position, int[] dimensions){
    this.url = url;
    this.focusable = focusable;
    this.position = position;
    this.dimensions = dimensions;
    setDefaultConfiguration();
  }
    
    
  @Override
  public void setDefaultConfiguration(){
    this.setFocusable(focusable);
    this.setIcon(new ImageIcon(Objects.requireNonNull(getClass()
                                              .getClassLoader()
                                              .getResource(url))
                                              .getFile()));
  
    
    this.setBounds(position[0], position[1], dimensions[0], dimensions[1]);
  }

}