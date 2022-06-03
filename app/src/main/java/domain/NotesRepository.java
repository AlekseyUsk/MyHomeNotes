package domain;

import java.util.List;

public interface NotesRepository {

List<Notes> getAll(); // получение заметок

void add(Notes notes); //добавление


}
