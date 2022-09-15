package App.src.ClientViews;

import App.src.System.User;
import App.src.Utils.UIUtils;
import App.src.System.Operation;
import App.src.Utils.BaseLayout;
import App.src.System.Transactions.*;
import App.src.Utils.TextFieldPassword;
import App.src.Components.TextFieldUsername;
import App.src.Utils.ComponentDispenser;


public class ChangeNipView extends BaseLayout {
  private TextFieldPassword confirmnip, newnip, nip;
  private TextFieldUsername username;


  ChangeNipView(Object ... params) {
    super();
    buildView();
  }

  private void buildView() {
    username = (TextFieldUsername) ComponentDispenser.createUsernameTextField(423, 70,
        UIUtils.PLACEHOLDER_TEXT_USERNAME,
        "^[a-zA-Z]{4,10}$", "Usuario debe contener solo letras y de 3-10 caracteres");

    nip = (TextFieldPassword) ComponentDispenser.createPasswordTextField(423, 120, true, "\\d{4}",
        "NIP debe ser un numero de 4 digitos");
    newnip = (TextFieldPassword) ComponentDispenser.createPasswordTextField(423, 170, true, "\\d{4}",
        "Nuevo NIP debe ser un numero de 4 digitos");
    confirmnip = (TextFieldPassword) ComponentDispenser.createPasswordTextField(423, 220, true,
        String.valueOf(newnip.getPassword()),
        "NIP de confirmacion no coincide");

    this
        .addC(nip)
        .addC(newnip)
        .addC(username)
        .addC(confirmnip)
        .addC(ComponentDispenser.createLogo())
        .addC(ComponentDispenser.createSeparator(290, 80))
        .addC(ComponentDispenser.createCardLabel(385, 132, "NIP"))
        .addC(ComponentDispenser.createCardLabel(308, 182, "NUEVO NIP"))
        .addC(ComponentDispenser.createCardLabel(298, 232, "CONFIRMAR"))
        .addC(ComponentDispenser.createOperationButton("Continue", Transactions.LOGIN.name(), 423, 270))
        .getBtnInFrame();
  }

  @Override
  protected void btnHandler(String operation) {
    if (operation == Transactions.LOGIN.name()) {
      confirmnip.setRegCondition(String.valueOf(newnip.getPassword()));
      if (this.validateFormComponents()) {
        var pnip = Integer.parseInt(String.valueOf(nip.getPassword()));
        var nnip = Integer.parseInt(String.valueOf(newnip.getPassword()));
        Operation transaction = new ChangeNip();
        transaction.setParameters(username.getText(), User.setNip(pnip), User.setNip(nnip));
        transaction.executeOperation();
        if (transaction.validateResponse()) {
          new LoginView(true, transaction.getResponseContext()).display();
          this.terminate();
        } else {
          new LoginView(false, transaction.getResponseContext()).display();
          this.terminate();
        }
      } else {
        this.warn();
      }
    }
  }

  @Override
  protected void manageParams(Object ... params){
    if(params == null)
      return;
    if (params.length == 0)
      return;
  }
  
  public BaseLayout getView() {
    return this;
  }
}