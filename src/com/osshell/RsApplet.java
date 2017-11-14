package com.osshell;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import com.osshell.util.reflection.RSHooks;
import com.osshell.util.reflection.Reflector;

public class RsApplet extends JFrame implements AppletStub {
  private static final long serialVersionUID = 1L;
  public static final HashMap<String, String> Parameters = new HashMap<String, String>();
  public static URL GamePack;
  private static Applet applet;
  public static String gameUrl;
  public static String MClass;
  public static Reflector loader;
  public static Object clientBootClass = null;
  
  public static Thread updateHookData = new Thread(new Runnable() {
	
	@Override
	public void run() {
		while (true!=false) { //Hopefully a long time boys.
			
			try {
				RSHooks.updateHooks();
				Thread.sleep(100);
			} catch (InterruptedException | IllegalArgumentException | IllegalAccessException 
					| NoSuchFieldException | SecurityException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
});

  /**
   * RsApplet - Instance of the RSApplet window.
 * @throws SecurityException 
 * @throws NoSuchFieldException 
   */
  public RsApplet() throws NoSuchFieldException, SecurityException {
    setTitle("OS-Lite 1.0");
    setSize(781, 543);
    setResizable(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    try {
      
      loader  = new Reflector(new URL[]
      {new File(System.getProperty("user.home") + "/OSLite/gamepack.jar")
      .toURI().toURL()});
      RSHooks.setHooks();
      updateHookData.start();
      
      clientBootClass = loader.loadClass(MClass).newInstance();
      applet = (Applet)clientBootClass;
      applet.setSize(781, 543); //fixes game crash.
      applet.setPreferredSize(new Dimension(768, 528));
      applet.setStub(this);
      applet.init();
      applet.start();
      JPopupMenu.setDefaultLightWeightPopupEnabled(false);
      add(applet);
    } catch (
    IOException | InstantiationException 
      | IllegalAccessException | ClassNotFoundException e1) {
      e1.printStackTrace();
    }
    setVisible(true);
  }

  @Override
  public void appletResize(int arg0, int arg1) {
  }

  @Override
  public AppletContext getAppletContext() {
    return null;
  }

  @Override
  public URL getCodeBase() {
    try {
      return new URL("http://oldschool6.runescape.com/");
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public URL getDocumentBase() {
    try {
      return new URL("http://oldschool6.runescape.com/");
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public String getParameter(String arg0) {
    return Parameters.get(arg0);
  }

  @Override
  public boolean isActive() {
    return false;
  }
}