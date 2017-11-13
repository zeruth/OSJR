package com.osshell;

import com.osshell.settings.Settings;
import com.osshell.settings.SettingsIo;
import com.osshell.util.Util;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class Loader {

  protected Shell shell;
  public static URL GamePack;
  public static String gameUrl = "http://oldschool6.runescape.com/";
  public static Settings s;
  public static boolean init = false;
  public static boolean downloadRequired = false;
  public static String newPercentage = "";
  public static int progress = 0;
  private static ProgressBar progressBar;

  Thread download = new Thread(new Runnable() {

    @Override
    public void run() {
      if (s.gamePackSize == -1 || s.gamePackSize != Util.getFileSize(RsApplet.GamePack)
          || Util.checkLocalGamePack() != Util.getFileSize(RsApplet.GamePack)) {
        try {
          Util.downloadGamePack();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      init = true;
    }
  });

  /**
   * main - Entry point for OS-Lite.
   * @param args = Launch parameters.
   */
  public static void main(String[] args) {
    try {
      Util.getParams(new URL(gameUrl));
      if (!SettingsIo.file.exists()) {
        SettingsIo.createBlankDb();
      }
      s = SettingsIo.loadSettings();
      Loader window = new Loader();
      window.open();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
  * open - Checks for gamepack update then calls a new RSApplet.
  * @throws MalformedURLException = Incorrect URL.
  * @throws IOException = Various I/O causes.
 * @throws SecurityException 
 * @throws NoSuchFieldException 
  */
  public void open() throws MalformedURLException, IOException, NoSuchFieldException, SecurityException {
    Display display = Display.getDefault();
    createContents();

    if (s.gamePackSize == -1 || s.gamePackSize != Util.getFileSize(RsApplet.GamePack)
        || Util.checkLocalGamePack() != Util.getFileSize(RsApplet.GamePack)) {
      shell.open();
      shell.layout();
      downloadRequired = true;
    } else {
      init = true;
    }

    boolean downloadStarted = false;
    while (!shell.isDisposed() && !init) {
      setPercentage("" + progress);
      if (!downloadStarted && downloadRequired) {
        download.start();
        downloadStarted = true;
      }
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    shell.close();
    new RsApplet();
    HookDebugger.main();
  }

  /**
   * createContents - Creates download window contents.
   */
  protected void createContents() {
    shell = new Shell();
    shell.setSize(206, 96);
    shell.setText("OS Shell 0.1");
    Label lblDownloadingGamepack = new Label(shell, SWT.NONE);
    lblDownloadingGamepack.setAlignment(SWT.CENTER);
    lblDownloadingGamepack.setBounds(10, 10, 170, 15);
    lblDownloadingGamepack.setText("Downloading Gamepack update");
    progressBar = new ProgressBar(shell, SWT.SMOOTH);
    progressBar.setState(1);
    progressBar.setBounds(10, 31, 170, 17);
  }

  /**
   * setPercentage - Sets download bar progress.
   * @param percentage - Percentage of progress represented as a String.
   */
  public static void setPercentage(String percentage) {
    progressBar.setSelection(Integer.valueOf(percentage));
  }
}
