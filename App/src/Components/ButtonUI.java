package App.src.Components;

import App.src.Utils.UIUtils;
import App.src.Utils.ComponentUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonUI extends JLabel implements ComponentUI {
  private String message;
  private String operation;
  private int[] position, dimensions;
  final Color[] ButtonColors = { UIUtils.COLOR_INTERACTIVE, Color.white };

  public ButtonUI(String message, String operation, int[] position, int[] dimensions) {
    super(message);
    this.message = message;
    this.operation = operation;
    this.position = position;
    this.dimensions = dimensions;
    setDefaultConfiguration();
    setDefaultListeners();
  }


  public String getOperation(){
    return operation;
  }
  
  @Override
  public void setDefaultConfiguration() {
    this.setBackground(UIUtils.COLOR_BACKGROUND);
    this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    this.setBounds(position[0], position[1], dimensions[0], dimensions[1]);
  }

  public void setDefaultListeners() {
    this.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseEntered(MouseEvent e) {
        onMouseEnter();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        onMouseExited();
      }
    });

  };

  private void onMouseEnter() {
    ButtonColors[0] = UIUtils.COLOR_INTERACTIVE_DARKER;
    ButtonColors[1] = UIUtils.OFFWHITE;
    this.repaint();
  }

  private void onMouseExited() {
    ButtonColors[0] = UIUtils.COLOR_INTERACTIVE;
    ButtonColors[1] = Color.white;
    this.repaint();
  }
}