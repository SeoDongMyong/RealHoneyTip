package real.honey.tip;

import java.util.zip.Inflater;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

public class Share_popUp extends Dialog {
	Context context;
	Inflater inflater;

	public Share_popUp(Context context, int theme) {
		super(context, theme);
		this.context = context;
	}

	public Share_popUp(Context context) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().getDecorView().setBackgroundResource(
				android.R.color.transparent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share);

	}
}
