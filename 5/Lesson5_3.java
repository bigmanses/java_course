import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Lesson5_3 {
    static class Animal implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String name;

        public Animal(String name) {
            this.name = name;
        }
        public String getname(){
            return name;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }
    public static void serializeAnimalArray(Animal anim, Animal anim1) throws IOException {
        Path path = Paths.get("Animals.bin");
        int size = 2;
        ObjectOutputStream obj = new ObjectOutputStream(Files.newOutputStream(path));
        obj.writeObject(size);
        obj.writeObject(anim);
        obj.writeObject(anim1);
        obj.close();
    }
    public static byte[] deserializeAnimalArraybyte() throws IOException, ClassNotFoundException {
        Path path = Paths.get("Animals.bin");
       byte [] animals;
       animals = Files.readAllBytes(path);
        return animals;
    }
    public static Animal [] deserializeAnimalArray(byte[] animal){
        try {
            ObjectInputStream obj = new ObjectInputStream(new ByteArrayInputStream(animal));
            int size = (int) obj.readObject();
            Animal [] animals = new Animal[size];
            for (int i = 0; i < size; i++) {
                animals[i] = (Animal) obj.readObject();
                //System.out.println(animals[i].getname());
            }
            obj.close();
            return animals;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Animal anim = new Animal("Cat");
        Animal anim1 = new Animal("Dog");
        serializeAnimalArray(anim, anim1);
        deserializeAnimalArray(deserializeAnimalArraybyte());

    }
}
