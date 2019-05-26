package com.sk.recyclerviewwithgridview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.sk.recyclerviewwithgridview.R;
import com.sk.recyclerviewwithgridview.adapter.HomeAdapter;
import com.sk.recyclerviewwithgridview.model.Item;
import com.sk.recyclerviewwithgridview.turbidity;
import com.sk.recyclerviewwithgridview.util.AutoFitGridLayoutManager;
import com.sk.recyclerviewwithgridview.waterusage;

import java.util.ArrayList;

/*
 * Created by Sambhaji Karad on 04-Jan-18
 * Mobile 9423476192
 * Email sambhaji2134@gmail.com/
*/

public class MainActivity extends AppCompatActivity implements HomeAdapter.ItemListener{

    private RecyclerView recyclerView;
    private ArrayList<Item> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();

        arrayList.add(new Item("waterheadtank", R.drawable.watertank, "#09A9FF"));
        arrayList.add(new Item("waterusage", R.drawable.waterusage, "#3E51B1"));
        arrayList.add(new Item("Air", R.drawable.air, "#673BB7"));
        arrayList.add(new Item("Energy", R.drawable.energy, "#4BAA50"));
        arrayList.add(new Item("related articles", R.drawable.articles, "#F94336"));

        HomeAdapter adapter = new HomeAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);


        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/

        //AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        //recyclerView.setLayoutManager(layoutManager);


        /**
         Simple GridLayoutManager that spans two columns
         **/
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void onItemClick(Item item) {
//        Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();
        switch (item.text)
        {
            case "waterheadtank":Intent intent=new Intent(this,turbidity.class);
            startActivity(intent);
            break;
            case "waterusage":Intent intent1=new Intent(this,waterusage.class);
                startActivity(intent1);
                break;
            default:Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //https://www.journaldev.com/13792/android-gridlayoutmanager-example
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
