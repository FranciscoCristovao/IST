/** @version $Id: NameSection.java,v 1.8 2015/11/28 17:15:15 ist181505 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.Section;
import edt.Document;
import edt.NoSuchSectionException;


/**
 * §2.2.6.
 */
public class NameSection extends SectionCommand {
  public NameSection(Section section, Document document) {
    super(MenuEntry.NAME_SECTION, section, document);
  }

  @Override
  public final void execute() throws DialogException, IOException {
    int id = IO.readInteger(Message.requestSectionId());
    String unique_id = IO.readString(Message.requestUniqueId());
    try{
      if(_receiver2.nameSection(id, unique_id, _receiver)){
	IO.println(Message.sectionNameChanged());
      }
    }
    catch(NoSuchSectionException e){IO.println(Message.noSuchSection(id)); }
  }
}
