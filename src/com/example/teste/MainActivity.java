package com.example.teste;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MainActivity extends Activity {
	public static MainActivity mainActivity = null;
	ListView lista;
	ArrayList<Pessoa> listaPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	MainActivity.mainActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);
        listaPessoa = Pessoa.listaPessoa;
        
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Intent intent = new Intent(MainActivity.mainActivity, FormActivity.class);
				FormActivity.pos = arg2;
				MainActivity.mainActivity.startActivity(intent);
			}
		});
        
        updateList();
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch( item.getItemId() ){
    	case R.id.add:
			FormActivity.pos = -1;
    		Intent intent = new Intent(this, FormActivity.class);
    		startActivity(intent);
    		return true;
    	default:
        	return super.onContextItemSelected(item);
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater m = getMenuInflater();
        m.inflate(R.menu.main, menu);
        return true;
    }
    
    public void updateList(){
    	lista.setAdapter( new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, new ArrayList<String>()));
    	
    	ArrayList<String> list = new ArrayList<String>();
    	for( int i =0; i < listaPessoa.size(); i++ ){
    		Pessoa pes = listaPessoa.get(i);
    		pes.setId(i);
    		list.add(pes.getNome()+" - "+pes.getTelefone());
    	}
    	ArrayAdapter arr = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);
        lista.setAdapter(arr);
    }    
}
