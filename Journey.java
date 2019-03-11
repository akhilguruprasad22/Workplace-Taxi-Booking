public class Journey
{
	private Taxi taxi;
	private Destination destination;
	private int nbPerson;
	private final static String ERROR_NULL_TAXI_DEST = "Taxi or destination cannot be null";
	private final static String ERROR_NB_PERSON_IN_TAXI = "Number of person in taxi out of bounds: ";

	public Journey(Taxi taxi, Destination destination, int nbPerson) throws NullPointerException, IllegalArgumentException
	{
		if(taxi == null || destination == null)
		{
			throw new NullPointerException(ERROR_NULL_TAXI_DEST);
		}
		if(nbPerson < 1 || taxi.getNbOfSeats() < nbPerson)
		{
			throw new IllegalArgumentException(ERROR_NB_PERSON_IN_TAXI + nbPerson);
		}
		this.taxi = taxi;
		this.destination = destination;
		this.nbPerson = nbPerson;
	}

	public Taxi getTaxi()
	{
		return this.taxi;
	}

	public void setTaxi(Taxi t)
	{
		this.taxi = t;
	}

	public Destination getDestination()
	{
		return this.destination;
	}

	public void setDestination(Destination d)
	{
		this.destination = d;
	}

	public int getNbPerson()
	{
		return this.nbPerson;
	}

	public void setNbPerson(int nbPerson)
	{
		this.nbPerson = nbPerson;
	}

	public double getJourneyFee()
	{
		double fee = 50.00;
		double distance;
		int nbPerson;
		distance = this.destination.getDistance();
		nbPerson = this.getNbPerson();
		fee = fee + (distance * 5.00 * nbPerson);
		return fee;
	}

	public void display()
	{
		System.out.println("YOUR JOURNEY DETAILS ARE:\n");
		System.out.println("Location details:");
		this.destination.display();
		System.out.println("Taxi Details:");
		this.taxi.display();
	}
}