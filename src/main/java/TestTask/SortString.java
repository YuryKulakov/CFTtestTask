package TestTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortString {

    public List<String> filesInObjectString(Params params) throws IOException {
        List<String> listParams = new ArrayList<>(params.getInputFiles().size());
        for (int i = 0; i < params.getInputFiles().size(); i++) {
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(params.getInputFiles().get(i)))) {
                String str;
                while (bufferedReader.ready()) {
                    str = bufferedReader.readLine();
                    listParams.add(str);
                }
            }
        }
        return listParams;
    }

    List<String> sortMerge(List<String> array) {
        if (array == null) {
            return null;
        } else if (array.size() < 2) {
            return array;
        }
        List<String> arrayA = array.subList(0, array.size() / 2);
        List<String> arrayB = array.subList(array.size() / 2, array.size());
        arrayA = sortMerge(arrayA);
        arrayB = sortMerge(arrayB);
        return merge(arrayA, arrayB);
    }

    private List<String> merge(List<String> arrayA, List<String> arrayB) {
        List<String> arrayC = new ArrayList<>(arrayA.size() + arrayB.size());
        int positionA = 0, positionB = 0;
        for (int i = 0; i < arrayA.size() + arrayB.size(); i++) {
            if (positionA == arrayA.size()) {
                arrayC.add(arrayB.get(positionB));
                positionB++;
            } else if (positionB == arrayB.size()) {
                arrayC.add(arrayA.get(positionA));
                positionA++;
            } else if (arrayA.get(positionA).compareTo(arrayB.get(positionB)) < 0) {
                arrayC.add(arrayA.get(positionA));
                positionA++;
            } else {
                arrayC.add(arrayB.get(positionB));
                positionB++;
            }
        }
        return arrayC;
    }
}
