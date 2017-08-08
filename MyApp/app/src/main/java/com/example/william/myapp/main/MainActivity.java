package com.example.william.myapp.main;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.william.myapp.NavigationDrawer.Nav_Drawer;
import com.example.william.myapp.R;
import com.example.william.myapp.TabsFragment.Calender;
import com.example.william.myapp.TabsFragment.Home;
import com.example.william.myapp.TabsFragment.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private int icons[] = {R.drawable.home,R.drawable.calender,R.drawable.menu};

    private ViewPager viewPager;
    private TabLayout tabLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout = (DrawerLayout)findViewById(R.id.DrawerLayout);

        Nav_Drawer nav_drawer = (Nav_Drawer) getSupportFragmentManager().findFragmentById(R.id.fragment);
        nav_drawer.setUp(drawerLayout,toolbar);

        viewPager = (ViewPager)findViewById(R.id.Pager);
        setViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.TabLayoutID);
        tabLayout.setupWithViewPager(viewPager);
        Icons();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    public void Icons(){
        for(int i=0;i<icons.length;i++) {
            tabLayout.getTabAt(i).setIcon(icons[i]);
        }




    }

   public void setViewPager(ViewPager viewPager){
        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
       adapter.addFragment(new Home(),"HOME");
       adapter.addFragment(new Calender(),"CALENDER");
       adapter.addFragment(new Menu(),"MENU");
       viewPager.setAdapter(adapter);

   }

   class viewPagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitle = new ArrayList<>();


       public viewPagerAdapter(FragmentManager fm) {
           super(fm);
       }

       @Override
       public Fragment getItem(int position) {
           return mFragmentList.get(position);
       }

       @Override
       public int getCount() {
           return mFragmentList.size();
       }


       public void addFragment(Fragment fragment, String title){
           mFragmentList.add(fragment);
           mFragmentTitle.add(title);

       }

       @Override
       public CharSequence getPageTitle(int position) {
           return null;
       }
   }


}
