package osrs.tasks.AirOrbs;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;
import osrs.Walker;

public class RunningToTrapdoor extends Task {

    public final int TRAPDOOR_CLOSED=1579;
    public final int TRAPDOOR=1581;
    public final int GATE_ONE[]=new int[]{1568,1569};
    public final int GATE_ONE_CLOSED[]=new int[]{1571,1572};
    public final int GATE_TWO[]=new int[]{1727,1728};
    public final int OBELISK=2152;
    public final int CLAN_WARS_PORTAL=26645;

    public final int RING_DUELING[]=new int[]{2552,2554};
    public final int AMULET_GLORY[]=new int[]{1712,1710,1708,1706};
    public final int AMULET_GLORY_U = 1704;
    public final int COSMICS=564;
    public final int ORBS=567;
    public final int AIR_ORBS=573;

    public static final Tile[] BANK_TO_TRAPDOOR = {new Tile(3094, 3491, 0), new Tile(3090, 3490, 0), new Tile(3090, 3486, 0), new Tile(3093, 3483, 0), new Tile(3093, 3479, 0), new Tile(3093, 3475, 0), new Tile(3094, 3471, 0)};
    public static final Tile[] LADDER_TO_DOOR = {new Tile(3096, 9867, 0), new Tile(3096, 9871, 0), new Tile(3096, 9875, 0), new Tile(3096, 9879, 0), new Tile(3096, 9883, 0), new Tile(3095, 9887, 0), new Tile(3095, 9891, 0), new Tile(3095, 9895, 0), new Tile(3095, 9899, 0), new Tile(3096, 9903, 0), new Tile(3100, 9905, 0)};
    public static final Tile[] DOOR_TO_WILDY= {new Tile(3103, 9908, 0), new Tile(3107, 9909, 0), new Tile(3111, 9909, 0), new Tile(3115, 9909, 0), new Tile(3119, 9909, 0), new Tile(3123, 9909, 0), new Tile(3127, 9910, 0), new Tile(3130, 9913, 0), new Tile(3132, 9917, 0)};
    public static final Tile[] WILDY_TO_OBELISK= {new Tile(3131, 9918, 0), new Tile(3132, 9922, 0), new Tile(3132, 9926, 0), new Tile(3132, 9930, 0), new Tile(3132, 9934, 0), new Tile(3133, 9938, 0), new Tile(3133, 9942, 0), new Tile(3133, 9946, 0), new Tile(3129, 9948, 0), new Tile(3125, 9950, 0), new Tile(3122, 9953, 0), new Tile(3118, 9955, 0), new Tile(3114, 9958, 0), new Tile(3110, 9956, 0), new Tile(3106, 9953, 0), new Tile(3102, 9954, 0), new Tile(3098, 9957, 0), new Tile(3095, 9960, 0), new Tile(3092, 9963, 0), new Tile(3090, 9967, 0)};

    public Walker walker  = new Walker(ctx);
    public Tile doorTile= new Tile(3094, 3471, 0);

    public RunningToTrapdoor(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        System.out.println(ctx.inventory.select().id(COSMICS).count());
        boolean distances=false;
        for(Tile tile: BANK_TO_TRAPDOOR)
            if(tile.distanceTo(ctx.players.local())<8)
                distances=true;

        return ctx.inventory.select().id(ORBS).count()==27 && ctx.inventory.select().id(COSMICS).count()>=1 && distances;
    }

    @Override
    public void execute() {
        if(ctx.objects.select().id(TRAPDOOR_CLOSED).nearest().poll().inViewport()){
            ctx.objects.select().id(TRAPDOOR_CLOSED).nearest().poll().click();
        }
        else if(ctx.objects.select().id(TRAPDOOR).nearest().poll().inViewport()){
            ctx.objects.select().id(TRAPDOOR).nearest().poll().click();
        }
        else if(!ctx.players.local().inMotion() || ctx.movement.destination().equals(Tile.NIL) || doorTile.distanceTo(ctx.players.local())<5)
            walker.walkPath(BANK_TO_TRAPDOOR );


    }
}
