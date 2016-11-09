# Annca
Android solution to simplify work with different camera apis. Include video and photo capturing.

## Example of using
```
 AnncaConfiguration.Builder builder = new AnncaConfiguration.Builder(activity, CAPTURE_MEDIA);
 new Annca(builder.build()).launchCamera();
```
and thats it. You can use more extended settings i.e.
```
 AnncaConfiguration.Builder videoLimited = new AnncaConfiguration.Builder(activity, CAPTURE_MEDIA);
 videoLimited.setMediaAction(AnncaConfiguration.MEDIA_ACTION_VIDEO);
 videoLimited.setMediaQuality(AnncaConfiguration.MEDIA_QUALITY_AUTO);
 videoLimited.setVideoFileSize(5 * 1024 * 1024);
 new Annca(videoLimited.build()).launchCamera();
```
in this example you request video capturing with file size limited to 5Mb and auto quality to record video which meet this requirements.

## How to add to your project?
For current moment repository not linked to jcenter (will be fixed in short time), so you need to add link to specific repo:
```
repositories {
    maven {
        url  'https://dl.bintray.com/m-e-m-f-i-s/io.github.memfis19/'
    }
}
```
After just include dependency:
```
compile 'io.github.memfis19:annca:0.1.0'
```