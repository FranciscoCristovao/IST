/** @version $Id: InsertParagraph.java,v 1.6 2015/11/23 23:27:11 ist181505 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.Section;
import edt.Document;


/**
 * §2.2.8.
 */
public class InsertParagraph extends SectionCommand {
	public InsertParagraph(Section section, Document document) {
		super(MenuEntry.INSERT_PARAGRAPH, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	  int id = IO.readInteger(Message.requestParagraphId());
	  String content = IO.readString(Message.requestParagraphContent());
	  _receiver.addParagraph(id, content);
	}
}
