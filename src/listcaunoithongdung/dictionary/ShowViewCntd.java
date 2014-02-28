package listcaunoithongdung.dictionary;

import java.util.ArrayList;

import thanhcs.dictionarydemo.R;
import thanhcs.dictionarydemo.R.layout;
import thanhcs.dictionarydemo.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class ShowViewCntd extends Activity {

	TextView tv1, tv2;
	ArrayList<String> ndanh;
	ArrayList<String> ndviet;
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_view_cntd);
	//	lv =(TextView)findViewById(R.id.lvshowcntd);		
		ndviet = new ArrayList<String>();
		ndanh = new ArrayList<String>();
		
		Intent inten = getIntent();
		Bundle bunde = new Bundle();
		bunde = inten.getBundleExtra("data");
		ndanh = bunde.getStringArrayList("ndanh");
		ndviet = bunde.getStringArrayList("ndviet");	

		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_view_cntd, menu);
		return true;
	}

}
