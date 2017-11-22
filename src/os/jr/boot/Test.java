package os.jr.boot;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import os.jr.game.Reflector;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Test {

	protected static Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main() {
		try {
			Test window = new Test();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnDoIt = new Button(shell, SWT.NONE);
		btnDoIt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				System.out.println("ls "+Reflector.getClient().getLocalPlayer().getCombatInfoList().getHead());
				/*
					I use to test code.
					
			      */
			}
		});
		btnDoIt.setBounds(191, 226, 75, 25);
		btnDoIt.setText("Do it");

	}
}
