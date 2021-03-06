package quizWriterPackage;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 3733221592337845369L; //Ignore
	public String quizTopic;
	public int quizLength, qPerRound;
	public JTextField[] questionText;
	public SetupFrame sf;
	
	//General Constructor takes in the values from SetupFrame
	public MainFrame(String topic, int length, int qpr){
		this.quizTopic = topic;
		this.quizLength = length;
		this.qPerRound = qpr;
		initFrame();
	}
	
	public void initFrame() {
		//JFrame setup stuff
		this.setTitle("Lee's Quiz Writer");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(QuizWriter.dim.width / 2 - this.getWidth() / 2, QuizWriter.dim.height / 2 - this.getHeight() / 2 );
		this.setVisible(true);
		this.setResizable(false);
		
		//Adding the File JMenu similar to the one in the top left of your screen right now for your IDE
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newQuiz = new JMenuItem("New");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem saveAs = new JMenuItem("Save as");
		JMenuItem exit = new JMenuItem("Exit");
		
		//Adds actionListener to all the JMenuItems with a for each loop
		JMenuItem[] throwArray = {open, save, saveAs, exit, newQuiz};
		for(JMenuItem item: throwArray){
			if(item == newQuiz)
				file.addSeparator();
			item.addActionListener(this);
			file.add(item);
		}
		menuBar.add(file);
		this.setJMenuBar(menuBar);
		
		//Adds a panel to place on the JFrame(subject to change in future versions)
		JPanel totalGUI = new JPanel();
		
		totalGUI.setLayout(new GridLayout(quizLength+1, 2));
		
		//Set up of quiz title display
		JLabel quizTitle = new JLabel(quizTopic + " Quiz!");
		quizTitle.setFont(new Font("Serif", Font.BOLD, 30));
		quizTitle.setHorizontalAlignment(0);
		totalGUI.add(quizTitle);
		
		//Setup of submit button
		JButton submitButton = new JButton("Submit!");
		totalGUI.add(submitButton);
		JLabel[] questionLabel = new JLabel[quizLength];
		questionText = new JTextField[quizLength];
		
		//Displays the Question number and JtextBox
		for(int i = 0; i < quizLength; i++){
			questionLabel[i] = new JLabel("Question " + (i+1) + ":");
			questionLabel[i].setHorizontalAlignment(JLabel.CENTER);
			questionText[i] = new JTextField();
			totalGUI.add(questionLabel[i]);
			totalGUI.add(questionText[i]);
		}
		
		 
		//allows the pane to be scrollable, which is essential because most of the quizzes are long enough that they go off the screen
		JScrollPane scrollPane = new JScrollPane(totalGUI, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		
		
		
		this.add(scrollPane);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Exit"))//Exits the program
			System.exit(0);
		else if(e.getActionCommand().equals("New")){//creates a new setupFrame and removes previous mainframe
			this.setVisible(false);
			sf = new SetupFrame();
			this.dispose();
		}
		else if(e.getActionCommand().equals("Save as")){
			saveAs();
		}
			
		
	}
	public void saveAs(){//Will return to comment this when I have it full finished
		JFileChooser chooser = new JFileChooser("./");
		
		int returned = chooser.showSaveDialog(this);
		
		if(returned == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			try{
				BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
				String[] s = new String[quizLength];
				for(int i = 0; i < quizLength; i++){
					s[i] = questionText[i].getText();
					bw.write("Question " + i + ": " + s[i]);
					bw.newLine();
				}
				bw.close();
				
			} catch(IOException E){
				E.printStackTrace();
			}
			
			
		}
	}
	
}
