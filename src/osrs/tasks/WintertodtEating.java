package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
import osrs.Task;

import java.util.concurrent.Callable;

public class WintertodtEating extends Task {

    public static int Wines = 1993;
    public static int WinesEmpty = 1995;

    public WintertodtEating(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return (ctx.inventory.select().id(Wines).count()>0 && ctx.combat.health()<40);
    }

    @Override
    public void execute() {
        int FoodQuantity = (int)(Math.random()*3);
        for(int i=0;i<FoodQuantity;i++){
            Item Food = ctx.inventory.select().id(Wines).poll();
            Food.click();
            final int health = ctx.combat.health();
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.combat.health() > health;
                }
            });
        }



    }
}
