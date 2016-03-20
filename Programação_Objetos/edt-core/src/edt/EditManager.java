package edt;
import java.util.Map;
import java.util.TreeMap;
import java.lang.String;
import java.io.*;

public class EditManager{

  private Document _document;
  private String _filename;
  
  public EditManager(){
    _document = new Document();
    _filename = "";
  }
  
  public void createDocument(){
    _document = new Document();
    _filename = "";
  }
  public void openDoc(String name) throws FileNotFoundException{
    _filename = name;
    try{
       ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(_filename)));
       _document = (Document) ois.readObject();
       ois.close();
    }
    catch(IOException e){e.printStackTrace(); }
    catch(ClassNotFoundException e){e.printStackTrace(); }
  }
  public void saveDoc(String name) {
    try{
      ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(name)));
      _filename = name;
      oos.writeObject(_document);
      oos.close();
    }
    catch(IOException e){e.printStackTrace(); }
  }
  public void dataImport(String data) throws FileNotFoundException{
    try{
      BufferedReader reader = new BufferedReader(new FileReader(data));
      String[] str, authors;
      String line; 
      Section section = _document;
      _document.changeTitle(reader.readLine());
      line = reader.readLine();
      authors = line.split("\\|");
      for(String author : authors) {
	str = author.split("/");
	_document.addAuthor(str[0], str[1]);
      }
      while ((line = reader.readLine()) != null){
	str = line.split("\\|");
	if(str[0].equals("SECTION")){
	  section = new Section(str[2]);
	  if(!(str[1].equals(""))){
	    section.setUniqueId(str[1]);
	    _document.addMapEntry(section);
	  }
	  _document.addSection(section);
	}
	else if(str[0].equals("PARAGRAPH")){
	  Paragraph paragraph = new Paragraph(str[1]);
	  section.addParagraph(paragraph);
	}
      }
    }
    catch(IOException e){e.printStackTrace(); }
  }
   public Document getDocument(){
    return _document;
  }
  public void setDocument(Document document){
    _document = document;
  }
  public String editorGetTitle(){
    return _document.getTitle();
  }
  public String editorGetFileName(){
    return _filename;
  }
  public String[] editorGetAuthors(){
     return _document.getAuthorsData();
  }
  public int editorGetTopSections(){
    return _document.getTopSections();
  }
  public int editorGetSize(){
    return _document.getParagraphsSize();
  }
  public int editorGetNId(){
    return _document.getNId();
  }
  public boolean editorAddAuthor(String name, String mail){
    return _document.addAuthor(name, mail);
  }
  public void editorShowTextElement(String unique_id, Visitor v) throws NoMapEntryException{
    _document.getMapEntry(unique_id).accept(v);
  }
}