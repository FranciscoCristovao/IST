/** @version $Id: NameParagraph.java,v 1.8 2015/11/28 17:15:15 ist181505 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.Section;
import edt.Document;
import edt.NoSuchParagraphException;


/**
 * §2.2.9.
 */
public class NameParagraph extends SectionCommand {
  public NameParagraph(Section section, Document document) {
    super(MenuEntry.NAME_PARAGRAPH, section, document);
  }

  @Override
  public final void execute() throws DialogException, IOException {
    int id = IO.readInteger(Message.requestParagraphId());
    String unique_id = IO.readString(Message.requestUniqueId());
    try{
      if(_receiver2.nameParagraph(id, unique_id, _receiver)){
	IO.println(Message.paragraphNameChanged());
      }
    }
    catch(NoSuchParagraphException e){IO.println(Message.noSuchParagraph(id)); }
  }
}
