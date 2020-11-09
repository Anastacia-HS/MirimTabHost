package kr.hs.e_mirim.s2019s04.mirimtabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecSakura = tabHost.newTabSpec("Sakura").setIndicator("벚꽃");
        tabSpecSakura.setContent(R.id.linear_sakura);
        tabHost.addTab(tabSpecSakura);

        TabHost.TabSpec tabSpecBeer = tabHost.newTabSpec("Beer").setIndicator("맥주");
        tabSpecBeer.setContent(R.id.linear_beer);
        tabHost.addTab(tabSpecBeer);

        TabHost.TabSpec tabSpecWave = tabHost.newTabSpec("wave").setIndicator("파도");
        tabSpecSakura.setContent(R.id.linear_wave);
        tabHost.addTab(tabSpecWave);
    }
}