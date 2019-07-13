package modul_1;

public class obiektowo_r�wnaniekwadratowe {
	private int a;
	private int b;
	private int c;
	
	
	public obiektowo_r�wnaniekwadratowe(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public String rozwi��()
	{
		String rozwi�zanie = "";
		double delta = Math.pow(b, 2) - 4*(a*c);
		System.out.println("Delta wynosi: " + delta);
		if(delta > 0)
		{
			double x1 = (-b - Math.sqrt(delta))/(2*a);
			double x2 = (-b + Math.sqrt(delta))/(2*a);
			rozwi�zanie = "Funkcja posiada dwa miejsca zerowe.Pierwsze miejsce zerowa wynosi: " + x1 + " Drugie miejsce zerowa wynosi: " + x2;
		}
		else if(delta == 0)
		{
			double x = (-b)/(2*a);
			rozwi�zanie= "Funkcja posiada jedno miejsce zerowe. Miejsce zerowa wynosi: " + x;
		}
		else {
			rozwi�zanie = "Funkcja kwadratowa nie posiada miejsc zerowych";
		}
		return(rozwi�zanie);
	}
	public String toString()
	{
		return("R�wnanie kwadratowe: " + a + "x^2 + " + b + "x + "+ c);
	}
	
	public static void main(String [] args)
	{
		obiektowo_r�wnaniekwadratowe r�wnanie = new obiektowo_r�wnaniekwadratowe(1,4,-2);
		System.out.println(r�wnanie.rozwi��());
		
	}

}
