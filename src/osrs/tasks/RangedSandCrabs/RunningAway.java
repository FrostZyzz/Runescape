package osrs.tasks.RangedSandCrabs;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Skills;
import osrs.Task;
import osrs.Walker;

import java.util.concurrent.Callable;

public class RunningAway extends Task
{
    Walker walker = new Walker(ctx);
    public static final Tile[] myPath = {new Tile(1675, 3478, 0), new Tile(1679, 3478, 0), new Tile(1683, 3478, 0),
            new Tile(1687, 3481, 0), new Tile(1691, 3481, 0), new Tile(1695, 3481, 0), new Tile(1699, 3481, 0),
            new Tile(1703, 3484, 0), new Tile(1707, 3484, 0), new Tile(1711, 3487, 0), new Tile(1715, 3488, 0),
            new Tile(1719, 3488, 0), new Tile(1723, 3489, 0), new Tile(1727, 3491, 0), new Tile(1731, 3490, 0),
            new Tile(1735, 3492, 0), new Tile(1739, 3492, 0), new Tile(1743, 3492, 0)};

    //new Tile(1743, 3492, 0)
    Skills mySkills = new Skills(ctx);

    public Tile tripleCrabs = new Tile(1675,3478);
//    public Tile altar = myPath[myPath.length-1];
    public final static int ALTAR = 27501;
//    public final static int ALTAR = 12372;
    public RunningAway(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
//        return false;
        return !ctx.players.local().inCombat() && ctx.prayer.prayerPoints()<60
                && ctx.objects.select().id(ALTAR).nearest().poll().tile().distanceTo(ctx.players.local())>2; //We will be using prayer as an identifier for when to return
    }

    @Override
    public void execute() {
//        GameObject altar = ctx.objects.select(ALTAR).nearest().poll();

        System.out.println(ctx.objects.select().id(ALTAR).nearest().poll().tile().distanceTo(ctx.players.local()));
        System.out.println("and");
        if(ctx.objects.select().id(ALTAR).nearest().poll().inViewport()) {
            ctx.objects.select().id(ALTAR).nearest().poll().interact("Pray");
//            ctx.objects.id(ALTAR).nearest().poll().click();
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.prayer.prayerPoints() == 60;
                }
            }, 1, (int) (Math.random() * 500 + 3000));
        }
        else if(!ctx.players.local().inMotion() || ctx.movement.destination().equals(Tile.NIL) || altar.tile().distanceTo(ctx.players.local())>5){
            ////////////THIS IS OK
            System.out.println("TEST");
            walker.walkPath(myPath);
        }
    }
}
