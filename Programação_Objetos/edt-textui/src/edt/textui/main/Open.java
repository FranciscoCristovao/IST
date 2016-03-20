/** @version $Id: Open.java,v 1.5 2015/11/15 15:27:05 ist181505 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import java.io.FileNotFoundException;
import edt.EditManager;


/**
 * Open existing document.
 */
public class Open extends Command<EditManager> {
	public Open(EditManager editor) {
		super(MenuEntry.OPEN, editor);
	}

	@Override
	public final void execute() throws DialogException, IOException{
		String filename = IO.readString(Message.openFile());
		try{
		  _receiver.openDoc(filename);
		}
		catch(FileNotFoundException e){
		  IO.println(Message.fileNotFound());
		}
		
	}

}
