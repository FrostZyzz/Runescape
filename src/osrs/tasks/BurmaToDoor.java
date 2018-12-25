package osrs.tasks;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;
import osrs.Walker;

public class BurmaToDoor extends Task {
    public final int DOOR = 29322;

    public static final Tile[] BURMA_TO_DOOR = {new Tile(1639, 3990, 0), new Tile(1635, 3990, 0), new Tile(1634, 3986, 0), new Tile(1633, 3982, 0), new Tile(1631, 3978, 0), new Tile(1630, 3974, 0), new Tile(1630, 3970, 0)};
    public static final Tile doorTile = new Tile(1630,3970,0);
    private final Walker walker = new Walker(ctx);
    GameObject Door = ctx.objects.select().id(DOOR).nearest().poll();

    public BurmaToDoor(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return (ctx.combat.health()<ctx.combat.maxHealth() && (doorTile.distanceTo(ctx.players.local())>3 || Door.inViewport()));
    }

    @Override
    public void execute() {
        if(!ctx.players.local().inMotion() || ctx.movement.destination().equals(Tile.NIL) || doorTile.distanceTo(ctx.players.local())>5){
//        if(!ctx.players.local().inMotion() || doorTile.distanceTo(ctx.players.local())>5){
            System.out.println("TEST");
            walker.walkPath(BURMA_TO_DOOR);

        }
//        GameObject Door = ctx.objects.select().id(DOOR).nearest().poll();
        if(Door.inViewport())
            Door.click();

    }
}
