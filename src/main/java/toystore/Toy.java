package toystore;

import java.util.UUID;

public class Toy {

    private UUID id;
    private String nameToy;
    private double priceToy;
    private int weightToy;

    public Toy(UUID id, String nameToy, double priceToy, int weightToy) {
        this.id = id;
        this.nameToy = nameToy;
        this.priceToy = priceToy;
        this.weightToy = weightToy;
    }

    public UUID getId() {
        return id;
    }


    public String getNameToy() {
        return nameToy;
    }

    public void setNameToy(String nameToy) {
        this.nameToy = nameToy;
    }

    public double getPriceToy() {
        return priceToy;
    }

    public void setPriceToy(double priceToy) {
        this.priceToy = priceToy;
    }

    public int getWeightToy() {
        return weightToy;
    }

    public void setWeightToy(int weightToy) {
        this.weightToy = weightToy;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", nameToy='" + nameToy + '\'' +
                ", priceToy=" + priceToy +
                ", weightToy=" + weightToy +
                '}';
    }

    public void printInfo(){
        System.out.println(this);
    }
}

