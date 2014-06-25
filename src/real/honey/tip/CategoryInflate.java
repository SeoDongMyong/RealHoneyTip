package real.honey.tip;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CategoryInflate extends Fragment {
	private View rootView;
	private LayoutInflater inflater;
	private ViewGroup container;
	private int display_width;
	private int display_height;

	public static CategoryInflate newInstance(int i) {
		CategoryInflate fragment = new CategoryInflate();
		Bundle args = new Bundle();
		args.putInt("index", i);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.inflater = inflater;

		display_width = MainActivity.getWidth();
		display_height = MainActivity.getHeight();

		rootView = inflater.inflate(R.layout.category, container, false);

		LinearLayout linear = (LinearLayout) rootView
				.findViewById(R.id.category_linear);
		View layoutRow = inflater.inflate(R.layout.category_custom, null);

		LinearLayout mainImg = (LinearLayout) layoutRow
				.findViewById(R.id.category_mainImg);
		ImageView mainImg_img = new ImageView(layoutRow.getContext());
		mainImg_img.setImageResource(R.drawable.test_img1);
		mainImg.addView(mainImg_img, MainActivity.getWidth(),
				MainActivity.getWidth() - MainActivity.getWidth() / 3
						+ dpToPx(10));
		Button category_clock = (Button) layoutRow
				.findViewById(R.id.category_clock);
		Button category_hot = (Button) layoutRow
				.findViewById(R.id.category_hot);

		category_clock.setPadding(dpToPx(6), 0, dpToPx(4), 0);
		category_hot.setPadding(dpToPx(6), 0, dpToPx(4), 0);

		LinearLayout linear01 = (LinearLayout) layoutRow
				.findViewById(R.id.category_linear_img);
		linear01.setPadding(0, dpToPx(2), 0, 0);

		View[] layoutRow2 = new View[Variable.img_resource.length];
		for (int i = 0; i < layoutRow2.length; i += 3) {
			layoutRow2[i] = inflater
					.inflate(R.layout.category_img_custom, null);
			LinearLayout li = (LinearLayout) layoutRow2[i]
					.findViewById(R.id.category_custom_img);

			ImageView img1 = (ImageView) li.findViewById(R.id.category_img1);
			ImageView img2 = (ImageView) li.findViewById(R.id.category_img2);
			ImageView img3 = (ImageView) li.findViewById(R.id.category_img3);
			TextView tv1 = (TextView) li.findViewById(R.id.category_txt1);
			TextView tv2 = (TextView) li.findViewById(R.id.category_txt2);
			TextView tv3 = (TextView) li.findViewById(R.id.category_txt3);

			img1.setImageResource(Variable.img_resource[i]);
			img2.setImageResource(Variable.img_resource[i + 1]);
			img3.setImageResource(Variable.img_resource[i + 2]);

			tv1.setText(Variable.txt_resource[i]);
			tv2.setText(Variable.txt_resource[i + 1]);
			tv3.setText(Variable.txt_resource[i + 2]);

			if (tv1.getText() != null) {
				tv1.setBackgroundColor(Color.BLACK);
			}
			if (tv2.getText() != null) {
				tv2.setBackgroundColor(Color.BLACK);
			}
			if (!tv3.getText().equals("")) {
				tv3.setBackgroundColor(Color.BLACK);
			}

			linear01.addView(layoutRow2[i], MainActivity.getWidth(),
					MainActivity.getWidth() / 3 - dpToPx(8));
		}

		linear.addView(layoutRow);
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
