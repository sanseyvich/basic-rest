package model;

/**
 * Created by sanseyvich on 12/3/17.
 */
public class InfoBlock {
    long id;
    String info;

    public InfoBlock(long id, String info) {
        this.id = id;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public long getId() {
        return id;
    }
}
