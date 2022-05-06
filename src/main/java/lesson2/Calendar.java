package lesson2;

public class Calendar {
    public static final int MONTH_JANUARY = 1;
    public static final int MONTH_FEBRUARY = 2;
    int month = MONTH_JANUARY;
    public static final int MONTHS_DAYS_COUNT = 31;


    public static void currentDate() {
        Months monthEPUM = Months.MARCH;
        Months as = Months.JANUARY;
        Months foo = Months.valueOf("MARCH");
        Months[] bar = Months.values();
        System.out.println(foo.toString() + " " + bar[1]);
        System.out.println(monthEPUM.getNumber() + " " + monthEPUM.getTitle());
    }

    public static void main(String[] args) {
        currentDate();
    }
}
