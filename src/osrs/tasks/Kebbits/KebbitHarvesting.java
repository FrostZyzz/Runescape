package osrs.tasks.Kebbits;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;

import java.util.concurrent.Callable;

public class KebbitHarvesting extends Task {

    public final int[] EVERGREEN = new int[]{2091,2092};
    public final int BONES = 526;
    public final int LOGS = 1511;
    public final int SPIKE = 10105;

    public KebbitHarvesting(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.objects.select().id(20648).nearest().poll().inViewport();
    }

    @Override
    public void execute() {

        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return false;
            }
        },(int)(Math.random()*5000+400),3);

        ctx.objects.select().id(20648).nearest().poll().click();


    }
}
