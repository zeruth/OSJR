package paint;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;

import hooks.helpers.ObjectManager;
import paint.listeners.ActorNames;

public class ColorChooserApplet extends Applet implements AdjustmentListener {
	
	public Color oldColor;
	
	int r = 100;      // The RGB color components.

	int g = 0;

	int b = 0;
	   
	   public ColorChooserApplet(Color c) {
		   this.oldColor = c;
		   this.r = c.getRed();
		   this.g = c.getGreen();
		   this.b = c.getBlue();
	   }

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private float[] hsb = new float[3];   // For holding HSB color components.
   
   
   private Scrollbar hueScroll, brightnessScroll, saturationScroll,  // Scroll bars.
                     redScroll, greenScroll, blueScroll;
   
   private Label hueLabel, brightnessLabel, saturationLabel,  // Display component values.
                 redLabel, greenLabel, blueLabel;
                 
   private Canvas colorCanvas;  // Color patch for displaying the color.
   
   public JButton confirm = new JButton("Confirm");
                 
   @Override
public void init() {
	   
	   this.confirm.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Color newColor = new Color(ColorChooserApplet.this.r, ColorChooserApplet.this.g, ColorChooserApplet.this.b);
			if (ColorChooserApplet.this.oldColor.equals(ObjectManager.outlineColor)) {
				ObjectManager.outlineColor = newColor;
				ColorChooserApplet.this.oldColor = newColor;
			} else if (ColorChooserApplet.this.oldColor.equals(ObjectManager.fillColor)) {
				Color newC = new Color(newColor.getRed(), newColor.getGreen(), newColor.getBlue(), 50);
				ObjectManager.fillColor = newC;
				ColorChooserApplet.this.oldColor = newC;
			} else if (ColorChooserApplet.this.oldColor.equals(ActorNames.npcNameColor)) {
				Color newC = new Color(newColor.getRed(), newColor.getGreen(), newColor.getBlue());
				ActorNames.npcNameColor = newC;
				ColorChooserApplet.this.oldColor = newC;
			} else if (ColorChooserApplet.this.oldColor.equals(ActorNames.playerNameColor)) {
				Color newC = new Color(newColor.getRed(), newColor.getGreen(), newColor.getBlue());
				ActorNames.playerNameColor = newC;
				ColorChooserApplet.this.oldColor = newC;
			} else if (ColorChooserApplet.this.oldColor.equals(ActorNames.clanMateNameColor)) {
				Color newC = new Color(newColor.getRed(), newColor.getGreen(), newColor.getBlue());
				ActorNames.clanMateNameColor = newC;
				ColorChooserApplet.this.oldColor = newC;
			}
			
		}
	});
   
       Color.RGBtoHSB(this.r,this.g,this.b,this.hsb);  // Get HSB equivalent of RGB = (0,0,0);
       
       /* Create Scrollbars with possible values from 0 to 255. */
       
       this.hueScroll = new Scrollbar(Scrollbar.HORIZONTAL, (int)(255*this.hsb[0]), 10, 0, 265);
       this.saturationScroll = new Scrollbar(Scrollbar.HORIZONTAL, (int)(255*this.hsb[1]), 10, 0, 265);
       this.brightnessScroll = new Scrollbar(Scrollbar.HORIZONTAL, (int)(255*this.hsb[2]), 10, 0, 265);
       this.redScroll = new Scrollbar(Scrollbar.HORIZONTAL, this.r, 10, 0, 265);
       this.greenScroll = new Scrollbar(Scrollbar.HORIZONTAL, this.g, 10, 0, 265);
       this.blueScroll = new Scrollbar(Scrollbar.HORIZONTAL, this.b, 10, 0, 265);
       
       /* Create Labels showing current RGB and HSB values. */
       
       this.hueLabel = new Label(" H = " + this.hsb[0]);
       this.saturationLabel = new Label(" S = " + this.hsb[1]);
       this.brightnessLabel = new Label(" B = " + this.hsb[2]);
       this.redLabel = new Label(" R = 0");
       this.greenLabel = new Label(" G = 0");
       this.blueLabel = new Label(" B = 0");
       
       /* Set background colors for Scrollbars and Labels, so they don't
          inherit the gray background of the applet. */
       
       this.hueScroll.setBackground(Color.lightGray);
       this.saturationScroll.setBackground(Color.lightGray);
       this.brightnessScroll.setBackground(Color.lightGray);
       this.redScroll.setBackground(Color.lightGray);
       this.greenScroll.setBackground(Color.lightGray);
       this.blueScroll.setBackground(Color.lightGray);
       
       this.hueLabel.setBackground(Color.white);
       this.saturationLabel.setBackground(Color.white);
       this.brightnessLabel.setBackground(Color.white);
       this.redLabel.setBackground(Color.white);
       this.greenLabel.setBackground(Color.white);
       this.blueLabel.setBackground(Color.white);
       
       /* Set the applet to listen for changes to the Scrollbars' values */
       
       this.hueScroll.addAdjustmentListener(this);
       this.saturationScroll.addAdjustmentListener(this);
       this.brightnessScroll.addAdjustmentListener(this);
       this.redScroll.addAdjustmentListener(this);
       this.greenScroll.addAdjustmentListener(this);
       this.blueScroll.addAdjustmentListener(this);
       
       /* Create a canvas whose background color will always be set to the
          currently selected color. */
       
       this.colorCanvas = new Canvas();
       this.colorCanvas.setBackground(new Color(this.r, this.g, this.b));
       
       /* Create the applet format, which consists of a row of
          three equal-sized regions holding the Scrollbars,
          the Labels, and the color patch.  The background color
          of the applet is gray, which will show around the edges
          and between components. */
       
       setLayout(new GridLayout(1,3,3,3));
       setBackground(Color.gray);
       Panel scrolls = new Panel();
       Panel labels = new Panel();
       add(scrolls);
       add(labels);
       add(this.colorCanvas);
       add(this.confirm);
       
       /* Add the Scrollbars and the Labels to their respective panels. */
       
       scrolls.setLayout(new GridLayout(6,1,2,2));
       scrolls.add(this.redScroll);
       scrolls.add(this.greenScroll);
       scrolls.add(this.blueScroll);
       scrolls.add(this.hueScroll);
       scrolls.add(this.saturationScroll);
       scrolls.add(this.brightnessScroll);
       
       labels.setLayout(new GridLayout(6,1,2,2));
       labels.add(this.redLabel);
       labels.add(this.greenLabel);
       labels.add(this.blueLabel);
       labels.add(this.hueLabel);
       labels.add(this.saturationLabel);
       labels.add(this.brightnessLabel);
       
   } // end init();
   

   @Override
public void adjustmentValueChanged(AdjustmentEvent evt) {
           // This is called when the user has changed the values on
           // one of the scrollbars.  All the scrollbars and labels
           // and the color patch are reset to correspond to the new color.
       int r1, g1, b1;
       r1 = this.redScroll.getValue();
       g1 = this.greenScroll.getValue();
       b1 = this.blueScroll.getValue();
       if (this.r != r1 || this.g != g1 || this.b != b1) {  // One of the RGB components has changed.
          this.r = r1;
          this.g = g1;
          this.b = b1;
          Color.RGBtoHSB(this.r,this.g,this.b,this.hsb);
       }
       else {  // One of the HSB components has changed.
           this.hsb[0] = this.hueScroll.getValue()/255.0F;
           this.hsb[1] = this.saturationScroll.getValue()/255.0F;
           this.hsb[2] = this.brightnessScroll.getValue()/255.0F;
           int rgb = Color.HSBtoRGB(this.hsb[0],this.hsb[1],this.hsb[2]);
           this.r = (rgb >> 16) & 0xFF;
           this.g = (rgb >> 8) & 0xFF;
           this.b = rgb & 0xFF;
       }
       this.redLabel.setText(" R = " + this.r);
       this.greenLabel.setText(" G = " + this.g);
       this.blueLabel.setText(" B = " + this.b);
       this.hueLabel.setText(" H = " + this.hsb[0]);
       this.saturationLabel.setText(" S = " + this.hsb[1]);
       this.brightnessLabel.setText(" B = " + this.hsb[2]);
       this.redScroll.setValue(this.r);
       this.greenScroll.setValue(this.g);
       this.blueScroll.setValue(this.b);
       this.hueScroll.setValue((int)(255*this.hsb[0]));
       this.saturationScroll.setValue((int)(255*this.hsb[1]));
       this.brightnessScroll.setValue((int)(255*this.hsb[2]));
       this.colorCanvas.setBackground(new Color(this.r,this.g,this.b));
       this.colorCanvas.repaint();  // Tell the system to redraw the canvas in its new color.
   } // end adjustmentValueChanged

   
   @Override
public Insets getInsets() {
          // The system calls this method to find out how much space to
          // leave between the edges of the applet and the components that
          // it contains.  I want a 3-pixel border at each edge.
      return new Insets(3,3,3,3);
   }
}  // end class ColorChooserApplet