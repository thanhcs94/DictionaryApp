package listcaunoithongdung.dictionary;

import java.util.ArrayList;

import databasecaunoithongdung.dictionary.Caunoithongdung;
import databasecaunoithongdung.dictionary.CaunoithongdungDataBase;
import thanhcs.dictionarydemo.R;
import thanhcs.dictionarydemo.R.layout;
import thanhcs.dictionarydemo.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class List1000CauNoiThongDung extends Activity {

	CaunoithongdungDataBase dbcntd;
	ArrayList<Caunoithongdung> arrcaunoitd;
	ArrayList<String> ndanh;
	ArrayList<String> ndviet;
	MyarrayAdapter adp;
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list1000_cau_noi_thong_dung);
		dbcntd = new  CaunoithongdungDataBase(this);
		
	//	Caunoithongdung caunoi = dbcntd.getcaunoithongdung(10);
		arrcaunoitd = new ArrayList<Caunoithongdung>();
		ndviet = new ArrayList<String>();
		ndanh = new ArrayList<String>();
		arrcaunoitd = dbcntd.getallcaunoithongdung();
		for(int i=0;i<arrcaunoitd.size();i++)
		{
			ndanh.add(arrcaunoitd.get(i).getNdanh());
			ndviet.add(arrcaunoitd.get(i).getNdviet());
		}
		
		adp = new MyarrayAdapter(this, ndanh, ndviet);
		lv = (ListView)findViewById(R.id.lv);
		lv.setAdapter(adp);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list1000_cau_noi_thong_dung, menu);
		return true;
	}

}
