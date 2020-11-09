package kr.hs.e_mirim.s2019s04.mirimtabhost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ActionBarAndFragment extends AppCompatActivity {
    ActionBar.Tab tabSakura, tabBeer, tabWave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabSakura = bar.newTab();
        tabSakura.setText("벚꽃");
        tabSakura.setTabListener(tabListener);
        bar.addTab(tabSakura);

        tabBeer = bar.newTab();
        tabBeer.setText("맥주");
        tabBeer.setTabListener(tabListener);
        bar.addTab(tabBeer);

        tabWave = bar.newTab();
        tabWave.setText("파도");
        tabWave.setTabListener(tabListener);
        bar.addTab(tabWave);
    }

    MyFragment myFrags[] = new MyFragment[3];

    ActionBar.TabListener tabListener = new ActionBar.TabListener() {
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            MyFragment myFrag = null;

            if(myFrags[tab.getPosition()] == null) {
                myFrag = new MyFragment();

                Bundle data = new Bundle();
                data.putString("tabName", tab.getText().toString());
                myFrag.setArguments(data);
                myFrags[tab.getPosition()] = myFrag;
            }else {
                myFrag = myFrags[tab.getPosition()];
            }

            ft.replace(android.R.id.content, myFrag);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    };

    public static class MyFragment extends Fragment {
        String tabName;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            LinearLayout linear = new LinearLayout(super.getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            linear.setLayoutParams(params);
            linear.setOrientation(LinearLayout.VERTICAL);
            if (tabName.equals("벚꽃"))
                linear.setBackgroundColor(Color.RED);

            if (tabName.equals("맥주"))
                linear.setBackgroundColor(Color.YELLOW);

            if (tabName.equals("파도"))
                linear.setBackgroundColor(Color.BLUE);

            return linear;
        }
    }
}