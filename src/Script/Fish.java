package Script;

//import javafx.scene.Node;

import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.DepositBox;
import org.powerbot.script.rt4.Npc;
import org.powerbot.script.rt4.TilePath;

import java.util.Date;
import java.util.concurrent.Callable;

@Script.Manifest(name="Fish", description = "How's it going?", properties = "author=afds; topic=999; client=4;")

public class Fish extends PollingScript<ClientContext> {
    final int FISHINGSPOT_ID[] = {1525};
    private Area DraynorBank = new Area(new Tile(7444,8478),new Tile(7090,9088));

//    private final Tile[] path_to_Bank={new Tile(6322,7198),new Tile(6548,8192),new Tile(7316,8478)};

    private final Tile[] path_to_Bank={new Tile(7316,8478),new Tile(6548,8192),new Tile(6322,7198)};

    private TilePath to_Bank,to_fishing_spot;

    Date time;

    @Override
    public void start() {
        to_Bank = ctx.movement.newTilePath(path_to_Bank);
    }

    @Override
    public void poll() {

        time = new Date();
        System.out.println(ctx.players.local().animation() );
        to_Bank.traverse();

        if(ctx.inventory.select().size()==28){

//            this.MoveToBank();
//            System.out.println(ctx.players.local().tile().floor());


            System.out.println("We're full! Wowee!");

            //Waits until the inventory is cleared
            Condition.wait(new Callable<Boolean>(){

                @Override
                public Boolean call() throws Exception{
                    DepositBoxShrimp();
                    final int CurrentInventorySpace = ctx.inventory.select().size();
                    return CurrentInventorySpace < 28;
                }
            });

        }
        else if(underAttack()){
            //Run away
        }
        else if(shouldFish()){
            System.out.println(shouldFish());
            if(!ctx.npcs.select().id(FISHINGSPOT_ID).isEmpty()){
                System.out.println("Is this on?");
                //Start Thieving if fishing spot is around

                Npc FishingSpot = ctx.npcs.select().id(FISHINGSPOT_ID).select().nearest().poll();
                FishingSpot.interact("Small Net");
                try{
                    Thread.sleep(5000);
                }
                catch(InterruptedException c){

                }
            }
        }

    }

    private boolean underAttack(){
        return ctx.players.local().inCombat();
    }

    private boolean shouldFish() {
        return ctx.players.local().animation() == -1;
    }

//    public void CheckInventory(){
//        System.out.println(ctx.inventory.select().size());
//    }

    public void DepositBoxShrimp(){

        ctx.depositBox.deposit(317, DepositBox.Amount.ALL);
        ctx.depositBox.deposit(321, DepositBox.Amount.ALL);
        ctx.depositBox.close();
    }

    public void MoveToBank(){
        //Moves to bank
        System.out.println("Is this on?");
        try{

            Thread.sleep(500);
        }
        catch(InterruptedException c){
        }

        to_Bank.traverse();

    }

    public void MoveToSpot(){
        //Moves to spot
    }

//    public boolean shouldFish(){
//        return ((ClientContext)this.ctx).players.local().
//    }
}