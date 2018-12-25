package osrs;

import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.PollingScript;
import osrs.tasks.RangedSandCrabs.ClickAltar;
import osrs.tasks.RangedSandCrabs.RunningAway;
import osrs.tasks.RangedSandCrabs.RunningBack;

import java.util.ArrayList;
import java.util.List;


@Script.Manifest(name="SandCrabs_triple_west" , description="Tutorial", properties="client=4; author = YEE ; topic=999")

public class TripleSandCrabs_West extends PollingScript<ClientContext> {
    List<Task> myTasks = new ArrayList<>();

    @Override
    public void start(){
//        myTasks.add(new ClickAltar(ctx));
        myTasks.add(new RunningBack(ctx));
        myTasks.add(new RunningAway(ctx));
    }

    @Override
    public void poll() {
//        if(ctx.objects.select().id(27501))
        for(Task task:myTasks)
            if(task.activate()){
                task.execute();
                System.out.println(task);
                break;
            }
    }
}
