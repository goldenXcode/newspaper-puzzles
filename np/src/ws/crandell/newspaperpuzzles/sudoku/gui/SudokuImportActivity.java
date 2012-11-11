package ws.crandell.newspaperpuzzles.sudoku.gui;

import ws.crandell.newspaperpuzzles.sudoku.gui.importing.AbstractImportTask;
import ws.crandell.newspaperpuzzles.sudoku.gui.importing.ExtrasImportTask;
import ws.crandell.newspaperpuzzles.sudoku.gui.importing.SudokuImportTask;
import ws.crandell.newspaperpuzzles.sudoku.gui.importing.SdmImportTask;
import ws.crandell.newspaperpuzzles.sudoku.gui.importing.AbstractImportTask.OnImportFinishedListener;
import ws.crandell.newspaperpuzzles.sudoku.utils.Const;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ProgressBar;
import ws.crandell.newspaperpuzzles.R;

/**
 * This activity is responsible for importing puzzles from various sources
 * (web, file, .sudoku, .sdm, extras).
 *
 * @author romario
 */
public class SudokuImportActivity extends Activity {
	/**
	 * Name of folder to which games should be imported.
	 */
	public static final String EXTRA_FOLDER_NAME = "FOLDER_NAME";
	/**
	 * Indicates whether games should be appended to the existing folder if such
	 * folder exists.
	 */
	public static final String EXTRA_APPEND_TO_FOLDER = "APPEND_TO_FOLDER";
	/**
	 * Games (puzzles) to import. String should be in this format:
	 * 120001232...0041\n 456000213...1100\n
	 */
	public static final String EXTRA_GAMES = "GAMES";

	private static final String TAG = "ImportSudokuActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_LEFT_ICON);
		setContentView(R.layout.s_import_sudoku);
		getWindow().setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,
				R.drawable.s_opensudoku_logo_72);

		ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);

		AbstractImportTask importTask;
		Intent intent = getIntent();
		Uri dataUri = intent.getData();
		if (dataUri != null) {
			if (Const.MIME_TYPE_SUDOKU.equals(intent.getType())
					|| dataUri.toString().endsWith(".sudoku")) {

				importTask = new SudokuImportTask(dataUri);

			} else if (dataUri.toString().endsWith(".sdm")) {

				importTask = new SdmImportTask(dataUri);

			} else {

				Log.e(
						TAG,
						String.format(
								"Unknown type of data provided (mime-type=%s; uri=%s), exiting.",
								intent.getType(), dataUri));
				finish();
				return;

			}
		} else if (intent.getStringExtra(EXTRA_FOLDER_NAME) != null) {

			String folderName = intent.getStringExtra(EXTRA_FOLDER_NAME);
			String games = intent.getStringExtra(EXTRA_GAMES);
			boolean appendToFolder = intent.getBooleanExtra(
					EXTRA_APPEND_TO_FOLDER, false);
			importTask = new ExtrasImportTask(folderName, games, appendToFolder);

		} else {
			Log.e(TAG, "No data provided, exiting.");
			finish();
			return;
		}

		importTask.initialize(this, progressBar);
		importTask.setOnImportFinishedListener(mOnImportFinishedListener);

		importTask.execute();
	}

	private OnImportFinishedListener mOnImportFinishedListener = new OnImportFinishedListener() {

		@Override
		public void onImportFinished(boolean importSuccessful, long folderId) {
			if (importSuccessful) {
				if (folderId == -1) {
					// multiple folders were imported, go to folder list
					Intent i = new Intent(SudokuImportActivity.this,
							FolderListActivity.class);
					startActivity(i);
				} else {
					// one folder was imported, go to this folder
					Intent i = new Intent(SudokuImportActivity.this,
							SudokuListActivity.class);
					i.putExtra(SudokuListActivity.EXTRA_FOLDER_ID, folderId);
					startActivity(i);
				}
			}
			// call finish, so this activity won't be part of history
			finish();
		}
	};

}
