package quizWriterPackage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OpeningFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 7371273143243284052L; //Ignore
	public JButton newQuizButton;
	public SetupFrame setupFrame;
	
	//Default Constructor
	public OpeningFrame(){
		//JFrame setup stuff. Can reference this because OpeningFrame extends JFrame
		this.setTitle("Lee's Quiz Maker");
		this.setSize(300, 200);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(new GridLayout(3, 1));
		this.setLocation(QuizWriter.dim.width / 2 - this.getWidth() / 2, QuizWriter.dim.height / 2 - this.getHeight() / 2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel openingQuestion = new JLabel("What would you like to do?");
		openingQuestion.setHorizontalAlignment(JLabel.CENTER);
		this.add(openingQuestion);
		
		newQuizButton = new JButton("New Quiz");
		newQuizButton.setActionCommand("run setup"); //Essentially adds a tag so the actionListener will know which object it heard from
		this.add(newQuizButton);
		
		JButton loadQuizButton = new JButton("Load Quiz");
		this.add(loadQuizButton);
		
		//Will link up to the ActionListener which is implemented on line 11, will trigger actionPerformed when clicked as it will be listened to
		newQuizButton.addActionListener(this);
		loadQuizButton.addActionListener(this);
	}
	//A requirement of the abstract ActionListener interface
	public void actionPerformed(ActionEvent e) {
		//Transfers from OpeningFrame to a new SetupFrame object
		if(e.getActionCommand().equals("run setup")){
			this.setVisible(false);
			setupFrame = new SetupFrame();
			this.dispose();
		}
	}
	
	
}
