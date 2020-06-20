package api;

import java.util.Arrays;

public class FILE {

    public String fileName;
    public int fileSize;
    public String[] keywords;
    public byte[] rawData;

    public FILE(){

    }

    public FILE(String fileName, int fileSize, String[] keywords, byte[] rawData) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.keywords = keywords;
        this.rawData = rawData;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public byte[] getRawData() {
        return rawData;
    }

    @Override
    public String toString() {
        return "FILE{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", keywords=" + Arrays.toString(keywords) +
                ", rawData=" + Arrays.toString(rawData) +
                '}';
    }
}
