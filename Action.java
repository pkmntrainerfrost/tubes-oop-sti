public interface Action extends Runnable {
    public abstract void act();
    public abstract void finish();
    public Sim getSim();
}