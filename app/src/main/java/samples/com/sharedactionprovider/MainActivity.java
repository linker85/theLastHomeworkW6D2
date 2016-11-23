package samples.com.sharedactionprovider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        ShareActionProvider.OnShareTargetSelectedListener {

    private static final String TAG = "MainActivityTAG_";
    private ShareActionProvider share = null;
    private Intent shareIntent        = new Intent(Intent.ACTION_SEND);
    private SparseArray<String> sparceItems;
    private ArrayMap<String, String> arrayMapItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sparceItems = new SparseArray<String>();
        sparceItems.put(1, "TV ?");
        sparceItems.put(2, "Cablebox ?");
        sparceItems.put(3, "Tuner / Hifi ?");
        sparceItems.put(4, "BD Player ?");
        sparceItems.put(5, "? ?");
        for (int i = 0; i < sparceItems.size(); i++) {
            int key = sparceItems.keyAt(i);
            // get the object by the key.
            String value = (String) sparceItems.get(key);
            Log.d(TAG, "SparseItems: " + value);
        }

        arrayMapItems = new ArrayMap<>();
        arrayMapItems.put("1", "Dracula");
        arrayMapItems.put("2", "Alucard");
        arrayMapItems.put("3", "Werewolve");
        arrayMapItems.put("3", "Frankestein");
        for (int i = 0; i < arrayMapItems.size(); i++) {
            String key = arrayMapItems.keyAt(i);
            // get the object by the key.
            String value = (String) arrayMapItems.get(key);
            Log.d(TAG, "ArrayMapItems: " + value);
        }

        shareIntent.setType("text/plain");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem item = menu.findItem(R.id.share);

        share = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        share.setOnShareTargetSelectedListener(this);

        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onShareTargetSelected(ShareActionProvider source,
                                         Intent intent) {
        Toast.makeText(this, intent.getComponent().toString(),
                Toast.LENGTH_LONG).show();
        return(false);
    }

      public void toF1(View view) {
        shareIntent.putExtra(Intent.EXTRA_TEXT, "f1");
        share.setShareIntent(shareIntent);
        Fragment1 fragmentItem = new Fragment1();
        FragmentTransaction mft = getSupportFragmentManager().beginTransaction();
        mft.replace(R.id.frame_container, fragmentItem);
        mft.addToBackStack(null);
        mft.commit();
    }
    public void toF2(View view) {
        shareIntent.putExtra(Intent.EXTRA_TEXT, "f2");
        share.setShareIntent(shareIntent);
        Fragment2 fragmentItem = new Fragment2();
        FragmentTransaction mft = getSupportFragmentManager().beginTransaction();
        mft.replace(R.id.frame_container, fragmentItem);
        mft.addToBackStack(null);
        mft.commit();
    }
    public void toF3(View view) {
        shareIntent.putExtra(Intent.EXTRA_TEXT, "f3");
        share.setShareIntent(shareIntent);
        Fragment3 fragmentItem = new Fragment3();
        FragmentTransaction mft = getSupportFragmentManager().beginTransaction();
        mft.replace(R.id.frame_container, fragmentItem);
        mft.addToBackStack(null);
        mft.commit();
    }
}