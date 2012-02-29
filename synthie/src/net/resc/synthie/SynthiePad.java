package net.resc.synthie;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SynthiePad extends Canvas implements MouseListener {

	private static final long serialVersionUID = 8806374456550447175L;
	private final Harmonic harmonic;
	private final HarmonicListener listener;
	private final Color color;

	/**
	 * Create the panel.
	 */
	public SynthiePad(Color color, Harmonic harmonic, HarmonicListener listener) {
		this.color = color;
		this.harmonic = harmonic;
		this.listener = listener;
		this.addMouseListener(this);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		listener.noteStarted(harmonic);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		listener.noteEnded(harmonic);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	public Harmonic getHarmonic() {
		return harmonic;
	}
}
