package io.github.memfis19.annca.internal.configuration;

import android.app.Activity;
import android.support.annotation.IntDef;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by memfis on 7/6/16.
 */
public final class AnncaConfiguration {

    public static final int MEDIA_QUALITY_AUTO = 10;
    public static final int MEDIA_QUALITY_LOWEST = 15;
    public static final int MEDIA_QUALITY_LOW = 11;
    public static final int MEDIA_QUALITY_MEDIUM = 12;
    public static final int MEDIA_QUALITY_HIGH = 13;
    public static final int MEDIA_QUALITY_HIGHEST = 14;

    public static final int MEDIA_ACTION_VIDEO = 100;
    public static final int MEDIA_ACTION_PHOTO = 101;
    public static final int MEDIA_ACTION_UNSPECIFIED = 102;

    public static final int CAMERA_FACE_FRONT = 0x6;
    public static final int CAMERA_FACE_REAR = 0x7;

    public static final int SENSOR_POSITION_UP = 90;
    public static final int SENSOR_POSITION_UP_SIDE_DOWN = 270;
    public static final int SENSOR_POSITION_LEFT = 0;
    public static final int SENSOR_POSITION_RIGHT = 180;
    public static final int SENSOR_POSITION_UNSPECIFIED = -1;

    public static final int DISPLAY_ROTATION_0 = 0;
    public static final int DISPLAY_ROTATION_90 = 90;
    public static final int DISPLAY_ROTATION_180 = 180;
    public static final int DISPLAY_ROTATION_270 = 270;

    public static final int ORIENTATION_PORTRAIT = 0x111;
    public static final int ORIENTATION_LANDSCAPE = 0x222;


    public interface Arguments {
        String REQUEST_CODE = "io.memfis19.annca.request_code";
        String MEDIA_ACTION = "io.memfis19.annca.media_action";
        String MEDIA_QUALITY = "io.memfis19.annca.camera_media_quality";
        String VIDEO_DURATION = "io.memfis19.annca.video_duration";
        String VIDEO_FILE_SIZE = "io.memfis19.annca.camera_video_file_size";
        String FILE_PATH = "io.memfis19.annca.camera_video_file_path";
    }

    @IntDef({MEDIA_QUALITY_AUTO, MEDIA_QUALITY_LOWEST, MEDIA_QUALITY_LOW, MEDIA_QUALITY_MEDIUM, MEDIA_QUALITY_HIGH, MEDIA_QUALITY_HIGHEST})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaQuality {
    }

    @IntDef({MEDIA_ACTION_VIDEO, MEDIA_ACTION_PHOTO, MEDIA_ACTION_UNSPECIFIED})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaAction {
    }

    @IntDef({CAMERA_FACE_FRONT, CAMERA_FACE_REAR})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CameraFace {
    }

    @IntDef({SENSOR_POSITION_UP, SENSOR_POSITION_UP_SIDE_DOWN, SENSOR_POSITION_LEFT, SENSOR_POSITION_RIGHT, SENSOR_POSITION_UNSPECIFIED})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SensorPosition {
    }

    @IntDef({DISPLAY_ROTATION_0, DISPLAY_ROTATION_90, DISPLAY_ROTATION_180, DISPLAY_ROTATION_270})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayRotation {
    }

    @IntDef({ORIENTATION_PORTRAIT, ORIENTATION_LANDSCAPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceDefaultOrientation {
    }

    private Activity activity = null;

    private int requestCode = -1;

    @MediaAction
    private int mediaAction = -1;

    @MediaQuality
    private int mediaQuality = -1;

    @CameraFace
    private int cameraFace = -1;

    private int videoDuration = -1;

    private long videoFileSize = -1;


    private AnncaConfiguration(Activity activity, int requestCode) {
        this.activity = activity;
        this.requestCode = requestCode;
    }

    public static class Builder {

        private AnncaConfiguration anncaConfiguration;


        public Builder(@NonNull Activity activity, @IntRange(from = 0) int requestCode) {
            anncaConfiguration = new AnncaConfiguration(activity, requestCode);
        }

        public Builder setMediaAction(@MediaAction int mediaAction) {
            anncaConfiguration.mediaAction = mediaAction;
            return this;
        }

        public Builder setMediaQuality(@MediaQuality int mediaQuality) {
            anncaConfiguration.mediaQuality = mediaQuality;
            return this;
        }

        /***
         * @param videoDurationInMilliseconds - video duration in milliseconds
         * @return
         */
        public Builder setVideoDuration(@IntRange(from = 1000, to = Integer.MAX_VALUE) int videoDurationInMilliseconds) {
            anncaConfiguration.videoDuration = videoDurationInMilliseconds;
            return this;
        }

        /***
         * @param videoSizeInBytes - file size in bytes
         * @return
         */
        public Builder setVideoFileSize(@IntRange(from = 1048576, to = Long.MAX_VALUE) long videoSizeInBytes) {
            anncaConfiguration.videoFileSize = videoSizeInBytes;
            return this;
        }

        public AnncaConfiguration build() throws IllegalArgumentException {
            if (anncaConfiguration.requestCode < 0)
                throw new IllegalArgumentException("Wrong request code value. Please set the value > 0.");

            return anncaConfiguration;
        }

    }

    public Activity getActivity() {
        return activity;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public int getMediaAction() {
        return mediaAction;
    }

    public int getMediaQuality() {
        return mediaQuality;
    }

    public int getCameraFace() {
        return cameraFace;
    }

    public int getVideoDuration() {
        return videoDuration;
    }

    public long getVideoFileSize() {
        return videoFileSize;
    }
}