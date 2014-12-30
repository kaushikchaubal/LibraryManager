package librarymanager.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestManipulator {
	
	@Test
	public void testAdd(){
		int first = 10;
		int second = 20;
		
		Manipulator manipulate = new Manipulator();
		int result = manipulate.sum(first, second);
		assertEquals("Sum should be but is:", 30, result);
	}
	

}
