/** World.java
 * The World class stores data about the world by creating a
 * WORLDSIZE by WORLDSIZE array of type Organism.
 * Null indicates an empty spot, otherwise a valid object
 * indicates an ant or doodlebug.  To determine which,
 * invoke the virtual function getType of Organism that should return
 * ANT if the class is of type ant, and DOODLEBUG otherwise.
 */
public class World extends Organism {
	public static final int WORLDSIZE = 20;
	private static final int ANT_BREED = 0;

	/**
	 * 2-D Array of Organisms that make up a WORLDSIZE x WORLDSIZE
	 * grid.  Some x,y positions may be null, some may contain Organisms
	 * of Ant or Doodlebug types.
	 */
	private Organism[][] grid;

	@Override
	public void breed() {

	}

	@Override
	public void move() {

	}

	@Override
	public boolean starve() {
		return false;
	}

	@Override
	public String getPrintableChar() {
		return null;
	}

	/**
	 * Empty constructor.
	 * Initialize the grid to contain no organisms
	 */
	public World() {
		grid = new Organism[WORLDSIZE][WORLDSIZE];
	}

	/**
	 * Returns the Organism stored in the grid array at x,y.
	 *
	 * @param x - X grid coordinate
	 * @param y - Y grid coordinate
	 * @return Organism - organism occupying this x,y coordinate of the
	 * grid, or NULL if no organism is at that location.
	 */
	public Organism getAt(int x, int y) {
		if ((x >= 0) && (x < World.WORLDSIZE) &&
				(y >= 0) && (y < World.WORLDSIZE)) {
			return grid[x][y];
		}

		// return null for out of bounds checks
		return null;
	}

	/**
	 * Puts the Organism on the grid at x,y.
	 *
	 * @param x   - X grid coordinate
	 * @param y   - Y grid coordinate
	 * @param org (Organism) - to place on the grid
	 */
	public void setAt(int x, int y, Organism org) {
		if ((x >= 0) && (x < World.WORLDSIZE) &&
				(y >= 0) && (y < World.WORLDSIZE)) {
			grid[x][y] = org;
		}
	}

	/**
	 * Displays the world grid in ASCII.text with Organisms denoted by
	 * their display character, getPrintableChar()
	 */
	public void displayWorld() {
		System.out.println("\n\n*****************************************\n");
		for (int i = 0; i < World.WORLDSIZE; i++) {
			System.out.println();
			for (int j = 0; j < World.WORLDSIZE; j++) {
				if (grid[i][j] == null) {
					System.out.print(".");
				} else {
					// X for Doodle, o for Ant
					System.out.print(grid[i][j].getPrintableChar());
				}
			}
		}
		System.out.println();
	}

	/**
	 * This is the main routine that simulates one turn in the world.
	 * First, a flag for each organism is used to indicate if it has moved.
	 * This is because we iterate through the grid starting from the top
	 * looking for an organism to move. If one moves down, we don't want
	 * to move it again when we reach it.
	 * First move doodlebugs, then ants, and if they are still alive then
	 * we breed them.  If any Organism is starving at the end of this turn,
	 * it will be killed off.
	 */
	public void SimulateOneStep() {
		// For this new turn, reset all organisms to not moved
		//define world symbol


		int x = 0;
		int y = 0;
		for (int i = 0; i < World.WORLDSIZE; i++) {
			for (int j = 0; j < World.WORLDSIZE; j++) {
				if (grid[i][j] != null) {
					grid[i][j].setMoved(false);
				}
			}
		}

		// Move all Doodlebugs, checks that the Doodlebug found has not
		//  moved yet this turn (since it can move right and down to a
		//  new grid position
		for (int i = 0; i < World.WORLDSIZE; i++) {
			for (int j = 0; j < World.WORLDSIZE; j++) {
				if ((grid[i][j] != null) &&
						(grid[i][j] instanceof Doodlebug) &&
						(!grid[i][j].getMoved())) {
					// NOTE: setMoved() is used to track whether an Organism
					//  has "attempted" to move so it is not moved again,
					//  there is no other purpose for this variable
					grid[i][j].setMoved(true);
					grid[i][j].move();
				}
			}
		}

		// Move all Ants - similar to above Doodlebug move loop
		for (int i = 0; i < World.WORLDSIZE; i++) {
			for (int j = 0; j < World.WORLDSIZE; j++) {
				// ITP 220 - complete this code
				// Check if the Ant has moved
				if ((grid[i][j] != null) &&
						(grid[i][j] instanceof Ant) &&
						(!grid[i][j].getMoved())) {
					// NOTE: setMoved() is used to track whether an Organism
					//  has "attempted" to move so it is not moved again,
					//  there is no other purpose for this variable
					grid[i][j].setMoved(true);
					grid[i][j].move();
				}
				// If not, move the Ant
				if (Math.random() < 0.25) {
					x++;
				} else if (Math.random() < 0.5) {
					x--;
				} else if (Math.random() < 0.75) {
					y++;
				} else {
					y--;
				}
				// Set moved to true
				if (world.getAt(x, y) == null) {
					world.setAt(x, y, this);
					world.setAt(x, y, null);
				}
				// Increment breedTicks
				breedTicks++;
				// Check if the Ant can breed
				if (breedTicks < ANT_BREED) {
					return;
				}
				// If so, breed the Ant
				if (world.getAt(x, y) == null) {
					Ant a1 = new Ant(world, x, y);
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
				if (world.getAt(x, y) != null) {
				}

			}

			// Kill off any starving Organisms
			for (int i = 0; i < World.WORLDSIZE; i++) {
				for (int j = 0; j < World.WORLDSIZE; j++) {
					// ITP 220 - complete this code
					// Check if the Organism is starving
					if (starveTicks > DOODLESTARVE) {
						// If so, kill it
						world.setAt(x, y, null);
					}
				}
			}

			// Breed any Organisms that have moved and have enough breedTicks
			//  to move.
			for (int i = 0; i < World.WORLDSIZE; i++) {
				for (int j = 0; j < World.WORLDSIZE; j++) {
					// ITP 220 - complete this code
					// Check if the Organism has moved
					if (moved == true) {
						// If so, check if it can breed
						if (breedTicks > DOODLEBREED) {
							// If so, breed it
							breed();
						}
					}
				}
			}
		}
	}
}