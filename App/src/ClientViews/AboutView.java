package App.src.ClientViews;

import App.src.Utils.UIUtils;
import App.src.Utils.BaseLayout;
import App.src.System.Transactions.*;
import App.src.Utils.ComponentDispenser;

public class AboutView extends BaseLayout {
  
  AboutView(Object ... params) {
    super();
    buildView();
  }

  private void buildView() {
    this
        .addC(ComponentDispenser.createLogo())
        .addC(ComponentDispenser.createSeparator(310, 80))
        .addC(ComponentDispenser.createOperationButton("Regresar a Login", Transactions.LOGIN.name(), 423, 247))
        .addC(ComponentDispenser.createMessage(370, 120, 400, 500, UIUtils.FONT_GENERAL_UI,
            "Usuarios para Pago de Servicios: [Pago Luz, 'luzp']-[Pago agua, 'aguap'] - [Pago Gas, 'gasp']. Pague desde Transferencia."))
        .getBtnInFrame();
  }

  @Override
  protected void btnHandler(String operation) {
    this.terminate();
  }

  @Override
  protected void manageParams(Object ... params){
    if(params == null)
      return;
  }
  
  
  public BaseLayout getView() {
    return this;
  }
}