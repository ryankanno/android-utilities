package com.localkinegrinds.utilities.media;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundManager {

    private final AudioManager audioManager;
    private SoundPool soundPool;
    private Context context;

    public SoundManager(Context context, int numStreams) {
        this.audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        this.soundPool = new SoundPool(numStreams, AudioManager.STREAM_MUSIC, 0);
        this.context = context;
    }

    public float getVolume()
    {
        final float actualVolume = (float)audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        final float maxVolume = (float)audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        return actualVolume / maxVolume;
    }

    public void dispose()
    {
        this.soundPool.release();
        this.soundPool = null;
    }
}
