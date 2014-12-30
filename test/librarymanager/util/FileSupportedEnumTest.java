package librarymanager.util;

import static librarymanager.util.FilesSupportedEnum.TXT;
import static librarymanager.util.FilesSupportedEnum.XML;
import static librarymanager.util.FilesSupportedEnum.XMLGZ;
import static org.junit.Assert.*;

import org.junit.Test;

public class FileSupportedEnumTest {

	@Test
	public void testGetEnumFrom() {
		FilesSupportedEnum actualValue1 = FilesSupportedEnum.getEnumFrom(".txt");
		assertEquals(TXT, actualValue1);
		
		FilesSupportedEnum actualValue2 = FilesSupportedEnum.getEnumFrom(".xml");
		assertEquals(XML, actualValue2);
		
		FilesSupportedEnum actualValue3 = FilesSupportedEnum.getEnumFrom(".xml.gz");
		assertEquals(XMLGZ, actualValue3);
	}
}
