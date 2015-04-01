package YWidget;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class YWidget extends JFrame implements ActionListener {

	private Yvonne y;
	private JPanel p1;
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
			this.setSize(250, 360);
			this.setMinimumSize(new Dimension(250, 150));
			this.setMaximumSize(new Dimension(250, 700));
			this.setDefaultCloseOperation(YWidget.EXIT_ON_CLOSE);
			this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
			this.setTitle("Yvonne");
			
			// Image
			y = new Yvonne();
			l1 = new JLabel(new ImageIcon(y.RandomPic()));
			
			// Button layout container
			JPanel f2 = new JPanel();
			f2.setSize(200, 75);
			f2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
			
			// Button
			b1 = new JButton("Get Image");
			b1.setSize(150, 65);
			b1.addActionListener(this);
			
			f2.add(this.b1);
			
			// Pull it all together
			p1 = new JPanel();
			p1.add(l1);
			p1.add(f2);
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
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			try {
				//l1.setVisible(false);
				l1 = new JLabel(new ImageIcon(y.RandomPic()));
				//l1.setVisible(true);
				l1.repaint();
				p1.repaint();
				count++;
				this.setTitle("Refresh: " + count);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		this.repaint();
	}
}
