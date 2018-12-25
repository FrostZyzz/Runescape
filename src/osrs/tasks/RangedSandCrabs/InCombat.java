package osrs.tasks.RangedSandCrabs;

import org.powerbot.script.rt4.ClientContext;
import osrs.Task;

public class InCombat extends Task {
    public InCombat(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.players.local().inCombat() && ctx.players;
    }

    @Override
    public void execute() {
        if(!ctx.prayer.prayersActive() && ctx.prayer.prayerPoints()>0) {
            ctx.prayer.quickPrayer();
        }
        else if(ctx.combat.specialPercentage()==100){
            ctx.combat.specialAttack(true);
        }
    }
}
