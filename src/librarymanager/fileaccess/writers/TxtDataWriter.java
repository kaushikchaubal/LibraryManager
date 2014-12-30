package librarymanager.fileaccess.writers;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import librarymanager.entity.BookEntry;

public class TxtDataWriter implements DataWriter{
    @Override
    public void writeInFile(Path fileName, List<BookEntry> readData, BookEntry newData) throws IOException {
        readData.add(newData);
        List<String> readDataString = convertToString(readData);
        Files.write(fileName, readDataString, UTF_8);
    }

    private List<String> convertToString(List<BookEntry> readData) {
        List<String> bookEntryString = new ArrayList<>();
        for(BookEntry bookEntry: readData) {
            bookEntryString.add(bookEntry.toString());
        }
        return bookEntryString;
    }
}
