public class WagesForMonth
{
	private static int empTime;
	private static int month=20;
	public static void main(String args[])
	{
		empTime = empCheck();
		switch(empTime)
		{
			case 1:
			final double fullWage = calculateWage(20, 8);
			System.out.println("This is full time employee");
			System.out.println("Total wage::" +fullWage);
			break;

			case 2:
			final double partWage = calculateWage(20, 4);
			System.out.println("This is part time employee");
			System.out.println("Total wage::" + partWage);
			break;
		}
	}

	public static int empCheck()
	{
		return empTime = (int)(Math.random() * (2 - 1 + 1) + 1);
	}
	public static double calculateWage (final int ratePerHrs, final int totalHrs)
	{
		return (ratePerHrs*totalHrs)*20;
	}
}
