package modul_1;

import java.util.Scanner;

public class TestRównania {
	public static void main (String[] args)
	{
		System.out.println("Podaj Parametry a, b i c");
		Scanner skaner = new Scanner(System.in);
		int a = skaner.nextInt();
		int b = skaner.nextInt();
		int c = skaner.nextInt();
		obiektowo_równaniekwadratowe r = new obiektowo_równaniekwadratowe(a,b,c);
		System.out.println(r.rozwi¹¿());
		System.out.println(r.rozwi¹¿());
	}

}
