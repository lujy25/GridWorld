import static org.junit.Assert.*;
import org.junit.*;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
public class JumperTest {
    private static Jumper jumper = new Jumper();
    @Before
	public void beforeTest() {
	ActorWorld world = new ActorWorld();
	world.add(new Location(4,1),jumper);
    }
    
    @Test
	public void testMove() {
	Location oldLocation = jumper.getLocation();
	Location next = oldLocation.getAdjacentLocation(jumper.getDirection());
	Location desLocation = next.getAdjacentLocation(jumper.getDirection());
	Grid<Actor> gr = jumper.getGrid();
	if (gr.isValid(desLocation)) {
	    jumper.move();
	    assertEquals(desLocation,jumper.getLocation());
	} else{
	    jumper.move();
	    assertEquals(null,jumper.getLocation());
	
	}
	    
    }
    @Test
	public void testCanMove() {
	Location loc = jumper.getLocation();
	Location next = loc.getAdjacentLocation(jumper.getDirection());
	Location next_next = next.getAdjacentLocation(jumper.getDirection());
	Grid<Actor> gr = jumper.getGrid();
	if (!gr.isValid(next_next)) {
	    assertEquals(false,jumper.canMove());
	} else {
	    Actor neighbor = gr.get(next_next);
	    assertEquals(neighbor == null, jumper.canMove());
	}
    }
}