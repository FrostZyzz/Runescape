package osrs;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import osrs.tasks.*;
import org.powerbot.script.rt4.ClientContext;

import osrs.tasks.VarrockSmithing;
import osrs.Task;
import java.util.ArrayList;
import java.util.List;

@Script.Manifest(name="VarrockSmithing" , description="Tutorial", properties="client=4; author = YEE ; topic=999")

public class Smithing extends PollingScript<ClientContext> {
    List<Task> taskList = new ArrayList<>();

    @Override
    public void start(){
        taskList.add(new VarrockSmithing(ctx));
    }

    @Override
    public void poll() {
        for(Task task:taskList){
            if(task.activate()){
                task.execute();
            }
        }
    }
}