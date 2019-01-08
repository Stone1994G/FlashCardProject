import java.util.*;
import java.io.Serializable;

public class Flashcard implements Serializable
{

	String question;
	String answer;

	public Flashcard()
	{
		question = "queston goes here";
		answer = "answer goes here";
	}

	public Flashcard(String newquestion, String newanswer)
	{
		this.question = newquestion;
		this.answer = newanswer;
	}

	public void setquestion(String setquestion)
	{
		question = setquestion;
	}

	public void setanswer(String setanswer)
	{
		answer = setanswer;
	}

	public String getquestion()
	{
		return question;
	}

	public String getanswer()
	{
		return answer;
	}

	public String toString()
		{
			return new StringBuffer("Question: ")
				.append(this.question).append(this.answer).toString();
	}
}







