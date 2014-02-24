package thanhcs.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import thanhcs.dictionarydemo.R;
import thanhcs.dictionarydemo.R.layout;
import thanhcs.dictionarydemo.R.menu;
import thanhcs.dictionarydemo.database.DictionaryDataBase;
import thanhcs.dictionarydemo.database.MyWord;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Game_Mean extends Activity implements OnClickListener{

	Button next, check;
	TextView tvtu;
	RadioGroup radiogr;
	RadioButton raA;
	RadioButton raB;
	RadioButton raC;
	RadioButton raD;
	DictionaryDataBase db;
	ArrayList<MyWord> arrword;
	int index ;
	int [] arrrannumber = new int[3];
	String ketqua;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game__mean);
		setinit();




	}

	private void setinit() {
		next =(Button)findViewById(R.id.btnext);
		check =(Button)findViewById(R.id.btcheck);
		next.setOnClickListener(this);
		check.setOnClickListener(this);
		
		tvtu =(TextView)findViewById(R.id.tvtu);

		radiogr =(RadioGroup)findViewById(R.id.radioGroup1);

		raA =(RadioButton)findViewById(R.id.raA);
		raA.setOnClickListener(this);
		raB =(RadioButton)findViewById(R.id.raB);
		raB.setOnClickListener(this);
		raC =(RadioButton)findViewById(R.id.raC);
		raC.setOnClickListener(this);
		raD =(RadioButton)findViewById(R.id.raD);
		raD.setOnClickListener(this);

		db = new DictionaryDataBase(this);
		arrword = new ArrayList<MyWord>();
	//	arrword = db.getallWord();
		
		

		taosoramdom();


	}

	private void taosoramdom() {
		
		raA.setChecked(false);
		raB.setChecked(false);
		raC.setChecked(false);
		raD.setChecked(false);
		int so =(int)(Math.random()*5);
		if(so==0)
			so=so+3;
		
		index = (int)(Math.random()*arrword.size());
		tvtu.setText(index+"-"+so+ "\n"+arrword.get(index).getWord().toString());
		for(int i =0;i<3;i++)
		{
			arrrannumber[i] = (int)(Math.random()*arrword.size());

		}
		
	
		
		if(so==1)
		{
			raA.setText(arrword.get(index).getMean().toString());
			raB.setText(arrword.get(arrrannumber[2]).getMean().toString());
			raC.setText(arrword.get(arrrannumber[0]).getMean().toString());
			raD.setText(arrword.get(arrrannumber[1]).getMean().toString());
		}
		if(so==2)
		{
			raA.setText(arrword.get(arrrannumber[2]).getMean().toString());
			raB.setText(arrword.get(index).getMean().toString());
			raC.setText(arrword.get(arrrannumber[0]).getMean().toString());
			raD.setText(arrword.get(arrrannumber[1]).getMean().toString());
		}
		if(so==3)
		{
			raA.setText(arrword.get(arrrannumber[2]).getMean().toString());
			raB.setText(arrword.get(arrrannumber[0]).getMean().toString());
			raC.setText(arrword.get(index).getMean().toString());
			raD.setText(arrword.get(arrrannumber[1]).getMean().toString());
		}
		if(so==4)
		{
			raA.setText(arrword.get(arrrannumber[2]).getMean().toString());
			raB.setText(arrword.get(arrrannumber[0]).getMean().toString());
			raC.setText(arrword.get(arrrannumber[1]).getMean().toString());
			raD.setText(arrword.get(index).getMean().toString());
		}
		
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game__mean, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.raA:
		//	Toast.makeText(Game_Mean.this, "raA", Toast.LENGTH_SHORT).show();
			ketqua = raA.getText().toString();
			break;
		case R.id.raB:
		//	Toast.makeText(Game_Mean.this, "raB", Toast.LENGTH_SHORT).show();
			ketqua = raB.getText().toString();
			break;
		case R.id.raC:
			//Toast.makeText(Game_Mean.this, "raC", Toast.LENGTH_SHORT).show();
			ketqua = raC.getText().toString();
			break;
		case R.id.raD:
			//Toast.makeText(Game_Mean.this, "raD", Toast.LENGTH_SHORT).show();
			ketqua = raD.getText().toString();
			break;
			
		case R.id.btnext:
			taosoramdom();
			break;
		case R.id.btcheck:
			check();
			break;

		default:
			break;
		}

	}

	private void check() {
		String dapan= arrword.get(index).getMean().toString();
		if(ketqua.equalsIgnoreCase(dapan))
		{
			Toast.makeText(Game_Mean.this, "Correct", Toast.LENGTH_SHORT).show();
		}
		else
		{
			Toast.makeText(Game_Mean.this, "Incorrect."+"\n"+"Type again", Toast.LENGTH_SHORT).show();
		}
		
	}

}
