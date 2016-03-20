/** @version $Id: ShowIndex.java,v 1.5 2015/11/28 17:15:15 ist181505 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.EditManager;
import edt.Document;
import edt.Section;
import edt.Visitor;
import edt.textui.VisitListIndex;


/**
 * §2.1.4.
 */
public class ShowIndex extends Command<EditManager> {
	public ShowIndex(EditManager editor) {
		super(MenuEntry.SHOW_INDEX, editor);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	  Visitor v = new VisitListIndex();
	  _receiver.getDocument().accept(v);
	  IO.println(v.getInfo());
	}
}
