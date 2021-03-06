package io.github.project_travel_mate.mytrips;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.project_travel_mate.R;
import objects.User;

class MyTripFriendnameAdapter extends ArrayAdapter<User> {
    private final Activity mContext;
    private final List<User> mUsers;

    MyTripFriendnameAdapter(Activity context, List<User> users) {
        super(context, R.layout.home_city_listitem, users);
        this.mContext = context;
        this.mUsers = users;
    }

    @NonNull
    @Override
    public View getView(final int position, View view, @NonNull ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = Objects.requireNonNull(mInflater).inflate(R.layout.trip_friend_listitem, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else
            holder = (ViewHolder) view.getTag();
        holder.name.setText(mUsers.get(position).getFirstName());
        Picasso.with(mContext).load(mUsers.get(position).getImage()).placeholder(R.drawable.ic_person_black_24dp)
                .error(R.drawable.ic_person_black_24dp).into(holder.imageView);
        return view;
    }

    class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.image)
        ImageView imageView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
