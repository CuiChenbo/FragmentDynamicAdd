package choi.ccb.com.fragmentdynamicadd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import choi.ccb.com.fragmentdynamicadd.fragment.ActiveFragment;
import choi.ccb.com.fragmentdynamicadd.fragment.BannerFragment;
import choi.ccb.com.fragmentdynamicadd.fragment.ListcFragment;

/**
 *  **动态添加Fragment，相同的Fragment可以重复添加多次；每个Fragment就是一个组件，目的是每个组件的变化都会有生命周期；
 * 
 * datas是数据集合，根据这些数据显示Fragment的位置；这个数据包含要显示Fragment的类型，和当前Fragment的ID；
 * mViews是Fragment的集合，有ID和Fragment，可以根据此ID获取某一个Fragment；
 * 同类型的Fragment可以添加多个，和ID一一对应；
 * 
 * 把每个Fragment/View 存在集合中，然后对集合进行操作，主要是这种思想；
 * 
 * 做了一个特殊的操作，改变数据的时候，第一个位置的Fragment不能被移除；
 */
public class MainActivity extends AppCompatActivity {

    private LinearLayout llMain;
    private Button btChagen;
    private final String BANNERTAG = "BANNERTAG";
    private final String LISTRTAG = "LISTRTAG";
    private final String ACTIVETAG = "ACTIVETAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llMain = findViewById(R.id.llMain);
        btChagen = findViewById(R.id.btChagen);
        initDatas();
        initViews();
        initList();
    }

    private List<DatasBean> datas;
    private void initDatas() {
        datas = new ArrayList<>();
        datas.add(new DatasBean("banner_1", BANNERTAG));
        datas.add(new DatasBean("active_1", ACTIVETAG));
        datas.add(new DatasBean("list_1", LISTRTAG));
        datas.add(new DatasBean("banner_2", BANNERTAG));
    }
    
    //维护fragment的集合；
    private List<FragmentsBean> mViews;
    private void initViews() {
        mViews = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            switch (datas.get(i).getTag()) {
                case LISTRTAG:
                    mViews.add(new FragmentsBean(datas.get(i).getId(), new ListcFragment()));
                    break;
                case ACTIVETAG:
                    mViews.add(new FragmentsBean(datas.get(i).getId(), new ActiveFragment()));
                    break;
                case BANNERTAG:
                    mViews.add(new FragmentsBean(datas.get(i).getId(), new BannerFragment()));
                    break;
            }
        }
        findFragments();
    }

    private void findFragments() {
        for (int i = 0; i < mViews.size(); i++) {
            getFragmentManager().beginTransaction().add(R.id.llMain, mViews.get(i).getFragment(), mViews.get(i).getId()).commit();
        }
        if (holdFm != null) {
            mViews.add(0, holdFm);
            holdFm = null;
        }
    }



    private void initList() {
        btChagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment();
            }
        });
    }

    private FragmentsBean holdFm; //暂存第一个Fragment
    /**
     * 改变fragment布局的时候，第一个fragment不要移除！！！；
     */
    private void ChangeFragment() {
        //从第2个开始，不删除第一个数据；
        for (int i = 1; i < mViews.size(); i++) {
            getFragmentManager().beginTransaction().remove(mViews.get(i).getFragment()).commit();
        }
        holdFm = mViews.get(0); //把第一个数据暂存起来，然后清空集合；最后再把此数据添加到集合的第一位，保持数据相同；
        Refresh();
    }
    private void Refresh() {
        datas = new ArrayList<>();
        datas.add(new DatasBean("list_1", LISTRTAG));
        datas.add(new DatasBean("banner_3", BANNERTAG));
        datas.add(new DatasBean("active_1", ACTIVETAG));
        datas.add(new DatasBean("banner_2", BANNERTAG));
        initViews();
    }
}
