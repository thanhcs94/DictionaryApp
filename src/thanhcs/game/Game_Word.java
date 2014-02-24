package thanhcs.game;

import java.util.ArrayList;
import java.util.Random;

import thanhcs.dictionarydemo.Dictionary;
import thanhcs.dictionarydemo.R;
import thanhcs.dictionarydemo.R.layout;
import thanhcs.dictionarydemo.R.menu;
import thanhcs.dictionarydemo.database.DictionaryDataBase;
import thanhcs.dictionarydemo.database.MyWord;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game_Word extends Activity {
	String user;

	MediaPlayer mp;
	EditText edword;
	TextView tvnghia, tvdiem, tvkiluc, tvdapan, tvsai;
	Button btnext, btok, btdapan;
	DictionaryDataBase db;
	GameUserDatase gm;
	ArrayList<MyWord> arrword;
	int index , sai =0, dung =0, kttraloi=0;
	ImageView image, imagecheck;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layoutgameguesstu);
	final MediaPlayer mp1 = MediaPlayer.create(Game_Word.this, R.raw.cangthang);
		mp1.start();
		setinit();

		btok.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String word, dapan;
				kttraloi = kttraloi+1;
				if(kttraloi>1)
				{
					kttraloi=1;
					Toast.makeText(Game_Word.this, "Yêu cầu không click ok Linh Tinh"+"Trả lời rồi, bấm next đi", Toast.LENGTH_SHORT).show();
				}
				else
				{
					kttraloi=1;
					if(edword.getText().toString().equalsIgnoreCase(""))
					{
						Toast.makeText(Game_Word.this, "DM chưa nhập đáp án", Toast.LENGTH_SHORT).show();
						kttraloi=0;
					}
					else
					{

						word = edword.getText().toString();
						dapan = arrword.get(index).getWord().toString();
						if(word.equalsIgnoreCase(dapan))
						{
							mp1.stop();
							MediaPlayer mp = MediaPlayer.create(Game_Word.this, R.raw.confirm);
							mp.start();
							mp1.stop();
							imagecheck.setImageResource(R.drawable.dung);
							dung++;
							tvkiluc.setText("MAX: " +dung);
							tvdiem.setText("Điểm: "+ dung);
							Toast.makeText(Game_Word.this, "Đúng rồi đấy", Toast.LENGTH_SHORT).show();
						}
						else
						{
							mp1.stop();
							MediaPlayer mp = MediaPlayer.create(Game_Word.this, R.raw.bg);
							mp.start();
							imagecheck.setImageResource(R.drawable.sai);
							tvdapan.setText("Đáp Án:"+"\n"+dapan);
							sai++;
							tvsai.setText("Sai: "+sai);
							if(sai ==1)
							{
								image.setImageResource(R.drawable.sai01);
							}
							if(sai ==2)
							{
								image.setImageResource(R.drawable.sai03);
							}
							if(sai ==3)
							{
								image.setImageResource(R.drawable.sai04);
							}
							if(sai ==4)
							{
								image.setImageResource(R.drawable.sai05);
							}
							if(sai ==5)
							{
								image.setImageResource(R.drawable.sai06);
							}
							if(sai ==6)
							{
								image.setImageResource(R.drawable.sai07);
							}
							if(sai ==7)
							{
								image.setImageResource(R.drawable.sai08);
							}
							if(sai ==8)
							{
								image.setImageResource(R.drawable.sai09);
							}
							if(sai ==9)
							{
								image.setImageResource(R.drawable.sai10);
							}
							if(sai ==10)
							{
								image.setImageResource(R.drawable.sai12);
								gotodialog();
							}
							
								
						}

					}
				}
				
			}

		});

		btnext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(kttraloi==1)
				{
					if(edword.getText().toString().equalsIgnoreCase(""))
					{
						Toast.makeText(Game_Word.this, "Không được bỏ đâu. Làm đê.", Toast.LENGTH_SHORT).show();

					}
					else
					{
						imagecheck.setImageResource(R.drawable.ngdep);
						index = (int)(Math.random()*arrword.size());
						tvnghia.setText(index+" "+arrword.get(index).getVidu().toString());
						edword.setText("");
						tvdapan.setText("");
						kttraloi =0;
						final MediaPlayer mp1 = MediaPlayer.create(Game_Word.this, R.raw.cangthang);
						mp1.start();
					}

				}
				else
				{
					Toast.makeText(Game_Word.this, "Chưa trả lời.không next đâu.", Toast.LENGTH_SHORT).show();

				}
				
			}
		});



	}



	protected void gotodialog() {
		
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		
		AlertDialog.Builder builder = new AlertDialog.Builder(Game_Word.this);

		builder.setTitle("\t\t\tCHÚ DIE RỒI");

		builder.setMessage("\t\t\tR.I.P Chú !"+"\n"+"\t\tChú được "+ dung + "điểm !"+"\n"+"\t\t\tNGU VL");
		builder.setPositiveButton("Restart", new DialogInterface.OnClickListener() {

			@Override

			public void onClick(DialogInterface dialog, int which) {
				sai=0;dung=0;
				tvdiem.setText("Diem: ");
				tvsai.setText("Sai: ");
				tvdapan.setText("");
				edword.setText("");
				image.setImageResource(R.drawable.sai00);
				imagecheck.setImageResource(R.drawable.ngdep);
				index =0;
			//	mp1.stop();

			}

		});

		builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
			//	mp1.stop();
				finish();
			}
		});

		builder.create().show();
		}
		
	}

	private void setinit() {
		image = (ImageView)findViewById(R.id.imageView1);
		imagecheck = (ImageView)findViewById(R.id.imagecheck);
		btok =(Button)findViewById(R.id.btok);
		btdapan =(Button)findViewById(R.id.btdapan);
		btnext =(Button)findViewById(R.id.btnext);
		tvnghia =(TextView)findViewById(R.id.tvnghia);
		tvdiem =(TextView)findViewById(R.id.tvdiem);
		tvkiluc=(TextView)findViewById(R.id.tvkiluc);
		tvdapan=(TextView)findViewById(R.id.tvdapan);
		tvsai=(TextView)findViewById(R.id.tvsai);


		image.setImageResource(R.drawable.sai00);
		edword =(EditText)findViewById(R.id.edword);
		db = new DictionaryDataBase(this);
		gm = new GameUserDatase(this);
	
		arrword = new ArrayList<MyWord>();
		arrword = db.gettutheoAC(1, 221);
	
		index = (int)(Math.random()*arrword.size());
		tvnghia.setText(index+" "+arrword.get(index).getVidu().toString());
		
		Intent intent = getIntent();
		Bundle bunder = intent.getBundleExtra("data");
		user = bunder.getString("user");
		ArrayList<GameRecord> arr = new ArrayList<GameRecord>();
		arr =gm.getallUser();
		for(int i=0; i<arr.size();i++)
		{
			if(arr.get(i).getUsename().equalsIgnoreCase(user))
				tvkiluc.setText(("MAX :"+arr.get(i).getKiluctu()));
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game__word, menu);
		return true;
	}

}
