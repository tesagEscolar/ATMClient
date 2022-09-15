package App.src.Components;

import java.awt.*;
import java.awt.event.*;
import App.src.Utils.UIUtils;
import App.src.Utils.ComponentUI;
import App.src.Utils.FormElement;

public class TextFieldUsername extends TextFieldUI implements ComponentUI , FormElement{
  private String placeholder;
  private String regCondition;
  private String warnContext;
  private Color foreground = UIUtils.COLOR_INTERACTIVE;
  private Color borderColor = UIUtils.COLOR_INTERACTIVE;
  private int[] position, dimensions;

//  public TextFieldUsername() {
   // super();
 // }
public TextFieldUsername(int[] position, String placeholder, Color foreground, Color border, boolean defListener) {
    super();
    this.foreground = foreground;
    this.placeholder = placeholder;
    this.position = position;
    setDefaultConfiguration();
    if (defListener) {
      setDefaultListeners();
    }
  }

public TextFieldUsername(int[] position, String placeholder, Color foreground, Color border, boolean defListener, String regCondition,String wcontext) {
    super();
    this.regCondition = regCondition; 
    this.warnContext = wcontext; 
    this.foreground = foreground;
    this.placeholder = placeholder;
    this.position = position;
    setDefaultConfiguration();
    if (defListener) {
      setDefaultListeners();
    }
  }

  @Override
  public void setDefaultConfiguration() {
    this.setBounds(position[0], position[1], 250, 44);
    this.setText(placeholder);
    this.setForeground(foreground);
    this.setBorderColor(borderColor);
  }
   public boolean getIgnore(){
    return false;
  }
  
  public boolean validateData(){
    return ((getText() != null) && (!getText().equals("")) && (getText().matches(this.regCondition)));
  }

  public String getError(){
    return this.warnContext;
  }
  
  public void setDefaultListeners() {
    this.addFocusListener(new FocusListener() {

      @Override
      public void focusGained(FocusEvent e) {
        onFocusGained();
      }

      @Override
      public void focusLost(FocusEvent e) {
        onFocusLost();
      }

    });
  };

  private void onFocusGained() {
    if (getText().equals(placeholder)) {
      this.setText("");
    }
    this.setForeground(Color.white);
    this.setBorderColor(UIUtils.COLOR_INTERACTIVE);
  }

  private void onFocusLost() {
    if (this.getText().isEmpty()) {
      this.setText(placeholder);
    }
    this.setForeground(UIUtils.COLOR_OUTLINE);
    this.setBorderColor(UIUtils.COLOR_OUTLINE);
  }

}