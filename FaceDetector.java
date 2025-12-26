/*
 * IMPORTANT - HOW TO RUN THIS FILE:
 * This is a complete Java application for face detection.
 * To run it, you need:
 * 1. A Java Development Kit (JDK) 8 or newer.
 * 2. The JavaCV (OpenCV) libraries. The easiest way to get them is with Maven.
 * Add this to your pom.xml:
 * <dependency>
 * <groupId>org.bytedeco</groupId>
 * <artifactId>javacv-platform</artifactId>
 * <version>1.5.10</version>
 * </dependency>
 * 3. The Haar Cascade XML file for face detection. This code assumes
 * 'haarcascade_frontalface_alt.xml' is in the same directory.
 * You can download it from the OpenCV GitHub repository.
 */

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;

import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import org.bytedeco.javacpp.Loader;

public class FaceDetector {

    public static void main(String[] args) throws Exception {
        
        // --- 1. SETUP ---

        // Load the OpenCV Cascade Classifier for face detection
        // This file must be in your project's path.
        // We'll try to load it from the resources or download it if not found.
        File cascadeFile = loadCascadeFile();
        if (cascadeFile == null || !cascadeFile.exists()) {
            System.err.println("Error: Could not load Haar cascade file.");
            return;
        }
        CascadeClassifier faceCascade = new CascadeClassifier(cascadeFile.getAbsolutePath());

        // Converters to move between OpenCV's Mat and Java's BufferedImage
        OpenCVFrameConverter.ToIplImage converterToIpl = new OpenCVFrameConverter.ToIplImage();
        Java2DFrameConverter converterToBufferedImage = new Java2DFrameConverter();

        // --- 2. INITIALIZE WEBCAM ---
        // Start the webcam. 0 is the default camera.
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        try {
            grabber.start();
        } catch (Exception e) {
            System.err.println("Failed to start webcam. Is it connected and drivers installed?");
            e.printStackTrace();
            return;
        }

        // --- 3. CREATE THE UI (Similar to Java Swing) ---
        // Create a CanvasFrame (a simple JFrame) to display the video feed.
        // This is part of the JavaCV library.
        CanvasFrame canvas = new CanvasFrame("Real-time Face Detection (Java)");
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // --- 4. DETECTION LOOP ---
        // This loop will run as long as the window is open.
        while (canvas.isVisible()) {
            // Grab a frame from the webcam
            Frame frame = grabber.grab();
            if (frame == null) {
                System.out.println("No frame grabbed. Exiting.");
                break;
            }

            // Convert the JavaCV frame to an OpenCV Mat (Matrix)
            Mat colorImage = converterToIpl.convertToMat(frame);
            
            // Convert the image to grayscale (face detection works better on grayscale)
            Mat grayImage = new Mat();
            opencv_imgproc.cvtColor(colorImage, grayImage, opencv_imgproc.COLOR_BGR2GRAY);
            
            // Equalize histogram to improve contrast
            opencv_imgproc.equalizeHist(grayImage, grayImage);

            // --- This is the core detection step ---
            // 'faceCascade.detectMultiScale' finds the faces in the grayscale image.
            RectVector faces = new RectVector();
            faceCascade.detectMultiScale(grayImage, faces,
                1.1, // Scale Factor: How much the image size is reduced at each step
                3,   // Min Neighbors: How many "neighbors" each candidate rectangle should have
                0,   // Flags: (Not used here)
                new Size(40, 40), // Min Size: Don't find faces smaller than this
                new Size()        // Max Size: (No limit)
            );
            // ----------------------------------------

            // --- 5. DRAW ON IMAGE ---
            // Loop through all detected faces and draw a rectangle
            for (int i = 0; i < faces.size(); i++) {
                Rect face = faces.get(i);
                
                // Draw a green rectangle around the face
                // Scalar(Blue, Green, Red, Alpha)
                opencv_imgproc.rectangle(colorImage, face, new Scalar(0, 255, 0, 1), 2, 0, 0);
            }

            // --- 6. DISPLAY THE FRAME ---
            // Convert the Mat (with rectangles) back to a Frame
            Frame processedFrame = converterToIpl.convert(colorImage);
            
            // Show the processed frame in the window
            canvas.showImage(processedFrame);
        }

        // --- 7. CLEANUP ---
        // Stop the webcam grabber and close the window
        grabber.stop();
        grabber.release();
        canvas.dispose();
        System.out.println("System exited.");
    }

    /**
     * Helper function to find or download the cascade file.
     */
    private static File loadCascadeFile() {
        try {
            // Try to find the file in the classpath
            URL url = new URL("httpss://raw.githubusercontent.com/opencv/opencv/master/data/haarcascades/haarcascade_frontalface_alt.xml");
            File file = Loader.cacheResource(url);
            if (file != null && file.exists()) {
                System.out.println("Loaded cascade file from: " + file.getAbsolutePath());
                return file;
            }
        } catch (Exception e) {
            System.err.println("Could not download cascade file: " + e.getMessage());
            System.err.println("Please download 'haarcascade_frontalface_alt.xml' manually and place it in your project's root folder.");
        }
        
        // Fallback: check current directory
        File localFile = new File("haarcascade_frontalface_alt.xml");
        if(localFile.exists()) {
            System.out.println("Loaded cascade file from local directory.");
            return localFile;
        }

        return null;
    }
}