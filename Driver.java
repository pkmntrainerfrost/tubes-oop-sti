public class Driver {
    public static void main(String[] args) throws SimNotInGameException, NeighborFoundException, SimNotInHouseException, SimMiskinException{
        Point p = new Point(0, 0);
        Sim owner = new Sim("tatak"); //batas untuk point awal bikin house
        House rumah = new House(p,owner);
        System.out.println(rumah.getMainRoom().getMinimumX());
        System.out.println(rumah.getMainRoom().getMaximumX());
        System.out.println(rumah.getMainRoom().getMinimumY());
        System.out.println(rumah.getMainRoom().getMaximumY());
        rumah.upgradeHouse(rumah.getMainRoom(), "kitchen", true, false);
    }
}