package osrs;


import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;
import osrs.tasks.Kebbits.KebbitCutting;
import osrs.tasks.Kebbits.KebbitFletching;
import osrs.tasks.Kebbits.KebbitHarvesting;
import osrs.tasks.Kebbits.KebbitPrepping;

import java.util.ArrayList;
import java.util.List;


@Script.Manifest(name="Prickly_Kebbits" , description="Tutorial", properties="client=4; author = YEE ; topic=999")

public class Kebbit extends PollingScript<ClientContext> {
    List<Task> myTasks = new ArrayList<>();

    @Override
    public void start(){
        myTasks.add(new KebbitFletching(ctx));
        myTasks.add(new KebbitPrepping(ctx));
        myTasks.add(new KebbitHarvesting(ctx));
//        myTasks.add(new KebbitCutting(ctx));
    }

    @Override
    public void poll() {
        for(Task task:myTasks){
            if(task.activate()){
                task.execute();
                System.out.println(task);
                break;
            }
        }
    }
}
