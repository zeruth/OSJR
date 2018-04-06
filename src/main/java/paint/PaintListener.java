package paint;

import java.awt.Graphics;
import java.util.EventListener;

/**
 * Created by IntelliJ IDEA. User: Jan Ove / Kosaki Date: 19.mar.2009 Time:
 * 17:04:48
 */
public interface PaintListener extends EventListener {
	/**
	 * Gets called on each repaint. This at default 50 times a second so try not to
	 * do anything resource intensive.
	 * 
	 * @param g
	 *            instance of the graphics object to paint on
	 */
	public abstract void onRepaint(Graphics g);
}
