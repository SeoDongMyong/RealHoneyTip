package real.honey.tip;

import java.util.Locale;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

	public SectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return TimelineInflate.newInstance(position + 1);
		case 1:
			return CategoryInflate.newInstance(position + 1);
		case 2:
			return ScrapInflate.newInstance(position + 1);
		case 3:
			return EtcInflate.newInstance(position + 1);
		default:
			break;
		}
		return null;
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		Locale l = Locale.getDefault();
		switch (position) {
		case 0:
			return "1번";
		case 1:
			return "2번";
		case 2:
			return "3번";
		case 3:
			return "4번";
		}
		return null;
	}

	public int getImage(int position) {
		Locale l = Locale.getDefault();
		switch (position) {
		case 0:
			return R.drawable.timeline;
		case 1:
			return R.drawable.category;
		case 2:
			return R.drawable.star;
		case 3:
			return R.drawable.the_rest;
		}
		return 0;
	}
}
