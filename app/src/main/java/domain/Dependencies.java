package domain;
//  Синглтон
public class Dependencies {

    public static final NotesRepository NOTES_REPOSITORY = new InMemoryNotesRepository();
}
