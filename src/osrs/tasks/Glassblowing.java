package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
import osrs.Task;

import java.util.concurrent.Callable;

public class Glassblowing extends Task {

    public final int PIPE = 1785;
    public final int MOLTEN_GLASS = 1775;
    public final int ORBS = 567;

    public Glassblowing(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().animation()!=-1;
            }
        },(int)(Math.random()*60+80),10);

        return (ctx.inventory.select().id(MOLTEN_GLASS).count()>0 && ctx.players.local().animation()==-1 && !ctx.bank.opened());
    }

    @Override
    public void execute() {
        Item Pipe = ctx.inventory.select().id(PIPE).poll();
        Item Molten = ctx.inventory.select().id(MOLTEN_GLASS).poll();

        int tempCount =  ctx.inventory.select().id(MOLTEN_GLASS).count();
        
        Pipe.click();
        Molten.click();

        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.widgets.widget(270).valid();
            }
        });

        ctx.input.send("6");

        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                if(ctx.players.local().animation()!=-1)
                    if(ctx.inventory.select().id(MOLTEN_GLASS).count()==0)
                        return ctx.inventory.select().id(MOLTEN_GLASS).count()==0;
//                    else
//                        return ctx.inventory.select().id(MOLTEN_GLASS).count()!=0;
                return false;
            }
        });
        System.out.println("***********************************");
        System.out.println( ctx.inventory.select().id(MOLTEN_GLASS).count());
        System.out.println("is it done?");
        System.out.println("***********************************");

    }
}
