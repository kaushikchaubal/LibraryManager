package librarymanager.util;

import static librarymanager.util.StatusEnum.BORROWED;
import static librarymanager.util.StatusEnum.DISCARDED;
import static librarymanager.util.StatusEnum.RECEIEVED;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StatusEnumTest {

	@Test
	public void testGetEnumFrom() {
		StatusEnum actualValue1 = StatusEnum.getEnumFrom("b");
		assertEquals(BORROWED, actualValue1);
		
		StatusEnum actualValue2 = StatusEnum.getEnumFrom("r");
		assertEquals(RECEIEVED, actualValue2);
		
		StatusEnum actualValue3 = StatusEnum.getEnumFrom("d");
		assertEquals(DISCARDED, actualValue3);
	}

}
