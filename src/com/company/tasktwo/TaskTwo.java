package com.company.tasktwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TaskTwo {
    Map<String, LinkedList<Integer>> myHM = new HashMap<>();

    public LinkedList getNumbers(String surname) {
        LinkedList getNum = myHM.get(surname);
        return getNum;
    }

    public void inputNumber(String surname, Integer number) {
        LinkedList setNum = myHM.get(surname);
        if (setNum == null) {
            setNum = new LinkedList();
        }
        setNum.add(number);
        myHM.put(surname, setNum);
    }
}
