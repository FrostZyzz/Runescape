package osrs.tasks.Kebbits;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;

import java.util.concurrent.Callable;

public class KebbitCutting extends Task {

    public final int[] EVERGREEN = new int[]{2091,2092};
    public final int BONES = 526;
    public final int LOGS = 1511;
    public final int SPIKE = 10105;

    public KebbitCutting(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return false;
    }

    @Override
    public void execute() {
        GameObject Tree = ctx.objects.select().id(EVERGREEN).nearest().poll();

        Tree.click();

        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().animation()!=-1;
            }
        });
    }
}
