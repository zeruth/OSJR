package paint;

import java.awt.Graphics;
import java.awt.RenderingHints;

import hooks.Hooks;
import hooks.helpers.SkillGlobe;

public class XpGlobe implements PaintListener {

	RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
			RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

	@Override
	public void onRepaint(Graphics g) {
		if (Hooks.client.isLoggedIn())
			if (SkillGlobe.activeSkillGlobe != null) {
				SkillGlobe.activeSkillGlobe.paint(g);
			}
	}

}
