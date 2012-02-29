package net.resc.synthie;

import java.util.HashSet;
import java.util.Set;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class NoteController implements HarmonicListener, FundamentalListener {
	private static final int[] harmonicOffsets 
		= new int[] { 0, 12, 19, 24, 28, 31, 34, 36 };
	
//	private final NoteModel model = new NoteModel();
	private Harmonic currentHarmonic = null;
	private final Set<Fundamental> currentFundamentals = new HashSet<Fundamental>();

	private final MidiChannel midiChannel;

	
//	private Instrument[] allInstruments;
	private int instrumentIndex = 0;

	public NoteController() throws MidiUnavailableException {
		Synthesizer s = MidiSystem.getSynthesizer();
//		s.getReceiver().
		
		s.open();
		this.midiChannel = s.getChannels()[0];
		this.midiChannel.controlChange(0x07, 100); // set most significant bits of volume
		this.midiChannel.setMute(false);
//		this.allInstruments = s.getLoadedInstruments();
//		System.out.println(Arrays.asList(this.allInstruments));
		
//		chan.noteOn(60, 50);
//		Thread.sleep(2000);
//		chan.noteOff(60);
//		s.close();
	}
	
	@Override
	public void noteStarted(Harmonic h) {
		currentHarmonic = h;
		
		for (Fundamental f : currentFundamentals) {
			startNote(getNoteNumber(f, h));
		}
	}


	@Override
	public void noteEnded(Harmonic h) {
		currentHarmonic = null;
		
		for (Fundamental f: currentFundamentals) {
			stopNote(getNoteNumber(f, h));
		}
	}

	private void startNote(int noteNumber) {
		this.midiChannel.noteOn(noteNumber, 127);
	}
	private void stopNote(int noteNumber) {
		this.midiChannel.noteOff(noteNumber, 127);
	}

	@Override
	public void fundamentalStarted(Fundamental f) {
		currentFundamentals.add(f);
		
		if (currentHarmonic != null) {
			startNote(getNoteNumber(f, currentHarmonic));
		}
	}

	@Override
	public void fundamentalEnded(Fundamental f) {
		currentFundamentals.remove(f);
		if (currentHarmonic != null) {
			stopNote(getNoteNumber(f, currentHarmonic));
		}
	}

	
	private static int getNoteNumber(Fundamental f, Harmonic h) {
		return f.getNoteNum() + harmonicOffsets[h.getSeqNum()];
	}

	public void previousInstrument() {
		this.instrumentIndex -= 1;
//		if (instrumentIndex < 0) {
//			instrumentIndex += allInstruments.length;
//		}
//		Patch p = allInstruments[instrumentIndex].getPatch();
//		midiChannel.programChange(p.getBank(), p.getProgram());
		midiChannel.programChange(this.instrumentIndex);
		System.out.println(this.instrumentIndex);
	}

	public void nextInstrument() {
		this.instrumentIndex += 1;
		midiChannel.programChange(this.instrumentIndex);
		System.out.println(this.instrumentIndex);
//		if (instrumentIndex >= allInstruments.length) {
//			instrumentIndex -= allInstruments.length;
//		}
//		Patch p = allInstruments[instrumentIndex].getPatch();
//		midiChannel.programChange(p.getBank(), p.getProgram());
		
	}
	
}
