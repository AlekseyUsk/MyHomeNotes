package noteRecyclerViewList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.myhomenotes.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import domain.Notes;

public class Adapter extends RecyclerView.Adapter<Adapter.NoteViewHolder> {


    private onNoteClicked onNoteClicked;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM, HH:mm", Locale.getDefault());

    private ArrayList<Notes> data = new ArrayList<>();//передал коллекцию заметок ( источник данных - в метод getItemCount возвр источник скока заметок)

    public void setData(Collection<Notes> notes) { //добавление заметок
        data.addAll(notes);
    }

    public void setOnNoteClicked(Adapter.onNoteClicked onNoteClicked) {
        this.onNoteClicked = onNoteClicked;
    }

    public Adapter.onNoteClicked getOnNoteClicked() {
        return onNoteClicked;
    }

    // завел интерфейс с методом обработки нажатия на заметку
    interface onNoteClicked{
        void onNoteClicked(Notes notes);
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // создает слепок этих заметок который будет переиспользоваться
        //сюда передаем View как делал в классе Notes_List только отличается
        // ( такой там был - View itemView = getLayoutInflater().inflate(R.layout.item_notes, container, false); и вставляем ее в holder
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes, parent, false);

        NoteViewHolder holder = new NoteViewHolder(itemView);

        return holder;
    }

    // служит для заполнения элементов каждого по позициям
    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Notes notes = data.get(position);

        holder.title.setText(notes.getTitle());
        holder.message.setText(notes.getMessage());

        holder.date.setText(simpleDateFormat.format(notes.getCreatedAt()));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    // класс ViewHolder своего рода отпечаток view которую надо перезапсывать(имеет констр по умолч)
    class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView message;
        TextView date;


        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_note);
            message = itemView.findViewById(R.id.message_note);
            date = itemView.findViewById(R.id.date_note);

            itemView.findViewById(R.id.card_view).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //если произошло нажатие и нам есть кому сообщить(заметка есть)
                    if(onNoteClicked != null){
                        int ClickedPosition = getAdapterPosition();//спрашиваю на какой позиции ты находишься?
                        onNoteClicked.onNoteClicked(data.get(ClickedPosition));//возвращаем на позицию заметку

                    }
                }
            });


        }


    }


}
// три метода обязательных (могут быть и больше методов)
