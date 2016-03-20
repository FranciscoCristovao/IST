/** @version $Id: Edit.java,v 1.3 2015/11/15 15:27:05 ist181505 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.EditManager;
import edt.Section;
import edt.Document;


/**
 * §2.3.1.
 */
public class Edit extends Command<EditManager> {
  public Edit(EditManager editor) {
    super(MenuEntry.OPEN_DOCUMENT_EDITOR, editor);
  }

  @Override
  public final void execute() throws DialogException, IOException {
    edt.textui.section.MenuBuilder.menuFor(_receiver.getDocument(), _receiver.getDocument());
  }

}
