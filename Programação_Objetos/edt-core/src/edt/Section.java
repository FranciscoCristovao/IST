package edt;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Section contains a title, a List of paragraphs and a List of sections (subsections).
 * A section can be created with a title or a title and a unique id
 */

public class Section extends Entry implements Serializable {
   /** Section Title */
  private String _title = "";
  /** List of paragraphs */
  private List<Paragraph> _paragraphs = new ArrayList<Paragraph>();
  /** List of subsections */
  private List<Section> _sections = new ArrayList<Section>();
  
  /** Section default constructor */
  public Section(){
  }
   /** Section constructor that receives a Title */
  public Section (String title){
    _title=title;
  }
  /** Section constructor that receives a Title and a unique id*/
  public Section (String title, String unique_id){
    super(unique_id);
    _title = title;
  }
  
  public void accept(Visitor v){
    v.visitSection(this);
  }
  
  /** 
   * ChangeTitle. Changes Title from Section
   * @param title new section title
   */
  public void changeTitle (String title){
   _title = title;
  }
  /** 
   * getTitle. Section title getter 
   * @return Section's title
   */
  public String getTitle(){
    return _title;
  }
  /** 
   * addSection. Adds a section to the list of subsections
   * @param section new section 
   */
  public void addSection(Section section){
    _sections.add(section);
  }
  /** 
   * addSection. Adds a section to the list of subsections
   * @param id  new Section id
   * @param title new section title
   */
  public void addSection (int id, String title){
    Section s = new Section(title);
    if(id < 0 || id >= _sections.size()){
      _sections.add(s);
    }
    else{
      _sections.add(id, s);
    }
  }
  /** 
   * removeSection. Removes the section from the subsections list
   * @param id Section's id
   */
  public void removeSection(int id){
      _sections.remove(id);
  }
  /** 
   * removeSection. Removes the section from the subsections list
   * @param s Section to remove
   */
  public void removeSection(Section s){
    _sections.remove(s);
  }
  
  /** 
   * addParagraph. Adds a new paragraph to the list of paragraphs
   * @param paragraph new paragraph
   */
  public void addParagraph(Paragraph paragraph){
    _paragraphs.add(paragraph);
  }
  /** 
   * addParagraph. Adds a new paragraph to the list of paragraphs
   * @param id Section's id
   * @param content paragraph's content
   */
  public void addParagraph(int id, String content){
    Paragraph p = new Paragraph(content);
    if(id < 0 || id >= _paragraphs.size()){
      _paragraphs.add(p);
    }
    else{
      _paragraphs.add(id, p);
    }
  }
  /** 
   * removeParagraph. Removes the paragraph from the paragraphs list
   * @param s Paragraph to remove
   */
  public void removeParagraph(int id){
    _paragraphs.remove(id);
  }
  
  /** 
   * changeParagraph. Changes Paragraph's content.
   * @param id Paragraph's id
   * @param text new content
   */
  public void changeParagraph(int id, String text) throws NoSuchParagraphException{
    if(id < 0 || id >= _paragraphs.size()) throw new NoSuchParagraphException();
    for(Paragraph p : _paragraphs){
      if(_paragraphs.indexOf(p) == id){
	p.setContent(text);
      }
    }
  }
  /** 
   * getTopSections. Getter for the number of top sections in a section.
   * @return Number of subsections in a section
   */
  public int getTopSections(){
    return _sections.size();
  }
  /** 
   * getParagraphsSize. Getter for the paragraph's size (title's size plus section's 
   * @return Paragraph's size
   */
  public int getParagraphsSize(){
    int size = _title.length();
    for(Section s : _sections){
      size += s.getParagraphsSize();
    }
    for(Paragraph p : _paragraphs){
      size += p.getSize();
    }
    return size;
  }
  /** 
   * getSubSection. Getter for the subsection with the given id 
   * @param id Section's id
   * @return SubSection
   */
  public Section getSubSection (int id) throws NoSuchSectionException{
    if(!hasSection(id)) throw new NoSuchSectionException();
    return _sections.get(id);
  }
  public boolean hasSection(int id){
    return (!(id < 0 || id >= _sections.size()));
  }
  public Paragraph getParagraph (int id){
    return _paragraphs.get(id);
  }
  public boolean hasParagraph(int id){
    return (!(id < 0 || id >= _paragraphs.size()));
  }
  /** 
   * getSubSectionList. Getter for the Section SubSections list 
   * @return Section SubSections list
   */
  public List<Section> getSubSectionList(){
    return _sections;
  }
  /** 
   * getParagraphList. Getter for the Section Paragraphs list 
   * @return Section Paragraphs list
   */
  public List<Paragraph> getParagraphList(){
    return _paragraphs;
  }
}

