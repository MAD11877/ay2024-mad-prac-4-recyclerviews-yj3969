package sg.edu.np.mad.madpractical4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getApplicationContext(),"testing",Toast.LENGTH_SHORT).show();
                Random rand = new Random();
                int upperbound = 99999;
                int random_int = rand.nextInt(upperbound);
                //Toast.makeText(getApplicationContext(),Integer.toString(random_int),Toast.LENGTH_SHORT).show();
                Intent activity  = new Intent(ListActivity.this,MainActivity.class);
                String rand_int = Integer.toString(random_int);
                activity.putExtra("Key",rand_int);
                startActivity(activity);
            }
        });

        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert = builder.create();
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.show();
            }
        });

        //Creating 20 Users
        ArrayList<User> user_data = new ArrayList<>();
        for (int i = 1; i<21; i++)
        {
            Random rand = new Random();
            int upperbound = 99999;
            int random_int = rand.nextInt(upperbound);
            int random_int2 = rand.nextInt(upperbound);
            String name = "Name" + Integer.toString(random_int);
            String description = "Description" + " " + Integer.toString(random_int2);
            int id = i +1;
            boolean followed = false;
            User user = new User(name,description,id,followed);
            user_data.add(user);
        }

        UserAdapter mAdapter = new UserAdapter(user_data,this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}