/** @version $Id: ListSections.java,v 1.5 2015/11/28 17:15:15 ist181505 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.Section;
import edt.Document;
import edt.Visitor;
import edt.textui.VisitListSections;


/**
 * §2.2.2.
 */
public class ListSections extends SectionCommand {
	public ListSections(Section section, Document document) {
		super(MenuEntry.LIST_SECTIONS, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	  Visitor v = new VisitListSections();
	  _receiver.accept(v);
	  if(!(v.getInfo().equals("")))
	    IO.println(v.getInfo());
	}
}
