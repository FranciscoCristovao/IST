/** @version $Id: ShowContent.java,v 1.5 2015/11/27 00:57:54 ist181505 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.Section;
import edt.Document;
import edt.Visitor;
import edt.textui.VisitEntry;


/**
 * §2.2.3.
 */
public class ShowContent extends SectionCommand {
	public ShowContent(Section section, Document document) {
		super(MenuEntry.SHOW_CONTENT, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	  Visitor v = new VisitEntry();
	  _receiver.accept(v);
	  IO.println(v.getInfo());
	}
}
