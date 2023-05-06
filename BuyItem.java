import java.util.*;

public class BuyItem extends SimPassiveAction {

    Item selectedItem;
    int totalPrice;

    public void begin(Sim sim) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = sim.getInventory();
        if (sim.getCurrentRoom() == null) {
            System.out.println("Anda tidak berada dalam ruangan saat ini.");
            setCancelled(true);
        }else{
            List<Item> itemList = new ArrayList<>();
            System.out.println("Daftar barang yang tersedia:");
            int i = 0;
            for (String itemName : Game.getInstance().getItemMap().keySet()) {
                if (Game.getInstance().getItemMap().get(itemName).getBuyable()) {
                    System.out.println((i + 1) + ". " + itemName + " (" + Game.getInstance().getItemMap().get(itemName).getPrice()    + ")");
                    itemList.add(Game.getInstance().getItemMap().get(itemName));
                    i += 1;
                }
            }
    
            System.out.print("Pilih barang yang ingin dibeli (masukkan nomor): ");
            String itemNumber = scanner.nextLine();
            
            if (CommandLine.validateInputInteger(itemNumber)) {
                if (Integer.valueOf(itemNumber) < 1 || Integer.valueOf(itemNumber) > i - 1) {
                    System.out.println("Nomor barang tidak valid.");
                    setCancelled(true);
                } else {
                    selectedItem = itemList.get(Integer.valueOf(itemNumber) - 1);
                    totalPrice = selectedItem.getPrice();
            
                    if (sim.getUang() < totalPrice) {
                        System.out.println("Uang Anda tidak cukup untuk membeli barang ini.");
                        setCancelled(true);
                    }  

                    Random random = new Random(); 
                    int x = random.nextInt(5) + 1;
                    setDuration(x * 30);
            
                    System.out.println("Barang " + selectedItem.getItemName() + " berhasil dipesan.");
                }
            } else {
                System.out.println("Nomor barang tidak valid.");
                setCancelled(true);
            }
    
            
        }

    }

    public void end(Sim sim) {
        sim.getInventory().addItem(selectedItem, 1);
        sim.setUang(sim.getUang() - totalPrice);
    }

}