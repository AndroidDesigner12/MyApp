package com.example.william.myapp.NavigationDrawer;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.william.myapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Nav_Drawer extends Fragment {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout  mDrawerLayout;
    private ListView listView;

    public Nav_Drawer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_nav__drawer, container, false);
        listView = (ListView)view.findViewById(R.id.ListViewID);
        listView.setAdapter(getData(getActivity()));
        return view;
    }

    public ArrayAdapter<String> getData(Context context){
        String [] title = getResources().getStringArray(R.array.title);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,title);
        return adapter;
    }

    public void setUp(DrawerLayout drawerLayout, Toolbar toolbar) {

        mDrawerLayout=drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });




    }
}
