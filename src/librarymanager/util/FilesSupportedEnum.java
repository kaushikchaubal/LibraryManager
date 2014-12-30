package librarymanager.util;

public enum FilesSupportedEnum {
    TXT(".txt"), XML(".xml"), XMLGZ(".xml.gz");

    private String fileExtension;

    private FilesSupportedEnum(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public static FilesSupportedEnum getEnumFrom(String input) {
        for (FilesSupportedEnum values : values()) {
            if (values.fileExtension.equals(input)) {
                return values;
            }
        }

        return null;
    }


}
