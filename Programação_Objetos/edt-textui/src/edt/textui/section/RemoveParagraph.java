/** @version $Id: RemoveParagraph.java,v 1.7 2015/11/28 17:15:15 ist181505 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.Section;
import edt.Document;
import edt.Paragraph;
import edt.NoSuchParagraphException;


/**
 * §2.2.11.
 */
public class RemoveParagraph extends SectionCommand {
	public RemoveParagraph(Section section, Document document) {
		super(MenuEntry.REMOVE_PARAGRAPH, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	  int id = IO.readInteger(Message.requestParagraphId());
	  try{
	    _receiver2.docRemoveParagraph(id, _receiver);
	  }
	  catch (NoSuchParagraphException e){IO.println(Message.noSuchParagraph(id)); }
      }
}
