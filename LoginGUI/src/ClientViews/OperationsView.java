package LoginGUI.src.ClientViews;

import java.awt.*;
import LoginGUI.src.System.User;
import LoginGUI.src.Utils.BaseLayout;
import LoginGUI.src.System.Transactions.*;
import LoginGUI.src.Utils.ComponentDispenser;


public class OperationsView extends BaseLayout {
  String responseContext;
  boolean state;

  OperationsView(Object... params) {
    super();
    manageParams(params);
    if (params.length != 0) {
      if (!this.state) {
        this.error(this.responseContext);
      } else {
        this.toaster.success(responseContext);
      }
    }
    if (User.getUser().isCardMovement()) {
      buildView();
    } else {
      buildAltView();
    }
  }

  private void buildView() {
    this
        .addC(ComponentDispenser.createLogo())
        .addC(ComponentDispenser.createSeparator(310, 80))
        .addC(ComponentDispenser.createOperationButton("Consulta", Transactions.CONSULT.name(), 423, 60))
        .addC(ComponentDispenser.createOperationButton("Deposito", Transactions.DEPOSIT.name(), 423, 119))
        .addC(ComponentDispenser.createOperationButton("Transferencia", Transactions.TRANSFER.name(), 423, 178))
        .addC(ComponentDispenser.createOperationButton("Retiro", Transactions.WITHDRAW.name(), 423, 237))
        .addC(ComponentDispenser.createOperationButton("Eliminar", Transactions.DELETE_ACCOUNT.name(), 423, 296))
        .getBtnInFrame();
  }

  private void buildAltView(){
     this
          .addC(ComponentDispenser.createLogo())
          .addC(ComponentDispenser.createSeparator(310, 80))
          .addC(ComponentDispenser.createOperationButton("Deposito", Transactions.ANOYMUS_DEPOSIT.name(), 423, 119))
          .getBtnInFrame();
  }
  
  @Override
  public void btnHandler(String operation) {
    if (operation.equals(Transactions.CONSULT.name())) {
      ViewBuilder.buildView(Views.TRANSACTION, new Consult()).display();
    } else if (operation.equals(Transactions.DEPOSIT.name())) {
      ViewBuilder.buildView(Views.TRANSACTION, new Deposit()).display();
    } else if (operation.equals(Transactions.TRANSFER.name())) {
      ViewBuilder.buildView(Views.TRANSACTION, new Transfer()).display();
    } else if (operation.equals(Transactions.WITHDRAW.name())) {
      ViewBuilder.buildView(Views.TRANSACTION, new Withdraw()).display();
    } else if (operation.equals(Transactions.DELETE_ACCOUNT.name())) {
      ViewBuilder.buildView(Views.TRANSACTION, new DeleteAccount()).display();
    }else if (operation.equals(Transactions.ANOYMUS_DEPOSIT.name())) {
      ViewBuilder.buildView(Views.TRANSACTION, new AnonymusDeposit()).display();
    }
    this.terminate();
  }

  @Override
  protected void manageParams(Object... params) {
    if (params == null)
      return;
    if (params.length == 0)
      return;
    
    for (Object param : params) {
      if (param instanceof Boolean) {
        this.state = (boolean) param;
      } else if (param instanceof String) {
        this.responseContext = (String) param;
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