public class ComputeWageObject
{
	public static final int IS_PART_TIME=1;
	public static final int IS_FULL_TIME=2;
//	public static final int EMP_RATE_PER_HR=20;
//	public static final int NUM_OF_WORKING_DAYS=20;
//	public static final int MAX_HRS_IN_MONTH=100;

	public static void computeWage(final Company company)
	{
		int empHrs=0, totalEmpHrs=0, totalWorkingDays=0;
		while(totalEmpHrs <= company.getMaxHrsInMonth() && totalWorkingDays < company.getTotalWorkingDays())
		{
			totalWorkingDays++;
			int empCheck= (int) Math.floor(Math.random() * 10) % 3;
			switch(empCheck)
			{
				case IS_PART_TIME:
					empHrs=4;
					break;
				case IS_FULL_TIME:
					empHrs=8;
					break;
				default:
					empHrs=0;
			}
			totalEmpHrs+= empHrs;
			System.out.println("Day::" + totalWorkingDays + "	Emp hour::" +empHrs);
		}
		final int wage = totalEmpHrs * company.getEmpRate();
		company.setTotalEmpWage(wage);
	}
	public static void main(String args[])
	{
		//for apple
		final Company apple = new Company("Apple", 20, 20, 100);
		computeWage(apple);
		System.out.println("Total wage for "+ apple.getName() + "::"+ apple.getTotalEmpWage());
		//for samsung
		final Company samsung = new Company("Samsung", 30, 30, 200);
		computeWage(samsung);
                System.out.println("Total wage for "+samsung.getName() + "::"+ samsung.getTotalEmpWage());

	}
}

class Company
{
	private String name;
	private int empRate;
	private int totalWorkingDays;
	private int maxHrsInMonth;
	private int totalEmpWage;

	public Company()
	{
	}

	public Company(final String name, final int empRate, final int totalWorkingDays, final int maxHrsInMonth)
	{
		this.name=name;
		this.empRate=empRate;
		this.totalWorkingDays=totalWorkingDays;
		this.maxHrsInMonth=maxHrsInMonth;
	}

	public void setName(final String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void setEmpRate(final int empRate)
        {
                this.empRate = empRate;
        }
        public int getEmpRate()
        {
                return empRate;
        }
	public void setTotalWorkingDays(final int totalWorkingDays)
        {
                this.totalWorkingDays = totalWorkingDays;
        }
        public int getTotalWorkingDays()
        {
                return totalWorkingDays;
        }
	public void setMaxHrsInMonth(final int maxHrsInMonth)
        {
                this.maxHrsInMonth = maxHrsInMonth;
        }
        public int getMaxHrsInMonth()
        {
                return maxHrsInMonth;
        }
	public void setTotalEmpWage(final int totalEmpWage)
	{
		this.totalEmpWage = totalEmpWage;
	}
	public int getTotalEmpWage()
	{
		return totalEmpWage;
	}
}
