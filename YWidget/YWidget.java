package YWidget;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class YWidget extends JFrame implements ActionListener {

	private Yvonne y;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JLabel l1;
	private JButton b1;
	int count = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new YWidget();
	}

	@SuppressWarnings("unused")
	public YWidget() throws Exception {
		try {
			this.setSize(360, 250);
			this.setMinimumSize(new Dimension(250, 250));
			this.setMaximumSize(new Dimension(1024, 1024));
			this.setDefaultCloseOperation(YWidget.EXIT_ON_CLOSE);
			this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
			this.setTitle("Yvonne");

			// Button panel
			p2 = new JPanel();
			p2.setSize(250, 75);
			p2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

			// Image panel
			p3 = new JPanel();
			p3.setSize(250, 360);
			p3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			// Image
			y = new Yvonne();
			l1 = new JLabel(new ImageIcon(y.RandomPic()));
			p3.add(l1);
			
			// Button
			b1 = new JButton("Get Image");
			b1.setSize(150, 65);
			b1.addActionListener(this);
			p2.add(this.b1);
			
			// Pull it all together
			p1 = new JPanel();
			p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
			p1.add(p2, 0);
			p1.add(p3, 1);
			this.add(p1);
			this.pack();
			this.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			try {
				l1 = new JLabel(new ImageIcon(y.RandomPic()));
				l1.updateUI();
				p3.remove(0);
				p3.add(l1, 0);
				p3.updateUI();
				p1.updateUI();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
