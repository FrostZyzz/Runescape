package osrs.tasks;

import Script.Cooking;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;

import java.util.concurrent.Callable;

public class Range extends Task {

    public static int RawSwordfish = 371;
    public static int CookedSwordfish = 373;
    public static int Range = 21302;

    public Range(ClientContext ctx) {
        super(ctx);
    }


    @Override
    public boolean activate() {
        return ctx.inventory.select().id(RawSwordfish).count()>0;
    }

    @Override
    public void execute() {
        GameObject CookingRange = ctx.objects.select().id(Range).nearest().poll();
        CookingRange.click();
        ctx.input.sendln("1");
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.inventory.select().id(RawSwordfish).count()==0;
            }
        });

    }
}
