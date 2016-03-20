package edt;
import java.lang.String;
import java.io.Serializable;

public class Paragraph extends Entry implements Serializable{
  
  private String _content = "";
  
  public Paragraph(String content){
    _content = content; 
  }
  public void accept(Visitor v){
    v.visitParagraph(this);
  }
  
  public String getContent(){
    return _content;
  }
  
  public void setContent(String content){
    _content = content;
  }
  
  public int getSize(){
    return _content.length();
  }
}

