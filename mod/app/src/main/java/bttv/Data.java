package bttv;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bttv.emote.ChannelEmoteData;
import bttv.emote.Emote;
import bttv.emote.Emotes;
import bttv.settings.UserPreferences;
import bttv.updater.UpdaterJobService;
import tv.twitch.android.models.channel.ChannelModel;

public class Data {
    public static int currentBroadcasterId = -1;
    public static Context ctx;


    public static String getBttvVersion(Context context) {
        if (context == null) {
            if (ctx != null) {
                context = ctx;
                Log.w("LBTTVData", "getBttvVersion: had to call back to ctx as context was null", new Exception());
            } else {
                Log.e("LBTTVData", "getVersion called, but context is null", new Exception());
                return null;
            }
        }
        String vN = null;
        try {
            vN = "v" + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return vN;
    }

    public static void setCurrentBroadcasterId(int id) {
        Log.i("LBTTVSetBroadcasterId", currentBroadcasterId + " -> " + id);
        Data.currentBroadcasterId = id;
        Emotes.ensureChannelEmotes(ctx, id);
    }

    public static void setCurrentBroadcasterId(ChannelModel channel) {
        setCurrentBroadcasterId(channel.component1());
    }

    public static void setContext(Context ctx) {
        Data.ctx = ctx;
        Log.i("LBTTVDataSetContext", "context now is " + ((Data.ctx == null) ? "null" : "not null"));
        UpdaterJobService.schedule(ctx);
    }
}
