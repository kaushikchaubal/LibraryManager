package librarymanager.fileaccess;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import librarymanager.entity.BookEntry;
import librarymanager.fileaccess.readers.DataReader;
import librarymanager.fileaccess.readers.TxtDataReader;
import librarymanager.fileaccess.writers.DataWriter;
import librarymanager.fileaccess.writers.TxtDataWriter;
import librarymanager.util.FilesSupportedEnum;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileAccessor {
	private static final Log log = LogFactory.getLog(FileAccessor.class);
    private DataReader dataReader;
    private DataWriter dataWriter;

    public DataReader getDataReader() {
        return dataReader;
    }

    public void setDataReader(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    public DataWriter getDataWriter() {
        return dataWriter;
    }

    public void setDataWriter(DataWriter dataWriter) {
        this.dataWriter = dataWriter;
    }
    
    public void setupFileAccess(String branch) {
		String fileType = branch.substring(branch.indexOf("."));

		switch (FilesSupportedEnum.getEnumFrom(fileType)) {
		case TXT:
			this.setDataReader(new TxtDataReader());
			this.setDataWriter(new TxtDataWriter());
			break;
		case XML:
			System.out.println("To be implemented");
			break;
		case XMLGZ:
			System.out.println("To be implemented");
			break;
		default:
		}
	}
    
    public void updateEntry(BookEntry newEntry, String branch) {
		try {
			Path userFile = FileSystems.getDefault().getPath(branch);
			List<BookEntry> file = getDataReader().readFromFile(userFile);
			getDataWriter().writeInFile(userFile, file, newEntry);
			log.info("Task Updated Successfully");
		} catch (Exception e) {
			log.error(e.getStackTrace());
			System.exit(-1);
		}
	}
}
