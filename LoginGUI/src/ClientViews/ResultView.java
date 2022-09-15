package LoginGUI.src.ClientViews;

import java.awt.*;
import LoginGUI.src.Utils.UIUtils;
import LoginGUI.src.Utils.BaseLayout;
import LoginGUI.src.Utils.ComponentDispenser;


public class ResultView extends BaseLayout {
  private String responseContext;

  ResultView(Object ... params) {
    this.toaster.success("Transaccion Exitosa");
    manageParams(params);
    buildView();
  }

  private void buildView() {
    this
        .addC(ComponentDispenser.createLogo())
        .addC(ComponentDispenser.createSeparator(310, 80))
        .addC(ComponentDispenser.createMessage(370, 90, 400, 150, UIUtils.FONT_RESULT_UI, responseContext))
        .addC(ComponentDispenser.createOperationButton("Continue", " ", 423, 247))
        .getBtnInFrame();
  }

  @Override
  public void btnHandler(String operation) {
    ViewBuilder.buildView(Views.LOGIN, true, "Gracias por su preferencia").display();
    this.terminate();
  }

  @Override
  protected void manageParams(Object ... params){
    if(params == null)
      return;
    if (params.length == 0)
      return;
    
    for(Object param: params){
      if(param instanceof String){
        this.responseContext = (String) param;
        break;
      }
    }
  }
  
  private void addDeclaredComponents(Component... components) {
    for (var c : components) {
      this.add(c);
    }
  }

  public BaseLayout getView() {
    return this;
  }
}