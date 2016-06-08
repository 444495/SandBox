package haribote;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JToolBar;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;

@SuppressWarnings("serial")
public class Haribote extends JFrame implements ActionListener{

	private JPanel contentPane;

	private File last = new File(System.getProperty("user.home"));
	
	JDesktopPane desktopPane;
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//create("sample");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Haribote frame = new Haribote();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Haribote() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel headerPanel = new JPanel();
		contentPane.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		headerPanel.add(toolBar, BorderLayout.SOUTH);
		
		JButton openButton = new JButton("Open");
		openButton.setActionCommand("Open");
		openButton.addActionListener(this);
		toolBar.add(openButton);
				
		JPanel bodyPanel = new JPanel();
		bodyPanel.setLayout(new BorderLayout(0,0));
		contentPane.add(bodyPanel, BorderLayout.CENTER);
		
		desktopPane = new JDesktopPane();
		bodyPanel.add(desktopPane, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if(e.getActionCommand().equals("Open")){ open(); }
		else{ save(); }
	}
	private void open(){
		JFileChooser chooser = new JFileChooser(last);
		chooser.showOpenDialog(this);
		File target = chooser.getSelectedFile();
		last = target;
		BufferedImage image = null;
		try {
			image = ImageIO.read(target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(image != null){
			System.out.println(image.toString() + " is detected.");
			JInternalFrame inframe = new HariboteImageFrame(image);
			desktopPane.add(inframe);
			try {
				inframe.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void save(){}
	
	
	public static void create(String filename) throws IOException{
		// サンプル用のデータをファイルに書き出します
		String filepath = "./"+filename+".txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
		for(int i = 0; i < 10; i++){
			bw.write(Double.toString(Math.random()*100));
			bw.write(" ");
		}
		bw.flush();
		bw.close();
	}
}
