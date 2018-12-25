package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
import osrs.Task;

import java.util.concurrent.Callable;

public class GlassblowingBanking extends Task {

    public final int PIPE = 1785;
    public final int MOLTEN_GLASS = 1775;
    public final int ORBS = 567;


    public GlassblowingBanking(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        System.out.println(ctx.inventory.select().id(MOLTEN_GLASS).count());
        System.out.println(ctx.inventory.select().id(ORBS).count());
        return ((ctx.inventory.select().id(MOLTEN_GLASS).count()==0 && ctx.inventory.select().id(ORBS).count()>0) || ctx.bank.opened());
    }

    @Override
    public void execute() {
        Item Glass = ctx.inventory.select().id(MOLTEN_GLASS).poll();
        Item Orbs = ctx.inventory.select().id(ORBS).poll();
        if(ctx.bank.opened()){ //do the stuff
            if(ctx.inventory.select().id(MOLTEN_GLASS).count()<27 && ctx.inventory.select().id(ORBS).count()>0){//deposit
                Orbs.click();
//                System.out.println("HAS");
            }
            else if(ctx.inventory.select().id(MOLTEN_GLASS).count()<27){//withdraw
                ctx.bank.select().id(MOLTEN_GLASS).poll().click();

            }
            else{//close
                ctx.bank.close();
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return !ctx.bank.opened();
                    }
                });
            }
        }
        else{ //open the bank otherwise
            ctx.bank.open();
        }

    }
}
