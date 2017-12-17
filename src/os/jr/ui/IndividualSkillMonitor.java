package os.jr.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class IndividualSkillMonitor extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private JLabel lblSkillimage;
	private JLabel lblLevellabel;
	private JLabel lblXptillevellabel;
	private JLabel lblXptillabel;
	private JLabel lblXpTil_1;
	private JLabel lblXptillabel_1;
	private JProgressBar progressBar;
	public static int skillFrameCount = 0;
	public static IndividualSkillMonitor[] frames = new IndividualSkillMonitor[25];

	/**
	 * Create the frame.
	 */
	public IndividualSkillMonitor() {
		setAlwaysOnTop(true);
		setBounds(100, 100, 269, 253);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 11, 233, 192);
		contentPane.add(panel);
		panel.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBackground(Color.BLACK);
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 167, 213, 14);
		panel.add(progressBar);
		
		JLabel lblLevel = new JLabel("XP Til Lvl");
		lblLevel.setForeground(Color.WHITE);
		lblLevel.setBounds(10, 93, 103, 14);
		panel.add(lblLevel);
		
		JLabel label = new JLabel("Level");
		label.setForeground(Color.WHITE);
		label.setBounds(10, 68, 103, 14);
		panel.add(label);
		
		JLabel lblXpTil = new JLabel("XP til 99");
		lblXpTil.setForeground(Color.WHITE);
		lblXpTil.setBounds(10, 118, 103, 14);
		panel.add(lblXpTil);
		
		lblSkillimage = new JLabel("");
		lblSkillimage.setBounds(100, 42, 30, 24);
		panel.add(lblSkillimage);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Attack", "Agility", "Construction", "Cooking", "Crafting", "Defence", "Firemaking", "Fishing", "Fletching", "Hitpoints", "Herblore", "Hunter", "Farming", "Magic", "Mining", "Prayer", "Ranged", "Runecrafting", "Slayer", "Smithing", "Strength", "Thieving", "Woodcutting"}));
		comboBox.setBounds(50, 11, 133, 20);
		panel.add(comboBox);
		
		lblLevellabel = new JLabel("LevelLabel");
		lblLevellabel.setForeground(Color.WHITE);
		lblLevellabel.setBounds(123, 68, 100, 14);
		panel.add(lblLevellabel);
		
		lblXptillevellabel = new JLabel("XPTilLevelLabel");
		lblXptillevellabel.setForeground(Color.WHITE);
		lblXptillevellabel.setBounds(123, 93, 100, 14);
		panel.add(lblXptillevellabel);
		
		lblXptillabel = new JLabel("XPTil99Label");
		lblXptillabel.setForeground(Color.WHITE);
		lblXptillabel.setBounds(123, 118, 100, 14);
		panel.add(lblXptillabel);
		
		lblXpTil_1 = new JLabel("XP til 120");
		lblXpTil_1.setForeground(Color.WHITE);
		lblXpTil_1.setBounds(10, 142, 103, 14);
		panel.add(lblXpTil_1);
		
		lblXptillabel_1 = new JLabel("XPTil120Label");
		lblXptillabel_1.setForeground(Color.WHITE);
		lblXptillabel_1.setBounds(123, 143, 100, 14);
		panel.add(lblXptillabel_1);
	}
	public JComboBox<String> getSkillSelector() {
		return comboBox;
	}
	public JLabel getSkillImageLabel() {
		return lblSkillimage;
	}
	public JLabel getLevellabel() {
		return lblLevellabel;
	}
	public JLabel getXptillevellabel() {
		return lblXptillevellabel;
	}
	public JLabel getXptil99label() {
		return lblXptillabel;
	}
	public JLabel getXptil120label() {
		return lblXptillabel_1;
	}
	public JProgressBar getProgressBar() {
		return progressBar;
	}
}
