package modul_1;

import java.util.Scanner;

public class TestR�wnania {
	public static void main (String[] args)
	{
		System.out.println("Podaj Parametry a, b i c");
		Scanner skaner = new Scanner(System.in);
		int a = skaner.nextInt();
		int b = skaner.nextInt();
		int c = skaner.nextInt();
		obiektowo_r�wnaniekwadratowe r = new obiektowo_r�wnaniekwadratowe(a,b,c);
		System.out.println(r.rozwi��());
		System.out.println(r.rozwi��());
	}

}
