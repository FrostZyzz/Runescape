package osrs;


import org.powerbot.script.Client;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import osrs.tasks.BankingWithdrawing;
import osrs.tasks.Fletching;

import java.util.ArrayList;
import java.util.List;

@Script.Manifest(name="Cutting Logs" , description="Tutorial", properties="client=4; author = YEE ; topic=999")

public class FletchingLogs extends PollingScript<ClientContext> {

    List<Task> myTasks = new ArrayList<>();

    @Override
    public void start(){
        myTasks.add(new Fletching(ctx));
        myTasks.add(new BankingWithdrawing(ctx));

    }

    @Override
    public void poll() {

    }
}
