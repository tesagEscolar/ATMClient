package App.src.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class TextFieldPassword extends JPasswordField implements FormElement{
  private String regCondition;
  private String warnContext;
  private Shape shape;
  private Color borderColor = UIUtils.COLOR_OUTLINE;
  private boolean ignoreWarn = false;

  public TextFieldPassword(String regCondition, String warnContext) {
    this.regCondition = regCondition;
    this.warnContext= warnContext;
    setOpaque(false);
    setBackground(UIUtils.COLOR_BACKGROUND);
    setForeground(Color.white);
    setCaretColor(Color.white);
    setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    setMargin(new Insets(2, 10, 2, 2));
    setHorizontalAlignment(SwingConstants.LEFT);
    setFont(UIUtils.FONT_GENERAL_UI);
  }

  public void setIgnore(boolean ignore){
    this.ignoreWarn = ignore;
  }
  public boolean getIgnore(){
    return this.ignoreWarn;
  }

  public void setRegCondition(String regCondition){
    this.regCondition = regCondition;
  }

    
  public boolean validateData(){
    return ((getPassword() != null) && (!getPassword().equals("")) && (String.valueOf(getPassword()).matches(this.regCondition)));
  }

  public String getError(){
    return this.warnContext;
  }
  

  protected void paintComponent(Graphics g) {
    Graphics2D g2 = UIUtils.get2dGraphics(g);
    g2.setColor(getBackground());
    g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);
    super.paintComponent(g2);
  }

  protected void paintBorder(Graphics g) {
    Graphics2D g2 = UIUtils.get2dGraphics(g);
    g2.setColor(borderColor);
    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);
  }

  public boolean contains(int x, int y) {
    if (shape == null || !shape.getBounds().equals(getBounds())) {
      shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);
    }
    return shape.contains(x, y);
  }

  public void setBorderColor(Color color) {
    borderColor = color;
    repaint();
  }
}