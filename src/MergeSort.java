import java.util.*;

public class MergeSort {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		while(true){
		        //Input
			System.out.println(ConsoleColor.IN+"Bitte geben Sie ein Feld an (Beispiel: 1 2 3 4 0):");
			
			String input = scanner.nextLine();
			String[] parts = input.split(" ");
			int[] array = new int[parts.length];

			for(int i = 0; i < parts.length; i++){
				array[i] = Integer.parseInt(parts[i]);
			}

			System.out.println(ConsoleColor.OUT+"Ihre Eingabe lautet: "+ConsoleColor.COLOR_GREEN+Arrays.toString(array)+ConsoleColor.COLOR_CLEAR);
						
			int[] result = mergesort(array);
			System.out.println(ConsoleColor.OUT+"Das Ergebnis lautet: "+ConsoleColor.COLOR_GREEN+Arrays.toString(result)+ConsoleColor.COLOR_CLEAR);
			
			System.out.println(ConsoleColor.IN+"Zum Abbrechen des Programms geben Sie bitte "+ConsoleColor.COLOR_RED+"\"quit\""+ConsoleColor.COLOR_CLEAR+" ein.");
			
			String quit = scanner.nextLine();
			if(quit.equalsIgnoreCase("quit"))
				break;
		}
		
		scanner.close();
	}
	
	public static int[] merge(int[] leftarray, int[] rightarray){	
		int[] result = new int[(leftarray.length+rightarray.length)];
		
		int indexleft = 0;
		int indexright = 0;
		int indexresult = 0;
		
		//Sortieren der beiden Arrays nach Größe der Einträge
		while (indexleft < leftarray.length && indexright < rightarray.length) {
			if (leftarray[indexleft] <= rightarray[indexright]) {
				result[indexresult++] = leftarray[indexleft++];
				
			}else
			    result[indexresult++] = rightarray[indexright++];
					
		}
		
		//Auffüllen der übrigen Einträge aus Teilliste 1
		while (indexleft < leftarray.length) {
			result[indexresult++] = leftarray[indexleft++];
		}
		
		//Auffüllen der übrigen Enträge aus Teilliste 2
		while (indexright < rightarray.length) {
			result[indexresult++] = rightarray[indexright++];
		}

		return result;
	}
	
	public static int[] mergesort(int[] array){
		//Rekursions-Abbruch
		if(array.length == 1)
			return array;
		
		//Mitte (abgerundet) bestimmen
		int middle = array.length/2;

                //Erste Teilliste bis zur Mitte
		int[] leftarray = new int[middle];	
		System.arraycopy(array, 0, leftarray, 0, middle);
		
		//Zweite Teilliste ab der Mitte
		int[] rightarray = new int[array.length-middle];		
		System.arraycopy(array, middle, rightarray, 0, (array.length-middle));
		
		//Rekursiv
		int[] re1 = mergesort(leftarray);
		int[] re2 = mergesort(rightarray);
		
		//Vereinen der sortierten Teillisten
		array = merge(re1, re2);
		return array;
	}
}
