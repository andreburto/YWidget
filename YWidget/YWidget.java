package YWidget;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class YWidget extends JFrame {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new YWidget();
	}

	@SuppressWarnings("unused")
	public YWidget() throws Exception {
		try {
			Yvonne y = new Yvonne();
			BufferedImage img = y.RandomPic();
			int w = img.getWidth() + 20;
			int h = img.getHeight() + 45;
			
			this.setSize(w, h);
			this.setDefaultCloseOperation(YWidget.EXIT_ON_CLOSE);
			this.setTitle("Yvonne");
			
			JPanel p1 = new JPanel();
			JLabel l1 = new JLabel(new ImageIcon(img));
			p1.add(l1);
			this.add(p1);
			this.setVisible(true);
		}
		catch (Exception e) {
			throw new Exception(e);
		}
	}
}
