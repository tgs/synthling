package net.resc.synthie;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InstrumentChanger implements KeyListener {
	private static final int NEXT_INSTRUMENT = KeyEvent.VK_RIGHT;
	private static final int PREVIOUS_INSTRUMENT = KeyEvent.VK_LEFT;
	private final NoteController controller;
	
	public InstrumentChanger(NoteController controller) {
		this.controller = controller;
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		int keyCode = arg0.getKeyCode();
		if (keyCode == NEXT_INSTRUMENT) {
			controller.nextInstrument();
		} else if (keyCode == PREVIOUS_INSTRUMENT) {
			controller.previousInstrument();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
