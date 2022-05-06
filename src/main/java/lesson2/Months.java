package lesson2;

public enum Months {
    JANUARY(1),FEBRUARY(2),MARCH(3), APPEAL(4);
    int number;

    Months(int number){
        this.number=number;
    }

    public int getNumber() {
        return number;
    }
    public String getTitle(){
        return "ddd";
    }
}
