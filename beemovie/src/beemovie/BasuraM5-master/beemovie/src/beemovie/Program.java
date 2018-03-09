package beemovie;

import java.util.Scanner;

/**
 * 
 * @author Arnau Marcos Almansa arnaumarcosalmansa@gmail.com
 * 
 * <br><br><br>This class is capable of creating the most imaginative Bee Movie memes ever conceived by us, humans.
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
	 * 
	 * @param args Default parameters never used<br>
	 * 
	 * 
	 * 
	 * FYI: This is the main function.
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
	}

	/**
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
		
		if(i != 0) i--;
		
		limits[0] = i;
		
		int j = index;
		
		while(j < text.length() && text.charAt(j) != ' ')
		{
			j++;
		}
		
		limits[1] = j;
		
		return limits;	
	}
	
	/**
	 * 
	 * @param text String that will be memetized.
	 * @return A String of the text memetized.
	 */
	 
	public static String meme(String text)
	{
		String result = new String(text);
		
		int pad = 0;
		
		boolean isFirst = true;
				 						
		for(int i = 0; i < text.length(); i++)
		{
			
			if(text.charAt(i) == 'b' || text.charAt(i) == 'B')
			{
				int[] cuts = wordLimits(text, i);
								
				System.out.println(result.substring(0, cuts[0] + pad));
				System.out.println(text.substring(0, cuts[1]));
				System.out.println(text.substring(cuts[1], text.length()));
				
				result = result.substring(0, cuts[0] + pad)
						+ text.substring(0, cuts[1])
						+ text.substring(cuts[1], text.length());
				
				System.out.println(result);
				System.out.println("//////////////////////////////");

				pad = pad + cuts[0] + (cuts[1] - i);
							
				i = cuts[1];
			}
		}
		
		return result;
	}
}
