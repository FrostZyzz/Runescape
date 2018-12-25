package osrs.tasks;


import org.powerbot.script.rt4.ClientContext;
import osrs.Task;

public class Fletching extends Task {
    public final static int FLETCH_LOGS=-1;
    public Fletching(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        System.out.println(ctx.inventory.select().id(FLETCH_LOGS));
        return ctx.inventory.select().id(FLETCH_LOGS).count()>0;
    }

    @Override
    public void execute() {

    }
}
