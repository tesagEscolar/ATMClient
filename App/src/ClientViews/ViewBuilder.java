package App.src.ClientViews;

import App.src.Utils.BaseLayout;


public class ViewBuilder {

  static BaseLayout buildView(Views view, Object ... params) {
    if (view == null) {
      return null;
    }
    if (view.name().equalsIgnoreCase("ABOUT")) {
      return new AboutView(params);
    } else if (view.name().equalsIgnoreCase("CHANGE_NIP")) {
      return new ChangeNipView(params);
    } else if (view.name().equalsIgnoreCase("LOGIN")) {
      return new LoginView(params);
    }
    else if (view.name().equalsIgnoreCase("OPERATIONS")) {
      return new OperationsView(params);
    }
    else if (view.name().equalsIgnoreCase("RESULT")) {
      return new ResultView(params);
    }
    else if (view.name().equalsIgnoreCase("TRANSACTION")) {
      return new TransactionView(params);
    }
    return null;
  }  

  public static void startApp(){
    new LoginView().display();
  }
  
}