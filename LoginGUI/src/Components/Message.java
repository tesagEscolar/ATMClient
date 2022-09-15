package LoginGUI.src.Components;

import LoginGUI.src.Utils.ComponentUI;
import LoginGUI.src.Utils.UIUtils;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Message extends JTextArea implements ComponentUI{
  private boolean editable = false;
  private Font font = UIUtils.FONT_RESULT_UI;
  private int[] position,  dimensions;
  private String message;
  
  public Message(String message,boolean editable, Font font, int[] position, int[] dimensions){
    super(message);
    this.message = message;
    this.font = font;
    this.editable = editable;
    this.position = position;
    this.dimensions = dimensions;
    setDefaultConfiguration();
  }
    
    
  @Override
  public void setDefaultConfiguration(){
    this.setEditable(editable);
    this.setLineWrap(true);
    this.setWrapStyleWord(true);
    this.setCursor(null);
    this.setOpaque(false);
    this.setFocusable(false);
    this.setForeground(Color.white);
    this.setFont(font);
    this.setBounds(position[0], position[1], dimensions[0], dimensions[1]);
  }

}