import java.util.Scanner;
import java.io.*;
public class Manager
{
	private DestinationList destinations;
	private TaxiList available,taken;
	private JourneyList journeys;

	public Manager()
	{
		this.destinations = new DestinationList();
		this.available = new TaxiList(true);
		this.taken = new TaxiList(false);
		this.journeys = new JourneyList();
	}

	public void work()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("-----------OFFICE TAXI BOOKING SERVICE-----------");
		System.out.println("-------------------------------------------------");
		System.out.println("\n\n\n\n");
		System.out.println("Enter 1 for pickup");
		System.out.println("Enter 2 for drop");
		int ch=Integer.parseInt(sc.nextLine());
		if(ch==1)
			System.out.println("\n\nChoose pickup location from the available choices:");
		else
			System.out.println("\n\nChoose drop location from the available choices:");
		this.destinations.display();
		String location = sc.nextLine();
		Destination dest=null;
		dest = this.destinations.getDest(location);
		if(dest==null)
		{
			System.out.println("Wrong Input. Try again.");
			System.exit(0);
		}
		if(this.available.getSize()==0)
		{
			System.out.println("Sorry!! No more taxis available!! All booked!!");
		}
		else
		{
			Taxi taxi=this.available.pop();
			this.taken.addTaxi(taxi);
			System.out.println("\n\nEnter the number of people");
			int n=sc.nextInt();
			if(n>taxi.getNbOfSeats())
			{
				System.out.println("Not enough seats!! Please try booking again from the beginning!!");
				System.exit(0);
			}
			Journey journ = new Journey(taxi,dest,n);
			double fee=journ.getJourneyFee();
			System.out.println("\nYOUR BOOKING WAS SUCCESSFUL!!!\n\n");
			journ.display();
			System.out.println("----------------------HAVE A SAFE JOURNEY!!!--------------------");
		}
	}
}