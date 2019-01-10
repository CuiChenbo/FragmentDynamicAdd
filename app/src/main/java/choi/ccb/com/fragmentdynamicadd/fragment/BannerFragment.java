package choi.ccb.com.fragmentdynamicadd.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import choi.ccb.com.fragmentdynamicadd.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BannerFragment extends Fragment {


    public BannerFragment() {
        // Required empty public constructor
    }


    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       mView = inflater.inflate(R.layout.fragment_banner, container, false);
       initViews();
        return mView;
    }

    private void initViews() {
        List<Integer> l = Arrays.asList(R.mipmap.ic_launcher,R.mipmap.icon_ccb);
      ConvenientBanner convenientBanner = mView.findViewById(R.id.convenientBanner);
      convenientBanner.setPages(new CBViewHolderCreator() {
          @Override
          public Holder createHolder(View itemView) {
              return new Holder<Integer>(itemView) {
                  private ImageView iv;
                  @Override
                  protected void initView(View itemView) {
                     iv = itemView.findViewById(R.id.iv);
                  }

                  @Override
                  public void updateUI(Integer data) {
                       iv.setImageResource(data);
                  }
              };
          }

          @Override
          public int getLayoutId() {
              return R.layout.banner_item;
          }
      }, l).setCanLoop(true).startTurning(3000).startTurning();
    }

}
