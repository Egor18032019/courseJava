package lesson3;

public class MyArraySizeException extends IndexOutOfBoundsException {
    private int row;
    private int column;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return column;
    }

    public MyArraySizeException(int limit, int row, int column) {
        super(" Не тот размер массива в строке " + row + ". Должен быть = " + limit +
                "  а пришёл равный " + column);
        this.row = row;
        this.column = column;
    }

    public MyArraySizeException(int limit, int row) {
        super("Неправильный размер массива." + "Должен быть = " + limit +
                " , а пришёл равный " + row);
        this.row = row;
    }
}
