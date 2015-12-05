package proxy;

import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JComponent;

/**
 * ÏÔÊ¾Í¼Æ¬×é¼þ
 * @author skywalker
 *
 */
public class ImageComponent extends JComponent {
	
	private static final long serialVersionUID = -2746210237229069923L;
	
	private Icon icon;
	
	public ImageComponent(Icon icon) {
		this.icon = icon;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = icon.getIconWidth();
		int height = icon.getIconHeight();
		int x = (300 - width) / 2;
		int y = (400 - height) / 2;
		icon.paintIcon(this, g, x, y);
	}
	
}
