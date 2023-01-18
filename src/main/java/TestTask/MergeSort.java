package TestTask;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort {

    public Params parse(String[] args) throws IOException {
        Params params = new Params();
        for (String str : args) {
            if ("-a".equals(str) || "-d".equals(str)) {
                params.setSortType(str);
            }
            if ("-s".equals(str) || "-i".equals(str)) {
                params.setInputType(str);
            }
            if (str.contains("out")) {
                params.setOutputFile(str);
            }
            if (str.contains("input")) {
                params.addInputFile(str);
            }
        }
        return params;
    }

    public void run(Params params) throws IOException {
        if (params.getInputType().contains("-i")) {
            SortInteger sortInteger = new SortInteger();
            List<Integer> array = new ArrayList<>(sortInteger.filesInObjectInteger(params));
            array = sortInteger.sortMerge(array);
            if ("-d".equals(params.getSortType())) {
                Collections.reverse(array);
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(params.getOutputFile()))) {
                for (Integer listInt : array) {
                    bufferedWriter.write(String.valueOf(listInt));
                    bufferedWriter.newLine();
                }
            }
        }
        else {
            SortString sortString = new SortString();
            List<String> array = new ArrayList<>(sortString.filesInObjectString(params));
            array = sortString.sortMerge(array);
            if ("-d".equals(params.getSortType())) {
                Collections.reverse(array);
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(params.getOutputFile()))) {
                for (String listStr : array) {
                    bufferedWriter.write(listStr);
                    bufferedWriter.newLine();
                }
            }
        }
    }


}

