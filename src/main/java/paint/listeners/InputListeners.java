package paint.listeners;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import game.LoaderWindow;

public class InputListeners
		implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener, FocusListener {

	public Applet client;
	private boolean hasFocus;
	private boolean inputEnabled;

	public InputListeners(boolean inputEnabled, Applet client) {
		this.inputEnabled = inputEnabled;
		this.client = client;
	}

	@Override
	public void focusGained(FocusEvent e) {
		this.hasFocus = true;
		e.setSource(this.client);
		if (this.inputEnabled && this.client != null) {
			Canvas canvas = (Canvas) this.client.getComponent(0);
			if (canvas != null)
				canvas.dispatchEvent(e);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		this.hasFocus = false;
		e.setSource(this.client);
		if (this.inputEnabled && this.client != null) {
			Canvas canvas = (Canvas) this.client.getComponent(0);
			if (canvas != null)
				canvas.dispatchEvent(e);
		}
	}

	public boolean isInputEnabled() {
		return this.inputEnabled;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		e.setSource(this.client);
		if (this.inputEnabled && this.client != null) {
			Canvas canvas = (Canvas) this.client.getComponent(0);
			if (canvas != null)
				canvas.dispatchEvent(e);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		e.setSource(this.client);
		if (this.inputEnabled && this.client != null) {
			Canvas canvas = (Canvas) this.client.getComponent(0);
			if (canvas != null)
				canvas.dispatchEvent(e);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		e.setSource(this.client);
		if (this.inputEnabled && this.client != null) {
			Canvas canvas = (Canvas) this.client.getComponent(0);
			if (canvas != null)
				canvas.dispatchEvent(e);
		}
	}

	// Listeners
	@Override
	public void mouseClicked(MouseEvent e) {
		LoaderWindow.game.focus();
		if (this.inputEnabled && this.client != null) {
			e.setSource(this.client);
			Canvas canvas = (Canvas) this.client.getComponent(0);
			if (canvas != null)
				canvas.dispatchEvent(e);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		e.setSource(this.client);
		if (this.inputEnabled && this.client != null) {
			Canvas canvas = (Canvas) this.client.getComponent(0);
			if (canvas != null)
				canvas.dispatchEvent(e);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		e.setSource(this.client);
		if (this.inputEnabled && this.client != null) {
			Canvas canvas = (Canvas) this.client.getComponent(0);
			if (canvas != null)
				canvas.dispatchEvent(e);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		e.setSource(this.client);
		if (this.inputEnabled && this.client != null) {
			Canvas canvas = (Canvas) this.client.getComponent(0);
			if (canvas != null)
				canvas.dispatchEvent(e);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		e.setSource(this.client);
		if (this.inputEnabled && this.client != null) {
			Canvas canvas = (Canvas) this.client.getComponent(0);
			if (canvas != null)
				canvas.dispatchEvent(e);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (this.inputEnabled && this.client != null) {
			e.setSource(this.client);
			Canvas canvas = (Canvas) this.client.getComponent(0);
			if (canvas != null) {
				if (!this.hasFocus)
					canvas.requestFocus();

				canvas.dispatchEvent(e);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.inputEnabled && this.client != null) {
			e.setSource(this.client);
			Canvas canvas = (Canvas) this.client.getComponent(0);
			if (canvas != null)
				canvas.dispatchEvent(e);
		}
	}

	// End listeners

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		e.setSource(this.client);
		if (this.inputEnabled && this.client != null) {
			Canvas canvas = (Canvas) this.client.getComponent(0);
			if (canvas != null)
				canvas.dispatchEvent(e);
		}
	}

	public void setInputeEnabled(boolean inputEnabled) {
		this.inputEnabled = inputEnabled;
	}

}
