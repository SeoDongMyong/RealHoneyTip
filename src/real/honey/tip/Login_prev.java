package real.honey.tip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Login_prev extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_prev);
		Button LoginBtn = (Button) findViewById(R.id.goto_login);
		Button JoinBtn1 = (Button) findViewById(R.id.goto_eJoin);
		Button JoinBtn2 = (Button) findViewById(R.id.goto_fJoin);
		
		JoinBtn2.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "기능 준비중입니다.", Toast.LENGTH_SHORT).show();
//				Intent intent = new Intent(Login_prev.this, Join.class);
//				startActivity(intent);
			}
		});
		
		JoinBtn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Login_prev.this, Join.class);
				startActivity(intent);
			}
		});

		LoginBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Login_prev.this, Login.class);
				startActivity(intent);
			}
		});
	}
}
