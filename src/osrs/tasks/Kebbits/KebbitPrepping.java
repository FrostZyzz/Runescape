package osrs.tasks.Kebbits;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;

import java.util.concurrent.Callable;

public class KebbitPrepping extends Task {

    public final int[] EVERGREEN = new int[]{2091,2092};
    public final int BONES = 526;
    public final int LOGS = 1511;
    public final int SPIKE = 10105;

    public KebbitPrepping(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        System.out.println(ctx.players.local().inMotion());
        return ctx.objects.select().id(19215).nearest().poll().inViewport() && !ctx.players.local().inMotion();
    }

    @Override
    public void execute() {
        ctx.objects.select().id(19215).nearest().poll().click();

        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return false;
            }
        },(int)(Math.random()*50+250),4);
    }
}
