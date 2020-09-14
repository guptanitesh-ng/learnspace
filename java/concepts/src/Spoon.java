

public class Spoon {

	private Scientist owner;

    public Spoon(Scientist s) {
        owner = s;
    }

    public Scientist getOwner() {
        return owner;
    }

    public synchronized void setOwner(Scientist s) {
        owner = s;
    }

    public synchronized void use() {
        System.out.printf("%s has eaten!", owner.getName());
    }
}
