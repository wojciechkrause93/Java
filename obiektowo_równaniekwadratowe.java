package modul_1;

public class obiektowo_równaniekwadratowe {
	private int a;
	private int b;
	private int c;
	
	
	public obiektowo_równaniekwadratowe(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public String rozwiąż()
	{
		String rozwiązanie = "";
		double delta = Math.pow(b, 2) - 4*(a*c);
		System.out.println("Delta wynosi: " + delta);
		if(delta > 0)
		{
			double x1 = (-b - Math.sqrt(delta))/(2*a);
			double x2 = (-b + Math.sqrt(delta))/(2*a);
			rozwiązanie = "Funkcja posiada dwa miejsca zerowe.Pierwsze miejsce zerowa wynosi: " + x1 + " Drugie miejsce zerowa wynosi: " + x2;
		}
		else if(delta == 0)
		{
			double x = (-b)/(2*a);
			rozwiązanie= "Funkcja posiada jedno miejsce zerowe. Miejsce zerowa wynosi: " + x;
		}
		else {
			rozwiązanie = "Funkcja kwadratowa nie posiada miejsc zerowych";
		}
		return(rozwiązanie);
	}
	public String toString()
	{
		return("Równanie kwadratowe: " + a + "x^2 + " + b + "x + "+ c);
	}
	
	public static void main(String [] args)
	{
		obiektowo_równaniekwadratowe równanie = new obiektowo_równaniekwadratowe(1,4,-2);
		System.out.println(równanie.rozwiąż());
		
	}

}
