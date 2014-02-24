package dictionary.listword;
import java.util.ArrayList;

import thanhcs.dictionarydemo.R;
import thanhcs.dictionarydemo.database.MyWord;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MyarrayAdapter extends ArrayAdapter<String>{
	
	public ArrayList<String> tu;
	public ArrayList<String> nghia;
	public ArrayList<String> phatam;
	public ArrayList<String> loaitu;
//	Integer []image;
	public Activity context;
	ArrayList<MyWord>myword;
	public LayoutInflater inflater;

	public MyarrayAdapter(Activity context,
			ArrayList<String>  tu,
			ArrayList<String> nghia,
			ArrayList<String>  phatam,
			ArrayList<String>  loaitu) {
		super(context, R.layout.listtitle, tu);
		this.context = context;
		this.tu = tu;
		this.nghia = nghia;
		this.phatam=phatam;
		this.loaitu=loaitu;

	    this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	
	public static class ViewHolder
	{
	//	ImageView imgViewLogo;
		TextView tvtu, tvphatam;
		TextView tvnghia, tvloaitu;
	//	ImageButton img;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ViewHolder holder;
		if(convertView==null)
		{
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.listtitle, null);

			//holder.imgViewLogo = (ImageView) convertView.findViewById(R.id.icon);
			holder.tvtu = (TextView) convertView.findViewById(R.id.firstline);
			holder.tvloaitu = (TextView) convertView.findViewById(R.id.tvloaitu);
			holder.tvnghia = (TextView) convertView.findViewById(R.id.secondLine);
			holder.tvphatam =(TextView) convertView.findViewById(R.id.tvam);
			//holder.img =(ImageButton)convertView.findViewById(R.id.imageButton1);

			convertView.setTag(holder);
		}
		else
			holder=(ViewHolder)convertView.getTag();

//		holder.imgViewLogo.setImageResource(R.drawable.dontknow);
//		holder.imgViewLogo.setImageResource(image[position]);
		
		holder.tvtu.setText(tu.get(position).toString());
		holder.tvloaitu.setText(loaitu.get(position).toString());
		holder.tvnghia.setText(nghia.get(position));
		holder.tvphatam.setText(phatam.get(position));
		
//		holder.txtViewTitle.setText(myword.get(position).getTu().toString());
//		holder.txtViewDescription.setText(myword.get(position).getNghia().toString());

		
		return convertView;
	}

}
