package choi.ccb.com.fragmentdynamicadd.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import choi.ccb.com.fragmentdynamicadd.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActiveFragment extends Fragment {


    public ActiveFragment() {
        // Required empty public constructor
    }


    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       mView = inflater.inflate(R.layout.fragment_active, container, false);
       initViews();
        return mView;
    }

    private void initViews() {

    }

}
