package jp.codeforfun.arknightsdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //deleteDatabase("personalDB.db");

        Button btResource = findViewById(R.id.bt_MR);
        Button btHumanResource = findViewById(R.id.bt_PR);
        Button btToDo = findViewById(R.id.bt_TD);
        btResource.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, MaterialResourceActivity.class);
            startActivity(intent);
        });
        btHumanResource.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, HumanResourceActivity.class);
            startActivity(intent);
        });
        btToDo.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this,ToDoActivity.class);
            startActivity(intent);
        });

    }
}
