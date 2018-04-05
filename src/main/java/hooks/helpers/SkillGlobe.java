package hooks.helpers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

import game.LoaderWindow;
import game.OSRSLauncher;
import hooks.Hooks;

public class SkillGlobe {
	
	public static SkillGlobe activeSkillGlobe;
	
	public int skillID;
	private Color fillColor;
	private Color outlineColor;
	private Graphics2D g2;
	
	public SkillGlobe(int skillID) {
		this.skillID = skillID;
	}
	
	public void paint(Graphics g) {
		this.g2 = (Graphics2D) g;
		this.fillColor = ObjectManager.fillColor;
		this.outlineColor = ObjectManager.outlineColor;

		if (OSRSLauncher.loaderWindow.getWidth() <= 850) {
			RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			int radiusX = 50;
			int centerX = ((OSRSLauncher.loaderWindow.getWidth() - (radiusX)) / 2) - 50;
			int centerY = 5;
			int radiusYY = 50;
			int startAngle = 90;
			Shape circle = new Ellipse2D.Double(centerX, centerY, radiusYY, radiusX);
			Graphics2D g22 = (Graphics2D) g;
			g.setColor(Color.DARK_GRAY.darker());
			g22.setRenderingHints(rh);
			g22.setStroke(new BasicStroke(3));
			g22.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 15));
			g22.setColor(this.fillColor);
			RoundRectangle2D skillBackdrop = new RoundRectangle2D.Double(centerX-32, centerY+10, 40, 30, 10, 10);
			g22.setColor(Color.DARK_GRAY.darker());
			g22.draw(skillBackdrop);
			g22.fill(skillBackdrop);
			g22.draw(circle);
			g22.setColor(this.fillColor);
			g22.fill(skillBackdrop);
			g22.setColor(Color.DARK_GRAY.darker());
			g22.fill(circle);
			g22.setColor(this.fillColor);

			g22.fill(circle);
			String skillName = Skill.getNameForID(this.skillID);
			if (skillName!=null)
			try (InputStream is = new FileInputStream("./resources/skill_icons/" +skillName + ".png")){
				Image skillIcon = ImageIO.read(is);
				is.close();
				this.g2.drawImage(skillIcon, centerX - 29, centerY + 13, LoaderWindow.game);
			} catch (Exception e) {
				e.printStackTrace();
			}
			g.setColor(this.outlineColor);
			int lvl = Hooks.client.getRealSkillLevels()[this.skillID];
			double percentage = Skill.getLevelUpPercentage(this.skillID);
			DecimalFormat df = new DecimalFormat("##.##");
			g22.drawString(Integer.toString(lvl), centerX + 16, 20);
			String s = (String) "-" + (int) ((percentage / 100) * 360);
			int length = Integer.valueOf(s);
			g22.drawArc(centerX, centerY, radiusX, radiusYY, startAngle, length);
			g22.setFont(new Font("TimesRoman", Font.PLAIN, 24));
			String i = String.valueOf((int) percentage);
			if ((int) percentage < 10) {
				i = "0" + i;
			}
			g22.drawString("" + i, centerX + 6, 40);
			g22.setFont(new Font("TimesRoman", Font.BOLD, 14));
			String percentage2 = "";
			if (df.format(percentage).split("\\.").length == 2) {
				percentage2 = df.format(percentage).split("\\.")[1];
				if (percentage2.length() == 1)
					percentage2 = percentage2 + 0;
			} else {
				percentage2 = "00";
			}
			g22.drawString("." + percentage2, centerX + 28, 40);
			g.setColor(this.fillColor);
			g22.setStroke(new BasicStroke());
		} else {
			RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			int radiusX = 50;
			int centerX = ((OSRSLauncher.loaderWindow.getWidth() - (radiusX)) / 2);
			int centerY = 5;
			int radiusYY = 50;
			int startAngle = 90;
			Shape circle = new Ellipse2D.Double(centerX, centerY, radiusYY, radiusX);
			Graphics2D g22 = (Graphics2D) g;
			g.setColor(Color.DARK_GRAY.darker());
			g22.setRenderingHints(rh);
			g22.setStroke(new BasicStroke(3));
			g22.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 15));
			g22.setColor(this.fillColor);
			RoundRectangle2D skillBackdrop = new RoundRectangle2D.Double(centerX-32, centerY+10, 40, 30, 10, 10);
			g22.setColor(Color.DARK_GRAY.darker());
			g22.draw(skillBackdrop);
			g22.fill(skillBackdrop);
			g22.draw(circle);
			g22.setColor(this.fillColor);
			g22.fill(skillBackdrop);
			g22.setColor(Color.DARK_GRAY.darker());
			g22.fill(circle);
			g22.setColor(this.fillColor);

			g22.fill(circle);
			String skillName = Skill.getNameForID(this.skillID);
			if (skillName!=null)
			try (InputStream is = new FileInputStream("./resources/skill_icons/" +skillName + ".png")){
				Image skillIcon = ImageIO.read(is);
				is.close();
				this.g2.drawImage(skillIcon, centerX - 29, centerY + 13, LoaderWindow.game);
			} catch (Exception e) {
				e.printStackTrace();
			}
			g.setColor(this.outlineColor);
			int lvl = Hooks.client.getRealSkillLevels()[this.skillID];
			double percentage = Skill.getLevelUpPercentage(this.skillID);
			DecimalFormat df = new DecimalFormat("##.##");
			g22.drawString(Integer.toString(lvl), centerX + 16, 20);
			String s = (String) "-" + (int) ((percentage / 100) * 360);
			int length = Integer.valueOf(s);
			g22.drawArc(centerX, centerY, radiusX, radiusYY, startAngle, length);
			g22.setFont(new Font("TimesRoman", Font.PLAIN, 24));
			String i = String.valueOf((int) percentage);
			if ((int) percentage < 10) {
				i = "0" + i;
			}
			g22.drawString("" + i, centerX + 6, 40);
			g22.setFont(new Font("TimesRoman", Font.BOLD, 14));
			String percentage2 = "";
			if (df.format(percentage).split("\\.").length == 2) {
				percentage2 = df.format(percentage).split("\\.")[1];
				if (percentage2.length() == 1)
					percentage2 = percentage2 + 0;
			} else {
				percentage2 = "00";
			}
			g22.drawString("." + percentage2, centerX + 28, 40);
			g.setColor(this.fillColor);
			g22.setStroke(new BasicStroke());
		}
	}

}
