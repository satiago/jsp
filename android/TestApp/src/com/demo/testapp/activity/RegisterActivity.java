/**
 * 
 */
package com.demo.testapp.activity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.demo.testapp.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

/**
 * @author yangsatiago
 *
 */
public class RegisterActivity extends Activity {

	Button btn_register;
	EditText et_birthdate;
	DatePickerDialog dpd;
	
	Context context = this;
	private String dateStr;
	private int mYear;
	private int mMonth;
	private int mDay;
	private EditText btn_phone;
	protected View focusView;
	protected boolean cancel = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_register);
		initView();
		initDatePicker();
		initListener();
	}
	
	private void initListener() {
		// TODO Auto-generated method stub
		btn_register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				btn_phone.setError(null);
				String phoneStr = btn_phone.getText().toString();
				
				if (phoneStr == null || phoneStr.length() == 0) {
					btn_phone.setError("必填");
					focusView = btn_phone;
					cancel = true;
				}
				
				if (cancel) {
					focusView.requestFocus();
					cancel = false;
				}
				else
				{
					Intent i = new Intent(context, MainActivity.class);
					i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
							| Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(i);
					cancel = false;
					finish();
				}
			}
		});
		
		et_birthdate.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					// set birth date
					// date dialog picker
					dateStr = et_birthdate.getText().toString();

					dpd.show();
					dpd.updateDate(mYear, mMonth, mDay);
					return true;
				}
				return false;
			}
		});
		
	}

	private void initDatePicker() {
		// TODO Auto-generated method stub
		getDateFromStr();
		
		dpd = new DatePickerDialog(context, new OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				mYear = year;
				mMonth = monthOfYear;
				mDay = dayOfMonth;
				updateDisplay();
				
			}
		}, mYear, mMonth, mDay);
	}

	protected void updateDisplay() {
		// TODO Auto-generated method stub
		//Date date = new Date(mYear - 1900, mMonth, mDay);
		GregorianCalendar date = new GregorianCalendar(mYear, mMonth, mDay);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		et_birthdate.setText(sdf.format(date.getTime()));
	}

	private void getDateFromStr() {
		// TODO Auto-generated method stub
		dateStr = et_birthdate.getText().toString();
		final Calendar c = Calendar.getInstance();
		
		if (dateStr != null && dateStr.length() != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Date d = new Date();
			try {
				d = sdf.parse(dateStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.setTime(d);
		}
		
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
	}

	private void initView() {
		// TODO Auto-generated method stub
		btn_register = (Button) findViewById(R.id.btn_register_register);
		et_birthdate = (EditText) findViewById(R.id.et_register_select_birthdate);
		btn_phone = (EditText) findViewById(R.id.et_register_input_phone);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}
}
