
public class HolidayBonus {
//Constructor: creates a default values for Holiday Bonus class
	public HolidayBonus() 
	{	
	}
//Methods
/**
 * pass in a two-dimensional ragged array of doubles, and the bonus amount for the store with the highest sales in a category,
 *  the bonus amount for the store with the lowest sales in a category and bonus amount for all other stores. It will return an array 
 *  of doubles which represents the holiday bonuses for each of the stores in the district. The first entry in the returned array [0] 
 *  will represent the holiday bonus for the store at [0] in the two-dimensional ragged array of doubles. You will be using methods 
 *  from the TwoDimRaggedArrayUtility when needed.
 * @param array
 * @return
 */
public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other)
{ 
	double[][] holidayBonusArray= new double[data.length][];
	for(int i = 0 ; i < data.length;i++)
	{
	 holidayBonusArray[i]= new double[data[i].length];
	}
	for(int i= 0, j=0;i < holidayBonusArray.length;i++,j++)
	{
		int highIndex= TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
		int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i);
		if(i<holidayBonusArray[j].length)
		{
			holidayBonusArray[highIndex][i]= high;
			holidayBonusArray[lowIndex][i]=low;
			if(j==highIndex||j==lowIndex)
			{
				continue;
			}
			else
			{
				holidayBonusArray[j][i]=other;
			
			}
		}
	}
	double[] holidayBonusPerStore = new double[data.length];
	for(int i = 0; i<holidayBonusArray.length;i++)
	{
		for(int j = 0 ; j<holidayBonusArray[i].length;j++)
		{
			holidayBonusPerStore[i]+=holidayBonusArray[i][j];
		}
	}
	return holidayBonusPerStore;
}

/**
 * pass in a two-dimensional ragged array of doubles, and the bonus amount for the store with the highest sales in a category, 
 * the bonus amount for the store with the lowest sales in a category and bonus amount for all other stores.
 * It will return a double which represents the total of all Holiday Bonuses for the District.
 * You will be using methods from the TwoDimRaggedArrayUtility when needed.
 * @param array
 * @return
 */
public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other)
{
	double[][]holidayBonusArray= new double[data.length][];
	for(int i = 0; i< data.length;i++)
	{
		holidayBonusArray[i]= new double[data[i].length];
	}
	for(int i = 0 , j=0; i<holidayBonusArray.length;i++,j++)
	{
		int highIndex= TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
		int lowIndex= TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i);
		if(i<holidayBonusArray[j].length)
		{
			holidayBonusArray[highIndex][i]= high;
			holidayBonusArray[lowIndex][i]= low;
			if(j== highIndex|| j ==lowIndex)
			{
				continue;
			}
			else
			{
				holidayBonusArray[j][i]= other;
			}
			
		}
	}
	double holidayTotal= 0.0;
	for(int i = 0 ; i<holidayBonusArray.length;i++)
	{
		for(int j = 0 ; j<holidayBonusArray[j].length;j++)
		{
			holidayTotal += holidayBonusArray[i][j];
		}
	}
	return holidayTotal; 
}
}