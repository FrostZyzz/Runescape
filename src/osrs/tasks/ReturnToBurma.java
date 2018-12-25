package osrs.tasks;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;
import osrs.Walker;

public class ReturnToBurma extends Task {

    public final int WINES = 1993;
    public final int KNIFE = 946;
    public final int TINDERBOX = 590;
    public final int DOOR = 29322;

    public static final Tile[] BURMA_TO_DOOR = {new Tile(1639, 3990, 0), new Tile(1635, 3990, 0), new Tile(1634, 3986, 0), new Tile(1633, 3982, 0), new Tile(1631, 3978, 0), new Tile(1630, 3974, 0), new Tile(1630, 3970, 0)};
    public static final Tile[] DOOR_TO_BANK = {new Tile(1632, 3958, 0), new Tile(1631, 3954, 0), new Tile(1631, 3950, 0), new Tile(1634, 3947, 0), new Tile(1637, 3944, 0)};
    public static Tile bankTile = new Tile(1637, 3944, 0);

    private final Walker walker = new Walker(ctx);

    public ReturnToBurma(ClientContext ctx) {
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
