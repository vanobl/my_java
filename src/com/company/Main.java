package com.company;

import com.company.myxceptions.MyArraySizeException;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws MyArraySizeException {
        String[][] myArr = getMyArr(4);
        sumMyArray(myArr);
    }

    public static void sumMyArray(String[][] myArr) throws MyArraySizeException {
        if (myArr.length != 4) throw new MyArraySizeException("Не поддерживаемый размер массива. Должен быть равен 4");

        int summArr = 0;

        for (int i = 0; i < myArr.length; i++) {
            for (int y = 0; y < myArr.length; y++) {
                String perStr = myArr[i][y];
                try {
                    int perInt = Integer.parseInt(perStr);
                    summArr += perInt;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println("Сумма массива возможно не корректна. Проверьте массив.");
                }
            }
        }

        System.out.println("Сумма массива: " + summArr);
    }

    public static String[][] getMyArr(int sizeArr) {
        String[][] my_fully = new String[sizeArr][sizeArr];

        // заполним массив значениями
        for (int i = 0; i < my_fully.length; i++) {
            for (int y = 0; y < my_fully.length; y++) {
                if (i == (sizeArr - 1) && y == (sizeArr - 1)){
                    my_fully[i][y] = "b";
                } else {
                    my_fully[i][y] = "" + i + y;
                }
            }
        }

        return my_fully;
    }
}
