package real.honey.tip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ScrapInflate extends Fragment {
	private View rootView;
	private LayoutInflater inflater;
	private ViewGroup container;
	private int display_width;
	private int display_height;

	public static ScrapInflate newInstance(int i) {
		ScrapInflate fragment = new ScrapInflate();
		Bundle args = new Bundle();
		args.putInt("index", i);
		fragment.setArguments(args);
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.scrap, container, false);
		return rootView;
	}

	public int pxToDp(int px) {
		DisplayMetrics displayMetrics = inflater.getContext().getResources()
				.getDisplayMetrics();
		int dp = Math.round(px
				/ (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
		return dp;
	}

	public int dpToPx(int dp) {
		DisplayMetrics displayMetrics = inflater.getContext().getResources()
				.getDisplayMetrics();
		int px = Math.round(dp
				* (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
		return px;
	}
}
