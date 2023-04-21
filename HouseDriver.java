public class HouseDriver {
    public static void main(String[] args){
        Point p = new Point(1, 1);
        Grid g = new Grid(10, 10); //batas untuk point awal bikin house
        House rumah = new House(p,g);
        Sim sim = new Sim("tatak");
        System.out.println("max x rumah: " + rumah.getMaximumX());
        System.out.println("max y rumah:  "+ rumah.getMaximumY());
        System.out.println("min x rumah: " + rumah.getMinimumX());
        System.out.println("min y rumah:  "+ rumah.getMinimumY());
        Point pNew = new Point(1, 7);
        Room newRoom = new Room(pNew, 6, 6);
        try {
            rumah.upgradeHouse(newRoom, sim, "top");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("max x ruangan: " + newRoom.getMaximumX());
        System.out.println("max y ruangan: " + newRoom.getMaximumY());
        System.out.println("min x ruangan: " + newRoom.getMinimumX());
        System.out.println("min y ruangan: " + newRoom.getMinimumY());
    }
}