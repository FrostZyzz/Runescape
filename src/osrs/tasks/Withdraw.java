package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;

import java.util.concurrent.Callable;

public class Withdraw extends Task {
    final static int STEEL_BARS =  2353;

    public Withdraw(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        System.out.println(ctx.inventory.count());
        return ctx.inventory.count()==2 && ctx.players.local().animation()==-1;
    }

    @Override
    public void execute() {
        ctx.bank.open();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.bank.opened();
            }
        });
        ctx.bank.withdraw(STEEL_BARS,26);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.inventory.count()==28;
            }
        });
        ctx.bank.close();
    }
}
