package de.fhswf.android;

import de.fhswf.android.R.layout;
import android.app.Activity;
import android.os.Bundle;

public class HagenActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.overviewlayout);
		
		RssParser rssParser = new RssParser();
		try {
			System.out.println("Try IT");
			rssParser.getLatestArticles("http://www-in.fh-swf.de/stwdo/rss.php/Ha-FH");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("FAIL");
		}
	}	
}
