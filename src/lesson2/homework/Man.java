package lesson2.homework;

public class Man implements Player {
    String type = "Man";

    int maxDistance = 100;
    int maxJump = 3;
    boolean canJump;
    boolean nextAction = true;


    @Override
    public void startAction(Activity foo) {
        if(foo.type=="Wall"){
            canJump = foo.action(maxJump);
        }
        else if(foo.type=="RunWall") {
            canJump = foo.action(maxDistance);
        }
        else {
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
    public boolean getCanNextAction(){
        return nextAction;
    }

}
