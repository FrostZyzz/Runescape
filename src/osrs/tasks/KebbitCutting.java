package osrs.tasks;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;

import java.util.concurrent.Callable;

public class KebbitCutting extends Task {

    public final int[] EVERGREEN = new int[]{2091,2092};

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
