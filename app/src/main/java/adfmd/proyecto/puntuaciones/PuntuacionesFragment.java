package adfmd.proyecto.puntuaciones;


import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import adfmd.proyecto.R;
import adfmd.proyecto.data.AmigoDbHelper;

public class PuntuacionesFragment extends Fragment {
    private AmigoDbHelper mAmigoDbHelper;
    private ListView mAmigosList;
    private PuntuacionesCursorAdapter mAmigosAdapter;
    private FloatingActionButton mAddButton;

    public PuntuacionesFragment() {

    }

    public static PuntuacionesFragment newInstance() {
        return new PuntuacionesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_puntuaciones, container, false);

        // Referencias UI
        mAmigosList = (ListView) root.findViewById(R.id.amigos_list);
        mAmigosAdapter = new PuntuacionesCursorAdapter(getActivity(), null);
        mAddButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        // Setup
        mAmigosList.setAdapter(mAmigosAdapter);

        // Instancia de helper
        mAmigoDbHelper = new AmigoDbHelper(getActivity());

        // Carga de datos
        loadLawyers();

        return root;
    }
    private void loadLawyers() {
        new AmigosLoadTask().execute();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    private class AmigosLoadTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mAmigoDbHelper.getAllAmigos();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                mAmigosAdapter.swapCursor(cursor);
            } else {
                // Mostrar empty state
            }
        }
    }

}
