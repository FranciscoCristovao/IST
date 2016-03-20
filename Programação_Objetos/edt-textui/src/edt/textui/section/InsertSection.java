/** @version $Id: InsertSection.java,v 1.5 2015/11/22 19:03:29 ist181505 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.Section;
import edt.Document;


/**
 * §2.2.5.
 */
public class InsertSection extends SectionCommand {
  public InsertSection(Section section, Document document) {
    super(MenuEntry.INSERT_SECTION, section, document);
  }

  @Override
  public final void execute() throws DialogException, IOException {
      int id = IO.readInteger(Message.requestSectionId());
      String title = IO.readString(Message.requestSectionTitle());
      _receiver.addSection(id,title);
      
  }
}
