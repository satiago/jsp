package com.demo.testapp.fragment;

import com.demo.testapp.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * @author yangsatiago
 *
 */
public class GoodsFragment extends Fragment {
	
	private View v;
	private Button btn_sort0;
	private Button btn_sort1;
	private Button btn_sort2;
	private RadioGroup rg;
	Fragment mapFrag;
	Fragment listFrag;
	private Button popup_button;
	
	public static Fragment newInstance()
	{
		GoodsFragment f = new GoodsFragment();
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
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		v = inflater.inflate(R.layout.fragment_goods, container, false);
		popup_button = (Button) v.findViewById(R.id.popup_button);
		initListener();
		
		if (savedInstanceState == null) {
			rg.check(R.id.rb_info_list);
		}
		
		popup_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PopupMenu popupmenu = new PopupMenu(getActivity(), v);
				popupmenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						// TODO Auto-generated method stub
						return false;
					}
				});
				
				MenuInflater inflater = getActivity().getMenuInflater();
				inflater.inflate(R.menu.context, popupmenu.getMenu());
				popupmenu.show();
			}
		});
		
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
	
	public void showDistanceDialog()
	{
		final String[] strs = { "500", "1000", "2000", "5000" };
		AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
		b.setTitle("距离选择");
		b.setItems(strs, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				btn_sort1.setText(strs[which]);
				dialog.cancel();
			}
		});
		b.setOnCancelListener(new OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				// TODO Auto-generated method stub
				Log.i("yang", "onCancelListener called");
			}
		});
		b.show();
	}
	
	public void initListener()
	{
		btn_sort0 = (Button) v.findViewById(R.id.rb_sort0);
		btn_sort1 = (Button) v.findViewById(R.id.rb_sort1);
		btn_sort2 = (Button) v.findViewById(R.id.rb_sort2);
		rg = (RadioGroup) v.findViewById(R.id.rg_info);
		
		btn_sort1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDistanceDialog();
			}
		});
		
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if (checkedId == R.id.rb_info_list) {
					loadListFrag();
				}else
				{
					loadMapFrag();
				}
			}
		});
	}

	protected void loadMapFrag() {
		// TODO Auto-generated method stub
		FragmentTransaction ft = getChildFragmentManager().beginTransaction();

		if (mapFrag == null) {
			mapFrag = GoodsMapFragment.newInstance();

			ft.add(R.id.info_content, mapFrag);

		} else {
			
			ft.show(mapFrag);

		}
		
		if (listFrag != null)
			ft.hide(listFrag);
		
		ft.commit();
	}

	protected void loadListFrag() {
		// TODO Auto-generated method stub
		FragmentTransaction ft = getChildFragmentManager().beginTransaction();

		if (listFrag == null) {
			listFrag = GoodsListFragment.newInstance();

			ft.add(R.id.info_content, listFrag);

		} else {

			ft.show(listFrag);

		}

		if (mapFrag != null)
			ft.hide(mapFrag);
		
		ft.commit();
	}
}
