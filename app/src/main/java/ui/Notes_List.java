package ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hfad.myhomenotes.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import domain.Dependencies;
import domain.Notes;

public class Notes_List extends Fragment {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM, HH:mm", Locale.getDefault());


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_notes__list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout container = view.findViewById(R.id.container_notes_list);

        List<Notes> notes = Dependencies.NOTES_REPOSITORY.getAll();// получаем список заметок(синглтон)

        for (Notes note : notes) {

            View itemView = getLayoutInflater().inflate(R.layout.item_notes, container, false);

            TextView title = itemView.findViewById(R.id.title_note);
            TextView message = itemView.findViewById(R.id.message_note);
            TextView date = itemView.findViewById(R.id.date_note);

            title.setText(note.getTitle());
            message.setText(note.getMessage());

            date.setText(simpleDateFormat.format(note.getCreatedAt()));


            container.addView(itemView);
        }
    }
}