package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;
import osrs.Walker;

import java.awt.event.KeyEvent;
import java.util.concurrent.Callable;

public class ConstructionBuilding extends Task {
    public final int LARDER_SPOT = 15403;
    public final int OAK_LARDER = 13566;
    public final int PHIALS = 1614;
    public final int PLANKS= 8778;
    public final int PLANKS_NOTED = 8779;

    public final int PORTAL_EXIT= 4525;
    public final int PORTAL_ENTRANCE= 15478;
    public final Walker walker = new Walker(ctx);

    public ConstructionBuilding(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ((ctx.objects.select().id(LARDER_SPOT).nearest().poll().inViewport() || ctx.objects.select().id(OAK_LARDER).nearest().poll().inViewport()) && ctx.inventory.select().id(PLANKS).count()>7) ;
    }

    @Override
    public void execute() {
        GameObject Spot = ctx.objects.select().id(LARDER_SPOT).nearest().poll();
        GameObject Larder = ctx.objects.select().id(OAK_LARDER).nearest().poll();
        if(Larder.inViewport()) {
            if (!ctx.players.local().inMotion())
                Larder.interact("Remove");

            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return false;
                }
            }, 1, (int) (15 * Math.random() + 60));

            ctx.input.send("1");

            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return false;
                }
            }, 1, (int) (20 * Math.random() + 50));
        }
        else if(Spot.inViewport()) {
            if (!ctx.players.local().inMotion()) {
                Spot.interact("Build");
            }

            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return false;
                }
            }, 1, (int) (10 * Math.random()+20));

//        if(ctx.widgets.widget(458).valid()) //458 widget for oak larder
            ctx.input.send("2");

            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return false;
                }
            }, 1, (int) (25 * Math.random() + 75));
        }
        else{
            walker.walkPath(new Tile[]{new Tile(11295,9693,0)});
        }

    }
}
