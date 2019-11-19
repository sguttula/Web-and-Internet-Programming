package midtermreview;

import java.util.ArrayList;

public class Quiz {
	
	/*
					0			1			2			3			4
questions = {	Question1	Question2	Question3	Question4	Question5 }	NULL	
														^
														|
														currentQuestion
	
	 */

	ArrayList<MathQuestion> questions;
	MathQuestion currentQuestion;
	
	int correct, asked;

	public Quiz() {
		
		// Create an array list to STORE MathQuestions
		questions = new ArrayList<MathQuestion>();
		
		// Construct 5 MathQuestion Objects and add them to the array list
		for (int i = 0; i < 5; i++) {
			questions.add( new MathQuestion() );
		}
		
		// Set the 'currentQuestion' to start at the 1st element in the array list
		currentQuestion = questions.get(0);
		
		correct = 0; // Keeps track of how many correct answers the user has submitted
		asked = 0;	// Keeps track of how many questions have been asked
	}
	
	public int getNumberCorrect() {
		return correct;
	}
	public boolean isComplete() {
		return currentQuestion == null;
	}
	
	public void answerQuestion(int answer) {
		if (currentQuestion != null && currentQuestion.getAnswer() == answer) {
			correct++;
		}
		
		asked++;
		
		if (asked >= 5)
			currentQuestion = null;
		else
			currentQuestion = questions.get(asked);		
	}
	
	public MathQuestion getCurrentQuestion() {
		return currentQuestion;
	}
	
	public int getScore() {
		return correct;
	}
	
	
}