package edt;
import java.io.Serializable;

public class Author implements Serializable{
    private String _name = "";
    private String _mail = "";
    
    public Author (String name, String mail){
      _name = name;
      _mail = mail;
    }
    public void setName(String name){
      _name = name;
      }
    public String getName(){
      return _name;
    }
    public void setMail(String mail){
      _mail = mail;
    }
    public String getMail(){
      return _mail;
    }
}