package App.src.ClientViews;

import java.awt.*;
import java.awt.event.*;
import App.src.System.User;
import App.src.Components.*;
import App.src.Utils.UIUtils;
import App.src.Utils.BaseLayout;
import App.src.System.Transactions.*;
import App.src.Utils.TextFieldPassword;
import App.src.Utils.ComponentDispenser;

public class LoginView extends BaseLayout {
  private boolean cardMovement = false, state;
  private String responseContext;
  private TextFieldPassword nipField;
  private TextFieldUsername usernameField;

  LoginView(Object ... params) {
    super();
    this.toaster.info("Movimiento sin tarjeta no requiere NIP");
    manageParams(params);
    if (params.length != 0) {
      if (!state) {
        this.error(responseContext);
      } else {
        this.toaster.success(responseContext);
      }
    }
    buildView();
  }

  private void buildView() {
    cardMovement = false;
    usernameField = (TextFieldUsername) ComponentDispenser.createUsernameTextField(423, 109,
        UIUtils.PLACEHOLDER_TEXT_USERNAME, "^[a-zA-Z]{4,10}$",
        "Usuario debe contener solo letras y de 3-10 caracteres");
    nipField = (TextFieldPassword) ComponentDispenser.createPasswordTextField(423, 168, false, "\\d{4}",
        "NIP debe ser un numero de 4 digitos");

    var togglebtn = ComponentDispenser.createToggleButton();
    var temptoaster = this.toaster;
    togglebtn.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if(!cardMovement){
          temptoaster.info("Movimiento sin tarjeta no requiere NIP");
        }
        cardMovement = !cardMovement;
        nipField.setEditable(cardMovement);
      }
    });

    this
        .addC(togglebtn)
        .addC(usernameField)
        .addC(nipField)
        .addC(ComponentDispenser.createLogo())
        .addC(ComponentDispenser.createSeparator(310, 80))
        .addC(ComponentDispenser.createCardLabel(480, 50, UIUtils.BUTTON_TEXT_CARD))
        .addC(ComponentDispenser.createCardLabel(385, 180, "NIP"))
        .addC(ComponentDispenser.createOperationButton("Continue", Transactions.LOGIN.name(), 423, 247))
        .addC(ComponentDispenser.createHyperLinkText(UIUtils.BUTTON_TEXT_FORGOT_PASS, 423, 300, () -> {
          new ChangeNipView().display();
        }))
        .addC(ComponentDispenser.createHyperLinkText(UIUtils.BUTTON_TEXT_REGISTER, 625, 300, () -> {
          new AboutView().display();
        }))
        .getBtnInFrame();
  }

  @Override
  protected void btnHandler(String operation) {
    if (operation == Transactions.LOGIN.name()) {
      if (cardMovement) {
        if (this.validateFormComponents()) {
          var pnip = Integer.parseInt(String.valueOf(nipField.getPassword()));
          User.getUser().setUser(cardMovement, usernameField.getText(), pnip);

          if (User.getUser().getUserState()) {
            ViewBuilder.buildView(Views.OPERATIONS, true, User.getUser().getResponseContext()).display();
            this.terminate();
          } else {
            this.toaster.error(User.getUser().getResponseContext());
          }
        } else {
          this.warn();
        }
      } else {
        nipField.setText("1234");
        if (this.validateFormComponents()) {
          nipField.setText("");
          User.getUser().setUser(cardMovement, usernameField.getText());
          
          ViewBuilder.buildView(Views.OPERATIONS, true, User.getUser().getResponseContext()).display();
          this.terminate();
        }else{
          nipField.setText("");
          System.out.println("Que wea");
          this.warn();
        }
      }
    }
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