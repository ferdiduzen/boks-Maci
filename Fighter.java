package boksmaci;

public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    int dodge;
    int aggressiveness;

    public Fighter(String name, int damage, int health, int weight, int dodge, int aggressiveness) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        this.dodge = dodge;
        this.aggressiveness = aggressiveness;
    }

    public int hit(Fighter foe) {
        System.out.println("------------");
        System.out.println(this.name + " => " + foe.name + " isimli sporcuya " + this.damage + " hasar vurdu.");

        if (foe.isDodge()) {
            System.out.println(foe.name + " gelen hasarı savurdu.");
            return foe.health;
        }

        if (foe.health - this.damage < 0) {
            return 0;
        }

        return foe.health - this.damage;
    }

    public boolean isDodge() {
        double randomValue = Math.random() * 100;
        return randomValue <= this.dodge;
    }

    public boolean isAggressiveness() {
        double random = Math.random() * 100;
        return random <= this.aggressiveness;
    }
}