package com.tilt.notebook;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
import java.util.*;

public class MainActivityListFragment extends ListFragment
{

    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        // TODO: Implement this method
        super.onActivityCreated(savedInstanceState);

//
//		String[] values = new String[]{"Target","Walmart","Treyarch","EA","EA sports",
//		"Square Enix","Naughty Dog",
//		"Bungie","RARE","Com2Us",
//		"Mojang","Rovio","Miniclip","Disney","Supercell","GameLoft"};
//
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, values);
//
//		setListAdapter(adapter);

        notes = new ArrayList<Note>();

        notes.add(new Note("This,", "this is a finance note that will be ellipsized and i cannot control" +
                " that", Note.Category.FINANCE));
        notes.add(new Note("This", "thi is a Personal note that will note allow me to swap what " +
                "is being held in it ", Note.Category.PERSONAL));
        notes.add(new Note("This", "this is a Technical note that has some random note" +
                " to it and it shows a t", Note.Category.TECHNICAL));
        notes.add(new Note("This is some of the best notes that i cannot modify and " +
                "will be a ", "", Note.Category.QUOTE));
        notes.add(new Note("This", "Quote Quote quote quote quote quote quote quote " +
                "quote quote quote quote quote quote", Note.Category.QUOTE));
        notes.add(new Note("This", "Finance finance finance finance finance finance finance Finance finance finance" +
                " finance finance finance finance", Note.Category.FINANCE));
        notes.add(new Note("This", "Technical technical technical technical technical technical technical" +
                "technical technical technical technical technical technical", Note.Category.TECHNICAL));
        notes.add(new Note("This", "Financial status sucks im poor like always and cannot do anything about it", Note.Category.FINANCE));
        notes.add(new Note("This", "Personal my personal life is terrible or at least only the money side because " +
                "thug life", Note.Category.PERSONAL));

        noteAdapter = new NoteAdapter(getActivity(), notes);
        setListAdapter(noteAdapter);

        //Sets the split bar for the list if the bar is note visible
        //getListView().setDivider(ContextCompat.getDrawable(getActivity(),android.R.color.black));
        //getListView().setDividerHeight(1);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);

        launchNoteDetailActivity(position);

    }

    private void launchNoteDetailActivity(int position){

        //grab the note information for whichever note is clicked on
        Note note = (Note) getListAdapter().getItem(position);

        //create a new intent that launches our NoteDetailActivity
        Intent intent = new Intent(getActivity(), NoteDetailActivity.class);

        //pass along the detail information for the note we click on to the NoteDetailActivity
        intent.putExtra(MainActivity.NOTE_TITLE_EXTRA, note.getTitle());
        intent.putExtra(MainActivity.NOTE_MESSAGE_EXTRA, note.getMessage());
        intent.putExtra(MainActivity.NOTE_CATEGORY_EXTRA,note.getCategory());
        intent.putExtra(MainActivity.NOTE_ID_EXTRA,note.getId());

        //start the activity (NoteDetailActivity)
        startActivity(intent);
    }
}