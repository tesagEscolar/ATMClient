package LoginGUI.src.Utils;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import LoginGUI.src.Components.*;

public class ComponentDispenser {

  public static Component createSeparator(int posX, int posY) {
    int[] position = { posX, posY };
    int[] dimensions = { 1, 240 };
    return new Separator(UIUtils.COLOR_OUTLINE, SwingConstants.VERTICAL, position, dimensions);
  }

  public static Component createLogo() {
    int[] position = { 55, 100};
    int[] dimensions = { 200, 200 };
    return new Logo(false, "LoginGUI/resources/diamond_dogs_ch.png", position, dimensions);
  }


  public static Component createUsernameTextField(int posX, int posY, String mess, String regCondition,String warnContext) {
    int position[] = { posX, posY };
    return new TextFieldUsername(position, mess, UIUtils.COLOR_OUTLINE, UIUtils.COLOR_OUTLINE, true,regCondition,warnContext);
  }

  public static Component createPasswordTextField(int posX, int posY, boolean editable, String regCondition,
      String warnContext) {
    TextFieldPassword passwordField = new TextFieldPassword(regCondition, warnContext);
    passwordField.setForeground(UIUtils.COLOR_OUTLINE);
    passwordField.setEditable(editable);
    passwordField.setBorderColor(UIUtils.COLOR_OUTLINE);
    passwordField.setBounds(posX, posY, 250, 44);
    passwordField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        passwordField.setForeground(Color.white);
        passwordField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
      }

      @Override
      public void focusLost(FocusEvent e) {
        passwordField.setForeground(UIUtils.COLOR_OUTLINE);
        passwordField.setBorderColor(UIUtils.COLOR_OUTLINE);
      }
    });

    passwordField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER)
          System.out.println("enter");
      }
    });
    return passwordField;
  }

  public static Component createMessage(int posX, int posY, int w, int h, Font font, String message) {
    int[] position = { posX, posY };
    int[] dimensions = { w, h };
    return new Message(message, false, font, position, dimensions);
  }

  public static Component createOperationButton(String mess, String operation, int posX, int posY) {
    int[] position = { posX, posY };
    int[] dimensions = { 250, 44 };
    return new ButtonUI(mess, operation, position, dimensions) {
      @Override
      protected void paintComponent(Graphics g) {
        Graphics2D g2 = UIUtils.get2dGraphics(g);
        super.paintComponent(g2);

        Insets insets = getInsets();
        int w = getWidth() - insets.left - insets.right;
        int h = getHeight() - insets.top - insets.bottom;
        g2.setColor(UIUtils.COLOR_INTERACTIVE);
        g2.fillRoundRect(insets.left, insets.top, w, h, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);

        FontMetrics metrics = g2.getFontMetrics(UIUtils.FONT_GENERAL_UI);
        int x2 = (getWidth() - metrics.stringWidth(mess)) / 2;
        int y2 = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g2.setFont(UIUtils.FONT_GENERAL_UI);
        g2.setColor(Color.white);
        g2.drawString(mess, x2, y2);
      }
    };
  }

  public static Component createHyperLinkText(String message, int posX, int posY, Runnable func) {
    return new HyperlinkText(message, posX, posY, func);
  }

  public static Component createWelcomeMessage() {
    JLabel label = new JLabel(UIUtils.WELCOME_TEXT);
    label.setBounds(22, 60, 250, 40);
    label.setForeground(Color.white);
    label.setFont(UIUtils.FONT_GENERAL_UI);
    return label;
  }

  public static Component createToggleButton() {
    int[] position = { 423, 50 };
    int[] dimensions = { 50, 25 };
    ToggleButtonUI toggleBtn = new ToggleButtonUI(false, position, dimensions);
    return toggleBtn;
  }

  public static Component createCardLabel(int posX, int posY, String message) {
    int[] position = { posX, posY };
    LabelUI label = new LabelUI(message, position);
    return label;
  }

}