package com.example.teste;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextPaint;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.EditText;
import android.widget.TextView;

public class FormActivity extends Activity {
	public static int pos = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form);
		

		if( FormActivity.pos != -1 ){
			Pessoa p = Pessoa.listaPessoa.get(FormActivity.pos);

    		EditText nome = (EditText)findViewById(R.id.editNome);
    		nome.setText(p.getNome());
    		EditText fone = (EditText)findViewById(R.id.editFone);
    		fone.setText(p.getTelefone());
		}
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	Intent intent;
    	switch( item.getItemId() ){
    	case R.id.menu_voltar:
    		intent = new Intent(this, MainActivity.class);
    		startActivity(intent);
    		return true;
    	case R.id.menu_salvar:
    		EditText nome = (EditText)findViewById(R.id.editNome);
    		EditText fone = (EditText)findViewById(R.id.editFone);
    		
    		Pessoa p = new Pessoa();
    		if( FormActivity.pos == -1 ){
    			p.setNome(nome.getText().toString());
        		p.setTelefone(fone.getText().toString());
        		Pessoa.listaPessoa.add(p);
    		}
    		else{
    			p = Pessoa.listaPessoa.get(pos);
    			p.setNome(nome.getText().toString());
        		p.setTelefone(fone.getText().toString());
    		}

    		intent = new Intent(this, MainActivity.class);
    		startActivity(intent);
    		return true;
    		
    	case R.id.menu_deletar:
    		Pessoa.listaPessoa.remove(FormActivity.pos);
    		intent = new Intent(this, MainActivity.class);
    		startActivity(intent);
    		return true;
    	default:
        	return super.onContextItemSelected(item);
    	}
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.form, menu);
		return true;
	}

}
