package osrs;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import osrs.tasks.*;
import osrs.tasks.WintertodtBurning;

import java.util.ArrayList;
import java.util.List;

@Script.Manifest(name="Wintertodt" , description="Tutorial", properties="client=4; author = YEE ; topic=999")

public class Wintertodt extends PollingScript<ClientContext> {

    //DOOR IS 29322
    List<Task> taskList = new ArrayList<>();
    List<Task> BetweenEvents = new ArrayList<>();
    @Override
    public void start(){
        BetweenEvents.add(new WintertodtBanking(ctx));
        BetweenEvents.add(new DoorToBank(ctx));
        BetweenEvents.add(new BurmaToDoor(ctx));

        taskList.add(new WintertodtEating(ctx));
        taskList.add(new WintertodtChopping(ctx));
        taskList.add(new WintertodtFletching(ctx));
        taskList.add(new WintertodtBurning(ctx));
    }

    @Override
    public void poll() {
        System.out.println(ctx.players.local().animation());
        String widgetText = ctx.widgets.widget(396).component(3).text();
        if(widgetText!="")
            for(Task task2:BetweenEvents)
                if (task2.activate()) {
                    task2.execute();
                    System.out.println(task2);
                    break;
                }

        for(Task task:taskList){
            if(task.activate()) {
                task.execute();
                break;
            }
        }
        System.out.println(ctx.players.local().animation());
    }
}
