package osrs.tasks.Kebbits;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
import osrs.Task;

import java.util.concurrent.Callable;

public class KebbitFletching extends Task {

    public final int[] EVERGREEN = new int[]{2091,2092};
    public final int BONES = 526;
    public final int LOGS = 1511;
    public final int SPIKE = 10105;
    public final int CHISEL = 1755;

    public KebbitFletching(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        System.out.println(28-ctx.inventory.count());
        return (28-ctx.inventory.count())<2 || ctx.inventory.select().id(LOGS).count()==0;
    }

    @Override
    public void execute() {

//        Item Bones = ctx.inventory.select().id(BONES).poll();

        for(int index=0;index<28;index++){ //Drop all bones
            Item Bones = ctx.inventory.select().id(BONES).poll();
//            ctx.inventory.selectedItemIndex()
            ctx.inventory.drop(Bones,true);
        }
        Item Chisel = ctx.inventory.select().id(CHISEL).poll();
        System.out.println( ctx.players.local().animation());
        if(ctx.inventory.select().id(SPIKE).count()>4 && ctx.players.local().animation()==-1){
            Item Spike= ctx.inventory.select().id(SPIKE).poll();
            Chisel.interact("Use");
            Spike.interact("Use");

            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return false;
                }
            },(int)(50*Math.random()+100),4);

            ctx.input.send("1");
        }Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return false;
            }
        },(int)(50*Math.random()+100),4);



    }
}
