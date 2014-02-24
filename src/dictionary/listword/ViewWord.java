package dictionary.listword;

import java.util.ArrayList;

import databasecaunoithongdung.dictionary.Caunoithongdung;
import databasecaunoithongdung.dictionary.CaunoithongdungDataBase;

import thanhcs.dictionarydemo.R;
import thanhcs.dictionarydemo.R.layout;
import thanhcs.dictionarydemo.R.menu;
import thanhcs.dictionarydemo.database.MyWord;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ViewWord extends Activity {
	//aabb
	TextView tvword, tvvidu, tvmean;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewword);
		tvword= (TextView)findViewById(R.id.tvword);
		tvvidu= (TextView)findViewById(R.id.tvvidu);
		tvmean= (TextView)findViewById(R.id.tvmean);
		Intent intent = getIntent();
		Bundle bundle = intent.getBundleExtra("data");
		MyWord word = (MyWord)bundle.getSerializable("word");
	
		tvword.setText(word.getWord());
		tvvidu.setText(word.getVidu());
		tvmean.setText(word.getMean());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_word, menu);
		return true;
	}

}
