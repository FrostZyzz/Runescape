package osrs;
//@Script.Manifest(name="Cooking_Khourend" , description="Tutorial", properties="client=4; author = YEE ; topic=999")
//
//public class Cooking extends PollingScript<ClientContext> {

import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.PollingScript;
import osrs.tasks.ConstructionBuilding;
import osrs.tasks.ConstructionReload;

import java.util.ArrayList;
import java.util.List;

@Script.Manifest(name="ConstructionTraining" , description="Tutorial", properties="client=4; author = YEE ; topic=999")


public class ConstructionTraining  extends PollingScript<ClientContext> {

    List<Task> myTasks = new ArrayList<>();

    @Override
    public void start(){
        myTasks.add(new ConstructionBuilding(ctx));
        myTasks.add(new ConstructionReload(ctx));

    }
    @Override
    public void poll() {
        for(Task task:myTasks){
            if(task.activate()) {
                task.execute();
                break;
            }
        }
    }
}
