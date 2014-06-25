package real.honey.tip;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class EtcInflate extends Fragment {
	private View rootView;
	private LayoutInflater inflater;
	private ViewGroup container;
	private int display_width;
	private int display_height;

	public static EtcInflate newInstance(int i) {
		EtcInflate fragment = new EtcInflate();
		Bundle args = new Bundle();
		args.putInt("index", i);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.etc, container, false);

		LinearLayout etc_notice = (LinearLayout) rootView
				.findViewById(R.id.etc_notice);
		etc_notice.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				ImageView etc_notice_ico = (ImageView) rootView
						.findViewById(R.id.etc_notice_ico);
				if (Variable.SOUND_STATE == 0) {
					etc_notice_ico.setImageResource(R.drawable.notice);
					Variable.SOUND_STATE = 1;
				} else {
					etc_notice_ico.setImageResource(R.drawable.notice_off);
					Variable.SOUND_STATE = 0;
				}
			}
		});

		LinearLayout etc_join = (LinearLayout) rootView
				.findViewById(R.id.etc_join);
		etc_join.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), Join.class);
				startActivity(intent);
			}
		});

		LinearLayout etc_loud_speaker = (LinearLayout) rootView
				.findViewById(R.id.etc_loud_speaker);
		etc_loud_speaker.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),
						ExpandableListSelect.class);
				startActivity(intent);
			}
		});
		LinearLayout etc_facebook = (LinearLayout) rootView
				.findViewById(R.id.etc_facebook);
		etc_facebook.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("https://www.facebook.com/profile.php?id=100002039410040"));
				startActivity(intent);
			}
		});

		LinearLayout etc_inquiry = (LinearLayout) rootView
				.findViewById(R.id.etc_inquiry);
		etc_inquiry.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), Inquiry.class);
				startActivity(intent);
			}
		});
		
		LinearLayout etc_profile = (LinearLayout) rootView
				.findViewById(R.id.etc_profile);
		etc_profile.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), Profile.class);
				startActivity(intent);
			}
		});
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
