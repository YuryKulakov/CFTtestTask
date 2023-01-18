package TestTask;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        try {
            ms.run(ms.parse(args));
        } catch (IOException e) {
            System.out.println("Ошибка выполнения программы");;
        }
    }
}
