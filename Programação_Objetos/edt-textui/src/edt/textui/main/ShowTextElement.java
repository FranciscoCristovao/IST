/** @version $Id: ShowTextElement.java,v 1.5 2015/11/28 17:15:15 ist181505 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import edt.EditManager;
import edt.Document;
import edt.Visitor;
import edt.textui.VisitEntry;
import edt.Entry;
import edt.NoMapEntryException;


/**
 * §2.1.5.
 */
public class ShowTextElement extends Command<EditManager> {
  public ShowTextElement(EditManager editor) {
    super(MenuEntry.SHOW_TEXT_ELEMENT, editor);
  }

  @Override
  public final void execute() throws DialogException, IOException {
    String uId = IO.readString(Message.requestElementId());
    try{
      Visitor v = new VisitEntry();
      _receiver.editorShowTextElement(uId, v);
      IO.println(v.getInfo());
    }
    catch (NoMapEntryException e) { IO.println(Message.noSuchTextElement(uId)); }
  }
}
