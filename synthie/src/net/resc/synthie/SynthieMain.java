package net.resc.synthie;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class SynthieMain {

	public static void main(String[] args) throws MidiUnavailableException,
			InterruptedException {
		System.out.println("Hi there!");
		Synthesizer s = MidiSystem.getSynthesizer();
		s.open();
		MidiChannel chan = s.getChannels()[0];
		chan.controlChange(0x07, 100); // set most significant bits of volume
		chan.setMute(false);
		chan.noteOn(60, 50);
		Thread.sleep(2000);
		chan.noteOff(60);
		s.close();
	}

}
