package osrs.tasks;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;

public class SandyCrabsReset extends Task {

    public static final Tile[] path = {new Tile(1786, 3404, 0), new Tile(1782, 3407, 0), new Tile(1779, 3410, 0), new Tile(1776, 3413, 0), new Tile(1772, 3414, 0), new Tile(1770, 3418, 0), new Tile(1768, 3422, 0), new Tile(1765, 3425, 0), new Tile(1761, 3426, 0), new Tile(1760, 3430, 0), new Tile(1757, 3433, 0), new Tile(1754, 3436, 0), new Tile(1758, 3433, 0), new Tile(1761, 3430, 0), new Tile(1764, 3427, 0), new Tile(1766, 3423, 0), new Tile(1770, 3421, 0), new Tile(1773, 3417, 0), new Tile(1777, 3414, 0), new Tile(1781, 3413, 0), new Tile(1785, 3411, 0)};

    public SandyCrabsReset(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return false;
    }

    @Override
    public void execute() {

    }
}
