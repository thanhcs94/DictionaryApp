package thanhcs.lesson_grammar;

import thanhcs.dictionarydemo.R;
import thanhcs.dictionarydemo.R.layout;
import thanhcs.dictionarydemo.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Select_Leson_Grammar extends Activity {

	private String[]grammar ={"1", "2", "3","4","5","6","7","8","9","10",
			"11", "12", "13","14","15","16","17","18","19","20",
			"21", "22", "23","24","25","26","27","28","29","30",
			"31", "32", "33","34","35","36","37","38","39","310",
			"41", "42", "43","44","45","46","47","48","49","50"
	};
	ListView lv;
	ArrayAdapter<String> adp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select__leson__grammar);
		lv =(ListView)findViewById(R.id.lvlesson);
		
		adp = new ArrayAdapter<String>(Select_Leson_Grammar.this, android.R.layout.simple_list_item_1, grammar);
		
		lv.setAdapter(adp);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			/* (non-Javadoc)
			 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
			 */
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Bundle bunde = new Bundle();
				bunde.putInt("so", arg2+1);
				Intent intent = new Intent(Select_Leson_Grammar.this, ViewGrammar.class);
				intent.putExtra("data", bunde);
				startActivity(intent);
				
			}
		
		
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select__leson__grammar, menu);
		return true;
	}

}
