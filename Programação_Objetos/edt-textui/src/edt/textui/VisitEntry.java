package edt.textui;

import edt.textui.main.Message;
import edt.Document;
import edt.Section;
import edt.Paragraph;
import edt.Visitor;


public class VisitEntry implements Visitor{

  private String _info = "";
  
  public void visitParagraph(Paragraph p){
    _info += p.getContent() + "\n";
  }

  public void visitSection(Section section){
    _info += Message.sectionIndexEntry(section.getUniqueId(), section.getTitle()) + "\n";
    for(Paragraph p : section.getParagraphList()){
      visitParagraph(p);
    }
    for(Section s : section.getSubSectionList()){
      visitSection(s);
    }
  }
  public void visitDocument(Document document){
    _info += "{" + document.getTitle() + "}" + "\n";
    for(Paragraph p : document.getParagraphList()){
      visitParagraph(p);
    }
    for(Section s : document.getSubSectionList()){
      visitSection(s);
    }
  }
  public String getInfo(){
    return _info.substring(0, _info.length()-1);
  }
}