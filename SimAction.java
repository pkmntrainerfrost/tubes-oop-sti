public interface SimAction extends Runnable {
    public abstract void act();
    public abstract void finish();
    public Sim getSim();
}