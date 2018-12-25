package osrs.tasks;


import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;

import java.util.concurrent.Callable;

public class Mine extends Task {

    final static int ROCK_IDS[]={7455};

    Tile rockLocation= Tile.NIL;

    public Mine(ClientContext ctx) {
        super(ctx);
    }


    @Override
    public boolean activate() {
        int playerState = ctx.players.local().animation();
        System.out.println(playerState );
//        return true;
        return playerState ==-1;
    }

    @Override
    public void execute() {
        GameObject rockToMine=ctx.objects.select().id(ROCK_IDS).nearest().poll();

        rockLocation=rockToMine.tile();
        rockToMine.interact("Mine");


        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().animation()!=-1;
            }
        });
    }
}
