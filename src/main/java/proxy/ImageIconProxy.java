package proxy;

import java.awt.Component;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ͼƬ����
 * @author skywalker
 *
 */
public class ImageIconProxy implements Icon {
	
	//���������
	private ImageIcon imageIcon;
	private String url;
	private boolean retriving = false;

	public ImageIconProxy(String url) {
		this.url = url;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		if(imageIcon == null) {
			g.drawString("loading image...", 0, 0);
			if(!retriving) {
				retriving = true;
				new Thread() {
					@Override
					public void run() {
						//��ʼ����ͼƬ
						try {
							imageIcon = new ImageIcon(new URL(url));
							c.repaint();
						} catch (MalformedURLException e) {
							e.printStackTrace();
						}
					};
				}.start();
			}
		}else {
			imageIcon.paintIcon(c, g, x, y);
		}
	}

	@Override
	public int getIconWidth() {
		return (imageIcon == null) ? 250 : imageIcon.getIconWidth();
	}

	@Override
	public int getIconHeight() {
		return (imageIcon == null) ? 250 : imageIcon.getIconHeight();
	}

}
