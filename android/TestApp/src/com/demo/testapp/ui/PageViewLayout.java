/**
 * 
 */
package com.demo.testapp.ui;

import java.util.ArrayList;
import java.util.List;

import com.demo.testapp.R;

import android.content.Context;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * @author yangsatiago
 *
 */
public class PageViewLayout extends FrameLayout {

	Context context;
	ViewPager pagerview;
	PagerTitleStrip pagetitle;
    List<String> titles;
	List<ImageView> indicatorList;
	ViewGroup viewPoints;
    
	final int IMAGE_SELECTED = R.drawable.img_indicator_p;
	final int IMAGE_NOT_SELECTED = R.drawable.img_indicator;
	
	public PageViewLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context = context;
		LayoutInflater.from(context).inflate(R.layout.pageview_indicator, this, true);
		
		initPageView();
		
		initIndicator(6);
	}
	
	private void initIndicator(int size) {
		// TODO Auto-generated method stub
		viewPoints = (ViewGroup) findViewById(R.id.vp_include_indicator);
		
		indicatorList = new ArrayList<ImageView>();
		
		for (int i = 0; i < size; i++) {
			ImageView image = new ImageView(context);
			
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(20, 20);
			lp.setMargins(10, 0, 10, 0);
			
			image.setLayoutParams(lp);
			
			indicatorList.add(image);
			
			if (i == 0) 
			{
				indicatorList.get(i).setBackgroundResource(IMAGE_SELECTED);
			}else
			{
				indicatorList.get(i).setBackgroundResource(IMAGE_NOT_SELECTED);
			}
			
			viewPoints.addView(image);
		}
	}

	private void initPageView() {
		// TODO Auto-generated method stub
		pagerview = (ViewPager) findViewById(R.id.vp_include_advert);
		pagetitle = (PagerTitleStrip) findViewById(R.id.page_title);
		
		PageViewAdapter adapter = new PageViewAdapter(context);
		
		pagerview.setAdapter(adapter);
		
		pagerview.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < indicatorList.size(); i++) {
					if (i == arg0) {
						indicatorList.get(i).setBackgroundResource(
								IMAGE_SELECTED);
					} else {
						indicatorList.get(i).setBackgroundResource(
								IMAGE_NOT_SELECTED);
					}
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	public PageViewLayout(Context context, AttributeSet attrs) {
		this(context, null, 0);
		// TODO Auto-generated constructor stub
	}
	
	public PageViewLayout(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}
	
	

	
}
