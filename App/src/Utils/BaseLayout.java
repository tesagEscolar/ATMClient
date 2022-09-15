package App.src.Utils;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import App.src.Toaster.Toaster;
import App.src.Components.ButtonUI;

public abstract class BaseLayout extends JFrame {
  protected final Toaster toaster;
  private String warnContext;
  private JPanel mainJPanel;
  private JDialog dlg;

  public BaseLayout() {
    this.mainJPanel = getMainJPanel();
    toaster = new Toaster(mainJPanel);
    createDialog();
  }

  public BaseLayout(boolean state, String responseContext) {
    this.mainJPanel = getMainJPanel();
    toaster = new Toaster(mainJPanel);
    createDialog();
    
    if(!state){
      this.error(responseContext);
    }else{
      this.toaster.success(responseContext);
    }
  }

  public boolean validateResponse(String response){       
    return response.substring(0, 1).equals("+");
  }
    
  public BaseLayout getBtnInFrame() {
    var components = mainJPanel.getComponents();
    for (int i = 0; i < components.length; i++) {
      if (!(components[i] instanceof ButtonUI))
        continue;

      var btn = (ButtonUI) components[i];
      components[i].addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
          btnHandler(btn.getOperation());
        }
      });
    }
    return this;
  }

  public boolean validateFormComponents(){
    
      for(var c: this.mainJPanel.getComponents()){
        if(c instanceof FormElement){
          var fc = (FormElement) c;
          if(fc.getIgnore()){
            return true;
          }
         if(!(fc.validateData())){
           setWarnContext(fc.getError());
           return false;
         }
        }
      }
    return true;
  }

  private void setWarnContext(String error){
    this.warnContext = error;
  }

  public String getWarnContext(){
    return this.warnContext;
  }
  
  public Toaster getToaster(){
    return this.toaster;  
  }
  
  protected abstract void btnHandler(String operation);

  protected abstract void manageParams(Object ... params);

  
  public void display() {
    this.add(mainJPanel);
    this.pack();
    this.toFront();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
    this.setVisible(true);
  }

  public void terminate() {
    this.dispose();
  }

  public BaseLayout addC(Component component) {
    mainJPanel.add(component);
    return this;
  }

  public void warn() {
    this.toaster.warn(warnContext);
  }

  public void error(String error) {
    this.toaster.error(error);
  }
 
  public void showLoadingDialog(boolean show){
      this.dlg.setVisible(show);
  }
  
  private void createDialog(){
    this.dlg = new JDialog(this, "Progress Dialog", true);
    this.dlg.add(BorderLayout.NORTH, new JLabel("Cargando..."));
    this.dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    this.dlg.setSize(300, 75);
    this.dlg.setLocationRelativeTo(this);
  }
  
  private JPanel getMainJPanel() {
    Dimension size = new Dimension(800, 400);
    JPanel panel = new JPanel();

    this.setUndecorated(true);
    panel.setSize(size);
    panel.setPreferredSize(size);
    panel.setBackground(UIUtils.COLOR_BACKGROUND);
    panel.setLayout(null);

    MouseAdapter ma = new MouseAdapter() {
      int lastX, lastY;

      @Override
      public void mousePressed(MouseEvent e) {
        lastX = e.getXOnScreen();
        lastY = e.getYOnScreen();
      }

      @Override
      public void mouseDragged(MouseEvent e) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        setLocation(getLocationOnScreen().x + x - lastX, getLocationOnScreen().y + y - lastY);
        lastX = x;
        lastY = y;
      }
    };

    panel.addMouseListener(ma);
    panel.addMouseMotionListener(ma);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        var frame = (JFrame)e.getSource();
        var result = JOptionPane.showConfirmDialog(
            frame,
            "Are you sure you want to exit the application?",
            "Exit Application",
            JOptionPane.YES_NO_OPTION);
 
        if (result == JOptionPane.YES_OPTION)
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //System.exit(0);
      }
    });

    return panel;
  }

}