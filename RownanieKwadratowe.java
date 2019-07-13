package modul_1;
import java.util.Scanner;
public class RownanieKwadratowe 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Wpisz parametr funkcji a: ");
		double a = input.nextDouble();
		System.out.println("Wpisz parametr funkcji b: ");
		double b = input.nextDouble();
		System.out.println("Wpisz parametr funkcji c: ");
		double c = input.nextDouble();
		
		double delta = Math.pow(b, 2) - 4*(a*c);
		System.out.println("Delta wynosi: " + delta);
		if(delta > 0)
		{
			double x1 = (-b - Math.sqrt(delta))/(2*a);
			double x2 = (-b + Math.sqrt(delta))/(2*a);
			System.out.println("Funkcja posiada dwa miejsca zerowe.Pierwsze miejsce zerowa wynosi: " + x1 + " Drugie miejsce zerowa wynosi: " + x2);
		}
		else if(delta == 0)
		{
			double x = (-b)/(2*a);
			System.out.println("Funkcja posiada jedno miejsce zerowe. Miejsce zerowa wynosi: " + x);
		}
		else {
			System.out.println("Funkcja kwadratowa nie posiada miejsc zerowych");
		}
	}
	
}
