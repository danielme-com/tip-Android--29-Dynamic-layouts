package com.danielme.tipsandroid.dynamiclayouts;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;



/**
 * 
 * @author danielme.com
 *
 */
public class MainActivity extends Activity 
{	
	
	private ViewGroup layout;
	private ScrollView scrollView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
        layout = (ViewGroup) findViewById(R.id.content);    
        scrollView = (ScrollView) findViewById(R.id.scrollView);  
	}	
	
	public void addRight(View button)
	{
		addChild(true);
	}
	 
	public void addLeft(View button)
	{
		addChild(false);
	}
	
	private void addChild(boolean right)
	{
		LayoutInflater inflater = LayoutInflater.from(this);
		int id = R.layout.layout_left;
		if (right)
		{
			id = R.layout.layout_right;
		}
		
		RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(id, null, false);

		TextView textView = (TextView) relativeLayout.findViewById(R.id.textViewDate);
		textView.setText(String.valueOf(System.currentTimeMillis()));
		
		//layout params
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		if (right)
		{
			params.gravity = Gravity.RIGHT;
		}
		params.topMargin = 15;
		relativeLayout.setPadding(5, 3, 5, 3);	
		relativeLayout.setLayoutParams(params);
		///////	
		
		layout.addView(relativeLayout);
		
		//scroll to last element
		//http://stackoverflow.com/questions/6438061/can-i-scroll-a-scrollview-programmatically-in-android
		scrollView.post(new Runnable() { 
			public void run() { 
			        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
			        } 
				});
		///////
	}
	
}