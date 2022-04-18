import java.io.*;
import java.util.Scanner;
/**
 * 
 * @author sebas
 *
 */
public class TwoDimRaggedArrayUtility {
	protected static int MAX_COLUMNS = 10;
	protected static int MAX_ROWS = 10;

	//constructor: creates a default value for two Dim Ragged Array Utility class
	public TwoDimRaggedArrayUtility() {
		}

	//methods
	/**
	 * (see the page in the assignment 5 twoDimRaggedArratUnity because is too long)
	 * @param file
	 * @return
	 */
	//***************************************************************************************************************************
	public static double[][] readFile(File file)
	{
		double[][] array = new double[6][];
		String line; 
		int i = 0 ; 
		try {
			//open the file
			BufferedReader br = new BufferedReader(new FileReader(file));
			//read the file 
			while((line = br.readLine())!= null)
			{
				String[] temp = line.split(" ");
				int size= temp.length;
				array[i]=new double[size];
			//convert it into doubles
				for(int j= 0; j<size;j++)
				{
					array[i][j]= Double.parseDouble(temp[j]);
				}
				i++;
			}
			br.close();
		}catch(Exception ep)
		{
			ep.printStackTrace();
		}
		return array;
	}
	//***************************************************************************************************************************
	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate
	 * line within the file and each double is separated by a space.
	 * @param data
	 * @param outputFile
	 */
	//***************************************************************************************************************************
	public static void writeToFile(double[][] data, File outputFile)
	{
	 try
	 {
		 //open the file
		 BufferedWriter br = new BufferedWriter(new FileWriter(outputFile));
		 //read the array and print into file with spaces
		 for(int i = 0; i<data.length;i++)
		 {
			 for(int j = 0 ; j<data[i].length;j++)
			 {
				 br.write(data[i][j]+ " ");
			 }
			 br.newLine();
		 }
		 br.close();
		 }
	 catch(Exception ep)
	 {
		 ep.printStackTrace();
	 }
	}
	//***************************************************************************************************************************
	/**
	 * Returns the average of the elements in the two dimensional array
	 * @param data
	 * @return
	 */
	//***************************************************************************************************************************
	public static double getAverage(double[][] data)
	{
		double average=0.0; 
		double sum=0;
		for(int i = 0; i <data.length; i++) //to find the average of the array
		{
			for (int j = 0 ; j <data[i].length;j++)				
			{
				average+=data[i][j];
			}
		}
		for(int i = 0; i <data.length; i++) //to find the sum
		{
			for (int j = 0 ; j<data[i].length;j++)				
			{
				sum+=1;
			}
		}
		average = average/sum;
		return average;
	}
	//***************************************************************************************************************************
	/**
	 *pass in a two-dimensional ragged array of doubles
	 * and returns the total(sum) of the elements in the array. 
	 * @param data
	 * @return
	 */
	//***************************************************************************************************************************
	public static double getTotal(double[][] data)
	{
		double total=0;
		for(int i = 0; i <data.length; i++) //to find the sum
		{
			for (int j = 0 ; j < data[i].length;j++)				
			{
				total+=data[i][j];
			}
		}
		
		return total;
	}
	//***************************************************************************************************************************
	/**
	 * – pass in a two-dimensional ragged array of doubles and a row index and returns the total of that row. 
	 * Row index 0 is the first row in the array.
	 * @param data
	 * @param row 
	 * @return
	 */
	//***************************************************************************************************************************
	public static double getRowTotal(double[][] data, int row)
	{
		double total=0;
		
			for (int j = 0 ; j<data[row].length;j++)	// returns the total of that row			
			{
				total+=data[row][j];
			}
	
			return total;
	}
	//***************************************************************************************************************************
	/**
	 * pass in a two-dimensional ragged array of doubles and a column index 
	 * and returns the total of that column. Column index 0 is the first column in the array.
	 *  If a row doesn’t contain that column,it is not an error, 
	 *  that row will not participate in this method.
	 * @param data
	 * @param col
	 * @return
	 */
	//***************************************************************************************************************************
	public static double getColumnTotal(double[][] data,int col)
	{
		double total=0;
		for (int i= 0; i<data.length;i++)
		{
			if (col <= data[i].length-1)
				total+=data[i][col];
		}
	
		
		return total;

	}
	//***************************************************************************************************************************
	/**
	 * pass in a two-dimensional ragged array of doubles and a row index and returns the largest
	 *  element in that row.Row index 0 is the first row in the array.
	 * @param data
	 * @param row 
	 * @return
	 */
	//***************************************************************************************************************************
	public static double getHighestInRow(double[][] data, int row)
	{
		double MaxValue=data[row][0];;
		for (int j = 1 ; j<data[row].length;j++)	// returns the greater value in the row		
		{
			if (data[row][j]>MaxValue)
			{
				MaxValue=data[row][j];
			}
		}
		return MaxValue;
	}
	//***************************************************************************************************************************
	/**
	 * pass in a two-dimensional ragged array of doubles
	 * and a row index and returns the index 
	 * of the largest element in that row. 
	 * Row index 0 is the first row in the array.
	 * @param data
	 * @param row 
	 * @return
	 */
	//***************************************************************************************************************************
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		int Index = 0;
		double MaxValue=data[row][0];
		
		for (int j = 1 ; j<data[row].length;j++)	// returns the greater value in the row		
		{
			if (data[row][j]>MaxValue)//if the first term maxValue is greater than the second one is replaced and the index is equal to j
			{
				MaxValue=data[row][j];
				Index = j;
				
			}
			else {
				Index = 0; //if the first term is the greater index is equals to 0 meaning the first term in the array 
			}
		}
		return Index;
	}
	//***************************************************************************************************************************
	/**
	 * a two-dimensional ragged array of doubles and a row index and returns the smallest
	 * element in that row. Row index 0 is the first row in the array.
	 * @param data
	 * @param row 
	 * @return
	 */
	//public static double getLowestInRow(double[][] data, int row)
	//{
	//	double no=0;
	//	return no;
	//}
	/**
	 * a two-dimensional ragged array of doubles and a row index and returns 
	 * the index of the smallest element in that row. 
	 * Row index 0 is the first row in the array.
	 * @param data
	 * @param row
	 * @return
	 */
	//************************************************************************************************************************
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		int Index = 0;
		for(int i= 0 ; i < data[row].length;++i)
		{
			if(data[row][i]<data[row][Index])
			{
				Index= i;
			}
		}
		return Index;
	}
	//***************************************************************************************************************************
	/**
	 * pass in a two-dimensional ragged array of doubles and a column index and returns
	 *  the largest element in that column. Column index 0 is the first column in the array.
	 *   If a row doesn’t contain that column, it is not an error,that row will not participate in this method.
	 * @param data
	 * @param col
	 * @return
	 */
	//***************************************************************************************************************************
	public static double getHighestInColumn(double[][] data,int col)
	{
		double highest = data[0][col];
		for(int i=0; i <data.length;i++)
		{
			if(col<=data[i].length-1)
			{
				if(data[i][col]>highest)
				{
					highest=data[i][col];
				}
			}
		}
		return highest;
	}
	//***************************************************************************************************************************
	/**
	 * pass in a two-dimensional ragged array of doubles and a column index and returns the index
     * of the largest element in that column. Column index 0 is the first column in the array.
     * If a row doesn’t contain that column,it is not an error, that row will not participate in this method.
	 *@param data
	 *@param col
	 * @return
	 */
	//***************************************************************************************************************************
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		int highestIndex=0;
		for(int i = 0; i<data.length;i++)
			{
				if(data[i].length>col)
				{
					if(data[i][col]>data[highestIndex][col])
						highestIndex=i;
				}
			}
		return highestIndex;
	}
	//***************************************************************************************************************************
	/**
	 * - pass in a two-dimensional ragged array of doubles and a column index and
	 *  returns the smallest element in that column. Column index 0 is the first column in the array. 
	 *  If a row doesn’t contain that column,it is not an error, that row will not participate in this method.
	 * @param data
	 * @param row
	 * @return
	 */
	//***************************************************************************************************************************
	public static double getLowestInRow(double[][] data, int row)
	{
		double MinValue=data[row][0];;
		for (int j = 1 ; j<data[row].length;j++)	// returns the greater value in the row		
		{
			if (data[row][j]<MinValue)
			{
				MinValue=data[row][j];
			}
		}
		return MinValue;
	}
	//***************************************************************************************************************************
	/**
	 * pass in a two-dimensional ragged array of doubles and a column index and returns the index
	 *  of the smallest element in that column. Column index 0 is the first column in the array. If a row doesn’t contain that column,
	 *  it is not an error, that row will not participate in this method.
	 * @param data
	 * @param col
	 * @return
	 */
	//***************************************************************************************************************************
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		int index = 0;
		for(int i = 0; i <data.length;i++)
		{
			if (data[i].length> col)
			{
				if (data[i][col]<data[index][col])
				{
					index=i;
				}
			}
		}
		return index; 
	}
	//***************************************************************************************************************************
	/**
	 * pass in a two-dimensional ragged array of doubles and returns the largest element in the array.
	 * @param data
	 * @return
	 */
	//***************************************************************************************************************************
	public static double getHighestInArray(double[][] data)
	{
		double MaxValue = data[0][0]; 
		for (int i =0 ; i<data.length; i++)//repeat the row 
		{
			for(int j = 0; j < data[i].length;j++)//repeat the column
			{
				if (data[i][j]>=MaxValue)
				{
					MaxValue=data[i][j];
				}
				
			}
		}
	
		return MaxValue;
	}
		
	
	//***************************************************************************************************************************
	/**
	 * pass in a two-dimensional ragged array of doubles and returns the smallest element in the array.
	 * @param data
	 * @return
	 */
	//***************************************************************************************************************************
	public static double getLowestInArray(double[][] data)
	{
		double MaxValue = data[0][0]; 
		for (int i =0 ; i<data.length; i++)//repeat the row 
		{
			for(int j = 0; j < data[i].length;j++)//repeat the column
			{
				if (data[i][j]<=MaxValue)
				{
					MaxValue=data[i][j];
				}
				
			}
		}
	
		return MaxValue;
	}
	//***************************************************************************************************************************
	/**
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	//***************************************************************************************************************************
	public static double getLowestInColumn(double[][] data, int col)
	{
		double lowest =data[0][col];
		for(int i =0 ; i < data.length;i++)
		{
			if (col <= data[i].length-1)
			{
				if(data[i][col]<lowest)
				{
					lowest = data[i][col];
				}
			}
		}
		return lowest; 
	}
	
}
