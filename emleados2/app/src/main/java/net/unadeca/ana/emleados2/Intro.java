package net.unadeca.ana.emleados2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
    }

    public void clickintro(View view) {
        Intent inte = new Intent(Intro.this, principal.class);
        startActivity(inte);
    }
}
