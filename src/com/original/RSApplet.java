package com.original;
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import javax.swing.*;

import com.osshell.util.Util;

import rsreflection.Reflector;


public class RSApplet extends JFrame implements AppletStub{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//insane declarations
    public enum Game{OSRS, RS3, CLASSIC};
    public static final HashMap<String, String> Parameters = new HashMap<String, String>();
    public Game game;
    public static URL GamePack;
    private static Applet applet;
    public static String gameUrl;
    public static String MClass;
    public Reflector loader;

    public RSApplet()
    {
        Color bgColor = new Color(0x2B2B2B);
        setTitle("OSLight v1.2");
        setSize(781, 543);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(bgColor);

            // Loading GUI

        try {
            Util.GetParams(new URL(gameUrl));


            loader  = new Reflector(new URL[]{new File(System.getProperty("user.home") + "/OSLite/gamepack.jar").toURI().toURL()});

            applet = (Applet)loader.loadClass(MClass).newInstance();
            applet.setSize(781, 543); //fixes game crash.
            applet.setPreferredSize(new Dimension(768, 528));
            applet.setStub(this);
            applet.init();
            applet.start();
            JPopupMenu.setDefaultLightWeightPopupEnabled(false);
            add(applet);
        } catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
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

    public static void main(String[] args) {
        new RSApplet();
    }


}