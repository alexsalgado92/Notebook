package com.tilt.notebook;

/**
 * Created by student on 6/13/2016.
 */
import android.widget.*;
import android.content.*;
import java.util.*;
import android.view.*;

public class NoteAdapter extends ArrayAdapter<Note>
{
    public static class ViewHolder{
        TextView title;
        TextView note;
        ImageView noteIcon;
    }

    public NoteAdapter(Context context, ArrayList<Note> notes){
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // get the data item for the position
        Note note = getItem(position);

        //create new viewholder
        ViewHolder viewHolder;

        //Check if an existing view is being reused, otherwise inflate a new view from custom row layout
        if (convertView == null){

            //if we don't have a view that is bieng used, create one,and make sure to create a viewholder to
            //Store the data reference to.
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);

            viewHolder.title = (TextView) convertView.findViewById(R.id.listItemNoteTitle);
            viewHolder.note = (TextView) convertView.findViewById(R.id.listItemNoteBody);
            viewHolder.noteIcon = (ImageView) convertView.findViewById(R.id.listItemNoteImg);

            //use settag to remember our view holder which is holder our reference to our widget
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Populate the data into the template view using the data object
        viewHolder.title.setText(note.getTitle());
        viewHolder.note.setText(note.getMessage());
        viewHolder.noteIcon.setImageResource(note.getAssociatedDrawable());

        //now that the view is modified return the view
        return convertView;
    }

}
