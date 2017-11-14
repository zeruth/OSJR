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
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			updateValues();
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {

		shell = new Shell();
		shell.setSize(739, 613);
		shell.setText("SWT Application");

		
		Label lblHooks = new Label(shell, SWT.NONE);
		lblHooks.setBounds(340, 10, 55, 15);
		lblHooks.setText("Hooks");
		
		Label lblClient = new Label(shell, SWT.NONE);
		lblClient.setBounds(48, 27, 55, 15);
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
		lblWeightdata.setBounds(91, 48, 55, 15);
		lblWeightdata.setText(""+weight);
		
		lblEnergydata = new Label(shell, SWT.NONE);
		lblEnergydata.setBounds(91, 69, 55, 15);
		lblEnergydata.setText(""+energy);
		
		lblWorld = new Label(shell, SWT.NONE);
		lblWorld.setBounds(101, 90, 55, 15);
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
