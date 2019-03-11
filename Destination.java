public class Destination
{
	private String name;
	private double distance;
	private final static String ERROR_CONST_DISTANCE = "Argument distance is negative: ";
	private final static String ERROR_NAME_NULL =  "Argument name is null";
	
	public Destination(){}
	
	public Destination(String name, double distance) throws IllegalArgumentException
	{
		if(distance < 0)
		{
			throw new IllegalArgumentException(ERROR_CONST_DISTANCE + distance);
		}
		if(name == null)
		{
			throw new NullPointerException(ERROR_NAME_NULL);
		}
		this.name = name;
		this.distance = distance;
	}
	
	public void display()
	{
		System.out.println("Location Name:"+this.name);
		System.out.println("Distance:"+this.distance+"\n");
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public double getDistance()
	{
		return this.distance;
	}

	public void setDistance(double dist)
	{
		this.distance = dist;
	}

	public boolean equals(Object other)
	{
		boolean eq = false;
		if(other != null && other instanceof Destination)
		{
			Destination d = (Destination) other;
			eq = this.getName().equals(d.getName());
		}
		return eq;
	}

	
	
}