package LoginGUI.src.Components;

import LoginGUI.src.Utils.ComponentUI;
import LoginGUI.src.Utils.UIUtils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelUI extends JLabel implements ComponentUI{
  private int[] position;
  private String message;
  
  public LabelUI(String message, int[] position){
    super(message);
    this.message = message;
    this.position = position;
    setDefaultConfiguration();
  }
    
    
  @Override
  public void setDefaultConfiguration(){
    this.setForeground(UIUtils.COLOR_OUTLINE);
    this.setFont(UIUtils.FONT_GENERAL_UI);
    this.setBounds(position[0], position[1], this.getPreferredSize().width, this.getPreferredSize().height);
  }

 
}