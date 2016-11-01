package quizWriterPackage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OpeningFrame extends JFrame implements ActionListener{
	
	public JButton newQuizButton;
	public SetupFrame setupFrame;
	
	public OpeningFrame(){
		
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
		newQuizButton.setActionCommand("run setup");
		this.add(newQuizButton);
		
		JButton loadQuizButton = new JButton("Load Quiz");
		this.add(loadQuizButton);
		
		newQuizButton.addActionListener(this);
		loadQuizButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("run setup"))
			this.setVisible(false);
			setupFrame = new SetupFrame();
			this.dispose();
		
	}
	
	
}
