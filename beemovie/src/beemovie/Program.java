package beemovie;

public class Program
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		int[] ans = wordLimits("a hola a todos", 2);
				
		System.out.println(ans[0] + " " + ans[1]);
		
		System.out.println(meme("boy a hacer bee movie bien y bad y muy bad"));
	}

	private static int[] wordLimits(String text, int index)
	{
		int[] limits = new int[2];
		
		int i = index;
		
		while(i > 0 && text.charAt(i - 1) != ' ')
		{
			i--;
		}
		
		if(i != 0) i--;
		
		limits[0] = i;
		
		int j = index;
		
		while(j < text.length() - 1 && text.charAt(j + 1) != ' ')
		{
			j++;
		}
		
		limits[1] = ++j;
		
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
				
				System.out.println(result.substring(0, cuts[0] + pad));
				System.out.println(text.substring(0, cuts[1]));
				System.out.println(text.substring(cuts[1], text.length()));
				System.out.println("//////////////////////////////");
				
				
				result = result.substring(0, cuts[0] + pad)
						+ text.substring(0, cuts[1])
						+ text.substring(cuts[1], text.length());
				
				pad = pad + cuts[1] + 1;
				
			}
		}
		
		return result;
	}
}
