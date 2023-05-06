public interface SimAction {
    public void execute(Sim sim);
    public void begin(Sim sim);
    public void process(Sim sim);
    public void end(Sim sim);
}