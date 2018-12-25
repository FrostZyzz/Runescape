package osrs;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

import osrs.tasks.Banking;
import osrs.tasks.MagicTreeWalking;
import osrs.tasks.Woodcutting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Script.Manifest(name="WC_Guild_Yews" , description="Tutorial", properties="client=4; author = YEE ; topic=999")

public class WoodcuttingGuild_Yews extends PollingScript<ClientContext>  {
    List<Task> myTasks = new ArrayList<>();

    @Override
    public void start(){
        myTasks.add(new Banking(ctx));
        myTasks.add(new MagicTreeWalking(ctx));
        myTasks.add(new Woodcutting(ctx));

    }



    @Override
    public void poll() {
        for(Task task:myTasks){
            if(task.activate()){
                task.execute();
            }
        }
    }
}
