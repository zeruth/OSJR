package os.rs.discord;

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

	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public UpdateStatus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 150, 128);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUpdateStatus = new JLabel("Update Status");
		lblUpdateStatus.setBounds(5, 5, 124, 20);
		lblUpdateStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblUpdateStatus);

		textField = new JTextField();
		textField.setBounds(5, 30, 124, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DiscordManager.discordStatus = textField.getText();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(5, 56, 124, 23);
		contentPane.add(btnNewButton);
	}
}
