package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;
import osrs.Walker;

import java.util.concurrent.Callable;

public class Walk extends Task {

    public static final Tile[] pathAway = {new Tile(1749, 3412, 0), new Tile(1753, 3412, 0), new Tile(1757, 3412, 0), new Tile(1761, 3412, 0), new Tile(1765, 3412, 0), new Tile(1769, 3412, 0), new Tile(1773, 3412, 0), new Tile(1777, 3412, 0), new Tile(1781, 3413, 0), new Tile(1785, 3411, 0), new Tile(1781, 3410, 0), new Tile(1778, 3413, 0), new Tile(1774, 3413, 0), new Tile(1770, 3412, 0), new Tile(1766, 3411, 0), new Tile(1762, 3412, 0), new Tile(1758, 3414, 0), new Tile(1754, 3414, 0), new Tile(1750, 3412, 0)};

//    public static final Tile[] pathAway = {new Tile(1753, 3413, 0), new Tile(1758, 3413, 0), new Tile(1763, 3413, 0), new Tile(1768, 3413, 0), new Tile(1773, 3412, 0), new Tile(1778, 3412, 0), new Tile(1783, 3412, 0), new Tile(1788, 3410, 0),new Tile(1783, 3408, 0), new Tile(1779, 3411, 0), new Tile(1774, 3412, 0), new Tile(1769, 3412, 0), new Tile(1764, 3412, 0), new Tile(1759, 3412, 0), new Tile(1754, 3412, 0), new Tile(1749, 3412, 0)};
//    public static final Tile[] pathAway = {new Tile(1753, 3413, 0), new Tile(1758, 3413, 0), new Tile(1763, 3413, 0), new Tile(1768, 3413, 0), new Tile(1773, 3412, 0), new Tile(1778, 3412, 0), new Tile(1783, 3412, 0), new Tile(1788, 3410, 0)};
//    public static final Tile[] pathBack = {new Tile(1783, 3408, 0), new Tile(1779, 3411, 0), new Tile(1774, 3412, 0), new Tile(1769, 3412, 0), new Tile(1764, 3412, 0), new Tile(1759, 3412, 0), new Tile(1754, 3412, 0), new Tile(1749, 3412, 0)};
//    public static final Tile[] pathBack = {new Tile(1770, 3410, 0), new Tile(1763, 3411, 0), new Tile(1756, 3411, 0), new Tile(1749, 3412, 0)};{new Tile(1753, 3413, 0), new Tile(1758, 3413, 0), new Tile(1763, 3413, 0), new Tile(1768, 3413, 0), new Tile(1773, 3412, 0), new Tile(1778, 3412, 0), new Tile(1783, 3412, 0), new Tile(1788, 3410, 0), new Tile(1783, 3408, 0), new Tile(1779, 3411, 0), new Tile(1774, 3412, 0), new Tile(1769, 3412, 0), new Tile(1764, 3412, 0), new Tile(1759, 3412, 0), new Tile(1754, 3412, 0), new Tile(1749, 3412, 0)};


    private final Walker walker=new Walker(ctx);

    public Walk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return true;
//        System.out.println("Hello?");
//        if(ctx.players.local().animation()==-1){
//            Condition.wait(new Callable<Boolean>() {
//                @Override
//                public Boolean call() throws Exception {
//                    return null;
//                }
//            });
//        }
//        return false;
    }

    @Override
    public void execute() {
        if(!ctx.players.local().inMotion() || ctx.movement.destination().equals(Tile.NIL) || ctx.movement.destination().distanceTo(ctx.players.local())<3) {
            walker.walkPath(pathAway);
            System.out.println("Test");
        }
//        walker.walkPath(pathBack);
//        System.out.println("Test");
//        walker.walkPath(new Tile[]{new Tile(1749, 3412, 0)});
    }
}
