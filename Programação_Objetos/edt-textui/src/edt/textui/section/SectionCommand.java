/** @version $Id: SectionCommand.java,v 1.7 2015/11/29 19:49:41 ist181505 Exp $ */
package edt.textui.section;

import ist.po.ui.Command;
import edt.Section;
import edt.Document;


/**
 * Superclass of all section-context commands.
 */
public abstract class SectionCommand extends Command<Section> {
  
	Document _receiver2;
	public SectionCommand(String title, Section section, Document document) {
		super(title, section);
		_receiver2 = document;
	}

}
