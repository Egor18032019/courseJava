package lesson3;

public class MyArrayDataException extends NumberFormatException {
    private int row;
    private int column;

    public int getRow() {
        return row;
    }
    public int getCol() {
        return column;
    }
    public MyArrayDataException(int row, int column) {
        super("Неправильный формат в ячейке " + "[" + row + "]" + "[" + column + "]");
        this.row = row;
        this.column = column;
    }
}
