package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import osrs.Task;

import java.util.concurrent.Callable;

//import static java.lang.Boolean.TRUE;

public class RangeBankingWithdrawing extends Task {

    public static int RawSwordfish = 371;
    public static int CookedSwordfish = 373;
    public static int Range = 21302;

    public RangeBankingWithdrawing(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(RawSwordfish).count()==0;
    }

    @Override
    public void execute(){
        if(ctx.bank.opened()){
            ctx.bank.depositInventory();
            ctx.bank.withdraw(371,28);
            ctx.bank.close();
        }
        else{

            ctx.bank.open();
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.bank.opened();
                }
            },(int)(100+400*Math.random()),1);
        }
    }
}
