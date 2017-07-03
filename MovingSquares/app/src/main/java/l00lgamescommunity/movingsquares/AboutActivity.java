package l00lgamescommunity.movingsquares;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        Button backButton = (Button) findViewById(R.id.backButtonAbout);

        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent back = new Intent(AboutActivity.this, MovingSquareStartActivity.class);
                startActivity(back);
            }
        });
    }
}
