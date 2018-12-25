package osrs;

import org.powerbot.script.PollingScript;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.Script;

import java.util.ArrayList;
import java.util.List;

@Script.Manifest(name="Glassblowing" , description="Tutorial", properties="client=4; author = YEE ; topic=999")



public class Glassblowing extends PollingScript<ClientContext> {
    List<Task> myTasks = new ArrayList<>();

    @Override
    public void start(){
        myTasks.add(new osrs.tasks.Glassblowing(ctx));
        myTasks.add(new osrs.tasks.GlassblowingBanking(ctx));
    }

    @Override
    public void poll() {
        for(Task task:myTasks){
            System.out.println(ctx.players.local().animation());
            if(task.activate()){
                task.execute();
                System.out.println(task);
                break;
            }
        }
    }
}
