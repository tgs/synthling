package net.resc.synthie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class InstrumentChooser extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 11234L;

	/**
	 * Create the panel.
	 */
	public InstrumentChooser(final NoteController controller) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JButton btnInst = new JButton("- inst");
		add(btnInst);
		btnInst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.previousInstrument();
			}
			
		});
		
		JButton btnInst_1 = new JButton("+ inst");
		add(btnInst_1);
		btnInst_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.nextInstrument();
			}
			
		});

	}

}
