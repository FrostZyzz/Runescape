package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import osrs.Task;

import java.util.concurrent.Callable;

import static java.lang.Boolean.TRUE;

public class Banking extends Task {

    public static int BANKS[] = {28861};
    public static Tile bankTile = new Tile(1592, 3476, 0);

    public Banking(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().count()>27 && bankTile.distanceTo(ctx.players.local())<10;
    }

    @Override
    public void execute() {
        if(ctx.bank.opened()){
            ctx.bank.depositInventory();
            ctx.bank.close();
        }
        else{
            ctx.bank.open();
//            System.out.println("hi");
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.bank.opened();
                }
            },(int)(10+400*Math.random()),1);
            if(ctx.combat.specialPercentage()==100) {
                ctx.combat.specialAttack(TRUE);
                ctx.game.tab(Game.Tab.INVENTORY);
            }
        }
    }
}
