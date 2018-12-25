package osrs.tasks;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import osrs.Task;
import osrs.tasks.HighAlching.HighAlch;

import java.util.ArrayList;
import java.util.List;


@Script.Manifest(name="High Alchemy" , description="Tutorial", properties="client=4; author = YEE ; topic=999")

public class High_Alching extends PollingScript<ClientContext> {
    List<Task> myTasks = new ArrayList<>();

    @Override
    public void start(){
        myTasks.add(new HighAlch(ctx,1398));
    }

    @Override
    public void poll() {
        for(Task task:myTasks)
            if(task.activate()){
                task.execute();
                break;
            }
    }
}
