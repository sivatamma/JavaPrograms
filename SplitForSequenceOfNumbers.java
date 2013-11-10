
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author SIVA$SANTU
 *
 */
public class SplitForSequenceOfNumbers {

/*Inthe given Class NumberList.java, implement method getNumberList()such that for the following input :

“1,2,3,4,5-8,6-10,8-15,16-25,20-30,22-26”the output displayed is:
1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30.
Notethe following points:
1. Numbersmissing in input should not appear in output. For example, aninput 1,2,3,6-8 should
produce the output 1,2,3,6,7,8 withoutthe missing numbers 4 and 5
2. Numbersrepeated in input should appear only once in output. Forexample, for a given input
“1,2,3,4,5,2-6” , theoutput should be 1,2,3,4,5,6.
3. Thereshould be no dashes in output and all number sequences must be expanded
ATester class is given to you with the main Method. Use this classto test your solution*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			String readInput = readInputFunction();
			String[] sequence = readInput.split(",");
			Set<Integer> sequenceList = getNumberList(sequence);
			System.out.println(sequenceList);
		}
		catch (IOException e) 
		{
			System.out.println("The sequence of numbers entered is invalid");
		}
		catch(NumberFormatException nfe)
		{
			System.out.println("The sequence of numbers entered is invalid");
		}
		
	}
	
	public static String readInputFunction() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the sequence");
		String readInput = br.readLine();
		return readInput;
	}
	
	public static Set<Integer> getNumberList(String[] sequence)
	{
		Set<Integer> sequenceList = new TreeSet<Integer>();
		for (String loop : sequence)
		{
			if(loop.contains("-"))
			{
				String splitedString[] = loop.split("-");
					List<Integer> list = new ArrayList<Integer>();
					Integer first = Integer.valueOf(splitedString[0]);
					Integer second = Integer.valueOf(splitedString[1]);
					while(first<second)
					{
						list.add(first);
						first++;
					}
					list.add(second);
					for(int j=0;j<list.size();j++)
					{
						if(!(sequenceList.contains(list.get(j))))
						{
							sequenceList.add(list.get(j));
						}
					}
			}
			else
			{
				if(!(sequenceList.contains(Integer.valueOf(loop))))
				{
					sequenceList.add(Integer.valueOf(loop));
				}
			
			}
		}
		return sequenceList;
	}

}
