public interface SimAction extends Runnable {
    public abstract void act(Sim sim);
    public abstract void end(Sim sim);
    public Sim getSim();
}