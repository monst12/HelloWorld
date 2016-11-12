import java.util.Locale;
import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		System.out.println("Hello Mr. Chocolate!");
		System.out.println("Hey there!");
		
		Locale.setDefault(Locale.US); //SET DEFAULT LOCALE
		
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		
		if(in >= 10){
			System.out.println("Hello world!");		
			System.out.println("Hey Michael!"); //Added Michael Support
			System.out.println("Hey Nick!"); //Added Nick Support
			System.out.println("Hey Carla!"); //Added Carla Support
			System.out.println("Hey Peter!"); //Added Peter Support
		}
		
		sc.close();
	}
}
