package App.src.Components;

import App.src.Utils.ComponentUI;
import App.src.Utils.UIUtils;

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