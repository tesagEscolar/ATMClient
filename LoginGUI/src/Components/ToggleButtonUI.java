package LoginGUI.src.Components;

import java.awt.*;
import LoginGUI.src.Utils.*;

public class ToggleButtonUI extends ToggleButton implements ComponentUI {
  private boolean selected = false;
  private int[] position, dimensions;

  public ToggleButtonUI(boolean selected, int[] position, int[] dimensions) {
    super();
    this.selected = selected;
    this.position = position;
    this.dimensions = dimensions;
    setDefaultConfiguration();
  }

  public boolean getState() {
    return selected;
  }

  @Override
  public void setDefaultConfiguration() {
    this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    this.setBounds(position[0], position[1], dimensions[0], dimensions[1]);
  }
}