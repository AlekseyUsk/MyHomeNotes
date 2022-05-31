package domain;

import java.util.ArrayList;

public interface NotesRepository {

ArrayList<Notes> getAll(); // получение заметок

void add(Notes notes); //добавление


}
