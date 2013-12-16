import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class FirstDayAndLastDayOfMonth {

	/*    input:	january:2014
		  output :	Wednesday 01
					Friday 31*/
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		String input = sc.next();
		String splitted[] = input.split(":");
		SimpleDateFormat readFormat = new SimpleDateFormat("MMMM yyyy");
		Date date = new Date();
		date =readFormat.parse(splitted[0]+" "+splitted[1]);
		
			
		Calendar c=Calendar.getInstance();
		c.setTime(date);
	Calendar caloutput = Calendar.getInstance();
	caloutput.set(Calendar.YEAR,c.get(Calendar.YEAR));
	caloutput.set(Calendar.MONTH,c.get(Calendar.MONTH));
	caloutput.set(Calendar.DAY_OF_MONTH,1);
	SimpleDateFormat writeFormat = new SimpleDateFormat("EEEE dd");
	String output = writeFormat.format(caloutput.getTime());
	System.out.println(output);
	
	
	caloutput.add(Calendar.MONTH,1);
	
	caloutput.add(Calendar.DATE,-1);
	SimpleDateFormat writeFormat1 = new SimpleDateFormat("EEEE dd");
	String output1 = writeFormat1.format(caloutput.getTime());
	System.out.println(output1);
		
		
		
	}

}
