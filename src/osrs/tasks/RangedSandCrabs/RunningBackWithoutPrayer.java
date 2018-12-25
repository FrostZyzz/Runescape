package osrs.tasks.RangedSandCrabs;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Skills;
import osrs.Task;
import osrs.Walker;

public class RunningBackWithoutPrayer extends Task {

    Walker walker = new Walker(ctx);
    public static final Tile[] myPath = {new Tile(1675, 3478, 0), new Tile(1679, 3478, 0), new Tile(1683, 3478, 0), new Tile(1687, 3481, 0), new Tile(1691, 3481, 0), new Tile(1695, 3481, 0), new Tile(1699, 3481, 0), new Tile(1703, 3484, 0), new Tile(1707, 3484, 0), new Tile(1711, 3487, 0), new Tile(1715, 3488, 0), new Tile(1719, 3488, 0), new Tile(1723, 3489, 0), new Tile(1727, 3491, 0), new Tile(1731, 3490, 0), new Tile(1735, 3492, 0), new Tile(1739, 3492, 0), new Tile(1743, 3492, 0)};

    Skills mySkills = new Skills(ctx);

    public Tile tripleCrabs = new Tile(1675,3478);
    public Tile altar = myPath[myPath.length-1];
    public final static int ALTAR = 27501;


    public RunningBackWithoutPrayer(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.movement.distance(ctx.players.local())<6;
    }

    @Override
    public void execute() {

    }
}
