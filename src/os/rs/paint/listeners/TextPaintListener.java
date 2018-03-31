package os.rs.paint.listeners;

import java.util.EventListener;

/**
 * Created by IntelliJ IDEA. User: Jan Ove / Kosaki Date: 23.apr.2009 Time:
 * 20:09:07
 */
public interface TextPaintListener extends EventListener {
	/**
	 * Gets called on each repaint.
	 * 
	 * @return array of strings to paint. 1 per line.
	 */
	public abstract String[] onTextRepaint();
}
