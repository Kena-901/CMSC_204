public class Road implements Comparable<Road>{
	
	private Town source;
	private Town destination;
	private int weight;
	private String name;
	
	/**
	 * constructor for Road object
	 * @param source - first town
	 * @param destination - second town
	 * @param weight - distance between towns
	 * @param name - name of road
	 */
	public Road(Town source, Town destination, int degree, String name) {
		this.source=source;
		this.destination=destination;
		weight=degree;
		this.name=name;
	}
	/**
	 * constructor with weight preset at 1
	 * @param source - first town
	 * @param destination - second town
	 * @param name - name of road
	 */
	public Road(Town source, Town destination, String name) {
		this(source,destination,1,name);
		
	}
	/**
	 * Getter method for source
	 */
	public Town getSource() {
		return source;
	}
	/**
	 * Setter method for source
	 */
	public void setSource(Town source) {
		this.source = source;
	}
	
	/**
	 * Getter method for destination
	 */
	public Town getDestination() {
		return destination;
	}
	
	/**
	 * Setter method for destination
	 */
	public void setDestination(Town destination) {
		this.destination = destination;
	}
	
	/**
	 * Getter method for weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * Setter method for weight
	 */
	public void setWeight(int degree) {
		this.weight = degree;
	}
	/**
	 * Getter method for name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter method for name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns true only if the edge contains the given town
	 * @param town vertex of the graph
	 * @return true only if the edge contains the given vertex
	 */
	public boolean contains(Town town) {
		return ((town.getName().equalsIgnoreCase(source.getName()))|| (town.getName().equalsIgnoreCase(destination.getName())));
	}
	/**
	 * @return 0 if the road names are the same, a positive or negative number if the road names are not the same
	 */
	@Override
	public int compareTo(Road r) {
		return name.compareToIgnoreCase(r.getName());
	}
	/**
	 *Returns true if each of the ends of the road r is the same as the ends of this road. 
	 *Remember that a road that goes from point A to point B is the same as a 
	 *road that goes from point B to point A.
	 * @param r -  road object to compare it to
	 * @return true if each of the ends of the road r is the same as the ends of this road
	 */
	@Override
	public boolean equals(Object r) {
		if(!(r instanceof Road)) {
			return false;
		}
		else {
			String town1=((Road) r).getSource().getName();
			String town2=((Road) r).getDestination().getName();
			if((source.getName().equalsIgnoreCase(town1)||source.getName().equalsIgnoreCase(town2))&&(destination.getName().equalsIgnoreCase(town1)||destination.getName().equalsIgnoreCase(town2))) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	/**
	 * @return string format of road information
	 */
	@Override
	public String toString() {
		return name + " connects " + source.getName() + " and " + destination.getName()+" and is "+ weight + " miles long";
		
	}

}
