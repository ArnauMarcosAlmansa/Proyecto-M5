package beemovie;

public class Program
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(meme("boy a hacer bee movie bien y bad y muy bad"));
		
		System.out.println(meme("b b b"));
		
		System.out.println("ba bien");
	}

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
	
	
	private static String meme(String text)
	{
		String result = new String(text);
		
		int pad = 0;
		
		int padcount = 1;
						
		for(int i = 0; i < text.length(); i++)
		{
			//System.out.println(result);
			
			if(text.charAt(i) == 'b' || text.charAt(i) == 'B')
			{
				int[] cuts = wordLimits(text, i);
				
				//System.out.println(result.length());
				
				System.out.println(result.substring(0, cuts[0] + pad));
				System.out.println(text.substring(0, cuts[1]));
				System.out.println(text.substring(cuts[1], text.length()));
				
				String space = "";
				
				//if(i == 0) space = " ";
				
				result = result.substring(0, cuts[0] + pad) + space
						+ text.substring(0, cuts[1])
						+ text.substring(cuts[1], text.length());
				
				System.out.println(result);
				System.out.println("//////////////////////////////");

				pad = pad + cuts[0] + 2;
			}
		}
		
		return result;
	}
}
