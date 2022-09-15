package LoginGUI.src.ClientViews;

import java.awt.*;
import LoginGUI.src.System.User;
import LoginGUI.src.System.Operation;
import LoginGUI.src.Utils.BaseLayout;
import LoginGUI.src.System.Transactions.*;
import LoginGUI.src.Utils.TextFieldPassword;
import LoginGUI.src.Components.TextFieldUsername;
import LoginGUI.src.Utils.ComponentDispenser;

public class TransactionView extends BaseLayout {
  private Operation transaction;
  private TextFieldPassword pwd;
  private TextFieldUsername amount, recipient;

  TransactionView(Object ... params) {
    super();
    manageParams(params);
    buildView();
  }

  private void buildView() {
    pwd = (TextFieldPassword) ComponentDispenser.createPasswordTextField(423, 168, true, "\\d{4}",
        "NIP debe ser un numero de 4 digitos");
    amount = (TextFieldUsername) ComponentDispenser.createUsernameTextField(423, 109, "Cantidad $$", "\\d{1,4}$",
        "La cantidad debe ser un numero de 1-4 digitos");
    recipient = (TextFieldUsername) ComponentDispenser.createUsernameTextField(423, 50, "Nombre Beneficiario",
        "^[a-zA-Z]{4,10}$", "Beneficiario debe contener solo letras y de 3-10 caracteres");

    if (User.getUser().isCardMovement()) {
      this.addC(pwd).addC(ComponentDispenser.createCardLabel(385, 180, "NIP"));
    }
    if (!(transaction instanceof Consult || transaction instanceof DeleteAccount)) {
      this.addC(amount);
    }
    if (transaction instanceof Transfer || transaction instanceof AnonymusDeposit) {
      this.addC(recipient);
    }

    this
        .addC(ComponentDispenser.createLogo())
        .addC(ComponentDispenser.createSeparator(310, 80))
        .addC(ComponentDispenser.createOperationButton("Continue", "CONTINUE", 423, 247))
        .getBtnInFrame();
  }

  @Override
  protected void btnHandler(String operation) {
    int amountQ = 0, pnip = -1;
    String getter = "", hashnip="-1";

    if (this.validateFormComponents()) {
      if (User.getUser().isCardMovement()) {
        pnip = Integer.parseInt(String.valueOf(pwd.getPassword()));
        hashnip = User.setNip(pnip);
      }
      if (transaction instanceof Transfer || transaction instanceof AnonymusDeposit) {
        getter = recipient.getText();
      }
      if (!(transaction instanceof Consult || transaction instanceof DeleteAccount)) {
        amountQ = Integer.parseInt(amount.getText());
      }
 
      transaction.setParameters( User.getUser().getUsername(),hashnip,amountQ, getter);
      transaction.executeOperation();
      if (transaction.validateResponse()) {
        ViewBuilder.buildView(Views.RESULT, transaction.getResponseContext()).display();
        this.terminate();
      } else {
        ViewBuilder.buildView(Views.LOGIN, transaction.validateResponse(), transaction.getResponseContext()).display();
        this.terminate();
      }
    } else {
      this.warn();
    }
  }

  @Override
  protected void manageParams(Object ... params){
    if(params == null)
      return;
    if (params.length == 0)
      return;
    
    for(Object param: params){
      if(param instanceof Operation){
        this.transaction = (Operation) param;
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