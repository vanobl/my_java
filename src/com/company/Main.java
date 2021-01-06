package com.company;

import com.company.myxceptions.MyArraySizeException;
import com.company.taskone.TaskOne;
import com.company.tasktwo.TaskTwo;

public class Main {

    public static void main(String[] args) throws MyArraySizeException {
//        TaskOne taskOne = new TaskOne();
//        taskOne.getMyHM();

        TaskTwo taskTwo = new TaskTwo();
        taskTwo.inputNumber("Бахтин", 2707541);
        taskTwo.inputNumber("Бахтин", 2707542);
        taskTwo.inputNumber("Путин", 2607551);
        taskTwo.inputNumber("Путин", 2607552);

        taskTwo.getNumbers("Бахтин");
        taskTwo.getNumbers("Путин");
    }

}
