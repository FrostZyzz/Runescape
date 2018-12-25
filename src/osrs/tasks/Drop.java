package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
import osrs.Task;

import java.util.concurrent.Callable;

public class Drop extends Task {

    final static int ORE = 440;

    public Drop(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().count()>27;
    }


    @Override
    public void execute() {
        System.out.println(ctx.inventory.shiftDroppingEnabled());

        for(int i=0; i<8;i++){
            for(int j=0;j<4;j++){
                if(ctx.controller.isStopping())
                    break;

                if(i%2==0){
                    ctx.inventory.drop(ctx.inventory.itemAt(i*4+j),true);
                    if(ctx.controller.isStopping())
                        break;
                }
                else{
                    ctx.inventory.drop(ctx.inventory.itemAt(i*4+3-j),true);
                    if(ctx.controller.isStopping())
                        break;
                }
            }
        }



//        for(Item Ore : ctx.inventory.select().id(ORE)){
//            int startAmtCopper = ctx.inventory.select().id(ORE).count();
//            Ore.interact("Drop", "Iron Ore");
//
//            Condition.wait(new Callable<Boolean>() {
//                @Override
//                public Boolean call() throws Exception {
//                    return ctx.inventory.select().id(ORE).count()!=startAmtCopper;
//                }
//            },25,20);
//        }
    }
}
