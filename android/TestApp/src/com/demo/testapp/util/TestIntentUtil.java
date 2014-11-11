/**
 * 
 */
package com.demo.testapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.demo.testapp.activity.SelectCityActivity;
import com.demo.testapp.app.Constant;


/**
 * @author yangsatiago
 *
 */
public class TestIntentUtil {

	public static void toSelectCity(Context context) {

		// MySelectCityActivity
		Intent intent = new Intent(context, SelectCityActivity.class);

		((Activity) context).startActivityForResult(intent,
				Constant.REQUEST_SELECT_CITY);
	}
}
