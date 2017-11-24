package os.jr.boot;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import os.jr.game.Reflector;
import os.jr.hooks.Client;
import os.jr.hooks.Node;
import os.jr.hooks.model.GameField;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Test {

	protected static Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main() {
		if (Boot.outdated) {
			try {
				Test window = new Test();
				window.open();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
			private Client client;
			private Node node;

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				try {
					client = new Client(Boot.rootReference);
					node = new Node();
					System.out.println("Works? "+client.getFieldValue(client.CLIENT_ENERGY, null));
					client.getFieldValue(client.CLIENT_ENERGY, null);
					for (GameField gf : client.allFields.values()) {
						System.out.println(gf.fieldName);
					}
					for (GameField gf : node.allFields.values()) {
						System.out.println(gf.fieldName);
					}				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*
				 * I use to test code.
				 * 
				 */ catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnDoIt.setBounds(191, 226, 75, 25);
		btnDoIt.setText("Do it");

	}
}
