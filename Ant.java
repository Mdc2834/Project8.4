/** Ant.java
 *  This class defines an Ant's attributes and behavior.
 */
public class Ant extends Organism {
	/** Constant defining the number of moves required before an Ant can breed */
	  public static final int ANTBREED = 3;	
  
	  /** Empty Constructor */
	   public Ant() {
		  // ITP 220 - complete this code
		  super();
	  }
  
	/** Argument constructor 
	 * @param world - World grid on which this Ant lives
	 * @param x - Initial x coordinate position of this Ant
	 * @param y - Initial y coordinate position of this Ant
	 */
	  public Ant(World world, int x, int y) {
		 // ITP 220 - complete this code
		  super(world, x, y);
  
	  }
  
	  /** Method defining what happens when an Ant moves.
	   *  This method must choose a single location randomly.  If it is 
	   *   occupied or off the grid, the Ant will not move anywhere.
	   */
	  public void move() {
		 // ITP 220 - complete this code
		  // Randomly choose a direction
		  if (Math.random() < 0.25) {
			  x++;
		  } else if (Math.random() < 0.5) {
			  x--;
		  } else if (Math.random() < 0.75) {
			  y++;
		  } else {
			  y--;
		  }
		  // Get the location in that direction
		  if (world.getAt(x, y) != null) {
			  // If the location is occupied, do nothing
			  return;
		  }
		  // Check if the location is valid
		  if (x < 0 || x >= World.WORLDSIZE || y < 0 || y >= World.WORLDSIZE) {
			  // If the location is off the grid, do nothing
			  return;
		  }
		  // If valid, move there
		  if (world.getAt(x, y) == null) {
			  world.setAt(x, y, this);
			  world.setAt(x, y, null);
		  }
		  // If not valid, do nothing
		  if (world.getAt(x, y) != null) {
			  return;
		  }
		  // Set moved to true
		  setMoved(true);
		  // Increment breedTicks
		  breedTicks++;
	  }
  
	  /** Method defining what happens when an Ant breeds. 
	   *  - This method must check that the Ant is able to breed and 
	   *     may reset it if the Ant breeds successfully.
	   *  - The Ant must search all locations around it randomly.
	   */
	  public void breed() {
		 // ITP 220 - complete this code
		  // Check if the Ant can breed
		  if (breedTicks < ANTBREED) {
			  return;
		  }
		  // Reset breedTicks
		  breedTicks = 0;
		  // Randomly choose a direction
		  if (Math.random() < 0.25) {
			  x++;
		  } else if (Math.random() < 0.5) {
			  x--;
		  } else if (Math.random() < 0.75) {
			  y++;
		  } else {
			  y--;
		  }
		  // Get the location in that direction
		  while (world.getAt(x, y) != null) {
			  // If the location is occupied, do nothing
			  return;
		  }
		  // Check if the location is valid
		  if (x < 0 || x >= World.WORLDSIZE || y < 0 || y >= World.WORLDSIZE) {
			  // If the location is off the grid, do nothing
			  return;
		  }
		  // If valid, breed there
		  if (world.getAt(x, y) == null) {
			  Ant a1 = new Ant(world, x, y);
		  }
		  // If not valid, do nothing
		  if (world.getAt(x, y) != null) {
			  return;
		  }
		  // Set moved to true
		  setMoved(true);
		  // Increment breedTicks
		  breedTicks++;
  
	  }
  
	  /** Method to determine whether the Ant is currently starving.
	   * @return boolean 
	   */
	  public boolean starve()	{
		 // ITP 220 - complete this code
		  // Ants don't starve
		  return false;
  
	  }
  
	  /** Returns a displayable character for this Ant (represented by "o")
	   */
	  public String getPrintableChar()	{
		  return "o";
	  }
  }
  
  