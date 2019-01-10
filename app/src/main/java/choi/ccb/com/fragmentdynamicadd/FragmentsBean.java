package choi.ccb.com.fragmentdynamicadd;

import android.app.Fragment;

public class FragmentsBean {
    public FragmentsBean(String d, Fragment f){
        id = d;
        fragment = f ;
    }
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    private Fragment fragment;
}
