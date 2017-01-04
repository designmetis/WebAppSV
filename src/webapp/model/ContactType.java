package webapp.model;


public enum ContactType {
    PHONE("Телефон"),
    MOBILE("Мобильный"),
    //HOME PHONE("Домашний тел."),
    SKYPE("Skype"),
    MAIL("Почта"),
    ICQ("ICQ");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
