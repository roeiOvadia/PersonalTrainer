package com.example.personaltrainer;

import android.graphics.Bitmap;

public class Exercise {

        private int reps;

        private String name;

        private String description;

        private Bitmap bitmap;

        public Exercise(int reps, String name, String description, Bitmap bitmap)

        {



            this.reps = reps;

            this.name = name;

            this.description = description;

            this.bitmap = bitmap;

        }



        public int getReps() {

            return reps;

        }

        public void setPrice(int reps) {

            this.reps = reps;

        }

        public String getName() {

            return name;

        }

        public void setName(String name) {

            this.name = name;

        }

        public String getDescription() {

            return description;

        }

        public void setDescription(String description) {

            this.description = description;

        }



        public Bitmap getBitmap() {

            return bitmap;

        }



        public void setBitmap(Bitmap bitmap) {

            this.bitmap = bitmap;

        }

}