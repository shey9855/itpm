package Models;

public class Tag {

    private int id;
    private String tag_name;
    private String tag_code;
    private String related_tag;

    public Tag() {
    }

    public Tag(int id) {
        this.id = id;
    }

    public Tag(int id, String tag_name, String tag_code, String related_tag) {
        this.id = id;
        this.tag_name = tag_name;
        this.tag_code = tag_code;
        this.related_tag = related_tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getTag_code() {
        return tag_code;
    }

    public void setTag_code(String tag_code) {
        this.tag_code = tag_code;
    }

    public String getRelated_tag() {
        return related_tag;
    }

    public void setRelated_tag(String related_tag) {
        this.related_tag = related_tag;
    }

}
