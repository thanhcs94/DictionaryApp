package dictionary.listword;
import java.util.ArrayList;
import java.util.Locale;

import thanhcs.dictionarydemo.Dictionary;
import thanhcs.dictionarydemo.R;
import thanhcs.dictionarydemo.database.MyWord;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MyarrayAdapter extends ArrayAdapter<String>  implements TextToSpeech.OnInitListener {

	public ArrayList<String> tu;
	public ArrayList<String> nghia;
	public ArrayList<String> phatam;
	public ArrayList<String> loaitu;
	public ArrayList<String> meanexplain;
	//	Integer []image;
	public Activity context;
	ArrayList<MyWord>myword;
	public LayoutInflater inflater;
	public TextToSpeech tts;
	String tvexplain;
	int i=1;
	int vitri;
	public MyarrayAdapter(Activity context,
			ArrayList<String>  tu,
			ArrayList<String> nghia,
			ArrayList<String>  phatam,
			ArrayList<String>  loaitu,
			ArrayList<String>  meanexplain) {
		super(context, R.layout.listtitle, tu);
		this.context = context;
		this.tu = tu;
		this.nghia = nghia;
		this.phatam=phatam;
		this.loaitu=loaitu;
		this.meanexplain =meanexplain;

		this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}


	public static class ViewHolder
	{

		//	ImageView imgViewLogo;
		TextView tvtu, tvphatam;
		TextView tvnghia, tvloaitu, tvexplain;
		//	ImageButton img;
		

	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		vitri =position;
		ViewHolder holder;
		if(convertView==null)
		{
			
			tts = new TextToSpeech(context,this);	
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.listtitle, null);

			ImageButton phatam=(ImageButton) convertView.findViewById(R.id.imgbtspeak);
			final ImageButton detail=(ImageButton) convertView.findViewById(R.id.imgdetail);
			final TextView tvexplain =(TextView)convertView.findViewById(R.id.tvexplain);
			tvexplain.setBackgroundColor(Color.parseColor("#ffffff"));
			detail.setImageResource(R.drawable.sai);
			final String phata[]= new String[this.phatam.size()];
			for(int i=0;i<this.phatam.size();i++)
			{
				phata[i] = this.phatam.get(i).toString();
			}
			
			
			phatam.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(context, "Thanh "+position, Toast.LENGTH_SHORT).show();
			//		String text =tu.get(position).toString();
					String text2 =phata[position].toString();
					tts.speak(text2, TextToSpeech.QUEUE_FLUSH, null);
				}
			});

			detail.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					for(int i=0;i< tu.size();i++)
					{
						if(tvexplain.getText().toString().equalsIgnoreCase(""))
						{
							tvexplain.setText("");
						}
					}
					if(tvexplain.getText().toString().equalsIgnoreCase(""))
					{
						Toast.makeText(context, "tao text", Toast.LENGTH_SHORT).show();
						detail.setImageResource(R.drawable.dung);
						tvexplain.setBackgroundColor(Color.parseColor("#dfdfdf"));
						tvexplain.setText(meanexplain.get(position).toString());
					}
					else
					{
						Toast.makeText(context, "xoa text", Toast.LENGTH_SHORT).show();
						detail.setImageResource(R.drawable.sai);
						tvexplain.setBackgroundColor(Color.parseColor("#ffffff"));
						tvexplain.setText("");
					}
					
					
				}
			});



			holder.tvtu = (TextView) convertView.findViewById(R.id.firstline);
			holder.tvloaitu = (TextView) convertView.findViewById(R.id.tvloaitu);
			holder.tvnghia = (TextView) convertView.findViewById(R.id.secondLine);
			holder.tvphatam =(TextView) convertView.findViewById(R.id.tvam);
			
			//holder.img =(ImageButton)convertView.findViewById(R.id.imageButton1);

			convertView.setTag(holder);
		}
		else
			holder=(ViewHolder)convertView.getTag();

		holder.tvtu.setText(tu.get(position).toString()+position);
		holder.tvloaitu.setText(loaitu.get(position).toString());
		holder.tvnghia.setText(nghia.get(position));
		holder.tvphatam.setText(phatam.get(position));	
		return convertView;
	}

	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {

			int result = tts.setLanguage(Locale.US);

			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("TTS", "This Language is not supported");
			} else {

			}

		} else {
			Log.e("TTS", "Initilization Failed!");
		}



	}

}
