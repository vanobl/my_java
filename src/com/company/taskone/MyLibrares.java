package com.company.taskone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class MyLibrares {
    ArrayList<String> myWords = new ArrayList<>();
    ArrayList<String> myLibrary = new ArrayList<>();

    public MyLibrares() {

        Random selectWord = new Random();
        Random repeat = new Random();

        int myCount = 20;
        try {
            File file = new File("src/com/company/files/lib_words.txt");

            try {
                FileReader fr = new FileReader(file);

                BufferedReader breader = new BufferedReader(fr);
                String line = breader.readLine();

                while (line != null) {
                    myLibrary.add(line);
                    line = breader.readLine();
                }
                int aCount = 1;
                while (aCount < myCount) {
                    int selectWordInt = selectWord.nextInt(370000);
                    int repeatInt = repeat.nextInt(2);
                    if (repeatInt == 0) {
                        for (int a = 0; a < 3; a++) {
                            myWords.add(myLibrary.get(selectWordInt));
                        }
                    } else {
                        myWords.add(myLibrary.get(selectWordInt));
                    }

                    aCount++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getMyWords() {
        return myWords;
    }
}
