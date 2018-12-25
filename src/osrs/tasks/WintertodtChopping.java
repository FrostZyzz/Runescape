package osrs.tasks;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;

public class WintertodtChopping extends Task {
    public final int BURMA = 29311;
    public final int BRAZIER = 29314;
    public final int BRAZIER_UNLIT = 32261; //29312
    public final int ROOT = 20695;
    public final int KINDLING= 20696;
    public final int KNIFE = 946;


    public WintertodtChopping(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        String widgetText = ctx.widgets.widget(396).component(3).text();
        return (ctx.inventory.select().count()<28 && ctx.players.local().animation()==-1 && ctx.inventory.select().id(KINDLING).count()==0 && widgetText=="");
    }

    @Override
    public void execute(){
        GameObject burma = ctx.objects.select().id(BURMA).nearest().poll();
        burma.click();
    }
}
