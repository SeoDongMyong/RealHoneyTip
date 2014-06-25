package real.honey.tip;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Comments extends Dialog {
	private View[] layoutRow;
	LinearLayout linear;
	LayoutInflater inflater;
	Context context;

	public Comments(Context context, int theme) {
		super(context, theme);
		this.context = context;
		getWindow().getDecorView().setBackgroundResource(
				android.R.color.transparent);
	}

	public Comments(Context context) {
		super(context);
	}

	String title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.comments);

		linear = (LinearLayout) findViewById(R.id.comments_custom);
		inflater = LayoutInflater.from(linear.getContext());
		layoutRow = new View[10];

		for (int i = 0; i < 7; i++) {
			layoutRow[i] = inflater
					.inflate(R.layout.comments_custom_view, null);
			layoutRow[i].setPadding(0, 0, 0, dpToPx(18));
			TextView tv = (TextView) layoutRow[i]
					.findViewById(R.id.comments_content);
			if (i < 3)
				tv.setText("야호야호\nㅁㅇㄴ함ㄴ");
			linear.addView(layoutRow[i]);
		}
	}

	public int dpToPx(int dp) {
		DisplayMetrics displayMetrics = inflater.getContext().getResources()
				.getDisplayMetrics();
		int px = Math.round(dp
				* (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
		return px;
	}
}
