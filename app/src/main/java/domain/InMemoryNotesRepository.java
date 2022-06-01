package domain;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class InMemoryNotesRepository implements NotesRepository {

    private static NotesRepository INSTANCE;

    public InMemoryNotesRepository() {

    }

    public static NotesRepository getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryNotesRepository(context);
        }
        return INSTANCE;
    }

    private Context context;

    public InMemoryNotesRepository(Context context) {
        this.context = context;
    }

    @Override
    public ArrayList<Notes> getAll() {
        ArrayList<Notes> data = new ArrayList<>();

        data.add(new Notes(UUID.randomUUID().toString(), "Title 1", "Message 1", new Date()));//new Date() - дата (время)
        data.add(new Notes(UUID.randomUUID().toString(), "Title 2", "Message 2", new Date()));
        data.add(new Notes(UUID.randomUUID().toString(), "Title 3", "Message 3", new Date()));
        data.add(new Notes(UUID.randomUUID().toString(), "Title 4", "Message 4", new Date()));
        data.add(new Notes(UUID.randomUUID().toString(), "Title 5", "Message 5", new Date()));
        data.add(new Notes(UUID.randomUUID().toString(), "Title 6", "Message 6", new Date()));
        data.add(new Notes(UUID.randomUUID().toString(), "Title 7", "Message 7", new Date()));

        return data;
    }

    @Override
    public void add(Notes notes) {

    }

}
