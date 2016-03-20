/** @version $Id: Save.java,v 1.5 2015/11/15 15:27:05 ist181505 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.EditManager;
import java.lang.String;


/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<EditManager> {
	public Save(EditManager editor) {
		super(MenuEntry.SAVE, editor);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		String filename = _receiver.editorGetFileName();
		if(filename.equals("")){
		  filename = IO.readString(Message.newSaveAs());
		}
		_receiver.saveDoc(filename);
	}
}
