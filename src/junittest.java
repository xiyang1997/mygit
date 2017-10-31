import static org.junit.Assert.*;
import org.junit.Before; 
import org.junit.Test;
public class junittest {
	public final World world = new World(40, 50);
	@Before
	public void setUp() throws Exception {
	}
	/**
	 * 
	 */
	@Test
	public void testset() {
		world.setArrow();
		if (world.pauseshape == world.arrow)
			System.out.println("设置箭头形状");
		world.setSquare();
		if (world.pauseshape == world.square)
			System.out.println("设置square状");
	}
}
