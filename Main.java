import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ToysCollection toysCollection = new ToysCollection();
        toysCollection.addToy("Конструктор", 40, 10);
        toysCollection.addToy("Машинка", 30, 20);
        toysCollection.addToy("Робот", 20, 30);
        toysCollection.addToy("Самолет", 10, 40);

        try (FileWriter writer = new FileWriter("results.txt", false)) {
            while (toysCollection.isPrizesAvailable()) {
                writer.write(toysCollection.getPrize() + '\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Не удалось записать призовую игрушку в файл");
        }
    }

}