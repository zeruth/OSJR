package os.jr.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class SkillMonitor extends JFrame {

	private JPanel contentPane;
	private JProgressBar progressBar;
	private JProgressBar progressBar_1;
	private JProgressBar progressBar_2;
	private JProgressBar progressBar_3;
	private JProgressBar progressBar_4;
	private JProgressBar progressBar_5;
	private JProgressBar progressBar_6;
	private JProgressBar progressBar_7;
	private JProgressBar progressBar_8;
	private JProgressBar progressBar_9;
	private JProgressBar progressBar_10;
	private JProgressBar progressBar_11;
	private JProgressBar progressBar_12;
	private JProgressBar progressBar_13;
	private JProgressBar progressBar_14;
	private JProgressBar progressBar_15;
	private JProgressBar progressBar_16;
	private JProgressBar progressBar_17;
	private JProgressBar progressBar_18;
	private JProgressBar progressBar_19;
	private JProgressBar progressBar_20;
	private JProgressBar progressBar_21;
	private JProgressBar progressBar_22;
	private JLabel lblTotal;
	private JLabel SkillLevelLabel;
	private JLabel label_1;
	private JLabel label_3;
	private JLabel label_5;
	private JLabel label_7;
	private JLabel label_9;
	private JLabel label_11;
	private JLabel label_13;
	private JLabel label_15;
	private JLabel label_17;
	private JLabel label_19;
	private JLabel label_21;
	private JLabel label_23;
	private JLabel label_25;
	private JLabel label_27;
	private JLabel label_29;
	private JLabel label_31;
	private JLabel label_33;
	private JLabel label_35;
	private JLabel label_37;
	private JLabel label_39;
	private JLabel label_41;
	private JLabel label_43;
	
	public static SkillMonitor frame;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SkillMonitor();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SkillMonitor() {
		setTitle("Stat monitor");
		setBounds(100, 100, 311, 528);
		setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel StatsPanel = new JPanel();
		StatsPanel.setBackground(Color.DARK_GRAY);
		StatsPanel.setBounds(10, 11, 275, 465);
		contentPane.add(StatsPanel);
		StatsPanel.setLayout(null);
		
		JPanel AttackPanel = new JPanel();
		AttackPanel.setBackground(Color.GRAY);
		AttackPanel.setBounds(10, 11, 78, 46);
		StatsPanel.add(AttackPanel);
		AttackPanel.setLayout(null);
		
		JLabel SkillIconLabel = new JLabel("");
		SkillIconLabel.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Attack-icon.png")));
		SkillIconLabel.setBounds(14, 0, 30, 35);
		AttackPanel.add(SkillIconLabel);
		
		SkillLevelLabel = new JLabel("99");
		SkillLevelLabel.setForeground(Color.WHITE);
		SkillLevelLabel.setBounds(54, 0, 24, 35);
		AttackPanel.add(SkillLevelLabel);
		
		progressBar = new JProgressBar();
		progressBar.setBorderPainted(false);
		progressBar.setBackground(Color.BLACK);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.ORANGE);
		progressBar.setValue(50);
		progressBar.setBounds(0, 32, 78, 14);
		AttackPanel.add(progressBar);
		
		JPanel HitpointsPanel = new JPanel();
		HitpointsPanel.setLayout(null);
		HitpointsPanel.setBackground(Color.GRAY);
		HitpointsPanel.setBounds(98, 11, 78, 46);
		StatsPanel.add(HitpointsPanel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Hitpoints-icon.png")));
		label.setBounds(14, 0, 30, 35);
		HitpointsPanel.add(label);
		
		label_1 = new JLabel("99");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(54, 0, 24, 35);
		HitpointsPanel.add(label_1);
		
		progressBar_1 = new JProgressBar();
		progressBar_1.setValue(50);
		progressBar_1.setStringPainted(true);
		progressBar_1.setForeground(Color.ORANGE);
		progressBar_1.setBorderPainted(false);
		progressBar_1.setBackground(Color.BLACK);
		progressBar_1.setBounds(0, 32, 78, 14);
		HitpointsPanel.add(progressBar_1);
		
		JPanel MiningPanel = new JPanel();
		MiningPanel.setLayout(null);
		MiningPanel.setBackground(Color.GRAY);
		MiningPanel.setBounds(186, 11, 78, 46);
		StatsPanel.add(MiningPanel);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Mining-icon.png")));
		label_2.setBounds(14, 0, 30, 35);
		MiningPanel.add(label_2);
		
		label_3 = new JLabel("99");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(54, 0, 24, 35);
		MiningPanel.add(label_3);
		
		progressBar_2 = new JProgressBar();
		progressBar_2.setValue(50);
		progressBar_2.setStringPainted(true);
		progressBar_2.setForeground(Color.ORANGE);
		progressBar_2.setBorderPainted(false);
		progressBar_2.setBackground(Color.BLACK);
		progressBar_2.setBounds(0, 32, 78, 14);
		MiningPanel.add(progressBar_2);
		
		JPanel StrengthPanel = new JPanel();
		StrengthPanel.setLayout(null);
		StrengthPanel.setBackground(Color.GRAY);
		StrengthPanel.setBounds(10, 68, 78, 46);
		StatsPanel.add(StrengthPanel);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Strength-icon.png")));
		label_4.setBounds(14, 0, 30, 35);
		StrengthPanel.add(label_4);
		
		label_5 = new JLabel("99");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(54, 0, 24, 35);
		StrengthPanel.add(label_5);
		
		progressBar_3 = new JProgressBar();
		progressBar_3.setValue(50);
		progressBar_3.setStringPainted(true);
		progressBar_3.setForeground(Color.ORANGE);
		progressBar_3.setBorderPainted(false);
		progressBar_3.setBackground(Color.BLACK);
		progressBar_3.setBounds(0, 32, 78, 14);
		StrengthPanel.add(progressBar_3);
		
		JPanel AgilityPanel = new JPanel();
		AgilityPanel.setLayout(null);
		AgilityPanel.setBackground(Color.GRAY);
		AgilityPanel.setBounds(98, 68, 78, 46);
		StatsPanel.add(AgilityPanel);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Agility-icon.png")));
		label_6.setBounds(14, 0, 30, 35);
		AgilityPanel.add(label_6);
		
		label_7 = new JLabel("99");
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(54, 0, 24, 35);
		AgilityPanel.add(label_7);
		
		progressBar_4 = new JProgressBar();
		progressBar_4.setValue(50);
		progressBar_4.setStringPainted(true);
		progressBar_4.setForeground(Color.ORANGE);
		progressBar_4.setBorderPainted(false);
		progressBar_4.setBackground(Color.BLACK);
		progressBar_4.setBounds(0, 32, 78, 14);
		AgilityPanel.add(progressBar_4);
		
		JPanel SmithingPanel = new JPanel();
		SmithingPanel.setLayout(null);
		SmithingPanel.setBackground(Color.GRAY);
		SmithingPanel.setBounds(186, 68, 78, 46);
		StatsPanel.add(SmithingPanel);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Smithing-icon.png")));
		label_8.setBounds(14, 0, 30, 35);
		SmithingPanel.add(label_8);
		
		label_9 = new JLabel("99");
		label_9.setForeground(Color.WHITE);
		label_9.setBounds(54, 0, 24, 35);
		SmithingPanel.add(label_9);
		
		progressBar_5 = new JProgressBar();
		progressBar_5.setValue(50);
		progressBar_5.setStringPainted(true);
		progressBar_5.setForeground(Color.ORANGE);
		progressBar_5.setBorderPainted(false);
		progressBar_5.setBackground(Color.BLACK);
		progressBar_5.setBounds(0, 32, 78, 14);
		SmithingPanel.add(progressBar_5);
		
		JPanel DefencePanel = new JPanel();
		DefencePanel.setLayout(null);
		DefencePanel.setBackground(Color.GRAY);
		DefencePanel.setBounds(10, 125, 78, 46);
		StatsPanel.add(DefencePanel);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Defence-icon.png")));
		label_10.setBounds(14, 0, 30, 35);
		DefencePanel.add(label_10);
		
		label_11 = new JLabel("99");
		label_11.setForeground(Color.WHITE);
		label_11.setBounds(54, 0, 24, 35);
		DefencePanel.add(label_11);
		
		progressBar_6 = new JProgressBar();
		progressBar_6.setValue(50);
		progressBar_6.setStringPainted(true);
		progressBar_6.setForeground(Color.ORANGE);
		progressBar_6.setBorderPainted(false);
		progressBar_6.setBackground(Color.BLACK);
		progressBar_6.setBounds(0, 32, 78, 14);
		DefencePanel.add(progressBar_6);
		
		JPanel HerblorePanel = new JPanel();
		HerblorePanel.setLayout(null);
		HerblorePanel.setBackground(Color.GRAY);
		HerblorePanel.setBounds(98, 125, 78, 46);
		StatsPanel.add(HerblorePanel);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Herblore-icon.png")));
		label_12.setBounds(14, 0, 30, 35);
		HerblorePanel.add(label_12);
		
		label_13 = new JLabel("99");
		label_13.setForeground(Color.WHITE);
		label_13.setBounds(54, 0, 24, 35);
		HerblorePanel.add(label_13);
		
		progressBar_7 = new JProgressBar();
		progressBar_7.setValue(50);
		progressBar_7.setStringPainted(true);
		progressBar_7.setForeground(Color.ORANGE);
		progressBar_7.setBorderPainted(false);
		progressBar_7.setBackground(Color.BLACK);
		progressBar_7.setBounds(0, 32, 78, 14);
		HerblorePanel.add(progressBar_7);
		
		JPanel FishingPanel = new JPanel();
		FishingPanel.setLayout(null);
		FishingPanel.setBackground(Color.GRAY);
		FishingPanel.setBounds(186, 125, 78, 46);
		StatsPanel.add(FishingPanel);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Fishing-icon.png")));
		label_14.setBounds(14, 0, 30, 35);
		FishingPanel.add(label_14);
		
		label_15 = new JLabel("99");
		label_15.setForeground(Color.WHITE);
		label_15.setBounds(54, 0, 24, 35);
		FishingPanel.add(label_15);
		
		progressBar_8 = new JProgressBar();
		progressBar_8.setValue(50);
		progressBar_8.setStringPainted(true);
		progressBar_8.setForeground(Color.ORANGE);
		progressBar_8.setBorderPainted(false);
		progressBar_8.setBackground(Color.BLACK);
		progressBar_8.setBounds(0, 32, 78, 14);
		FishingPanel.add(progressBar_8);
		
		JPanel RangedPanel = new JPanel();
		RangedPanel.setLayout(null);
		RangedPanel.setBackground(Color.GRAY);
		RangedPanel.setBounds(10, 182, 78, 46);
		StatsPanel.add(RangedPanel);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Ranged-icon.png")));
		label_16.setBounds(14, 0, 30, 35);
		RangedPanel.add(label_16);
		
		label_17 = new JLabel("99");
		label_17.setForeground(Color.WHITE);
		label_17.setBounds(54, 0, 24, 35);
		RangedPanel.add(label_17);
		
		progressBar_9 = new JProgressBar();
		progressBar_9.setValue(50);
		progressBar_9.setStringPainted(true);
		progressBar_9.setForeground(Color.ORANGE);
		progressBar_9.setBorderPainted(false);
		progressBar_9.setBackground(Color.BLACK);
		progressBar_9.setBounds(0, 32, 78, 14);
		RangedPanel.add(progressBar_9);
		
		JPanel ThievingPanel = new JPanel();
		ThievingPanel.setLayout(null);
		ThievingPanel.setBackground(Color.GRAY);
		ThievingPanel.setBounds(98, 182, 78, 46);
		StatsPanel.add(ThievingPanel);
		
		JLabel label_18 = new JLabel("");
		label_18.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Thieving-icon.png")));
		label_18.setBounds(14, 0, 30, 35);
		ThievingPanel.add(label_18);
		
		label_19 = new JLabel("99");
		label_19.setForeground(Color.WHITE);
		label_19.setBounds(54, 0, 24, 35);
		ThievingPanel.add(label_19);
		
		progressBar_10 = new JProgressBar();
		progressBar_10.setValue(50);
		progressBar_10.setStringPainted(true);
		progressBar_10.setForeground(Color.ORANGE);
		progressBar_10.setBorderPainted(false);
		progressBar_10.setBackground(Color.BLACK);
		progressBar_10.setBounds(0, 32, 78, 14);
		ThievingPanel.add(progressBar_10);
		
		JPanel CookingPanel = new JPanel();
		CookingPanel.setLayout(null);
		CookingPanel.setBackground(Color.GRAY);
		CookingPanel.setBounds(186, 182, 78, 46);
		StatsPanel.add(CookingPanel);
		
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Cooking-icon.png")));
		label_20.setBounds(14, 0, 30, 35);
		CookingPanel.add(label_20);
		
		label_21 = new JLabel("99");
		label_21.setForeground(Color.WHITE);
		label_21.setBounds(54, 0, 24, 35);
		CookingPanel.add(label_21);
		
		progressBar_11 = new JProgressBar();
		progressBar_11.setValue(50);
		progressBar_11.setStringPainted(true);
		progressBar_11.setForeground(Color.ORANGE);
		progressBar_11.setBorderPainted(false);
		progressBar_11.setBackground(Color.BLACK);
		progressBar_11.setBounds(0, 32, 78, 14);
		CookingPanel.add(progressBar_11);
		
		JPanel PrayerPanel = new JPanel();
		PrayerPanel.setLayout(null);
		PrayerPanel.setBackground(Color.GRAY);
		PrayerPanel.setBounds(10, 239, 78, 46);
		StatsPanel.add(PrayerPanel);
		
		JLabel label_22 = new JLabel("");
		label_22.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Prayer-icon.png")));
		label_22.setBounds(14, 0, 30, 35);
		PrayerPanel.add(label_22);
		
		label_23 = new JLabel("99");
		label_23.setForeground(Color.WHITE);
		label_23.setBounds(54, 0, 24, 35);
		PrayerPanel.add(label_23);
		
		progressBar_12 = new JProgressBar();
		progressBar_12.setValue(50);
		progressBar_12.setStringPainted(true);
		progressBar_12.setForeground(Color.ORANGE);
		progressBar_12.setBorderPainted(false);
		progressBar_12.setBackground(Color.BLACK);
		progressBar_12.setBounds(0, 32, 78, 14);
		PrayerPanel.add(progressBar_12);
		
		JPanel CraftingPanel = new JPanel();
		CraftingPanel.setLayout(null);
		CraftingPanel.setBackground(Color.GRAY);
		CraftingPanel.setBounds(98, 239, 78, 46);
		StatsPanel.add(CraftingPanel);
		
		JLabel label_24 = new JLabel("");
		label_24.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Crafting-icon.png")));
		label_24.setBounds(14, 0, 30, 35);
		CraftingPanel.add(label_24);
		
		label_25 = new JLabel("99");
		label_25.setForeground(Color.WHITE);
		label_25.setBounds(54, 0, 24, 35);
		CraftingPanel.add(label_25);
		
		progressBar_13 = new JProgressBar();
		progressBar_13.setValue(50);
		progressBar_13.setStringPainted(true);
		progressBar_13.setForeground(Color.ORANGE);
		progressBar_13.setBorderPainted(false);
		progressBar_13.setBackground(Color.BLACK);
		progressBar_13.setBounds(0, 32, 78, 14);
		CraftingPanel.add(progressBar_13);
		
		JPanel FiremakingPanel = new JPanel();
		FiremakingPanel.setLayout(null);
		FiremakingPanel.setBackground(Color.GRAY);
		FiremakingPanel.setBounds(186, 239, 78, 46);
		StatsPanel.add(FiremakingPanel);
		
		JLabel label_26 = new JLabel("");
		label_26.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Firemaking-icon.png")));
		label_26.setBounds(14, 0, 30, 35);
		FiremakingPanel.add(label_26);
		
		label_27 = new JLabel("99");
		label_27.setForeground(Color.WHITE);
		label_27.setBounds(54, 0, 24, 35);
		FiremakingPanel.add(label_27);
		
		progressBar_14 = new JProgressBar();
		progressBar_14.setValue(50);
		progressBar_14.setStringPainted(true);
		progressBar_14.setForeground(Color.ORANGE);
		progressBar_14.setBorderPainted(false);
		progressBar_14.setBackground(Color.BLACK);
		progressBar_14.setBounds(0, 32, 78, 14);
		FiremakingPanel.add(progressBar_14);
		
		JPanel MagicPanel = new JPanel();
		MagicPanel.setLayout(null);
		MagicPanel.setBackground(Color.GRAY);
		MagicPanel.setBounds(10, 296, 78, 46);
		StatsPanel.add(MagicPanel);
		
		JLabel label_28 = new JLabel("");
		label_28.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Magic-icon.png")));
		label_28.setBounds(14, 0, 30, 35);
		MagicPanel.add(label_28);
		
		label_29 = new JLabel("99");
		label_29.setForeground(Color.WHITE);
		label_29.setBounds(54, 0, 24, 35);
		MagicPanel.add(label_29);
		
		progressBar_15 = new JProgressBar();
		progressBar_15.setValue(50);
		progressBar_15.setStringPainted(true);
		progressBar_15.setForeground(Color.ORANGE);
		progressBar_15.setBorderPainted(false);
		progressBar_15.setBackground(Color.BLACK);
		progressBar_15.setBounds(0, 32, 78, 14);
		MagicPanel.add(progressBar_15);
		
		JPanel FletchingPanel = new JPanel();
		FletchingPanel.setLayout(null);
		FletchingPanel.setBackground(Color.GRAY);
		FletchingPanel.setBounds(98, 296, 78, 46);
		StatsPanel.add(FletchingPanel);
		
		JLabel label_30 = new JLabel("");
		label_30.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Fletching-icon.png")));
		label_30.setBounds(14, 0, 30, 35);
		FletchingPanel.add(label_30);
		
		label_31 = new JLabel("99");
		label_31.setForeground(Color.WHITE);
		label_31.setBounds(54, 0, 24, 35);
		FletchingPanel.add(label_31);
		
		progressBar_16 = new JProgressBar();
		progressBar_16.setValue(50);
		progressBar_16.setStringPainted(true);
		progressBar_16.setForeground(Color.ORANGE);
		progressBar_16.setBorderPainted(false);
		progressBar_16.setBackground(Color.BLACK);
		progressBar_16.setBounds(0, 32, 78, 14);
		FletchingPanel.add(progressBar_16);
		
		JPanel WoodcuttingPanel = new JPanel();
		WoodcuttingPanel.setLayout(null);
		WoodcuttingPanel.setBackground(Color.GRAY);
		WoodcuttingPanel.setBounds(186, 296, 78, 46);
		StatsPanel.add(WoodcuttingPanel);
		
		JLabel label_32 = new JLabel("");
		label_32.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Woodcutting-icon.png")));
		label_32.setBounds(14, 0, 30, 35);
		WoodcuttingPanel.add(label_32);
		
		label_33 = new JLabel("99");
		label_33.setForeground(Color.WHITE);
		label_33.setBounds(54, 0, 24, 35);
		WoodcuttingPanel.add(label_33);
		
		progressBar_17 = new JProgressBar();
		progressBar_17.setValue(50);
		progressBar_17.setStringPainted(true);
		progressBar_17.setForeground(Color.ORANGE);
		progressBar_17.setBorderPainted(false);
		progressBar_17.setBackground(Color.BLACK);
		progressBar_17.setBounds(0, 32, 78, 14);
		WoodcuttingPanel.add(progressBar_17);
		
		JPanel RunecraftingPanel = new JPanel();
		RunecraftingPanel.setLayout(null);
		RunecraftingPanel.setBackground(Color.GRAY);
		RunecraftingPanel.setBounds(10, 353, 78, 46);
		StatsPanel.add(RunecraftingPanel);
		
		JLabel label_34 = new JLabel("");
		label_34.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Runecrafting-icon.png")));
		label_34.setBounds(14, 0, 30, 35);
		RunecraftingPanel.add(label_34);
		
		label_35 = new JLabel("99");
		label_35.setForeground(Color.WHITE);
		label_35.setBounds(54, 0, 24, 35);
		RunecraftingPanel.add(label_35);
		
		progressBar_18 = new JProgressBar();
		progressBar_18.setValue(50);
		progressBar_18.setStringPainted(true);
		progressBar_18.setForeground(Color.ORANGE);
		progressBar_18.setBorderPainted(false);
		progressBar_18.setBackground(Color.BLACK);
		progressBar_18.setBounds(0, 32, 78, 14);
		RunecraftingPanel.add(progressBar_18);
		
		JPanel SlayerPanel = new JPanel();
		SlayerPanel.setLayout(null);
		SlayerPanel.setBackground(Color.GRAY);
		SlayerPanel.setBounds(98, 353, 78, 46);
		StatsPanel.add(SlayerPanel);
		
		JLabel label_36 = new JLabel("");
		label_36.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Slayer-icon.png")));
		label_36.setBounds(14, 0, 30, 35);
		SlayerPanel.add(label_36);
		
		label_37 = new JLabel("99");
		label_37.setForeground(Color.WHITE);
		label_37.setBounds(54, 0, 24, 35);
		SlayerPanel.add(label_37);
		
		progressBar_19 = new JProgressBar();
		progressBar_19.setValue(50);
		progressBar_19.setStringPainted(true);
		progressBar_19.setForeground(Color.ORANGE);
		progressBar_19.setBorderPainted(false);
		progressBar_19.setBackground(Color.BLACK);
		progressBar_19.setBounds(0, 32, 78, 14);
		SlayerPanel.add(progressBar_19);
		
		JPanel FarmingPanel = new JPanel();
		FarmingPanel.setLayout(null);
		FarmingPanel.setBackground(Color.GRAY);
		FarmingPanel.setBounds(186, 353, 78, 46);
		StatsPanel.add(FarmingPanel);
		
		JLabel label_38 = new JLabel("");
		label_38.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Farming-icon.png")));
		label_38.setBounds(14, 0, 30, 35);
		FarmingPanel.add(label_38);
		
		label_39 = new JLabel("99");
		label_39.setForeground(Color.WHITE);
		label_39.setBounds(54, 0, 24, 35);
		FarmingPanel.add(label_39);
		
		progressBar_20 = new JProgressBar();
		progressBar_20.setValue(50);
		progressBar_20.setStringPainted(true);
		progressBar_20.setForeground(Color.ORANGE);
		progressBar_20.setBorderPainted(false);
		progressBar_20.setBackground(Color.BLACK);
		progressBar_20.setBounds(0, 32, 78, 14);
		FarmingPanel.add(progressBar_20);
		
		JPanel ConstructionPanel = new JPanel();
		ConstructionPanel.setLayout(null);
		ConstructionPanel.setBackground(Color.GRAY);
		ConstructionPanel.setBounds(10, 410, 78, 46);
		StatsPanel.add(ConstructionPanel);
		
		JLabel label_40 = new JLabel("");
		label_40.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Construction-icon.png")));
		label_40.setBounds(14, 0, 30, 35);
		ConstructionPanel.add(label_40);
		
		label_41 = new JLabel("99");
		label_41.setForeground(Color.WHITE);
		label_41.setBounds(54, 0, 24, 35);
		ConstructionPanel.add(label_41);
		
		progressBar_21 = new JProgressBar();
		progressBar_21.setValue(50);
		progressBar_21.setStringPainted(true);
		progressBar_21.setForeground(Color.ORANGE);
		progressBar_21.setBorderPainted(false);
		progressBar_21.setBackground(Color.BLACK);
		progressBar_21.setBounds(0, 32, 78, 14);
		ConstructionPanel.add(progressBar_21);
		
		JPanel HunterPanel = new JPanel();
		HunterPanel.setLayout(null);
		HunterPanel.setBackground(Color.GRAY);
		HunterPanel.setBounds(98, 410, 78, 46);
		StatsPanel.add(HunterPanel);
		
		JLabel label_42 = new JLabel("");
		label_42.setIcon(new ImageIcon(SkillMonitor.class.getResource("/resources/Hunter-icon.png")));
		label_42.setBounds(14, 0, 30, 35);
		HunterPanel.add(label_42);
		
		label_43 = new JLabel("99");
		label_43.setForeground(Color.WHITE);
		label_43.setBounds(54, 0, 24, 35);
		HunterPanel.add(label_43);
		
		progressBar_22 = new JProgressBar();
		progressBar_22.setValue(50);
		progressBar_22.setStringPainted(true);
		progressBar_22.setForeground(Color.ORANGE);
		progressBar_22.setBorderPainted(false);
		progressBar_22.setBackground(Color.BLACK);
		progressBar_22.setBounds(0, 32, 78, 14);
		HunterPanel.add(progressBar_22);
		
		lblTotal = new JLabel("Total: 0");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setBounds(199, 427, 65, 14);
		StatsPanel.add(lblTotal);
	}
	public JProgressBar getAttackProgress() {
		return progressBar;
	}
	public JProgressBar getHitpointsProgress() {
		return progressBar_1;
	}
	public JProgressBar getMiningProgress() {
		return progressBar_2;
	}
	public JProgressBar getStrengthProgress() {
		return progressBar_3;
	}
	public JProgressBar getAgilityProgress() {
		return progressBar_4;
	}
	public JProgressBar getSmithingProgress() {
		return progressBar_5;
	}
	public JProgressBar getDefenceProgress() {
		return progressBar_6;
	}
	public JProgressBar getHerbloreProgress() {
		return progressBar_7;
	}
	public JProgressBar getFishingProgress() {
		return progressBar_8;
	}
	public JProgressBar getRangedProgress() {
		return progressBar_9;
	}
	public JProgressBar getThievingProgress() {
		return progressBar_10;
	}
	public JProgressBar getCookingProgress() {
		return progressBar_11;
	}
	public JProgressBar getPrayerProgress() {
		return progressBar_12;
	}
	public JProgressBar getCraftingProgress() {
		return progressBar_13;
	}
	public JProgressBar getFiremakingProgress() {
		return progressBar_14;
	}
	public JProgressBar getMagicProgress() {
		return progressBar_15;
	}
	public JProgressBar getFletchingProgress() {
		return progressBar_16;
	}
	public JProgressBar getWoodcuttingProgress() {
		return progressBar_17;
	}
	public JProgressBar getRunecraftingProgress() {
		return progressBar_18;
	}
	public JProgressBar getSlayerProgress() {
		return progressBar_19;
	}
	public JProgressBar getFarmingProgress() {
		return progressBar_20;
	}
	public JProgressBar getConstructionProgress() {
		return progressBar_21;
	}
	public JProgressBar getHunterProgress() {
		return progressBar_22;
	}
	public JLabel getTotalLevelLabel() {
		return lblTotal;
	}
	public JLabel getAttackLevel() {
		return SkillLevelLabel;
	}
	public JLabel getHitpointsLevel() {
		return label_1;
	}
	public JLabel getMiningLevel() {
		return label_3;
	}
	public JLabel getStrengthLevel() {
		return label_5;
	}
	public JLabel getAgilityLevel() {
		return label_7;
	}
	public JLabel getSmithingLevel() {
		return label_9;
	}
	public JLabel getDefenceLevel() {
		return label_11;
	}
	public JLabel getHerbloreLevel() {
		return label_13;
	}
	public JLabel getFishingLevel() {
		return label_15;
	}
	public JLabel getRangedLevel() {
		return label_17;
	}
	public JLabel getThievingLevel() {
		return label_19;
	}
	public JLabel getCookingLevel() {
		return label_21;
	}
	public JLabel getPrayerLevel() {
		return label_23;
	}
	public JLabel getCraftingLevel() {
		return label_25;
	}
	public JLabel getFiremakingLevel() {
		return label_27;
	}
	public JLabel getMagicLevel() {
		return label_29;
	}
	public JLabel getFletchingLevel() {
		return label_31;
	}
	public JLabel getWoodcuttingLevel() {
		return label_33;
	}
	public JLabel getRunecraftingLevel() {
		return label_35;
	}
	public JLabel getSlayerLevel() {
		return label_37;
	}
	public JLabel getFarmingLevel() {
		return label_39;
	}
	public JLabel getConstructionLevel() {
		return label_41;
	}
	public JLabel getHunterLevel() {
		return label_43;
	}
}
