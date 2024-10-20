Car Dent Detection App
A mobile application designed to detect and classify car dents using machine learning models. The app allows users to upload images of car dents and predicts the severity of the damage, ranging from minor to severe. Additionally, it suggests an insurance amount based on the classification of the dent.

Features

User Authentication: Sign-up and log-in functionality using Firebase Authentication.
Image Upload: Upload images of car dents from the device's gallery.
Dent Classification: The app detects and classifies the uploaded car dent image into three categories: Minor, Moderate, or Severe.
Insurance Recommendation: Based on the dent severity, the app provides an estimated insurance amount.
Real-time Firebase Integration: All user authentication and data storage are powered by Firebase.

Technologies Used

Android: The app is built using Android Studio.
Firebase:
Authentication: Used for user sign-up and sign-in.
Storage: Used to upload and store images.
Real-time Database: For storing and retrieving dent severity classification and insurance recommendations.
Machine Learning Model:
Java: Core language for Android app development.
XML: Used for the design and layout of the app’s user interface.

Figma designs
Sign In Screen	Image Upload Screen	Dent Classification Screen
Installation
Prerequisites
Android Studio
Java JDK 8 or later
Firebase Account
Steps to Run Locally
Clone the repository:
bash
Copy code
git clone https://github.com/yourusername/car-dent-detection.git
Open the project in Android Studio.
Connect Firebase:
Go to Firebase Console.
Create a project and add an Android app with the correct package name (e.g., com.example.car_dent_detection).
Download the google-services.json file and place it in the app/ directory.
Enable Firebase Authentication and Storage.
Sync Gradle: Ensure that the Firebase dependencies are correctly synced in the build.gradle files.
Run the app: Connect an Android device or use an emulator and press the Run button in Android Studio.
Firebase Setup
Authentication:

Go to the Firebase console, and under the "Authentication" tab, enable email/password authentication.
Storage:

In the Firebase console, go to "Storage" and set up cloud storage rules for uploading and downloading images.
Database:

Set up a real-time database for storing user-related data, such as classification results and insurance recommendations.
Machine Learning Model
The app uses the Florence 2 model for dent classification. The model is trained to classify car dents into three categories:

Minor
Moderate
Severe
For further improvements, the model can be retrained with a larger dataset of car dent images to enhance classification accuracy.

Contributing
Contributions are welcome! Please open an issue or create a pull request if you'd like to contribute.

Steps to Contribute
Fork the repository.
Create a new feature branch:
bash
Copy code
git checkout -b feature-branch
Commit your changes:
bash
Copy code
git commit -m "Add some feature"
Push to the branch:
bash
Copy code
git push origin feature-branch
Create a pull request.
