package boksmaci;

public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {
        if (checkWeight()) {
            System.out.println(f1.name+" Başlayan taraf");
            if (this.f1.isAggressiveness()) {
                this.f2.health = this.f1.hit(f2);

            } else if (this.f2.isAggressiveness()) {
                this.f1.health = this.f2.hit(f1);
            }

            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("-------Yeni Round------");

                this.f2.health = this.f1.hit(this.f2);
                if (isWin()) {
                    break;
                }

                this.f1.health = this.f2.hit(this.f1);
                if (isWin()) {
                    break;
                }

                printScore();
            }
        } else {
            System.out.println("Sikletler uyuşmamaktadır.");
        }
    }

    public boolean checkWeight() {
        return (this.f1.weight >= this.minWeight && this.f1.weight <= this.maxWeight)
                && (f2.weight >= this.minWeight && f2.weight <= this.maxWeight);
    }

    public boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println("\n" + "Kazanan: " + this.f2.name);
            return true;
        } else if (this.f2.health == 0) {
            System.out.println("\n" + "Kazanan: " + this.f1.name);
            return true;
        } else {
            return false;
        }
    }

    public void printScore() {
        System.out.println("-------------");
        System.out.println(this.f1.name + " Kalan can: \t" + this.f1.health);
        System.out.println(this.f2.name + " Kalan can: \t" + this.f2.health);
    }

}