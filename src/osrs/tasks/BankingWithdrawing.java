package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import osrs.Task;

import java.util.concurrent.Callable;

import static java.lang.Boolean.TRUE;

public class BankingWithdrawing extends Task {
    public final static int LONGBOWS_U=58;

    public BankingWithdrawing(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(LONGBOWS_U).count() >26;
    }

    @Override
    public void execute() {
        if(ctx.bank.opened()){
            ctx.bank.depositInventory();
            ctx.bank.close();
        }
        else{

        }
    }
}
