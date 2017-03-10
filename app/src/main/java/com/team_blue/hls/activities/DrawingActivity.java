package com.team_blue.hls.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.team_blue.hls.R;
import com.team_blue.hls.custom_views.PaintView;

public class DrawingActivity extends AppCompatActivity {

    PaintView paintView;
    LinearLayout FirstListOfColors, SecondListOfColors, ListOfTools;
    ImageButton currentCollor;
    AlertDialog alertDialog;
    final static public int SMALL_BRUSH = 10, MEDIUM_BRUSH = 30, BIG_BRUSH = 50;
    final static public int SMALL_ERASER = 30, MEDIUM_ERASER = 60, BIG_ERASER = 90;


    View.OnClickListener OnColorItemClickListtener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String color = view.getTag().toString();
            paintView.setColor(color);
            currentCollor.setImageDrawable(getResources().getDrawable(R.drawable.paint));
            currentCollor = (ImageButton) view;
            currentCollor.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
        }
    };



    View.OnClickListener OnToolsItemClickListenner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.brush_button:
                    final Dialog brushDialog = new Dialog(DrawingActivity.this);

                    View.OnClickListener OnBrushSizeItemClickListenner = new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            switch (view.getId()) {
                                case R.id.small_brush:
                                    paintView.setBrushSize(SMALL_BRUSH);
                                    brushDialog.dismiss();
                                    break;
                                case R.id.medium_brush:
                                    paintView.setBrushSize(MEDIUM_BRUSH);
                                    brushDialog.dismiss();
                                    break;
                                case R.id.big_brush:
                                    paintView.setBrushSize(BIG_BRUSH);
                                    brushDialog.dismiss();
                                    break;
                            }
                        }
                    };
                    brushDialog.setTitle("Choose Size Of Brush");
                    brushDialog.setContentView(R.layout.brush_dialog);
                    ImageButton small_brush = (ImageButton) brushDialog.findViewById(R.id.small_brush);
                    ImageButton medium_brush = (ImageButton) brushDialog.findViewById(R.id.medium_brush);
                    ImageButton big_brush = (ImageButton) brushDialog.findViewById(R.id.big_brush);
                    small_brush.setOnClickListener(OnBrushSizeItemClickListenner);
                    medium_brush.setOnClickListener(OnBrushSizeItemClickListenner);
                    big_brush.setOnClickListener(OnBrushSizeItemClickListenner);
                    brushDialog.show();
                    break;
                case R.id.eraser_button:
                    final Dialog brushDialog2 = new Dialog(DrawingActivity.this);
                    View.OnClickListener OnEraserSizeItemClickListenner = new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            switch (view.getId()) {
                                case R.id.small_brush:
                                    paintView.setErased(SMALL_ERASER);
                                    brushDialog2.dismiss();
                                    break;
                                case R.id.medium_brush:
                                    paintView.setErased(MEDIUM_ERASER);
                                    brushDialog2.dismiss();
                                    break;
                                case R.id.big_brush:
                                    paintView.setErased(BIG_ERASER);
                                    brushDialog2.dismiss();
                                    break;
                            }
                        }
                    };
                    brushDialog2.setTitle("Choose Size Of Erase");
                    brushDialog2.setContentView(R.layout.brush_dialog);
                    ImageButton small_eraser = (ImageButton) brushDialog2.findViewById(R.id.small_brush);
                    ImageButton medium_eraser = (ImageButton) brushDialog2.findViewById(R.id.medium_brush);
                    ImageButton big_eraser = (ImageButton) brushDialog2.findViewById(R.id.big_brush);
                    small_eraser.setOnClickListener(OnEraserSizeItemClickListenner);
                    medium_eraser.setOnClickListener(OnEraserSizeItemClickListenner);
                    big_eraser.setOnClickListener(OnEraserSizeItemClickListenner);
                    brushDialog2.show();
                    break;
                case R.id.create_button:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DrawingActivity.this);
                    builder.setTitle("Create new page for paint?").setCancelable(true).setNegativeButton("Create", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            paintView.newPage();
                        }
                    }).setPositiveButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    alertDialog = builder.create();
                    alertDialog.show();
                    break;
                case R.id.save_button:
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DrawingActivity.this);
                    paintView.setDrawingCacheEnabled(true);
                    builder2.setTitle("Save drawing");
                    builder2.setMessage("Save drawing to device Gallery?");
//                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//
//                            if (ContextCompat.checkSelfPermission(MainActivity.this,
//                                    Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                                    != PackageManager.PERMISSION_GRANTED) {
//
//                                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
//                                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//
//
//
//                                }
//
//
//                                ActivityCompat.requestPermissions(MainActivity.this,
//                                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
//
//
//
//                            }else {
//                                imgSaved = MediaStore.Images.Media.insertImage(
//                                        getContentResolver(), paintView.getDrawingCache(),
//                                        UUID.randomUUID().toString(), "drawing");
//                                if(imgSaved!=null){
//                                    Toast savedToast = Toast.makeText(getApplicationContext(),
//                                            "Drawing saved to Gallery!", Toast.LENGTH_SHORT);
//                                    savedToast.show();
//                                }
//                                else{
//                                    Toast unsavedToast = Toast.makeText(getApplicationContext(),
//                                            "Oops! Image could not be saved,try again.", Toast.LENGTH_SHORT);
//                                    unsavedToast.show();}
//                            }
//                            paintView.destroyDrawingCache();
//                            paintView.setDrawingCacheEnabled(false);
//
//                        }
//                    });
//                    saveDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
//                        public void onClick(DialogInterface dialog, int which){
//                            dialog.cancel();
//                        }
//                    });
                    alertDialog = builder2.create();
                    alertDialog.show();

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        paintView = (PaintView) findViewById(R.id.paintView);
        FirstListOfColors = (LinearLayout) findViewById(R.id.list_of_colors_1);
        SecondListOfColors = (LinearLayout) findViewById(R.id.list_of_colors_2);
        ListOfTools = (LinearLayout) findViewById(R.id.list_of_res);
        currentCollor = (ImageButton) FirstListOfColors.getChildAt(0);
        currentCollor.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));

        setItemsOnClickListenners();


    }

    private void setItemsOnClickListenners() {
        for (int i = 0; i < 6; i++) {
            FirstListOfColors.getChildAt(i).setOnClickListener(OnColorItemClickListtener);
        }
        for (int i = 0; i < 6; i++) {
            SecondListOfColors.getChildAt(i).setOnClickListener(OnColorItemClickListtener);
        }
        for (int i = 0; i < 4; i++) {
            ListOfTools.getChildAt(i).setOnClickListener(OnToolsItemClickListenner);
        }
    }
}

