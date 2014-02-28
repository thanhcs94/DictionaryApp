package listcaunoithongdung.dictionary;

import java.util.ArrayList;

import databasecaunoithongdung.dictionary.Caunoithongdung;
import databasecaunoithongdung.dictionary.CaunoithongdungDataBase;
import thanhcs.dictionarydemo.R;
import thanhcs.dictionarydemo.R.layout;
import thanhcs.dictionarydemo.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class List1000CauNoiThongDung extends Activity {

	CaunoithongdungDataBase dbcntd;
	ArrayList<Caunoithongdung> arrcaunoitd;
	ArrayList<String> ndanh;
	ArrayList<String> ndviet;
	MyarrayAdapterCNTD adp;
	ListView lv;
	Spinner spinner;

	String  [] titlecntd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listcaunoithongdung);
		dbcntd = new  CaunoithongdungDataBase(this);
		spinner = (Spinner)findViewById(R.id.spinner1);
		lv =(ListView)findViewById(R.id.lvcntd);
		titlecntd = getResources().getStringArray(R.array.titlecntd);
		ArrayAdapter<String>adp = new ArrayAdapter<String>(List1000CauNoiThongDung.this, android.R.layout.simple_spinner_item, titlecntd);
		adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adp);
		spinner.setOnItemSelectedListener(new ProcessforSpinner());


	}
	private class  ProcessforSpinner implements OnItemSelectedListener
	{

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			Toast.makeText(List1000CauNoiThongDung.this, ""+titlecntd[arg2], Toast.LENGTH_SHORT).show();
			switch (arg2) {
			case 0:
				getcntdloai(1);
				break;
			case 1:
				getcntdloai(2);
				break;
			case 2:
				getcntdloai(2);
				break;
			case 3:
				getcntdloai(3);
				break;
			case 4:
				getcntdloai(4);
				break;
			case 5:
				getcntdloai(5);
				break;
			case 6:
				getcntdloai(6);
				break;
			case 7:
				getcntdloai(7);
				break;
			case 8:
				getcntdloai(8);
				break;
			case 9:
				getcntdloai(9);
				break;
			case 10:
				getcntdloai(10);
				break;
			case 11:
				getcntdloai(11);
				break;
			case 12:
				getcntdloai(12);
				break;
			case 13:
				getcntdloai(13);
				break;
			case 14:
				getcntdloai(14);
				break;
			case 15:
				getcntdloai(15);
				break;
			case 16:
				getcntdloai(16);
				break;
			case 17:
				getcntdloai(17);
				break;


			default:
				break;
			}

		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}


	}

	public void getcntdloai(int i) {
		arrcaunoitd = new ArrayList<Caunoithongdung>();
		ndviet = new ArrayList<String>();
		ndanh = new ArrayList<String>();
		arrcaunoitd = dbcntd.getloaicntd(i);
		for(int dem=0;dem<arrcaunoitd.size();dem++)
		{
			ndanh.add(arrcaunoitd.get(dem).getNdanh());
			ndviet.add(arrcaunoitd.get(dem).getNdviet());
		}
		
		adp = new MyarrayAdapterCNTD(List1000CauNoiThongDung.this, ndanh, ndviet);
		lv.setAdapter(adp);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_actions, menu);
		return true;
	}

}
