package osrs;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import osrs.tasks.AnvilSmithing;
import osrs.tasks.Withdraw;

import java.util.ArrayList;
import java.util.List;

//@Script.Manifest(name="VarrockSmithing" , description="Tutorial", properties="client=4; author = YEE ; topic=999")

public class VarrockSmithing extends PollingScript<ClientContext> {

    List<Task> taskList = new ArrayList<>();
    @Override
    public void start(){
        taskList.add(new AnvilSmithing(ctx));
        taskList.add(new Withdraw(ctx));
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
