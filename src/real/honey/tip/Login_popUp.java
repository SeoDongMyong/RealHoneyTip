package real.honey.tip;

import java.util.zip.Inflater;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Login_popUp extends Dialog{

	Context context;
	Inflater inflater;

	public Login_popUp(Context context, int theme) {
		super(context, theme);
		this.context = context;
		getWindow().getDecorView().setBackgroundResource(
				android.R.color.transparent);
	}

	public Login_popUp(Context context) {
		super(context);
	}

	String title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login_info);
	}
}
