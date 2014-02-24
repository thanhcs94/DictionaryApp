package thanhcs.game;

import thanhcs.dictionarydemo.R;
import thanhcs.dictionarydemo.R.layout;
import thanhcs.dictionarydemo.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DangNhapGame extends Activity {

	Button btdangnhap, btthoat;
	EditText eduser;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dang_nhap_game);

		btdangnhap =(Button)findViewById(R.id.btdangnhap);
		btthoat =(Button)findViewById(R.id.btboqua);
		eduser =(EditText)findViewById(R.id.edusername);


		btdangnhap.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				String user = eduser.getText().toString();
				Intent intent = new Intent(DangNhapGame.this, Game_Word.class);
				Bundle bunde = new Bundle();
				bunde.putString("user",user );
				intent.putExtra("data", bunde);
				startActivity(intent);

			}
		});


		btthoat.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();

			}
		});



	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dang_nhap_game, menu);
		return true;
	}

}
