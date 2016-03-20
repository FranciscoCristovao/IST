/** @version $Id: EditParagraph.java,v 1.8 2015/11/28 17:15:15 ist181505 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.Section;
import edt.Document;
import edt.NoSuchParagraphException;


/**
 * §2.2.10.
 */
public class EditParagraph extends SectionCommand {
	public EditParagraph(Section section, Document document) {
		super(MenuEntry.EDIT_PARAGRAPH, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	  int id = IO.readInteger(Message.requestParagraphId());
	  String content = IO.readString(Message.requestParagraphContent());
	  try{
	      _receiver.changeParagraph(id,content);
	  }
	  catch(NoSuchParagraphException e){IO.println(Message.noSuchParagraph(id)); }
	}
}
