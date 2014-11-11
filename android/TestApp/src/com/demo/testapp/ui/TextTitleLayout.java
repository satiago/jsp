/**
 * 
 */
package com.demo.testapp.ui;

import com.demo.testapp.R;
import com.demo.testapp.app.Constant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author yangsatiago
 *
 */
public class TextTitleLayout extends RelativeLayout {

	Context context;
	Button btn_left;
	TextView textView;
	
	public TextTitleLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context = context;
		
		LayoutInflater.from(context).inflate(R.layout.include_title_bar_text, this, true);
		
		btn_left = (Button) findViewById(R.id.btn_left);
		textView = (TextView) findViewById(R.id.tv_include_title);
		initListener();
	}
	
	public void initListener()
	{
		btn_left.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.putExtra(Constant.KEY_CITY_NAME, "北京");

				((Activity) context).setResult(Activity.RESULT_OK, i);
				((Activity) context).finish();
			}
		});
	}
	
	public TextTitleLayout(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}
	
	public TextTitleLayout(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}
	
	public void setTitleText(CharSequence text)
	{
		textView.setText(text);
	}

	
}
