package com.company.taskone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskOne {
    Map<String, Integer> myHM = new HashMap<>();

    public TaskOne() {
        MyLibrares librares = new MyLibrares();
        ArrayList<String> words = librares.getMyWords();

        for (int i = 0; i < words.size(); i++) {
            Integer curr = myHM.get(words.get(i));
            myHM.put(words.get(i), curr == null ? 1 : curr + 1);
        }
    }

    public void getMyHM() {
        System.out.println(myHM);
    }
}
