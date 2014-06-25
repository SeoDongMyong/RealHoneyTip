package real.honey.tip;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class TimelineInflate extends Fragment {

	private static View rootView;
	private View[] layoutRow;
	private ViewFlipper[] viewFlipper;
	private int display_width;
	private int display_height;
	public Login_popUp login;
	public Button btn1, btn2, btn3, good;
	private Activity mActivity;
	public LayoutInflater inflater;

	public static TimelineInflate newInstance(int i) {
		TimelineInflate fragment = new TimelineInflate();
		Bundle args = new Bundle();
		args.putInt("index", i);
		fragment.setArguments(args);
		return fragment;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.inflater = inflater;
		rootView = inflater.inflate(R.layout.timeline, container, false);
		LinearLayout linear = (LinearLayout) rootView
				.findViewById(R.id.timeline_custom);
		layoutRow = new View[10];
		viewFlipper = new ViewFlipper[10];
		for (int i = 0; i < 10; i++) {
			layoutRow[i] = inflater
					.inflate(R.layout.timeline_custom_view, null);
			layoutRow[i].setPadding(dpToPx(16), dpToPx(16), dpToPx(16), 0);
			viewFlipper[i] = (ViewFlipper) layoutRow[i]
					.findViewById(R.id.viewFlipper);
			TextView tv = (TextView) layoutRow[i]
					.findViewById(R.id.timeline_com);
			Button btn = (Button) layoutRow[i].findViewById(R.id.timeline_com1);
			good = (Button) layoutRow[i].findViewById(R.id.timeline_good);
			btn3 = (Button) layoutRow[i].findViewById(R.id.shareBtn);
			btn3.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Share_popUp cm = new Share_popUp(rootView.getContext());
					WindowManager.LayoutParams wm = new WindowManager.LayoutParams();
					wm.copyFrom(cm.getWindow().getAttributes());
					wm.dimAmount = 0.75f;
					wm.width = wm.WRAP_CONTENT;
					wm.height = wm.WRAP_CONTENT;
					cm.getWindow().setFlags(wm.FLAG_BLUR_BEHIND,
							wm.FLAG_BLUR_BEHIND);
					cm.show();
					Window window = cm.getWindow();
					window.setAttributes(wm);
				}
			});
			good.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Drawable img = getActivity().getResources().getDrawable(
							R.drawable.timeline_heart_full);
					((Button) v).setCompoundDrawablesWithIntrinsicBounds(img,
							null, null, null);
					login = new Login_popUp(rootView.getContext(),
							R.style.Theme_Dialog);
					login.show();
					btn1 = (Button) login.findViewById(R.id.login_prev);
					btn2 = (Button) login.findViewById(R.id.canceled);
					btn1.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {

							Intent intent = new Intent(getActivity(),
									Login_prev.class);
							startActivity(intent);
						}
					});
					btn2.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							login.cancel();
						}
					});
					WindowManager.LayoutParams wm = new WindowManager.LayoutParams();
					wm.copyFrom(login.getWindow().getAttributes());
					wm.dimAmount = 0.75f;
					wm.width = (int) (MainActivity.getWidth() * 0.7);
					wm.height = (int) (MainActivity.getHeight() * 0.3);
					login.getWindow().setFlags(wm.FLAG_BLUR_BEHIND,
							wm.FLAG_BLUR_BEHIND);
					Window window = login.getWindow();
					window.setAttributes(wm);
				}
			});

			btn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Comments cm = new Comments(rootView.getContext(),
							R.style.Theme_Dialog);
					WindowManager.LayoutParams wm = new WindowManager.LayoutParams();
					wm.copyFrom(cm.getWindow().getAttributes());
					wm.dimAmount = 0.75f;
					wm.width = (int) (MainActivity.getWidth() * 0.9);
					wm.height = (int) (MainActivity.getHeight() * 0.9);
					cm.getWindow().setFlags(wm.FLAG_BLUR_BEHIND,
							wm.FLAG_BLUR_BEHIND);
					cm.show();
					Window window = cm.getWindow();
					window.setAttributes(wm);
				}
			});

			tv.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Comments cm = new Comments(rootView.getContext(),
							R.style.Theme_Dialog);
					WindowManager.LayoutParams wm = new WindowManager.LayoutParams();
					wm.copyFrom(cm.getWindow().getAttributes());
					wm.dimAmount = 0.75f;
					wm.width = (int) (MainActivity.getWidth() * 0.9);
					wm.height = (int) (MainActivity.getHeight() * 0.9);
					cm.getWindow().setFlags(wm.FLAG_BLUR_BEHIND,
							wm.FLAG_BLUR_BEHIND);
					cm.show();

					Window window = cm.getWindow();
					window.setAttributes(wm);

				}
			});

			ImageView[] imgView = new ImageView[5];

			for (int j = 0; j < imgView.length; j++) {
				imgView[j] = new ImageView(rootView.getContext());
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inSampleSize = 10;
				Bitmap bitmap = BitmapFactory.decodeResource(
						layoutRow[i].getResources(), R.drawable.e1, options);
				imgView[j].setImageBitmap(bitmap); // 이미지뷰에 조정한 이미지 넣기
				imgView[j].setImageResource(R.drawable.e1);
				LayoutParams mParam = new LayoutParams((int)(LayoutParams.MATCH_PARENT),(int) (LayoutParams.MATCH_PARENT));
				viewFlipper[i].addView(imgView[j], mParam);
				bitmap.recycle();
			}

			linear.addView(layoutRow[i]);
		}
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
