package thanhcs.lesson_grammar;

import java.util.ArrayList;

import listcaunoithongdung.dictionary.MyarrayAdapterCNTD;
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

	
	private String []titlegrammar;
	private String []titlegrammar2;
	ArrayList<String>argrammar;
	ArrayList<String>argrammar2;
	ListView lv;
	MyarrayAdapterCNTD adp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select__leson__grammar);
		argrammar = new ArrayList<String>();
		argrammar2 = new ArrayList<String>();
		lv =(ListView)findViewById(R.id.lvlesson);
		titlegrammar = getResources().getStringArray(R.array.titlegrammar);
		titlegrammar2 = getResources().getStringArray(R.array.titlegrammar2);
		
		for(int  i=0;i< titlegrammar.length;i++)
		{
			argrammar.add(titlegrammar[i]);
			argrammar2.add(titlegrammar2[i]);
		}
		
		adp = new MyarrayAdapterCNTD(Select_Leson_Grammar.this, argrammar,argrammar2);
		
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
