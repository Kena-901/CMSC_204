
import java.util.ArrayList;

public class Town implements Comparable <Town>{

	private String name;
	private ArrayList<Town> adjTowns;
	
	/**
	 * constructor with name of town
	 * @param name - name of town
	 */
	public Town(String name) {
		this.name=name;
		adjTowns=new ArrayList<Town>();
		
	}
	/**
	 * copy constructor
	 * @param templateTown - an instance of Town
	 */
	public Town(Town templateTown) {
		this(templateTown.getName());
		setAdjacentTowns(templateTown.getAdjacentTowns());
	}
	/** Setter for name
	 */
	public void setName(String name) {
		this.name=name;
	}
	/**Getter for name
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets the list of adjacent towns 
	 * @param towns arrayList of adjacent towns
	 */
	public void setAdjacentTowns(ArrayList<Town> towns) {
		
		for(int i=0;i<towns.size();i++) {
			adjTowns.add(towns.get(i));
		}
	}
	/**
	 * adds a town in the list of adjacent towns
	 * @param town town to be added to the list
	 */
	public void addAdjacentTowns(Town town) {
		adjTowns.add(town);
	}
	
	/**
	 * @return reference to list of adjacent towns of a town
	 */
	public ArrayList<Town> getAdjacentTowns(){
		return adjTowns;
	}
	
	/**
	 * compareTo method
	 *@return 0 if names are equal, a positive or negative number if the names are not equal
	 */
	@Override
	public int compareTo(Town o) {
		if(o.getName().equalsIgnoreCase(name)) {
			return 0;
		}
		else {
			return name.compareToIgnoreCase(o.getName());
		}
	}
	
	/**
	 * @return hashCode of name of town
	 */
	public int hashCode() {
		return name.hashCode();
	}
	
	/**
	 * @return information of a town in a string format
	 */
	public String toString() {
		String town="";
		for(int i=0;i<adjTowns.size();i++) {
			town+=adjTowns.get(i).getName()+" ";
		}
		return "Name of Town: "+name +"\t Adjacent Towns: "+ town+"\n";
	}

}
