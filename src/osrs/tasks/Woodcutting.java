package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Npc;
import osrs.Task;

import java.util.concurrent.Callable;

public class Woodcutting extends Task {
    final static int TREES[]={1761};


    public Woodcutting(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.count()<28;
//        return false;
    }

    @Override
    public void execute() {
        int playerState = ctx.players.local().animation();
        GameObject Tree = ctx.objects.select().id(TREES).nearest().poll();
        System.out.println(playerState);

        if(ctx.combat.specialPercentage()==100 && ctx.inventory.count()<20 && Math.random()<0.1) {
//            if(Math.random()<0.00005){
                ctx.combat.specialAttack(true);
                Tree.click();
                ctx.game.tab(Game.Tab.INVENTORY);
//            }
        }
//        System.out.println(playerState);
        if(playerState==-1){
//            System.out.println(ctx.combat.specialPercentage());
            Tree.click();
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.players.local().animation()!=-1;
                }
            });
//            Condition.wait(new Callable<Boolean>() {
//                @Override
//                public Boolean call() throws Exception {
//                    return null;
//                }
//            },(int)(1000+Math.random()*20000),1);
        }
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return null;
            }
        },(int)(1000+Math.random()*20000),1);
    }
}
