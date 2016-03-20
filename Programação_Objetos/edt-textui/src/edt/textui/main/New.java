/** @version $Id: New.java,v 1.5 2015/11/15 15:27:05 ist181505 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.EditManager;


/**
 * Open a new document.
 */
public class New extends Command<EditManager> {
	public New(EditManager editor) {
		super(MenuEntry.NEW, editor);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	  _receiver.createDocument();
	}

}
