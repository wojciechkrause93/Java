
public class analizatablic 
{
	
	public String MaximValue(int[] numbers)
	{
		String wnk = "";
		int x = 0;
		int maxValue = numbers[0];
		for(int i = 1; i < numbers.length;i++)
		{
			if(numbers[i] > maxValue)
			{
				maxValue = numbers[i];
				x = i;
			}
		}
		wnk = ("Wartoœæ maksymalna wynosi = " + maxValue +" na pozycji " + x);
		return(wnk);
	}
	
	public String MinimumValue(int[] numbers) 
	{
		String wnk = "";
		int x = 0;
		int minValue = numbers[0];
		for(int i = 1; i< numbers.length; i ++)
		{
			if(numbers[i] < minValue)
			{
				minValue = numbers[i];
				x = i;
			}
		}
		wnk = ("Wartoœæ minimalna wynosi = " + minValue +" na pozycji " + x);
		return(wnk);
	}
	
	public static void main(String[] args)
	{
		int[] numbers = {1,5,3,6,9,12,3,5,0};
		analizatablic MaximumValue = new analizatablic();
		System.out.println(MaximumValue.MinimumValue(numbers));
		System.out.println(MaximumValue.MaximValue(numbers));
	}
}
