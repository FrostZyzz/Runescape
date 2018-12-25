package osrs;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import osrs.tasks.Drop;
import osrs.tasks.Mine;

import java.util.ArrayList;
import java.util.List;


@Script.Manifest(name="QuickMining" , description="Tutorial", properties="client=4; author = YEE ; topic=999")

public class QuickMining extends PollingScript<ClientContext> {

    List<Task> taskList = new ArrayList<>();


    @Override
    public void start(){
        taskList.add(new Drop(ctx));
        taskList.add(new Mine(ctx));
    }

    @Override
    public void poll() {
        for(Task task:taskList){
            if(task.activate()){
                task.execute();
                break;
            }

        }
    }
}
