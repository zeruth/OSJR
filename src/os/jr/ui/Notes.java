package os.jr.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import os.jr.utils.SettingsIo;

import java.awt.Color;
import javax.swing.JTextArea;

public class Notes extends JFrame {

	private JPanel contentPane;
	private static JTextArea txtrThankYouFor;
	public static Notes frame;
	public static String notes = "";

	/**
	 * Launch the application.
	 */
	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Notes();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Notes() {
		setTitle("Notes");
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtrThankYouFor = new JTextArea();
		txtrThankYouFor.setLineWrap(true);
		txtrThankYouFor.setText(SettingsIo.loadNotes());
		txtrThankYouFor.setForeground(Color.WHITE);
		txtrThankYouFor.setBackground(Color.DARK_GRAY);
		txtrThankYouFor.setBounds(10, 11, 414, 239);
		contentPane.add(txtrThankYouFor);
	}
	public static JTextArea getTextArea() {
		return txtrThankYouFor;
	}
}
