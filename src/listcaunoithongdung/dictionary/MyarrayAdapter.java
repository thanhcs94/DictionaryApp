package listcaunoithongdung.dictionary;
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
	
	public ArrayList<String> ndanh;
	public ArrayList<String> ndviet;
//	public ArrayList<String> phatam;
//	Integer []image;
	public Activity context;
	ArrayList<MyWord>myword;
	public LayoutInflater inflater;

	public MyarrayAdapter(Activity context,
			ArrayList<String>  title,
			ArrayList<String>  description) {
		super(context, R.layout.listcaunoithongdung, title);
		this.context = context;
		this.ndanh = title;
		this.ndviet = description;
		

	    this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	
	public static class ViewHolder
	{
		ImageView imgViewLogo;
		TextView txtViewTitle;// tvphatam;
		TextView txtViewDescription;
	//	ImageButton img;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ViewHolder holder;
		if(convertView==null)
		{
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.listcaunoithongdung, null);

			holder.imgViewLogo = (ImageView) convertView.findViewById(R.id.icon);
			holder.txtViewTitle = (TextView) convertView.findViewById(R.id.firstline);
			holder.txtViewDescription = (TextView) convertView.findViewById(R.id.secondLine);
		//	holder.tvphatam =(TextView) convertView.findViewById(R.id.tvam);
			//holder.img =(ImageButton)convertView.findViewById(R.id.imageButton1);

			convertView.setTag(holder);
		}
		else
			holder=(ViewHolder)convertView.getTag();

		holder.imgViewLogo.setImageResource(R.drawable.monster);
//		holder.imgViewLogo.setImageResource(image[position]);
		
		holder.txtViewTitle.setText(ndanh.get(position).toString());
		holder.txtViewDescription.setText(ndviet.get(position));
		
//		holder.txtViewTitle.setText(myword.get(position).getTu().toString());
//		holder.txtViewDescription.setText(myword.get(position).getNghia().toString());

		
		return convertView;
	}

}
