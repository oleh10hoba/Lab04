package pollub.ism.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class game extends AppCompatActivity {
    public static int KOD_PROSBY = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
    int steps = 0;
    String mark = "X";
    String square[][] = {{"00","01","02"},{"10","11","12"},{"20","21","22"}};
    public void click_button(View view) {
//        Toast.makeText(this,"Wygrały X", Toast.LENGTH_LONG).show();
        Button b = (Button) view;
        int if_win = 0;
        if (b.getText() != "X" && b.getText() != "0") {
            b.setText(mark);
            String button_name = view.getResources().getResourceEntryName(view.getId());
            int x = Integer.parseInt(button_name.substring(7, 8));
            int y = Integer.parseInt(button_name.substring(9, 10));
            square[x][y] = mark;
            if_win = check_win();
            if (if_win == 1) {
                Toast.makeText(this, "Win " + mark, Toast.LENGTH_LONG).show();
                Intent intencja = new Intent(this, MainActivity.class);
                this.startActivityForResult(intencja, KOD_PROSBY);
            }
            steps++;
            if(steps >= 9)
            {
                Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show();
                Intent intencja = new Intent(this, MainActivity.class);
                this.startActivityForResult(intencja, KOD_PROSBY);

            }
            mark = mark == "X" ? "0" : "X";
        }
    }
    public int check_win()
    {
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+square[0][2]);
        if(square[0][0] == square[0][1] && square[0][1] == square[0][2] ||
                square[1][0] == square[1][1] && square[1][1] == square[1][2] ||
                square[2][0] == square[2][1] && square[2][1] == square[2][2] ||
                square[0][0] == square[1][0] && square[1][0] == square[2][0] ||
                square[0][1] == square[1][1] && square[1][1] == square[2][1] ||
                square[0][2] == square[1][2] && square[1][2] == square[2][2] ||
                square[0][0] == square[1][1] && square[1][1] == square[2][2] ||
                square[0][2] == square[1][1] && square[1][1] == square[2][0]
        )
        {
            return 1;
        }
        return 0;
    }
}