import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


/**
 * Given the date , month and year of a birthday calculate the age in decimal
 * format. For example, if the calculated age as of today is 15 years and 6
 * months, the output returned should be 15.5, and if it is 15 yrs and 3 months,
 * the output returned should be 15.25
 * 
 * NOTE: Accuracy can be only up to the month. Accurate calculation up to a
 * single day Day calculation is not needed
 * 
 * @param birthdate
 * @param birthMonth
 * @param birthYear
 * @return
 * 
 * Example=
 * enter date of birth of format yyyy MM dd
	1991 02 12
	22.75
 */
    
public class AgeCalculator {
	public static void main(String[] args){
		AgeCalculator ageCalculator = new AgeCalculator();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter date of birth of format yyyy MM dd");
		String birthday  = sc.nextLine();
		String array[] = birthday.split("\\s+");
		try {
			double result = ageCalculator.calculateAge(Integer.parseInt(array[2]),Integer.parseInt(array[1]),Integer.parseInt(array[0]));
			System.out.println(result);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Enter date properly");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Enter date properly");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Enter date properly");
		}
	}

	public double calculateAge(int birthdate, int birthMonth, int birthYear) throws Exception {
		Calendar c= Calendar.getInstance();
				c.set(Calendar.YEAR,birthYear);
				c.set(Calendar.MONTH, birthMonth-1);
				c.set(Calendar.DATE, birthdate);
				
		SimpleDateFormat readFormat=new SimpleDateFormat("yyyy MM dd");
		Calendar c1 = Calendar.getInstance();
		if(c.before(c1) ) {
		String curr = readFormat.format(c1.getTime());
		String array[] = curr.split("\\s+");
		Integer years=Integer.valueOf(array[0])-birthYear;
		double months=(double)Math.abs(Integer.valueOf(array[1])-birthMonth)/12;
		DecimalFormat df = new DecimalFormat("#.##");
		String mon = df.format(months);
		return (years + Double.valueOf(mon));
		}
		else{
			throw new Exception();
		}
		
}
}