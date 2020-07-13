/*
this class checks whether employee is present or not
*/
public class EmpTotalWage
{
	private static final int IS_PRESENT=1;
	public static void main(String args[])
	{
		final boolean isPresent = empCheck();
		if(isPresent)
		{
			final double wage = calculateWage(20, 8);
			System.out.println("Employee is present");
			System.out.println("Total wage::" +wage);
		}
		else
		{
			System.out.println("Employee is absent");
			System.out.println("Employee wage is 0.0");
		}
	}

	public static boolean empCheck()
	{
		return IS_PRESENT == Math.floor(Math.random() * 10) % 2;
	}
	public static double calculateWage (final int ratePerHrs, final int totalHrs)
	{
		return ratePerHrs*totalHrs;
	}
}
