package os.jr.hooks;

import java.awt.Component;
import java.awt.Image;

import os.jr.hooks.loader.RSClass;

public class MainBufferProvider extends RSClass {
	
	public static final String component = "component";
	public static final String image = "image";

	public MainBufferProvider() {
		super(Hooks.classNames.get("MainBufferProvider"));
	}
	
	public Component getComponent() {
		return (Component) getField(component).getValue(reference);
	}
	
	public Image getImage() {
		return (Image) getField(image).getValue(reference);
	}

}
