package net.resc.synthie;

import java.awt.Color;
import java.awt.EventQueue;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFrame;

public class SynthieAppWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SynthieAppWindow window = new SynthieAppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws MidiUnavailableException 
	 */
	public SynthieAppWindow() throws MidiUnavailableException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws MidiUnavailableException 
	 */
	private void initialize() throws MidiUnavailableException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SynthieControlArea controlArea = new SynthieControlArea();
		frame.getContentPane().add(controlArea);
		
		
		NoteController noteController = new NoteController();
		frame.addKeyListener(new FundamentalGenerator(noteController));
		frame.addKeyListener(new InstrumentChanger(noteController));
		
		for (int seqNum = 7; seqNum >= 0; seqNum--) {
			controlArea.add(makePad(seqNum, noteController));
		}
		
	}

	private SynthiePad makePad(int seqNum, NoteController noteController) {
		return new SynthiePad(Color.getHSBColor(seqNum / 12.0f, 0.5f, 0.5f),
				new Harmonic(seqNum), noteController);
	}

}
