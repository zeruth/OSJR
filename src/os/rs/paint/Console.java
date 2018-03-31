package os.rs.paint;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import os.rs.game.Game;

public class Console extends JPanel implements ActionListener {
	public static boolean isOpen = false;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static boolean isOpen() {
		return isOpen;
	}

	protected JTextArea textArea;

	protected JTextField textField;

	public Console(Game game) {
		super(new GridBagLayout());
		isOpen = true;

		textField = new JTextField(20);
		textField.addActionListener(this);

		textArea = new JTextArea(15, 20);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textArea);

		// Add Components to this panel.
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;

		c.fill = GridBagConstraints.HORIZONTAL;
		add(textField, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		this.add(scrollPane, c);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String text = textField.getText();

		// textField.selectAll();
		textField.setText("");

		// Make sure the new text is visible, even if there
		// was a selection in the text area.
		textArea.setCaretPosition(textArea.getDocument().getLength());

		// handle text
		if (text.startsWith("clear")) {
			textArea.setText("");
		}

	}

}