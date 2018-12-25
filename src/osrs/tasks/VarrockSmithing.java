package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Widget;
import osrs.Task;

import java.util.concurrent.Callable;

public class VarrockSmithing extends Task{

    public final int BARS = 2353;

    public VarrockSmithing(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
//        Item Bar = ctx.inventory.select().id(BARS).poll();
        return ctx.inventory.select().id(BARS).count()>0 && ctx.players.local().animation()!=1;
    }

    @Override
    public void execute() {
        System.out.println(ctx.players.local().animation());
        GameObject Anvil = ctx.objects.select(2097).nearest().poll();
        System.out.println(Anvil);
//        Anvil.interact("Examine");
        System.out.println(Anvil.inViewport());
//        Anvil.interact("Smith");
//
//        Widget Smithing = ctx.widgets.widget(312);
//        System.out.println(Smithing.valid());
//        Condition.wait(new Callable<Boolean>() {
//            @Override
//            public Boolean call() throws Exception {
//                return Smithing.valid();
//            }
//        });
//        Smithing.component(23).interact("Smith all sets");
//
//        System.out.println(Smithing.component(23).component(1).text());


    }
}
