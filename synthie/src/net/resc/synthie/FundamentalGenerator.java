package net.resc.synthie;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class FundamentalGenerator implements KeyListener {
	private static Map<Integer, Fundamental> keyFundamentals = new HashMap<Integer, Fundamental>();
	static {
		keyFundamentals.put(KeyEvent.VK_A, new Fundamental(60));
		keyFundamentals.put(KeyEvent.VK_S, new Fundamental(67));
		keyFundamentals.put(KeyEvent.VK_D, new Fundamental(62));
		keyFundamentals.put(KeyEvent.VK_F, new Fundamental(69));
		keyFundamentals.put(KeyEvent.VK_G, new Fundamental(64));
		keyFundamentals.put(KeyEvent.VK_H, new Fundamental(71));
		keyFundamentals.put(KeyEvent.VK_J, new Fundamental(66));
		keyFundamentals.put(KeyEvent.VK_K, new Fundamental(73));
		keyFundamentals.put(KeyEvent.VK_L, new Fundamental(68));
		
		keyFundamentals.put(KeyEvent.VK_Q, new Fundamental(69));
		keyFundamentals.put(KeyEvent.VK_W, new Fundamental(64));
		keyFundamentals.put(KeyEvent.VK_E, new Fundamental(71));
		keyFundamentals.put(KeyEvent.VK_R, new Fundamental(66));
		keyFundamentals.put(KeyEvent.VK_T, new Fundamental(73));
		keyFundamentals.put(KeyEvent.VK_Y, new Fundamental(68));
		keyFundamentals.put(KeyEvent.VK_U, new Fundamental(75));
		keyFundamentals.put(KeyEvent.VK_I, new Fundamental(70));
		keyFundamentals.put(KeyEvent.VK_O, new Fundamental(77));
		keyFundamentals.put(KeyEvent.VK_P, new Fundamental(72));
		
	}
	
	private final FundamentalListener listener;

	public FundamentalGenerator(FundamentalListener listener) {
		this.listener = listener;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		Integer keyCode = arg0.getKeyCode();
		if (keyFundamentals.containsKey(keyCode)) {
			this.listener.fundamentalStarted(keyFundamentals.get(keyCode));
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		Integer keyCode = arg0.getKeyCode();
		if (keyFundamentals.containsKey(keyCode)) {
			this.listener.fundamentalEnded(keyFundamentals.get(keyCode));
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
