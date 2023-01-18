package TestTask;

import java.util.ArrayList;
import java.util.List;

public class Params {

    private String inputType;
    private String sortType;
    private String outputFile;
    private List<String> inputFiles;

    public Params() {
        inputFiles = new ArrayList<>();
    }

    public void addInputFile(String str) {
        inputFiles.add(str);
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }

    public void setInputFiles(List<String> inputFiles) {
        this.inputFiles = inputFiles;
    }
}
