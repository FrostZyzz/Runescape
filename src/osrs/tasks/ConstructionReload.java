package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;
import osrs.Walker;

import java.util.concurrent.Callable;

public class ConstructionReload extends Task {

    public final int LARDER_SPOT = 15403;
    public final int OAK_LARDER = 13566;
    public final int PHIALS = 1614;
    public final int PLANKS= 8778;
    public final int PLANKS_NOTED = 8779;

    public final int PORTAL_EXIT= 4525;
    public final int PORTAL_ENTRANCE= 15478;

    public final Walker walker = new Walker(ctx);

    public ConstructionReload(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return true;
    }

    @Override
    public void execute() {
//        System.out.println("HIHHDSFOIHSDIUF");
//        if(ctx.widgets.widget(458).valid() || ){
//
//        }
        GameObject HomePortal = ctx.objects.select().id(PORTAL_EXIT).nearest().poll();
        if(!ctx.players.local().inMotion() && HomePortal.inViewport() && ctx.inventory.select().id(PLANKS).count()<8) {
            HomePortal.click();
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return false;
                }
            }, 1, (int) (20 * Math.random() + 50));
        }
        if(ctx.inventory.select().id(PLANKS).count()<8 && !ctx.players.local().inMotion() && ctx.npcs.select().id(PHIALS).viewable().poll().inViewport()){ //talk to Phials
            if(ctx.widgets.widget(219).valid()){
                ctx.input.send("3");
            }
            else {
                ctx.inventory.select().id(PLANKS_NOTED).poll().click();
                ctx.npcs.select().id(PHIALS).poll().click();
            }
        }
        else{ //go back into home and restart script
            if(!ctx.players.local().inMotion()) {
                ctx.objects.select().id(PORTAL_ENTRANCE).nearest().poll().interact("Build Mode");
            }
        }
    }
}
