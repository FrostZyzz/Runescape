package osrs.tasks.HighAlching;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.Magic;
import osrs.Task;

import java.util.concurrent.Callable;

public class HighAlch extends Task {

    public int ITEM;


    public HighAlch(ClientContext ctx, int Item_ID) {
        super(ctx);
        ITEM = Item_ID;
    }

    @Override
    public boolean activate() {
//        ctx.magic.cast(Magic.Spell.HIGH_ALCHEMY)

        return ctx.game.tab(Game.Tab.MAGIC) && ctx.inventory.select().id(ITEM).count()>0;
//        System.out.println(ctx.magic.ready(Magic.Spell.HIGH_ALCHEMY));
//        return ctx.magic.ready(Magic.Spell.HIGH_ALCHEMY) && ctx.players.local().animation()==-1;
    }

    @Override
    public void execute() {
        int horizontal =(int)((Math.random()-0.5)*4);
        int vertical = (int)((Math.random()-0.5)*2);
        ctx.input.click(712+horizontal,308+vertical,true);
        ctx.input.click(712+horizontal,308+vertical,true);

        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().animation()==-1;
            }
        });

        if(Math.random()<0.001){
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return false;
                }
            },1,(int)(Math.random()*15000+3000));
        }

    }
}
