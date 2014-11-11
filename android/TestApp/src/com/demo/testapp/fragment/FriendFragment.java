/**
 * 
 */
package com.demo.testapp.fragment;

import com.demo.testapp.R;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author yangsatiago
 *
 */
public class FriendFragment extends Fragment {
	
	View v;
	private Button scaleButton;
	private Button rotateButton;
	private Button translateButton;
	private Button alphaButton;
	private ImageView image;
	private Button allButton;
	private Button walkButton;
	private ImageView image2;
	public static Fragment newInstance()
	{
		FriendFragment f = new FriendFragment();
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
		v = inflater.inflate(R.layout.fragment_friend, container, false);
		scaleButton = (Button) v.findViewById(R.id.scalebutton);
		rotateButton = (Button) v.findViewById(R.id.rotatebutton);
		translateButton = (Button) v.findViewById(R.id.translatebutton);
		alphaButton = (Button) v.findViewById(R.id.alphabutton);
		allButton = (Button) v.findViewById(R.id.allbutton);
		walkButton = (Button) v.findViewById(R.id.walkbutton);
		image = (ImageView) v.findViewById(R.id.imageView1);
		image2 = (ImageView) v.findViewById(R.id.imageView2);
		
		initListener();
		
		return v;
	}
	
	private void initListener()
	{
		scaleButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AnimationSet animationSet = new AnimationSet(true);
				ScaleAnimation scaleAnimation = new ScaleAnimation(1, 0.1f, 1, 0.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
				
				animationSet.addAnimation(scaleAnimation);
				animationSet.setDuration(2000);
				image.startAnimation(animationSet);
			}
		});
		
		rotateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AnimationSet animationSet = new AnimationSet(true);
				RotateAnimation rotateAnimation = new RotateAnimation(
						0, 360,
						Animation.RELATIVE_TO_PARENT, 0.5f,
						Animation.RELATIVE_TO_PARENT, 1f);
				
				animationSet.setDuration(2000);
				animationSet.addAnimation(rotateAnimation);
				image.startAnimation(animationSet);
			}
		});
		
		translateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AnimationSet animationSet = new AnimationSet(true);
				TranslateAnimation translateAnimation = new TranslateAnimation(
						Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0.5f, 
						Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0.5f);
				
				animationSet.setDuration(2000);
				animationSet.addAnimation(translateAnimation);
				image.startAnimation(animationSet);
			}
		});
		
		alphaButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AnimationSet animationSet = new AnimationSet(true);
				AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
				
				animationSet.setDuration(1000);
				animationSet.addAnimation(alphaAnimation);
				image.startAnimation(animationSet);
			}
		});
		
		allButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(getActivity(), R.anim.anim);
				image.startAnimation(animationSet);
			}
		});
		
		walkButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				image2.setBackgroundResource(R.drawable.anim_walk);
				AnimationDrawable animationDrawable = (AnimationDrawable) image2.getBackground();
				animationDrawable.start();
			}
		});
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
}
