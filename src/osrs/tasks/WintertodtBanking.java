package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import osrs.Task;
import osrs.Walker;

import java.util.concurrent.Callable;

public class WintertodtBanking extends Task {

    public final int WINES = 1993;
    public final int JUG = 0;
    public final int KNIFE = 946;
    public final int TINDERBOX = 590;
    public final int DOOR = 29322;

    public static final Tile[] BURMA_TO_DOOR = {new Tile(1639, 3990, 0), new Tile(1635, 3990, 0), new Tile(1634, 3986, 0), new Tile(1633, 3982, 0), new Tile(1631, 3978, 0), new Tile(1630, 3974, 0), new Tile(1630, 3970, 0)};
    public static final Tile[] DOOR_TO_BANK = {new Tile(1632, 3958, 0), new Tile(1631, 3954, 0), new Tile(1631, 3950, 0), new Tile(1634, 3947, 0), new Tile(1637, 3944, 0)};
    public static Tile doorTile = new Tile(1630, 3970, 0);

    private final Walker walker = new Walker(ctx);

    public WintertodtBanking(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.bank.inViewport();
    }

    @Override
    public void execute() {
        String widgetText = ctx.widgets.widget(396).component(3).text();
        System.out.println(ctx.combat.health());
        /////////////////////////////
        if(ctx.combat.health() != ctx.combat.maxHealth()) {
            if (!ctx.bank.opened()) {
                ctx.bank.open();
            } else {
                ctx.bank.withdraw(WINES, 6);
                if (ctx.combat.maxHealth() - ctx.combat.health() > 66) {
                    ctx.bank.withdraw(WINES, 6);
                }
                ctx.bank.close();
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return null;
                    }
                }, 1, (int) (5 * Math.random() + 20));
                System.out.println(ctx.combat.health());
                while (ctx.combat.health() < ctx.combat.maxHealth() && ctx.inventory.select().id(WINES).count() > 0) {
                    System.out.println("HEIEFHIUSDHFIUSHDFIUEHRIUEWHRIUEWH12312321312312312");
                    Item Food = ctx.inventory.select().id(WINES).poll();
                    Food.click();
                }
            }
        }
        else{
            if (!ctx.bank.opened()) {
                ctx.inventory.selectedItem().click();
                ctx.bank.open();
            } else {
                ctx.bank.depositInventory();

                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return null;
                    }
                }, 1, (int) (5 * Math.random() + 20));

                ctx.bank.withdraw(WINES, 6);
                ctx.bank.select().id(KNIFE).poll().click();
                ctx.bank.select().id(TINDERBOX).poll().click();

                ctx.bank.close();
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return null;
                    }
                }, 1, (int) (5 * Math.random() + 20));
            }
            if(!ctx.players.local().inMotion() || ctx.movement.destination().equals(Tile.NIL) || doorTile.distanceTo(ctx.players.local())<3)
                walker.walkPathReverse(DOOR_TO_BANK);
        }
//        ctx.bank.open();
//        if(!ctx.bank.opened()){
//            ctx.bank.open();
//        }
//        else {
//            ctx.bank.withdraw(WINES, 6);
//            ctx.bank.close();
//            while (ctx.combat.health() < ctx.combat.maxHealth() && ctx.inventory.select().id(WINES).count() > 0) {
//                Item Food = ctx.inventory.select().id(WINES).poll();
//                Food.click();
//            }
//        }






//        ctx.bank.open();
//        while(!ctx.bank.opened()){
//            ctx.bank.open();
//        }
//        ctx.bank.depositInventory();
//        ctx.bank.withdraw(WINES,6);
//        Condition.wait(new Callable<Boolean>() {
//            @Override
//            public Boolean call() throws Exception {
//                return null;
//            }
//        }, 1, (int) (5 * Math.random() + 1));
//
//        ctx.bank.select().id(KNIFE).poll().click();
//        ctx.bank.select().id(TINDERBOX).poll().click();
//
////        ctx.bank.withdraw(KNIFE,1);
////        ctx.bank.withdraw(TINDERBOX,1);
//        ctx.bank.close();
        ////////////////////////

        ////////////////////////
        //run back
        ////////////////////////

        //end



    }
}
