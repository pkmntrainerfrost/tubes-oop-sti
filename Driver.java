public class Driver {
    public static void main(String[] args){
        Point p = new Point(0, 0);
        Sim sim = new Sim("Pedro");
        House rumah = new House(p, sim);
        try {
            rumah.upgradeHouse(rumah.getMainRoom(), "dapur", true, false);
        } catch (NeighborFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SimNotInHouseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SimMiskinException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
