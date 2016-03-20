package edt;
import java.io.Serializable;

public abstract class Entry implements Serializable{

  private String _unique_id = "";

  public Entry(){}
  
  public Entry(String unique_id){
    _unique_id = unique_id;
  }
  public String getUniqueId(){
    return _unique_id;
  }
  public void setUniqueId(String unique_id){
    _unique_id = unique_id;
  }
  public abstract void accept(Visitor v);
}