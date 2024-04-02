import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	private int size;
	private double loadingF = 1.5;
	private LinkedList <CourseDBElement>[] hashTable;
	
	CourseDBStructure()
	{
		this.size = 0;
		this.hashTable = null;
	}
	
	/**
	 * Constructor for CourseDBStructure class
	 * @param size - determines the size of the hash table by finding a 4K+3 prime just greater than n /loading factor.
	 */
	CourseDBStructure(int size)
	{
		boolean fkp3 = false;
		boolean aPrime = false;
		int prime,highDivisor,d;
		
		prime = (int) (size/this.loadingF);
		if(prime % 2 == 0)
		{
			prime = prime +1;
		}
		while(fkp3 == false)
		{
			while(aPrime == false)
			{
				highDivisor = (int) (Math. sqrt(prime) + 0.5);
				for(d = highDivisor; d >1; d--)
				{
					if(prime % d == 0)
						break;
				}
				if(d != 1)
					prime = prime + 2;
				else
					aPrime = true;
			}
		if((prime - 3) % 4 == 0)
			fkp3 = true;
		else
			prime = prime + 2;
			aPrime = false;
		}
		
		this.size = prime;
		this.hashTable = new LinkedList[size];;
	}

	public CourseDBStructure(String Testing,int size) {
		this.size=size;
		this.hashTable=new LinkedList[size];
	}
	
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	@Override
	public void add(CourseDBElement element) {
		int index;
		index=Math.abs(element.hashCode())% size;
		if (hashTable[index] == null) {
		      hashTable[index] = new LinkedList<CourseDBElement>();
		      hashTable[index].add(element);
		      
		    } 
		else 
		{
			try {
				get(element.getCRN()).setCredits(element.getCredits());
				get(element.getCRN()).setID(element.getID());
				get(element.getCRN()).setInstructorName(element.getInstructorName());
				get(element.getCRN()).setRoomNum(element.getRoomNum());
			} 
			catch (IOException e) { 
				hashTable[index].add(element);
			}
		}
	}
 
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		int check = 0;
		CourseDBElement result = null;
		String code=Integer.toString(crn);
		int index=Math.abs(code.hashCode())% size;
		if(hashTable[index]==null ) 
			throw new IOException();
		
		for(int j=0;j<hashTable[index].size();j++) 
		{
			if(crn!=hashTable[index].get(j).getCRN())
				check++;
			else
				result = (CourseDBElement) hashTable[index].get(j);
		}
		
		if(check == hashTable[index].size())
			throw new IOException();
		
		return result;
	}
 
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> courses=new ArrayList<String>();
		for(int i=0;i<size;i++) {
			while(hashTable[i]!=null) {
				for(int j=0;j<hashTable[i].size();j++) {
					CourseDBElement element= (CourseDBElement) hashTable[i].get(j);
					courses.add("\n"+element.toString());
				}
				break;
			}
		}
		return courses;
	}
	
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public int getTableSize() {
		return size;
	}
	
}