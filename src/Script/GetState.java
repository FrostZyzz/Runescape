package Script;

//import javafx.scene.Node;

import org.powerbot.script.Condition;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Npc;

import java.util.concurrent.Callable;

@Script.Manifest(name="GetState", description = "How's it going?", properties = "author=afds; topic=999; client=4;")

public class GetState extends PollingScript<ClientContext> {
    final static int FOODS[] = {1891,1893,1895,2309,1901};
    final static int Guard = 3108;
    final static int MoneyBag[]={3245,22531};
    final static int TREES[]={1753};
    final static int pickpocketingState[]={};
    final static int stunnedState[]={};
    final static int eatingState[]={829};


    @Override
    public void start(){
        Item Money = ctx.inventory.select().id(MoneyBag).poll();
        Money.click();
    }

    @Override
    public void poll() {

        int playerState = ctx.players.local().animation();
        System.out.println(playerState);



//        if(hasFood()) {
//            if (ctx.combat.health() >40) {
//                if (playerState == 388 || playerState == 378 || playerState == 424) {
//
//                    Item Money = ctx.inventory.select().id(MoneyBag).poll();
//
//                    Condition.wait(new Callable<Boolean>() {
//
//                        @Override
//                        public Boolean call() throws Exception {
//                            return null;
//                        }
//
//                    }, (int) (Math.random() * 2500+1500), 10);
//
//                    if(Math.random()<0.30)
//                        Money.click();
//
//
//                } else {
//
//                    Item Money = ctx.inventory.select().id(MoneyBag).poll();
//
//                    if(Math.random()<0.06){
//                        Money.click();
//                    }
//
//                    pickpocket();
//                    Condition.wait(new Callable<Boolean>() {
//
//                        @Override
//                        public Boolean call() throws Exception {
//                            return null;
//                        }
//                    }, (int) ((Math.random()) * 20 + 330), 10);
//                }
//            }
//            else{
//                heal();
//            }
//
//        }

//        System.out.println(ctx.players.local().animation());
    }


    public boolean hasFood() {
        return ctx.inventory.select().id(FOODS).count()>0;
    }

    public void heal(){

        Item Money = ctx.inventory.select().id(MoneyBag).poll();
        Money.click();

        final int startingHealth = ctx.combat.health();
        int iterations = 0;

        while(iterations<7) {
            iterations++;
            final int intermediateHealth = ctx.combat.health(); //The health check at any given moment to make it more difficult to detect

            Item foodToEat = ctx.inventory.select().id(FOODS).poll();
            foodToEat.click();
            if(iterations==6){

            }
            else {
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        final int currentHealth = ctx.combat.health();
                        return currentHealth != intermediateHealth;
                    }
                },(int)(Math.random()*500),10);
            }
        }

    }

    public void pickpocket(){
        final Npc guard = ctx.npcs.select().id(Guard).nearest().poll();
        guard.interact("Pickpocket");


    }

//    final int FISHINGSPOT_ID[] = {1525};
//    private Area DraynorBank = new Area(new Tile(7444,8478),new Tile(7090,9088));
//
////    private final Tile[] path_to_Bank={new Tile(6322,7198),new Tile(6548,8192),new Tile(7316,8478)};
//
//    private final Tile[] path_to_Bank={new Tile(7316,8478),new Tile(6548,8192),new Tile(6322,7198)};
//
//    private TilePath to_Bank,to_fishing_spot;
//
//    Date time;
//
//    @Override
//    public void start() {
//        to_Bank = ctx.movement.newTilePath(path_to_Bank);
//    }
//
//    @Override
//    public void poll() {
//
//        time = new Date();
//        System.out.println(ctx.players.local().animation() );
//        to_Bank.traverse();
//
//        if(ctx.inventory.select().size()==28){
//
////            this.MoveToBank();
////            System.out.println(ctx.players.local().tile().floor());
//
//            System.out.println("We're full! Wowee!");
//
//            //Waits until the inventory is cleared
//            Condition.wait(new Callable<Boolean>(){
//
//                @Override
//                public Boolean call() throws Exception{
//                    DepositBoxShrimp();
//                    final int CurrentInventorySpace = ctx.inventory.select().size();
//                    return CurrentInventorySpace < 28;
//                }
//            });
//
//        }
//        else if(underAttack()){
//            //Run away
//        }
//        else if(shouldFish()){
//            System.out.println(shouldFish());
//            if(!ctx.npcs.select().id(FISHINGSPOT_ID).isEmpty()){
//                System.out.println("Is this on?");
//                //Start Thieving if fishing spot is around
//
//                Npc FishingSpot = ctx.npcs.select().id(FISHINGSPOT_ID).select().nearest().poll();
//                FishingSpot.interact("Small Net");
//                try{
//                    Thread.sleep(5000);
//                }
//                catch(InterruptedException c){
//
//                }
//            }
//        }
//
//    }
//
//    private boolean underAttack(){
//        return ctx.players.local().inCombat();
//    }
//
//    private boolean shouldFish() {
//        return ctx.players.local().animation() == -1;
//    }
//
////    public void CheckInventory(){
////        System.out.println(ctx.inventory.select().size());
////    }
//
//    public void DepositBoxShrimp(){
//
//        ctx.depositBox.deposit(317, DepositBox.Amount.ALL);
//        ctx.depositBox.deposit(321, DepositBox.Amount.ALL);
//        ctx.depositBox.close();
//    }
//
//    public void MoveToBank(){
//        //Moves to bank
//        System.out.println("Is this on?");
//        try{
//
//            Thread.sleep(500);
//        }
//        catch(InterruptedException c){
//        }
//
//        to_Bank.traverse();
//
//    }
//
//    public void MoveToSpot(){
//        //Moves to spot
//    }

//    public boolean shouldFish(){
//        return ((ClientContext)this.ctx).players.local().
//    }
}