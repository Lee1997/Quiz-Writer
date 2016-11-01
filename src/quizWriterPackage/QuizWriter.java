package quizWriterPackage;
/*
 * Written by Lee Laffan 30/10/2016
 * Pushed to and updated (hopefully) regularly on https://github.com/Lee1997/QuizApp
 */
import java.awt.Dimension;
import java.awt.Toolkit;

public class QuizWriter {
	/*
	 * Finally getting around to commenting my code. Hopefully this makes it much easier to understand.
	 * This project started as just a learning playground, I didn't plan for it to be an actual app.
	 * A lot of the comments will be favoured towards explaining to friends so I may over-comment.
	 * Ah well, better get to it!
	 */
	public OpeningFrame openingFrame;
	public static Dimension dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	public static QuizWriter qw;
	
	public static void main(String[] args){
		qw = new QuizWriter();
	}
	//The default constructor referenced from main, initialising a new OpeningFrame object
	public QuizWriter(){
		openingFrame = new OpeningFrame();		
	}
	
	
	
}
