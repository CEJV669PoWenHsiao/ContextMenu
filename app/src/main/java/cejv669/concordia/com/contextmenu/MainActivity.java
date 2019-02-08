package cejv669.concordia.com.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.btn01);
        Button b2 = findViewById(R.id.btn02);


        registerForContextMenu(b1);
        registerForContextMenu(b2);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.btn01)
        {
            menu.setHeaderTitle("Two Letters Menu");
            menu.add(0, v.getId(), 0, "A");
            menu.add(1, v.getId(), 0, "B");
        }
        if (v.getId() == R.id.btn02) {
            menu.setHeaderTitle("Two Color Menu");
            menu.add(0, v.getId(), 1, "Red");
            menu.add(1, v.getId(), 1, "Blue");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        TextView tv = findViewById(R.id.lblResult);

        if (item.getItemId() == R.id.btn01)
        {
            if (item.getGroupId() == 0) {
                Toast.makeText(this, "You selected A ", Toast.LENGTH_LONG).show();

                tv.setText("You selected A ");
            }

            if (item.getGroupId() == 1) {
                Toast.makeText(this, "You selected B ", Toast.LENGTH_LONG).show();
                tv.setText("You selected B ");
            }
        }

        if (item.getItemId() == R.id.btn02)
        {
            Toast.makeText(this, "You selected " + item.toString(), Toast.LENGTH_LONG).show();
            tv.setText("You selected " + item.toString());
        }

        return true;

    }


}
