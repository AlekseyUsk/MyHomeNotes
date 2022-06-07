package domain;

import java.util.ArrayList;
import java.util.List;

public interface NotesRepository {

ArrayList<Notes> getAll(); // получение заметок

void add(Notes notes); //добавление


}
