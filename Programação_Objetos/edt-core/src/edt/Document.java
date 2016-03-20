package edt;
import java.util.Map;
import java.util.TreeMap;
import java.io.*;

public class Document extends Section implements Serializable{
  private Map<String, Author> _authors = new TreeMap<String, Author>();
  private Map<String, Entry> _entries = new TreeMap<String, Entry>();

  public Document(){
  }

  public void accept(Visitor v){
    v.visitDocument(this);
  }
  
  public boolean addAuthor(String name, String mail){
    if(_authors.get(name) != null){
      return false;
    }
    Author author = new Author(name, mail);
    _authors.put(author.getName(), (author));
    return true;
    }
  public void removeAuthor(String unique_id){
    Author a = _authors.remove(unique_id);
  }
  public void addMapEntry(Entry entry){
    _entries.put(entry.getUniqueId(), entry);
  }
  public Entry getMapEntry(String key) throws NoMapEntryException{
    if(_entries.get(key) ==null) throw new NoMapEntryException();
    return _entries.get(key);
  }
  public void removeMapEntry(String key){
    _entries.remove(key);
  } 
  public String[] getAuthorsData(){
    int i = 0;
    String[] authors = new String[_authors.size()*2];
    for(Map.Entry<String, Author> _entry : _authors.entrySet()){
       authors[i] = _entry.getValue().getName();
       authors[i+1] = _entry.getValue().getMail();
       i+=2;
    }
    return authors;
  }
  public int getNId(){
    return _entries.size();
  }
  public boolean nameSection(int id, String unique_id, Section section) throws NoSuchSectionException{ 
    if(!(section.hasSection(id))) throw new NoSuchSectionException();
    Section s = section.getSubSection(id);
    Entry entry;
    String oldId;
    if(_entries.get(unique_id) != null){
      entry = _entries.get(unique_id);
      _entries.remove(unique_id);
      entry.setUniqueId("");
    }
    if(!(s.getUniqueId().equals(""))){
      oldId = s.getUniqueId();
      _entries.remove(oldId);
      s.setUniqueId(unique_id);
      _entries.put(unique_id, s);
      return true;
    }
    s.setUniqueId(unique_id);
    _entries.put(unique_id, s);
    return false;
  }
  public boolean nameParagraph(int id, String unique_id, Section section) throws NoSuchParagraphException{ 
    if(!(section.hasParagraph(id))) throw new NoSuchParagraphException();
    Paragraph p = section.getParagraph(id);
    Entry entry;
    String oldId;
    if(_entries.get(unique_id) != null){
      entry = _entries.get(unique_id);
      _entries.remove(unique_id);
      entry.setUniqueId("");
    }
    if(!(p.getUniqueId().equals(""))){
      oldId = p.getUniqueId();
      _entries.remove(oldId);
      p.setUniqueId(unique_id);
      _entries.put(unique_id, p); 
      return true;
    }
    p.setUniqueId(unique_id);
    _entries.put(unique_id, p);
    return false;
  }
  public void docRemoveParagraph(int id, Section section) throws NoSuchParagraphException{
    if(!(section.hasParagraph(id))) throw new NoSuchParagraphException(); 
    Paragraph p = section.getParagraph(id);
    String uId = p.getUniqueId();
    if(!(uId.equals(""))){
      _entries.remove(uId);
      p.setUniqueId("");
    }
    section.removeParagraph(id);
  }
  public void docRemoveSection(int id, Section section) throws NoSuchSectionException, NoSuchParagraphException{
    if(!(section.hasSection(id))) throw new NoSuchSectionException();
    Section s = section.getSubSection(id);
    String uId = s.getUniqueId();
    for(int i = 0; i < s.getSubSectionList().size(); i++){
      docRemoveSection(i, s);
    }
    for(int i = 0; i < s.getParagraphList().size(); i++){
      docRemoveParagraph(i, s);
    }
    if(!(uId.equals(""))){
      _entries.remove(uId);
      s.setUniqueId("");
    }
    section.removeSection(id);
  }
}