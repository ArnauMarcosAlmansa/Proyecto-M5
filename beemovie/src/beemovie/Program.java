package beemovie;

import java.util.Scanner;

/**
 * This class is capable of creating the most imaginative Bee Movie memes ever conceived by us, humans.
 * 
 * @author Arnau Marcos Almansa arnaumarcosalmansa@gmail.com
 * 
 *  
 * @version 1.0
 *
 * @since Java 8.0
 * 
 * 
 *
 */

public class Program
{
	
	private Program()
	{
		
	}
	/**
	 * FYI: This is the main function.
	 * 
	 * @param args Default parameters never used<br>
	 * 
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		boolean emoji = false;
		
		while(input.hasNextLine())
		{
			String line = input.nextLine();
			
			if(line.equals("EMOJI MOVIE"))
				{
					System.out.println("BASURA");
					emoji = true;
					break;
				}
			
			System.out.println(meme(line));
		}
		
		if(!emoji)
		{
			System.out.println("THE END");
		}
		
		input.close();
	}

	/**
	 * Finds, in the given text, the indexes of the start and the end of a word which contains the given index.
	 * 
	 * @param text String where things happen and are happened
	 * @param index Parameter that indicates the index of a character contained inside a word.
	 * @return Returns an int[] of length 2.<br>Being int[0] the index of the space before a word and int[1] the index after the last character of the word.
	 */
	private static int[] wordLimits(String text, int index)
	{
		int[] limits = new int[2];
		
		int i = index;
		
		while(i > 0 && text.charAt(i) != ' ')
		{
			i--;
		}
		
		//if(i != 0) i--;
		
		limits[0] = i;
		
		int j = index;
		
		while(j < text.length() && text.charAt(j) != ' ')
		{
			j++;
		}
		
		if(j == text.length() - 1) j++;
		
		limits[1] = j;
				
		return limits;	
	}
	
	/**
	 * Converts a String into it's meme version.<br>Each time it finds a word containing a 'b' or 'B', it replaces it with a substring from the beginning of the text til the end of the word containing the letter.
	 * @param text String that will be memetized.
	 * @return A String of the text memetized.
	 */
	 
	public static String meme(String text)
	{
		String result = new String(text);
		
		int pad = 0;
		
		boolean nob = true;
		
						 						
		for(int i = 0; i < text.length(); i++)
		{
			/*
			System.out.println("isFirst: " + isFirst);
			System.out.println(i);
			*/
			if(text.charAt(i) == 'b' || text.charAt(i) == 'B')
			{
				int[] cuts = wordLimits(text, i);
				
				String space1 = "";
				String space2 = "";
				
				int mod = 0;
				
				if(nob && cuts[0] != 0)
				{
					mod = 1;
				}
				
				nob = false;

				
				if(true)
				{
					/*
					System.out.println("entra");
					System.out.println(result.length() + " " + (cuts[0] + pad));
					*/
					
					if(!result.substring(0, cuts[0] + pad + mod).endsWith(" ") 
							&& result.substring(0, cuts[0] + pad + mod).length() > 0 
							&& !text.substring(0, cuts[1]).startsWith(" "))
					{
						space1 = " ";
					}
					
					if(!text.substring(0, cuts[1]).endsWith(" ") 
							&& !text.substring(cuts[1], text.length()).startsWith(" ") 
							&& text.substring(cuts[1], text.length()).length() > 0)
					{
						space2 = " ";
					}
				}
				
				/*
				System.out.println(cuts[0] + pad + mod);
				System.out.println(result.substring(0, cuts[0] + pad + mod));
				System.out.println(text.substring(0, cuts[1]));
				System.out.println(text.substring(cuts[1], text.length()));
				*/
				
				result = result.substring(0, cuts[0] + pad + mod) + space1
						+ text.substring(0, cuts[1]) + space2
						+ text.substring(cuts[1], text.length());
				
				/*
				System.out.println(result);
				 
				System.out.println("/////////////////////");
				*/
				
				pad = pad + cuts[0] + 1 + mod;
				
				i = cuts[1];
			}
		}
		
		return result;
	}
}
