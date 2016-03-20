/** @version $Id: ChangeTitle.java,v 1.5 2015/11/21 18:59:01 ist181505 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.Section;
import edt.Document;


/**
 * §2.2.1.
 */
public class ChangeTitle extends SectionCommand {
	public ChangeTitle(Section section, Document document) {
		super(MenuEntry.CHANGE_TITLE, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
    		String title = IO.readString(Message.requestSectionTitle());
    		_receiver.changeTitle(title);
	}
}
