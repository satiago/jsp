/**
 * 
 */
package com.demo.testapp.fragment;

import com.demo.testapp.R;
import com.demo.testapp.activity.SelectCityActivity;
import com.demo.testapp.app.Constant;
import com.demo.testapp.ui.FalseSearchTitleLayout;
import com.demo.testapp.util.TestIntentUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;

/**
 * @author yangsatiago
 *
 */
public class HomeFragment extends Fragment {

	View v;
	FalseSearchTitleLayout title_layout;
	Button test_button;
	Button context_button;
	Button action_button;
	Context context;
	ActionMode actionmode;
	TabHost tabh;

	public static Fragment newInstance()
	{
		HomeFragment f = new HomeFragment();
		return f;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	private ActionMode.Callback actionCallback = new ActionMode.Callback() {

		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onDestroyActionMode(ActionMode mode) {
			// TODO Auto-generated method stub
			actionmode = null;
		}

		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			// TODO Auto-generated method stub
			MenuInflater inflater = getActivity().getMenuInflater();
			inflater.inflate(R.menu.context, menu);
			return true;
		}

		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			// TODO Auto-generated method stub
			return false;
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		v = inflater.inflate(R.layout.fragment_home, container, false);
		title_layout = (FalseSearchTitleLayout) v.findViewById(R.id.title_layout);
		test_button = (Button) v.findViewById(R.id.test_button);
		action_button = (Button) v.findViewById(R.id.actionmode_button);

		test_button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), SelectCityActivity.class);

				startActivityForResult(intent,
						Constant.REQUEST_SELECT_CITY);
			}
		});

		action_button.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				if (actionmode != null) {
					return false;
				}
				actionmode = getActivity().startActionMode(actionCallback);
				v.setSelected(true);
				return true;
			}
		});

		tabh = (TabHost) v.findViewById(R.id.tabhost);
		tabh.setup();  
		TabWidget tabWidget = tabh.getTabWidget();

		TabSpec tab1 = tabh.newTabSpec("tab01")
				.setIndicator("自由")
				.setContent(R.id.tab1);
		tabh.addTab(tab1);

		TabSpec tab2 = tabh.newTabSpec("tab02")
				.setIndicator("民主")
				.setContent(R.id.tab2);
		tabh.addTab(tab2);

		TabSpec tab3 = tabh.newTabSpec("tab03")
				.setIndicator("博爱")
				.setContent(R.id.tab3);
		tabh.addTab(tab3);

		context_button = (Button) v.findViewById(R.id.context_button);
		registerForContextMenu(context_button);

		context_button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "长按我啊，亲！", 1).show();
			}
		});

		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub

		if (requestCode == Constant.REQUEST_SELECT_CITY)
		{
			if (resultCode == Activity.RESULT_OK) {
				String str = (String) data.getCharSequenceExtra(Constant.KEY_CITY_NAME);
				title_layout.setCity(str);
				Log.i("yang", str);
			}

			Log.i("yang", "homefragment onActivityResult called");
		}

		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflter = getActivity().getMenuInflater();
		inflter.inflate(R.menu.context, menu);

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onContextItemSelected(item);
	}
}
