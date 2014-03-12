package thanhcs.game;

import java.util.ArrayList;


import thanhcs.dictionarydemo.R;
import thanhcs.dictionarydemo.database.DictionaryDataBase;
import thanhcs.dictionarydemo.database.MyWord;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DangNhapGame extends Activity {


	DictionaryDataBase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabgame);
		Button btgametu =(Button)findViewById(R.id.btgametu);
		Button btgamenghia =(Button)findViewById(R.id.btgamenghia);
		db = new DictionaryDataBase(this);

		btgamenghia.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ArrayList<MyWord>arrdahoc =db.gettudahoc();
				
				Intent intent = new Intent(DangNhapGame.this, Game_Mean.class);
				startActivity(intent);
				
					
	
			}
		});
		
		
		

		btgametu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ArrayList<MyWord>arrdahoc =db.gettudahoc();
				
				Intent intent = new Intent(DangNhapGame.this, Game_Word.class);
				startActivity(intent);
				
					
	
			}
		});
}



			






	//
	//		btdangnhap =(Button)findViewById(R.id.btdangnhap);
	//		btthoat =(Button)findViewById(R.id.btboqua);
	//		eduser =(EditText)findViewById(R.id.edusername);
	//
	//
	//		btdangnhap.setOnClickListener(new View.OnClickListener() {
	//
	//			@Override
	//			public void onClick(View v) {
	//				
	//				String user = eduser.getText().toString();
	//				Intent intent = new Intent(DangNhapGame.this, Game_Word.class);
	//				Bundle bunde = new Bundle();
	//				bunde.putString("user",user );
	//				intent.putExtra("data", bunde);
	//				startActivity(intent);
	//
	//			}
	//		});


	//		btthoat.setOnClickListener(new View.OnClickListener() {
	//
	//			@Override
	//			public void onClick(View v) {
	//				finish();
	//
	//			}
	//		});
	//


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dang_nhap_game, menu);
		return true;
	}

}
