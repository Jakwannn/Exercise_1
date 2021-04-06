package com.example.exercise_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener  {

    SearchView searchView;
    private ListView list;
    private ListViewAdapter adapter;
    String[] listnama;
    ArrayAdapter<String > arrayAdapter;
    public static ArrayList<com.example.myapplication.ClassNama> classNamaArrayList = new ArrayList<com.example.myapplication.ClassNama>();
    Bundle bundle = new Bundle();
    Intent intent;
    String detail_kontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        searchView = findViewById(R.id.search_bar);
        listnama = new String[]{"Naufal", "Ilham", "Kurniawan", "Gempi", "Giselle", "Raffi", "Ahmad",
                "Deddy", "Corbuzier", "Rafatar"};
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,listnama);
        list = findViewById(R.id.listkontak);
        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listnama.length; i++) {
            com.example.myapplication.ClassNama classNama = new com.example.myapplication.ClassNama(listnama[i]);
            classNamaArrayList.add(classNama);
            adapter = new ListViewAdapter(this);
            list.setAdapter(arrayAdapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    detail_kontak = classNamaArrayList.get(position).getNama();
                    bundle.putString("a", detail_kontak.trim());
                    PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                    pm.setOnMenuItemClickListener(HomeActivity.this);
                    pm.inflate(R.menu.popup_menu);
                    pm.show();



                }
            });
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    HomeActivity.this.arrayAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    HomeActivity.this.arrayAdapter.getFilter().filter(newText);
                    return false;
                }
            });

        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnView:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                String nomor_kontak = detail_kontak.trim();
                String isinomor = "";
                if (nomor_kontak == "Naufal") {
                    isinomor = "082288416394";
                }
                else if (nomor_kontak == "Ilham"){
                    isinomor = "081298239451";
                }
                else if (nomor_kontak == "Kurniawan"){
                    isinomor = "081294492939";
                }
                else if (nomor_kontak == "Gempi"){
                    isinomor = "081244345425";
                }
                else if (nomor_kontak == "Giselle"){
                    isinomor = "0812084504823";
                }
                else if (nomor_kontak == "Raffi"){
                    isinomor = "082254567893";
                }
                else if (nomor_kontak == "Ahmad"){
                    isinomor = "081245454345";
                }
                else if (nomor_kontak == "Deddy"){
                    isinomor = "081374739475";
                }
                else if (nomor_kontak == "Corbuzier"){
                    isinomor = "081374739475";
                }
                else if (nomor_kontak == "Rafatar"){
                    isinomor = "0821453902849";
                }
                Toast.makeText(getApplicationContext(),isinomor, Toast.LENGTH_LONG).show();
                break;

        }
        return false;

    }

}
