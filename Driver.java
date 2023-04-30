import java.util.*;
public class Driver {
    public static void main(String[] args) throws NeighborFoundException, SimNotInHouseException, SimMiskinException{
        Sim sim1 = new Sim("tata");
        Point p = new Point(0, 0);
        House house1 = new House(p, sim1);
        house1.upgradeHouse(house1.getMainRoom(), "kitchen", false, false);
    }
}
