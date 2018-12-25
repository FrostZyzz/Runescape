package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;
import osrs.Walker;

import javax.xml.bind.SchemaOutputResolver;
import java.util.concurrent.Callable;

public class MagicTreeWalking extends Task {

    public static final Tile[] pathToBank = {new Tile(1580, 3481, 0), new Tile(1583, 3481, 0), new Tile(1586, 3482, 0), new Tile(1589, 3482, 0), new Tile(1591, 3479, 0)};
    public static Tile bankTile = new Tile(1592, 3476, 0);
    private final Walker walker = new Walker(ctx);
    public MagicTreeWalking(ClientContext ctx) {
        super(ctx);
    }
    GameObject Tree = ctx.objects.select().id(1761).nearest().poll();

    @Override
    public boolean activate() {

        return ctx.inventory.count()>27 || (ctx.inventory.count()<28 && pathToBank[0].distanceTo(ctx.players.local())>10) ;
    }

    @Override
    public void execute() {
        System.out.println(ctx.movement.destination());
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return null;
            }
        },(int)(2000 + Math.random()*8000),1);


//        if(!ctx.players.local().inMotion() || ctx.movement.destination().equals(Tile.NIL) || ctx.movement.destination().distanceTo(ctx.players.local())<5 || bankTile.distanceTo()<5)
        if(!ctx.players.local().inMotion() || ctx.movement.destination().equals(Tile.NIL) || bankTile.distanceTo(ctx.players.local())<5)
            if(ctx.inventory.select().count()>27) {
                walker.walkPath(pathToBank);
//                System.out.println("hi");
                new Banking(ctx).execute();
            }
            else {
                walker.walkPathReverse(pathToBank);
                Tree.click();
            }

    }
}
