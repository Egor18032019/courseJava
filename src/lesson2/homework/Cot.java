package lesson2.homework;

public class Cot implements Player {
    String type = "Cot";
    int maxDistance = 11;
    int maxJump = 4;
    boolean canJump;
    boolean nextAction = true;


    @Override
    public void startAction(Activity foo) {
        if (foo.type == "Wall") {
            canJump = foo.action(maxJump);
        } else if (foo.type == "RunWall") {
            canJump = foo.action(maxDistance);
        } else {
            System.out.println("Что делать то ?");
            return;
        }

        if (canJump) {
            System.out.println(type + " can" + foo.type);
        } else {
            nextAction = false;
            System.out.println(type + " no can" + foo.type);
        }
    }

    @Override
    public boolean getCanNextAction() {
        return nextAction;
    }
}
