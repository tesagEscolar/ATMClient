package App.src.Utils;

public interface FormElement{
  String getError();
  boolean getIgnore();
  boolean validateData();
}