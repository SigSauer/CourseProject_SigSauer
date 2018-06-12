package entity;

public class ShopList {
    private int id;
    private int tableId;
    private String name;
    private String address;
    private String image;
    private String spec;
    private String ownership;
    private String timeBegin;
    private String timeEnd;
    private String workHours;
    private String description;

    public ShopList() {
    }

    public ShopList(String name, String address, String image, String spec, String ownership, String timeBegin, String timeEnd, String workHours, String description) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.spec = spec;
        this.ownership = ownership;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.workHours = workHours;
        this.description = description;
    }

    public ShopList(String name, String address, String image, String spec, String ownership, String timeBegin, String timeEnd, String description) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.spec = spec;
        this.ownership = ownership;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Shop:" +
                "\nid: " + id +
                "\ntableId: " + tableId +
                "\nname: " + name  +
                "\naddress: " + address +
                "\nimage: " + image +
                "\nspec: " + spec +
                "\nownership: " + ownership +
                "\ntimeBegin: " + timeBegin +
                "\ntimeEnd: " + timeEnd+
                "\nworkHours: " + workHours +
                "\ndescription: " + description;
    }
}
