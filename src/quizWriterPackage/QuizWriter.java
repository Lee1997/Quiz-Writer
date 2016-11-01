package quizWriterPackage;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QuizWriter implements ActionListener{
	
<<<<<<< HEAD
<<<<<<< HEAD
	public JFrame mainFrame, setupFrame;
	public OpeningFrame openingFrame;
=======
	public JFrame openingFrame, mainFrame, setupFrame;
>>>>>>> 564fe7b7d7d84d17a0ee5b6260b191e44cd71dcb
=======
	public JFrame openingFrame, mainFrame, setupFrame;
>>>>>>> 564fe7b7d7d84d17a0ee5b6260b191e44cd71dcb
	public static Dimension dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	public JButton newQuizButton, loadQuizButton, submitSettings;
	public JTextField quizTopicField, questionQuantityField, qPerRoundField;
	public int quizLength, roundLength, currentQuestion = 0;
	public String quizTopic;
	public boolean changed = false;
	public JTextField[] questionText;
	
	
	public QuizWriter(){
<<<<<<< HEAD
<<<<<<< HEAD
		openingFrame = new OpeningFrame();		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		
		if("Save as".equals(e.getActionCommand())&& changed == false){
=======
=======
>>>>>>> 564fe7b7d7d84d17a0ee5b6260b191e44cd71dcb
		OpeningFrame();		
	}
	
	public void OpeningFrame(){
		openingFrame = new JFrame();
		openingFrame.setTitle("Lee's Quiz Maker");
		openingFrame.setSize(300, 200);
		openingFrame.setVisible(true);
		openingFrame.setResizable(false);
		openingFrame.setLayout(new GridLayout(3, 1));
		openingFrame.setLocation(dim.width / 2 - openingFrame.getWidth() / 2, dim.height / 2 - openingFrame.getHeight() / 2);
		
		JLabel openingQuestion = new JLabel("What would you like to do?");
		openingQuestion.setHorizontalAlignment(JLabel.CENTER);
		openingFrame.add(openingQuestion);
		
		newQuizButton = new JButton("New Quiz");
		newQuizButton.setActionCommand("run setup");
		openingFrame.add(newQuizButton);
		
		JButton loadQuizButton = new JButton("Load Quiz");
		openingFrame.add(loadQuizButton);
		
		newQuizButton.addActionListener(this);
		loadQuizButton.addActionListener(this);
	}
	
	public void createSetupFrame(){
		setupFrame = new JFrame();
		setupFrame.setTitle("Lee's Quiz Writer");
		setupFrame.setSize(300, 200);
		setupFrame.setResizable(false);
		setupFrame.setVisible(true);
		setupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupFrame.setLocation(dim.width / 2 - setupFrame.getWidth() / 2, dim.height / 2 - setupFrame.getHeight() / 2 );
		setupFrame.setLayout(new GridLayout(4, 2));
		
		JLabel quizTopicLabel = new JLabel("Quiz Topic: ");
		quizTopicLabel.setHorizontalAlignment(JLabel.CENTER);
		setupFrame.add(quizTopicLabel);
		
		quizTopicField = new JTextField("Game of Thrones");
		setupFrame.add(quizTopicField);
		
		JLabel questionQuantityLabel = new JLabel("Amount of Questions:");
		questionQuantityLabel.setHorizontalAlignment(JLabel.CENTER);
		setupFrame.add(questionQuantityLabel);
		
		questionQuantityField = new JTextField("25");
		setupFrame.add(questionQuantityField);
		
		JLabel qPerRoundLabel = new JLabel("Questions per round:");
		qPerRoundLabel.setHorizontalAlignment(JLabel.CENTER);
		setupFrame.add(qPerRoundLabel);
		
		qPerRoundField = new JTextField("5");
		setupFrame.add(qPerRoundField);
		
		JLabel submitFiller = new JLabel("Submit when done!");
		submitFiller.setHorizontalAlignment(JLabel.CENTER);
		setupFrame.add(submitFiller);
		
		submitSettings = new JButton("Submit!");
		submitSettings.setActionCommand("run mainframe");
		setupFrame.add(submitSettings);
		
		submitSettings.addActionListener(this);
		
		
	}
	
	public void createMainFrame(){
		mainFrame = new JFrame();
		mainFrame.setTitle("Lee's Quiz Writer");
		mainFrame.setSize(800, 800);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocation(dim.width / 2 - mainFrame.getWidth() / 2, dim.height / 2 - mainFrame.getHeight() / 2 );
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newQuiz = new JMenuItem("New");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem saveAs = new JMenuItem("Save as");
		JMenuItem exit = new JMenuItem("Exit");
		
		JMenuItem[] throwArray = {open, save, saveAs, exit, newQuiz};
		for(JMenuItem item: throwArray){
			if(item == newQuiz)
				file.addSeparator();
			item.addActionListener(this);
			file.add(item);
		}
		menuBar.add(file);
		mainFrame.setJMenuBar(menuBar);
		
		JPanel totalGUI = new JPanel();
		
		totalGUI.setLayout(new GridLayout(quizLength+1, 2));
		
		JLabel quizTitle = new JLabel(quizTopic + " Quiz!");
		quizTitle.setFont(new Font("Serif", Font.BOLD, 30));
		quizTitle.setHorizontalAlignment(0);
		totalGUI.add(quizTitle);
		
		JButton submitButton = new JButton("Submit!");
		totalGUI.add(submitButton);
		JLabel[] questionLabel = new JLabel[quizLength];
		questionText = new JTextField[quizLength];
		
		for(int i = 0; i < quizLength; i++){
			questionLabel[i] = new JLabel("Question " + (i+1) + ":");
			questionLabel[i].setHorizontalAlignment(JLabel.CENTER);
			questionText[i] = new JTextField();
			totalGUI.add(questionLabel[i]);
			totalGUI.add(questionText[i]);
		}
		
		 
		
		JScrollPane scrollPane = new JScrollPane(totalGUI, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		
		
		
		mainFrame.add(scrollPane);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if("run setup".equals(e.getActionCommand())){
			//REPLACE WITH SETTINGS FRAME
			openingFrame.setVisible(false);
			createSetupFrame();
			openingFrame.dispose();
		}
		else if("run mainframe".equals(e.getActionCommand())){
				//SAVING SETTINGS
				quizTopic = quizTopicField.getText();
				String quizLengthString = questionQuantityField.getText();
				String roundLengthString = qPerRoundField.getText();
				quizLength = Integer.parseInt(quizLengthString);
				roundLength = Integer.parseInt(roundLengthString);
				System.out.println(quizLength);
				System.out.println(roundLength);
			
				//REPLACE WITH MAIN FRAME
				setupFrame.setVisible(false);
				createMainFrame();
				setupFrame.dispose();	
		}
		else if("Exit".equals(e.getActionCommand())){
			System.exit(0);
		}
		else if("New".equals(e.getActionCommand())){
			//REPLACE WITH SETUP FRAME
			mainFrame.setVisible(false);
			createSetupFrame();
			mainFrame.dispose();
		}
		else if("Save as".equals(e.getActionCommand())&& changed == false){
<<<<<<< HEAD
>>>>>>> 564fe7b7d7d84d17a0ee5b6260b191e44cd71dcb
=======
>>>>>>> 564fe7b7d7d84d17a0ee5b6260b191e44cd71dcb
			JFileChooser chooser = new JFileChooser("./");
			
			int returned = chooser.showSaveDialog(mainFrame);
			
			if(returned == JFileChooser.APPROVE_OPTION){
				File file = chooser.getSelectedFile();
				String path = file.getAbsolutePath();
				try{
					BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
					String[] s = new String[quizLength];
					FileWriter fw = null;
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
	
	
	public static void main(String[] args){
		QuizWriter qw = new QuizWriter();
	}
	
}
