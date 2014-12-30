package librarymanager.fileaccess.readers;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import librarymanager.entity.BookEntry;
import librarymanager.util.StatusEnum;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class TxtDataReader implements DataReader{
    private static final Log log = LogFactory.getLog(TxtDataReader.class);

    @Override
    public List<BookEntry> readFromFile(Path fileName) {
        try {
            List<String> lines = Files.readAllLines(fileName, UTF_8);
            List<BookEntry> bookEntry = convertToBookEntry(lines);
            return bookEntry;
        } catch (IOException e) {
            log.error("Error Reading File", e);
        }

        return null;
    }

    private List<BookEntry> convertToBookEntry(List<String> lines) {
        List<BookEntry> bookEntries = new ArrayList<>();
        for(String line: lines) {
    		String[] split = line.split("\t");
    		BookEntry entry = new BookEntry.Builder()//
    		.isbnCode(split[0]).bookName(split[1])//
    		.status(StatusEnum.getEnumFrom(split[2])).borrowedBy(split[3])//
    		.startDate(split[4]).endDate(split[5]).build();
    		bookEntries.add(entry);
        }
        return bookEntries;
    }
}
