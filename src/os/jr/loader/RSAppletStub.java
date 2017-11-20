package os.jr.loader;

import java.applet.AppletContext;
import java.applet.AppletStub;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import os.jr.utils.Utils;

public class RSAppletStub implements AppletStub {

	private String link = "http://oldschool9.runescape.com/";
	public static HashMap<String, String> parameters = new HashMap<String, String>();

	public RSAppletStub() {

	}

	@Override
	public boolean isActive() {
		return true;
	}

	@Override
	public URL getDocumentBase() {
		return getCodeBase();
	}

	@Override
	public URL getCodeBase() {
		try {
			return new URL(link);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getParameter(String name) {
		return parameters.get(name);
	}

	@Override
	public AppletContext getAppletContext() {
		return null;
	}

	@Override
	public void appletResize(int width, int height) {

	}

	public String getLink() {
		return link;
	}
}
