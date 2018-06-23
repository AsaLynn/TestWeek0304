package com.test.week0304.slidemenu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.test.week0304.R;

/**
 * 易信页面
 * @author Administrator
 *
 */
public class FragmentDefaultMain extends Fragment implements OnClickListener{
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	View view = inflater.inflate(R.layout.fragment_yixin, container, false);
    	Button button = (Button)view.findViewById(R.id.TestBtn);
    	button.setOnClickListener(this);
    	return view;
    }

	@Override
	public void onClick(View v) {
		Toast.makeText(getActivity().getApplicationContext(), "很好！", Toast.LENGTH_SHORT).show();
	}
}
