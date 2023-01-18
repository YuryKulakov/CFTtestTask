package TestTask;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortInteger {

    public List<Integer> filesInObjectInteger(Params params) throws IOException {
        List<Integer> listParams = new ArrayList<>();
        for (int i = 0; i < params.getInputFiles().size(); i++) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(params.getInputFiles().get(i)))) {
                String str;
                while (bufferedReader.ready()) {
                    str = bufferedReader.readLine();
                    if(StringUtils.isNumeric(str)) {
                        listParams.add(Integer.valueOf(str));
                    }
                }
            }
        }
        return listParams;
    }

    public List<Integer> sortMerge(List<Integer> array) {
        if (array == null) {
            return null;
        } else if (array.size() < 2) {
            return array;
        }
        List<Integer> arrayA = array.subList(0, array.size() / 2);
        List<Integer> arrayB = array.subList(array.size() / 2, array.size());
        arrayA = sortMerge(arrayA);
        arrayB = sortMerge(arrayB);

        return merge(arrayA, arrayB);
    }

    private List<Integer> merge(List<Integer> arrayA, List<Integer> arrayB) {
        List<Integer> arrayC = new ArrayList<>(arrayA.size() + arrayB.size());
        int positionA = 0, positionB = 0;
        for (int i = 0; i < arrayA.size() + arrayB.size(); i++) {
            if (positionA == arrayA.size()) {
                arrayC.add(arrayB.get(positionB));
                positionB++;
            } else if (positionB == arrayB.size()) {
                arrayC.add(arrayA.get(positionA));
                positionA++;
            } else if (arrayA.get(positionA) < arrayB.get(positionB)) {
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
