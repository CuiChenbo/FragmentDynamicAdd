package choi.ccb.com.fragmentdynamicadd;

public class DatasBean {
    public DatasBean(String d, String t){
        id = d;
        tag = t;
    }
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    private String tag;
}
