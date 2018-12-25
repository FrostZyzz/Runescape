package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;

import java.util.concurrent.Callable;

public class AnvilSmithing extends Task {
//    2097
    public final static int[] VARROCK_ANVIL={2097};
    public final static int STEEL_BARS=2353;

    public AnvilSmithing(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.count()>2 && !ctx.players.local().inMotion();
    }

    @Override
    public void execute() {
        System.out.println(ctx.widgets.widget(312).component(4).visible());

        GameObject Anvil = ctx.objects.select().id(VARROCK_ANVIL).nearest().poll();
        Anvil.interact("Smith");
        System.out.println(ctx.widgets.widget(312).component(4).visible());
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.inventory.count()==2;
            }
        });
//        System.out.println(ctx.widgets);
//        System.out.println(ctx.widgets.component(0,0));
//        ctx.widgets.components
//        ctx.widgets.component(0,4).interact("Smith All sets"); //Questionable

    }
}
