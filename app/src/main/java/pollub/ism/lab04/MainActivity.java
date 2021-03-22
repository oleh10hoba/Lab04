package pollub.ism.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static int KOD_PROSBY = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void to_game(View view)
    {
        Intent intencja = new Intent(this, game.class);
        this.startActivityForResult(intencja, KOD_PROSBY);
    }

}