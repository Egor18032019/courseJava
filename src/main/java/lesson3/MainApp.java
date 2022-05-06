package lesson3;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {
        String[][] stringsArr = {
                {"1", "2", "3", "3"},
                {"4", "5", "6","7"},
                {"3", "7", "8", "3"},
                {"9", "10", "11", "3"},
        };

        try {
            arrCheck(stringsArr);
            System.out.println("args = " + arrCheck(stringsArr));
        } catch (MyArraySizeException err) {
            JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (MyArrayDataException err) {
            JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            for (int i = 0; i < stringsArr.length; ++i) {
                System.out.print("[");
                for (int j = 0; j < stringsArr[i].length; ++j) {
                    if (j == stringsArr[i].length - 1) {
                        System.out.println(stringsArr[i][j] + "] ");
                    } else {
                        System.out.print(stringsArr[i][j] + ", ");
                    }
                }
                if (i == stringsArr[i].length - 1) {
                    System.out.println(" закончилось");
                }
            }
        }

        System.exit(0);
    }

    public static int arrCheck(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int limit = 4;
        int rows = array.length;

        if (rows != 4) {
            System.out.println("colums ");
            throw new MyArraySizeException(limit, rows);
        }
        for (int i = 0; i < limit; ++i) {
            if (array[i].length != limit) {
                throw new MyArraySizeException(limit, i, array[i].length);
            }
        }; // вынесли проверку выше что бы не тратилось время на расчеты если будет ошибка
        int sum = 0;
        for (int i = 0; i < limit; ++i) {
            for (int j = 0; j < limit; ++j) {
                String foo = array[i][j];
                try {
                    Integer bar = new Integer(foo);
                    sum = sum + bar;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
