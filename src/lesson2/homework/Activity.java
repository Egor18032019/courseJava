package lesson2.homework;

public class Activity {
    protected String type;
    private int heightWall;

    public Activity(int canJump, String type) {
        this.heightWall = canJump;
        this.type = type;
    }

    public boolean action(int maxJump) {
        if (maxJump >= heightWall) {
            return true;
        } else {
            return false;
        }
    }
}
