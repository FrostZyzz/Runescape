package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import osrs.Task;

import java.util.concurrent.Callable;

public class WintertodtBurning extends Task {
    public final int BURMA = 29311;
    public final int BRAZIER_UNLIT = 29312;
    public final int BRAZIER = 29314;
    public final int ROOT = 20695;
    public final int KINDLING= 20696;
    public final int KNIFE = 946;

    public WintertodtBurning(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        System.out.println(ctx.inventory.select().id(KINDLING).count());
        return (ctx.inventory.select().id(KINDLING).count()>0 && ctx.players.local().animation()==-1 && ctx.inventory.select().id(ROOT).count()==0 );
    }

    @Override
    public void execute(){
        GameObject BrazierUnlit = ctx.objects.select().id(BRAZIER_UNLIT).nearest().poll();
        BrazierUnlit.click();

        GameObject Brazier = ctx.objects.select().id(BRAZIER).nearest().poll();
        Brazier.click();

        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return false;
            }
        },1,(int)(150*Math.random()+500));

    }
}
