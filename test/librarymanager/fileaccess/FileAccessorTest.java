package librarymanager.fileaccess;

import static org.junit.Assert.*;

import javax.xml.ws.ServiceMode;

import librarymanager.fileaccess.readers.DataReader;
import librarymanager.fileaccess.writers.DataWriter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class FileAccessorTest {
	
	private DataReader dataReader;
	private DataWriter dataWriter;

	@Before
	private void setUp() {
		dataReader = Mockito.mock(DataReader.class);
		dataWriter = Mockito.mock(DataWriter.class);
	}
	
	@Test
	public void testUpdateEntry() {
		
	}

}
