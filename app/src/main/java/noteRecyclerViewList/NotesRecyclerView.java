package noteRecyclerViewList;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hfad.myhomenotes.R;

import java.util.List;


import domain.Dependencies;
import domain.Notes;


public class NotesRecyclerView extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView notesList = view.findViewById(R.id.container_notes_list_recycle);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        notesList.setLayoutManager(layoutManager);

        Adapter adapter = new Adapter();
//todo - в конце всего добавил из адаптера этот метод нажатия на заметку (аналог setOnClickListener )
        adapter.setOnNoteClicked(new Adapter.onNoteClicked() {
            @Override
            public void onNoteClicked(Notes notes) {
                Toast.makeText(requireContext(), notes.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        notesList.setAdapter(adapter);

        List<Notes> notes = Dependencies.NOTES_REPOSITORY.getAll();// получаем список заметок(синглтон)

        adapter.setData(notes);//передал адаптеру список заметок (из адаптера метод)

        adapter.notifyDataSetChanged();// говорим adapter перерисуй cardView
    }
}