import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author SIVA$SANTU
 *Enter the String Input
   34.5d
  o/p: 34.5 is Numeric
 */
public class CheckForNumeric {

	/**
	 * @param args
	 */
	public void isNumeric(){
		Scanner scanner= new Scanner(System.in);

		System.out.println("Enter the String Input");
		String input = scanner.nextLine();
		try{
			Number x=	NumberFormat.getInstance().parse(input);
			System.out.println(x+" is Numeric");
		}
		
		catch(ParseException pe){
			System.out.println("Entered input is not Numeric ,try again...");
			isNumeric();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckForNumeric checkForNumeric = new CheckForNumeric();
		checkForNumeric.isNumeric();
	}
}
