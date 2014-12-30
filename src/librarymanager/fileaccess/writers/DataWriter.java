package librarymanager.fileaccess.writers;

import java.nio.file.Path;
import java.util.List;

import librarymanager.entity.BookEntry;

public interface DataWriter {

    public void writeInFile(Path fileName, List<BookEntry> readData, BookEntry newData) throws Exception;

}
