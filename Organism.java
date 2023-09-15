/** Doodlebug.java
 *  This class defines a Doodlebug's attributes and behavior.
 */
public class Doodlebug extends Organism {
	/** Constant defining the number of moves required before a Doodlebug
	 *   can breed. */
	  public static final int DOODLEBREED = 4;	
  
	/** Constant defining the number of moves a Doodlebug can make without
	 *   eating before it starves. */
	  public static final int DOODLESTARVE = 8;	
  
	/** Number of moves since last eating */
	  private int starveTicks;		
  
	  /** Empty Constructor
	   */
	   public Doodlebug() {
		  // ITP 220 - complete this code
		  super();
	  }
  
	/** Argument constructor
	 * @param world - World grid on which this Doodlebug lives
	 * @param x - Initial x coordinate position of this Doodlebug
	 * @param y - Initial y coordinate position of this Doodlebug
	 */
	  public Doodlebug(World world, int x, int y) {
		 // ITP 220 - complete this code
		  super(world, x, y);
	  }
   
	  /** Method defining what happens when a Doodlebug moves.
	   *  This method must randomly search all adjacent locations for a cell
	   *   occupied by an Ant (it wants to move where it can eat).
	   *  If a cell with an Ant is not found, this Doodlebug moves as an Ant,
	   *   picking a single random location and not moving if this chosen
	   *   location is not valid or is occupied.
	   */
	  public void move() {
		 // ITP 220 - complete this code
		  // Randomly choose a direction
		  // If the location is occupied, eat the ant
		  // Get the location in that direction
		  // If the location is occupied, eat the ant
		  // If the location is not occupied, move there
		  // If the location is off the grid, do nothing
		  if (Math.random() < 0.25) {
			  x++;
		  } else if (Math.random() < 0.5) {
			  x--;
		  } else if (Math.random() < 0.75) {
			  y++;
		  } else {
			  y--;
		  }
		  // If the location is occupied by an ant, eat the ant
		  if (world.getAt(x, y) instanceof Ant) {
			  world.setAt(x, y, this);
			  world.setAt(x, y, null);
			  starveTicks = 0;
		  }
		  // If the location is occupied by a doodlebug, do nothing
		  if (world.getAt(x, y) instanceof Doodlebug) {
			  return;
		  }
		  // If the location is not occupied, move there
		  if (world.getAt(x, y) == null) {
			  world.setAt(x, y, this);
			  world.setAt(x, y, null);
		  }
  
  
	  }
  
	  /** Method defining what happens when a Doodlebug breeds. 
	   *  - This method must check that the Doodlebug is able to breed and 
	   *     may reset it if the Doodlebug breeds successfully.
	   *  - The Doodlebug must search all locations around it randomly.
	   */
	  public void breed() {
		 // ITP 220 - complete this code
		  // Check if the Doodlebug can breed
		  if (breedTicks < DOODLEBREED) {
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
	  }
  
	  /** Method to determine whether the Doodlebug is currently starving.
	   * @return boolean - TRUE if the Doodlebug is starving
	   */
	  public boolean starve()	{
		 // ITP 220 - complete this code
		  // Check if the Doodlebug is starving
		  if (starveTicks < DOODLESTARVE) {
			  return false;
		  }
		  // If starving, kill the Doodlebug
		  if (starveTicks >= DOODLESTARVE) {
			  world.setAt(x, y, null);
			  return true;
		  }
		  return false;
  
	  }
  
	  /** Returns a displayable character for this Doodlebug (represented by "X")
	   */
	  public String getPrintableChar()	{
		  return "X";
	  }
  }
  