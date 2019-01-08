import java.util.*;
import java.io.File;
import java.util.ArrayList;
import java.io.Serializable;

public class Deck extends ArrayList<Flashcard> implements Serializable
{

	String deckname;
	File file = new File("C:\\USB LOCAL DRIVE SPOT\\FLASHCARD PROJECT");

	Deck()
	{
		//ArrayList <Flashcard> deck = new ArrayList<Flashcard>();
		deckname = "Unnamed Deck";
	}


	public String getdeckname()
	{
		return deckname;
	}

	public void setdeckname(String newdeckname)
	{
		deckname = newdeckname;
	}

	public String toString()
	{
		return new StringBuffer("Deck: ")
			.append(this.deckname).toString();
	}

}