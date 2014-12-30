package librarymanager.fileaccess.readers;

import java.nio.file.Path;
import java.util.List;

import librarymanager.entity.BookEntry;

public interface DataReader {

    public List<BookEntry> readFromFile(Path fileName);

}
