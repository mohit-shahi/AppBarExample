package com.example.appbarexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbaar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
//        menuInflater.inflate(R.menu.app_bar_menu,menu);
        menuInflater.inflate(R.menu.toolbar_menu,menu);

        MenuItem.OnActionExpandListener onActionExpandListener=new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                Toast.makeText(MainActivity.this,"Expanded", Toast.LENGTH_LONG).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                Toast.makeText(MainActivity.this,"collapsed", Toast.LENGTH_LONG).show();
                return true;
            }
        };
        MenuItem searchItem=menu.findItem(R.id.action_share);
        searchItem.setOnActionExpandListener(onActionExpandListener);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_share:
                Toast.makeText(this,"share option",Toast.LENGTH_LONG).show();
                    return true;

                    case R.id.action_settings:
                        Toast.makeText(this,"settings option",Toast.LENGTH_LONG).show();
                        return true;

                        default:
                            return super.onOptionsItemSelected(item);
        }



    }
}
