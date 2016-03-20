/** @version $Id: SelectSection.java,v 1.10 2015/11/30 16:01:47 ist181505 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.Section;
import edt.Document;
import edt.NoSuchSectionException;


/**
 * §2.2.4.
 */
public class SelectSection extends SectionCommand {
	public SelectSection(Section section, Document document) {
		super(MenuEntry.SELECT_SECTION, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException  {
	  int id = IO.readInteger(Message.requestSectionId());
	  try{
	    Section s = _receiver.getSubSection(id);
	    IO.println(Message.newActiveSection(id));
	    edt.textui.section.MenuBuilder.menuFor(s, _receiver2);
	  }
	  catch(NoSuchSectionException e){IO.println(Message.noSuchSection(id));}
	}
}
