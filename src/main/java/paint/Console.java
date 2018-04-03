package paint;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import game.Game;

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

		this.textField = new JTextField(20);
		this.textField.addActionListener(this);

		this.textArea = new JTextArea(15, 20);
		this.textArea.setEditable(false);
		this.textArea.setLineWrap(true);
		this.textArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(this.textArea);

		// Add Components to this panel.
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;

		c.fill = GridBagConstraints.HORIZONTAL;
		add(this.textField, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		this.add(scrollPane, c);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String text = this.textField.getText();

		// textField.selectAll();
		this.textField.setText("");

		// Make sure the new text is visible, even if there
		// was a selection in the text area.
		this.textArea.setCaretPosition(this.textArea.getDocument().getLength());

		// handle text
		if (text.startsWith("clear")) {
			this.textArea.setText("");
		}

	}

}
