import java.util.*;

public class ToysCollection {
    private final Map<Integer, Toy> collection;
    private int toyId = 1;

    public ToysCollection() {
        this.collection = new HashMap<>();
    }

    public int addToy(String name, int quantity, int weight) {
        Toy toy = new Toy(this.toyId, name, quantity, weight);
        this.collection.put(this.toyId, toy);
        this.toyId++;
        return toy.id;
    }

    public void changeWeight(int id, int weight) {
        this.collection.get(id).weight = weight;
    }

    public boolean isPrizesAvailable() {
        for (Toy toy : this.collection.values()) {
            if (toy.quantity > 0) {
                return true;
            }
        }
        return false;
    }
    
    public String getPrize() {
        if (!this.isPrizesAvailable()) {
            return "Игрушки закончились";
        }
        int weightsSum = 0;
        for (Toy toy : this.collection.values()) {
            if (toy.quantity > 0) {
                weightsSum += toy.weight;
            }
        }
        Double chance = (100.0 / weightsSum);
        List<Integer> prizes = new ArrayList<>();
        for (Toy toy : this.collection.values()) {
            if (toy.quantity > 0) {
                long toyRatio = Math.round(chance * toy.weight);
                for (int i = 0; i < toyRatio; i++) {
                    prizes.add(toy.id);
                }
            }
        }
        Random rand = new Random();
        int prizeId = prizes.get(rand.nextInt(prizes.size()));
        Toy toy = this.collection.get(prizeId);
        toy.quantity -= 1;
        return toy.name;
    }
}