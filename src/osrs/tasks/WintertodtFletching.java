package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import osrs.Task;

import java.util.concurrent.Callable;

public class WintertodtFletching extends Task {
    public final int BURMA = 29311;
    public final int BRAZIER = 29314;
    public final int ROOT = 20695;
    public final int KNIFE = 946;

    public WintertodtFletching(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        System.out.println(ctx.inventory.select().id(ROOT).count());
        return (ctx.inventory.select().id(ROOT).count()>0 && ctx.players.local().animation()==-1);
    }

    @Override
    public void execute(){
        Item log = ctx.inventory.select().id(ROOT).poll();
        Item knife = ctx.inventory.select().id(KNIFE).poll();

        knife.click();
        log.click();


        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return false;
            }
        },1,(int)(60*Math.random()+20));
    }
}
