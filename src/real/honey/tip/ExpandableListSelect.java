package real.honey.tip;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class ExpandableListSelect extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loud_speaker);
		ExpandableListAdapter adapter = new MyExpandableListAdapter(this);

		ExpandableListView loud_list = (ExpandableListView) findViewById(R.id.loud_list);
		loud_list.setAdapter(adapter);
		loud_list.setGroupIndicator(null);
	}

	public int pxToDp(int px) {
		DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
		int dp = Math.round(px
				/ (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
		return dp;
	}

	public int dpToPx(int dp) {
		DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
		int px = Math.round(dp
				* (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
		return px;
	}
}
