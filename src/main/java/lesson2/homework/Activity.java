package lesson2.homework;

public class Activity {
    protected String type;
    private int heightWall;

    public Activity(int canJump, String type) {
        this.heightWall = canJump;
        this.type = type;
    }

    public boolean action(int maxJump) {
        if (heightWall<0 ){
            System.out.println("Так мало");
            return true;
        }
        if (maxJump<0){
            System.out.println("Как так ?");
            return false;
        }
        return maxJump >= heightWall;
    }
}
