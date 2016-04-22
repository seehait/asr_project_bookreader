import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame {
	
	// GUI
	// window
	private JFrame window;
	private JPanel panel;
	
	// file operation panel
	private JPanel fileOpPanel;
	private JLabel fileOpLabel;
	private JTextField fileDirField;
	private JButton openFileButton;
	private JButton closeFileButton;
	
	// text display panel
	private JPanel textDisplayPanel;
	private JLabel textDisplay;
	
	// variables
	private String fileDir;
	
	public Frame() {
		initWindow();
	}
	
	private void initWindow() {
		window = new JFrame("Book Reader");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		initPanel();
		
		window.add(panel);
		window.pack();
		window.setVisible(true);
		
	}
	
	private void initPanel() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(800, 800));
		
		initFileOpPanel();
		panel.add(fileOpPanel, BorderLayout.NORTH);
		
		initTextDisplayPanel();
		panel.add(textDisplayPanel, BorderLayout.CENTER);
	}
	
	private void initFileOpPanel() {
		fileOpPanel = new JPanel();
		fileOpPanel.setBorder(BorderFactory.createTitledBorder("Open file"));
		fileOpPanel.setLayout(new FlowLayout());
		
		initFileOpGUI();
		fileOpPanel.add(fileOpLabel);
		fileOpPanel.add(fileDirField);
		fileOpPanel.add(openFileButton);
		fileOpPanel.add(closeFileButton);
	}
	
	private void initFileOpGUI() {
		fileOpLabel = new JLabel(" File directory:");
		
		fileDirField = new JTextField();
		fileDirField.setPreferredSize(new Dimension(500, 20));
		fileDirField.addActionListener(new ActionListener() {
			
			// when user pressed enter
			@Override
			public void actionPerformed(ActionEvent e) {
				fileDir = fileDirField.getText();
				
				// call openFile method
				
				// debug
				System.out.println("Open file at \"" + fileDir + "\".");
			}
		});
		
		openFileButton = new JButton("Open");
		openFileButton.addActionListener(new ActionListener() {
			
			// when user pressed open button
			@Override
			public void actionPerformed(ActionEvent e) {
				fileDir = fileDirField.getText();
				
				// call openFile method
				
				// debug
				System.out.println("Open file at \"" + fileDir + "\".");
			}
		});
		
		closeFileButton = new JButton("Close");
		closeFileButton.addActionListener(new ActionListener() {
			
			// when user pressed close button
			@Override
			public void actionPerformed(ActionEvent e) {
				fileDir = fileDirField.getText();
				
				// call closeFile method
				
				// debug
				System.out.println("Close file.");
			}
		});
	}
	
	private void initTextDisplayPanel() {
		textDisplayPanel = new JPanel();
		textDisplayPanel.setLayout(new FlowLayout());
		textDisplayPanel.setBorder(BorderFactory.createTitledBorder("Text"));
		
		initTextDisplayGUI();
		textDisplayPanel.add(textDisplay);
	}
	
	private void initTextDisplayGUI() {
		textDisplay = new JLabel("<html><center><h1>Please opan a file to read more text.</h1></center><br><p>Line1....................................................................................................................................................................................<br>Line2<br>Line3</p></html>");
		textDisplay.setAlignmentX(Component.LEFT_ALIGNMENT);
		textDisplay.setHorizontalAlignment(0);
	}

}
