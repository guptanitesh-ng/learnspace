

public class Scientist {

	private Boolean isHungry = true;
    private String name = "";

    public Scientist(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void eat(Spoon spoon, Scientist s)
    {
        while (isHungry)
        {
            if (spoon.getOwner() != this)
            {
                try {
                    Thread.sleep(1);
                } catch(InterruptedException e) {
                    continue;
                }
                continue;
            }

            if (s.isHungry)
            {
                System.out.printf("%s: I'm giving you, %s, the spoon. ", name, s.getName());
                spoon.setOwner(s);
                continue;
            }

            spoon.use();

            isHungry = false;

            System.out.printf("%s: I'm not hungry anymore. ", name);

            spoon.setOwner(s);
        }
    }
}
