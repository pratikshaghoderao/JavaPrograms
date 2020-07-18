import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ComputeWageObjectUC12 implements IComputeWage
{
	public static final int IS_PART_TIME=1;
	public static final int IS_FULL_TIME=2;
	private int noOfCompany;
	private List<Company> companyList;
	private HashMap<String,Company> map;

	public ComputeWageObjectUC12()
	{
		this.companyList =  new ArrayList<>();
		this.map = new HashMap<>();

	}

	@Override
	public void addCompany(final String name, final int empRate, final int totalWorkingDays, final int maxHrsInMonth)
	{
		final Company company =  new Company(name, empRate, totalWorkingDays, maxHrsInMonth);
		companyList.add(company);
		map.put(name,company);
	}

	@Override
	public void computeEmpWage()
	{
		for(int i=0; i < companyList.size(); i++)
		{
			this.computeWage(companyList.get(i));
			System.out.println(companyList.get(i));
		}
	}



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

	@Override
	public int getTotalWageByCompanyName(String name)
	{
		final Company company = map.get(name);
		return company.getTotalEmpWage();
	}

	public static void main(String args[])
	{
		IComputeWage icw = new ComputeWageObjectUC12();
		//for apple
		icw.addCompany("Apple", 20, 20, 200);
		//for samsung
		icw.addCompany("samsung", 10, 30, 100);
		icw.computeEmpWage();
		final int appleWage = icw.getTotalWageByCompanyName("Apple");
		System.out.println("Total employee wage for Apple is ::" + appleWage);
	}
}

interface IComputeWage
{
	public void addCompany(final String name, final int empRate, final int totalWorkingDays, final int maxHrsInMonth);
	public void computeEmpWage();
	public int getTotalWageByCompanyName(String name);
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
	@Override
	public String toString()
	{
		return "Total employee wage for "+ name + " is ::" + totalEmpWage;
	}
}
