package com.example.locdaika.adidi.CustomCamera;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.locdaika.adidi.Fragment_Service.Frag_Service_ImageCam;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Camera_model;


public class CustomCam_Activity extends AppCompatActivity {
    private boolean isFlashOn = false;
    FrameLayout frameCamera;
    Camera camera;
    ShowCamera showCamera;
    ImageView ImgCap, ImgFlat;
    RelativeLayout layoutCap, layoutFlat;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    RelativeLayout ryFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutomcamera);
        init();
        Eventhandle();
    }

    private void init() {
        ryFrag = findViewById(R.id.activity_custom_camera);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
            }
        }
        camera = switch_onCamera();
        ImgFlat = findViewById(R.id.imgFlat);
        layoutCap = findViewById(R.id.layoutCap);
        layoutFlat = findViewById(R.id.layoutFlat);
        ImgCap = findViewById(R.id.CapImg);
        showCamera = new ShowCamera(this, camera);
        frameCamera = findViewById(R.id.frameCamera);
        frameCamera.addView(showCamera);
        setFocus();
        startFaceDetection();
    }

    private void Eventhandle() {
        verifyStoragePermissions(CustomCam_Activity.this);
        layoutCap.setBackgroundColor(getColorWithAlpha(R.color.black, 1.2f));
        layoutFlat.setBackgroundColor(getColorWithAlpha(R.color.black, 1.2f));
        EventFlat();
        ImgCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    camera.takePicture(myShutterCallback, null, pictureCallback);
                } catch (Exception e) {
                    Log.d("Error", e.toString());
                }
            }
        });
    }

    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    Camera.ShutterCallback myShutterCallback = new Camera.ShutterCallback() {
        @Override
        public void onShutter() {
        }
    };

    public Camera switch_onCamera() {
        Camera camob = null;
        camob = Camera.open();
        Camera.Parameters parameters = camob.getParameters();
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
        camob.setParameters(parameters);
//        if (isFlashOn) {
//            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//        }
        if (this.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
            parameters.set("orientation", "portrait");
            camob.setDisplayOrientation(90);
            parameters.setRotation(90);
        } else {
            parameters.set("orientation", "landscape");
            camob.setDisplayOrientation(0);
            parameters.setRotation(0);
        }
        return camob;
    }

    private Camera.PictureCallback pictureCallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            if (data != null) {
                Bundle bundle = new Bundle();
                Bitmap bm = BitmapFactory.decodeByteArray(data, 0, (data) != null ? data.length : 0);
                Camera_model model = new Camera_model(bm);
                bundle.putSerializable("data", model);
                Frag_Service_ImageCam fragInfo = new Frag_Service_ImageCam();
                fragInfo.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.mylayout, fragInfo).commit();

            }
//            File file = new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS) + "/" + System.currentTimeMillis() + ".jpg");
//            if (file == null) {
//                Log.d("tag", "Error creating media file, check storage permissions: ");
//                return;
//            }
//            Bitmap bm = BitmapFactory.decodeByteArray(data, 0, (data) != null ? data.length : 0);
//            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//                Matrix matrix = new Matrix();
//                matrix.setRotate(90);
//                bm = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, false);
//                EventBus.getDefault().post(bm);
//                getSupportFragmentManager().beginTransaction().replace(R.id.mylayout, new Frag_Service_ImageCam()).commit();
//            }
//            try {
//                FileOutputStream fileOutputStream = new FileOutputStream(file);
//                bm.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
//                fileOutputStream.flush();
//                fileOutputStream.close();
//            } catch (FileNotFoundException e) {
//                Log.d("tag", e.toString());
//                e.printStackTrace();
//        } catch(IOException e)
//        {
//            e.printStackTrace();
//        }
            camera.startPreview();
        }
    };

    public static int getColorWithAlpha(int color, float ratio) {
        int newColor = 0;
        int alpha = Math.round(Color.alpha(color) * ratio);
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        newColor = Color.argb(alpha, r, g, b);
        return newColor;
    }


    public void EventFlat() {
        ImgFlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFlashOn == true) {
                    isFlashOn = false;
                    ImgFlat.setImageDrawable(getResources().getDrawable(R.drawable.flash_off));
                } else {
                    isFlashOn = true;
                    ImgFlat.setImageDrawable(getResources().getDrawable(R.drawable.flash_on));
                }
            }
        });
    }

    public void setFocus() {
        Camera.Parameters params = camera.getParameters();
        if (params.getSupportedFocusModes().contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)) {
            params.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        } else {
            params.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
        }
        camera.setParameters(params);
    }

    public void startFaceDetection() {
        // Try starting Face Detection
        Camera.Parameters params = camera.getParameters();

        // start face detection only *after* preview has started
        if (params.getMaxNumDetectedFaces() > 0) {
            // camera supports face detection, so can start it:
            camera.startFaceDetection();
        }
    }
}
