
public class pierwszy {
	private final double pi = 3.14;
	private double r;
	
	public pierwszy(double r)
	{
		this.r = r;
	}
	
	public String rozwiazanie()
	{
		String rozwiaz = "";
		double pole;
		double obwod;
		if(r > 0)
		{
			pole = pi * r * r;
			obwod = 2 * pi * r;
			rozwiaz = "Wartoœæ pola wynosi" + pole + ". Natomiast obwód ko³a wynosi " + obwod;
		}
		else
		{
			rozwiaz = "Promieñ jest równy b¹dz mniejszy od 0. Promien wynosi" + r + ".";
		}
		return(rozwiaz);
	}
	
	
	public static void main(String[] args) {
        
		pierwszy rownanie = new pierwszy(3);
		System.out.println(rownanie);

    }
}
