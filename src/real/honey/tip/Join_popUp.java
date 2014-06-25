package real.honey.tip;

import java.util.zip.Inflater;

import real.honey.tip.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

public class Join_popUp extends Dialog {
	Context context;
	Inflater inflater;

	public Join_popUp(Context context, int theme) {
		super(context, theme);
		this.context = context;
		getWindow().getDecorView().setBackgroundResource(
				android.R.color.transparent);
	}

	public Join_popUp(Context context) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().getDecorView().setBackgroundResource(
				android.R.color.transparent);
	}

	String title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.join_custom);

	}
}
