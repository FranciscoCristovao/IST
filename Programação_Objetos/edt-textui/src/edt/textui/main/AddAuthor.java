/** @version $Id: AddAuthor.java,v 1.4 2015/11/21 17:08:10 ist181505 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.EditManager;


/**
 * §2.1.3.
 */
public class AddAuthor extends Command<EditManager> {
	public AddAuthor(EditManager editor) {
		super(MenuEntry.ADD_AUTHOR, editor);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	  String name = IO.readString(Message.requestAuthorName());
	  String mail = IO.readString(Message.requestEmail());
	  if(!(_receiver.editorAddAuthor(name, mail))){
	    IO.println(Message.duplicateAuthor(name));
	  }
	}
}
