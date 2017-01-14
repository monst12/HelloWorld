import java.util.Locale;
import java.util.*;


public class MergeSort {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		boolean cancel = false;		
		while(!cancel){
			System.out.println("Bitte geben Sie ein Feld an (Beispiel: 1 2 3 4 0):");
			
			String input = scanner.nextLine();
			String[] parts = input.split(" ");
			int[] array = new int[parts.length];

			for(int i = 0; i < parts.length; i++){
				array[i] = Integer.valueOf(parts[i]);
			}

			System.out.println("Ihre Eingabe lautet: "+Arrays.toString(array));
						
			int[] result = mergesort(array);
			System.out.println("Das Ergebnis lautet: "+Arrays.toString(result));
			
			System.out.println("Zum Abbrechen des Programms geben Sie bitte \"quit\" ein.");
			
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
				
			}else{
				result[indexresult++] = rightarray[indexright++];
			}		
		}
		
		//Auffüllen der übrigen Einträge
		while (indexleft < leftarray.length) {
			result[indexresult++] = leftarray[indexleft++];
		}
		
		//Auffüllen der übrigen Enträge
		while (indexright < rightarray.length) {
			result[indexresult++] = rightarray[indexright++];
		}

		return result;
	}
	
	public static int[] mergesort(int[] array){
		//Rekursions-Abbruch
		if(array.length == 1)
			return array;
		
		int middle = array.length/2;

		int[] leftarray = new int[middle];	
		System.arraycopy(array, 0, leftarray, 0, middle);
		
		int[] rightarray = new int[array.length-middle];		
		System.arraycopy(array, middle, rightarray, 0, (array.length-middle));
		
		//Rekursiv
		mergesort(leftarray);
		mergesort(rightarray);
		
		array = merge(leftarray, rightarray);
		return array;
	}
	
	
	
	public static void sort(int[] array)
	{

		if (array.length > 1) {
			int mitte = (int)(array.length / 2);

			int[] links = new int[mitte];
			for (int i = 0; i <= links.length - 1; i++) {
				links[i] = array[i];
			}

			int[] rechts = new int[array.length - mitte];
			for (int i = mitte; i <= array.length - 1; i++) {
				rechts[i - mitte] = array[i];
			}

			sort(links);
			sort(rechts);

			array = merge(links, rechts);
		}
	}

}
