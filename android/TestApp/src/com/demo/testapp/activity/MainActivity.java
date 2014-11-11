package com.demo.testapp.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import com.demo.testapp.R;
import com.demo.testapp.R.id;
import com.demo.testapp.R.layout;
import com.demo.testapp.R.menu;
import com.demo.testapp.app.Constant;
import com.demo.testapp.fragment.FriendFragment;
import com.demo.testapp.fragment.GoodsFragment;
import com.demo.testapp.fragment.HomeFragment;
import com.demo.testapp.fragment.InfoFragment;
import com.demo.testapp.fragment.ReportFragment;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;


public class MainActivity extends FragmentActivity {

	View[] tab;
	int[] tab_res;

	Fragment[] frag;
	Class<?> cla[] = new Class<?>[] {HomeFragment.class, InfoFragment.class, GoodsFragment.class, FriendFragment.class,
			ReportFragment.class};

	Context context = this;
	int indexPage = 0;

	public class click implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			Fragment fgm = null;

			int id = v.getId();
			switch (id) {
			case R.id.view_tab0:
				if (indexPage != 0)
				{
					fgm = fragmentByIndex(0);
					tab[indexPage].setSelected(false);
					indexPage = 0;
				}
				break;
			case R.id.view_tab1:
				if (indexPage != 1)
				{
					fgm = fragmentByIndex(1);
					tab[indexPage].setSelected(false);
					indexPage = 1;
				}
				break;
			case R.id.view_tab2:
				if (indexPage != 2)
				{
					fgm = fragmentByIndex(2);
					tab[indexPage].setSelected(false);
					indexPage = 2;
				}
				break;
			case R.id.view_tab3:
				if (indexPage != 3)
				{
					fgm = fragmentByIndex(3);
					tab[indexPage].setSelected(false);
					indexPage = 3;
				}
				break;
			case R.id.view_tab4:
				if (indexPage != 4)
				{
					fgm = fragmentByIndex(4);
					tab[indexPage].setSelected(false);
					indexPage = 4;
				}
				break;
			default:
				break;
			}

			if (fgm != null)
			{
				tab[indexPage].setSelected(true);
				ft.replace(R.id.content, fgm);
				ft.commit();
			}
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		initTabMenu();

		if (savedInstanceState == null)
		{
			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			ft.add(R.id.content, fragmentByIndex(0));
			ft.commit();
			indexPage = 0;
			tab[indexPage].setSelected(true);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		switch (id) {
		case R.id.action1:
			Toast.makeText(this, "雾霾啊", 1).show();
			break;
		case R.id.action2:
			Toast.makeText(this, "无节操", 1).show();
			break;
		case R.id.action3:
			Toast.makeText(this, "万万没想到", 1).show();
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	private void initTabMenu()
	{
		tab_res = new int[] {R.id.view_tab0, R.id.view_tab1, R.id.view_tab2, R.id.view_tab3, R.id.view_tab4};
		tab = new View[5];
		frag = new Fragment[5];

		for (int i = 0; i < 5; i++) 
		{
			tab[i] = (View) findViewById(tab_res[i]);	
			tab[i].setOnClickListener(new click());
		}
	}

	private Fragment fragmentByIndex(int index)
	{
		if (frag[index] == null)
		{
			try {
				frag[index] = (Fragment) cla[index].newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return frag[index];
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub

		if (requestCode == Constant.REQUEST_SELECT_CITY)
		{
			if (resultCode == Activity.RESULT_OK) {
				String str = (String) data.getCharSequenceExtra(Constant.KEY_CITY_NAME);
				Log.i("yang", str);
			}

			Log.i("yang", "mainActivity onActivityResult called");
		}

		super.onActivityResult(requestCode, resultCode, data);
	}
}
