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
	
	public JFrame mainFrame, setupFrame;
	public OpeningFrame openingFrame;
	public static Dimension dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	public JButton newQuizButton, loadQuizButton, submitSettings;
	public JTextField quizTopicField, questionQuantityField, qPerRoundField;
	public int quizLength, roundLength, currentQuestion = 0;
	public String quizTopic;
	public boolean changed = false;
	public JTextField[] questionText;
	
	
	public QuizWriter(){
		openingFrame = new OpeningFrame();		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	public static void main(String[] args){
		QuizWriter qw = new QuizWriter();
	}
	
}
