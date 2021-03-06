package models;

public class Fruit extends Item {
    private String variety;
    private String quantity;
    private boolean youPick = false;
//    public static final String DATABASE_TYPE = "fruit";



    public Fruit (int userId, String name, String location, boolean pub, String description, boolean barter, String variety, String quantity, boolean youPick) {
    super(userId, name, location, pub, description, barter);
    this.variety = variety;
    this.quantity = quantity;
    this.youPick = youPick;
//    type = DATABASE_TYPE;
    }

    public Fruit (String name, String location, boolean pub, String description, String variety, String quantity, boolean youPick) {
        super(name, location, pub, description);
        this.variety = variety;
        this.quantity = quantity;
        this.youPick = youPick;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public boolean isYouPick() {
        return youPick;
    }

    public void setYouPick(boolean youPick) {
        this.youPick = youPick;
    }

}
