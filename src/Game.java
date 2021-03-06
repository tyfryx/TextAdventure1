import java.util.ArrayList;
import java.util.Scanner;


public class Game {
	private ArrayList<Room> rooms;
	private Room currentRoom;

	public Game()
	{
		currentRoom = new Room(null, null);
		this.rooms = new ArrayList<Room>();
		this.createRooms();
		this.setupNewGame();
	}
	
	private void createRooms()
	{
		Room entry = new Room("Entry", "You stand in a room with large curtains on the walls");
		Room diningRoom = new Room("Dining Room", "The smell of a recent feast makes your stomach rumble, and mouth water");
		Room captainQuarters = new Room("Captain's Quarters", "The office of this particular captain shows a recent struggle");
		Room courtyard = new Room("Courtyard", "An eerie silence looms, best if you go back inside");
		Room kitchen = new Room("Kitchen", "This kitchen is quite clean");
		
		courtyard.addExit(entry);
		
		entry.addExit(diningRoom);
		entry.addExit(captainQuarters);
		entry.addExit(courtyard);
		
		diningRoom.addExit(entry);
		diningRoom.addExit(kitchen);
		
		kitchen.addExit(diningRoom);
		
		captainQuarters.addExit(entry);
		
		rooms.add(entry);
		rooms.add(diningRoom);
		rooms.add(captainQuarters);
		rooms.add(courtyard);
	}
	public void gameLoop()
	{
		boolean playing = true;
		while(playing)
		{
			boolean movedRoom = false;
			this.showRoomInfo();		

			while(!movedRoom)
			{
				String input = this.input();
				for(Room room : currentRoom.getExits())
				{
					if(room.getName().contentEquals(input))
					{
						this.moveRoom(room);
						movedRoom = true;
					}
				}
				if(!movedRoom)
				{
					System.out.println("I don't know what that means");
				}
			}
		}
	}
	private String input()
	{
		String input = "error";
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();	

		return input;
	}
	
	private void moveRoom(Room nextRoom)
	{
		this.currentRoom = nextRoom;
	}
	
	private void setupNewGame()
	{
		for(Room room : rooms)
		{
			if(room.getName() == "Entry")
				currentRoom = room;
		}
	}
	
	private void showRoomInfo()
	{
		System.out.println(currentRoom.getEnteredRoomString());
	}
}
