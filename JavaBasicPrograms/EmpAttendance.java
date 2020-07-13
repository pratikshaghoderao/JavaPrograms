/*
this class checks whether employee is present or not
*/
public class EmpAttendance
{
	private static final int IS_FULL_TIME=1;
	public static void main(String args[])
	{
		empChecking();
	}
	public static void empChecking()
	{
		double empCheck =  Math.floor(Math.random()*10)%2;
		if(IS_FULL_TIME == empCheck)
		{
			System.out.println("Present");
		}
		else
		{
			System.out.println("Absent");
		}
	}
}
