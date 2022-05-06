package lesson2.homework;

public class Man implements Player {
    String type = "Man";

    int maxDistance = 100;
    int maxJump = 3;
    boolean canJump;
    boolean nextAction = true;


    @Override
    public boolean startAction(Activity foo) {
        if(foo.type.equals("Wall")){
            canJump = foo.action(maxJump);
        }
        else if(foo.type.equals("RunWall")) {
            canJump = foo.action(maxDistance);
        }
        else {
            System.out.println("Что делать то ?");
            canJump=false;
            return false;
        }

        if (canJump) {
            System.out.println(type + " can" + foo.type);
            return nextAction;
        } else {
            nextAction = false;
            System.out.println(type + " no can" + foo.type);
            return nextAction;
        }
    }
    @Override
    public boolean getCanNextAction(){
        return nextAction;
    }

}
