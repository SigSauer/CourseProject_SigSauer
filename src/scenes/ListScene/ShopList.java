package scenes.ListScene;

public class ShopList {
    private int id;
    private String name;
    private String address;
    private String image;
    private String spec;
    private String ownership;
    private String timeBegin;
    private String timeEnd;
    private String workHours;

    public ShopList() {
    }

    public ShopList(int id, String name, String address, String spec, String ownership, String timeBegin, String timeEnd, String workHours) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.spec = spec;
        this.ownership = ownership;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.workHours = workHours;
    }



    public ShopList(int id, String name, String address, String image, String spec, String ownership, String timeBegin, String timeEnd, String workHours) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.image = image;
        this.spec = spec;
        this.ownership = ownership;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.workHours = workHours;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(String timeBegin) {
        this.timeBegin = timeBegin;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    @Override
    public String toString() {
        return "Shop:" +
                "\nid: " + id +
                "\nname: " + name  +
                "\naddress: " + address +
                "\nimage: " + image +
                "\nspec: " + spec +
                "\nownership: " + ownership +
                "\ntimeBegin: " + timeBegin +
                "\ntimeEnd: " + timeEnd+
                "\nworkHours: " + workHours;
    }
}
