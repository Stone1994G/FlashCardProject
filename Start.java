import java.util.*;
import java.nio.file.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;



public class Start
{

	public static void main(String[] args)
	{

		Scanner sc =  new Scanner(System.in);
		String filename;
		int choice;
		String menu;
		menu = "Welcome to the Flashcard Project!\nPlease select a option from the list below:\n\n1) Review Flashcards\n2) Create Flashcards\n3) Edit Flashcards\n4) Quit Program\n";

		System.out.println("Welcome to the Flashcard Project!\n");
		System.out.println("Please select a option from the list below:\n\n");

		System.out.println("1) Review Deck of Flashcards\n");
		System.out.println("2) Create new Deck of Flashcards\n");
		System.out.println("3) Edit or Delete Deck of Flashcards\n");
		System.out.println("4) Quit Program\n");


		do
		{
			choice = sc.nextInt();
			//File x = new File("C:\\USB LOCAL DRIVE SPOT\\FLASHCARD PROJECT\\Flashcard savespot");



			switch(choice)
				{
					case 1: System.out.println("you chose option; " + choice + ") Review Flashcards\n");
							try
								{


									Scanner kb = new Scanner(System.in);
									System.out.println("Please enter the name of the Deck of Flashcards you want to review:\n");
									filename = kb.nextLine();
									File file = new File(filename);
									Scanner inputFile = new Scanner(file);
									if(file.exists())
									{
										try
										{
											System.out.println("Found the file!!");
											FileInputStream fin = new FileInputStream(filename);
											ObjectInputStream ois = new ObjectInputStream(fin);

											Deck deckread = (Deck) ois.readObject();
											for(Flashcard fcread: deckread)
											{
												String useranswer;
												int wrongcount = 0;

												Scanner answercheck = new Scanner(System.in);
												do
												{
													System.out.println("\n"+fcread.getquestion());
													System.out.println("What is the answer: ");
													useranswer = answercheck.nextLine();


													if(useranswer.equalsIgnoreCase(fcread.getanswer()))
													{
														System.out.println("\nCorrect!");
													}
													else
													{
														System.out.println("\nIncorrect..... Try again:");
														wrongcount++;
														if(wrongcount >= 3)
														{
															System.out.println("Here is some help!!!\nCorrect answer printed below:");
															System.out.println(fcread.getanswer());
														}
													}

												}while(!useranswer.equalsIgnoreCase(fcread.getanswer()));
											}

											System.out.println("\nFinished with this deck\n");

											ois.close();


										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
									}
									// Code above looks for file have not implemented code for opening it
								}
							catch (Exception f)
								{
									System.out.println("The File was not found\n");
								}
							System.out.println("Returning to main menu:...");
							System.out.println(menu);
							break;

					case 2: System.out.println("You chose option: " + choice + ") Create Flashcards\n");

							System.out.println("Name this deck");
							Scanner scan = new Scanner(System.in);
							Deck deck = new Deck();
							deck.setdeckname(scan.nextLine());
							System.out.println("Begin making flashcards, type esc after entering\nthe question and answer to quit and save deck\n");
							do
							{
								Flashcard fc = new Flashcard();
								System.out.println("Enter the question");
								fc.setquestion(scan.nextLine());
								System.out.println("Enter the answer");
								fc.setanswer(scan.nextLine());

								System.out.println("\nQuestion was " + fc.getquestion());
								System.out.println("Answer was " + fc.getanswer());
								deck.add(fc);


								System.out.println("\nCard added to deck, size of deck currently: " + deck.size());
								System.out.println("TYPE esc to quit or press any other key once to continue making cards\n");

							}while(!"esc".equals(scan.nextLine()));


							System.out.println("\nFinished Making deck of flashcards");
							System.out.println("Deck file named: " + deck.getdeckname());

							try{
								System.out.println("\nBegin attempt Saving....");
								FileOutputStream fout = new FileOutputStream(deck.getdeckname());
								ObjectOutputStream oos = new ObjectOutputStream(fout);
								oos.writeObject(deck);
								oos.close();
								System.out.println("Success!!\n");

							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							System.out.println("Returning to main menu:...\n" + menu);
							break;

					case 3: System.out.println("You chose option: " + choice + ") Edit or Delete Flashcards\n");
							try
							{
								System.out.println("Please enter the name of the Deck you want to edit/delete:\n");
								Scanner read = new Scanner(System.in);
								filename = read.nextLine();
								File file = new File(filename);

								if(file.exists())
								{
									try
									{
										System.out.println("Deck was located\n");
										FileInputStream fin = new FileInputStream(filename);
										ObjectInputStream ois = new ObjectInputStream(fin);

										Deck deckread = (Deck) ois.readObject();
										int choice2;
										String choice3;
										do
										{
											System.out.println("What would you like to do with: " + deckread.getdeckname()+" deck?\n");
											System.out.println("1) Edit/delete individual Flashcards within the deck");
											System.out.println("2) Delete the whole deck enter\n3) Return to the main menu enter\n");

											choice2 = read.nextInt();
											switch(choice2)
											{
												case 1:System.out.println("You chose to edit/delete individual Flashcards.\n");
													for(Flashcard fcread: deckread)
													{
													System.out.println("Question: " + fcread.getquestion()+"\n"+"Answer: "+fcread.getanswer());
													System.out.println("Enter what you would like to do:\n1) Change the question\n2) Change the answer\n3) Delete the card\n4) Go to next card in deck\n");

														do{
															choice2 = read.nextInt();
															Scanner dis = new Scanner(System.in);
														switch(choice2)
															{


															case 1:
																System.out.println("Change question to what?\n");
																fcread.setquestion(dis.nextLine());
																break;
															case 2:
																System.out.println("Change answer to what\n");
																fcread.setanswer(dis.nextLine());
																break;
															case 3:
																System.out.println("Going to next card\n");
																break;
															default:
																System.out.println("Invalid Option\n");
																break;
															}
														 }while(choice2 != 3);

													}





													break;

												case 2:System.out.println("You chose to delete the entire deck\n");
														System.out.println("Are you sure you want to delete this entire deck\nEnter 1 to confirm\n");

														if(read.nextInt() == 1);
														{
																//experiment
															try
															{
																Files.deleteIfExists(Paths.get(filename));
															}
															 catch(NoSuchFileException e)
																	{
																		System.out.println("No such file/directory exists");
																	}
																	catch(DirectoryNotEmptyException e)
																	{
																		System.out.println("Directory is not empty.");
																	}
																	catch(IOException e)
																	{
																		System.out.println("Invalid permissions.");
																	}

																System.out.println("Deletion successful.");

															fin.close();
															ois.close();
															/*if(file.delete())
															{
																System.out.println("Deck Deleted");
																choice2 = 3;
															}
															else
																System.out.println("Deck not deleted due to some error....");
															*/
														}




													break;

												case 3:

													break;

												default:System.out.println("Invalid option chosen");

													break;
											}
										}while(choice2 != 3);
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
								}
								else
									System.out.print("File not found\n");
							}
							catch(Exception e)
							{
								System.out.println("The File was not found\n");
							}

							System.out.println("\nReturning to main menu...\n" + menu);

							break;

					case 4: System.out.println("You chose option " + choice + ") Quit\n");
							break;
					default:
							System.out.println("The choice you chose does not exist\n" +  menu);
							break;

				}
		} while(choice != 4);

		System.out.println("Leaving the Flashcard Project. Have amazing day!\n");

	}
}