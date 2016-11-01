package quizWriterPackage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SetupFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -6607302741134109340L; //Ignore
	public JTextField quizTopicField, questionQuantityField, qPerRoundField;
	public JButton submitSettings;
	public String quizTopic;
	public int quizLength, roundLength;
	public MainFrame mainFrame;
	
	public SetupFrame(){
		//JFrame setup stuff
		this.setTitle("Lee's Quiz Writer");
		this.setSize(300, 200);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(QuizWriter.dim.width / 2 - this.getWidth() / 2, QuizWriter.dim.height / 2 - this.getHeight() / 2 );
		this.setLayout(new GridLayout(4, 2));
		
		JLabel quizTopicLabel = new JLabel("Quiz Topic: ");
		quizTopicLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(quizTopicLabel);
		
		quizTopicField = new JTextField("Game of Thrones");
		this.add(quizTopicField);
		
		JLabel questionQuantityLabel = new JLabel("Amount of Questions:");
		questionQuantityLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(questionQuantityLabel);
		
		questionQuantityField = new JTextField("25");
		this.add(questionQuantityField);
		
		JLabel qPerRoundLabel = new JLabel("Questions per round:");
		qPerRoundLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(qPerRoundLabel);
		
		qPerRoundField = new JTextField("5");
		this.add(qPerRoundField);
		
		JLabel submitFiller = new JLabel("Submit when done!");
		submitFiller.setHorizontalAlignment(JLabel.CENTER);
		this.add(submitFiller);
		
		submitSettings = new JButton("Submit!");
		submitSettings.setActionCommand("run mainframe");
		this.add(submitSettings);
		
		submitSettings.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		//SAVING SETTINGS
		quizTopic = quizTopicField.getText();
		String quizLengthString = questionQuantityField.getText();
		String roundLengthString = qPerRoundField.getText();
		quizLength = Integer.parseInt(quizLengthString);
		roundLength = Integer.parseInt(roundLengthString);
		System.out.println(quizLength);
		System.out.println(roundLength);
	
		//REPLACE WITH MAIN FRAME
		this.setVisible(false);
		mainFrame = new MainFrame(quizTopic, quizLength, roundLength);
		this.dispose();
		
	}
	
}
