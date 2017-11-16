package com.osshell;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.osshell.util.Util;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class HookDebugger {

	public static Label lblWeightdata;
	public static Label lblEnergydata;
	public static Label lblWorld;
	public static boolean woke = false;
	public static Label skill0Level, skill1Level, skill2Level, skill3Level, skill4Level, skill5Level, skill6Level,
			skill7Level, skill8Level, skill9Level, skill10Level, skill11Level, skill12Level, skill13Level, skill14Level,
			skill15Level, skill16Level, skill17Level, skill18Level, skill19Level, skill20Level, skill21Level,
			skill22Level;
	public static Label skill0Experience, skill1Experience, skill2Experience, skill3Experience, skill4Experience,
			skill5Experience, skill6Experience, skill7Experience, skill8Experience, skill9Experience, skill10Experience,
			skill11Experience, skill12Experience, skill13Experience, skill14Experience, skill15Experience,
			skill16Experience, skill17Experience, skill18Experience, skill19Experience, skill20Experience,
			skill21Experience, skill22Experience;
	public static int world = -1;
	public static int energy = -1;
	public static int weight = -1;
	public static int[] experiences;
	public static int[] levels;
	public static ProgressBar progressBar_16;
	public static long lastForcedRedraw = System.currentTimeMillis();
	public static long nextForcedRedraw = lastForcedRedraw += 1000;

	private final String[] SKILLS = new String[] { "0: Attack", "1: Defence", "2: Strength", "3: Hitpoints",
			"4: Ranged", "5: Prayer", "6: Magic", "7: Cooking", "8: Woodcutting", "9: Fletching", "10: Fishing",
			"11: Firemaking", "12: Crafting", "13: Smithing", "14: Mining", "15: Herblore", "16: Agility",
			"17: Thieving", "18: Slayer", "19: Farming", "20: Runecrafting", "21: Hunter", "22: Construction", "?",
			"?" };

	protected Shell shell = new Shell();
	private static ProgressBar progressBar_0;
	private static ProgressBar progressBar_1;
	private static ProgressBar progressBar_2;
	private static ProgressBar progressBar_3;
	private static ProgressBar progressBar_4;
	private static ProgressBar progressBar_5;
	private static ProgressBar progressBar_6;
	private static ProgressBar progressBar_7;
	private static ProgressBar progressBar_8;
	private static ProgressBar progressBar_9;
	private static ProgressBar progressBar_10;
	private static ProgressBar progressBar_11;
	private static ProgressBar progressBar_12;
	private static ProgressBar progressBar_13;
	private static ProgressBar progressBar_14;
	private static ProgressBar progressBar_15;
	private static ProgressBar progressBar_17;
	private static ProgressBar progressBar_18;
	private static ProgressBar progressBar_19;
	private static ProgressBar progressBar_20;
	private static ProgressBar progressBar_21;
	private static ProgressBar progressBar_22;
	private Label lblGgg;
	private Label label_23;
	private Label label_24;
	private Label label_25;
	private Label label_26;
	private Label label_27;
	private Label label_28;
	private Label label_29;
	private Label label_30;
	private Label label_31;
	private Label label_32;
	private Label label_33;
	private Label label_34;
	private Label label_35;
	private Label label_36;
	private Label label_37;
	private Label label_38;
	private Label label_39;
	private Label label_40;
	private Label label_41;
	private Label label_42;
	private Label label_43;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main() {
		try {
			HookDebugger window = new HookDebugger();
			Util.makeXPforLevel();
			window.open();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * 
	 * @throws InterruptedException
	 */
	public void open() throws InterruptedException {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.forceFocus();
		shell.layout();
		while (!shell.isDisposed()) {
			while (!display.readAndDispatch()) {
				if (woke == false) {
					updateValues();
					display.timerExec(100, new Runnable() {

						@Override
						public void run() {
							display.wake();
							updateValues();
							shell.redraw();
							woke = false;
						}
					});
					woke = true;
				}
				if (woke == true) {
					display.sleep();
				}

			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {

		shell = new Shell();
		shell.setSize(740, 796);
		shell.setText("Hooks");

		Label lblClient = new Label(shell, SWT.NONE);
		lblClient.setBounds(75, 10, 55, 15);
		lblClient.setText("Client");

		Label lblWeight = new Label(shell, SWT.NONE);
		lblWeight.setBounds(10, 48, 55, 15);
		lblWeight.setText("Weight:");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 69, 55, 15);
		lblNewLabel.setText("Energy: ");

		Label lblCurrentWorld = new Label(shell, SWT.NONE);
		lblCurrentWorld.setBounds(10, 90, 75, 15);
		lblCurrentWorld.setText("Current World");

		lblWeightdata = new Label(shell, SWT.NONE);
		lblWeightdata.setBounds(136, 48, 55, 15);
		lblWeightdata.setText("" + weight);

		lblEnergydata = new Label(shell, SWT.NONE);
		lblEnergydata.setBounds(136, 69, 55, 15);
		lblEnergydata.setText("" + energy);

		lblWorld = new Label(shell, SWT.NONE);
		lblWorld.setBounds(136, 90, 55, 15);
		lblWorld.setText("" + world);

		Label lblSkills = new Label(shell, SWT.NONE);
		lblSkills.setBounds(306, 69, 55, 15);
		lblSkills.setText("Skills");

		Label lblLevels = new Label(shell, SWT.NONE);
		lblLevels.setBounds(404, 69, 55, 15);
		lblLevels.setText("Levels");

		Label lblExperience = new Label(shell, SWT.NONE);
		lblExperience.setBounds(484, 69, 55, 15);
		lblExperience.setText("Experience");

		Label label = new Label(shell, SWT.NONE);
		label.setBounds(306, 138, 55, 15);
		label.setText(SKILLS[0]);

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(306, 167, 68, 15);
		label_1.setText(SKILLS[1]);

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(306, 196, 68, 15);
		label_2.setText(SKILLS[2]);

		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(306, 227, 68, 15);
		label_3.setText(SKILLS[3]);

		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(306, 258, 55, 15);
		label_4.setText(SKILLS[4]);

		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setBounds(306, 285, 55, 15);
		label_5.setText(SKILLS[5]);

		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(306, 315, 55, 15);
		label_6.setText(SKILLS[6]);

		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setBounds(306, 344, 68, 15);
		label_7.setText(SKILLS[7]);

		Label label_8 = new Label(shell, SWT.NONE);
		label_8.setBounds(306, 372, 92, 15);
		label_8.setText(SKILLS[8]);

		Label label_9 = new Label(shell, SWT.NONE);
		label_9.setBounds(306, 400, 68, 15);
		label_9.setText(SKILLS[9]);

		Label label_10 = new Label(shell, SWT.NONE);
		label_10.setBounds(306, 427, 55, 15);
		label_10.setText(SKILLS[10]);

		Label label_11 = new Label(shell, SWT.NONE);
		label_11.setBounds(306, 452, 92, 15);
		label_11.setText(SKILLS[11]);

		Label label_12 = new Label(shell, SWT.NONE);
		label_12.setBounds(306, 477, 68, 15);
		label_12.setText(SKILLS[12]);

		Label label_13 = new Label(shell, SWT.NONE);
		label_13.setBounds(306, 506, 68, 15);
		label_13.setText(SKILLS[13]);

		Label label_14 = new Label(shell, SWT.NONE);
		label_14.setBounds(306, 537, 55, 15);
		label_14.setText(SKILLS[14]);

		Label label_15 = new Label(shell, SWT.NONE);
		label_15.setBounds(306, 568, 80, 15);
		label_15.setText(SKILLS[15]);

		Label label_16 = new Label(shell, SWT.NONE);
		label_16.setBounds(306, 595, 55, 15);
		label_16.setText(SKILLS[16]);

		Label label_17 = new Label(shell, SWT.NONE);
		label_17.setBounds(306, 616, 68, 15);
		label_17.setText(SKILLS[17]);

		Label label_18 = new Label(shell, SWT.NONE);
		label_18.setBounds(306, 639, 55, 15);
		label_18.setText(SKILLS[18]);

		Label label_19 = new Label(shell, SWT.NONE);
		label_19.setBounds(306, 662, 68, 15);
		label_19.setText(SKILLS[19]);

		Label label_20 = new Label(shell, SWT.NONE);
		label_20.setBounds(306, 685, 92, 15);
		label_20.setText(SKILLS[20]);

		Label label_21 = new Label(shell, SWT.NONE);
		label_21.setBounds(306, 708, 55, 15);
		label_21.setText(SKILLS[21]);

		Label label_22 = new Label(shell, SWT.NONE);
		label_22.setBounds(306, 731, 92, 15);
		label_22.setText(SKILLS[22]);

		skill0Level = new Label(shell, SWT.NONE);
		skill0Level.setBounds(404, 138, 55, 15);
		skill0Level.setText("99/99");

		skill0Experience = new Label(shell, SWT.NONE);
		skill0Experience.setBounds(484, 138, 55, 15);
		skill0Experience.setText("10000000");

		skill1Level = new Label(shell, SWT.NONE);
		skill1Level.setBounds(404, 167, 55, 15);
		skill1Level.setText("99/99");

		skill1Experience = new Label(shell, SWT.NONE);
		skill1Experience.setBounds(484, 167, 55, 15);
		skill1Experience.setText("10000000");

		skill2Level = new Label(shell, SWT.NONE);
		skill2Level.setBounds(404, 196, 55, 15);
		skill2Level.setText("99/99");

		skill2Experience = new Label(shell, SWT.NONE);
		skill2Experience.setBounds(484, 196, 55, 15);
		skill2Experience.setText("10000000");

		skill3Level = new Label(shell, SWT.NONE);
		skill3Level.setBounds(404, 227, 55, 15);
		skill3Level.setText("99/99");

		skill3Experience = new Label(shell, SWT.NONE);
		skill3Experience.setBounds(484, 227, 55, 15);
		skill3Experience.setText("10000000");

		skill4Level = new Label(shell, SWT.NONE);
		skill4Level.setBounds(404, 258, 55, 15);
		skill4Level.setText("99/99");

		skill4Experience = new Label(shell, SWT.NONE);
		skill4Experience.setBounds(484, 258, 55, 15);
		skill4Experience.setText("10000000");

		skill5Level = new Label(shell, SWT.NONE);
		skill5Level.setBounds(404, 287, 55, 15);
		skill5Level.setText("99/99");

		skill5Experience = new Label(shell, SWT.NONE);
		skill5Experience.setBounds(484, 285, 55, 15);
		skill5Experience.setText("10000000");

		skill6Level = new Label(shell, SWT.NONE);
		skill6Level.setBounds(404, 315, 55, 15);
		skill6Level.setText("99/99");

		skill6Experience = new Label(shell, SWT.NONE);
		skill6Experience.setBounds(484, 315, 55, 15);
		skill6Experience.setText("10000000");

		skill7Level = new Label(shell, SWT.NONE);
		skill7Level.setBounds(404, 344, 55, 15);
		skill7Level.setText("99/99");

		skill7Experience = new Label(shell, SWT.NONE);
		skill7Experience.setBounds(484, 344, 55, 15);
		skill7Experience.setText("10000000");

		skill8Level = new Label(shell, SWT.NONE);
		skill8Level.setBounds(404, 372, 55, 15);
		skill8Level.setText("99/99");

		skill8Experience = new Label(shell, SWT.NONE);
		skill8Experience.setBounds(484, 372, 55, 15);
		skill8Experience.setText("10000000");

		skill9Level = new Label(shell, SWT.NONE);
		skill9Level.setBounds(404, 400, 55, 15);
		skill9Level.setText("99/99");

		skill9Experience = new Label(shell, SWT.NONE);
		skill9Experience.setBounds(484, 400, 55, 15);
		skill9Experience.setText("10000000");

		skill10Level = new Label(shell, SWT.NONE);
		skill10Level.setBounds(404, 427, 55, 15);
		skill10Level.setText("99/99");

		skill10Experience = new Label(shell, SWT.NONE);
		skill10Experience.setBounds(484, 427, 55, 15);
		skill10Experience.setText("10000000");

		skill11Level = new Label(shell, SWT.NONE);
		skill11Level.setBounds(404, 452, 55, 15);
		skill11Level.setText("99/99");

		skill11Experience = new Label(shell, SWT.NONE);
		skill11Experience.setBounds(484, 452, 55, 15);
		skill11Experience.setText("10000000");

		skill12Level = new Label(shell, SWT.NONE);
		skill12Level.setBounds(404, 477, 55, 15);
		skill12Level.setText("99/99");

		skill12Experience = new Label(shell, SWT.NONE);
		skill12Experience.setBounds(484, 477, 55, 15);
		skill12Experience.setText("10000000");

		skill13Level = new Label(shell, SWT.NONE);
		skill13Level.setBounds(404, 506, 55, 15);
		skill13Level.setText("99/99");

		skill13Experience = new Label(shell, SWT.NONE);
		skill13Experience.setBounds(484, 506, 55, 15);
		skill13Experience.setText("10000000");

		skill14Level = new Label(shell, SWT.NONE);
		skill14Level.setBounds(404, 537, 55, 15);
		skill14Level.setText("99/99");

		skill14Experience = new Label(shell, SWT.NONE);
		skill14Experience.setBounds(484, 537, 55, 15);
		skill14Experience.setText("10000000");

		skill15Level = new Label(shell, SWT.NONE);
		skill15Level.setBounds(404, 568, 55, 15);
		skill15Level.setText("99/99");

		skill15Experience = new Label(shell, SWT.NONE);
		skill15Experience.setBounds(484, 568, 55, 15);
		skill15Experience.setText("10000000");

		skill16Level = new Label(shell, SWT.NONE);
		skill16Level.setBounds(404, 595, 55, 15);
		skill16Level.setText("99/99");

		skill16Experience = new Label(shell, SWT.NONE);
		skill16Experience.setBounds(484, 591, 55, 15);
		skill16Experience.setText("10000000");

		skill17Level = new Label(shell, SWT.NONE);
		skill17Level.setBounds(404, 616, 55, 15);
		skill17Level.setText("99/99");

		skill17Experience = new Label(shell, SWT.NONE);
		skill17Experience.setBounds(484, 616, 55, 15);
		skill17Experience.setText("10000000");

		skill18Level = new Label(shell, SWT.NONE);
		skill18Level.setBounds(404, 639, 55, 15);
		skill18Level.setText("99/99");

		skill18Experience = new Label(shell, SWT.NONE);
		skill18Experience.setBounds(484, 639, 55, 15);
		skill18Experience.setText("10000000");

		skill19Level = new Label(shell, SWT.NONE);
		skill19Level.setBounds(404, 662, 55, 15);
		skill19Level.setText("99/99");

		skill19Experience = new Label(shell, SWT.NONE);
		skill19Experience.setBounds(484, 662, 55, 15);
		skill19Experience.setText("10000000");

		skill20Level = new Label(shell, SWT.NONE);
		skill20Level.setBounds(404, 685, 55, 15);
		skill20Level.setText("99/99");

		skill20Experience = new Label(shell, SWT.NONE);
		skill20Experience.setBounds(484, 685, 55, 15);
		skill20Experience.setText("10000000");

		skill21Level = new Label(shell, SWT.NONE);
		skill21Level.setBounds(404, 708, 55, 15);
		skill21Level.setText("99/99");

		skill21Experience = new Label(shell, SWT.NONE);
		skill21Experience.setBounds(484, 708, 55, 15);
		skill21Experience.setText("10000000");

		skill22Level = new Label(shell, SWT.NONE);
		skill22Level.setBounds(404, 731, 55, 15);
		skill22Level.setText("99/99");

		skill22Experience = new Label(shell, SWT.NONE);
		skill22Experience.setBounds(484, 731, 55, 15);
		skill22Experience.setText("10000000");

		progressBar_16 = new ProgressBar(shell, SWT.NONE);
		progressBar_16.setState(1);
		progressBar_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_16);
			}
		});
		progressBar_16.setBounds(551, 591, 170, 17);
		
		progressBar_0 = new ProgressBar(shell, SWT.NONE);
		progressBar_0.setState(1);
		progressBar_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_0);
			}
		});
		progressBar_0.setBounds(551, 136, 170, 17);
		
		progressBar_1 = new ProgressBar(shell, SWT.NONE);
		progressBar_1.setState(1);
		progressBar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_1);
			}
		});
		progressBar_1.setBounds(551, 167, 170, 17);
		
		progressBar_2 = new ProgressBar(shell, SWT.NONE);
		progressBar_2.setState(1);
		progressBar_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_2);

			}
		});
		progressBar_2.setBounds(551, 196, 170, 17);
		
		progressBar_3 = new ProgressBar(shell, SWT.NONE);
		progressBar_3.setState(1);
		progressBar_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_3);
			}
		});
		progressBar_3.setBounds(551, 227, 170, 17);
		
		progressBar_4 = new ProgressBar(shell, SWT.NONE);
		progressBar_4.setState(1);
		progressBar_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_4);
			}
		});
		progressBar_4.setBounds(551, 258, 170, 17);
		
		progressBar_5 = new ProgressBar(shell, SWT.NONE);
		progressBar_5.setState(1);
		progressBar_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_5);
			}
		});
		progressBar_5.setBounds(551, 285, 170, 17);
		
		progressBar_6 = new ProgressBar(shell, SWT.NONE);
		progressBar_6.setState(1);
		progressBar_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_6);
			}
		});
		progressBar_6.setBounds(551, 315, 170, 17);
		
		progressBar_7 = new ProgressBar(shell, SWT.NONE);
		progressBar_7.setState(1);
		progressBar_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_7);
			}
		});
		progressBar_7.setBounds(551, 344, 170, 17);
		
		progressBar_8 = new ProgressBar(shell, SWT.NONE);
		progressBar_8.setState(1);
		progressBar_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_8);

			}
		});
		progressBar_8.setBounds(551, 372, 170, 17);
		
		progressBar_9 = new ProgressBar(shell, SWT.NONE);
		progressBar_9.setState(1);
		progressBar_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_9);

			}
		});
		progressBar_9.setBounds(551, 400, 170, 17);
		
		progressBar_10 = new ProgressBar(shell, SWT.NONE);
		progressBar_10.setState(1);
		progressBar_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_10);
			}
		});
		progressBar_10.setBounds(551, 427, 170, 17);
		
		progressBar_11 = new ProgressBar(shell, SWT.NONE);
		progressBar_11.setState(1);
		progressBar_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_11);
			}
		});
		progressBar_11.setBounds(551, 452, 170, 17);
		
		progressBar_12 = new ProgressBar(shell, SWT.NONE);
		progressBar_12.setState(1);
		progressBar_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_12);
			}
		});
		progressBar_12.setBounds(551, 475, 170, 17);
		
		progressBar_13 = new ProgressBar(shell, SWT.NONE);
		progressBar_13.setState(1);
		progressBar_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_13);
			}
		});
		progressBar_13.setBounds(551, 506, 170, 17);
		
		progressBar_14 = new ProgressBar(shell, SWT.NONE);
		progressBar_14.setState(1);
		progressBar_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_14);
			}
		});
		progressBar_14.setBounds(551, 535, 170, 17);
		
		progressBar_15 = new ProgressBar(shell, SWT.NONE);
		progressBar_15.setState(1);
		progressBar_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_15);
			}
		});
		progressBar_15.setBounds(551, 568, 170, 17);
		
		progressBar_17 = new ProgressBar(shell, SWT.NONE);
		progressBar_17.setState(1);
		progressBar_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_17);
			}
		});
		progressBar_17.setBounds(551, 614, 170, 17);
		
		progressBar_18 = new ProgressBar(shell, SWT.NONE);
		progressBar_18.setState(1);
		progressBar_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_18);
			}
		});
		progressBar_18.setBounds(551, 637, 170, 17);
		
		progressBar_19 = new ProgressBar(shell, SWT.NONE);
		progressBar_19.setState(1);
		progressBar_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_19);
			}
		});
		progressBar_19.setBounds(551, 662, 170, 17);
		
		progressBar_20 = new ProgressBar(shell, SWT.NONE);
		progressBar_20.setState(1);
		progressBar_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_20);
			}
		});
		progressBar_20.setBounds(551, 683, 170, 17);
		
		progressBar_21 = new ProgressBar(shell, SWT.NONE);
		progressBar_21.setState(1);
		progressBar_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_21);
			}
		});
		progressBar_21.setBounds(551, 706, 170, 17);
		
		progressBar_22 = new ProgressBar(shell, SWT.NONE);
		progressBar_22.setState(1);
		progressBar_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				switchPbarState(progressBar_22);
			}
		});
		progressBar_22.setBounds(551, 729, 170, 17);
		
		lblGgg = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblGgg.setText("ggg");
		lblGgg.setBounds(306, 159, 434, 2);
		
		label_23 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_23.setText("ggg");
		label_23.setBounds(306, 188, 434, 2);
		
		label_24 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_24.setText("ggg");
		label_24.setBounds(306, 219, 434, 2);
		
		label_25 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_25.setText("ggg");
		label_25.setBounds(306, 250, 434, 2);
		
		label_26 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_26.setText("ggg");
		label_26.setBounds(306, 279, 434, 2);
		
		label_27 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_27.setText("ggg");
		label_27.setBounds(306, 308, 434, 2);
		
		label_28 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_28.setText("ggg");
		label_28.setBounds(306, 336, 434, 2);
		
		label_29 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_29.setText("ggg");
		label_29.setBounds(306, 365, 434, 2);
		
		label_30 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_30.setText("ggg");
		label_30.setBounds(306, 393, 434, 2);
		
		label_31 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_31.setText("ggg");
		label_31.setBounds(306, 421, 434, 2);
		
		label_32 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_32.setText("ggg");
		label_32.setBounds(306, 448, 434, 2);
		
		label_33 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_33.setText("ggg");
		label_33.setBounds(306, 473, 434, 2);
		
		label_34 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_34.setText("ggg");
		label_34.setBounds(306, 498, 434, 2);
		
		label_35 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_35.setText("ggg");
		label_35.setBounds(306, 527, 434, 2);
		
		label_36 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_36.setText("ggg");
		label_36.setBounds(306, 558, 434, 2);
		
		label_37 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_37.setText("ggg");
		label_37.setBounds(306, 589, 434, 2);
		
		label_38 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_38.setText("ggg");
		label_38.setBounds(306, 612, 434, 2);
		
		label_39 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_39.setText("ggg");
		label_39.setBounds(306, 637, 434, 2);
		
		label_40 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_40.setText("ggg");
		label_40.setBounds(306, 660, 434, 2);
		
		label_41 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_41.setText("ggg");
		label_41.setBounds(306, 683, 434, 2);
		
		label_42 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_42.setText("ggg");
		label_42.setBounds(306, 706, 434, 2);
		
		label_43 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_43.setText("ggg");
		label_43.setBounds(316, 729, 434, 2);

	}

	public static void updateValues() {
		if (lblWeightdata != null) {
			lblWeightdata.setText("" + weight);
			lblEnergydata.setText("" + energy);
			lblWorld.setText("" + world);
			String[] lvls = Util.intArraytoString(levels);
			String[] xp = Util.intArraytoString(experiences);
			skill0Level.setText(lvls[0]);
			skill0Experience.setText(xp[0]);
			skill1Level.setText(lvls[1]);
			skill1Experience.setText(xp[1]);
			skill2Level.setText(lvls[2]);
			skill2Experience.setText(xp[2]);
			skill3Level.setText(lvls[3]);
			skill3Experience.setText(xp[3]);
			skill4Level.setText(lvls[4]);
			skill4Experience.setText(xp[4]);
			skill5Level.setText(lvls[5]);
			skill5Experience.setText(xp[5]);
			skill6Level.setText(lvls[6]);
			skill6Experience.setText(xp[6]);
			skill7Level.setText(lvls[7]);
			skill7Experience.setText(xp[7]);
			skill8Level.setText(lvls[8]);
			skill8Experience.setText(xp[8]);
			skill9Level.setText(lvls[9]);
			skill9Experience.setText(xp[9]);
			skill10Level.setText(lvls[10]);
			skill10Experience.setText(xp[10]);
			skill11Level.setText(lvls[11]);
			skill11Experience.setText(xp[11]);
			skill12Level.setText(lvls[12]);
			skill12Experience.setText(xp[12]);
			skill13Level.setText(lvls[13]);
			skill13Experience.setText(xp[13]);
			skill14Level.setText(lvls[14]);
			skill14Experience.setText(xp[14]);
			skill15Level.setText(lvls[15]);
			skill15Experience.setText(xp[15]);
			skill16Level.setText(lvls[16]);
			skill16Experience.setText(xp[16]);
			skill17Level.setText(lvls[17]);
			skill17Experience.setText(xp[17]);
			skill18Level.setText(lvls[18]);
			skill18Experience.setText(xp[18]);
			skill19Level.setText(lvls[19]);
			skill19Experience.setText(xp[19]);
			skill20Level.setText(lvls[20]);
			skill20Experience.setText(xp[20]);
			skill21Level.setText(lvls[21]);
			skill21Experience.setText(xp[21]);
			skill22Level.setText(lvls[22]);
			skill22Experience.setText(xp[22]);
			progressBar_0.setMaximum(makePbarMax(0));
			progressBar_0.setSelection(makePbarSelection(0));
			progressBar_1.setMaximum(makePbarMax(1));
			progressBar_1.setSelection(makePbarSelection(1));
			progressBar_2.setMaximum(makePbarMax(2));
			progressBar_2.setSelection(makePbarSelection(2));
			progressBar_3.setMaximum(makePbarMax(3));
			progressBar_3.setSelection(makePbarSelection(3));
			progressBar_4.setMaximum(makePbarMax(4));
			progressBar_4.setSelection(makePbarSelection(4));
			progressBar_5.setMaximum(makePbarMax(5));
			progressBar_5.setSelection(makePbarSelection(5));
			progressBar_6.setMaximum(makePbarMax(6));
			progressBar_6.setSelection(makePbarSelection(6));
			progressBar_7.setMaximum(makePbarMax(7));
			progressBar_7.setSelection(makePbarSelection(7));
			progressBar_8.setMaximum(makePbarMax(8));
			progressBar_8.setSelection(makePbarSelection(8));
			progressBar_9.setMaximum(makePbarMax(9));
			progressBar_9.setSelection(makePbarSelection(9));
			progressBar_10.setMaximum(makePbarMax(10));
			progressBar_10.setSelection(makePbarSelection(10));
			progressBar_11.setMaximum(makePbarMax(11));
			progressBar_11.setSelection(makePbarSelection(11));
			progressBar_12.setMaximum(makePbarMax(12));
			progressBar_12.setSelection(makePbarSelection(12));
			progressBar_13.setMaximum(makePbarMax(13));
			progressBar_13.setSelection(makePbarSelection(13));
			progressBar_14.setMaximum(makePbarMax(14));
			progressBar_14.setSelection(makePbarSelection(14));
			progressBar_15.setMaximum(makePbarMax(15));
			progressBar_15.setSelection(makePbarSelection(15));
			progressBar_16.setMaximum(makePbarMax(16));
			progressBar_16.setSelection(makePbarSelection(16));
			progressBar_17.setMaximum(makePbarMax(17));
			progressBar_17.setSelection(makePbarSelection(17));
			progressBar_18.setMaximum(makePbarMax(18));
			progressBar_18.setSelection(makePbarSelection(18));
			progressBar_19.setMaximum(makePbarMax(19));
			progressBar_19.setSelection(makePbarSelection(19));
			progressBar_20.setMaximum(makePbarMax(20));
			progressBar_20.setSelection(makePbarSelection(20));
			progressBar_21.setMaximum(makePbarMax(21));
			progressBar_21.setSelection(makePbarSelection(21));
			progressBar_22.setMaximum(makePbarMax(22));
			progressBar_22.setSelection(makePbarSelection(22));
			

		}
	}
	
	public static void switchPbarState(ProgressBar p) {
		if (p.getState()==1) {
			p.setState(0);
		}
		else {
			p.setState(1);
		}
	}
	
	public static int makePbarMax(int skill) {
		return (Util.getXPforNextLevel(levels[skill])-Util.getXPforCurrentLevel(levels[skill]));
	}
	
	public static int makePbarSelection(int skill) {
		return (experiences[skill]-Util.getXPforCurrentLevel(levels[skill]));
	}
}
