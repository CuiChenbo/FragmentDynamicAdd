package choi.ccb.com.fragmentdynamicadd.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Arrays;

import choi.ccb.com.fragmentdynamicadd.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListcFragment extends Fragment {


    public ListcFragment() {
        // Required empty public constructor
    }


    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       mView = inflater.inflate(R.layout.fragment_listr, container, false);
       initViews();
        return mView;
    }

    private void initViews() {
        RecyclerView recyclerView = mView.findViewById(R.id.rv);
        LinearLayoutManager llm =new LinearLayoutManager(getActivity());
       llm.setOrientation(OrientationHelper.HORIZONTAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(new BaseQuickAdapter(R.layout.rv_item, Arrays.asList("","","","","","","")) {
            @Override
            protected void convert(BaseViewHolder helper, Object item) {

            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }
        });
    }

}
