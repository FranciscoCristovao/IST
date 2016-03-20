package edt;

public interface Visitor{
  String getInfo();
  void visitDocument(Document document);
  void visitSection(Section section);
  void visitParagraph(Paragraph paragraph);
}