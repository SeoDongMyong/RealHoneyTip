package real.honey.tip;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;

public class MainActivity extends ActionBarActivity implements
		ActionBar.TabListener {
	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;
	public static int width = 0;
	public static int height = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame_main);
		Display display = ((WindowManager) this
				.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		width = display.getWidth();
		height = display.getHeight();

		final ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setTitle("타임라인");

		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						switch (position) {
						case 0:
							actionBar.setTitle("타임라인");
							actionBar.getTabAt(0).setIcon(
									R.drawable.timeline_full);
							actionBar.getTabAt(1).setIcon(R.drawable.category);
							actionBar.getTabAt(2).setIcon(R.drawable.star);
							actionBar.getTabAt(3).setIcon(R.drawable.the_rest);
							break;
						case 1:
							actionBar.setTitle("카테고리");
							actionBar.getTabAt(0).setIcon(R.drawable.timeline);
							actionBar.getTabAt(1).setIcon(
									R.drawable.category_full);
							actionBar.getTabAt(2).setIcon(R.drawable.star);
							actionBar.getTabAt(3).setIcon(R.drawable.the_rest);
							break;
						case 2:
							actionBar.setTitle("내 꿀팁");
							actionBar.getTabAt(0).setIcon(R.drawable.timeline);
							actionBar.getTabAt(1).setIcon(R.drawable.category);
							actionBar.getTabAt(2)
									.setIcon(R.drawable.scrap_full);
							actionBar.getTabAt(3).setIcon(R.drawable.the_rest);
							break;
						case 3:
							actionBar.setTitle("더보기");
							actionBar.getTabAt(0).setIcon(R.drawable.timeline);
							actionBar.getTabAt(1).setIcon(R.drawable.category);
							actionBar.getTabAt(2).setIcon(R.drawable.star);
							actionBar.getTabAt(3).setIcon(
									R.drawable.the_rest_full);
							break;
						default:
							break;
						}
						actionBar.setSelectedNavigationItem(position);
					}
				});

		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			actionBar.addTab(actionBar
					.newTab()
					.setIcon(
							getResources().getDrawable(
									mSectionsPagerAdapter.getImage(i)))
					.setTabListener(this));
		}
		actionBar.getTabAt(0).setIcon(R.drawable.timeline_full);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		MainActivity.width = width;
	}

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		MainActivity.height = height;
	}

	@Override
	public boolean onCreatePanelMenu(int featureId, Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreatePanelMenu(featureId, menu);
	}
}
