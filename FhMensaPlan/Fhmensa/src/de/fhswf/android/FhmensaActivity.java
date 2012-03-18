package de.fhswf.android;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class FhmensaActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

       

        // Do the same for the other tabs
        intent = new Intent().setClass(this, IserlohnActivity.class);
        spec = tabHost.newTabSpec("iserlohn").setIndicator(res.getString(R.string.iserlohn),
                          res.getDrawable(R.drawable.ic_tab_artists_white))
                      .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, HagenActivity.class);
        spec = tabHost.newTabSpec("hagen").setIndicator(res.getString(R.string.hagen),
                          res.getDrawable(R.drawable.ic_tab_artists_white))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, MeschedeActivity.class);
        spec = tabHost.newTabSpec("meschede").setIndicator(res.getString(R.string.meschede),
                          res.getDrawable(R.drawable.ic_tab_artists_white))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, SoestActivity.class);
        spec = tabHost.newTabSpec("soest").setIndicator(res.getString(R.string.soest),
                          res.getDrawable(R.drawable.ic_tab_artists_white))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, LuedenscheidActivity.class);
        spec = tabHost.newTabSpec("luedenscheid").setIndicator(res.getString(R.string.luedenscheid),
                          res.getDrawable(R.drawable.ic_tab_artists_white))
                      .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(1);
        
    }

    
    public void getRss(){

        RssParser rssParser = new RssParser();
        String result = null;
		try {
			rssParser.getLatestArticles("http://www-in.fh-swf.de/stwdo/rss.php/Ha-FH");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}