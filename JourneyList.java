import java.util.ArrayList;
public class JourneyList
{
	private ArrayList<Journey> journeyList;
	private static final String ERROR_READING = "Error during reading process: ";
	private static final String ERROR_NB_ARGUMENTS = "Input line should be 'reg nb,destination,nb person'";
	
	public JourneyList()
	{
		this.journeyList=new ArrayList<Journey>();
	}

	public void setJourneyList(ArrayList<Journey> journeyList)
	{
		this.journeyList = journeyList;
	}

	public ArrayList<Journey> getJourneyList()
	{
		return this.journeyList;
	}

	public boolean addJourney(Journey j)
	{
		return j != null ? journeyList.add(j) : false;
	}
}