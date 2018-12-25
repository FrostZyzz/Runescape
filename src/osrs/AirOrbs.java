package osrs;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;
import osrs.tasks.AirOrbs.RunningToTrapdoor;
import osrs.tasks.AirOrbs.TrapdoorToGate;
import osrs.tasks.Range;
import osrs.tasks.RangeBankingWithdrawing;


import java.util.ArrayList;
import java.util.List;

@Script.Manifest(name="Charging_AIR" , description="Tutorial", properties="client=4; author = YEE ; topic=999")

public class AirOrbs extends PollingScript<ClientContext> {
    List<Task> myTasks = new ArrayList<>();

    @Override
    public void start(){
        myTasks.add(new TrapdoorToGate(ctx));
        myTasks.add(new RunningToTrapdoor(ctx));

    }


    @Override
    public void poll() {
        for(Task task:myTasks)
            if(task.activate()){
                task.execute();
                System.out.println(task);
                break;
            }
    }
}
