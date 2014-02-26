package thanhcs.lesson_grammar;

import thanhcs.dictionarydemo.R;
import thanhcs.dictionarydemo.R.id;
import thanhcs.dictionarydemo.R.layout;
import thanhcs.dictionarydemo.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.webkit.WebView;

public class ViewGrammar extends Activity {

	WebView mywebview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_grammar);
		mywebview = (WebView)findViewById(R.id.webView1);
		Intent intent =getIntent();
		Bundle bunde = new Bundle();
		bunde = intent.getBundleExtra("data");
		int so = bunde.getInt("so");
		
		mywebview.loadUrl("file:///android_asset/"+so+".htm");
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_grammar, menu);
		return true;
	}

}
