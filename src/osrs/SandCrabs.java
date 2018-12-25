package osrs;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import osrs.tasks.Mine;
import osrs.tasks.Walk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


@Script.Manifest(name="SandCrabs" , description="Tutorial", properties="client=4; author = YEE ; topic=999")

public class SandCrabs extends PollingScript<ClientContext> {

    List<Task> taskList = new ArrayList<>();


    @Override
    public void start(){
        taskList.add(new Walk(ctx));
    }

    @Override
    public void poll() {

//        int playerState = ctx.players.local().animation();
//        System.out.println(playerState);

        for(Task task:taskList){
            if(ctx.controller.isStopping()){
                break;
            }
            if(task.activate()){
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return null;
                    }
                },(int) (601000+2000*(Math.random()-0.5)),2);
                break;
            }

        }
    }
}
