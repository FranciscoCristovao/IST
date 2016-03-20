package edt.textui;

import edt.textui.main.Message;
import edt.Document;
import edt.Section;
import edt.Paragraph;
import edt.Visitor;


public class VisitListSections implements Visitor{

  private String _info = "";
  
  public void visitParagraph(Paragraph p){}

  public void visitSection(Section section){
    for(Section s : section.getSubSectionList()){
      _info += Message.sectionIndexEntry(s.getUniqueId(), s.getTitle()) + "\n";
      visitSection(s);
    }
  }
  public void visitDocument(Document document){
    for(Section s : document.getSubSectionList()){
      _info += Message.sectionIndexEntry(s.getUniqueId(), s.getTitle()) + "\n";
      visitSection(s);
    }
  }
  public String getInfo(){
    if(_info.equals("")) return "";
    return _info.substring(0, _info.length()-1);
  }
}