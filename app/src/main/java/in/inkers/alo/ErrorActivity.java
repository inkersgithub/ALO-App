package in.inkers.alo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ErrorActivity extends AppCompatActivity implements View.OnClickListener{

    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        findViewById(R.id.tvRefresh).setOnClickListener(this);
        findViewById(R.id.tvExit).setOnClickListener(this);

        Intent intent = getIntent();
        link = intent.getStringExtra("link");

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.tvRefresh:
                Intent main = new Intent(this,MainActivity.class);
                if(link!=null)
                    main.putExtra("link",link);
                startActivity(main) ;
                finish();
                break;

            case R.id.tvExit:
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                this.finish();
        }
    }
}
