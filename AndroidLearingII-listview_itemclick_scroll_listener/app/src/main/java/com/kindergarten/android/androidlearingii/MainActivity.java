package com.kindergarten.android.androidlearingii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener{

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private SimpleAdapter mSimpleAdapter;
    private String[] data1 = {"a","b","c","d","e","f","g","h","i"};
    private List<Map<String, Object>> data2= new ArrayList<Map<String, Object>>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.listview);

        //instantiate an adapter
        /**
         * 3 arguments:
         * 1. context: current activity
         * 2. layout for every item in current listview
         * 3. data resource
         */
        mAdapter =  new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data1);
        /**
         * 5 arguments:
         * 1. context: current activity
         * 2. data: generic group: List<? extends Map<String, ?>> data, a list formed by maps
         *                         a map: one line(item) in listview
         *                         key-value in map: key must contains all the keys in "from"
         * 3. resource: layout(id) for every item in current listview
         * 4. from: keys in the map
         * 5. to: bound view id
         */
        mSimpleAdapter = new SimpleAdapter(MainActivity.this, getData(), R.layout.item, new String[]{"picture", "content"}, new int[]{R.id.itempicture, R.id.itemtext});
        // set adapter for listview
        //mListView.setAdapter(mAdapter);
        mListView.setAdapter(mSimpleAdapter);
        mListView.setOnItemClickListener(this);
        mListView.setOnScrollListener(this);



    }

    private List<Map<String, Object>> getData() {
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("picture", R.mipmap.ic_launcher);
            map.put("content", "item" + i);
            data2.add(map);
        }

        return data2;
    }

    /**
     *
     * @param adapterView
     * @param view
     * @param i click on item, give back a position information
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String position = mListView.getItemAtPosition(i) + "";
        Toast.makeText(MainActivity.this, position + "is clicked", Toast.LENGTH_SHORT).show();
    }


    /**
     *
     * @param absListView
     * @param i scroll state
     */
    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case SCROLL_STATE_FLING:
                Log.i("scroll", "list view still scrolling because user scroll firmly and because of inertia it cannot stop");
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("picture", R.mipmap.sev);
                map.put("content", "new user");
                data2.add(map);
                mSimpleAdapter.notifyDataSetChanged();
                break;

            case SCROLL_STATE_IDLE:
                Log.i("scroll", "list view has stopped scrolling");
                break;

            case SCROLL_STATE_TOUCH_SCROLL:
                Log.i("scroll", "list view is scrolling with user's finger on the screen");
                break;
        }

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

    }
}
