package thanhcs.dictionarydemo;

import java.util.ArrayList;



import listcaunoithongdung.dictionary.List1000CauNoiThongDung;
import listcaunoithongdung.dictionary.MyarrayAdapterCNTD;

import databasecaunoithongdung.dictionary.Caunoithongdung;
import databasecaunoithongdung.dictionary.CaunoithongdungDataBase;
import dictionary.listword.MyarrayAdapter;
import dictionary.listword.MyarrayaDapterABC;
import dictionary.listword.ViewWord;



import thanhcs.dictionarydemo.database.DictionaryDataBase;
import thanhcs.dictionarydemo.database.MyWord;
import thanhcs.game.DangNhapGame;
import thanhcs.lesson_grammar.Select_Leson_Grammar;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Dictionary extends Activity{

	CaunoithongdungDataBase dbcntd;
	ArrayList<Caunoithongdung> arrcaunoitd;
	//=============================
	TabHost tabhost;
	DictionaryDataBase db;
	MyWord word;
	int index =0, size;
	ArrayList<MyWord> arrlistword;
	ArrayList<MyWord> arrlistwordabc;
	ArrayList<MyWord> arrlistwordtudahoc;
	MyarrayAdapter adp;
	MyarrayaDapterABC adpabc;
	MyarrayAdapterCNTD adtdahoc;
	//==============================

	//===tab list word
	ArrayList<String> arrstrword,arrstrnghia, arrphatam, arrloai;
	ArrayList<String> arrstrwordabc,arrstrnghiaabc, arrphatamabc, arrloaiabc;
	ArrayList<String> arrstrwordahoc;
	ListView lv;
	Spinner spinnerabc;
	ListView lvdahoc;
	ListView lvabc;
	TextView tvthongtindahoc;

	String []a ={"A", "B", "C", "D", "E",
			"F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T",
			"W", "U", "V", "W", "Y",
			"Z"

	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dictionary);
		db = new DictionaryDataBase(this);
		arrlistwordtudahoc = new ArrayList<MyWord>();
		arrlistwordtudahoc = db.gettudahoc();


		setinit();
		settablistdahoc();
		settablistWord();
		settablistWordABC();
	
	}



	//================================================Tab LIST WORD ABC ==========================================================

	private void settablistdahoc() {
		lvdahoc =(ListView)findViewById(R.id.lvdahoc);
		ArrayList<String> tudahoc = new ArrayList<String>();
		ArrayList<String> nghiadahoc = new ArrayList<String>();

		for(int i=0;i<arrlistwordtudahoc.size();i++)
		{
			tudahoc.add((arrlistwordtudahoc.get(i).getWord()));
			nghiadahoc.add((arrlistwordtudahoc.get(i).getVidu()));
		}
		adtdahoc = new MyarrayAdapterCNTD(Dictionary.this,
				tudahoc, 
				nghiadahoc);
		lvdahoc.setAdapter(adtdahoc);




	}



	private void settablistWordABC() {

		tvthongtindahoc =(TextView)findViewById(R.id.tvthongtin);
		tvthongtindahoc.setText("Tổng :3114"+"-"+"Đã Học :"+arrlistwordtudahoc.size());
		arrstrwordabc =new ArrayList<String>();
		arrstrnghiaabc =new ArrayList<String>();
		arrphatamabc =new ArrayList<String>();
		arrloaiabc =new ArrayList<String>();
		ArrayAdapter<String> adpspin;
		arrlistwordabc =new ArrayList<MyWord>();
		lvabc =(ListView)findViewById(R.id.lvabc);
		spinnerabc =(Spinner)findViewById(R.id.spinnerabc);
		adpspin =new ArrayAdapter<String>(Dictionary.this, android.R.layout.simple_spinner_item, a);
		adpspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerabc.setAdapter(adpspin);
		spinnerabc.setOnItemSelectedListener(new ItemselectSP());



	}
	private class ItemselectSP implements OnItemSelectedListener
	{

		/* (non-Javadoc)
		 * @see android.widget.AdapterView.OnItemSelectedListener#onItemSelected(android.widget.AdapterView, android.view.View, int, long)
		 */
		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {

			if(a[arg2].equalsIgnoreCase(a[0])) //1->221
			{
				setkhiclickABC(2, 221);
			}
			if(a[arg2].equalsIgnoreCase(a[1]))
			{
				setkhiclickABC(222, 370);
			}
			if(a[arg2].equalsIgnoreCase(a[2]))
			{
				setkhiclickABC(371, 691);

			}
			if(a[arg2].equalsIgnoreCase(a[3]))
			{
				setkhiclickABC(692, 887);
			}
			if(a[arg2].equalsIgnoreCase(a[4]))
			{
				setkhiclickABC(888, 1045);
			}
			if(a[arg2].equalsIgnoreCase(a[5]))
			{
				setkhiclickABC(1046,1200 );
			}
			if(a[arg2].equalsIgnoreCase(a[6])) //1->221
			{
				setkhiclickABC(1201, 1283);
			}
			if(a[arg2].equalsIgnoreCase(a[7]))
			{
				setkhiclickABC(1284, 1377);
			}
			if(a[arg2].equalsIgnoreCase(a[8]))
			{
				setkhiclickABC(1378, 1503);
			}
			if(a[arg2].equalsIgnoreCase(a[9]))
			{
				setkhiclickABC(1504, 1526);
			}
			if(a[arg2].equalsIgnoreCase(a[10]))
			{
				setkhiclickABC(1527, 1553);
			}
			if(a[arg2].equalsIgnoreCase(a[11]))
			{
				setkhiclickABC(1554, 1658);
			}
			if(a[arg2].equalsIgnoreCase(a[12])) //1->221
			{
				setkhiclickABC(1659, 1791);
			}
			if(a[arg2].equalsIgnoreCase(a[13]))
			{
				setkhiclickABC(1792, 1854);
			}
			if(a[arg2].equalsIgnoreCase(a[14]))
			{
				setkhiclickABC(1855, 1925);
			}
			if(a[arg2].equalsIgnoreCase(a[15]))
			{
				setkhiclickABC(1926, 2191);
			}
			if(a[arg2].equalsIgnoreCase(a[16]))
			{
				setkhiclickABC(2192, 2206);
			}
			if(a[arg2].equalsIgnoreCase(a[17]))
			{
				setkhiclickABC(2207, 2389);
			}
			if(a[arg2].equalsIgnoreCase(a[18])) //1->221
			{
				setkhiclickABC(2390, 2776);
			}
			if(a[arg2].equalsIgnoreCase(a[19]))
			{
				setkhiclickABC(2777, 2931);
			}
			if(a[arg2].equalsIgnoreCase(a[20]))
			{
				setkhiclickABC(2932, 400);
			}
			if(a[arg2].equalsIgnoreCase(a[21]))
			{
				setkhiclickABC(222, 2970);
			}
			if(a[arg2].equalsIgnoreCase(a[22]))
			{
				setkhiclickABC(2971, 3007);
			}
			if(a[arg2].equalsIgnoreCase(a[23]))
			{
				setkhiclickABC(3008, 3105);
			}
			if(a[arg2].equalsIgnoreCase(a[24])) //1->221
			{
				setkhiclickABC(3106, 3113);
			}
			if(a[arg2].equalsIgnoreCase(a[25]))
			{
				setkhiclickABC(3113, 3114);
			}


		}

		/* (non-Javadoc)
		 * @see android.widget.AdapterView.OnItemSelectedListener#onNothingSelected(android.widget.AdapterView)
		 */
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}



	}

	//==========================================================tab LIST WORD ===============================================
	private void settablistWord() {
		arrlistword = new ArrayList<MyWord>();
		MyWord []word = new MyWord[5];
		int []a = new int[5];
		int so = (int)(Math.random()*500);
		a[0]=5;a[1]=300;a[2]=1000;a[3]=1500;a[4]=2500;
		for(int i=0;i<5;i++)
		{
			a[i]=a[i]+so;
			word[i] = db.getWord(a[i]);
			arrlistword.add(word[i]);
		}
		db = new DictionaryDataBase(this);
		arrstrword =new ArrayList<String>();
		arrstrnghia =new ArrayList<String>();
		arrphatam =new ArrayList<String>();
		arrloai =new ArrayList<String>();


		arrstrword.removeAll(arrstrword);
		arrloai.removeAll(arrloai);
		arrphatam.removeAll(arrphatam);
		arrstrnghia.removeAll(arrstrnghia);


		size = arrlistword.size();	
		lv =(ListView)findViewById(R.id.lvword);
		setlist();

	}

	private void setlist() {

		arrstrword.removeAll(arrstrword);
		arrloai.removeAll(arrloai);
		arrphatam.removeAll(arrphatam);
		arrstrnghia.removeAll(arrstrnghia);
		for(int i=0;i<arrlistword.size();i++)
		{
			System.out.println(""+i);
			arrstrword.add(arrlistword.get(i).getWord());
			arrstrnghia.add(arrlistword.get(i).getVidu());
			arrphatam.add(arrlistword.get(i).getSound());
			arrloai.add(arrlistword.get(i).getType());
		}

		adp = new MyarrayAdapter(Dictionary.this, arrstrword, arrstrnghia, arrphatam, arrloai);
		lv.setAdapter(adp);

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				word =arrlistword.get(arg2);
				Intent intent= new Intent(Dictionary.this, ViewWord.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("word", word);
				intent.putExtra("data",bundle);
				startActivity(intent);
			}
		});

		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			/* (non-Javadoc)
			 * @see android.widget.AdapterView.OnItemLongClickListener#onItemLongClick(android.widget.AdapterView, android.view.View, int, long)
			 */
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				MyWord wordupdate = new MyWord();
				wordupdate.setId(arrlistword.get(arg2).getId());
				wordupdate.setMean(arrlistword.get(arg2).getMean());
				wordupdate.setVidu(arrlistword.get(arg2).getVidu());
				wordupdate.setSound(arrlistword.get(arg2).getSound());
				wordupdate.setImportan(arrlistword.get(arg2).getImportan());
				wordupdate.setType(arrlistword.get(arg2).getType());
				wordupdate.setWord(arrlistword.get(arg2).getWord());
				wordupdate.setHistory(arrlistword.get(arg2).getHistory());
				wordupdate.setLearn(1);
				db.updateWord(wordupdate);

				//su kien can su li sau khi update la da hoc!
				Toast.makeText(Dictionary.this, "Bạn đã đánh thuộc từ này", Toast.LENGTH_SHORT).show();
				arrlistwordtudahoc.add(wordupdate);
				adtdahoc.notifyDataSetChanged();
				tvthongtindahoc.setText("Tổng :3114"+"-"+"Đã Học :"+arrlistwordtudahoc.size());
				settablistdahoc();
				return true;
			}



		}); 
	}



	//=================================================Creat TabHost============================================================
	private void setinit() {
		tabhost = (TabHost)findViewById(R.id.tabhost);
		tabhost.setup();
		TabSpec spec;
		spec = tabhost.newTabSpec("5 Word");
		spec.setIndicator("5 Word",getResources().getDrawable(R.drawable.wink));
		spec.setContent(R.id.listWord);
		tabhost.addTab(spec);

		spec = tabhost.newTabSpec("ABC");
		spec.setIndicator("ABC",getResources().getDrawable(R.drawable.monster));
		spec.setContent(R.id.listtheoabc);
		tabhost.addTab(spec);



		spec = tabhost.newTabSpec("Đã Học");
		spec.setIndicator("Đã Học",getResources().getDrawable(R.drawable.cantbelieve));
		spec.setContent(R.id.listdahoc);
		tabhost.addTab(spec);

		

	}

	//============================================SEt ACTION BAR ===============================================
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater inflate  =  getMenuInflater();
		inflate.inflate(R.menu.activity_main_actions, menu);


		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
				.getActionView();
		searchView.setSearchableInfo(searchManager
				.getSearchableInfo(getComponentName()));
		return super.onCreateOptionsMenu(menu);
	}

	//======================================menu===================================================================
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_search:
			Toast.makeText(Dictionary.this, "Hello android search", Toast.LENGTH_SHORT).show();
			break;
		case R.id.next5tu:
		{
			settablistWord();
		}
		return true;

		case R.id.dongtubqt:
		{

		}
		return true;


		case R.id.canoithongdung:
			Intent intentcntd = new Intent(Dictionary.this,List1000CauNoiThongDung.class);
			startActivity(intentcntd);

			return true;
		case R.id.game:
			Intent intentg = new Intent(Dictionary.this,DangNhapGame.class);
			startActivity(intentg);
			return true;

		case R.id.grammar:
			Intent intent = new Intent(Dictionary.this,Select_Leson_Grammar.class);
			startActivity(intent);
			return true;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}


	//==================================menu cho bang 3 ngan tu ===============================================

	private void setkhiclickABC(int i, int j) {
		arrstrwordabc.removeAll(arrstrwordabc);
		arrloaiabc.removeAll(arrloaiabc);
		arrphatamabc.removeAll(arrphatamabc);
		arrstrnghiaabc.removeAll(arrstrnghiaabc);
		arrlistwordabc =new ArrayList<MyWord>();
		arrlistwordabc = db.gettutheoAC(i, j);
		setlistall();

	}


	private void setlistall() {

		//	setlisttheotenABC();
		//xoa cac thanh phan trong listview cu :D
		//	arrlistword = db.getallWord();


		for(int i=0;i<arrlistwordabc.size();i++)
		{
			System.out.println(""+i);
			arrstrwordabc.add(arrlistwordabc.get(i).getWord());
			arrstrnghiaabc.add(arrlistwordabc.get(i).getVidu());
			arrphatamabc.add(arrlistwordabc.get(i).getSound());
			arrloaiabc.add(arrlistwordabc.get(i).getType());

		}//cai dat lai de cho vao list view :D

		adpabc = new MyarrayaDapterABC(Dictionary.this, arrstrwordabc, arrstrnghiaabc, arrphatamabc, arrloaiabc);
		lvabc.setAdapter(adpabc);

		lvabc.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				word =arrlistwordabc.get(arg2);
				Intent intent= new Intent(Dictionary.this, ViewWord.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("word", word);
				intent.putExtra("data",bundle);
				startActivity(intent);
			}
		});
		lvabc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			/* (non-Javadoc)
			 * @see android.widget.AdapterView.OnItemLongClickListener#onItemLongClick(android.widget.AdapterView, android.view.View, int, long)
			 */
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				MyWord wordupdate = new MyWord();
				wordupdate.setId(arrlistwordabc.get(arg2).getId());
				wordupdate.setMean(arrlistwordabc.get(arg2).getMean());
				wordupdate.setVidu(arrlistwordabc.get(arg2).getVidu());
				wordupdate.setSound(arrlistwordabc.get(arg2).getSound());
				wordupdate.setImportan(arrlistwordabc.get(arg2).getImportan());
				wordupdate.setType(arrlistwordabc.get(arg2).getType());
				wordupdate.setWord(arrlistwordabc.get(arg2).getWord());
				wordupdate.setHistory(arrlistwordabc.get(arg2).getHistory());
				wordupdate.setLearn(1);
				db.updateWord(wordupdate);

				//su kien can su li sau khi update la da hoc!
				Toast.makeText(Dictionary.this, "Bạn đã đánh thuộc từ này", Toast.LENGTH_SHORT).show();
				arrlistwordtudahoc.add(wordupdate);
				adtdahoc.notifyDataSetChanged();
				tvthongtindahoc.setText("Tổng :3114"+"-"+"Đã Học :"+arrlistwordtudahoc.size());
				settablistdahoc();
				return true;
			}



		}); 


	}


}
