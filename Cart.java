public class Cart {
    // TODO: when I learn about dynamic collections...
    Bundle[] contents = new Bundle[100];
    int amount = 0;

    public double getTotal() {
        double total = 0.0;
        // for (Bundle bundle : contents) {
        //     if(bundle == null) break;
        //     total += bundle.getTotal();            
        // }
        for(int i = 0; i < amount; i++) {
            total += contents[i].getTotal();
        }

        return total;
    }

    public void add(Bundle bundle){
        contents[amount] = bundle;
        amount++;
    }
}
