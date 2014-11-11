/**
 * 
 */
package com.demo.testapp.ui;

import com.demo.testapp.R;
import com.demo.testapp.util.TestIntentUtil;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

/**
 * @author yangsatiago
 *
 */
public class FalseSearchTitleLayout extends RelativeLayout {

	Button btnLeft;
	ImageButton btnRight;
	RelativeLayout searchLayout;
	Context context;
	
	public FalseSearchTitleLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context = context;
		LayoutInflater.from(context).inflate(R.layout.include_title_bar_myedit_false, this, true);
		
		btnLeft = (Button) findViewById(R.id.btn_left);
		btnRight = (ImageButton) findViewById(R.id.btn_right);
		searchLayout = (RelativeLayout) findViewById(R.id.rl_include_myedit_edit);
		initListener();
		Log.i("yang", "c3 called");
		
	}
	
	public void initListener()
	{
		btnLeft.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TestIntentUtil.toSelectCity(context);
			}
		});
	}

	public FalseSearchTitleLayout(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		Log.i("yang", "c2 called");
		// TODO Auto-generated constructor stub
	}

	public FalseSearchTitleLayout(Context context) {
		this(context, null);
		Log.i("yang", "c1 called");
		// TODO Auto-generated constructor stub
	}
	
	public void setCity(CharSequence text)
	{
		btnLeft.setText(text);
	}

}
