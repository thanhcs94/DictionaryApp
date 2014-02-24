package thanhcs.dictionarydemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;


import listcaunoithongdung.dictionary.List1000CauNoiThongDung;
import listcaunoithongdung.dictionary.MyarrayAdapterCNTD;

import databasecaunoithongdung.dictionary.Caunoithongdung;
import databasecaunoithongdung.dictionary.CaunoithongdungDataBase;
import dictionary.listword.MyarrayAdapter;
import dictionary.listword.ViewWord;



import thanhcs.dictionarydemo.database.DictionaryDataBase;
import thanhcs.dictionarydemo.database.MyWord;
import thanhcs.dictionarydemo.database.Sapxeptheoabc;
import thanhcs.game.DangNhapGame;
import thanhcs.game.Game_Mean;
import thanhcs.game.Game_Word;
import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Dictionary extends Activity{

	CaunoithongdungDataBase dbcntd;
	ArrayList<Caunoithongdung> arrcaunoitd;
	//=============================
	TabHost tabhost;
	DictionaryDataBase db;
	MyWord word;
	int index =0, size;
	ArrayList<MyWord> arrlistword;
	MyarrayAdapter adp;
	//==============================
	
	//===tab list word
	 ArrayList<String> arrstrword,arrstrnghia, arrphatam, arrloai;
	ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dictionary);
		db = new DictionaryDataBase(this);
				
		setinit();
     //   settabshowcaunoithongdung();
		settablistWord();
		//settabfinWord();
		settabgame();
	}

	//============================================================Tab CAU NOI THONG DUNG=====================================
	private void settabshowcaunoithongdung() {

		MyarrayAdapterCNTD adplistcntd;
		ListView lvlistcntd;
		ArrayList<String> ndcntdanh;
		ArrayList<String> ndcntdviet;
		Button btloadall, btloaddahoc;

		btloadall = (Button)findViewById(R.id.btloadhet);
		btloaddahoc = (Button)findViewById(R.id.btloaddahoc);
		dbcntd = new  CaunoithongdungDataBase(this);
		arrcaunoitd = new ArrayList<Caunoithongdung>();
		ndcntdviet = new ArrayList<String>();
		ndcntdanh = new ArrayList<String>();
		arrcaunoitd = dbcntd.getloaicntd(3); //1-A, 2 -B get tung loai cau theo stt1, 2, 3, 4;
		lvlistcntd = (ListView)findViewById(R.id.lv);
		for(int i=0;i<arrcaunoitd.size();i++)
		{
			System.out.println(arrcaunoitd.get(i));
			ndcntdanh.add(arrcaunoitd.get(i).getNdanh());
			ndcntdviet.add(arrcaunoitd.get(i).getNdviet());
		}

		adplistcntd = new MyarrayAdapterCNTD(this, ndcntdanh, ndcntdviet);
		lvlistcntd.setAdapter(adplistcntd);
		lvlistcntd.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			/* (non-Javadoc)
			 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
			 */
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Toast.makeText(Dictionary.this, "Danh Dau Da Hoc", Toast.LENGTH_SHORT).show();				
			}		
		});	
		btloadall.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		btloaddahoc.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});			
	}

	private void settabgame() {
		Button btgametu =(Button)findViewById(R.id.btgametu);
		Button btgamenghia =(Button)findViewById(R.id.btgamenghia);
		btgametu.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
//			if(arrdahoc.size()>=5)
//			{
				Intent intent = new Intent(Dictionary.this, DangNhapGame.class);
				startActivity(intent);
//			}
//			else
//			{
//				Toast.makeText(Dictionary.this,"Bạn Cần Học Ít Nhất 5 Từ Để Chơi Game Này",Toast.LENGTH_SHORT).show();
//			}
//				
//
		}
		});

//		btgamenghia.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				ArrayList<MyWord>arrdahoc =db.gettudahoc();
//				if(arrdahoc.size()>=5)
//				{
//				Intent intent = new Intent(Dictionary.this, Game_Mean.class);
//				startActivity(intent);
//				}
//				else
//				{
//					Toast.makeText(Dictionary.this,"Bạn Cần Học Ít Nhất 5 Từ Để Chơi Game Này",Toast.LENGTH_SHORT).show();
//				}
//					
//	
//			}
//		});

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
		ArrayList<MyWord> arrdahoc, arrchuahoc;
		arrdahoc = new ArrayList<MyWord>(); 
		arrchuahoc = new ArrayList<MyWord>();
		final MyWord []wordarr;
		Button btgetall, btgetdahoc;

		db = new DictionaryDataBase(this);
	    arrstrword =new ArrayList<String>();
		arrstrnghia =new ArrayList<String>();
		arrphatam =new ArrayList<String>();
		arrloai =new ArrayList<String>();
		
		
		
		size = arrlistword.size();	
		lv =(ListView)findViewById(R.id.lvword);
		setlist();
		
//		btgetall.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
////				arrlistword = db.getallWord();
////				arrstrword.removeAll(arrstrword);
////				arrloai.removeAll(arrloai);
////				arrphatam.removeAll(arrphatam);
////				arrstrnghia.removeAll(arrstrnghia);
//				setlist();
//
//			}
//
//			
//		});

//		btgetdahoc.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				arrlistword = db.gettudahoc();
//				arrstrword.removeAll(arrstrword);
//				arrloai.removeAll(arrloai);
//				arrphatam.removeAll(arrphatam);
//				arrstrnghia.removeAll(arrstrnghia);
//				setlist();
//				for(int i=0;i<arrlistword.size();i++)
//				{
//					System.out.println(""+i);
//					arrstrword.add(arrlistword.get(i).getWord());
//					arrstrnghia.add(arrlistword.get(i).getMean());
//					arrphatam.add(arrlistword.get(i).getSound());
//					arrloai.add(arrlistword.get(i).getType());
//					
//				}
//				
//				ArrayAdapter<String> adpsp = new ArrayAdapter<String>(Dictionary.this, android.R.layout.simple_list_item_1,arrstrword);
//				lv.setAdapter(adpsp);
//				
//			}
//		});


		

	}

	private void setlist() {

		//	Collections.sort(arrlistword, new Sapxeptheoabc());
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
//		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//
//			@Override
//			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
//					int arg2, long arg3) {
//				Toast.makeText(Dictionary.this, "OK roi! Ban da hoc xong tu nay", Toast.LENGTH_SHORT).show();
//
//				return false;
//			}
//
//
//
//		});


		
	}

	//================================================Tab FIND WORD ==========================================================
	private void settabfinWord() {

		final Button btfind;
		final TextView tvresult, tvphatam, tvvidu3;
		final EditText edword;

		btfind =(Button)findViewById(R.id.btfind);
		tvresult =(TextView)findViewById(R.id.tvketquafind);
		tvphatam =(TextView)findViewById(R.id.tvphatamfind);
		tvvidu3 =(TextView)findViewById(R.id.tvvidufind);
		edword =(EditText)findViewById(R.id.edfindword);
		arrlistword = new ArrayList<MyWord>();
		db = new DictionaryDataBase(this);
	//	arrlistword = db.getallWord();


		btfind.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String text = edword.getText().toString();
				MyWord wordlist =dictionary_findword(text);
				if(wordlist!=null)
				{
					tvresult.setText(wordlist.getMean().toString());
					tvphatam.setText(wordlist.getSound().toString()+ "   Type: "+wordlist.getType().toString());
					tvvidu3.setText(wordlist.getVidu().toString());
				}
				else
				{
					tvresult.setText("Not Found");
					tvphatam.setText("");
					tvvidu3.setText("");
				}
			}

			private MyWord dictionary_findword(String text) {

				for(MyWord a : arrlistword)
				{
					if(a.getWord().equalsIgnoreCase(text))
						return a;
				}
				return null;
			}
		});




	}

	//=================================================Creat TabHost============================================================
	private void setinit() {
		tabhost = (TabHost)findViewById(R.id.tabhost);
		tabhost.setup();
		TabSpec spec;
		spec = tabhost.newTabSpec("List");
		spec.setIndicator("List",getResources().getDrawable(R.drawable.wink));
		spec.setContent(R.id.listWord);
		tabhost.addTab(spec);

		spec = tabhost.newTabSpec("Find");
		spec.setIndicator("Find",getResources().getDrawable(R.drawable.monster));
		spec.setContent(R.id.findWord);
		tabhost.addTab(spec);



		spec = tabhost.newTabSpec("List CNTD");
		spec.setIndicator("List CNTD",getResources().getDrawable(R.drawable.cantbelieve));
		spec.setContent(R.id.caunoitd);
		tabhost.addTab(spec);

		spec = tabhost.newTabSpec("GAME");
		spec.setIndicator("GAME",getResources().getDrawable(R.drawable.wink));
		spec.setContent(R.id.gameWord);
		tabhost.addTab(spec);
		
		
	//	ArrayList<MyWord> arr = new ArrayList<MyWord>();
//		db.addword(new MyWord(2,"providesd",
//				"/provide/", 
//				"(vi.)",
//				"blabla", 
//				"ubauba",
//				0,
//				0,
//				""));
	//	ArrayList<MyWord> a = db.getallWord();
//		MyWord a = db.getWord(3);
	//	System.out.println(a.get(3).toString());
		
	//	db.updatedahocword(20);
	}


	//======================================================setlist word=================================================
	
	

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
			        case R.id.action_location_found:
			        	setlisttheotenABC();
			         //  LocationFound();
			            return true;
//			        case R.id.action_refresh:
//			            // refresh
//			            return true;
		case R.id.getalllist:
				setlisttheotenABC();
			return true;
		case R.id.gettudahoc:
				setlistdahoc();
			return true;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	
	//==================================menu cho bang 3 ngan tu ===============================================
	private void setlistdahoc() {
		
//        arrlistword = db.gettudahoc();
//		adp = new MyarrayAdapter(Dictionary.this, arrstrword, arrstrnghia, arrphatam, arrloai);
//		lv.setAdapter(adp);
//
//		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//					long arg3) {
//				word =arrlistword.get(arg2);
//				Intent intent= new Intent(Dictionary.this, ViewWord.class);
//				Bundle bundle = new Bundle();
//				bundle.putSerializable("word", word);
//				intent.putExtra("data",bundle);
//				startActivity(intent);
//			}
//		});
	}

	private void setlistall() {
		
	//	setlisttheotenABC();
		//xoa cac thanh phan trong listview cu :D
	//	arrlistword = db.getallWord();
		
	
		for(int i=0;i<arrlistword.size();i++)
			{
				System.out.println(""+i);
				arrstrword.add(arrlistword.get(i).getWord());
				arrstrnghia.add(arrlistword.get(i).getMean());
				arrphatam.add(arrlistword.get(i).getSound());
				arrloai.add(arrlistword.get(i).getType());
				
			}//cai dat lai de cho vao list view :D
		
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
		
		
	}

	private void setlisttheotenABC() {
	
		final String []a ={"A", "B", "C", "D", "E",
				"F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O",
				"P", "Q", "R", "S", "T",
				"W", "U", "V", "W", "Y",
				"Z"
		
		};
		
		ArrayAdapter<String> adp = new ArrayAdapter<String>(Dictionary.this, android.R.layout.simple_list_item_1,
				a);
		lv.setAdapter(adp);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			/* (non-Javadoc)
			 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
			 */
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
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
				//	setkhiclickABC(371, 691);
					
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

			
		
		});
		
	}
	private void setkhiclickABC(int i, int j) {
		arrstrword.removeAll(arrstrword);
		arrloai.removeAll(arrloai);
		arrphatam.removeAll(arrphatam);
		arrstrnghia.removeAll(arrstrnghia);
		arrlistword =new ArrayList<MyWord>();
		arrlistword = db.gettutheoAC(i, j);
		setlistall();
		
	}


}
