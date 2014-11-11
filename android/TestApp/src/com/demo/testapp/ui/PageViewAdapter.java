/**
 * 
 */
package com.demo.testapp.ui;

import java.util.ArrayList;

import com.demo.testapp.R;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * @author yangsatiago
 *
 */
public class PageViewAdapter extends PagerAdapter {

	int[] imageids = new int[]
			{
				R.drawable.btn_orange_p, R.drawable.img_arrow_left,
				R.drawable.img_tab0_p, R.drawable.img_tab1_p,
				R.drawable.img_tab2_p, R.drawable.img_tab3_p
			};
	Context context;
	ArrayList<String> titles;
	
	public PageViewAdapter(Context context)
	{
		this.context = context;
		titles = new ArrayList<String>();
		titles.add("标题1");
		titles.add("标题2");
		titles.add("标题3");
		titles.add("标题4");
		titles.add("标题5");
		titles.add("标题6");
		
	}
	/* (non-Javadoc)
	 * @see android.support.v4.view.PagerAdapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imageids.length;
	}

	/* (non-Javadoc)
	 * @see android.support.v4.view.PagerAdapter#isViewFromObject(android.view.View, java.lang.Object)
	 */
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		ImageView image = new ImageView(context);
		
		image.setImageResource(imageids[position]);
		container.addView(image);
		return image;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		//super.destroyItem(container, position, object);
		//((ViewPager)container).removeView(view);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return titles.get(position).toString();
	}
}
