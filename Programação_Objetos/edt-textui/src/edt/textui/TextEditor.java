/** @version $Id: TextEditor.java,v 1.6 2015/11/15 15:27:05 ist181505 Exp $ */
package edt.textui;

import static ist.po.ui.Dialog.IO;

import java.io.IOException;
import java.io.FileNotFoundException;
import edt.EditManager;


/**
 * Class that starts the application's textual interface.
 */
public class TextEditor {
	public static void main(String[] args) {
		EditManager editor = new EditManager();
		try{
		  String datafile = System.getProperty("import"); //$NON-NLS-1$
		  if (datafile != null) {
			  editor.dataImport(datafile);
		  }
		  edt.textui.main.MenuBuilder.menuFor(editor);
		  IO.closeDown();
		}
		catch (FileNotFoundException e){}
	}
}
