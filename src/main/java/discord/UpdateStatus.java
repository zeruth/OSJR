package discord;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UpdateStatus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void run() {
		UpdateStatus frame = new UpdateStatus();
		frame.setVisible(true);
	}

	private JPanel contentPane;

	JTextField textField;

	/**
	 * Create the frame.
	 */
	public UpdateStatus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 150, 128);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		JLabel lblUpdateStatus = new JLabel("Update Status");
		lblUpdateStatus.setBounds(5, 5, 124, 20);
		lblUpdateStatus.setHorizontalAlignment(SwingConstants.CENTER);
		this.contentPane.add(lblUpdateStatus);

		this.textField = new JTextField();
		this.textField.setBounds(5, 30, 124, 20);
		this.contentPane.add(this.textField);
		this.textField.setColumns(10);

		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DiscordManager.discordStatus = UpdateStatus.this.textField.getText();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(5, 56, 124, 23);
		this.contentPane.add(btnNewButton);
	}
}
