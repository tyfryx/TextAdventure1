import java.util.ArrayList;


public class Room {
	private String name;
	private ArrayList<Room> exits;
	private String description;
	
	public Room(String name, String description)
	{
		this.exits = new ArrayList<Room>();
		this.name = name;
		this.description = description;
	}
	public void addExit(Room room)
	{
		this.exits.add(room);
	}
	public ArrayList<Room> getExits()
	{
		return this.exits;
	}
	
	public String getRoomInfo()
	{
		return this.name + ": " + this.description;
	}
	
	public String getName()
	{
		return this.name;
	}
	public String getExitInfo()
	{
		String info = "Exits: ";
		for(Room room : exits)
		{
			info += room.getName() + ", ";
		}
		return info;
	}
	public String getEnteredRoomString()
	{
		return this.getRoomInfo() + "\n" + this.getExitInfo() + "\n";
	}
}
