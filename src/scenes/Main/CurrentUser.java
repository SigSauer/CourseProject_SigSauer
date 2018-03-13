package scenes.Main;

public class CurrentUser {
    private String CURRENT_USER;

    public CurrentUser(String CURRENT_USER) {
        this.CURRENT_USER = CURRENT_USER;
    }

    public CurrentUser() {
    }

    public String getCURRENT_USER() {
        return CURRENT_USER;
    }

    public void setCURRENT_USER(String CURRENT_USER) {
        this.CURRENT_USER = CURRENT_USER;
    }
}
