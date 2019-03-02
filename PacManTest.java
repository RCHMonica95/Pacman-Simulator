import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * PacManTest class tests individual units to check if it works as expected by passing values.
 * 
 * @author Monica
 */
public class PacManTest {

	PacMan pacman;
	
	@Before
    public void setUp() {
		pacman = new PacMan();
    }
	
	/**
	 * Test cases to check whether x is between 0 and 5
	 */
	@Test
	public void testCheck_XPosition001() {
		int x=0;
		
		boolean expected = true;			
		boolean actual = pacman.check_XPosition(x);
			
		assertEquals(expected,actual);
	}
		
	@Test
	public void testCheck_XPosition002() {
		int x=-1;
		
		boolean expected = false;
		boolean actual = pacman.check_XPosition(x);
			
		assertEquals(expected,actual);
	}
		
	@Test
	public void testCheck_XPosition003() {
		int x=6;
			
		boolean expected = false;
		boolean actual = pacman.check_XPosition(x);
			
		assertEquals(expected,actual);
	}
		
	/**
	 * Test cases to check whether y is between 0 and 5
	 */	
	@Test
	public void testCheck_YPosition001() {
		int y=0;
		
		boolean expected = true;
		boolean actual = pacman.check_YPosition(y);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCheck_YPosition002() {
		int y=-1;
		
		boolean expected = false;
		boolean actual = pacman.check_YPosition(y);
			
		assertEquals(expected,actual);
	}
		
	@Test
	public void testCheck_YPosition003() {
		int y=6;
		
		boolean expected = false;
		boolean actual = pacman.check_YPosition(y);
			
		assertEquals(expected,actual);
	}

	/**
	 * Test cases to check whether face value is NORTH, SOUTH,EAST or WEST
	 */	
	@Test
	public void testCheckDirection001() {
		String f = "NORTH";
		
		boolean expected = true;
		boolean actual = pacman.checkDirection(f);
		assertEquals(expected,actual);	
	}
		
	@Test
	public void testCheckDirection002() {
		String f = "nort";
		
		boolean expected = false;
		boolean actual = pacman.checkDirection(f);
		assertEquals(expected,actual);	
	}
		
	@Test
	public void testCheckDirection003() {
		String f = "";
		
		boolean expected = false;
		boolean actual = pacman.checkDirection(f);
		assertEquals(expected,actual);	
	}
	
	/**
	 * Test cases to check whether all three inputs x,y,f are valid and are 
	 * within the grid
	 */
	@Test
	public void testCheckPlacedPosition001() {
		int x=0;
		int y=0;
		String face ="NORTH";
		
		String expected = "valid";
		String actual = pacman.checkPlacedPosition(x, y,face);
		
		assertEquals(expected,actual);			
	}
	
	@Test
	public void testCheckPlacedPosition002() {
		int x=-1;
		int y=0;
		String face ="NORTH";
		
		String expected = "invalid";
		String actual = pacman.checkPlacedPosition(x, y,face);
		
		assertEquals(expected,actual);			
	}
	
	@Test
	public void testCheckPlacedPosition003() {
		int x=6;
		int y=0;
		String face ="NOR";
		
		String expected = "invalid";
		String actual = pacman.checkPlacedPosition(x, y,face);
		
		assertEquals(expected,actual);			
	}
	
	@Test
	public void testCheckPlacedPosition004() {
		int x=0;
		int y=-1;
		String face ="EAST";
		
		String expected = "invalid";
		String actual = pacman.checkPlacedPosition(x, y,face);
		
		assertEquals(expected,actual);			
	}
	
	/**
	 * Test cases to check whether all three inputs x,y,f are in the format
	 * as expected and are within the grid.
	 */
	@Test
	public void testcheckPlaceInputFormat001() {

		String pos ="0,0,EAST";
		
		boolean expected = true;
		boolean actual = pacman.checkPlaceInputFormat(pos);
		
		assertEquals(expected,actual);			
	}
	
	@Test
	public void testcheckPlaceInputFormat002() {

		String pos ="0,0EAST";
		
		boolean expected = false;
		boolean actual = pacman.checkPlaceInputFormat(pos);
		
		assertEquals(expected,actual);			
	}
	
	/**
	 * Move
	 * testMove001 to check whether move command moves further as expected
	 * 
	 */
	@Test
	public void testMove001() {
		pacman.xValue = 3;
		pacman.yValue = 0;
		pacman.fValue = "WEST";
		
		String expected = "PacMan is at x:"+2+" y:"+0+" face:"+"WEST";
		String actual = pacman.move();
		assertEquals(expected,actual);
	}
	
	/**
	 * Move
	 * testMove002 to check whether move command asks the users to place PacMan on the grid
	 * if it is not placed.
	 */
	@Test
	public void testMove002() {
		
		String expected = "PacMan must be placed to move";
		String actual = pacman.move();
		assertEquals(expected,actual);
	}
	
	/**
	 * Move
	 * testMove003 to check whether move command prevents 
	 * PacMan to move off the grid 
	 */
	@Test
	public void testMove003() {
		pacman.xValue = 0;
		pacman.yValue = 0;
		pacman.fValue = "WEST";
		
		String expected = "PacMan is going to fall please select some other command";
		String actual = pacman.move();
		assertEquals(expected,actual);
	}

	/**
	 * Turn Left
	 * testTurnLeft001 to check whether turnLeft rotates PacMan to 90 degrees
	 * after placing it on the grid.
	 */
	@Test
	public void testTurnLeft001() {
		pacman.xValue = 0;
		pacman.yValue = 0;
		pacman.fValue = "WEST";
		
		String expected = "PacMan is at x:"+0+" y:"+0+" face:"+"SOUTH";
		String actual = pacman.turnLeft();
		assertEquals(expected,actual);
	}
	
	/**
	 * Turn Left
	 * testTurnLeft002 to check whether turnLeft command asks the users to place PacMan on the grid
	 * if it is not placed.
	 */
	@Test
	public void testTurnLeft002() {
		
		String expected = "PacMan must be placed to turn left";
		String actual = pacman.turnLeft();
		assertEquals(expected,actual);
	}

	/**
	 * Turn Right
	 * testTurnRight001 to check whether turnRight rotates PacMan to 90 degrees
	 * after placing it on the grid.
	 */
	@Test
	public void testTurnRight001() {
		pacman.xValue = 0;
		pacman.yValue = 0;
		pacman.fValue = "WEST";
		
		String expected = "PacMan is at x:"+0+" y:"+0+" face:"+"NORTH";
		String actual = pacman.turnRight();
		assertEquals(expected,actual);
	}
	
	/**
	 * Turn Right
	 * testTurnRight002 to check whether turnRight command asks the users to place PacMan on the grid
	 * if it is not placed.
	 */
	@Test
	public void testTurnRight002() {
		
		String expected = "PacMan must be placed to turn right";
		String actual = pacman.turnRight();
		assertEquals(expected,actual);
	}

	/**
	 * Report
	 * testReport001 to check whether report command produces the position of PacMan
	 * after placing it on the grid.
	 */
	@Test
	public void testReport001() {
		pacman.xValue = 1;
		pacman.yValue = 2;
		pacman.fValue = "EAST";
		
		String expected = "OUTPUT - x:"+1+" y:"+2+" face:"+"EAST";
		String actual = pacman.report();
		
		assertEquals(expected,actual);	
	}
	
	/**
	 * Report
	 * testReport002 to check whether report command asks the users to place PacMan on the grid
	 * if it is not placed.
	 */
	@Test
	public void testReport002() {
		
		String expected = "PacMan must be placed to report";
		String actual = pacman.report();
		
		assertEquals(expected,actual);	
	}
	
}
