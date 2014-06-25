package real.honey.tip;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class Join extends Activity {
	Join_popUp cm;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.join);
		getActionBar().setTitle("회원가입");
		Calendar cal = new GregorianCalendar();
		int mYear = cal.get(Calendar.YEAR);
		int mMonth = cal.get(Calendar.MONTH);
		int mDay = cal.get(Calendar.DAY_OF_MONTH);
		cm = new Join_popUp(this);
		WindowManager.LayoutParams wm = new WindowManager.LayoutParams();
		wm.copyFrom(cm.getWindow().getAttributes());
		wm.width = wm.WRAP_CONTENT;
		wm.height = wm.WRAP_CONTENT;
		
		tv = (TextView) findViewById(R.id.sID);
		tv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				cm.show();
			}
		});
		Window window = cm.getWindow();
		window.setAttributes(wm);

	}

	private OnDateSetListener listener = new OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			tv.setText(year + "년 " + monthOfYear + "월 " + dayOfMonth + "일");
		}
	};
}
