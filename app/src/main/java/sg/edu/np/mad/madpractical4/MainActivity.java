package sg.edu.np.mad.madpractical4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Intent recieveing_end = getIntent();
        String key = recieveing_end.getStringExtra("Key");
        User user = new User("John Doe", "MAD Developer",1,false);
        String key1 = recieveing_end.getStringExtra("Name");
        String desc = recieveing_end.getStringExtra("Description");
        boolean followed = recieveing_end.getBooleanExtra("Followed",false);
        int id = recieveing_end.getIntExtra("Id",1);
        user.setName(key1);
        user.setDescription(desc);
        user.setFollowed(followed);
        user.setId(id);
        TextView tvName = findViewById(R.id.textView2);
        TextView tvDescription = findViewById(R.id.textView3);

        Button btnFollow = findViewById(R.id.button);
        Button btnMessage = findViewById(R.id.button2);

        tvName.setText(user.getName());
        tvDescription.setText(user.getDescription());
        btnFollow.setText("Follow");

        if(user.getFollowed())
        {
            btnFollow.setText("Unfollow");
        }
        else
        {
            btnFollow.setText("Follow");
        }
        btnFollow.setOnClickListener(new View.OnClickListener() {
            //            @Override
            public void onClick(View v) {
                Intent intent = new Intent("Updating_user_follow_status");
                intent.putExtra("Name",user.getName());
                user.setFollowed(!user.getFollowed());
                if(user.getFollowed())
                {
                    btnFollow.setText("Unfollow");
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    btnFollow.setText("Follow");
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                }
                intent.putExtra("Followed",user.getFollowed());
                LocalBroadcastManager.getInstance(v.getContext()).sendBroadcast(intent);

            }
        });

    }
}