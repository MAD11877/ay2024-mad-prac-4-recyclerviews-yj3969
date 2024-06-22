package sg.edu.np.mad.madpractical4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView txt;
    TextView nameTextView;
    ImageView imageView;

    ImageView bigImageView;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        txt = itemView.findViewById(R.id.descriptionTextView);
    }
}