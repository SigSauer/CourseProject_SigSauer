package scenes.ListScene;

public class ShopList {
    private String username;
    private String name;
    private String address;
    private String image;
    private String spec;
    private String ownership;
    private String timeBegin;
    private String timeEnd;

    public ShopList() {
    }


    public ShopList(String username, String name, String address, String spec, String ownership, String timeBegin, String timeEnd) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.spec = spec;
        this.ownership = ownership;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
    }

    public ShopList(String username, String name, String address, String image, String spec, String ownership, String timeBegin, String timeEnd) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.image = image;
        this.spec = spec;
        this.ownership = ownership;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


}
