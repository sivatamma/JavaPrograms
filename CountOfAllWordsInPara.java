import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class CountOfAllWordsInPara {

	/**
	 * @param args
	 * 
	 *Enter the String Input:
The third-rate mind is only happy when it is thinking with the majority.The second-rate mind is only happy when it is thinking with the minority. The first-rate mind is only happy when it is thinking."
output:{is=6, it=3, The=3, rate=3, thinking=3, happy=3, when=3, only=3, mind=3, with=2, the=2, minority=1, second=1, majority=1, third=1, first=1}

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter the String Input");
		String input = scanner.nextLine();
		String[] array = input.replaceAll("\\p{Punct}"," ").split("\\s+");

		Map<String,Integer> unsortMap = new HashMap<String, Integer>(); 
		for (String string : array) {
			if(unsortMap.get(string)!=null)
				unsortMap.put(string,unsortMap.get(string)+1);
			else
				unsortMap.put(string, 1);
		}
		
		Map<String, String> sortedMap = sortByComparator(unsortMap);
		 System.out.println(sortedMap);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	private static Map<String, String> sortByComparator(
			 Map unsortMap) {
		
		List list = new LinkedList(unsortMap.entrySet());
		 
		// sort list based on comparator
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue())
                                       .compareTo(((Map.Entry) (o1)).getValue());
			}
		});
 
		// put sorted list into map again
                //LinkedHashMap make sure order in which keys were inserted
		Map sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	


}
