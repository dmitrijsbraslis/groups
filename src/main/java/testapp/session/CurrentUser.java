package testapp.session;

public interface CurrentUser {
    String getName();
    void setName(String name);

    long getId();
    void setId(long id);
}
