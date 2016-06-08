package haribote;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HariboteImageFrame extends JInternalFrame {
	private static Point initializePosition = new Point(0,0);

	/**
	 * Create the frame.
	 */
	public HariboteImageFrame(Image image) {
		setLayout(new BorderLayout(0,0));
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		JScrollPane scrollPane = new JScrollPane();
		setContentPane(scrollPane);
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(2,2));
		panel.add(new JLabel(new ImageIcon(image)));
		panel.add(new JLabel(new ImageIcon(image)));
		panel.add(new JLabel(new ImageIcon(image)));
		panel.add(new JLabel(new ImageIcon(image)));
		setSize(image.getWidth(this)*2, image.getHeight(this)*2);
		
		initializePosition.translate(15, 15);
		setLocation(initializePosition);
		
		setVisible(true);
	}

}
