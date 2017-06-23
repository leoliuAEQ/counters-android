package ca.aequilibrium.counters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_VALUE = "A4B65C20-3BF1-411C-8070-DEE3EA729729";

    private MenuItem menuItemAdd;
    private ListView listView;
    private ArrayAdapter<Integer> listViewAdapter;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, new ArrayList<Integer>());
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Integer value = (Integer) listView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(EXTRA_VALUE, value);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menuItemAdd = menu.findItem(R.id.menuitem_add);
        menuItemAdd.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                listViewAdapter.insert(counter, 0);
                counter++;
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
