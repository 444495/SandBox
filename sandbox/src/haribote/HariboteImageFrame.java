package haribote;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JButton;

public class HariboteImageFrame extends JInternalFrame {
	private static Point initializePosition = new Point(0,0);

	/**
	 * Create the frame.
	 */
	public HariboteImageFrame(Image image) {
		getContentPane().setLayout(new BorderLayout(0,0));
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0,0));
		JPanel bodyPanel = new JPanel();
		bodyPanel.setLayout(new GridLayout(2,2));
		contentPane.add(bodyPanel, BorderLayout.CENTER);
		JScrollPane scrollPane1 = new JScrollPane();
		JScrollPane scrollPane2 = new JScrollPane();
		JScrollPane scrollPane3 = new JScrollPane();
		JScrollPane scrollPane4 = new JScrollPane();
		bodyPanel.add(scrollPane1);
		bodyPanel.add(scrollPane2);
		bodyPanel.add(scrollPane3);
		bodyPanel.add(scrollPane4);
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel(new ImageIcon(image)));
		scrollPane1.setViewportView(panel1);
		JPanel panel2 = new JPanel();
		panel2.add(new JLabel(new ImageIcon(image)));
		scrollPane2.setViewportView(panel2);
		JPanel panel3 = new JPanel();
		panel3.add(new JLabel(new ImageIcon(image)));
		scrollPane3.setViewportView(panel3);
		JPanel panel4 = new JPanel();
		panel4.add(new JLabel(new ImageIcon(image)));
		scrollPane4.setViewportView(panel4);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton saveButton = new JButton("Save");
		toolBar.add(saveButton);
		
		setSize(image.getWidth(this)*2, image.getHeight(this)*2);
		
		initializePosition.translate(15, 15);
		setLocation(initializePosition);
		
		setVisible(true);
	}

}
