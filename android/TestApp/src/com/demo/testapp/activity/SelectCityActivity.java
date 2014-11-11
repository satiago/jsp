/**
 * 
 */
package com.demo.testapp.activity;

import java.util.ArrayList;

import com.demo.testapp.R;
import com.demo.testapp.app.Constant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * @author yangsatiago
 *
 */
public class SelectCityActivity extends Activity {

	ListView stationList;
	ArrayAdapter<String> adapter;
	ArrayList<String> city_list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.city_main);
		stationList = (ListView) findViewById(R.id.list_view);
		
		stationList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		InitCity();
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, city_list);
		stationList.setAdapter(adapter);
		
		stationList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String city = city_list.get(position);
				Intent i = new Intent();
				i.putExtra(Constant.KEY_CITY_NAME, city);
				setResult(RESULT_OK, i);
				finish();
			}
			
		});
	}
	
	
	private void InitCity() {
		// TODO Auto-generated method stub
		city_list = new ArrayList<String>();
		
		city_list.add("上海");
		city_list.add("北京");
		city_list.add("天津");
		city_list.add("深圳");
		city_list.add("太原");
		city_list.add("西安");
		city_list.add("福州");
		city_list.add("广州");
		city_list.add("丽江");
		city_list.add("杭州");
		city_list.add("苏州");
		city_list.add("西藏");
		city_list.add("新疆");
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	
}
