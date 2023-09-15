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
	}

  /** Argument constructor
   * @param world - World grid on which this Doodlebug lives
   * @param x - Initial x coordinate position of this Doodlebug
   * @param y - Initial y coordinate position of this Doodlebug
   */
	public Doodlebug(World world, int x, int y) {
	   // ITP 220 - complete this code
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
	}

	/** Method defining what happens when a Doodlebug breeds. 
	 *  - This method must check that the Doodlebug is able to breed and 
	 *     may reset it if the Doodlebug breeds successfully.
	 *  - The Doodlebug must search all locations around it randomly.
	 */
	public void breed() {
	   // ITP 220 - complete this code
	}

	/** Method to determine whether the Doodlebug is currently starving.
	 * @return boolean - TRUE if the Doodlebug is starving
	 */
	public boolean starve()	{
	   // ITP 220 - complete this code
	}

	/** Returns a displayable character for this Doodlebug (represented by "X")
	 */
	public String getPrintableChar()	{
		return "X";
	}
}
