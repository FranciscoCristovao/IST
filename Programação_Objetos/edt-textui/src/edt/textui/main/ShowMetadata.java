/** @version $Id: ShowMetadata.java,v 1.5 2015/11/15 15:27:05 ist181505 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.EditManager;


/**
 * §2.1.2.
 */
public class ShowMetadata extends Command<EditManager> {
	public ShowMetadata(EditManager editor) {
		super(MenuEntry.SHOW_METADATA, editor);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		IO.println(Message.documentTitle(_receiver.editorGetTitle()));
		String[] _authorsInfo = _receiver.editorGetAuthors();
		for(int i = 0; i<_authorsInfo.length; i++){
		  IO.println(Message.author(_authorsInfo[i], _authorsInfo[i+1]));
		  i++;
		}
		IO.println(Message.documentSections(_receiver.editorGetTopSections()));
		IO.println(Message.documentBytes(_receiver.editorGetSize()));
		IO.println(Message.documentIdentifiers(_receiver.editorGetNId()));
	}

}
