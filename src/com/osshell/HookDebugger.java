package com.osshell;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class HookDebugger {
	
	public static Label lblWeightdata;
	public static Label lblEnergydata; 
	public static Label lblWorld;
	public static int world = -1;
	public static int energy = -1;
	public static int weight = -1;
	public static long lastForcedRedraw = System.currentTimeMillis();
	public static long nextForcedRedraw = lastForcedRedraw+=1000;
	public static boolean woke = false;

	protected Shell shell = new Shell();

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main() {
		try {
			HookDebugger window = new HookDebugger();
			window.open();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
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
				if (woke==false) {
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
				if (woke==true) {
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
		shell.setSize(217, 155);
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
		lblWeightdata.setText(""+weight);
		
		lblEnergydata = new Label(shell, SWT.NONE);
		lblEnergydata.setBounds(136, 69, 55, 15);
		lblEnergydata.setText(""+energy);
		
		lblWorld = new Label(shell, SWT.NONE);
		lblWorld.setBounds(136, 90, 55, 15);
		lblWorld.setText(""+world);

	}
	
	public static void updateValues() {
		if (lblWeightdata!=null) {
			lblWeightdata.setText(""+weight);
			lblEnergydata.setText(""+energy);
			lblWorld.setText(""+world);
		}
	}
}
