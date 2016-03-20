/** @version $Id: RemoveSection.java,v 1.9 2015/11/28 20:46:36 ist181505 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.Section;
import edt.Document;
import edt.NoSuchSectionException;
import edt.NoSuchParagraphException;


/**
 * §2.2.7.
 */
public class RemoveSection extends SectionCommand {
  public RemoveSection(Section section, Document document) {
    super(MenuEntry.REMOVE_SECTION, section, document);
  }

  @Override
  public final void execute() throws DialogException, IOException {
    int id = IO.readInteger(Message.requestSectionId());
    try{
      _receiver2.docRemoveSection(id, _receiver);
    }
    catch(NoSuchSectionException e){IO.println(Message.noSuchSection(id));}
    catch(NoSuchParagraphException e){}
    }  
}
