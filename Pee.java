public class Pee extends SimActiveAction {
    Eat eat;
    boolean finished;
    public Pee(Sim sim, Eat eat){
        super(sim);
        this.eat = eat;
    }

    @Override
    public void finish() {
        if (eat.getStatusFinish()){
            int time = getDuration()/10;
            getSim().setKekenyangan(getSim().getKekenyangan() - (time * 20));
            getSim().setMood(getSim().getMood() + (time * 10));
        }
    }

    // "Berlaku 4 menitnya setiap setelah makan" -> asumsi tidak siklus
    public void didntPee() {
        if (getEatTimeFinished() > 240){ //4 menit
            System.out.println(getSim().getName() + " hasn't peed yet!");
            getSim().setKesehatan(getSim().getKesehatan() - 5);
            getSim().setMood(getSim().getMood() - 5 );
        }
    }

}